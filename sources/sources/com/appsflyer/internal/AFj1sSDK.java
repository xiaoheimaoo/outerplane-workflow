package com.appsflyer.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.appsflyer.AFLogger;
/* loaded from: classes.dex */
public final class AFj1sSDK extends AFj1qSDK {
    private final AFc1bSDK getMediationNetwork;
    final ProviderInfo getRevenue;

    public AFj1sSDK(ProviderInfo providerInfo, Runnable runnable, AFc1bSDK aFc1bSDK) {
        super("af_referrer", providerInfo.authority, runnable);
        this.getMediationNetwork = aFc1bSDK;
        this.getRevenue = providerInfo;
    }

    @Override // com.appsflyer.internal.AFj1qSDK
    public final void getCurrencyIso4217Code(final Context context) {
        this.getMediationNetwork.getMediationNetwork().execute(new Runnable() { // from class: com.appsflyer.internal.AFj1sSDK.5
            /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 291
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1sSDK.AnonymousClass5.run():void");
            }
        });
    }

    public static ContentProviderClient B_(Context context, Uri uri) {
        try {
            return context.getContentResolver().acquireUnstableContentProviderClient(uri);
        } catch (SecurityException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.PREINSTALL, "Failed to acquire unstable content providerClient due to SecurityException", e, false, true, false);
            return null;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PREINSTALL, "Failed to acquire unstable content providerClient due to unexpected throwable", th, false, true, false);
            return null;
        }
    }
}
