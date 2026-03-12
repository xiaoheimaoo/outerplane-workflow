package com.appsflyer.internal.models;

import android.view.View;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0013\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÇ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007"}, d2 = {"Lcom/appsflyer/internal/models/PrepaidPlan;", "", "", "p0", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/appsflyer/internal/models/PrepaidPlan;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "allowExtendAfterTime", "Ljava/lang/String;", "getAllowExtendAfterTime", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrepaidPlan {
    public static final Companion Companion = new Companion(null);
    private final String allowExtendAfterTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/PrepaidPlan$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/PrepaidPlan;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/PrepaidPlan;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<PrepaidPlan> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static long InAppPurchaseEvent = 7859613101306768189L;
        private static int getOneTimePurchaseOfferDetails = 1;
        private static int getPackageName = -2135458862;
        private static char getQuantity = 31698;
        private static int toJsonMap;

        /* JADX WARN: Multi-variable type inference failed */
        private static void a(String str, String str2, int i, char c, String str3, Object[] objArr) {
            char[] charArray;
            char[] cArr;
            char[] charArray2 = str3 != 0 ? str3.toCharArray() : str3;
            if (str2 == null) {
                charArray = str2;
            } else {
                int i2 = $11 + 83;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                charArray = str2.toCharArray();
            }
            char[] cArr2 = charArray;
            if (!(str != null ? true : true)) {
                int i4 = $10 + 97;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                cArr = str.toCharArray();
            } else {
                cArr = str;
            }
            char[] cArr3 = cArr;
            AFPurchaseConnectorA1i aFPurchaseConnectorA1i = new AFPurchaseConnectorA1i();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr3.length;
            char[] cArr5 = new char[length2];
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr3, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = charArray2.length;
            char[] cArr6 = new char[length3];
            aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails = 0;
            while (aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails < length3) {
                int i6 = $10 + 81;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                int i8 = (aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails + 2) % 4;
                int i9 = (aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails + 3) % 4;
                aFPurchaseConnectorA1i.InAppPurchaseEvent = (char) (((cArr4[aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails % 4] * 32718) + cArr5[i8]) % 65535);
                cArr5[i9] = (char) (((cArr4[i9] * 32718) + cArr5[i8]) / 65535);
                cArr4[i9] = aFPurchaseConnectorA1i.InAppPurchaseEvent;
                cArr6[aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails] = (char) ((((cArr4[i9] ^ charArray2[aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails]) ^ (InAppPurchaseEvent ^ 409721173320367058L)) ^ ((int) (getPackageName ^ 409721173320367058L))) ^ ((char) (getQuantity ^ 409721173320367058L)));
                aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails++;
            }
            String str4 = new String(cArr6);
            int i10 = $10 + 27;
            $11 = i10 % 128;
            if ((i10 % 2 == 0 ? '\t' : (char) 22) == 22) {
                objArr[0] = str4;
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ PrepaidPlan fromJson(JSONObject jSONObject) {
            int i = toJsonMap + 103;
            getOneTimePurchaseOfferDetails = i % 128;
            if (!(i % 2 != 0)) {
                fromJson(jSONObject);
                throw null;
            }
            PrepaidPlan fromJson = fromJson(jSONObject);
            int i2 = toJsonMap + 5;
            getOneTimePurchaseOfferDetails = i2 % 128;
            if ((i2 % 2 == 0 ? '[' : '\r') != '[') {
                return fromJson;
            }
            throw null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final PrepaidPlan fromJson(JSONObject jSONObject) {
            Object nullable;
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a("ჯ뿒歅梽", "⦢ﺳț죽", View.MeasureSpec.getMode(0), (char) View.MeasureSpec.getMode(0), "令됉㰓ⴗ₦臫隣튣頛\ue62fꨁ鳌뺨⋀䚓℃\u19cf\u218f醏䞁", objArr);
            nullable = SubscriptionPurchaseKt.getNullable(jSONObject, ((String) objArr[0]).intern());
            PrepaidPlan prepaidPlan = new PrepaidPlan((String) nullable);
            int i = getOneTimePurchaseOfferDetails + 93;
            toJsonMap = i % 128;
            int i2 = i % 2;
            return prepaidPlan;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PrepaidPlan(String str) {
        this.allowExtendAfterTime = str;
    }

    public final String getAllowExtendAfterTime() {
        return this.allowExtendAfterTime;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PrepaidPlan) && Intrinsics.areEqual(this.allowExtendAfterTime, ((PrepaidPlan) obj).allowExtendAfterTime);
    }

    public final int hashCode() {
        String str = this.allowExtendAfterTime;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return "PrepaidPlan(allowExtendAfterTime=" + this.allowExtendAfterTime + ")";
    }

    public static /* synthetic */ PrepaidPlan copy$default(PrepaidPlan prepaidPlan, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prepaidPlan.allowExtendAfterTime;
        }
        return prepaidPlan.copy(str);
    }

    public final PrepaidPlan copy(String str) {
        return new PrepaidPlan(str);
    }

    public final String component1() {
        return this.allowExtendAfterTime;
    }
}
