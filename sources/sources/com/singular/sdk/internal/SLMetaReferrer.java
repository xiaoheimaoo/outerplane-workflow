package com.singular.sdk.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler;
import com.singular.sdk.internal.InstallReferrer.SLInstallReferrerService;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class SLMetaReferrer implements SLInstallReferrerService {
    private static final String sourceName = "facebook";

    @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerService
    public void fetchReferrer(Context context, SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        Cursor cursor;
        Uri parse;
        Cursor cursor2 = null;
        if (context == null) {
            sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
            return;
        }
        String str = SingularInstance.getInstance().getSingularConfig().facebookAppId;
        try {
            if (Utils.isEmptyOrNull(str)) {
                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
                return;
            }
            try {
                String[] strArr = {"install_referrer", "is_ct", "actual_timestamp"};
                if (context.getPackageManager().resolveContentProvider(Constants.FACEBOOK_CONTENT_URI_STRING, 0) != null) {
                    parse = Uri.parse(String.format("content://%s/%s", Constants.FACEBOOK_CONTENT_URI_STRING, str));
                } else if (context.getPackageManager().resolveContentProvider(Constants.INSTAGRAM_CONTENT_URI_STRING, 0) != null) {
                    parse = Uri.parse(String.format("content://%s/%s", Constants.INSTAGRAM_CONTENT_URI_STRING, str));
                } else {
                    sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
                    return;
                }
                cursor = context.getContentResolver().query(parse, strArr, null, null, null);
                try {
                } catch (Exception unused) {
                    sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
                    if (cursor == null) {
                        return;
                    }
                    cursor.close();
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            if (cursor == null) {
                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (!cursor.moveToFirst()) {
                cursor.close();
                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(null);
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                int columnIndex = cursor.getColumnIndex("install_referrer");
                int columnIndex2 = cursor.getColumnIndex("actual_timestamp");
                int columnIndex3 = cursor.getColumnIndex("is_ct");
                int i = -1;
                String string = (columnIndex == -1 || cursor.getType(columnIndex) != 3) ? null : cursor.getString(columnIndex);
                int parseInt = (columnIndex2 == -1 || cursor.getType(columnIndex2) != 3) ? -1 : Integer.parseInt(cursor.getString(columnIndex2));
                if (columnIndex3 != -1 && cursor.getType(columnIndex3) == 3) {
                    i = Integer.parseInt(cursor.getString(columnIndex3));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("facebook_install_referrer", string);
                hashMap.put("facebook_actual_timestamp", Integer.valueOf(parseInt));
                hashMap.put("facebook_is_ct", Integer.valueOf(i));
                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(hashMap);
                if (cursor == null) {
                    return;
                }
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = Constants.INSTAGRAM_CONTENT_URI_STRING;
        }
    }
}
