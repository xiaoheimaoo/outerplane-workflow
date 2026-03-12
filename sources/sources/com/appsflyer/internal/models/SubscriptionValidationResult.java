package com.appsflyer.internal.models;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1g;
import com.appsflyer.internal.models.SubscriptionPurchase;
import com.appsflyer.internal.models.ValidationFailureData;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004HÇ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÇ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u001a\u0010 \u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/models/SubscriptionValidationResult;", "", "", "p0", "Lcom/appsflyer/internal/models/SubscriptionPurchase;", "p1", "Lcom/appsflyer/internal/models/ValidationFailureData;", "p2", "<init>", "(ZLcom/appsflyer/internal/models/SubscriptionPurchase;Lcom/appsflyer/internal/models/ValidationFailureData;)V", "component1", "()Z", "component2", "()Lcom/appsflyer/internal/models/SubscriptionPurchase;", "component3", "()Lcom/appsflyer/internal/models/ValidationFailureData;", "copy", "(ZLcom/appsflyer/internal/models/SubscriptionPurchase;Lcom/appsflyer/internal/models/ValidationFailureData;)Lcom/appsflyer/internal/models/SubscriptionValidationResult;", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "failureData", "Lcom/appsflyer/internal/models/ValidationFailureData;", "getFailureData", "subscriptionPurchase", "Lcom/appsflyer/internal/models/SubscriptionPurchase;", "getSubscriptionPurchase", FirebaseAnalytics.Param.SUCCESS, "Z", "getSuccess", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionValidationResult {
    public static final Companion Companion = new Companion(null);
    private final ValidationFailureData failureData;
    private final SubscriptionPurchase subscriptionPurchase;
    private final boolean success;

    public SubscriptionValidationResult(boolean z, SubscriptionPurchase subscriptionPurchase, ValidationFailureData validationFailureData) {
        this.success = z;
        this.subscriptionPurchase = subscriptionPurchase;
        this.failureData = validationFailureData;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final SubscriptionPurchase getSubscriptionPurchase() {
        return this.subscriptionPurchase;
    }

    public final ValidationFailureData getFailureData() {
        return this.failureData;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/SubscriptionValidationResult$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/SubscriptionValidationResult;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/SubscriptionValidationResult;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<SubscriptionValidationResult> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int InAppPurchaseEvent = 1;
        private static long getPackageName = -9203480607422290978L;
        private static int getQuantity;

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* synthetic */ SubscriptionValidationResult fromJson(JSONObject jSONObject) {
            int i = InAppPurchaseEvent + 107;
            getQuantity = i % 128;
            int i2 = i % 2;
            SubscriptionValidationResult fromJson = fromJson(jSONObject);
            int i3 = getQuantity + 119;
            InAppPurchaseEvent = i3 % 128;
            if (i3 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        @JvmStatic
        public final SubscriptionValidationResult fromJson(JSONObject jSONObject) {
            SubscriptionPurchase subscriptionPurchase;
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a("丄\ued12ࠇ꜀숞愇", TextUtils.indexOf((CharSequence) "", '0') + 41730, objArr);
            boolean optBoolean = jSONObject.optBoolean(((String) objArr[0]).intern());
            Object[] objArr2 = new Object[1];
            a("丅촘䠢읔䉹솃岽\udbbb囚헬儗\uec31歭\ue659敹\ue091羥𥉉秱\uf504瀏", 33563 - Drawable.resolveOpacity(0, 0), objArr2);
            ValidationFailureData validationFailureData = null;
            if ((jSONObject.has(((String) objArr2[0]).intern()) ? (char) 26 : (char) 2) != 2) {
                SubscriptionPurchase.Companion companion = SubscriptionPurchase.Companion;
                Object[] objArr3 = new Object[1];
                a("丅촘䠢읔䉹솃岽\udbbb囚헬儗\uec31歭\ue659敹\ue091羥𥉉秱\uf504瀏", 33563 - (ViewConfiguration.getEdgeSlop() >> 16), objArr3);
                JSONObject jSONObject2 = jSONObject.getJSONObject(((String) objArr3[0]).intern());
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "");
                subscriptionPurchase = companion.fromJson(jSONObject2);
            } else {
                subscriptionPurchase = null;
            }
            Object[] objArr4 = new Object[1];
            a("丐톴煙郳わ倫\uf3c1\u135c댊튬牜鈖", TextUtils.lastIndexOf("", '0', 0, 0) + 40868, objArr4);
            if ((jSONObject.has(((String) objArr4[0]).intern()) ? '#' : '[') == '#') {
                ValidationFailureData.Companion companion2 = ValidationFailureData.Companion;
                Object[] objArr5 = new Object[1];
                a("丐톴煙郳わ倫\uf3c1\u135c댊튬牜鈖", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 40867, objArr5);
                JSONObject jSONObject3 = jSONObject.getJSONObject(((String) objArr5[0]).intern());
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "");
                validationFailureData = companion2.fromJson(jSONObject3);
            } else {
                int i = InAppPurchaseEvent + 123;
                getQuantity = i % 128;
                int i2 = i % 2;
            }
            SubscriptionValidationResult subscriptionValidationResult = new SubscriptionValidationResult(optBoolean, subscriptionPurchase, validationFailureData);
            int i3 = InAppPurchaseEvent + 69;
            getQuantity = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int i4 = 7 / 0;
                return subscriptionValidationResult;
            }
            return subscriptionValidationResult;
        }

        private static void a(String str, int i, Object[] objArr) {
            char[] cArr;
            int i2;
            if (str != null) {
                int i3 = $10 + 95;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                cArr = str.toCharArray();
            } else {
                cArr = str;
            }
            char[] cArr2 = cArr;
            AFPurchaseConnectorA1g aFPurchaseConnectorA1g = new AFPurchaseConnectorA1g();
            aFPurchaseConnectorA1g.getPackageName = i;
            int length = cArr2.length;
            long[] jArr = new long[length];
            aFPurchaseConnectorA1g.InAppPurchaseEvent = 0;
            while (true) {
                if (!(aFPurchaseConnectorA1g.InAppPurchaseEvent < cArr2.length)) {
                    break;
                }
                int i5 = $10 + 65;
                $11 = i5 % 128;
                if (i5 % 2 == 0) {
                    jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] = (cArr2[aFPurchaseConnectorA1g.InAppPurchaseEvent] + (aFPurchaseConnectorA1g.InAppPurchaseEvent * aFPurchaseConnectorA1g.getPackageName)) ^ (5319290379872349608L & getPackageName);
                    i2 = aFPurchaseConnectorA1g.InAppPurchaseEvent >> 0;
                } else {
                    jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] = (5319290379872349608L ^ getPackageName) ^ (cArr2[aFPurchaseConnectorA1g.InAppPurchaseEvent] ^ (aFPurchaseConnectorA1g.InAppPurchaseEvent * aFPurchaseConnectorA1g.getPackageName));
                    i2 = aFPurchaseConnectorA1g.InAppPurchaseEvent + 1;
                }
                aFPurchaseConnectorA1g.InAppPurchaseEvent = i2;
            }
            char[] cArr3 = new char[length];
            aFPurchaseConnectorA1g.InAppPurchaseEvent = 0;
            while (true) {
                if ((aFPurchaseConnectorA1g.InAppPurchaseEvent < cArr2.length ? 'L' : (char) 31) != 'L') {
                    objArr[0] = new String(cArr3);
                    return;
                }
                int i6 = $10 + 25;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr3[aFPurchaseConnectorA1g.InAppPurchaseEvent] = (char) jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent];
                aFPurchaseConnectorA1g.InAppPurchaseEvent++;
                int i8 = $10 + 119;
                $11 = i8 % 128;
                int i9 = i8 % 2;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static SubscriptionValidationResult fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubscriptionValidationResult) {
            SubscriptionValidationResult subscriptionValidationResult = (SubscriptionValidationResult) obj;
            return this.success == subscriptionValidationResult.success && Intrinsics.areEqual(this.subscriptionPurchase, subscriptionValidationResult.subscriptionPurchase) && Intrinsics.areEqual(this.failureData, subscriptionValidationResult.failureData);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        SubscriptionPurchase subscriptionPurchase = this.subscriptionPurchase;
        int hashCode = (i + (subscriptionPurchase == null ? 0 : subscriptionPurchase.hashCode())) * 31;
        ValidationFailureData validationFailureData = this.failureData;
        return hashCode + (validationFailureData != null ? validationFailureData.hashCode() : 0);
    }

    public final String toString() {
        boolean z = this.success;
        SubscriptionPurchase subscriptionPurchase = this.subscriptionPurchase;
        return "SubscriptionValidationResult(success=" + z + ", subscriptionPurchase=" + subscriptionPurchase + ", failureData=" + this.failureData + ")";
    }

    public static /* synthetic */ SubscriptionValidationResult copy$default(SubscriptionValidationResult subscriptionValidationResult, boolean z, SubscriptionPurchase subscriptionPurchase, ValidationFailureData validationFailureData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = subscriptionValidationResult.success;
        }
        if ((i & 2) != 0) {
            subscriptionPurchase = subscriptionValidationResult.subscriptionPurchase;
        }
        if ((i & 4) != 0) {
            validationFailureData = subscriptionValidationResult.failureData;
        }
        return subscriptionValidationResult.copy(z, subscriptionPurchase, validationFailureData);
    }

    public final SubscriptionValidationResult copy(boolean z, SubscriptionPurchase subscriptionPurchase, ValidationFailureData validationFailureData) {
        return new SubscriptionValidationResult(z, subscriptionPurchase, validationFailureData);
    }

    public final ValidationFailureData component3() {
        return this.failureData;
    }

    public final SubscriptionPurchase component2() {
        return this.subscriptionPurchase;
    }

    public final boolean component1() {
        return this.success;
    }
}
