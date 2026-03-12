package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzop extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzop> CREATOR = new zzoo();
    public final List<Integer> zza;

    public static zzop zza(zzlu... zzluVarArr) {
        ArrayList arrayList = new ArrayList(zzluVarArr.length);
        for (zzlu zzluVar : zzluVarArr) {
            arrayList.add(Integer.valueOf(zzluVar.zza()));
        }
        return new zzop(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzop(List<Integer> list) {
        this.zza = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
