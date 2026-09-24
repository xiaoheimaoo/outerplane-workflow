package com.google.android.gms.internal.games_v2;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
final class zzbv {
    private final String zza;
    private final Status zzb;

    private zzbv(Status status, String str) {
        this.zzb = status;
        this.zza = str;
    }

    public static zzbv zza(String str) {
        return new zzbv(Status.RESULT_SUCCESS, str);
    }

    public static zzbv zzb(Status status) {
        Preconditions.checkArgument(!status.isSuccess());
        return new zzbv(status, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbv) {
            zzbv zzbvVar = (zzbv) obj;
            return Objects.equals(this.zzb, zzbvVar.zzb) && Objects.equals(this.zza, zzbvVar.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zzb, this.zza);
    }

    public final String toString() {
        return com.google.android.gms.common.internal.Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzb).add("gameRunToken", this.zza).toString();
    }

    public final boolean zzc() {
        return this.zzb.isSuccess();
    }

    public final String zzd() {
        return this.zza;
    }

    public final PendingIntent zze() {
        return this.zzb.getResolution();
    }
}
