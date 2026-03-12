package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public abstract class zze {
    private boolean zza;

    protected zzen zza(String str) {
        throw null;
    }

    protected zzen zzb() {
        throw null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|(1:20)|12|13))(4:21|22|23|24))(4:44|45|46|(1:48)(1:49))|25|26|(1:28)|29|31))|53|6|(0)(0)|25|26|(0)|29|31|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        r10 = r0;
        r16 = r3;
        r4 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[Catch: Exception -> 0x00a6, TryCatch #2 {Exception -> 0x00a6, blocks: (B:27:0x0091, B:29:0x009e, B:30:0x00a1), top: B:52:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ed A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzc(java.lang.String r19, long r20, kotlin.coroutines.Continuation r22) throws com.google.android.recaptcha.internal.zzbd {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zze.zzc(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected abstract Object zzd(String str, Continuation continuation);

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        if (r12 != r1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[Catch: Exception -> 0x0058, TryCatch #1 {Exception -> 0x0058, blocks: (B:18:0x0054, B:29:0x0088, B:31:0x0097, B:32:0x009a), top: B:49:0x0054 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zze(long r9, com.google.android.recaptcha.internal.zzsc r11, kotlin.coroutines.Continuation r12) throws com.google.android.recaptcha.internal.zzbd {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zze.zze(long, com.google.android.recaptcha.internal.zzsc, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzf(String str, Continuation continuation) throws zzbd;

    protected Object zzg(zzbd zzbdVar, Continuation continuation) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzh(zzsc zzscVar, Continuation continuation) throws zzbd;

    protected Object zzi(String str, long j, Exception exc, Continuation continuation) {
        return Unit.INSTANCE;
    }

    protected Object zzj(Exception exc, Continuation continuation) {
        return zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzap, exc.getMessage()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzk(zzsr zzsrVar) {
    }

    public final boolean zzl() {
        return this.zza;
    }
}
