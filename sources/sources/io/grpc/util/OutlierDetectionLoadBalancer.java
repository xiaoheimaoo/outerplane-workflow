package io.grpc.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ClientStreamTracer;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ServiceConfigUtil;
import io.grpc.internal.TimeProvider;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public final class OutlierDetectionLoadBalancer extends LoadBalancer {
    private static final Attributes.Key<AddressTracker> ADDRESS_TRACKER_ATTR_KEY = Attributes.Key.create("addressTrackerKey");
    private final LoadBalancer.Helper childHelper;
    private SynchronizationContext.ScheduledHandle detectionTimerHandle;
    private Long detectionTimerStartNanos;
    private final ChannelLogger logger;
    private final GracefulSwitchLoadBalancer switchLb;
    private final SynchronizationContext syncContext;
    private TimeProvider timeProvider;
    private final ScheduledExecutorService timeService;
    final AddressTrackerMap trackerMap;

    public OutlierDetectionLoadBalancer(LoadBalancer.Helper helper, TimeProvider timeProvider) {
        ChannelLogger channelLogger = helper.getChannelLogger();
        this.logger = channelLogger;
        ChildHelper childHelper = new ChildHelper((LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper"));
        this.childHelper = childHelper;
        this.switchLb = new GracefulSwitchLoadBalancer(childHelper);
        this.trackerMap = new AddressTrackerMap();
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(helper.getSynchronizationContext(), "syncContext");
        this.timeService = (ScheduledExecutorService) Preconditions.checkNotNull(helper.getScheduledExecutorService(), "timeService");
        this.timeProvider = timeProvider;
        channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "OutlierDetection lb created.");
    }

    @Override // io.grpc.LoadBalancer
    public Status acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        Long valueOf;
        this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Received resolution result: {0}", resolvedAddresses);
        OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig = (OutlierDetectionLoadBalancerConfig) resolvedAddresses.getLoadBalancingPolicyConfig();
        ArrayList arrayList = new ArrayList();
        for (EquivalentAddressGroup equivalentAddressGroup : resolvedAddresses.getAddresses()) {
            arrayList.addAll(equivalentAddressGroup.getAddresses());
        }
        this.trackerMap.keySet().retainAll(arrayList);
        this.trackerMap.updateTrackerConfigs(outlierDetectionLoadBalancerConfig);
        this.trackerMap.putNewTrackers(outlierDetectionLoadBalancerConfig, arrayList);
        this.switchLb.switchTo(outlierDetectionLoadBalancerConfig.childPolicy.getProvider());
        if (outlierDetectionLoadBalancerConfig.outlierDetectionEnabled()) {
            if (this.detectionTimerStartNanos == null) {
                valueOf = outlierDetectionLoadBalancerConfig.intervalNanos;
            } else {
                valueOf = Long.valueOf(Math.max(0L, outlierDetectionLoadBalancerConfig.intervalNanos.longValue() - (this.timeProvider.currentTimeNanos() - this.detectionTimerStartNanos.longValue())));
            }
            SynchronizationContext.ScheduledHandle scheduledHandle = this.detectionTimerHandle;
            if (scheduledHandle != null) {
                scheduledHandle.cancel();
                this.trackerMap.resetCallCounters();
            }
            this.detectionTimerHandle = this.syncContext.scheduleWithFixedDelay(new DetectionTimer(outlierDetectionLoadBalancerConfig, this.logger), valueOf.longValue(), outlierDetectionLoadBalancerConfig.intervalNanos.longValue(), TimeUnit.NANOSECONDS, this.timeService);
        } else {
            SynchronizationContext.ScheduledHandle scheduledHandle2 = this.detectionTimerHandle;
            if (scheduledHandle2 != null) {
                scheduledHandle2.cancel();
                this.detectionTimerStartNanos = null;
                this.trackerMap.cancelTracking();
            }
        }
        this.switchLb.handleResolvedAddresses(resolvedAddresses.toBuilder().setLoadBalancingPolicyConfig(outlierDetectionLoadBalancerConfig.childPolicy.getConfig()).build());
        return Status.OK;
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        this.switchLb.handleNameResolutionError(status);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        this.switchLb.shutdown();
    }

    /* loaded from: classes.dex */
    class DetectionTimer implements Runnable {
        OutlierDetectionLoadBalancerConfig config;
        ChannelLogger logger;

        DetectionTimer(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            OutlierDetectionLoadBalancer outlierDetectionLoadBalancer = OutlierDetectionLoadBalancer.this;
            outlierDetectionLoadBalancer.detectionTimerStartNanos = Long.valueOf(outlierDetectionLoadBalancer.timeProvider.currentTimeNanos());
            OutlierDetectionLoadBalancer.this.trackerMap.swapCounters();
            for (OutlierEjectionAlgorithm outlierEjectionAlgorithm : OutlierEjectionAlgorithm.forConfig(this.config, this.logger)) {
                outlierEjectionAlgorithm.ejectOutliers(OutlierDetectionLoadBalancer.this.trackerMap, OutlierDetectionLoadBalancer.this.detectionTimerStartNanos.longValue());
            }
            OutlierDetectionLoadBalancer.this.trackerMap.maybeUnejectOutliers(OutlierDetectionLoadBalancer.this.detectionTimerStartNanos);
        }
    }

    /* loaded from: classes.dex */
    class ChildHelper extends ForwardingLoadBalancerHelper {
        private LoadBalancer.Helper delegate;

        ChildHelper(LoadBalancer.Helper helper) {
            this.delegate = new HealthProducerHelper(helper);
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper
        protected LoadBalancer.Helper delegate() {
            return this.delegate;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper, io.grpc.LoadBalancer.Helper
        public LoadBalancer.Subchannel createSubchannel(LoadBalancer.CreateSubchannelArgs createSubchannelArgs) {
            OutlierDetectionSubchannel outlierDetectionSubchannel = new OutlierDetectionSubchannel(createSubchannelArgs, this.delegate);
            List<EquivalentAddressGroup> addresses = createSubchannelArgs.getAddresses();
            if (OutlierDetectionLoadBalancer.hasSingleAddress(addresses) && OutlierDetectionLoadBalancer.this.trackerMap.containsKey(addresses.get(0).getAddresses().get(0))) {
                AddressTracker addressTracker = OutlierDetectionLoadBalancer.this.trackerMap.get(addresses.get(0).getAddresses().get(0));
                addressTracker.addSubchannel(outlierDetectionSubchannel);
                if (addressTracker.ejectionTimeNanos != null) {
                    outlierDetectionSubchannel.eject();
                }
            }
            return outlierDetectionSubchannel;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper, io.grpc.LoadBalancer.Helper
        public void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
            this.delegate.updateBalancingState(connectivityState, new OutlierDetectionPicker(subchannelPicker));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OutlierDetectionSubchannel extends ForwardingSubchannel {
        private AddressTracker addressTracker;
        private final LoadBalancer.Subchannel delegate;
        private boolean ejected;
        private ConnectivityStateInfo lastSubchannelState;
        private final ChannelLogger logger;
        private LoadBalancer.SubchannelStateListener subchannelStateListener;

        OutlierDetectionSubchannel(LoadBalancer.CreateSubchannelArgs createSubchannelArgs, LoadBalancer.Helper helper) {
            LoadBalancer.SubchannelStateListener subchannelStateListener = (LoadBalancer.SubchannelStateListener) createSubchannelArgs.getOption(LoadBalancer.HEALTH_CONSUMER_LISTENER_ARG_KEY);
            if (subchannelStateListener != null) {
                this.subchannelStateListener = subchannelStateListener;
                this.delegate = helper.createSubchannel(createSubchannelArgs.toBuilder().addOption(LoadBalancer.HEALTH_CONSUMER_LISTENER_ARG_KEY, new OutlierDetectionSubchannelStateListener(subchannelStateListener)).build());
            } else {
                this.delegate = helper.createSubchannel(createSubchannelArgs);
            }
            this.logger = this.delegate.getChannelLogger();
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public void start(LoadBalancer.SubchannelStateListener subchannelStateListener) {
            if (this.subchannelStateListener != null) {
                super.start(subchannelStateListener);
                return;
            }
            this.subchannelStateListener = subchannelStateListener;
            super.start(new OutlierDetectionSubchannelStateListener(subchannelStateListener));
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public void shutdown() {
            AddressTracker addressTracker = this.addressTracker;
            if (addressTracker != null) {
                addressTracker.removeSubchannel(this);
            }
            super.shutdown();
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public Attributes getAttributes() {
            if (this.addressTracker != null) {
                return this.delegate.getAttributes().toBuilder().set(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY, this.addressTracker).build();
            }
            return this.delegate.getAttributes();
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public void updateAddresses(List<EquivalentAddressGroup> list) {
            if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) || !OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) || OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                    if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                        SocketAddress socketAddress = list.get(0).getAddresses().get(0);
                        if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(socketAddress)) {
                            OutlierDetectionLoadBalancer.this.trackerMap.get(socketAddress).addSubchannel(this);
                        }
                    }
                } else if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(getAddresses().getAddresses().get(0))) {
                    AddressTracker addressTracker = OutlierDetectionLoadBalancer.this.trackerMap.get(getAddresses().getAddresses().get(0));
                    addressTracker.removeSubchannel(this);
                    addressTracker.resetCallCounters();
                }
            } else {
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsValue(this.addressTracker)) {
                    this.addressTracker.removeSubchannel(this);
                }
                SocketAddress socketAddress2 = list.get(0).getAddresses().get(0);
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(socketAddress2)) {
                    OutlierDetectionLoadBalancer.this.trackerMap.get(socketAddress2).addSubchannel(this);
                }
            }
            this.delegate.updateAddresses(list);
        }

        void setAddressTracker(AddressTracker addressTracker) {
            this.addressTracker = addressTracker;
        }

        void clearAddressTracker() {
            this.addressTracker = null;
        }

        void eject() {
            this.ejected = true;
            this.subchannelStateListener.onSubchannelState(ConnectivityStateInfo.forTransientFailure(Status.UNAVAILABLE));
            this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel ejected: {0}", this);
        }

        void uneject() {
            this.ejected = false;
            ConnectivityStateInfo connectivityStateInfo = this.lastSubchannelState;
            if (connectivityStateInfo != null) {
                this.subchannelStateListener.onSubchannelState(connectivityStateInfo);
                this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel unejected: {0}", this);
            }
        }

        boolean isEjected() {
            return this.ejected;
        }

        @Override // io.grpc.util.ForwardingSubchannel
        protected LoadBalancer.Subchannel delegate() {
            return this.delegate;
        }

        /* loaded from: classes.dex */
        class OutlierDetectionSubchannelStateListener implements LoadBalancer.SubchannelStateListener {
            private final LoadBalancer.SubchannelStateListener delegate;

            OutlierDetectionSubchannelStateListener(LoadBalancer.SubchannelStateListener subchannelStateListener) {
                this.delegate = subchannelStateListener;
            }

            @Override // io.grpc.LoadBalancer.SubchannelStateListener
            public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                OutlierDetectionSubchannel.this.lastSubchannelState = connectivityStateInfo;
                if (OutlierDetectionSubchannel.this.ejected) {
                    return;
                }
                this.delegate.onSubchannelState(connectivityStateInfo);
            }
        }

        @Override // io.grpc.util.ForwardingSubchannel
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.delegate.getAllAddresses() + '}';
        }
    }

    /* loaded from: classes.dex */
    class OutlierDetectionPicker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.SubchannelPicker delegate;

        OutlierDetectionPicker(LoadBalancer.SubchannelPicker subchannelPicker) {
            this.delegate = subchannelPicker;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            LoadBalancer.PickResult pickSubchannel = this.delegate.pickSubchannel(pickSubchannelArgs);
            LoadBalancer.Subchannel subchannel = pickSubchannel.getSubchannel();
            return subchannel != null ? LoadBalancer.PickResult.withSubchannel(subchannel, new ResultCountingClientStreamTracerFactory((AddressTracker) subchannel.getAttributes().get(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY), pickSubchannel.getStreamTracerFactory())) : pickSubchannel;
        }

        /* loaded from: classes.dex */
        class ResultCountingClientStreamTracerFactory extends ClientStreamTracer.Factory {
            @Nullable
            private final ClientStreamTracer.Factory delegateFactory;
            private final AddressTracker tracker;

            ResultCountingClientStreamTracerFactory(AddressTracker addressTracker, @Nullable ClientStreamTracer.Factory factory) {
                this.tracker = addressTracker;
                this.delegateFactory = factory;
            }

            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                ClientStreamTracer.Factory factory = this.delegateFactory;
                if (factory != null) {
                    final ClientStreamTracer newClientStreamTracer = factory.newClientStreamTracer(streamInfo, metadata);
                    return new ForwardingClientStreamTracer() { // from class: io.grpc.util.OutlierDetectionLoadBalancer.OutlierDetectionPicker.ResultCountingClientStreamTracerFactory.1
                        @Override // io.grpc.util.ForwardingClientStreamTracer
                        protected ClientStreamTracer delegate() {
                            return newClientStreamTracer;
                        }

                        @Override // io.grpc.util.ForwardingClientStreamTracer, io.grpc.StreamTracer
                        public void streamClosed(Status status) {
                            ResultCountingClientStreamTracerFactory.this.tracker.incrementCallCount(status.isOk());
                            delegate().streamClosed(status);
                        }
                    };
                }
                return new ClientStreamTracer() { // from class: io.grpc.util.OutlierDetectionLoadBalancer.OutlierDetectionPicker.ResultCountingClientStreamTracerFactory.2
                    @Override // io.grpc.StreamTracer
                    public void streamClosed(Status status) {
                        ResultCountingClientStreamTracerFactory.this.tracker.incrementCallCount(status.isOk());
                    }
                };
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AddressTracker {
        private OutlierDetectionLoadBalancerConfig config;
        private int ejectionTimeMultiplier;
        private Long ejectionTimeNanos;
        private volatile CallCounter activeCallCounter = new CallCounter();
        private CallCounter inactiveCallCounter = new CallCounter();
        private final Set<OutlierDetectionSubchannel> subchannels = new HashSet();

        AddressTracker(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            this.config = outlierDetectionLoadBalancerConfig;
        }

        void setConfig(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            this.config = outlierDetectionLoadBalancerConfig;
        }

        boolean addSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            if (subchannelsEjected() && !outlierDetectionSubchannel.isEjected()) {
                outlierDetectionSubchannel.eject();
            } else if (!subchannelsEjected() && outlierDetectionSubchannel.isEjected()) {
                outlierDetectionSubchannel.uneject();
            }
            outlierDetectionSubchannel.setAddressTracker(this);
            return this.subchannels.add(outlierDetectionSubchannel);
        }

        boolean removeSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            outlierDetectionSubchannel.clearAddressTracker();
            return this.subchannels.remove(outlierDetectionSubchannel);
        }

        boolean containsSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            return this.subchannels.contains(outlierDetectionSubchannel);
        }

        Set<OutlierDetectionSubchannel> getSubchannels() {
            return ImmutableSet.copyOf((Collection) this.subchannels);
        }

        void incrementCallCount(boolean z) {
            if (this.config.successRateEjection == null && this.config.failurePercentageEjection == null) {
                return;
            }
            if (z) {
                this.activeCallCounter.successCount.getAndIncrement();
            } else {
                this.activeCallCounter.failureCount.getAndIncrement();
            }
        }

        long activeVolume() {
            return this.activeCallCounter.successCount.get() + this.activeCallCounter.failureCount.get();
        }

        long inactiveVolume() {
            return this.inactiveCallCounter.successCount.get() + this.inactiveCallCounter.failureCount.get();
        }

        double successRate() {
            return this.inactiveCallCounter.successCount.get() / inactiveVolume();
        }

        double failureRate() {
            return this.inactiveCallCounter.failureCount.get() / inactiveVolume();
        }

        void resetCallCounters() {
            this.activeCallCounter.reset();
            this.inactiveCallCounter.reset();
        }

        void decrementEjectionTimeMultiplier() {
            int i = this.ejectionTimeMultiplier;
            this.ejectionTimeMultiplier = i == 0 ? 0 : i - 1;
        }

        void resetEjectionTimeMultiplier() {
            this.ejectionTimeMultiplier = 0;
        }

        void swapCounters() {
            this.inactiveCallCounter.reset();
            CallCounter callCounter = this.activeCallCounter;
            this.activeCallCounter = this.inactiveCallCounter;
            this.inactiveCallCounter = callCounter;
        }

        void ejectSubchannels(long j) {
            this.ejectionTimeNanos = Long.valueOf(j);
            this.ejectionTimeMultiplier++;
            for (OutlierDetectionSubchannel outlierDetectionSubchannel : this.subchannels) {
                outlierDetectionSubchannel.eject();
            }
        }

        void unejectSubchannels() {
            Preconditions.checkState(this.ejectionTimeNanos != null, "not currently ejected");
            this.ejectionTimeNanos = null;
            for (OutlierDetectionSubchannel outlierDetectionSubchannel : this.subchannels) {
                outlierDetectionSubchannel.uneject();
            }
        }

        boolean subchannelsEjected() {
            return this.ejectionTimeNanos != null;
        }

        public boolean maxEjectionTimeElapsed(long j) {
            return j > this.ejectionTimeNanos.longValue() + Math.min(this.config.baseEjectionTimeNanos.longValue() * ((long) this.ejectionTimeMultiplier), Math.max(this.config.baseEjectionTimeNanos.longValue(), this.config.maxEjectionTimeNanos.longValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class CallCounter {
            AtomicLong failureCount;
            AtomicLong successCount;

            private CallCounter() {
                this.successCount = new AtomicLong();
                this.failureCount = new AtomicLong();
            }

            void reset() {
                this.successCount.set(0L);
                this.failureCount.set(0L);
            }
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.subchannels + '}';
        }
    }

    /* loaded from: classes.dex */
    static class AddressTrackerMap extends ForwardingMap<SocketAddress, AddressTracker> {
        private final Map<SocketAddress, AddressTracker> trackerMap = new HashMap();

        AddressTrackerMap() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<SocketAddress, AddressTracker> delegate() {
            return this.trackerMap;
        }

        void updateTrackerConfigs(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                addressTracker.setConfig(outlierDetectionLoadBalancerConfig);
            }
        }

        void putNewTrackers(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, Collection<SocketAddress> collection) {
            for (SocketAddress socketAddress : collection) {
                if (!this.trackerMap.containsKey(socketAddress)) {
                    this.trackerMap.put(socketAddress, new AddressTracker(outlierDetectionLoadBalancerConfig));
                }
            }
        }

        void resetCallCounters() {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                addressTracker.resetCallCounters();
            }
        }

        void cancelTracking() {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                if (addressTracker.subchannelsEjected()) {
                    addressTracker.unejectSubchannels();
                }
                addressTracker.resetEjectionTimeMultiplier();
            }
        }

        void swapCounters() {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                addressTracker.swapCounters();
            }
        }

        void maybeUnejectOutliers(Long l) {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                if (!addressTracker.subchannelsEjected()) {
                    addressTracker.decrementEjectionTimeMultiplier();
                }
                if (addressTracker.subchannelsEjected() && addressTracker.maxEjectionTimeElapsed(l.longValue())) {
                    addressTracker.unejectSubchannels();
                }
            }
        }

        double ejectionPercentage() {
            if (this.trackerMap.isEmpty()) {
                return 0.0d;
            }
            int i = 0;
            int i2 = 0;
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                i2++;
                if (addressTracker.subchannelsEjected()) {
                    i++;
                }
            }
            return (i / i2) * 100.0d;
        }
    }

    /* loaded from: classes.dex */
    interface OutlierEjectionAlgorithm {
        void ejectOutliers(AddressTrackerMap addressTrackerMap, long j);

        @Nullable
        static List<OutlierEjectionAlgorithm> forConfig(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            ImmutableList.Builder builder = ImmutableList.builder();
            if (outlierDetectionLoadBalancerConfig.successRateEjection != null) {
                builder.add((ImmutableList.Builder) new SuccessRateOutlierEjectionAlgorithm(outlierDetectionLoadBalancerConfig, channelLogger));
            }
            if (outlierDetectionLoadBalancerConfig.failurePercentageEjection != null) {
                builder.add((ImmutableList.Builder) new FailurePercentageOutlierEjectionAlgorithm(outlierDetectionLoadBalancerConfig, channelLogger));
            }
            return builder.build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SuccessRateOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        SuccessRateOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            Preconditions.checkArgument(outlierDetectionLoadBalancerConfig.successRateEjection != null, "success rate ejection config is null");
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @Override // io.grpc.util.OutlierDetectionLoadBalancer.OutlierEjectionAlgorithm
        public void ejectOutliers(AddressTrackerMap addressTrackerMap, long j) {
            List<AddressTracker> trackersWithVolume = OutlierDetectionLoadBalancer.trackersWithVolume(addressTrackerMap, this.config.successRateEjection.requestVolume.intValue());
            if (trackersWithVolume.size() < this.config.successRateEjection.minimumHosts.intValue() || trackersWithVolume.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (AddressTracker addressTracker : trackersWithVolume) {
                arrayList.add(Double.valueOf(addressTracker.successRate()));
            }
            double mean = mean(arrayList);
            double standardDeviation = standardDeviation(arrayList, mean);
            double intValue = mean - ((this.config.successRateEjection.stdevFactor.intValue() / 1000.0f) * standardDeviation);
            for (AddressTracker addressTracker2 : trackersWithVolume) {
                if (addressTrackerMap.ejectionPercentage() >= this.config.maxEjectionPercent.intValue()) {
                    return;
                }
                if (addressTracker2.successRate() < intValue) {
                    this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", addressTracker2, Double.valueOf(addressTracker2.successRate()), Double.valueOf(mean), Double.valueOf(standardDeviation), Double.valueOf(intValue));
                    if (new Random().nextInt(100) < this.config.successRateEjection.enforcementPercentage.intValue()) {
                        addressTracker2.ejectSubchannels(j);
                    }
                }
            }
        }

        static double mean(Collection<Double> collection) {
            double d = 0.0d;
            for (Double d2 : collection) {
                d += d2.doubleValue();
            }
            return d / collection.size();
        }

        static double standardDeviation(Collection<Double> collection, double d) {
            double d2 = 0.0d;
            for (Double d3 : collection) {
                double doubleValue = d3.doubleValue() - d;
                d2 += doubleValue * doubleValue;
            }
            return Math.sqrt(d2 / collection.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FailurePercentageOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        FailurePercentageOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @Override // io.grpc.util.OutlierDetectionLoadBalancer.OutlierEjectionAlgorithm
        public void ejectOutliers(AddressTrackerMap addressTrackerMap, long j) {
            List<AddressTracker> trackersWithVolume = OutlierDetectionLoadBalancer.trackersWithVolume(addressTrackerMap, this.config.failurePercentageEjection.requestVolume.intValue());
            if (trackersWithVolume.size() < this.config.failurePercentageEjection.minimumHosts.intValue() || trackersWithVolume.size() == 0) {
                return;
            }
            for (AddressTracker addressTracker : trackersWithVolume) {
                if (addressTrackerMap.ejectionPercentage() >= this.config.maxEjectionPercent.intValue()) {
                    return;
                }
                if (addressTracker.inactiveVolume() >= this.config.failurePercentageEjection.requestVolume.intValue() && addressTracker.failureRate() > this.config.failurePercentageEjection.threshold.intValue() / 100.0d) {
                    this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", addressTracker, Double.valueOf(addressTracker.failureRate()));
                    if (new Random().nextInt(100) < this.config.failurePercentageEjection.enforcementPercentage.intValue()) {
                        addressTracker.ejectSubchannels(j);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AddressTracker> trackersWithVolume(AddressTrackerMap addressTrackerMap, int i) {
        ArrayList arrayList = new ArrayList();
        for (AddressTracker addressTracker : addressTrackerMap.values()) {
            if (addressTracker.inactiveVolume() >= i) {
                arrayList.add(addressTracker);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasSingleAddress(List<EquivalentAddressGroup> list) {
        int i = 0;
        for (EquivalentAddressGroup equivalentAddressGroup : list) {
            i += equivalentAddressGroup.getAddresses().size();
            if (i > 1) {
                return false;
            }
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static final class OutlierDetectionLoadBalancerConfig {
        public final Long baseEjectionTimeNanos;
        public final ServiceConfigUtil.PolicySelection childPolicy;
        public final FailurePercentageEjection failurePercentageEjection;
        public final Long intervalNanos;
        public final Integer maxEjectionPercent;
        public final Long maxEjectionTimeNanos;
        public final SuccessRateEjection successRateEjection;

        private OutlierDetectionLoadBalancerConfig(Long l, Long l2, Long l3, Integer num, SuccessRateEjection successRateEjection, FailurePercentageEjection failurePercentageEjection, ServiceConfigUtil.PolicySelection policySelection) {
            this.intervalNanos = l;
            this.baseEjectionTimeNanos = l2;
            this.maxEjectionTimeNanos = l3;
            this.maxEjectionPercent = num;
            this.successRateEjection = successRateEjection;
            this.failurePercentageEjection = failurePercentageEjection;
            this.childPolicy = policySelection;
        }

        /* loaded from: classes.dex */
        public static class Builder {
            ServiceConfigUtil.PolicySelection childPolicy;
            FailurePercentageEjection failurePercentageEjection;
            SuccessRateEjection successRateEjection;
            Long intervalNanos = 10000000000L;
            Long baseEjectionTimeNanos = 30000000000L;
            Long maxEjectionTimeNanos = 300000000000L;
            Integer maxEjectionPercent = 10;

            public Builder setIntervalNanos(Long l) {
                Preconditions.checkArgument(l != null);
                this.intervalNanos = l;
                return this;
            }

            public Builder setBaseEjectionTimeNanos(Long l) {
                Preconditions.checkArgument(l != null);
                this.baseEjectionTimeNanos = l;
                return this;
            }

            public Builder setMaxEjectionTimeNanos(Long l) {
                Preconditions.checkArgument(l != null);
                this.maxEjectionTimeNanos = l;
                return this;
            }

            public Builder setMaxEjectionPercent(Integer num) {
                Preconditions.checkArgument(num != null);
                this.maxEjectionPercent = num;
                return this;
            }

            public Builder setSuccessRateEjection(SuccessRateEjection successRateEjection) {
                this.successRateEjection = successRateEjection;
                return this;
            }

            public Builder setFailurePercentageEjection(FailurePercentageEjection failurePercentageEjection) {
                this.failurePercentageEjection = failurePercentageEjection;
                return this;
            }

            public Builder setChildPolicy(ServiceConfigUtil.PolicySelection policySelection) {
                Preconditions.checkState(policySelection != null);
                this.childPolicy = policySelection;
                return this;
            }

            public OutlierDetectionLoadBalancerConfig build() {
                Preconditions.checkState(this.childPolicy != null);
                return new OutlierDetectionLoadBalancerConfig(this.intervalNanos, this.baseEjectionTimeNanos, this.maxEjectionTimeNanos, this.maxEjectionPercent, this.successRateEjection, this.failurePercentageEjection, this.childPolicy);
            }
        }

        /* loaded from: classes.dex */
        public static class SuccessRateEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer stdevFactor;

            SuccessRateEjection(Integer num, Integer num2, Integer num3, Integer num4) {
                this.stdevFactor = num;
                this.enforcementPercentage = num2;
                this.minimumHosts = num3;
                this.requestVolume = num4;
            }

            /* loaded from: classes.dex */
            public static final class Builder {
                Integer stdevFactor = 1900;
                Integer enforcementPercentage = 100;
                Integer minimumHosts = 5;
                Integer requestVolume = 100;

                public Builder setStdevFactor(Integer num) {
                    Preconditions.checkArgument(num != null);
                    this.stdevFactor = num;
                    return this;
                }

                public Builder setEnforcementPercentage(Integer num) {
                    boolean z = true;
                    Preconditions.checkArgument(num != null);
                    if (num.intValue() < 0 || num.intValue() > 100) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.enforcementPercentage = num;
                    return this;
                }

                public Builder setMinimumHosts(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.minimumHosts = num;
                    return this;
                }

                public Builder setRequestVolume(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.requestVolume = num;
                    return this;
                }

                public SuccessRateEjection build() {
                    return new SuccessRateEjection(this.stdevFactor, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }
            }
        }

        /* loaded from: classes.dex */
        public static class FailurePercentageEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer threshold;

            FailurePercentageEjection(Integer num, Integer num2, Integer num3, Integer num4) {
                this.threshold = num;
                this.enforcementPercentage = num2;
                this.minimumHosts = num3;
                this.requestVolume = num4;
            }

            /* loaded from: classes.dex */
            public static class Builder {
                Integer threshold = 85;
                Integer enforcementPercentage = 100;
                Integer minimumHosts = 5;
                Integer requestVolume = 50;

                public Builder setThreshold(Integer num) {
                    boolean z = true;
                    Preconditions.checkArgument(num != null);
                    if (num.intValue() < 0 || num.intValue() > 100) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.threshold = num;
                    return this;
                }

                public Builder setEnforcementPercentage(Integer num) {
                    boolean z = true;
                    Preconditions.checkArgument(num != null);
                    if (num.intValue() < 0 || num.intValue() > 100) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.enforcementPercentage = num;
                    return this;
                }

                public Builder setMinimumHosts(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.minimumHosts = num;
                    return this;
                }

                public Builder setRequestVolume(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.requestVolume = num;
                    return this;
                }

                public FailurePercentageEjection build() {
                    return new FailurePercentageEjection(this.threshold, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }
            }
        }

        boolean outlierDetectionEnabled() {
            return (this.successRateEjection == null && this.failurePercentageEjection == null) ? false : true;
        }
    }
}
