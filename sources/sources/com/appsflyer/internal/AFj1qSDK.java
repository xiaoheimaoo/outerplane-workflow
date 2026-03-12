package com.appsflyer.internal;

import android.content.Context;
import com.helpshift.HelpshiftEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public abstract class AFj1qSDK extends Observable {
    public final Map<String, Object> AFAdRevenueData = new HashMap();
    public AFa1vSDK areAllFieldsValid = AFa1vSDK.NOT_STARTED;
    long component1;
    public final String component4;
    public final String getCurrencyIso4217Code;
    final Runnable getMonetizationNetwork;

    /* loaded from: classes.dex */
    public enum AFa1vSDK {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public abstract void getCurrencyIso4217Code(Context context);

    public AFj1qSDK(String str, String str2, Runnable runnable) {
        this.getMonetizationNetwork = runnable;
        this.getCurrencyIso4217Code = str2;
        this.component4 = str;
    }

    /* renamed from: com.appsflyer.internal.AFj1qSDK$1  reason: invalid class name */
    /* loaded from: classes.dex */
    final class AnonymousClass1 implements Observer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1() {
        }

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            AFj1qSDK.this.getMonetizationNetwork.run();
        }
    }

    public final void getMonetizationNetwork() {
        this.AFAdRevenueData.put("source", this.getCurrencyIso4217Code);
        this.AFAdRevenueData.put(HelpshiftEvent.DATA_MESSAGE_TYPE, this.component4);
        getCurrencyIso4217Code();
        this.areAllFieldsValid = AFa1vSDK.FINISHED;
        setChanged();
        notifyObservers();
    }

    protected void getCurrencyIso4217Code() {
        this.AFAdRevenueData.put("latency", Long.valueOf(System.currentTimeMillis() - this.component1));
    }
}
