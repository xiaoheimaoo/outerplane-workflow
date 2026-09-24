package com.google.android.gms.games.playergameevent;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzg;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class PlayDuration extends zzg {
    public static final Parcelable.Creator<PlayDuration> CREATOR = new zza();
    private final long zza;
    private final int zzb;

    public PlayDuration(long j, int i) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0, "seconds must be non-negative");
        Preconditions.checkArgument((i < 0 || i > 999999999) ? false : z, "nanos must be between 0 and 999,999,999");
        this.zza = j;
        this.zzb = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayDuration) {
            PlayDuration playDuration = (PlayDuration) obj;
            if (this.zza == playDuration.zza && this.zzb == playDuration.zzb) {
                return true;
            }
        }
        return false;
    }

    public int getNanos() {
        return this.zzb;
    }

    public long getSeconds() {
        return this.zza;
    }

    public int hashCode() {
        long j = this.zza;
        return (((int) (j ^ (j >>> 32))) * 31) + this.zzb;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("seconds", Long.valueOf(this.zza)).add("nanos", Integer.valueOf(this.zzb)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getSeconds());
        SafeParcelWriter.writeInt(parcel, 2, getNanos());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
