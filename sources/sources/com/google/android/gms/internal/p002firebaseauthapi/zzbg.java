package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzuz;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbg  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzbg implements zzbz {
    private final OutputStream zza;

    public static zzbz zza(OutputStream outputStream) {
        return new zzbg(outputStream);
    }

    private zzbg(OutputStream outputStream) {
        this.zza = outputStream;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbz
    public final void zza(zzuz zzuzVar) throws IOException {
        try {
            zzuz.zza zzn = zzuzVar.zzn();
            zzuz.zza zzaVar = zzn;
            ((zzuz) ((zzakg) zzn.zza().zze())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbz
    public final void zza(zzwl zzwlVar) throws IOException {
        try {
            zzwlVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
