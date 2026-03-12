package com.helpshift.util.network.connectivity;
/* loaded from: classes3.dex */
public interface HSAndroidConnectivityManager {
    HSConnectivityStatus getConnectivityStatus();

    HSConnectivityType getConnectivityType();

    void startListeningConnectivityChange(HSNetworkConnectivityCallback hSNetworkConnectivityCallback);

    void stopListeningConnectivityChange();
}
