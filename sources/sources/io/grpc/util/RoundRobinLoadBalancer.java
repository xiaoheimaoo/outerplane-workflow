package io.grpc.util;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.ConnectivityState;
import io.grpc.LoadBalancer;
import io.grpc.util.MultiChildLoadBalancer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class RoundRobinLoadBalancer extends MultiChildLoadBalancer {
    protected LoadBalancer.SubchannelPicker currentPicker;
    private final AtomicInteger sequence;

    public RoundRobinLoadBalancer(LoadBalancer.Helper helper) {
        super(helper);
        this.sequence = new AtomicInteger(new Random().nextInt());
        this.currentPicker = new EmptyPicker();
    }

    @Override // io.grpc.util.MultiChildLoadBalancer
    protected LoadBalancer.SubchannelPicker getSubchannelPicker(Map<Object, LoadBalancer.SubchannelPicker> map) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // io.grpc.util.MultiChildLoadBalancer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void updateOverallBalancingState() {
        /*
            r3 = this;
            java.util.List r0 = r3.getReadyChildren()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L48
            java.util.Collection r0 = r3.getChildLbStates()
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r0.next()
            io.grpc.util.MultiChildLoadBalancer$ChildLbState r1 = (io.grpc.util.MultiChildLoadBalancer.ChildLbState) r1
            io.grpc.ConnectivityState r1 = r1.getCurrentState()
            io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.CONNECTING
            if (r1 == r2) goto L2a
            io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.IDLE
            if (r1 != r2) goto L12
        L2a:
            r0 = 1
            goto L2d
        L2c:
            r0 = 0
        L2d:
            if (r0 == 0) goto L3a
            io.grpc.ConnectivityState r0 = io.grpc.ConnectivityState.CONNECTING
            io.grpc.util.RoundRobinLoadBalancer$EmptyPicker r1 = new io.grpc.util.RoundRobinLoadBalancer$EmptyPicker
            r1.<init>()
            r3.updateBalancingState(r0, r1)
            goto L51
        L3a:
            io.grpc.ConnectivityState r0 = io.grpc.ConnectivityState.TRANSIENT_FAILURE
            java.util.Collection r1 = r3.getChildLbStates()
            io.grpc.LoadBalancer$SubchannelPicker r1 = r3.createReadyPicker(r1)
            r3.updateBalancingState(r0, r1)
            goto L51
        L48:
            io.grpc.ConnectivityState r1 = io.grpc.ConnectivityState.READY
            io.grpc.LoadBalancer$SubchannelPicker r0 = r3.createReadyPicker(r0)
            r3.updateBalancingState(r1, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.util.RoundRobinLoadBalancer.updateOverallBalancingState():void");
    }

    private void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
        if (connectivityState == this.currentConnectivityState && subchannelPicker.equals(this.currentPicker)) {
            return;
        }
        getHelper().updateBalancingState(connectivityState, subchannelPicker);
        this.currentConnectivityState = connectivityState;
        this.currentPicker = subchannelPicker;
    }

    protected LoadBalancer.SubchannelPicker createReadyPicker(Collection<MultiChildLoadBalancer.ChildLbState> collection) {
        ArrayList arrayList = new ArrayList();
        for (MultiChildLoadBalancer.ChildLbState childLbState : collection) {
            arrayList.add(childLbState.getCurrentPicker());
        }
        return new ReadyPicker(arrayList, this.sequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ReadyPicker extends LoadBalancer.SubchannelPicker {
        private final int hashCode;
        private final AtomicInteger index;
        private final List<LoadBalancer.SubchannelPicker> subchannelPickers;

        public ReadyPicker(List<LoadBalancer.SubchannelPicker> list, AtomicInteger atomicInteger) {
            Preconditions.checkArgument(!list.isEmpty(), "empty list");
            this.subchannelPickers = list;
            this.index = (AtomicInteger) Preconditions.checkNotNull(atomicInteger, FirebaseAnalytics.Param.INDEX);
            int i = 0;
            for (LoadBalancer.SubchannelPicker subchannelPicker : list) {
                i += subchannelPicker.hashCode();
            }
            this.hashCode = i;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.subchannelPickers.get(nextIndex()).pickSubchannel(pickSubchannelArgs);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) ReadyPicker.class).add("subchannelPickers", this.subchannelPickers).toString();
        }

        private int nextIndex() {
            return (this.index.getAndIncrement() & Integer.MAX_VALUE) % this.subchannelPickers.size();
        }

        List<LoadBalancer.SubchannelPicker> getSubchannelPickers() {
            return this.subchannelPickers;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ReadyPicker) {
                ReadyPicker readyPicker = (ReadyPicker) obj;
                if (readyPicker == this) {
                    return true;
                }
                return this.hashCode == readyPicker.hashCode && this.index == readyPicker.index && this.subchannelPickers.size() == readyPicker.subchannelPickers.size() && new HashSet(this.subchannelPickers).containsAll(readyPicker.subchannelPickers);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyPicker extends LoadBalancer.SubchannelPicker {
        EmptyPicker() {
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withNoResult();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        public boolean equals(Object obj) {
            return obj instanceof EmptyPicker;
        }
    }
}
