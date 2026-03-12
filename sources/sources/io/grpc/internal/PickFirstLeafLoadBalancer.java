package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class PickFirstLeafLoadBalancer extends LoadBalancer {
    static final int CONNECTION_DELAY_INTERVAL_MS = 250;
    public static final String GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS = "GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS";
    private static final Logger log = Logger.getLogger(PickFirstLeafLoadBalancer.class.getName());
    private Index addressIndex;
    private final LoadBalancer.Helper helper;
    @Nullable
    private SynchronizationContext.ScheduledHandle scheduleConnectionTask;
    private final Map<SocketAddress, SubchannelData> subchannels = new HashMap();
    private int numTf = 0;
    private boolean firstPass = true;
    private ConnectivityState rawConnectivityState = ConnectivityState.IDLE;
    private ConnectivityState concludedState = ConnectivityState.IDLE;
    private final boolean enableHappyEyeballs = GrpcUtil.getFlag(GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS, false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public PickFirstLeafLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    @Override // io.grpc.LoadBalancer
    public Status acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        if (this.rawConnectivityState == ConnectivityState.SHUTDOWN) {
            return Status.FAILED_PRECONDITION.withDescription("Already shut down");
        }
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        if (addresses.isEmpty()) {
            Status withDescription = Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + resolvedAddresses.getAddresses() + ", attrs=" + resolvedAddresses.getAttributes());
            handleNameResolutionError(withDescription);
            return withDescription;
        }
        for (EquivalentAddressGroup equivalentAddressGroup : addresses) {
            if (equivalentAddressGroup == null) {
                Status withDescription2 = Status.UNAVAILABLE.withDescription("NameResolver returned address list with null endpoint. addrs=" + resolvedAddresses.getAddresses() + ", attrs=" + resolvedAddresses.getAttributes());
                handleNameResolutionError(withDescription2);
                return withDescription2;
            }
        }
        this.firstPass = true;
        if (resolvedAddresses.getLoadBalancingPolicyConfig() instanceof PickFirstLeafLoadBalancerConfig) {
            PickFirstLeafLoadBalancerConfig pickFirstLeafLoadBalancerConfig = (PickFirstLeafLoadBalancerConfig) resolvedAddresses.getLoadBalancingPolicyConfig();
            if (pickFirstLeafLoadBalancerConfig.shuffleAddressList != null && pickFirstLeafLoadBalancerConfig.shuffleAddressList.booleanValue()) {
                ArrayList arrayList = new ArrayList(addresses);
                Collections.shuffle(arrayList, pickFirstLeafLoadBalancerConfig.randomSeed != null ? new Random(pickFirstLeafLoadBalancerConfig.randomSeed.longValue()) : new Random());
                addresses = arrayList;
            }
        }
        ImmutableList<EquivalentAddressGroup> build = ImmutableList.builder().addAll((Iterable) addresses).build();
        if (this.addressIndex == null) {
            this.addressIndex = new Index(build);
        } else if (this.rawConnectivityState == ConnectivityState.READY) {
            SocketAddress currentAddress = this.addressIndex.getCurrentAddress();
            this.addressIndex.updateGroups(build);
            if (this.addressIndex.seekTo(currentAddress)) {
                return Status.OK;
            }
            this.addressIndex.reset();
        } else {
            this.addressIndex.updateGroups(build);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.subchannels.keySet());
        HashSet hashSet2 = new HashSet();
        UnmodifiableIterator<EquivalentAddressGroup> it = build.iterator();
        while (it.hasNext()) {
            hashSet2.addAll(it.next().getAddresses());
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                this.subchannels.remove(socketAddress).getSubchannel().shutdown();
            }
        }
        if (hashSet.size() == 0 || this.rawConnectivityState == ConnectivityState.CONNECTING || this.rawConnectivityState == ConnectivityState.READY) {
            this.rawConnectivityState = ConnectivityState.CONNECTING;
            updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withNoResult()));
            cancelScheduleTask();
            requestConnection();
        } else if (this.rawConnectivityState == ConnectivityState.IDLE) {
            updateBalancingState(ConnectivityState.IDLE, new RequestConnectionPicker(this));
        } else if (this.rawConnectivityState == ConnectivityState.TRANSIENT_FAILURE) {
            cancelScheduleTask();
            requestConnection();
        }
        return Status.OK;
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        for (SubchannelData subchannelData : this.subchannels.values()) {
            subchannelData.getSubchannel().shutdown();
        }
        this.subchannels.clear();
        updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(status)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: processSubchannelState */
    public void m527x8260e1cf(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        ConnectivityState state = connectivityStateInfo.getState();
        SubchannelData subchannelData = this.subchannels.get(getAddress(subchannel));
        if (subchannelData == null || subchannelData.getSubchannel() != subchannel || state == ConnectivityState.SHUTDOWN) {
            return;
        }
        if (state == ConnectivityState.IDLE) {
            this.helper.refreshNameResolution();
        }
        subchannelData.updateState(state);
        if (this.rawConnectivityState == ConnectivityState.TRANSIENT_FAILURE || this.concludedState == ConnectivityState.TRANSIENT_FAILURE) {
            if (state == ConnectivityState.CONNECTING) {
                return;
            }
            if (state == ConnectivityState.IDLE) {
                requestConnection();
                return;
            }
        }
        int i = AnonymousClass1.$SwitchMap$io$grpc$ConnectivityState[state.ordinal()];
        if (i == 1) {
            this.addressIndex.reset();
            this.rawConnectivityState = ConnectivityState.IDLE;
            updateBalancingState(ConnectivityState.IDLE, new RequestConnectionPicker(this));
        } else if (i == 2) {
            this.rawConnectivityState = ConnectivityState.CONNECTING;
            updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withNoResult()));
        } else if (i == 3) {
            shutdownRemaining(subchannelData);
            this.addressIndex.seekTo(getAddress(subchannel));
            this.rawConnectivityState = ConnectivityState.READY;
            updateHealthCheckedState(subchannelData);
        } else if (i == 4) {
            if (this.addressIndex.isValid() && this.subchannels.get(this.addressIndex.getCurrentAddress()).getSubchannel() == subchannel && this.addressIndex.increment()) {
                cancelScheduleTask();
                requestConnection();
            }
            if (isPassComplete()) {
                this.rawConnectivityState = ConnectivityState.TRANSIENT_FAILURE;
                updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(connectivityStateInfo.getStatus())));
                int i2 = this.numTf + 1;
                this.numTf = i2;
                if (i2 >= this.addressIndex.size() || this.firstPass) {
                    this.firstPass = false;
                    this.numTf = 0;
                    this.helper.refreshNameResolution();
                }
            }
        } else {
            throw new IllegalArgumentException("Unsupported state:" + state);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.internal.PickFirstLeafLoadBalancer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$ConnectivityState;

        static {
            int[] iArr = new int[ConnectivityState.values().length];
            $SwitchMap$io$grpc$ConnectivityState = iArr;
            try {
                iArr[ConnectivityState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHealthCheckedState(SubchannelData subchannelData) {
        if (subchannelData.state != ConnectivityState.READY) {
            return;
        }
        if (subchannelData.getHealthState() == ConnectivityState.READY) {
            updateBalancingState(ConnectivityState.READY, new LoadBalancer.FixedResultPicker(LoadBalancer.PickResult.withSubchannel(subchannelData.subchannel)));
        } else if (subchannelData.getHealthState() == ConnectivityState.TRANSIENT_FAILURE) {
            updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(subchannelData.healthListener.healthStateInfo.getStatus())));
        } else if (this.concludedState != ConnectivityState.TRANSIENT_FAILURE) {
            updateBalancingState(subchannelData.getHealthState(), new Picker(LoadBalancer.PickResult.withNoResult()));
        }
    }

    private void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
        if (connectivityState == this.concludedState && (connectivityState == ConnectivityState.IDLE || connectivityState == ConnectivityState.CONNECTING)) {
            return;
        }
        this.concludedState = connectivityState;
        this.helper.updateBalancingState(connectivityState, subchannelPicker);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        log.log(Level.FINE, "Shutting down, currently have {} subchannels created", Integer.valueOf(this.subchannels.size()));
        this.rawConnectivityState = ConnectivityState.SHUTDOWN;
        this.concludedState = ConnectivityState.SHUTDOWN;
        cancelScheduleTask();
        for (SubchannelData subchannelData : this.subchannels.values()) {
            subchannelData.getSubchannel().shutdown();
        }
        this.subchannels.clear();
    }

    private void shutdownRemaining(SubchannelData subchannelData) {
        cancelScheduleTask();
        for (SubchannelData subchannelData2 : this.subchannels.values()) {
            if (!subchannelData2.getSubchannel().equals(subchannelData.subchannel)) {
                subchannelData2.getSubchannel().shutdown();
            }
        }
        this.subchannels.clear();
        subchannelData.updateState(ConnectivityState.READY);
        this.subchannels.put(getAddress(subchannelData.subchannel), subchannelData);
    }

    @Override // io.grpc.LoadBalancer
    public void requestConnection() {
        LoadBalancer.Subchannel createNewSubchannel;
        Index index = this.addressIndex;
        if (index == null || !index.isValid() || this.rawConnectivityState == ConnectivityState.SHUTDOWN) {
            return;
        }
        SocketAddress currentAddress = this.addressIndex.getCurrentAddress();
        if (this.subchannels.containsKey(currentAddress)) {
            createNewSubchannel = this.subchannels.get(currentAddress).getSubchannel();
        } else {
            createNewSubchannel = createNewSubchannel(currentAddress);
        }
        int i = AnonymousClass1.$SwitchMap$io$grpc$ConnectivityState[this.subchannels.get(currentAddress).getState().ordinal()];
        if (i == 1) {
            createNewSubchannel.requestConnection();
            this.subchannels.get(currentAddress).updateState(ConnectivityState.CONNECTING);
            scheduleNextConnection();
        } else if (i == 2) {
            if (this.enableHappyEyeballs) {
                scheduleNextConnection();
            } else {
                createNewSubchannel.requestConnection();
            }
        } else if (i == 3) {
            log.warning("Requesting a connection even though we have a READY subchannel");
        } else if (i != 4) {
        } else {
            this.addressIndex.increment();
            requestConnection();
        }
    }

    private void scheduleNextConnection() {
        if (this.enableHappyEyeballs) {
            SynchronizationContext.ScheduledHandle scheduledHandle = this.scheduleConnectionTask;
            if (scheduledHandle == null || !scheduledHandle.isPending()) {
                this.scheduleConnectionTask = this.helper.getSynchronizationContext().schedule(new Runnable() { // from class: io.grpc.internal.PickFirstLeafLoadBalancer.1StartNextConnection
                    @Override // java.lang.Runnable
                    public void run() {
                        PickFirstLeafLoadBalancer.this.scheduleConnectionTask = null;
                        if (PickFirstLeafLoadBalancer.this.addressIndex.increment()) {
                            PickFirstLeafLoadBalancer.this.requestConnection();
                        }
                    }
                }, 250L, TimeUnit.MILLISECONDS, this.helper.getScheduledExecutorService());
            }
        }
    }

    private void cancelScheduleTask() {
        SynchronizationContext.ScheduledHandle scheduledHandle = this.scheduleConnectionTask;
        if (scheduledHandle != null) {
            scheduledHandle.cancel();
            this.scheduleConnectionTask = null;
        }
    }

    private LoadBalancer.Subchannel createNewSubchannel(SocketAddress socketAddress) {
        HealthListener healthListener = new HealthListener(this, null);
        final LoadBalancer.Subchannel createSubchannel = this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(Lists.newArrayList(new EquivalentAddressGroup(socketAddress))).addOption(HEALTH_CONSUMER_LISTENER_ARG_KEY, healthListener).build());
        if (createSubchannel == null) {
            log.warning("Was not able to create subchannel for " + socketAddress);
            throw new IllegalStateException("Can't create subchannel");
        }
        SubchannelData subchannelData = new SubchannelData(createSubchannel, ConnectivityState.IDLE, healthListener);
        healthListener.subchannelData = subchannelData;
        this.subchannels.put(socketAddress, subchannelData);
        if (createSubchannel.getAttributes().get(LoadBalancer.HAS_HEALTH_PRODUCER_LISTENER_KEY) == null) {
            healthListener.healthStateInfo = ConnectivityStateInfo.forNonError(ConnectivityState.READY);
        }
        createSubchannel.start(new LoadBalancer.SubchannelStateListener() { // from class: io.grpc.internal.PickFirstLeafLoadBalancer$$ExternalSyntheticLambda0
            @Override // io.grpc.LoadBalancer.SubchannelStateListener
            public final void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                PickFirstLeafLoadBalancer.this.m527x8260e1cf(createSubchannel, connectivityStateInfo);
            }
        });
        return createSubchannel;
    }

    private boolean isPassComplete() {
        Index index = this.addressIndex;
        if (index == null || index.isValid() || this.subchannels.size() < this.addressIndex.size()) {
            return false;
        }
        for (SubchannelData subchannelData : this.subchannels.values()) {
            if (!subchannelData.isCompletedConnectivityAttempt()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class HealthListener implements LoadBalancer.SubchannelStateListener {
        private ConnectivityStateInfo healthStateInfo;
        private SubchannelData subchannelData;

        private HealthListener() {
            this.healthStateInfo = ConnectivityStateInfo.forNonError(ConnectivityState.IDLE);
        }

        /* synthetic */ HealthListener(PickFirstLeafLoadBalancer pickFirstLeafLoadBalancer, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.grpc.LoadBalancer.SubchannelStateListener
        public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
            PickFirstLeafLoadBalancer.log.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{connectivityStateInfo, this.subchannelData.subchannel});
            this.healthStateInfo = connectivityStateInfo;
            if (PickFirstLeafLoadBalancer.this.addressIndex.isValid() && ((SubchannelData) PickFirstLeafLoadBalancer.this.subchannels.get(PickFirstLeafLoadBalancer.this.addressIndex.getCurrentAddress())).healthListener == this) {
                PickFirstLeafLoadBalancer.this.updateHealthCheckedState(this.subchannelData);
            }
        }
    }

    private SocketAddress getAddress(LoadBalancer.Subchannel subchannel) {
        return subchannel.getAddresses().getAddresses().get(0);
    }

    ConnectivityState getConcludedConnectivityState() {
        return this.concludedState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Picker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.PickResult result;

        Picker(LoadBalancer.PickResult pickResult) {
            this.result = (LoadBalancer.PickResult) Preconditions.checkNotNull(pickResult, "result");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.result;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) Picker.class).add("result", this.result).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class RequestConnectionPicker extends LoadBalancer.SubchannelPicker {
        private final AtomicBoolean connectionRequested = new AtomicBoolean(false);
        private final PickFirstLeafLoadBalancer pickFirstLeafLoadBalancer;

        RequestConnectionPicker(PickFirstLeafLoadBalancer pickFirstLeafLoadBalancer) {
            this.pickFirstLeafLoadBalancer = (PickFirstLeafLoadBalancer) Preconditions.checkNotNull(pickFirstLeafLoadBalancer, "pickFirstLeafLoadBalancer");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            if (this.connectionRequested.compareAndSet(false, true)) {
                SynchronizationContext synchronizationContext = PickFirstLeafLoadBalancer.this.helper.getSynchronizationContext();
                final PickFirstLeafLoadBalancer pickFirstLeafLoadBalancer = this.pickFirstLeafLoadBalancer;
                Objects.requireNonNull(pickFirstLeafLoadBalancer);
                synchronizationContext.execute(new Runnable() { // from class: io.grpc.internal.PickFirstLeafLoadBalancer$RequestConnectionPicker$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PickFirstLeafLoadBalancer.this.requestConnection();
                    }
                });
            }
            return LoadBalancer.PickResult.withNoResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Index {
        private List<EquivalentAddressGroup> addressGroups;
        private int addressIndex;
        private int groupIndex;

        public Index(List<EquivalentAddressGroup> list) {
            this.addressGroups = list == null ? Collections.emptyList() : list;
        }

        public boolean isValid() {
            return this.groupIndex < this.addressGroups.size();
        }

        public boolean isAtBeginning() {
            return this.groupIndex == 0 && this.addressIndex == 0;
        }

        public boolean increment() {
            if (isValid()) {
                int i = this.addressIndex + 1;
                this.addressIndex = i;
                if (i >= this.addressGroups.get(this.groupIndex).getAddresses().size()) {
                    int i2 = this.groupIndex + 1;
                    this.groupIndex = i2;
                    this.addressIndex = 0;
                    return i2 < this.addressGroups.size();
                }
                return true;
            }
            return false;
        }

        public void reset() {
            this.groupIndex = 0;
            this.addressIndex = 0;
        }

        public SocketAddress getCurrentAddress() {
            if (!isValid()) {
                throw new IllegalStateException("Index is past the end of the address group list");
            }
            return this.addressGroups.get(this.groupIndex).getAddresses().get(this.addressIndex);
        }

        public Attributes getCurrentEagAttributes() {
            if (!isValid()) {
                throw new IllegalStateException("Index is off the end of the address group list");
            }
            return this.addressGroups.get(this.groupIndex).getAttributes();
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
            r1 = r1;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateGroups(com.google.common.collect.ImmutableList<io.grpc.EquivalentAddressGroup> r1) {
            /*
                r0 = this;
                if (r1 == 0) goto L3
                goto L7
            L3:
                java.util.List r1 = java.util.Collections.emptyList()
            L7:
                r0.addressGroups = r1
                r0.reset()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.PickFirstLeafLoadBalancer.Index.updateGroups(com.google.common.collect.ImmutableList):void");
        }

        public boolean seekTo(SocketAddress socketAddress) {
            for (int i = 0; i < this.addressGroups.size(); i++) {
                int indexOf = this.addressGroups.get(i).getAddresses().indexOf(socketAddress);
                if (indexOf != -1) {
                    this.groupIndex = i;
                    this.addressIndex = indexOf;
                    return true;
                }
            }
            return false;
        }

        public int size() {
            List<EquivalentAddressGroup> list = this.addressGroups;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class SubchannelData {
        private boolean completedConnectivityAttempt = false;
        private final HealthListener healthListener;
        private ConnectivityState state;
        private final LoadBalancer.Subchannel subchannel;

        public SubchannelData(LoadBalancer.Subchannel subchannel, ConnectivityState connectivityState, HealthListener healthListener) {
            this.subchannel = subchannel;
            this.state = connectivityState;
            this.healthListener = healthListener;
        }

        public LoadBalancer.Subchannel getSubchannel() {
            return this.subchannel;
        }

        public ConnectivityState getState() {
            return this.state;
        }

        public boolean isCompletedConnectivityAttempt() {
            return this.completedConnectivityAttempt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateState(ConnectivityState connectivityState) {
            this.state = connectivityState;
            if (connectivityState == ConnectivityState.READY || connectivityState == ConnectivityState.TRANSIENT_FAILURE) {
                this.completedConnectivityAttempt = true;
            } else if (connectivityState == ConnectivityState.IDLE) {
                this.completedConnectivityAttempt = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ConnectivityState getHealthState() {
            return this.healthListener.healthStateInfo.getState();
        }
    }

    /* loaded from: classes3.dex */
    public static final class PickFirstLeafLoadBalancerConfig {
        @Nullable
        final Long randomSeed;
        @Nullable
        public final Boolean shuffleAddressList;

        public PickFirstLeafLoadBalancerConfig(@Nullable Boolean bool) {
            this(bool, null);
        }

        PickFirstLeafLoadBalancerConfig(@Nullable Boolean bool, @Nullable Long l) {
            this.shuffleAddressList = bool;
            this.randomSeed = l;
        }
    }
}
