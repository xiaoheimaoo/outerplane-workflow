package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.singular.sdk.internal.Constants;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzblz implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get(Constants.ScionAnalytics.PARAM_LABEL);
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzcec.zzj("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzcec.zzj("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() + (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzcjkVar.zzm().zzc(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzcec.zzk("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzcec.zzj("No value given for CSI experiment.");
            } else {
                zzcjkVar.zzm().zza().zzd(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzcec.zzj("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzcec.zzj("No name given for CSI extra.");
            } else {
                zzcjkVar.zzm().zza().zzd(str6, str7);
            }
        }
    }
}
