package com.appsflyer.internal.models;

import android.graphics.Color;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007"}, d2 = {"Lcom/appsflyer/internal/models/PausedStateContext;", "", "", "p0", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/appsflyer/internal/models/PausedStateContext;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "autoResumeTime", "Ljava/lang/String;", "getAutoResumeTime", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PausedStateContext {
    public static final Companion Companion = new Companion(null);
    private final String autoResumeTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/PausedStateContext$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/PausedStateContext;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/PausedStateContext;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<PausedStateContext> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int InAppPurchaseEvent = 1;
        private static int[] getOneTimePurchaseOfferDetails = {-1304909012, 714143344, 719802641, 1576161698, 1933478925, 1141267324, -677188655, 1131992209, 1786428511, 1255381593, -1146773330, -346518410, 790114477, 1685937482, 568483301, -2129505576, 1603859667, 1267649722};
        private static int getPackageName;

        private static void a(int[] iArr, int i, Object[] objArr) {
            int i2;
            int i3;
            int length;
            int[] iArr2;
            int i4;
            AFPurchaseConnectorA1c aFPurchaseConnectorA1c = new AFPurchaseConnectorA1c();
            char[] cArr = new char[4];
            int i5 = 2;
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr3 = getOneTimePurchaseOfferDetails;
            if (iArr3 != null) {
                int i6 = $11 + 25;
                $10 = i6 % 128;
                if (!(i6 % 2 != 0)) {
                    length = iArr3.length;
                    iArr2 = new int[length];
                    i4 = 0;
                } else {
                    length = iArr3.length;
                    iArr2 = new int[length];
                    i4 = 1;
                }
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    iArr2[i4] = (int) (iArr3[i4] ^ (-6033101233399176549L));
                    i4++;
                }
                iArr3 = iArr2;
            }
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = getOneTimePurchaseOfferDetails;
            if (iArr5 != null) {
                int i7 = $10 + 59;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i9 = 0;
                while (true) {
                    if (!(i9 < length3 ? true : true)) {
                        break;
                    }
                    int i10 = $10 + 53;
                    $11 = i10 % 128;
                    if (i10 % i5 == 0) {
                        i3 = length2;
                        iArr6[i9] = (int) (iArr5[i9] ^ (-6033101233399176549L));
                        i9 *= 1;
                    } else {
                        i3 = length2;
                        iArr6[i9] = (int) (iArr5[i9] ^ (-6033101233399176549L));
                        i9++;
                    }
                    length2 = i3;
                    i5 = 2;
                }
                i2 = length2;
                iArr5 = iArr6;
            } else {
                i2 = length2;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            aFPurchaseConnectorA1c.InAppPurchaseEvent = 0;
            while (true) {
                if (aFPurchaseConnectorA1c.InAppPurchaseEvent >= iArr.length) {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
                cArr[0] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent] >> 16);
                cArr[1] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent];
                cArr[2] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1] >> 16);
                cArr[3] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1];
                aFPurchaseConnectorA1c.getQuantity = (cArr[0] << 16) + cArr[1];
                aFPurchaseConnectorA1c.toJsonMap = (cArr[2] << 16) + cArr[3];
                AFPurchaseConnectorA1c.InAppPurchaseEvent(iArr4);
                for (int i11 = 0; i11 < 16; i11++) {
                    aFPurchaseConnectorA1c.getQuantity ^= iArr4[i11];
                    aFPurchaseConnectorA1c.toJsonMap = AFPurchaseConnectorA1c.getQuantity(aFPurchaseConnectorA1c.getQuantity) ^ aFPurchaseConnectorA1c.toJsonMap;
                    int i12 = aFPurchaseConnectorA1c.getQuantity;
                    aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                    aFPurchaseConnectorA1c.toJsonMap = i12;
                }
                int i13 = aFPurchaseConnectorA1c.getQuantity;
                aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                aFPurchaseConnectorA1c.toJsonMap = i13;
                aFPurchaseConnectorA1c.toJsonMap ^= iArr4[16];
                aFPurchaseConnectorA1c.getQuantity ^= iArr4[17];
                int i14 = aFPurchaseConnectorA1c.getQuantity;
                int i15 = aFPurchaseConnectorA1c.toJsonMap;
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
        }

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ PausedStateContext fromJson(JSONObject jSONObject) {
            int i = InAppPurchaseEvent + 107;
            getPackageName = i % 128;
            if ((i % 2 != 0 ? 'K' : '@') == '@') {
                return fromJson(jSONObject);
            }
            fromJson(jSONObject);
            throw null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final PausedStateContext fromJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a(new int[]{-814223544, 922159691, -908370604, -1848497898, -405032872, 572579928, 963491659, 148804044}, 14 - Color.argb(0, 0, 0, 0), objArr);
            String optString = jSONObject.optString(((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            PausedStateContext pausedStateContext = new PausedStateContext(optString);
            int i = InAppPurchaseEvent + 65;
            getPackageName = i % 128;
            if ((i % 2 != 0 ? '\'' : '7') == '7') {
                return pausedStateContext;
            }
            throw null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PausedStateContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.autoResumeTime = str;
    }

    public final String getAutoResumeTime() {
        return this.autoResumeTime;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PausedStateContext) && Intrinsics.areEqual(this.autoResumeTime, ((PausedStateContext) obj).autoResumeTime);
    }

    public final int hashCode() {
        return this.autoResumeTime.hashCode();
    }

    public final String toString() {
        return "PausedStateContext(autoResumeTime=" + this.autoResumeTime + ")";
    }

    public static /* synthetic */ PausedStateContext copy$default(PausedStateContext pausedStateContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pausedStateContext.autoResumeTime;
        }
        return pausedStateContext.copy(str);
    }

    public final PausedStateContext copy(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new PausedStateContext(str);
    }

    public final String component1() {
        return this.autoResumeTime;
    }
}
