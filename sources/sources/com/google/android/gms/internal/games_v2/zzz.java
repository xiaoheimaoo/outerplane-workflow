package com.google.android.gms.internal.games_v2;
/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes2.dex */
public final class zzz {
    public static String zza(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return "ALL_TIME";
                }
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 18);
                sb.append("Unknown time span ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            return "WEEKLY";
        }
        return "DAILY";
    }
}
