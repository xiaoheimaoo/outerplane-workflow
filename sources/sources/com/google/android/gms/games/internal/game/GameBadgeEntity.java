package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements Freezable, Parcelable {
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new zza();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final Uri zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameBadgeEntity(int i, String str, String str2, Uri uri) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = uri;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GameBadgeEntity) {
            GameBadgeEntity gameBadgeEntity = (GameBadgeEntity) obj;
            return this.zza == gameBadgeEntity.zza && Objects.equals(this.zzb, gameBadgeEntity.zzb) && Objects.equals(this.zzc, gameBadgeEntity.zzc) && Objects.equals(this.zzd, gameBadgeEntity.zzd);
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return com.google.android.gms.common.internal.Objects.toStringHelper(this).add("Type", Integer.valueOf(this.zza)).add("Title", this.zzb).add("Description", this.zzc).add("IconImageUri", this.zzd).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zza);
            SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
            SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        Uri uri = this.zzd;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}
