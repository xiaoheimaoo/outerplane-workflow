package com.appsflyer.internal.models;

import android.graphics.Color;
import android.telephony.cdma.CdmaCellLocation;
import android.view.ViewConfiguration;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÇ\u0003¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/models/UserInitiatedCancellation;", "", "Lcom/appsflyer/internal/models/CancelSurveyResult;", "p0", "", "p1", "<init>", "(Lcom/appsflyer/internal/models/CancelSurveyResult;Ljava/lang/String;)V", "component1", "()Lcom/appsflyer/internal/models/CancelSurveyResult;", "component2", "()Ljava/lang/String;", "copy", "(Lcom/appsflyer/internal/models/CancelSurveyResult;Ljava/lang/String;)Lcom/appsflyer/internal/models/UserInitiatedCancellation;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "cancelSurveyResult", "Lcom/appsflyer/internal/models/CancelSurveyResult;", "getCancelSurveyResult", "cancelTime", "Ljava/lang/String;", "getCancelTime", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UserInitiatedCancellation {
    public static final Companion Companion = new Companion(null);
    private final CancelSurveyResult cancelSurveyResult;
    private final String cancelTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/UserInitiatedCancellation$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/UserInitiatedCancellation;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/UserInitiatedCancellation;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<UserInitiatedCancellation> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int InAppPurchaseEvent = 1;
        private static long getOneTimePurchaseOfferDetails = 409721173320367058L;
        private static int getPackageName = 0;
        private static int getQuantity = -2135458862;
        private static char toJsonMap = 40031;

        /* JADX WARN: Multi-variable type inference failed */
        private static void a(String str, String str2, int i, char c, String str3, Object[] objArr) {
            char[] cArr;
            int i2 = $11 + 83;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            char[] charArray = (str3 != 0 ? ':' : '3') != ':' ? str3 : str3.toCharArray();
            char[] charArray2 = str2 != null ? str2.toCharArray() : str2;
            if ((str != null ? '_' : 'V') != 'V') {
                cArr = str.toCharArray();
                int i4 = $10 + 75;
                $11 = i4 % 128;
                int i5 = i4 % 2;
            } else {
                cArr = str;
            }
            char[] cArr2 = cArr;
            AFPurchaseConnectorA1i aFPurchaseConnectorA1i = new AFPurchaseConnectorA1i();
            int length = charArray2.length;
            char[] cArr3 = new char[length];
            int length2 = cArr2.length;
            char[] cArr4 = new char[length2];
            System.arraycopy(charArray2, 0, cArr3, 0, length);
            System.arraycopy(cArr2, 0, cArr4, 0, length2);
            cArr3[0] = (char) (cArr3[0] ^ c);
            cArr4[2] = (char) (cArr4[2] + ((char) i));
            int length3 = charArray.length;
            char[] cArr5 = new char[length3];
            aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails = 0;
            while (aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails < length3) {
                int i6 = $11 + 59;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                int i8 = (aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails + 2) % 4;
                int i9 = (aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails + 3) % 4;
                aFPurchaseConnectorA1i.InAppPurchaseEvent = (char) (((cArr3[aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails % 4] * 32718) + cArr4[i8]) % 65535);
                cArr4[i9] = (char) (((cArr3[i9] * 32718) + cArr4[i8]) / 65535);
                cArr3[i9] = aFPurchaseConnectorA1i.InAppPurchaseEvent;
                cArr5[aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails] = (char) ((((cArr3[i9] ^ charArray[aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails]) ^ (getOneTimePurchaseOfferDetails ^ 409721173320367058L)) ^ ((int) (getQuantity ^ 409721173320367058L))) ^ ((char) (toJsonMap ^ 409721173320367058L)));
                aFPurchaseConnectorA1i.getOneTimePurchaseOfferDetails++;
            }
            objArr[0] = new String(cArr5);
        }

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* synthetic */ UserInitiatedCancellation fromJson(JSONObject jSONObject) {
            int i = getPackageName + 99;
            InAppPurchaseEvent = i % 128;
            if ((i % 2 == 0 ? 'C' : 'F') == 'F') {
                return fromJson(jSONObject);
            }
            fromJson(jSONObject);
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final UserInitiatedCancellation fromJson(JSONObject jSONObject) {
            Object object;
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a("\u0000\u0000\u0000\u0000", "㐞ᩔ叨즪", (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 43603), "Гꪇ\uf27f遣噋ꏅ漕홚\ue953芯滀觲未昔ன㋸\uf37b\uea98", objArr);
            object = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr[0]).intern(), CancelSurveyResult.Companion);
            Object[] objArr2 = new Object[1];
            a("\u0000\u0000\u0000\u0000", "瀋뚃텣ꢺ", ViewConfiguration.getPressedStateDuration() >> 16, (char) Color.blue(0), "㈧渨\udcc0捹⋠鲊욢\ue3b0̈軧", objArr2);
            String optString = jSONObject.optString(((String) objArr2[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            UserInitiatedCancellation userInitiatedCancellation = new UserInitiatedCancellation((CancelSurveyResult) object, optString);
            int i = InAppPurchaseEvent + 103;
            getPackageName = i % 128;
            int i2 = i % 2;
            return userInitiatedCancellation;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UserInitiatedCancellation(CancelSurveyResult cancelSurveyResult, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cancelSurveyResult = cancelSurveyResult;
        this.cancelTime = str;
    }

    public final CancelSurveyResult getCancelSurveyResult() {
        return this.cancelSurveyResult;
    }

    public final String getCancelTime() {
        return this.cancelTime;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserInitiatedCancellation) {
            UserInitiatedCancellation userInitiatedCancellation = (UserInitiatedCancellation) obj;
            return Intrinsics.areEqual(this.cancelSurveyResult, userInitiatedCancellation.cancelSurveyResult) && Intrinsics.areEqual(this.cancelTime, userInitiatedCancellation.cancelTime);
        }
        return false;
    }

    public final int hashCode() {
        CancelSurveyResult cancelSurveyResult = this.cancelSurveyResult;
        return ((cancelSurveyResult == null ? 0 : cancelSurveyResult.hashCode()) * 31) + this.cancelTime.hashCode();
    }

    public final String toString() {
        CancelSurveyResult cancelSurveyResult = this.cancelSurveyResult;
        return "UserInitiatedCancellation(cancelSurveyResult=" + cancelSurveyResult + ", cancelTime=" + this.cancelTime + ")";
    }

    public static /* synthetic */ UserInitiatedCancellation copy$default(UserInitiatedCancellation userInitiatedCancellation, CancelSurveyResult cancelSurveyResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            cancelSurveyResult = userInitiatedCancellation.cancelSurveyResult;
        }
        if ((i & 2) != 0) {
            str = userInitiatedCancellation.cancelTime;
        }
        return userInitiatedCancellation.copy(cancelSurveyResult, str);
    }

    public final UserInitiatedCancellation copy(CancelSurveyResult cancelSurveyResult, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new UserInitiatedCancellation(cancelSurveyResult, str);
    }

    public final String component2() {
        return this.cancelTime;
    }

    public final CancelSurveyResult component1() {
        return this.cancelSurveyResult;
    }
}
