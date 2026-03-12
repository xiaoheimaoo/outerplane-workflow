package com.helpshift.util.network.connectivity;

import android.content.Context;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class HSConnectivityManager implements HSNetworkConnectivityCallback {
    private static HSConnectivityManager instance;
    private Context context;
    private HSAndroidConnectivityManager hsAndroidConnectivityManager;
    private Set<HSNetworkConnectivityCallback> connectivityCallbacks = Collections.synchronizedSet(new LinkedHashSet());
    private HSAndroidConnectivityManagerProvider hsAndroidConnectivityManagerProvider = new HSAndroidConnectivityManagerProvider();

    private HSConnectivityManager(Context context) {
        this.context = context;
    }

    public static HSConnectivityManager getInstance(Context context) {
        if (instance == null) {
            instance = new HSConnectivityManager(context.getApplicationContext());
        }
        return instance;
    }

    public synchronized void registerNetworkConnectivityListener(HSNetworkConnectivityCallback hSNetworkConnectivityCallback) {
        boolean isEmpty = this.connectivityCallbacks.isEmpty();
        this.connectivityCallbacks.add(hSNetworkConnectivityCallback);
        if (isEmpty) {
            startListenNetworkStatus();
        } else {
            int i = AnonymousClass1.$SwitchMap$com$helpshift$util$network$connectivity$HSConnectivityStatus[this.hsAndroidConnectivityManager.getConnectivityStatus().ordinal()];
            if (i == 1) {
                hSNetworkConnectivityCallback.onNetworkAvailable();
            } else if (i == 2) {
                hSNetworkConnectivityCallback.onNetworkUnavailable();
            }
        }
    }

    /* renamed from: com.helpshift.util.network.connectivity.HSConnectivityManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$helpshift$util$network$connectivity$HSConnectivityStatus;

        static {
            int[] iArr = new int[HSConnectivityStatus.values().length];
            $SwitchMap$com$helpshift$util$network$connectivity$HSConnectivityStatus = iArr;
            try {
                iArr[HSConnectivityStatus.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$helpshift$util$network$connectivity$HSConnectivityStatus[HSConnectivityStatus.NOT_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public synchronized void unregisterNetworkConnectivityListener(HSNetworkConnectivityCallback hSNetworkConnectivityCallback) {
        this.connectivityCallbacks.remove(hSNetworkConnectivityCallback);
        if (this.connectivityCallbacks.isEmpty()) {
            stopListenNetworkStatus();
        }
    }

    private void startListenNetworkStatus() {
        if (this.hsAndroidConnectivityManager == null) {
            this.hsAndroidConnectivityManager = this.hsAndroidConnectivityManagerProvider.getOSConnectivityManager(this.context);
        }
        this.hsAndroidConnectivityManager.startListeningConnectivityChange(this);
    }

    private void stopListenNetworkStatus() {
        HSAndroidConnectivityManager hSAndroidConnectivityManager = this.hsAndroidConnectivityManager;
        if (hSAndroidConnectivityManager == null) {
            return;
        }
        hSAndroidConnectivityManager.stopListeningConnectivityChange();
        this.hsAndroidConnectivityManager = null;
    }

    @Override // com.helpshift.util.network.connectivity.HSNetworkConnectivityCallback
    public void onNetworkAvailable() {
        if (this.connectivityCallbacks.isEmpty()) {
            return;
        }
        for (HSNetworkConnectivityCallback hSNetworkConnectivityCallback : this.connectivityCallbacks) {
            hSNetworkConnectivityCallback.onNetworkAvailable();
        }
    }

    @Override // com.helpshift.util.network.connectivity.HSNetworkConnectivityCallback
    public void onNetworkUnavailable() {
        if (this.connectivityCallbacks.isEmpty()) {
            return;
        }
        for (HSNetworkConnectivityCallback hSNetworkConnectivityCallback : this.connectivityCallbacks) {
            hSNetworkConnectivityCallback.onNetworkUnavailable();
        }
    }

    public HSConnectivityType getConnectivityType() {
        if (this.hsAndroidConnectivityManager == null) {
            this.hsAndroidConnectivityManager = this.hsAndroidConnectivityManagerProvider.getOSConnectivityManager(this.context);
        }
        return this.hsAndroidConnectivityManager.getConnectivityType();
    }
}
