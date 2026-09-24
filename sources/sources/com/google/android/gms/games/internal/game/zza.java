package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
final class zza extends zzb {
    @Override // com.google.android.gms.games.internal.game.zzb, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.internal.game.zzb
    public final GameBadgeEntity zza(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzp;
        boolean canUnparcelSafely;
        unparcelClientVersion = GameBadgeEntity.getUnparcelClientVersion();
        zzp = GameBadgeEntity.zzp(unparcelClientVersion);
        if (!zzp) {
            canUnparcelSafely = GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                return new GameBadgeEntity(readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
            }
        }
        return super.createFromParcel(parcel);
    }
}
