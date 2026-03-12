package com.appsflyer.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class AFb1iSDK extends AFb1vSDK<String> {
    public AFb1iSDK(Context context, Executor executor) {
        super(context, executor, "com.facebook.katana.provider.AttributionIdProvider", "E3F9E1E0CF99D0E56A055BA65E241B3399F7CEA524326B0CDD6EC1327ED0FDC1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.AFb1vSDK
    /* renamed from: AFAdRevenueData */
    public String getCurrencyIso4217Code() {
        Cursor cursor;
        Throwable th;
        try {
            cursor = this.getCurrencyIso4217Code.getContentResolver().query(Uri.parse(new StringBuilder("content://").append(this.getRevenue).toString()), new String[]{"aid"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("aid"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    public final String getMonetizationNetwork() {
        this.getMediationNetwork.execute(this.getMonetizationNetwork);
        return (String) super.getRevenue();
    }

    @Override // com.appsflyer.internal.AFb1vSDK
    public final /* synthetic */ String getRevenue() {
        this.getMediationNetwork.execute(this.getMonetizationNetwork);
        return (String) super.getRevenue();
    }
}
