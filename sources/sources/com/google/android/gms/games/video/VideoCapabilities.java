package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzg;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class VideoCapabilities extends zzg {
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new zza();
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean[] zzd;
    private final boolean[] zze;

    public VideoCapabilities(boolean z, boolean z2, boolean z3, boolean[] zArr, boolean[] zArr2) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = zArr;
        this.zze = zArr2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof VideoCapabilities) {
            if (this == obj) {
                return true;
            }
            VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
            return Arrays.equals(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && Arrays.equals(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && videoCapabilities.isCameraSupported() == isCameraSupported() && videoCapabilities.isMicSupported() == isMicSupported() && videoCapabilities.isWriteStorageSupported() == isWriteStorageSupported();
        }
        return false;
    }

    public boolean[] getSupportedCaptureModes() {
        return this.zzd;
    }

    public boolean[] getSupportedQualityLevels() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(getSupportedCaptureModes())), Integer.valueOf(Arrays.hashCode(getSupportedQualityLevels())), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public boolean isCameraSupported() {
        return this.zza;
    }

    public boolean isFullySupported(int i, int i2) {
        return this.zza && this.zzb && this.zzc && supportsCaptureMode(i) && supportsQualityLevel(i2);
    }

    public boolean isMicSupported() {
        return this.zzb;
    }

    public boolean isWriteStorageSupported() {
        return this.zzc;
    }

    public boolean supportsCaptureMode(int i) {
        Preconditions.checkState(VideoConfiguration.isValidCaptureMode(i, false));
        return this.zzd[i];
    }

    public boolean supportsQualityLevel(int i) {
        Preconditions.checkState(VideoConfiguration.isValidQualityLevel(i, false));
        return this.zze[i];
    }

    public String toString() {
        return com.google.android.gms.common.internal.Objects.toStringHelper(this).add("SupportedCaptureModes", getSupportedCaptureModes()).add("SupportedQualityLevels", getSupportedQualityLevels()).add("CameraSupported", Boolean.valueOf(isCameraSupported())).add("MicSupported", Boolean.valueOf(isMicSupported())).add("StorageWriteSupported", Boolean.valueOf(isWriteStorageSupported())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isCameraSupported());
        SafeParcelWriter.writeBoolean(parcel, 2, isMicSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, isWriteStorageSupported());
        SafeParcelWriter.writeBooleanArray(parcel, 4, getSupportedCaptureModes(), false);
        SafeParcelWriter.writeBooleanArray(parcel, 5, getSupportedQualityLevels(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
