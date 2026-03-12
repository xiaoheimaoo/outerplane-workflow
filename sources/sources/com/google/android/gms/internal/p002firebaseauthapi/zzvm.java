package com.google.android.gms.internal.p002firebaseauthapi;

import kotlin.text.Typography;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm  reason: invalid package */
/* loaded from: classes2.dex */
public enum zzvm implements zzakl {
    KEM_UNKNOWN(0),
    DHKEM_X25519_HKDF_SHA256(1),
    DHKEM_P256_HKDF_SHA256(2),
    DHKEM_P384_HKDF_SHA384(3),
    DHKEM_P521_HKDF_SHA512(4),
    UNRECOGNIZED(-1);
    
    private final int zzh;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakl
    public final int zza() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.zzh;
    }

    public static zzvm zza(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return DHKEM_P521_HKDF_SHA512;
                    }
                    return DHKEM_P384_HKDF_SHA384;
                }
                return DHKEM_P256_HKDF_SHA256;
            }
            return DHKEM_X25519_HKDF_SHA256;
        }
        return KEM_UNKNOWN;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=").append(zza());
        }
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzvm(int i) {
        this.zzh = i;
    }
}
