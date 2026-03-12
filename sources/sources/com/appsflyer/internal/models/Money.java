package com.appsflyer.internal.models;

import android.os.Process;
import android.view.ViewConfiguration;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001a\u0010\u001d\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\f"}, d2 = {"Lcom/appsflyer/internal/models/Money;", "", "", "p0", "", "p1", "p2", "<init>", "(Ljava/lang/String;JJ)V", "component1", "()Ljava/lang/String;", "component2", "()J", "component3", "copy", "(Ljava/lang/String;JJ)Lcom/appsflyer/internal/models/Money;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", AppsFlyerProperties.CURRENCY_CODE, "Ljava/lang/String;", "getCurrencyCode", "nanos", "J", "getNanos", "units", "getUnits", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Money {
    public static final Companion Companion = new Companion(null);
    private final String currencyCode;
    private final long nanos;
    private final long units;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/Money$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/Money;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/Money;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<Money> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int InAppPurchaseEvent = 1;
        private static int getPackageName = 0;
        private static long toJsonMap = 3402519045217790112L;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v6, types: [char[]] */
        private static void a(String str, int i, Object[] objArr) {
            int i2;
            int i3 = $11 + 47;
            $10 = i3 % 128;
            if (i3 % 2 == 0) {
                if ((str != 0 ? '.' : (char) 19) == '.') {
                    str = str.toCharArray();
                }
                char[] cArr = (char[]) str;
                AFPurchaseConnectorA1g aFPurchaseConnectorA1g = new AFPurchaseConnectorA1g();
                aFPurchaseConnectorA1g.getPackageName = i;
                int length = cArr.length;
                long[] jArr = new long[length];
                aFPurchaseConnectorA1g.InAppPurchaseEvent = 0;
                while (true) {
                    if ((aFPurchaseConnectorA1g.InAppPurchaseEvent < cArr.length ? 'Y' : 'H') != 'Y') {
                        break;
                    }
                    int i4 = $10 + 77;
                    $11 = i4 % 128;
                    if ((i4 % 2 == 0 ? '<' : 'D') != '<') {
                        jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] = (toJsonMap ^ 5319290379872349608L) ^ (cArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] ^ (aFPurchaseConnectorA1g.InAppPurchaseEvent * aFPurchaseConnectorA1g.getPackageName));
                        i2 = aFPurchaseConnectorA1g.InAppPurchaseEvent + 1;
                    } else {
                        jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] = cArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] * (aFPurchaseConnectorA1g.InAppPurchaseEvent + aFPurchaseConnectorA1g.getPackageName) * toJsonMap * 5319290379872349608L;
                        i2 = aFPurchaseConnectorA1g.InAppPurchaseEvent * 1;
                    }
                    aFPurchaseConnectorA1g.InAppPurchaseEvent = i2;
                }
                char[] cArr2 = new char[length];
                aFPurchaseConnectorA1g.InAppPurchaseEvent = 0;
                while (aFPurchaseConnectorA1g.InAppPurchaseEvent < cArr.length) {
                    cArr2[aFPurchaseConnectorA1g.InAppPurchaseEvent] = (char) jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent];
                    aFPurchaseConnectorA1g.InAppPurchaseEvent++;
                }
                objArr[0] = new String(cArr2);
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ Money fromJson(JSONObject jSONObject) {
            int i = InAppPurchaseEvent + 103;
            getPackageName = i % 128;
            if ((i % 2 != 0 ? '[' : '6') == '6') {
                return fromJson(jSONObject);
            }
            fromJson(jSONObject);
            throw null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final Money fromJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a("蕫銜ꪸ싙\udae9\uf203ਭ≖㩃厎殦菆", 6113 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr);
            String optString = jSONObject.optString(((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            Object[] objArr2 = new Object[1];
            a("蕦屲㝐ึ\ue117", (ViewConfiguration.getDoubleTapTimeout() >> 16) + 55579, objArr2);
            long j = jSONObject.getLong(((String) objArr2[0]).intern());
            Object[] objArr3 = new Object[1];
            a("蕽ᕫꕻ㕛앏", ((Process.getThreadPriority(0) + 20) >> 6) + 36877, objArr3);
            Money money = new Money(optString, j, jSONObject.getLong(((String) objArr3[0]).intern()));
            int i = InAppPurchaseEvent + 33;
            getPackageName = i % 128;
            if (i % 2 == 0 ? true : false) {
                return money;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Money(String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.currencyCode = str;
        this.nanos = j;
        this.units = j2;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final long getNanos() {
        return this.nanos;
    }

    public final long getUnits() {
        return this.units;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Money) {
            Money money = (Money) obj;
            return Intrinsics.areEqual(this.currencyCode, money.currencyCode) && this.nanos == money.nanos && this.units == money.units;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.currencyCode.hashCode() * 31) + Long.hashCode(this.nanos)) * 31) + Long.hashCode(this.units);
    }

    public final String toString() {
        String str = this.currencyCode;
        long j = this.nanos;
        return "Money(currencyCode=" + str + ", nanos=" + j + ", units=" + this.units + ")";
    }

    public static /* synthetic */ Money copy$default(Money money, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = money.currencyCode;
        }
        if ((i & 2) != 0) {
            j = money.nanos;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = money.units;
        }
        return money.copy(str, j3, j2);
    }

    public final Money copy(String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Money(str, j, j2);
    }

    public final long component3() {
        return this.units;
    }

    public final long component2() {
        return this.nanos;
    }

    public final String component1() {
        return this.currencyCode;
    }
}
