package com.helpshift.network;

import com.helpshift.network.exception.HSRootApiException;
/* loaded from: classes3.dex */
public interface UserManagerProxy {
    HSRequest getRequestBodyForRotatingToken(String str);

    void logoutUserForNetworkException(HSRootApiException.ExceptionType exceptionType);

    void updateNewTokensInStorage(String str, String str2, long j);
}
