package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.UShort;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzau  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzau<K, V> extends zzan<K, V> {
    private static final zzan<Object, Object> zza = new zzau(null, new Object[0], 0);
    private final transient Object zzb;
    private final transient Object[] zzc;
    private final transient int zzd;

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final zzai<V> zza() {
        return new zzay(this.zzc, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final zzas<Map.Entry<K, V>> zzb() {
        return new zzat(this, this.zzc, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final zzas<K> zzc() {
        return new zzav(this, new zzay(this.zzc, 0, this.zzd));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object[]] */
    public static <K, V> zzau<K, V> zza(int i, Object[] objArr, zzaq<K, V> zzaqVar) {
        int i2;
        short[] sArr;
        char c;
        char c2;
        byte[] bArr;
        byte[] bArr2;
        int i3 = i;
        Object[] objArr2 = objArr;
        if (i3 == 0) {
            return (zzau) zza;
        }
        Object obj = null;
        int i4 = 1;
        if (i3 == 1) {
            zzag.zza(Objects.requireNonNull(objArr2[0]), Objects.requireNonNull(objArr2[1]));
            return new zzau<>(null, objArr2, 1);
        }
        zzw.zzb(i3, objArr2.length >> 1);
        int max = Math.max(i3, 2);
        if (max < 751619276) {
            i2 = Integer.highestOneBit(max - 1) << 1;
            while (i2 * 0.7d < max) {
                i2 <<= 1;
            }
        } else {
            i2 = 1073741824;
            if (!(max < 1073741824)) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i3 == 1) {
            zzag.zza(Objects.requireNonNull(objArr2[0]), Objects.requireNonNull(objArr2[1]));
            c = 1;
            c2 = 2;
        } else {
            int i5 = i2 - 1;
            char c3 = 65535;
            if (i2 <= 128) {
                byte[] bArr3 = new byte[i2];
                Arrays.fill(bArr3, (byte) -1);
                int i6 = 0;
                int i7 = 0;
                while (i6 < i3) {
                    int i8 = i6 * 2;
                    int i9 = i7 * 2;
                    Object requireNonNull = Objects.requireNonNull(objArr2[i8]);
                    Object requireNonNull2 = Objects.requireNonNull(objArr2[i8 ^ i4]);
                    zzag.zza(requireNonNull, requireNonNull2);
                    int zza2 = zzaf.zza(requireNonNull.hashCode());
                    while (true) {
                        int i10 = zza2 & i5;
                        int i11 = bArr3[i10] & 255;
                        if (i11 == 255) {
                            bArr3[i10] = (byte) i9;
                            if (i7 < i6) {
                                objArr2[i9] = requireNonNull;
                                objArr2[i9 ^ 1] = requireNonNull2;
                            }
                            i7++;
                        } else if (requireNonNull.equals(objArr2[i11])) {
                            int i12 = i11 ^ 1;
                            obj = new zzap(requireNonNull, requireNonNull2, Objects.requireNonNull(objArr2[i12]));
                            objArr2[i12] = requireNonNull2;
                            break;
                        } else {
                            zza2 = i10 + 1;
                        }
                    }
                    i6++;
                    i4 = 1;
                }
                if (i7 == i3) {
                    bArr = bArr3;
                    c2 = 2;
                    bArr2 = bArr;
                    c = 1;
                    obj = bArr2;
                } else {
                    bArr2 = new Object[]{bArr3, Integer.valueOf(i7), obj};
                    c2 = 2;
                    c = 1;
                    obj = bArr2;
                }
            } else {
                if (i2 <= 32768) {
                    sArr = new short[i2];
                    Arrays.fill(sArr, (short) -1);
                    int i13 = 0;
                    for (int i14 = 0; i14 < i3; i14++) {
                        int i15 = i14 * 2;
                        int i16 = i13 * 2;
                        Object requireNonNull3 = Objects.requireNonNull(objArr2[i15]);
                        Object requireNonNull4 = Objects.requireNonNull(objArr2[i15 ^ 1]);
                        zzag.zza(requireNonNull3, requireNonNull4);
                        int zza3 = zzaf.zza(requireNonNull3.hashCode());
                        while (true) {
                            int i17 = zza3 & i5;
                            int i18 = sArr[i17] & UShort.MAX_VALUE;
                            if (i18 == 65535) {
                                sArr[i17] = (short) i16;
                                if (i13 < i14) {
                                    objArr2[i16] = requireNonNull3;
                                    objArr2[i16 ^ 1] = requireNonNull4;
                                }
                                i13++;
                            } else if (requireNonNull3.equals(objArr2[i18])) {
                                int i19 = i18 ^ 1;
                                obj = new zzap(requireNonNull3, requireNonNull4, Objects.requireNonNull(objArr2[i19]));
                                objArr2[i19] = requireNonNull4;
                                break;
                            } else {
                                zza3 = i17 + 1;
                            }
                        }
                    }
                    if (i13 != i3) {
                        c2 = 2;
                        bArr2 = new Object[]{sArr, Integer.valueOf(i13), obj};
                        c = 1;
                        obj = bArr2;
                    }
                } else {
                    sArr = new int[i2];
                    Arrays.fill((int[]) sArr, -1);
                    int i20 = 0;
                    int i21 = 0;
                    while (i20 < i3) {
                        int i22 = i20 * 2;
                        int i23 = i21 * 2;
                        Object requireNonNull5 = Objects.requireNonNull(objArr2[i22]);
                        Object requireNonNull6 = Objects.requireNonNull(objArr2[i22 ^ 1]);
                        zzag.zza(requireNonNull5, requireNonNull6);
                        int zza4 = zzaf.zza(requireNonNull5.hashCode());
                        while (true) {
                            int i24 = zza4 & i5;
                            ?? r15 = sArr[i24];
                            if (r15 == c3) {
                                sArr[i24] = i23;
                                if (i21 < i20) {
                                    objArr2[i23] = requireNonNull5;
                                    objArr2[i23 ^ 1] = requireNonNull6;
                                }
                                i21++;
                            } else if (requireNonNull5.equals(objArr2[r15])) {
                                int i25 = r15 ^ 1;
                                obj = new zzap(requireNonNull5, requireNonNull6, Objects.requireNonNull(objArr2[i25]));
                                objArr2[i25] = requireNonNull6;
                                break;
                            } else {
                                zza4 = i24 + 1;
                                c3 = 65535;
                            }
                        }
                        i20++;
                        c3 = 65535;
                    }
                    if (i21 != i3) {
                        c = 1;
                        c2 = 2;
                        obj = new Object[]{sArr, Integer.valueOf(i21), obj};
                    }
                }
                bArr = sArr;
                c2 = 2;
                bArr2 = bArr;
                c = 1;
                obj = bArr2;
            }
        }
        if (obj instanceof Object[]) {
            Object[] objArr3 = (Object[]) obj;
            zzap zzapVar = (zzap) objArr3[c2];
            if (zzaqVar == null) {
                throw zzapVar.zza();
            }
            zzaqVar.zza = zzapVar;
            Object obj2 = objArr3[0];
            int intValue = ((Integer) objArr3[c]).intValue();
            objArr2 = Arrays.copyOf(objArr2, intValue << 1);
            obj = obj2;
            i3 = intValue;
        }
        return new zzau<>(obj, objArr2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1 A[RETURN] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zzb
            java.lang.Object[] r1 = r8.zzc
            int r2 = r8.zzd
            r3 = 0
            if (r9 != 0) goto Lc
        L9:
            r9 = r3
            goto L9e
        Lc:
            r4 = 1
            if (r2 != r4) goto L24
            r0 = 0
            r0 = r1[r0]
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L9
            r9 = r1[r4]
            java.lang.Object r9 = java.util.Objects.requireNonNull(r9)
            goto L9e
        L24:
            if (r0 != 0) goto L27
            goto L9
        L27:
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L52
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r5 = r0 + (-1)
            int r0 = r9.hashCode()
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r0)
        L39:
            r0 = r0 & r5
            r6 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L42
            goto L9
        L42:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L4f
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9e
        L4f:
            int r0 = r0 + 1
            goto L39
        L52:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L7e
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r5 = r0 + (-1)
            int r0 = r9.hashCode()
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r0)
        L64:
            r0 = r0 & r5
            short r6 = r2[r0]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L6e
            goto L9
        L6e:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L7b
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9e
        L7b:
            int r0 = r0 + 1
            goto L64
        L7e:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 - r4
            int r5 = r9.hashCode()
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zza(r5)
        L8a:
            r5 = r5 & r2
            r6 = r0[r5]
            r7 = -1
            if (r6 != r7) goto L92
            goto L9
        L92:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto La2
            r9 = r6 ^ 1
            r9 = r1[r9]
        L9e:
            if (r9 != 0) goto La1
            return r3
        La1:
            return r9
        La2:
            int r5 = r5 + 1
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzau.get(java.lang.Object):java.lang.Object");
    }

    private zzau(Object obj, Object[] objArr, int i) {
        this.zzb = obj;
        this.zzc = objArr;
        this.zzd = i;
    }
}
