package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final class zzer extends SuspendLambda implements Function2 {
    final /* synthetic */ zzes zza;
    final /* synthetic */ zztx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzer(zzes zzesVar, zztx zztxVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzesVar;
        this.zzb = zztxVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzer(this.zza, this.zzb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzer) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        zzei zzeiVar;
        zzei zzeiVar2;
        zzei zzeiVar3;
        zzei zzeiVar4;
        zzei zzeiVar5;
        zzei zzeiVar6;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zztx zztxVar = this.zzb;
        zzes zzesVar = this.zza;
        synchronized (zzeo.class) {
            zzeiVar = zzesVar.zze;
            if (zzeiVar != null) {
                byte[] zzd = zztxVar.zzd();
                zzej zzejVar = new zzej(zzkh.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
                zzeiVar2 = zzesVar.zze;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ss", zzejVar.zzc());
                contentValues.put("ts", Long.valueOf(zzejVar.zzb()));
                zzeiVar2.getWritableDatabase().insert("ce", null, contentValues);
                zzeiVar3 = zzesVar.zze;
                int zzb = zzeiVar3.zzb() - 500;
                if (zzb > 0) {
                    zzeiVar5 = zzesVar.zze;
                    List take = CollectionsKt.take(zzeiVar5.zzd(), zzb);
                    zzeiVar6 = zzesVar.zze;
                    zzeiVar6.zza(take);
                }
                zzeiVar4 = zzesVar.zze;
                if (zzeiVar4.zzb() >= 20) {
                    zzesVar.zzg();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
