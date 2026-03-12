package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzlk implements Application.ActivityLifecycleCallbacks, zzll {
    private final /* synthetic */ zzju zza;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc A[Catch: RuntimeException -> 0x0167, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0167, blocks: (B:3:0x000b, B:31:0x0095, B:33:0x00a3, B:36:0x00b0, B:38:0x00b6, B:39:0x00c9, B:40:0x00d5, B:43:0x00dc, B:47:0x00ff, B:49:0x011b, B:48:0x010c, B:51:0x0122, B:53:0x0128, B:55:0x012e, B:57:0x0134, B:59:0x013a, B:61:0x0142, B:65:0x014d, B:67:0x015b, B:69:0x0161, B:7:0x0025, B:9:0x002b, B:11:0x0033, B:13:0x0039, B:15:0x003f, B:17:0x0045, B:19:0x004d, B:21:0x0055, B:23:0x005d, B:25:0x0065, B:26:0x0071, B:28:0x008a), top: B:74:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void zza(com.google.android.gms.measurement.internal.zzlk r17, boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlk.zza(com.google.android.gms.measurement.internal.zzlk, boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlk(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzeb.zza(activity), bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        try {
            this.zza.zzj().zzq().zza("onActivityCreated");
            Intent intent = zzebVar.zzc;
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data == null || !data.isHierarchical()) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (!TextUtils.isEmpty(string)) {
                        data = Uri.parse(string);
                    }
                }
                data = null;
            }
            Uri uri = data;
            if (uri != null && uri.isHierarchical()) {
                this.zza.zzs();
                this.zza.zzl().zzb(new zzln(this, bundle == null, uri, zzpn.zza(intent) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, uri.getQueryParameter("referrer")));
            }
        } catch (RuntimeException e) {
            this.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzp().zza(zzebVar, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        this.zza.zzp().zza(zzebVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        this.zza.zzp().zzb(zzebVar);
        zznx zzr = this.zza.zzr();
        zzr.zzl().zzb(new zznz(zzr, zzr.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzc(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        zznx zzr = this.zza.zzr();
        zzr.zzl().zzb(new zznw(zzr, zzr.zzb().elapsedRealtime()));
        this.zza.zzp().zzc(zzebVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzb(com.google.android.gms.internal.measurement.zzeb.zza(activity), bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        this.zza.zzp().zzb(zzebVar, bundle);
    }
}
