package com.appsflyer.internal.models;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/CancelSurveyResult;", "", "", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/appsflyer/internal/models/CancelSurveyResult;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "reason", "Ljava/lang/String;", "getReason", "reasonUserInput", "getReasonUserInput", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CancelSurveyResult {
    public static final Companion Companion = new Companion(null);
    private final String reason;
    private final String reasonUserInput;

    public CancelSurveyResult(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.reason = str;
        this.reasonUserInput = str2;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getReasonUserInput() {
        return this.reasonUserInput;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/CancelSurveyResult$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/CancelSurveyResult;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/CancelSurveyResult;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<CancelSurveyResult> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getQuantity = 1;
        private static int toJsonMap;
        private static char[] getPackageName = {50311, 50336, 50308, 50310, 50333, 50331, 50364, 50315, 50330, 50309, 50332, 50313, 50329, 50314, 50312, 50316};
        private static char InAppPurchaseEvent = 61815;

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* synthetic */ CancelSurveyResult fromJson(JSONObject jSONObject) {
            int i = toJsonMap + 123;
            getQuantity = i % 128;
            if ((i % 2 == 0 ? '\\' : '-') != '\\') {
                return fromJson(jSONObject);
            }
            fromJson(jSONObject);
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final CancelSurveyResult fromJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a((byte) (93 - View.resolveSize(0, 0)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6, "\u0007\r\f\n\u0000\u0001", objArr);
            String optString = jSONObject.optString(((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            Object[] objArr2 = new Object[1];
            a((byte) (75 - TextUtils.lastIndexOf("", '0')), TextUtils.indexOf((CharSequence) "", '0') + 16, "\u0007\r\f\n\u0000\u0001\u0004\n\r\u0007\u0002\u0001\u000e\b㘺", objArr2);
            String optString2 = jSONObject.optString(((String) objArr2[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString2, "");
            CancelSurveyResult cancelSurveyResult = new CancelSurveyResult(optString, optString2);
            int i = toJsonMap + 23;
            getQuantity = i % 128;
            if (i % 2 != 0) {
                return cancelSurveyResult;
            }
            throw null;
        }

        private static void a(byte b, int i, String str, Object[] objArr) {
            int i2;
            int i3 = $11;
            int i4 = i3 + 5;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            char[] cArr = str;
            if (str != null) {
                int i6 = i3 + 49;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                cArr = str.toCharArray();
            }
            char[] cArr2 = cArr;
            AFPurchaseConnectorA1k aFPurchaseConnectorA1k = new AFPurchaseConnectorA1k();
            char[] cArr3 = getPackageName;
            if ((cArr3 != null ? (char) 11 : '\'') != '\'') {
                int i8 = $10 + 25;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                int length = cArr3.length;
                char[] cArr4 = new char[length];
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    int i11 = $10 + 41;
                    $11 = i11 % 128;
                    if (!(i11 % 2 != 0)) {
                        cArr4[i10] = (char) (cArr3[i10] ^ (-8783246495946182285L));
                    } else {
                        cArr4[i10] = (char) (cArr3[i10] ^ (-8783246495946182285L));
                    }
                    i10++;
                }
                cArr3 = cArr4;
            }
            char c = (char) (InAppPurchaseEvent ^ (-8783246495946182285L));
            char[] cArr5 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr5[i2] = (char) (cArr2[i2] - b);
            } else {
                i2 = i;
            }
            if ((i2 > 1 ? 'b' : '3') == 'b') {
                int i12 = $11 + 19;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                aFPurchaseConnectorA1k.getQuantity = 0;
                while (aFPurchaseConnectorA1k.getQuantity < i2) {
                    aFPurchaseConnectorA1k.getPackageName = cArr2[aFPurchaseConnectorA1k.getQuantity];
                    aFPurchaseConnectorA1k.getOneTimePurchaseOfferDetails = cArr2[aFPurchaseConnectorA1k.getQuantity + 1];
                    if (aFPurchaseConnectorA1k.getPackageName == aFPurchaseConnectorA1k.getOneTimePurchaseOfferDetails) {
                        cArr5[aFPurchaseConnectorA1k.getQuantity] = (char) (aFPurchaseConnectorA1k.getPackageName - b);
                        cArr5[aFPurchaseConnectorA1k.getQuantity + 1] = (char) (aFPurchaseConnectorA1k.getOneTimePurchaseOfferDetails - b);
                    } else {
                        aFPurchaseConnectorA1k.InAppPurchaseEvent = aFPurchaseConnectorA1k.getPackageName / c;
                        aFPurchaseConnectorA1k.hashCode = aFPurchaseConnectorA1k.getPackageName % c;
                        aFPurchaseConnectorA1k.toJsonMap = aFPurchaseConnectorA1k.getOneTimePurchaseOfferDetails / c;
                        aFPurchaseConnectorA1k.stopObservingTransactions = aFPurchaseConnectorA1k.getOneTimePurchaseOfferDetails % c;
                        if (aFPurchaseConnectorA1k.hashCode == aFPurchaseConnectorA1k.stopObservingTransactions) {
                            aFPurchaseConnectorA1k.InAppPurchaseEvent = ((aFPurchaseConnectorA1k.InAppPurchaseEvent + c) - 1) % c;
                            aFPurchaseConnectorA1k.toJsonMap = ((aFPurchaseConnectorA1k.toJsonMap + c) - 1) % c;
                            int i14 = (aFPurchaseConnectorA1k.InAppPurchaseEvent * c) + aFPurchaseConnectorA1k.hashCode;
                            int i15 = (aFPurchaseConnectorA1k.toJsonMap * c) + aFPurchaseConnectorA1k.stopObservingTransactions;
                            cArr5[aFPurchaseConnectorA1k.getQuantity] = cArr3[i14];
                            cArr5[aFPurchaseConnectorA1k.getQuantity + 1] = cArr3[i15];
                        } else if ((aFPurchaseConnectorA1k.InAppPurchaseEvent == aFPurchaseConnectorA1k.toJsonMap ? 'L' : '?') != '?') {
                            aFPurchaseConnectorA1k.hashCode = ((aFPurchaseConnectorA1k.hashCode + c) - 1) % c;
                            aFPurchaseConnectorA1k.stopObservingTransactions = ((aFPurchaseConnectorA1k.stopObservingTransactions + c) - 1) % c;
                            int i16 = (aFPurchaseConnectorA1k.InAppPurchaseEvent * c) + aFPurchaseConnectorA1k.hashCode;
                            int i17 = (aFPurchaseConnectorA1k.toJsonMap * c) + aFPurchaseConnectorA1k.stopObservingTransactions;
                            cArr5[aFPurchaseConnectorA1k.getQuantity] = cArr3[i16];
                            cArr5[aFPurchaseConnectorA1k.getQuantity + 1] = cArr3[i17];
                        } else {
                            int i18 = (aFPurchaseConnectorA1k.InAppPurchaseEvent * c) + aFPurchaseConnectorA1k.stopObservingTransactions;
                            int i19 = (aFPurchaseConnectorA1k.toJsonMap * c) + aFPurchaseConnectorA1k.hashCode;
                            cArr5[aFPurchaseConnectorA1k.getQuantity] = cArr3[i18];
                            cArr5[aFPurchaseConnectorA1k.getQuantity + 1] = cArr3[i19];
                        }
                    }
                    aFPurchaseConnectorA1k.getQuantity += 2;
                }
            }
            for (int i20 = 0; i20 < i; i20++) {
                cArr5[i20] = (char) (cArr5[i20] ^ 13722);
            }
            objArr[0] = new String(cArr5);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CancelSurveyResult) {
            CancelSurveyResult cancelSurveyResult = (CancelSurveyResult) obj;
            return Intrinsics.areEqual(this.reason, cancelSurveyResult.reason) && Intrinsics.areEqual(this.reasonUserInput, cancelSurveyResult.reasonUserInput);
        }
        return false;
    }

    public final int hashCode() {
        return (this.reason.hashCode() * 31) + this.reasonUserInput.hashCode();
    }

    public final String toString() {
        String str = this.reason;
        return "CancelSurveyResult(reason=" + str + ", reasonUserInput=" + this.reasonUserInput + ")";
    }

    public static /* synthetic */ CancelSurveyResult copy$default(CancelSurveyResult cancelSurveyResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelSurveyResult.reason;
        }
        if ((i & 2) != 0) {
            str2 = cancelSurveyResult.reasonUserInput;
        }
        return cancelSurveyResult.copy(str, str2);
    }

    public final CancelSurveyResult copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new CancelSurveyResult(str, str2);
    }

    public final String component2() {
        return this.reasonUserInput;
    }

    public final String component1() {
        return this.reason;
    }
}
