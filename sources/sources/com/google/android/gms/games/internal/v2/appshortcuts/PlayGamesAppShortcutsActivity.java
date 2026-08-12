package com.google.android.gms.games.internal.v2.appshortcuts;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.Log;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.games_v2.zzfy;
import com.google.android.gms.internal.games_v2.zzgj;
import com.google.android.gms.internal.games_v2.zzgm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes.dex */
public final class PlayGamesAppShortcutsActivity extends Activity {
    private Intent zza;

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1005000000) {
            return;
        }
        if (i2 == -1) {
            new zzfy(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    PlayGamesAppShortcutsActivity.this.zza();
                }
            }, 50L);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        int componentEnabledSetting;
        Intent intent;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 25) {
            finish();
            return;
        }
        final zzr zza = zzt.zza(this, PlayGamesAppShortcutsActivity.class);
        if (zza == null) {
            finish();
            return;
        }
        String zzb = zza.zzb();
        if (zzb == null || zzb.isEmpty()) {
            List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(getPackageName()), 795136);
            int i = zzgm.zzd;
            zzgj zzgjVar = new zzgj();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if ((activityInfo != null && ((componentEnabledSetting = getPackageManager().getComponentEnabledSetting(new ComponentName(activityInfo.packageName, activityInfo.name))) != 0 ? componentEnabledSetting == 1 : activityInfo.enabled)) && resolveInfo.activityInfo.exported) {
                    zzgjVar.zzb(resolveInfo);
                }
            }
            zzgm zzc = zzgjVar.zzc();
            int size = zzc.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    zzb = null;
                    break;
                }
                ActivityInfo activityInfo2 = ((ResolveInfo) zzc.get(i2)).activityInfo;
                i2++;
                if (activityInfo2 != null) {
                    zzb = activityInfo2.name;
                    break;
                }
            }
        }
        if (zzb == null || zzb.isEmpty()) {
            intent = null;
        } else {
            String packageName = getPackageName();
            intent = new Intent().setComponent(new ComponentName(packageName, zzb)).setPackage(packageName).addFlags(335577088);
        }
        if (intent == null) {
            finish();
            return;
        }
        this.zza = intent;
        final zzq zzqVar = new zzq((Activity) this);
        Intent intent2 = getIntent();
        final zzi zziVar = new zzi(intent2.getStringExtra("com.google.android.gms.games.EXTRA_APP_SHORTCUT_ID"), (PersistableBundle) intent2.getParcelableExtra("com.google.android.gms.games.EXTRA_APP_SHORTCUT_EXTRAS"), null, true);
        zzqVar.doRead(TaskApiCall.builder().setMethodKey(6745).setFeatures(com.google.android.gms.games.zzd.zzg).setAutoResolveMissingFeatures(false).run(new RemoteCall() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzo
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zzv) ((zzu) obj).getService()).zze(new zzm(zzq.this, (TaskCompletionSource) obj2), zza, zziVar);
            }
        }).build()).addOnCompleteListener(this, new OnCompleteListener() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzz
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity = PlayGamesAppShortcutsActivity.this;
                if (!task.isSuccessful()) {
                    Log.e("PGShortcutsActivity", "Failed to access intent.", task.getException());
                    playGamesAppShortcutsActivity.finish();
                    return;
                }
                playGamesAppShortcutsActivity.startActivityForResult((Intent) task.getResult(), 1005000000);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza() {
        startActivityForResult(this.zza, 1005000001);
        finish();
        System.exit(0);
    }
}
