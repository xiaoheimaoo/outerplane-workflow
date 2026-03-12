package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final class zzal extends SuspendLambda implements Function2 {
    long zza;
    boolean zzb;
    int zzc;
    final /* synthetic */ zzan zzd;
    final /* synthetic */ zzen zze;
    final /* synthetic */ Ref.ObjectRef zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(zzan zzanVar, zzen zzenVar, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzanVar;
        this.zze = zzenVar;
        this.zzf = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzal(this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Throwable, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:12:0x0028). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008c -> B:39:0x008d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.zzc
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L21
            if (r1 == r3) goto L17
            boolean r1 = r8.zzb
            long r4 = r8.zza
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r1
            r1 = r8
            goto L8d
        L17:
            long r4 = r8.zza
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L1e
            r1 = r8
            goto L39
        L1e:
            r9 = move-exception
            r1 = r8
            goto L55
        L21:
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = 1000(0x3e8, double:4.94E-321)
            r1 = r8
            r9 = r3
        L28:
            if (r9 == 0) goto L91
            com.google.android.recaptcha.internal.zzan r9 = r1.zzd     // Catch: java.lang.Exception -> L52
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L52
            r1.zza = r4     // Catch: java.lang.Exception -> L52
            r1.zzc = r3     // Catch: java.lang.Exception -> L52
            java.lang.Object r9 = com.google.android.recaptcha.internal.zzan.zza(r9, r6)     // Catch: java.lang.Exception -> L52
            if (r9 == r0) goto L54
        L39:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r9 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r9     // Catch: java.lang.Exception -> L52
            com.google.android.recaptcha.internal.zzan r6 = r1.zzd     // Catch: java.lang.Exception -> L52
            kotlinx.coroutines.CompletableDeferred r6 = r6.zzf()     // Catch: java.lang.Exception -> L52
            r6.complete(r9)     // Catch: java.lang.Exception -> L52
            com.google.android.recaptcha.internal.zzan r9 = r1.zzd     // Catch: java.lang.Exception -> L52
            com.google.android.recaptcha.internal.zzao r6 = com.google.android.recaptcha.internal.zzao.zzc     // Catch: java.lang.Exception -> L52
            com.google.android.recaptcha.internal.zzan.zzh(r9, r6)     // Catch: java.lang.Exception -> L52
            com.google.android.recaptcha.internal.zzen r9 = r1.zze     // Catch: java.lang.Exception -> L52
            r9.zza()     // Catch: java.lang.Exception -> L52
            r9 = r2
            goto L28
        L52:
            r9 = move-exception
            goto L55
        L54:
            return r0
        L55:
            kotlin.jvm.internal.Ref$ObjectRef r6 = r1.zzf
            r6.element = r9
            boolean r6 = r9 instanceof com.google.android.play.core.integrity.StandardIntegrityException
            if (r6 == 0) goto L79
            r6 = r9
            com.google.android.play.core.integrity.StandardIntegrityException r6 = (com.google.android.play.core.integrity.StandardIntegrityException) r6
            int r6 = r6.getErrorCode()
            r7 = -100
            if (r6 == r7) goto L77
            r7 = -18
            if (r6 == r7) goto L77
            r7 = -12
            if (r6 == r7) goto L77
            r7 = -8
            if (r6 == r7) goto L77
            r7 = -3
            if (r6 == r7) goto L77
            goto L79
        L77:
            r6 = r3
            goto L7a
        L79:
            r6 = r2
        L7a:
            if (r6 == 0) goto L90
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r1.zza = r4
            r1.zzb = r3
            r7 = 2
            r1.zzc = r7
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r4, r9)
            if (r9 == r0) goto L8f
            r9 = r6
        L8d:
            long r4 = r4 + r4
            goto L28
        L8f:
            return r0
        L90:
            throw r9
        L91:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzal.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
