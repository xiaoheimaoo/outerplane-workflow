package com.appsflyer.internal.models;

import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÇ\u0003¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÇ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/models/AutoRenewingPlan;", "", "", "p0", "Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;", "p1", "<init>", "(Ljava/lang/Boolean;Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;)V", "component1", "()Ljava/lang/Boolean;", "component2", "()Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;", "copy", "(Ljava/lang/Boolean;Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;)Lcom/appsflyer/internal/models/AutoRenewingPlan;", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "autoRenewEnabled", "Ljava/lang/Boolean;", "getAutoRenewEnabled", "priceChangeDetails", "Lcom/appsflyer/internal/models/SubscriptionItemPriceChangeDetails;", "getPriceChangeDetails", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutoRenewingPlan {
    public static final Companion Companion = new Companion(null);
    private final Boolean autoRenewEnabled;
    private final SubscriptionItemPriceChangeDetails priceChangeDetails;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/AutoRenewingPlan$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/AutoRenewingPlan;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/AutoRenewingPlan;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<AutoRenewingPlan> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getOneTimePurchaseOfferDetails = 0;
        private static int getPackageName = 1;
        private static char[] InAppPurchaseEvent = {8976, 31969, 40143, 15537, 23735, 64621, 7233, 48215, 56366, 31801, 40429, 15815, 23983, 64956, 7570, 48510, 8961, 31974, 40146, 15549, 23680, 64587, 7239, 48211, 56375, 31771, 40422, 15842, 23976, 64932, 7574, 48499, 56653, 32055};
        private static long toJsonMap = -6458867719560463212L;

        private static void a(int i, char c, int i2, Object[] objArr) {
            AFPurchaseConnectorA1d aFPurchaseConnectorA1d = new AFPurchaseConnectorA1d();
            long[] jArr = new long[i];
            aFPurchaseConnectorA1d.getQuantity = 0;
            int i3 = $10 + 19;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            while (true) {
                if (aFPurchaseConnectorA1d.getQuantity >= i) {
                    break;
                }
                int i5 = $10 + 111;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                jArr[aFPurchaseConnectorA1d.getQuantity] = (((char) (InAppPurchaseEvent[i2 + aFPurchaseConnectorA1d.getQuantity] ^ 5120776544585851761L)) ^ (aFPurchaseConnectorA1d.getQuantity * (5120776544585851761L ^ toJsonMap))) ^ c;
                aFPurchaseConnectorA1d.getQuantity++;
            }
            char[] cArr = new char[i];
            aFPurchaseConnectorA1d.getQuantity = 0;
            while (true) {
                if (!(aFPurchaseConnectorA1d.getQuantity >= i)) {
                    cArr[aFPurchaseConnectorA1d.getQuantity] = (char) jArr[aFPurchaseConnectorA1d.getQuantity];
                    aFPurchaseConnectorA1d.getQuantity++;
                } else {
                    objArr[0] = new String(cArr);
                    return;
                }
            }
        }

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ AutoRenewingPlan fromJson(JSONObject jSONObject) {
            int i = getOneTimePurchaseOfferDetails + 89;
            getPackageName = i % 128;
            int i2 = i % 2;
            AutoRenewingPlan fromJson = fromJson(jSONObject);
            int i3 = getPackageName + 99;
            getOneTimePurchaseOfferDetails = i3 % 128;
            int i4 = i3 % 2;
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final AutoRenewingPlan fromJson(JSONObject jSONObject) {
            Object nullable;
            Object object;
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a(17 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1, objArr);
            nullable = SubscriptionPurchaseKt.getNullable(jSONObject, ((String) objArr[0]).intern());
            Object[] objArr2 = new Object[1];
            a(TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) TextUtils.getCapsMode("", 0, 0), 17 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr2);
            object = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr2[0]).intern(), SubscriptionItemPriceChangeDetails.Companion);
            AutoRenewingPlan autoRenewingPlan = new AutoRenewingPlan((Boolean) nullable, (SubscriptionItemPriceChangeDetails) object);
            int i = getOneTimePurchaseOfferDetails + 57;
            getPackageName = i % 128;
            if (i % 2 != 0) {
                return autoRenewingPlan;
            }
            int i2 = 33 / 0;
            return autoRenewingPlan;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AutoRenewingPlan(Boolean bool, SubscriptionItemPriceChangeDetails subscriptionItemPriceChangeDetails) {
        this.autoRenewEnabled = bool;
        this.priceChangeDetails = subscriptionItemPriceChangeDetails;
    }

    public final Boolean getAutoRenewEnabled() {
        return this.autoRenewEnabled;
    }

    public final SubscriptionItemPriceChangeDetails getPriceChangeDetails() {
        return this.priceChangeDetails;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AutoRenewingPlan) {
            AutoRenewingPlan autoRenewingPlan = (AutoRenewingPlan) obj;
            return Intrinsics.areEqual(this.autoRenewEnabled, autoRenewingPlan.autoRenewEnabled) && Intrinsics.areEqual(this.priceChangeDetails, autoRenewingPlan.priceChangeDetails);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.autoRenewEnabled;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        SubscriptionItemPriceChangeDetails subscriptionItemPriceChangeDetails = this.priceChangeDetails;
        return hashCode + (subscriptionItemPriceChangeDetails != null ? subscriptionItemPriceChangeDetails.hashCode() : 0);
    }

    public final String toString() {
        Boolean bool = this.autoRenewEnabled;
        return "AutoRenewingPlan(autoRenewEnabled=" + bool + ", priceChangeDetails=" + this.priceChangeDetails + ")";
    }

    public static /* synthetic */ AutoRenewingPlan copy$default(AutoRenewingPlan autoRenewingPlan, Boolean bool, SubscriptionItemPriceChangeDetails subscriptionItemPriceChangeDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = autoRenewingPlan.autoRenewEnabled;
        }
        if ((i & 2) != 0) {
            subscriptionItemPriceChangeDetails = autoRenewingPlan.priceChangeDetails;
        }
        return autoRenewingPlan.copy(bool, subscriptionItemPriceChangeDetails);
    }

    public final AutoRenewingPlan copy(Boolean bool, SubscriptionItemPriceChangeDetails subscriptionItemPriceChangeDetails) {
        return new AutoRenewingPlan(bool, subscriptionItemPriceChangeDetails);
    }

    public final SubscriptionItemPriceChangeDetails component2() {
        return this.priceChangeDetails;
    }

    public final Boolean component1() {
        return this.autoRenewEnabled;
    }
}
