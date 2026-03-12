package com.appsflyer.internal.models;

import android.graphics.PointF;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1c;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÇ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\t"}, d2 = {"Lcom/appsflyer/internal/models/ValidationFailureData;", "", "", "p0", "", "p1", "<init>", "(ILjava/lang/String;)V", "component1", "()I", "component2", "()Ljava/lang/String;", "copy", "(ILjava/lang/String;)Lcom/appsflyer/internal/models/ValidationFailureData;", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "description", "Ljava/lang/String;", "getDescription", NotificationCompat.CATEGORY_STATUS, "I", "getStatus", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ValidationFailureData {
    public static final Companion Companion = new Companion(null);
    private final String description;
    private final int status;

    public ValidationFailureData(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = i;
        this.description = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getDescription() {
        return this.description;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/ValidationFailureData$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/ValidationFailureData;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/ValidationFailureData;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<ValidationFailureData> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int[] InAppPurchaseEvent = {987131286, -795503016, 1085795907, -394671689, 407361632, 940651397, -1374684004, -1080083704, -719311440, -958781164, 964790139, -1556834772, -1651995693, 1790979398, -1614282934, -369245761, -1675628797, 573531954};
        private static int getPackageName = 0;
        private static int toJsonMap = 1;

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ ValidationFailureData fromJson(JSONObject jSONObject) {
            int i = getPackageName + 115;
            toJsonMap = i % 128;
            int i2 = i % 2;
            ValidationFailureData fromJson = fromJson(jSONObject);
            int i3 = getPackageName + 45;
            toJsonMap = i3 % 128;
            int i4 = i3 % 2;
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        @JvmStatic
        public final ValidationFailureData fromJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a(new int[]{-340659533, -459495648, -1920624047, -599543187}, 6 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr);
            int optInt = jSONObject.optInt(((String) objArr[0]).intern(), -1);
            Object[] objArr2 = new Object[1];
            a(new int[]{949337563, -1749529051, 1869596331, 1756777723, -1296466469, -491897845}, TextUtils.getCapsMode("", 0, 0) + 11, objArr2);
            String optString = jSONObject.optString(((String) objArr2[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            ValidationFailureData validationFailureData = new ValidationFailureData(optInt, optString);
            int i = toJsonMap + 97;
            getPackageName = i % 128;
            if (i % 2 == 0) {
                return validationFailureData;
            }
            throw null;
        }

        private static void a(int[] iArr, int i, Object[] objArr) {
            int i2;
            AFPurchaseConnectorA1c aFPurchaseConnectorA1c = new AFPurchaseConnectorA1c();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = InAppPurchaseEvent;
            if (!(iArr2 == null)) {
                int i3 = $11;
                int i4 = i3 + 71;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i6 = i3 + 79;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                int i8 = 0;
                while (true) {
                    if (!(i8 < length)) {
                        break;
                    }
                    iArr3[i8] = (int) (iArr2[i8] ^ (-6033101233399176549L));
                    i8++;
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = InAppPurchaseEvent;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i9 = 0;
                while (i9 < length3) {
                    iArr6[i9] = (int) (iArr5[i9] ^ (-6033101233399176549L));
                    i9++;
                    length2 = length2;
                }
                iArr5 = iArr6;
                i2 = length2;
            } else {
                i2 = length2;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            aFPurchaseConnectorA1c.InAppPurchaseEvent = 0;
            while (aFPurchaseConnectorA1c.InAppPurchaseEvent < iArr.length) {
                cArr[0] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent] >> 16);
                cArr[1] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent];
                cArr[2] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1] >> 16);
                cArr[3] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1];
                aFPurchaseConnectorA1c.getQuantity = (cArr[0] << 16) + cArr[1];
                aFPurchaseConnectorA1c.toJsonMap = (cArr[2] << 16) + cArr[3];
                AFPurchaseConnectorA1c.InAppPurchaseEvent(iArr4);
                int i10 = $10 + 55;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                for (int i12 = 0; i12 < 16; i12++) {
                    int i13 = $11 + 75;
                    $10 = i13 % 128;
                    int i14 = i13 % 2;
                    aFPurchaseConnectorA1c.getQuantity ^= iArr4[i12];
                    aFPurchaseConnectorA1c.toJsonMap = AFPurchaseConnectorA1c.getQuantity(aFPurchaseConnectorA1c.getQuantity) ^ aFPurchaseConnectorA1c.toJsonMap;
                    int i15 = aFPurchaseConnectorA1c.getQuantity;
                    aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                    aFPurchaseConnectorA1c.toJsonMap = i15;
                }
                int i16 = aFPurchaseConnectorA1c.getQuantity;
                aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                aFPurchaseConnectorA1c.toJsonMap = i16;
                aFPurchaseConnectorA1c.toJsonMap ^= iArr4[16];
                aFPurchaseConnectorA1c.getQuantity ^= iArr4[17];
                int i17 = aFPurchaseConnectorA1c.getQuantity;
                int i18 = aFPurchaseConnectorA1c.toJsonMap;
                cArr[0] = (char) (aFPurchaseConnectorA1c.getQuantity >>> 16);
                cArr[1] = (char) aFPurchaseConnectorA1c.getQuantity;
                cArr[2] = (char) (aFPurchaseConnectorA1c.toJsonMap >>> 16);
                cArr[3] = (char) aFPurchaseConnectorA1c.toJsonMap;
                AFPurchaseConnectorA1c.InAppPurchaseEvent(iArr4);
                cArr2[aFPurchaseConnectorA1c.InAppPurchaseEvent * 2] = cArr[0];
                cArr2[(aFPurchaseConnectorA1c.InAppPurchaseEvent * 2) + 1] = cArr[1];
                cArr2[(aFPurchaseConnectorA1c.InAppPurchaseEvent * 2) + 2] = cArr[2];
                cArr2[(aFPurchaseConnectorA1c.InAppPurchaseEvent * 2) + 3] = cArr[3];
                aFPurchaseConnectorA1c.InAppPurchaseEvent += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static ValidationFailureData fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ValidationFailureData) {
            ValidationFailureData validationFailureData = (ValidationFailureData) obj;
            return this.status == validationFailureData.status && Intrinsics.areEqual(this.description, validationFailureData.description);
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.hashCode(this.status) * 31) + this.description.hashCode();
    }

    public final String toString() {
        int i = this.status;
        return "ValidationFailureData(status=" + i + ", description=" + this.description + ")";
    }

    public static /* synthetic */ ValidationFailureData copy$default(ValidationFailureData validationFailureData, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = validationFailureData.status;
        }
        if ((i2 & 2) != 0) {
            str = validationFailureData.description;
        }
        return validationFailureData.copy(i, str);
    }

    public final ValidationFailureData copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new ValidationFailureData(i, str);
    }

    public final String component2() {
        return this.description;
    }

    public final int component1() {
        return this.status;
    }
}
