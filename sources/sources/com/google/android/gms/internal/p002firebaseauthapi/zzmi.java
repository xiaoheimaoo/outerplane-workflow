package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzmi {
    private static final Object zza = new Object();
    private static final String zzb = "zzmi";
    private zzbx zzc;

    static /* synthetic */ boolean zzd() {
        return true;
    }

    public final synchronized zzbs zza() throws GeneralSecurityException {
        return this.zzc.zza();
    }

    static /* synthetic */ void zza(zzbs zzbsVar, zzbz zzbzVar, zzbe zzbeVar) {
        try {
            if (zzbeVar != null) {
                zzbsVar.zza(zzbzVar, zzbeVar, new byte[0]);
            } else {
                zzce.zza(zzbsVar, zzbzVar, zzbl.zza());
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private zzmi(zza zzaVar) {
        new zzmp(zzaVar.zza, zzaVar.zzb, zzaVar.zzc);
        this.zzc = zzaVar.zzi;
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi$zza */
    /* loaded from: classes2.dex */
    public static final class zza {
        private Context zza = null;
        private String zzb = null;
        private String zzc = null;
        private String zzd = null;
        private zzbe zze = null;
        private boolean zzf = true;
        private zzbp zzg = null;
        private zzwf zzh = null;
        private zzbx zzi;

        private final zzbe zzb() throws GeneralSecurityException {
            zzmi.zzd();
            zzmn zzmnVar = new zzmn();
            try {
                boolean zzc = zzmn.zzc(this.zzd);
                try {
                    return zzmnVar.zza(this.zzd);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (!zzc) {
                        throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.zzd), e);
                    }
                    Log.w(zzmi.zzb, "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                Log.w(zzmi.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        private static zzbx zza(byte[] bArr) throws GeneralSecurityException, IOException {
            return zzbx.zza(zzce.zza(zzbd.zza(bArr), zzbl.zza()));
        }

        private final zzbx zzb(byte[] bArr) throws GeneralSecurityException, IOException {
            try {
                this.zze = new zzmn().zza(this.zzd);
                try {
                    return zzbx.zza(zzbs.zza(zzbd.zza(bArr), this.zze, new byte[0]));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return zza(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    zzbx zza = zza(bArr);
                    Log.w(zzmi.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                    return zza;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }

        public final zza zza(zzwf zzwfVar) {
            this.zzh = zzwfVar;
            return this;
        }

        public final zza zza(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.zzf) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.zzd = str;
            return this;
        }

        public final zza zza(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            this.zza = context;
            this.zzb = str;
            this.zzc = str2;
            return this;
        }

        public final synchronized zzmi zza() throws GeneralSecurityException, IOException {
            zzmi zzmiVar;
            if (this.zzb == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            zzwf zzwfVar = this.zzh;
            if (zzwfVar != null && this.zzg == null) {
                this.zzg = zzbp.zza(zzco.zza(zzwfVar.zzk()));
            }
            synchronized (zzmi.zza) {
                byte[] zzb = zzb(this.zza, this.zzb, this.zzc);
                if (zzb == null) {
                    if (this.zzd != null) {
                        this.zze = zzb();
                    }
                    zzbp zzbpVar = this.zzg;
                    if (zzbpVar == null) {
                        throw new GeneralSecurityException("cannot read or generate keyset");
                    }
                    zzbs zza = zzbs.zza(zzbpVar);
                    zzmi.zza(zza, new zzmp(this.zza, this.zzb, this.zzc), this.zze);
                    this.zzi = zzbx.zza(zza);
                } else if (this.zzd == null) {
                    this.zzi = zza(zzb);
                } else {
                    zzmi.zzd();
                    this.zzi = zzb(zzb);
                }
                zzmiVar = new zzmi(this);
            }
            return zzmiVar;
        }

        private static byte[] zzb(Context context, String str, String str2) throws IOException {
            SharedPreferences sharedPreferences;
            if (str == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            } else {
                sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
            }
            try {
                String string = sharedPreferences.getString(str, null);
                if (string == null) {
                    return null;
                }
                return zzza.zza(string);
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
            }
        }
    }
}
