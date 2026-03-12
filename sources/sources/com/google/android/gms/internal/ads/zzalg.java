package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.helpshift.HelpshiftEvent;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
final class zzalg {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzalg(int i, int i2, int i3, int i4, int i5) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzalg zza(String str) {
        boolean z;
        zzek.zzd(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            int length = split.length;
            if (i >= length) {
                if (i2 == -1 || i3 == -1 || i5 == -1) {
                    return null;
                }
                return new zzalg(i2, i3, i4, i5, length);
            }
            String zza = zzfwk.zza(split[i].trim());
            switch (zza.hashCode()) {
                case 100571:
                    if (zza.equals("end")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3556653:
                    if (zza.equals(HelpshiftEvent.DATA_MESSAGE_TYPE_TEXT)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 109757538:
                    if (zza.equals("start")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 109780401:
                    if (zza.equals("style")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                i2 = i;
            } else if (z) {
                i3 = i;
            } else if (z) {
                i4 = i;
            } else if (z) {
                i5 = i;
            }
            i++;
        }
    }
}
