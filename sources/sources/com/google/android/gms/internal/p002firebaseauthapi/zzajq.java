package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajq  reason: invalid package */
/* loaded from: classes2.dex */
final class zzajq implements zzanm {
    private final zzajo zza;

    public static zzajq zza(zzajo zzajoVar) {
        if (zzajoVar.zza != null) {
            return zzajoVar.zza;
        }
        return new zzajq(zzajoVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final int zza() {
        return 1;
    }

    private zzajq(zzajo zzajoVar) {
        zzajo zzajoVar2 = (zzajo) zzaki.zza(zzajoVar, "output");
        this.zza = zzajoVar2;
        zzajoVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaiu)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zza(list.get(i4).booleanValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).booleanValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar = (zzaiu) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzaiuVar.size(); i6++) {
                i5 += zzajo.zza(zzaiuVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzaiuVar.size()) {
                this.zza.zzb(zzaiuVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzaiuVar.size()) {
            this.zza.zzb(i, zzaiuVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, zzaiw zzaiwVar) throws IOException {
        this.zza.zzc(i, zzaiwVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, List<zzaiw> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajt)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zza(list.get(i4).doubleValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).doubleValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        zzajt zzajtVar = (zzajt) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzajtVar.size(); i6++) {
                i5 += zzajo.zza(zzajtVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzajtVar.size()) {
                this.zza.zzb(zzajtVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzajtVar.size()) {
            this.zza.zzb(i, zzajtVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakj)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zza(list.get(i4).intValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzj(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzakj zzakjVar = (zzakj) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakjVar.size(); i6++) {
                i5 += zzajo.zza(zzakjVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakjVar.size()) {
                this.zza.zzj(zzakjVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakjVar.size()) {
            this.zza.zzh(i, zzakjVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakj)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zzb(list.get(i4).intValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzi(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzakj zzakjVar = (zzakj) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakjVar.size(); i6++) {
                i5 += zzajo.zzb(zzakjVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakjVar.size()) {
                this.zza.zzi(zzakjVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakjVar.size()) {
            this.zza.zzg(i, zzakjVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaky)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zza(list.get(i4).longValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzf(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzaky zzakyVar = (zzaky) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakyVar.size(); i6++) {
                i5 += zzajo.zza(zzakyVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakyVar.size()) {
                this.zza.zzf(zzakyVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakyVar.size()) {
            this.zza.zzf(i, zzakyVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzake)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zza(list.get(i4).floatValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).floatValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        zzake zzakeVar = (zzake) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakeVar.size(); i6++) {
                i5 += zzajo.zza(zzakeVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakeVar.size()) {
                this.zza.zzb(zzakeVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakeVar.size()) {
            this.zza.zzb(i, zzakeVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, Object obj, zzamc zzamcVar) throws IOException {
        zzajo zzajoVar = this.zza;
        zzajoVar.zzj(i, 3);
        zzamcVar.zza((zzamc) ((zzaln) obj), (zzanm) zzajoVar.zza);
        zzajoVar.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, List<?> list, zzamc zzamcVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzamcVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakj)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zzc(list.get(i4).intValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzj(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzakj zzakjVar = (zzakj) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakjVar.size(); i6++) {
                i5 += zzajo.zzc(zzakjVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakjVar.size()) {
                this.zza.zzj(zzakjVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakjVar.size()) {
            this.zza.zzh(i, zzakjVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaky)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zzb(list.get(i4).longValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzaky zzakyVar = (zzaky) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakyVar.size(); i6++) {
                i5 += zzajo.zzb(zzakyVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakyVar.size()) {
                this.zza.zzh(zzakyVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakyVar.size()) {
            this.zza.zzh(i, zzakyVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final <K, V> void zza(int i, zzale<K, V> zzaleVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i, 2);
            this.zza.zzl(zzalf.zza(zzaleVar, entry.getKey(), entry.getValue()));
            zzalf.zza(this.zza, zzaleVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzb(int i, Object obj, zzamc zzamcVar) throws IOException {
        this.zza.zzc(i, (zzaln) obj, zzamcVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzb(int i, List<?> list, zzamc zzamcVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzamcVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzaiw) {
            this.zza.zzd(i, (zzaiw) obj);
        } else {
            this.zza.zzb(i, (zzaln) obj);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakj)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zze(list.get(i4).intValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzi(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzakj zzakjVar = (zzakj) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakjVar.size(); i6++) {
                i5 += zzajo.zze(zzakjVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakjVar.size()) {
                this.zza.zzi(zzakjVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakjVar.size()) {
            this.zza.zzg(i, zzakjVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaky)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zzc(list.get(i4).longValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzf(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzaky zzakyVar = (zzaky) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakyVar.size(); i6++) {
                i5 += zzajo.zzc(zzakyVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakyVar.size()) {
                this.zza.zzf(zzakyVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakyVar.size()) {
            this.zza.zzf(i, zzakyVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakj)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zzf(list.get(i4).intValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzk(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzi(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzakj zzakjVar = (zzakj) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakjVar.size(); i6++) {
                i5 += zzajo.zzf(zzakjVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakjVar.size()) {
                this.zza.zzk(zzakjVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakjVar.size()) {
            this.zza.zzi(i, zzakjVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaky)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zzd(list.get(i4).longValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzg(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzaky zzakyVar = (zzaky) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakyVar.size(); i6++) {
                i5 += zzajo.zzd(zzakyVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakyVar.size()) {
                this.zza.zzg(zzakyVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakyVar.size()) {
            this.zza.zzg(i, zzakyVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzj(i, 3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzaku) {
            zzaku zzakuVar = (zzaku) list;
            while (i2 < list.size()) {
                Object zza = zzakuVar.zza(i2);
                if (zza instanceof String) {
                    this.zza.zzb(i, (String) zza);
                } else {
                    this.zza.zzc(i, (zzaiw) zza);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakj)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zzh(list.get(i4).intValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzl(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzk(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzakj zzakjVar = (zzakj) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakjVar.size(); i6++) {
                i5 += zzajo.zzh(zzakjVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakjVar.size()) {
                this.zza.zzl(zzakjVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakjVar.size()) {
            this.zza.zzk(i, zzakjVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanm
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaky)) {
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzajo.zze(list.get(i4).longValue());
                }
                this.zza.zzl(i3);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzaky zzakyVar = (zzaky) list;
        if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < zzakyVar.size(); i6++) {
                i5 += zzajo.zze(zzakyVar.zzb(i6));
            }
            this.zza.zzl(i5);
            while (i2 < zzakyVar.size()) {
                this.zza.zzh(zzakyVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzakyVar.size()) {
            this.zza.zzh(i, zzakyVar.zzb(i2));
            i2++;
        }
    }
}
