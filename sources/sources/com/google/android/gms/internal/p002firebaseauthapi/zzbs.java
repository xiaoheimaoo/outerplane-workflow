package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import com.google.android.gms.internal.p002firebaseauthapi.zzwl;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbs */
/* loaded from: classes2.dex */
public final class zzbs {
    private final zzwl zza;
    private final List<zzbv> zzb;
    private final zznr zzc;

    public static /* synthetic */ zzwl.zza zza(zzbo zzboVar, zzbq zzbqVar, int i) {
        return zzb(zzboVar, zzbqVar, i);
    }

    public static /* synthetic */ void zzb(zzwl zzwlVar) {
        zzd(zzwlVar);
    }

    private static zzbo zza(zzwl.zza zzaVar) throws GeneralSecurityException {
        zzpn zza = zzpn.zza(zzaVar.zzb().zzf(), zzaVar.zzb().zze(), zzaVar.zzb().zzb(), zzaVar.zzf(), zzaVar.zzf() == zzxd.RAW ? null : Integer.valueOf(zzaVar.zza()));
        zzom zza2 = zzom.zza();
        zzcm zza3 = zzcm.zza();
        if (!zza2.zzb(zza)) {
            return new zznn(zza, zza3);
        }
        return zza2.zza((zzom) zza, zza3);
    }

    private static zzbq zza(zzwc zzwcVar) throws GeneralSecurityException {
        int i = zzbr.zza[zzwcVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return zzbq.zzc;
                }
                throw new GeneralSecurityException("Unknown key status");
            }
            return zzbq.zzb;
        }
        return zzbq.zza;
    }

    public static final zzbs zza(zzwl zzwlVar) throws GeneralSecurityException {
        zzd(zzwlVar);
        return new zzbs(zzwlVar, zzc(zzwlVar));
    }

    public static final zzbs zza(zzbp zzbpVar) throws GeneralSecurityException {
        return new zzbu().zza(new zzbt(zzbpVar.zza()).zzb().zza()).zza();
    }

    public final zzbs zza() throws GeneralSecurityException {
        zzwl.zza zzaVar;
        zzbv zzbvVar;
        if (this.zza == null) {
            throw new GeneralSecurityException("cleartext keyset is not available");
        }
        zzwl.zzb zzc = zzwl.zzc();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        int i = 0;
        for (zzbv zzbvVar2 : this.zzb) {
            if (zzbvVar2 != null && (zzbvVar2.zzb() instanceof zzcf)) {
                zzbo zzb = ((zzcf) zzbvVar2.zzb()).zzb();
                zzbvVar = new zzbv(zzb, zzbvVar2.zzc(), zzbvVar2.zza(), zzbvVar2.zzd());
                zzaVar = zzb(zzb, zzbvVar2.zzc(), zzbvVar2.zza());
            } else {
                zzwl.zza zza = this.zza.zza(i);
                zzwb zzb2 = zza.zzb();
                if (zzb2.zzb() != zzwb.zza.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
                zzaVar = (zzwl.zza) ((zzakg) zza.zzn().zza(zzcj.zza(zzb2.zzf(), zzb2.zze())).zze());
                try {
                    zzbo zza2 = zza(zzaVar);
                    int zza3 = zzaVar.zza();
                    zzbvVar = new zzbv(zza2, zza(zzaVar.zzc()), zza3, zza3 == this.zza.zzb());
                } catch (GeneralSecurityException unused) {
                    zzbvVar = null;
                }
            }
            zzc.zza(zzaVar);
            arrayList.add(zzbvVar);
            i++;
        }
        zzc.zza(this.zza.zzb());
        return new zzbs((zzwl) ((zzakg) zzc.zze()), arrayList, this.zzc);
    }

    @Deprecated
    public static final zzbs zza(zzca zzcaVar, zzbe zzbeVar, byte[] bArr) throws GeneralSecurityException, IOException {
        zzuz zza = zzcaVar.zza();
        if (zza == null || zza.zzc().zzb() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return zza(zza(zza, zzbeVar, bArr));
    }

    public static zzwl.zza zzb(zzbo zzboVar, zzbq zzbqVar, int i) throws GeneralSecurityException {
        zzwc zzwcVar;
        zzpn zzpnVar = (zzpn) zzom.zza().zza(zzboVar, zzpn.class, zzcm.zza());
        Integer zze = zzpnVar.zze();
        if (zze != null && zze.intValue() != i) {
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }
        if (zzbq.zza.equals(zzbqVar)) {
            zzwcVar = zzwc.ENABLED;
        } else if (zzbq.zzb.equals(zzbqVar)) {
            zzwcVar = zzwc.DISABLED;
        } else if (zzbq.zzc.equals(zzbqVar)) {
            zzwcVar = zzwc.DESTROYED;
        } else {
            throw new IllegalStateException("Unknown key status");
        }
        return (zzwl.zza) ((zzakg) zzwl.zza.zzd().zza(zzwb.zza().zza(zzpnVar.zzf()).zza(zzpnVar.zzd()).zza(zzpnVar.zza())).zza(zzwcVar).zza(i).zza(zzpnVar.zzc()).zze());
    }

    private static zzwl zza(zzuz zzuzVar, zzbe zzbeVar, byte[] bArr) throws GeneralSecurityException {
        try {
            zzwl zza = zzwl.zza(zzbeVar.zza(zzuzVar.zzc().zzd(), bArr), zzajv.zza());
            zzd(zza);
            return zza;
        } catch (zzakm unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public final zzwl zzb() {
        return this.zza;
    }

    public final <P> P zza(zzbf zzbfVar, Class<P> cls) throws GeneralSecurityException {
        if (!(zzbfVar instanceof zzmz)) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        zzmz zzmzVar = (zzmz) zzbfVar;
        Class<?> zza = zzmzVar.zza((Class<?>) cls);
        if (zza == null) {
            throw new GeneralSecurityException("No wrapper found for " + cls.getName());
        }
        return (P) zza(zzmzVar, cls, zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <B, P> P zza(zzmz zzmzVar, Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        zzcn.zzb(this.zza);
        zzpj zza = zzpg.zza(cls2);
        zza.zza(this.zzc);
        for (int i = 0; i < this.zzb.size(); i++) {
            zzwl.zza zza2 = this.zza.zza(i);
            if (zza2.zzc().equals(zzwc.ENABLED)) {
                zzbv zzbvVar = this.zzb.get(i);
                if (zzbvVar == null) {
                    throw new GeneralSecurityException("Key parsing of key with index " + i + " and type_url " + zza2.zzb().zzf() + " failed, unable to get primitive");
                }
                zzbo zzb = zzbvVar.zzb();
                try {
                    Object zza3 = zzmzVar.zza(zzb, cls2);
                    if (zza2.zza() == this.zza.zzb()) {
                        zza.zzb(zza3, zzb, zza2);
                    } else {
                        zza.zza(zza3, zzb, zza2);
                    }
                } catch (GeneralSecurityException e) {
                    String valueOf = String.valueOf(cls2);
                    throw new GeneralSecurityException("Unable to get primitive " + valueOf + " for key of type " + zza2.zzb().zzf() + ", see https://developers.google.com/tink/faq/registration_errors", e);
                }
            }
        }
        return (P) zzmzVar.zza(zza.zza(), cls);
    }

    public final String toString() {
        return zzcn.zza(this.zza).toString();
    }

    private static List<zzbv> zzc(zzwl zzwlVar) {
        ArrayList arrayList = new ArrayList(zzwlVar.zza());
        for (zzwl.zza zzaVar : zzwlVar.zze()) {
            int zza = zzaVar.zza();
            try {
                arrayList.add(new zzbv(zza(zzaVar), zza(zzaVar.zzc()), zza, zza == zzwlVar.zzb()));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zzbs(zzwl zzwlVar, List<zzbv> list) {
        this.zza = zzwlVar;
        this.zzb = list;
        this.zzc = zznr.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzbs(zzwl zzwlVar, List<zzbv> list, zznr zznrVar) {
        this.zza = zzwlVar;
        this.zzb = list;
        this.zzc = zznrVar;
    }

    public static void zzd(zzwl zzwlVar) throws GeneralSecurityException {
        if (zzwlVar == null || zzwlVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0010  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.p002firebaseauthapi.zzbz r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zzwl r0 = r4.zza
            java.util.List r0 = r0.zze()
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zzwl$zza r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzwl.zza) r1
            com.google.android.gms.internal.firebase-auth-api.zzwb r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwb$zza r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwb$zza r3 = com.google.android.gms.internal.p002firebaseauthapi.zzwb.zza.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zzwb r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwb$zza r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwb$zza r3 = com.google.android.gms.internal.p002firebaseauthapi.zzwb.zza.SYMMETRIC
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zzwb r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwb$zza r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwb$zza r3 = com.google.android.gms.internal.p002firebaseauthapi.zzwb.zza.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L3b
            goto La
        L3b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.google.android.gms.internal.firebase-auth-api.zzwb r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwb$zza r2 = r2.zzb()
            java.lang.String r2 = r2.name()
            r3 = 0
            r0[r3] = r2
            com.google.android.gms.internal.firebase-auth-api.zzwb r1 = r1.zzb()
            java.lang.String r1 = r1.zzf()
            r2 = 1
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L64:
            com.google.android.gms.internal.firebase-auth-api.zzwl r0 = r4.zza
            r5.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbs.zza(com.google.android.gms.internal.firebase-auth-api.zzbz):void");
    }

    @Deprecated
    public final void zza(zzbz zzbzVar, zzbe zzbeVar, byte[] bArr) throws GeneralSecurityException, IOException {
        zzwl zzwlVar = this.zza;
        zzbzVar.zza((zzuz) ((zzakg) zzuz.zza().zza(zzaiw.zza(zzbeVar.zzb(zzwlVar.zzk(), bArr))).zza(zzcn.zza(zzwlVar)).zze()));
    }
}
