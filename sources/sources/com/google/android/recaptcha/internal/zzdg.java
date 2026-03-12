package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzdg extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzdt zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzsp zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(zzdt zzdtVar, String str, long j, zzsp zzspVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzdtVar;
        this.zzd = str;
        this.zze = j;
        this.zzf = zzspVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzdg(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdg) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        zzek zzu;
        zzen zzenVar;
        Exception e;
        TimeoutCancellationException e2;
        zzbd e3;
        zzbd zzs;
        zzbd zzs2;
        zzbd zzs3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.zzb != 0) {
            zzenVar = (zzen) this.zza;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (zzbd e4) {
                e3 = e4;
                zzs3 = this.zzc.zzs(e3, e3);
                zzenVar.zzb(zzs3);
                throw zzs3;
            } catch (TimeoutCancellationException e5) {
                e2 = e5;
                zzs2 = this.zzc.zzs(e2, new zzbd(zzbb.zzc, zzba.zzb, e2.getMessage()));
                zzenVar.zzb(zzs2);
                throw zzs2;
            } catch (Exception e6) {
                e = e6;
                zzs = this.zzc.zzs(e, new zzbd(zzbb.zzc, zzba.zzZ, e.getMessage()));
                zzenVar.zzb(zzs);
                throw zzs;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            zzu = this.zzc.zzu(this.zzd);
            zzen zzf = zzu.zzf(28);
            try {
                this.zza = zzf;
                this.zzb = 1;
                Object withTimeout = TimeoutKt.withTimeout(this.zze, new zzdf(this.zzc, this.zzf, zzf, null), this);
                if (withTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzenVar = zzf;
                obj = withTimeout;
            } catch (zzbd e7) {
                zzenVar = zzf;
                e3 = e7;
                zzs3 = this.zzc.zzs(e3, e3);
                zzenVar.zzb(zzs3);
                throw zzs3;
            } catch (TimeoutCancellationException e8) {
                zzenVar = zzf;
                e2 = e8;
                zzs2 = this.zzc.zzs(e2, new zzbd(zzbb.zzc, zzba.zzb, e2.getMessage()));
                zzenVar.zzb(zzs2);
                throw zzs2;
            } catch (Exception e9) {
                zzenVar = zzf;
                e = e9;
                zzs = this.zzc.zzs(e, new zzbd(zzbb.zzc, zzba.zzZ, e.getMessage()));
                zzenVar.zzb(zzs);
                throw zzs;
            }
        }
        return (zzsr) obj;
    }
}
