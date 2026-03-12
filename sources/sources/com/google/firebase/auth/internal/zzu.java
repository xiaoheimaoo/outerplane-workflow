package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p002firebaseauthapi.zzahg;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* loaded from: classes3.dex */
public final class zzu implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.zzc;
        }
        return this.zzb;
    }

    public zzu(zzahg zzahgVar) {
        this.zzb = zzahgVar.zzg() ? zzahgVar.zzc() : zzahgVar.zzb();
        this.zzc = zzahgVar.zzb();
        ActionCodeInfo actionCodeInfo = null;
        if (!zzahgVar.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String zzd = zzahgVar.zzd();
        zzd.hashCode();
        int i = 5;
        char c = 65535;
        switch (zzd.hashCode()) {
            case -1874510116:
                if (zzd.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c = 0;
                    break;
                }
                break;
            case -1452371317:
                if (zzd.equals("PASSWORD_RESET")) {
                    c = 1;
                    break;
                }
                break;
            case -1341836234:
                if (zzd.equals("VERIFY_EMAIL")) {
                    c = 2;
                    break;
                }
                break;
            case -1099157829:
                if (zzd.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c = 3;
                    break;
                }
                break;
            case 870738373:
                if (zzd.equals("EMAIL_SIGNIN")) {
                    c = 4;
                    break;
                }
                break;
            case 970484929:
                if (zzd.equals("RECOVER_EMAIL")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = 6;
                break;
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 2;
                break;
            default:
                i = 3;
                break;
        }
        this.zza = i;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        if (zzahgVar.zzf()) {
            actionCodeInfo = new zzv(zzahgVar.zzb(), zzbk.zza(zzahgVar.zza()));
        } else if (zzahgVar.zzg()) {
            actionCodeInfo = new zzt(zzahgVar.zzc(), zzahgVar.zzb());
        } else if (zzahgVar.zze()) {
            actionCodeInfo = new zzs(zzahgVar.zzb());
        }
        this.zzd = actionCodeInfo;
    }
}
