package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.helpshift.HelpshiftEvent;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzbny implements zzbng {
    private final Context zza;

    public zzbny(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        if (!map.containsKey(HelpshiftEvent.DATA_MESSAGE_TYPE_TEXT) || TextUtils.isEmpty((CharSequence) map.get(HelpshiftEvent.DATA_MESSAGE_TYPE_TEXT))) {
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("Opening Share Sheet with text: ".concat(String.valueOf((String) map.get(HelpshiftEvent.DATA_MESSAGE_TYPE_TEXT))));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (String) map.get(HelpshiftEvent.DATA_MESSAGE_TYPE_TEXT));
        if (map.containsKey("title")) {
            intent.putExtra("android.intent.extra.TITLE", (String) map.get("title"));
        }
        try {
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzS(this.zza, intent);
        } catch (RuntimeException e) {
            zzcec.zzk("Failed to open Share Sheet", e);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "ShareSheetGmsgHandler.onGmsg");
        }
    }
}
