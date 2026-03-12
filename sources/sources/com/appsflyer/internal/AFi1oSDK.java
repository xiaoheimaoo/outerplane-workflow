package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.appsflyer.AFLogger;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFi1oSDK extends AFi1pSDK {
    private Network getCurrencyIso4217Code;
    private String getMediationNetwork;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFi1oSDK(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.getMediationNetwork = "unknown";
        AFa1tSDK aFa1tSDK = new AFa1tSDK();
        try {
            ConnectivityManager connectivityManager = this.AFAdRevenueData;
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), aFa1tSDK);
            }
        } catch (Throwable th) {
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.DEVICE_DATA, "Error at attempt to register network callback with ConnectivityManager", th, true, false, false, false, 96, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class AFa1tSDK extends ConnectivityManager.NetworkCallback {
        AFa1tSDK() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            Intrinsics.checkNotNullParameter(network, "");
            AFi1oSDK.this.getCurrencyIso4217Code = network;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "");
            AFi1oSDK.this.getCurrencyIso4217Code = network;
            AFi1oSDK.this.getMediationNetwork = "NetworkLost";
        }
    }

    @Override // com.appsflyer.internal.AFi1pSDK
    protected final String getCurrencyIso4217Code() {
        Network network = this.getCurrencyIso4217Code;
        if (network != null) {
            ConnectivityManager connectivityManager = this.AFAdRevenueData;
            NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
            if (networkCapabilities != null && networkCapabilities != null) {
                if (networkCapabilities.hasTransport(1)) {
                    return "WIFI";
                }
                if (networkCapabilities.hasTransport(0)) {
                    return "MOBILE";
                }
            }
        }
        return "unknown";
    }

    @Override // com.appsflyer.internal.AFi1pSDK
    public final boolean getRevenue() {
        Network network = this.getCurrencyIso4217Code;
        if (network != null) {
            if (!(!Intrinsics.areEqual(this.getMediationNetwork, "NetworkLost"))) {
                network = null;
            }
            if (network != null) {
                ConnectivityManager connectivityManager = this.AFAdRevenueData;
                NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
                if (networkCapabilities != null) {
                    return y_(networkCapabilities);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean y_(NetworkCapabilities networkCapabilities) {
        return (networkCapabilities == null || !networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(15)) ? false : true;
    }
}
