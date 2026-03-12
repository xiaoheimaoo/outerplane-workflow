package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzlj implements zzov {
    private final zzli zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzlj(zzli zzliVar) {
        byte[] bArr = zznl.zzb;
        this.zza = zzliVar;
        zzliVar.zzc = this;
    }

    private final void zzP(Object obj, zzow zzowVar, zzmo zzmoVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzowVar.zzh(obj, this, zzmoVar);
            if (this.zzb == this.zzc) {
                return;
            }
            throw new zznn("Failed to parse the message.");
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzow zzowVar, zzmo zzmoVar) throws IOException {
        zzli zzliVar;
        zzli zzliVar2 = this.zza;
        int zzn = zzliVar2.zzn();
        if (zzliVar2.zza >= zzliVar2.zzb) {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int zze = zzliVar2.zze(zzn);
        this.zza.zza++;
        zzowVar.zzh(obj, this, zzmoVar);
        this.zza.zzz(0);
        zzliVar.zza--;
        this.zza.zzA(zze);
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zznm("Protocol message tag had invalid wire type.");
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zznn("Failed to parse the message.");
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zznn("Failed to parse the message.");
        }
    }

    public static zzlj zzq(zzli zzliVar) {
        zzlj zzljVar = zzliVar.zzc;
        return zzljVar != null ? zzljVar : new zzlj(zzliVar);
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzA(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = zzn + this.zza.zzd();
                do {
                    zznxVar.zzg(this.zza.zzo());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zznxVar.zzg(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = zzn2 + this.zza.zzd();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzB(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzmv) {
            zzmv zzmvVar = (zzmv) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzmvVar.zzf(this.zza.zzc());
                } while (this.zza.zzd() < zzd);
                return;
            } else if (i2 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzmvVar.zzf(this.zza.zzc());
                    if (this.zza.zzC()) {
                        return;
                    }
                    i = this.zza.zzm();
                } while (i == this.zzb);
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i3 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            } else {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm = this.zza.zzm();
                } while (zzm == this.zzb);
                i = zzm;
            }
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    @Deprecated
    public final void zzC(List list, zzow zzowVar, zzmo zzmoVar) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                Object zze = zzowVar.zze();
                zzP(zze, zzowVar, zzmoVar);
                zzowVar.zzf(zze);
                list.add(zze);
                if (this.zza.zzC() || this.zzd != 0) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw new zznm("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzD(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zzneVar.zzh(this.zza.zzh());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzneVar.zzh(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzE(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zznxVar.zzg(this.zza.zzp());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zznxVar.zzg(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzF(List list, zzow zzowVar, zzmo zzmoVar) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                Object zze = zzowVar.zze();
                zzQ(zze, zzowVar, zzmoVar);
                zzowVar.zzf(zze);
                list.add(zze);
                if (this.zza.zzC() || this.zzd != 0) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw new zznm("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzG(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzneVar.zzh(this.zza.zzk());
                } while (this.zza.zzd() < zzd);
                return;
            } else if (i2 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzneVar.zzh(this.zza.zzk());
                    if (this.zza.zzC()) {
                        return;
                    }
                    i = this.zza.zzm();
                } while (i == this.zzb);
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i3 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            } else {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm = this.zza.zzm();
                } while (zzm == this.zzb);
                i = zzm;
            }
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzH(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = zzn + this.zza.zzd();
                do {
                    zznxVar.zzg(this.zza.zzt());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zznxVar.zzg(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = zzn2 + this.zza.zzd();
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzI(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zzneVar.zzh(this.zza.zzl());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzneVar.zzh(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzJ(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zznxVar.zzg(this.zza.zzu());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zznxVar.zzg(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzm;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zznu) && !z) {
                zznu zznuVar = (zznu) list;
                do {
                    zzp();
                    zznuVar.zzb();
                    if (this.zza.zzC()) {
                        return;
                    }
                    i = this.zza.zzm();
                } while (i == this.zzb);
            } else {
                do {
                    list.add(z ? zzs() : zzr());
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm = this.zza.zzm();
                } while (zzm == this.zzb);
                i = zzm;
            }
            this.zzd = i;
            return;
        }
        throw new zznm("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzL(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zzneVar.zzh(this.zza.zzn());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzneVar.zzh(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzM(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zznxVar.zzg(this.zza.zzv());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zznxVar.zzg(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final boolean zzO() throws IOException {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzm();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final zzle zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzt(Object obj, zzow zzowVar, zzmo zzmoVar) throws IOException {
        zzS(3);
        zzP(obj, zzowVar, zzmoVar);
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzu(Object obj, zzow zzowVar, zzmo zzmoVar) throws IOException {
        zzS(2);
        zzQ(obj, zzowVar, zzmoVar);
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzv(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzkv) {
            zzkv zzkvVar = (zzkv) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zzkvVar.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzkvVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw new zznm("Protocol message tag had invalid wire type.");
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzx(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzmi) {
            zzmi zzmiVar = (zzmi) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = zzn + this.zza.zzd();
                do {
                    zzmiVar.zzf(this.zza.zzb());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zzmiVar.zzf(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = zzn2 + this.zza.zzd();
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzy(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar = this.zza;
                int zzd = zzliVar.zzd() + zzliVar.zzn();
                do {
                    zzneVar.zzh(this.zza.zzf());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzneVar.zzh(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                }
                i = this.zza.zzm();
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzli zzliVar2 = this.zza;
                int zzd2 = zzliVar2.zzd() + zzliVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzC()) {
                    return;
                }
                zzm = this.zza.zzm();
            } while (zzm == this.zzb);
            i = zzm;
        }
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzov
    public final void zzz(List list) throws IOException {
        int zzm;
        int i;
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzneVar.zzh(this.zza.zzg());
                } while (this.zza.zzd() < zzd);
                return;
            } else if (i2 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            } else {
                do {
                    zzneVar.zzh(this.zza.zzg());
                    if (this.zza.zzC()) {
                        return;
                    }
                    i = this.zza.zzm();
                } while (i == this.zzb);
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i3 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            } else {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (this.zza.zzC()) {
                        return;
                    }
                    zzm = this.zza.zzm();
                } while (zzm == this.zzb);
                i = zzm;
            }
        }
        this.zzd = i;
    }
}
