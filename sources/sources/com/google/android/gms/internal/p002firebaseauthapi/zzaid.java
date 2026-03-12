package com.google.android.gms.internal.p002firebaseauthapi;

import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1l;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaid  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzaid implements zzaeb {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AFPurchaseConnectorA1l.toJsonMap, this.zza);
        jSONObject.put("returnSecureToken", true);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }

    public zzaid(String str, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
    }
}
