package com.google.android.gms.internal.p002firebaseauthapi;

import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1l;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahf  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class zzahf implements zzaeb {
    public static zzahi zzg() {
        return new zzafs();
    }

    public abstract zzagh zzb();

    public abstract String zzc();

    public abstract String zzd();

    public abstract String zze();

    public abstract String zzf();

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", zzc());
        jSONObject.put(AFPurchaseConnectorA1l.toJsonMap, zzf());
        jSONObject.put("providerId", zzd());
        jSONObject.put("tokenType", zzb().toString());
        jSONObject.put("tenantId", zze());
        return jSONObject.toString();
    }
}
