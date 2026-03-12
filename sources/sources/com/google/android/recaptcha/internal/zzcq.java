package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutCancellationException;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzcq {
    private static zzcv zza;

    public static final zzcv zza(Application application) {
        zzcv zzcvVar = zza;
        if (zzcvVar == null) {
            zzcvVar = new zzcv(application);
        }
        if (zza == null) {
            zza = zzcvVar;
        }
        return zzcvVar;
    }

    public static final Object zzb(Application application, String str, long j, Continuation continuation) throws TimeoutCancellationException, ApiException, RecaptchaException {
        return zzcv.zzh(zza(application), str, j, null, null, null, continuation, 28, null);
    }

    public static final Task zzc(Application application, String str, long j) throws TimeoutCancellationException, ApiException, RecaptchaException {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(zza(application).zzd().zza(), null, null, new zzco(application, str, j, null), 3, null);
        return zzas.zza(async$default);
    }

    public static final Object zzd(Application application, String str, Continuation continuation) throws ApiException, RecaptchaException {
        return zzcv.zzf(zza(application), str, null, null, continuation, 6, null);
    }

    public static final Task zze(Application application, String str) throws ApiException, RecaptchaException {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(zza(application).zzd().zza(), null, null, new zzcp(application, str, null), 3, null);
        return zzas.zza(async$default);
    }
}
