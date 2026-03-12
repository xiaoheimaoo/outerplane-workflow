package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public enum zzs {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    public static zzs zza(int i) {
        if (i != 2) {
            if (i != 3) {
                if (i != 5) {
                    if (i == 6) {
                        return ERROR;
                    }
                    return INFO;
                }
                return WARN;
            }
            return DEBUG;
        }
        return VERBOSE;
    }

    zzs(int i) {
    }
}
