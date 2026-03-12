package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.helpshift.user.UserConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagw  reason: invalid package */
/* loaded from: classes2.dex */
public class zzagw extends AbstractSafeParcelable implements zzaea<zzagw> {
    public static final Parcelable.Creator<zzagw> CREATOR = new zzagv();
    private static final String zza = "zzagw";
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;

    public final long zza() {
        Long l = this.zzd;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final long zzb() {
        return this.zzf.longValue();
    }

    public static zzagw zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzagw zzagwVar = new zzagw();
            zzagwVar.zzb = jSONObject.optString(UserConstants.REFRESH_TOKEN, null);
            zzagwVar.zzc = jSONObject.optString(UserConstants.ACCESS_TOKEN, null);
            zzagwVar.zzd = Long.valueOf(jSONObject.optLong("expires_in"));
            zzagwVar.zze = jSONObject.optString("token_type", null);
            zzagwVar.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzagwVar;
        } catch (JSONException e) {
            Log.d(zza, "Failed to read GetTokenResponse from JSONObject");
            throw new zzzp(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* renamed from: zzd */
    public final zzagw zza(String str) throws zzabr {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString(UserConstants.REFRESH_TOKEN));
            this.zzc = Strings.emptyToNull(jSONObject.optString(UserConstants.ACCESS_TOKEN));
            this.zzd = Long.valueOf(jSONObject.optLong("expires_in", 0L));
            this.zze = Strings.emptyToNull(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UserConstants.REFRESH_TOKEN, this.zzb);
            jSONObject.put(UserConstants.ACCESS_TOKEN, this.zzc);
            jSONObject.put("expires_in", this.zzd);
            jSONObject.put("token_type", this.zze);
            jSONObject.put("issued_at", this.zzf);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d(zza, "Failed to convert GetTokenResponse to JSON");
            throw new zzzp(e);
        }
    }

    public zzagw() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    public zzagw(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagw(String str, String str2, Long l, String str3, Long l2) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l;
        this.zze = str3;
        this.zzf = l2;
    }

    public final void zzc(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLongObject(parcel, 4, Long.valueOf(zza()), false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeLongObject(parcel, 6, Long.valueOf(this.zzf.longValue()), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzg() {
        return DefaultClock.getInstance().currentTimeMillis() + PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS < this.zzf.longValue() + (this.zzd.longValue() * 1000);
    }
}
