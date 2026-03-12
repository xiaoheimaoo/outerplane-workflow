package com.appsflyer.internal;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFd1vSDK implements AFd1wSDK {
    private final AFd1zSDK getRevenue;

    public AFd1vSDK(AFd1zSDK aFd1zSDK) {
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.getRevenue = aFd1zSDK;
    }

    @Override // com.appsflyer.internal.AFd1wSDK
    public final void getRevenue(byte[] bArr, Map<String, String> map, int i) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        if (new AFd1qSDK(bArr, map, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE).getRevenue()) {
            this.getRevenue.getCurrencyIso4217Code();
        }
    }
}
