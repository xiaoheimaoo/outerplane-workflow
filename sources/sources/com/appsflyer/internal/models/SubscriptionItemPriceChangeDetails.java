package com.appsflyer.internal.models;

import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B+\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004HÇ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;", "", "", "p0", "Lcom/appsflyer/internal/models/Money;", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Lcom/appsflyer/internal/models/Money;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/appsflyer/internal/models/Money;", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/appsflyer/internal/models/Money;Ljava/lang/String;Ljava/lang/String;)Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "expectedNewPriceChargeTime", "Ljava/lang/String;", "getExpectedNewPriceChargeTime", "newPrice", "Lcom/appsflyer/internal/models/Money;", "getNewPrice", "priceChangeMode", "getPriceChangeMode", "priceChangeState", "getPriceChangeState", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionItemPriceChangeDetails {
    public static final Companion Companion = new Companion(null);
    private final String expectedNewPriceChargeTime;
    private final Money newPrice;
    private final String priceChangeMode;
    private final String priceChangeState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<SubscriptionItemPriceChangeDetails> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getQuantity = 0;
        private static int hashCode = 1;
        private static char[] getPackageName = {34824, 35063, 35071, 34826, 35067, 34827, 34849, 35062, 34847, 35069, 34820, 34858, 34823, 34828, 34822, 34843, 34816, 34817, 34848, 35070, 34842};
        private static int toJsonMap = -2120185745;
        private static boolean getOneTimePurchaseOfferDetails = true;
        private static boolean InAppPurchaseEvent = true;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        private static void a(int[] iArr, String str, int i, String str2, Object[] objArr) {
            int i2;
            char[] cArr;
            String str3 = str2;
            byte[] bArr = str3;
            if (str3 != null) {
                int i3 = $10 + 15;
                $11 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    str3.getBytes("ISO-8859-1");
                    throw null;
                }
                bArr = str3.getBytes("ISO-8859-1");
            }
            byte[] bArr2 = bArr;
            char[] cArr2 = (char[]) (str != null ? str.toCharArray() : str);
            AFPurchaseConnectorA1b aFPurchaseConnectorA1b = new AFPurchaseConnectorA1b();
            char[] cArr3 = getPackageName;
            if ((cArr3 != null ? 'B' : 'M') == 'B') {
                int i4 = $11 + 87;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int length = cArr3.length;
                char[] cArr4 = new char[length];
                for (int i6 = 0; i6 < length; i6++) {
                    cArr4[i6] = (char) (cArr3[i6] ^ (-4643703481320830850L));
                }
                cArr3 = cArr4;
            }
            int i7 = (int) (toJsonMap ^ (-4643703481320830850L));
            if (InAppPurchaseEvent) {
                int i8 = $11 + 109;
                $10 = i8 % 128;
                if (i8 % 2 != 0) {
                    aFPurchaseConnectorA1b.getPackageName = bArr2.length;
                    cArr = new char[aFPurchaseConnectorA1b.getPackageName];
                    aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails = 1;
                } else {
                    aFPurchaseConnectorA1b.getPackageName = bArr2.length;
                    cArr = new char[aFPurchaseConnectorA1b.getPackageName];
                    aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails = 0;
                }
                while (aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails < aFPurchaseConnectorA1b.getPackageName) {
                    cArr[aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] = (char) (cArr3[bArr2[(aFPurchaseConnectorA1b.getPackageName - 1) - aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] + i] - i7);
                    aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails++;
                }
                String str4 = new String(cArr);
                int i9 = $11 + 43;
                $10 = i9 % 128;
                if ((i9 % 2 != 0 ? (char) 24 : 'b') != 'b') {
                    throw null;
                }
                objArr[0] = str4;
            } else if (getOneTimePurchaseOfferDetails) {
                aFPurchaseConnectorA1b.getPackageName = cArr2.length;
                char[] cArr5 = new char[aFPurchaseConnectorA1b.getPackageName];
                aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails = 0;
                while (aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails < aFPurchaseConnectorA1b.getPackageName) {
                    int i10 = $10 + 123;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr5[aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] = (char) (cArr3[cArr2[(aFPurchaseConnectorA1b.getPackageName - 1) - aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] - i] - i7);
                    aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails++;
                }
                objArr[0] = new String(cArr5);
            } else {
                aFPurchaseConnectorA1b.getPackageName = iArr.length;
                char[] cArr6 = new char[aFPurchaseConnectorA1b.getPackageName];
                aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails = 0;
                while (true) {
                    if ((aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails < aFPurchaseConnectorA1b.getPackageName ? (char) 1 : 'T') != 1) {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                    int i12 = $11 + 75;
                    $10 = i12 % 128;
                    if (i12 % 2 != 0) {
                        cArr6[aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] = (char) (cArr3[iArr[(aFPurchaseConnectorA1b.getPackageName >>> 1) >> aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] - i] - i7);
                        i2 = aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails * 0;
                    } else {
                        cArr6[aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] = (char) (cArr3[iArr[(aFPurchaseConnectorA1b.getPackageName - 1) - aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails] - i] - i7);
                        i2 = aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails + 1;
                    }
                    aFPurchaseConnectorA1b.getOneTimePurchaseOfferDetails = i2;
                }
            }
        }

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ SubscriptionItemPriceChangeDetails fromJson(JSONObject jSONObject) {
            int i = getQuantity + 111;
            hashCode = i % 128;
            int i2 = i % 2;
            SubscriptionItemPriceChangeDetails fromJson = fromJson(jSONObject);
            int i3 = getQuantity + 55;
            hashCode = i3 % 128;
            int i4 = i3 % 2;
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final SubscriptionItemPriceChangeDetails fromJson(JSONObject jSONObject) {
            Money fromJson;
            int i = hashCode + 83;
            getQuantity = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a(null, null, 127 - (ViewConfiguration.getLongPressTimeout() >> 16), "\u0081\u0091\u008b\u0090\u0081\u008f\u008a\u008e\u008d\u008c\u0081\u0084\u008b\u008a\u0089\u0088\u0081\u0087\u0086\u0081\u0085\u0084\u0081\u0083\u0082\u0081", objArr);
            String optString = jSONObject.optString(((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            Object[] objArr2 = new Object[1];
            a(null, null, (ViewConfiguration.getFadingEdgeLength() >> 16) + WorkQueueKt.MASK, "\u0081\u0084\u008b\u008a\u0089\u0088\u0081\u0092", objArr2);
            JSONObject optJSONObject = jSONObject.optJSONObject(((String) objArr2[0]).intern());
            if ((optJSONObject != null ? 'O' : 'E') == 'O') {
                int i3 = getQuantity + 113;
                hashCode = i3 % 128;
                int i4 = i3 % 2;
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "");
                fromJson = Money.Companion.fromJson(optJSONObject);
            } else {
                int i5 = hashCode + 83;
                getQuantity = i5 % 128;
                int i6 = i5 % 2;
                fromJson = null;
            }
            Object[] objArr3 = new Object[1];
            a(null, null, 127 - View.MeasureSpec.getMode(0), "\u0081\u0086\u0094\u0093\u0081\u008f\u0092\u008e\u008d\u008c\u0081\u0084\u008b\u008a\u0083", objArr3);
            String optString2 = jSONObject.optString(((String) objArr3[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString2, "");
            Object[] objArr4 = new Object[1];
            a(null, null, 127 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), "\u0081\u0085\u008e\u0085\u0095\u0081\u008f\u0092\u008e\u008d\u008c\u0081\u0084\u008b\u008a\u0083", objArr4);
            String optString3 = jSONObject.optString(((String) objArr4[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString3, "");
            return new SubscriptionItemPriceChangeDetails(optString, fromJson, optString2, optString3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SubscriptionItemPriceChangeDetails(String str, Money money, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.expectedNewPriceChargeTime = str;
        this.newPrice = money;
        this.priceChangeMode = str2;
        this.priceChangeState = str3;
    }

    public final String getExpectedNewPriceChargeTime() {
        return this.expectedNewPriceChargeTime;
    }

    public final Money getNewPrice() {
        return this.newPrice;
    }

    public final String getPriceChangeMode() {
        return this.priceChangeMode;
    }

    public final String getPriceChangeState() {
        return this.priceChangeState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubscriptionItemPriceChangeDetails) {
            SubscriptionItemPriceChangeDetails subscriptionItemPriceChangeDetails = (SubscriptionItemPriceChangeDetails) obj;
            return Intrinsics.areEqual(this.expectedNewPriceChargeTime, subscriptionItemPriceChangeDetails.expectedNewPriceChargeTime) && Intrinsics.areEqual(this.newPrice, subscriptionItemPriceChangeDetails.newPrice) && Intrinsics.areEqual(this.priceChangeMode, subscriptionItemPriceChangeDetails.priceChangeMode) && Intrinsics.areEqual(this.priceChangeState, subscriptionItemPriceChangeDetails.priceChangeState);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.expectedNewPriceChargeTime.hashCode() * 31;
        Money money = this.newPrice;
        return ((((hashCode + (money == null ? 0 : money.hashCode())) * 31) + this.priceChangeMode.hashCode()) * 31) + this.priceChangeState.hashCode();
    }

    public final String toString() {
        String str = this.expectedNewPriceChargeTime;
        Money money = this.newPrice;
        String str2 = this.priceChangeMode;
        return "SubscriptionItemPriceChangeDetails(expectedNewPriceChargeTime=" + str + ", newPrice=" + money + ", priceChangeMode=" + str2 + ", priceChangeState=" + this.priceChangeState + ")";
    }

    public static /* synthetic */ SubscriptionItemPriceChangeDetails copy$default(SubscriptionItemPriceChangeDetails subscriptionItemPriceChangeDetails, String str, Money money, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionItemPriceChangeDetails.expectedNewPriceChargeTime;
        }
        if ((i & 2) != 0) {
            money = subscriptionItemPriceChangeDetails.newPrice;
        }
        if ((i & 4) != 0) {
            str2 = subscriptionItemPriceChangeDetails.priceChangeMode;
        }
        if ((i & 8) != 0) {
            str3 = subscriptionItemPriceChangeDetails.priceChangeState;
        }
        return subscriptionItemPriceChangeDetails.copy(str, money, str2, str3);
    }

    public final SubscriptionItemPriceChangeDetails copy(String str, Money money, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        return new SubscriptionItemPriceChangeDetails(str, money, str2, str3);
    }

    public final String component4() {
        return this.priceChangeState;
    }

    public final String component3() {
        return this.priceChangeMode;
    }

    public final Money component2() {
        return this.newPrice;
    }

    public final String component1() {
        return this.expectedNewPriceChargeTime;
    }
}
