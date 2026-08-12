package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.games_v2.zzfx;
import com.google.android.gms.internal.games_v2.zzgj;
import com.google.android.gms.internal.games_v2.zzgm;
import com.google.android.gms.internal.games_v2.zzhc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes.dex */
public final class zze extends zzf {
    private final Context zza;

    public zze(Context context) {
        super(null);
        this.zza = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzg zzc(zzgm zzgmVar, zzgm zzgmVar2, Task task) {
        if (task.isSuccessful()) {
            return (zzg) task.getResult();
        }
        return zze(zzgmVar, zzgmVar2);
    }

    private static zzg zze(zzgm zzgmVar, zzgm zzgmVar2) {
        return new zzg(zzf(zzgmVar), zzgm.zzg(), zzf(zzgmVar2), zzgm.zzg());
    }

    private static zzgm zzf(zzgm zzgmVar) {
        int i = zzgm.zzd;
        zzgj zzgjVar = new zzgj();
        int size = zzgmVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            String zza = ((zzi) zzgmVar.get(i2)).zza();
            if (zza != null) {
                zzgjVar.zzb(zza);
            }
        }
        return zzgjVar.zzc();
    }

    private static zzgm zzg(List list) {
        int i = zzgm.zzd;
        zzgj zzgjVar = new zzgj();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
            if (!shortcutInfo.isImmutable() && shortcutInfo.getId().startsWith("PLAY_GAMES_SERVICES_")) {
                zzgjVar.zzb(new zzi(shortcutInfo.getId(), shortcutInfo.getExtras(), Boolean.valueOf(shortcutInfo.isPinned()), Boolean.valueOf(shortcutInfo.isEnabled())));
            }
        }
        return zzgjVar.zzc();
    }

    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzf
    public final void zza() {
        zzfx.zza();
        new Thread(new Runnable() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zze.this.zzb();
            }
        }, "initialize-shortcuts").start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        Task forResult;
        Context context = this.zza;
        final ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            return;
        }
        final zzr zza = zzt.zza(context, PlayGamesAppShortcutsActivity.class);
        final zzgm zzg = zzg(shortcutManager.getDynamicShortcuts());
        final zzgm zzg2 = zzg(shortcutManager.getPinnedShortcuts());
        if (zza == null || zza.zza() <= 0) {
            forResult = Tasks.forResult(zze(zzg, zzg2));
        } else {
            final zzq zzqVar = new zzq(context);
            forResult = zzqVar.doRead(TaskApiCall.builder().setMethodKey(6744).setFeatures(com.google.android.gms.games.zzd.zzg).setAutoResolveMissingFeatures(false).run(new RemoteCall() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzp
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj, Object obj2) {
                    ((zzv) ((zzu) obj).getService()).zzd(new zzl(zzq.this, (TaskCompletionSource) obj2), zza, zzg, zzg2);
                }
            }).build()).continueWith(zzhc.zza(), new Continuation() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzc
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return zze.zzc(zzgm.this, zzg2, task);
                }
            });
        }
        forResult.addOnSuccessListener(zzhc.zza(), new OnSuccessListener() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzb
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                zzg zzgVar = (zzg) obj;
                List<String> zza2 = zzgVar.zza();
                ShortcutManager shortcutManager2 = shortcutManager;
                if (zza2 != null && !zza2.isEmpty()) {
                    shortcutManager2.removeDynamicShortcuts(zza2);
                }
                List<ShortcutInfo> zzb = zzgVar.zzb();
                if (zzb != null && !zzb.isEmpty()) {
                    shortcutManager2.addDynamicShortcuts(zzb);
                }
                List<String> zzc = zzgVar.zzc();
                if (zzc != null && !zzc.isEmpty()) {
                    shortcutManager2.disableShortcuts(zzc);
                }
                List<String> zzd = zzgVar.zzd();
                if (zzd == null || zzd.isEmpty()) {
                    return;
                }
                shortcutManager2.enableShortcuts(zzd);
            }
        });
    }
}
