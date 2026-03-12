package com.appsflyer.internal.models;

import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u000b\u0010\tJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\t"}, d2 = {"Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;", "", "", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "externalAccountId", "Ljava/lang/String;", "getExternalAccountId", "obfuscatedExternalAccountId", "getObfuscatedExternalAccountId", "obfuscatedExternalProfileId", "getObfuscatedExternalProfileId", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExternalAccountIdentifiers {
    public static final Companion Companion = new Companion(null);
    private final String externalAccountId;
    private final String obfuscatedExternalAccountId;
    private final String obfuscatedExternalProfileId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/ExternalAccountIdentifiers$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<ExternalAccountIdentifiers> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int InAppPurchaseEvent = 0;
        private static int getPackageName = 1;
        private static char[] getOneTimePurchaseOfferDetails = {8980, 17673, 61189, 4372, 47875, 56607, 18192, 59677, 4912, 46354, 57106, 16670, 60164, 3359, 46853, 55608, 17173, 8990, 17683, 61207, 4356, 47874, 56594, 18192, 59653, 4884, 46357, 57140, 16649, 60165, 3348, 46851, 55583, 17168, 58653, 3888, 45330, 56082, 32030, 59140, 2335, 45829, 54584, 32533, 17338, 9655, 36787, 29088, 56230, 48566, 10164, 35233, 29616, 54705, 49040, 8621, 35745, 28080, 55207, 47547, 9140, 34233, 28549, 53671, 48058, 7603, 34748, 27065, 54192, 46492, 8113};
        private static long getQuantity = -3076080037190023823L;

        private static void a(int i, char c, int i2, Object[] objArr) {
            AFPurchaseConnectorA1d aFPurchaseConnectorA1d = new AFPurchaseConnectorA1d();
            long[] jArr = new long[i];
            aFPurchaseConnectorA1d.getQuantity = 0;
            while (true) {
                if ((aFPurchaseConnectorA1d.getQuantity < i ? ':' : (char) 31) != ':') {
                    break;
                }
                int i3 = $10 + 1;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                jArr[aFPurchaseConnectorA1d.getQuantity] = (((char) (getOneTimePurchaseOfferDetails[aFPurchaseConnectorA1d.getQuantity + i2] ^ 5120776544585851761L)) ^ (aFPurchaseConnectorA1d.getQuantity * (5120776544585851761L ^ getQuantity))) ^ c;
                aFPurchaseConnectorA1d.getQuantity++;
            }
            char[] cArr = new char[i];
            aFPurchaseConnectorA1d.getQuantity = 0;
            while (true) {
                if ((aFPurchaseConnectorA1d.getQuantity < i ? '/' : '\n') == '\n') {
                    break;
                }
                cArr[aFPurchaseConnectorA1d.getQuantity] = (char) jArr[aFPurchaseConnectorA1d.getQuantity];
                aFPurchaseConnectorA1d.getQuantity++;
            }
            String str = new String(cArr);
            int i5 = $10 + 61;
            $11 = i5 % 128;
            if (i5 % 2 != 0) {
                objArr[0] = str;
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ ExternalAccountIdentifiers fromJson(JSONObject jSONObject) {
            int i = getPackageName + 53;
            InAppPurchaseEvent = i % 128;
            int i2 = i % 2;
            ExternalAccountIdentifiers fromJson = fromJson(jSONObject);
            int i3 = getPackageName + 123;
            InAppPurchaseEvent = i3 % 128;
            int i4 = i3 % 2;
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final ExternalAccountIdentifiers fromJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a(TextUtils.getOffsetAfter("", 0) + 17, (char) ExpandableListView.getPackedPositionGroup(0L), KeyEvent.getMaxKeyCode() >> 16, objArr);
            String optString = jSONObject.optString(((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            Object[] objArr2 = new Object[1];
            a(View.MeasureSpec.getMode(0) + 27, (char) TextUtils.getTrimmedLength(""), 16 - Process.getGidForName(""), objArr2);
            String optString2 = jSONObject.optString(((String) objArr2[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString2, "");
            Object[] objArr3 = new Object[1];
            a(ExpandableListView.getPackedPositionType(0L) + 27, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 24740), 44 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr3);
            String optString3 = jSONObject.optString(((String) objArr3[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString3, "");
            ExternalAccountIdentifiers externalAccountIdentifiers = new ExternalAccountIdentifiers(optString, optString2, optString3);
            int i = getPackageName + 13;
            InAppPurchaseEvent = i % 128;
            int i2 = i % 2;
            return externalAccountIdentifiers;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ExternalAccountIdentifiers(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.externalAccountId = str;
        this.obfuscatedExternalAccountId = str2;
        this.obfuscatedExternalProfileId = str3;
    }

    public final String getExternalAccountId() {
        return this.externalAccountId;
    }

    public final String getObfuscatedExternalAccountId() {
        return this.obfuscatedExternalAccountId;
    }

    public final String getObfuscatedExternalProfileId() {
        return this.obfuscatedExternalProfileId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExternalAccountIdentifiers) {
            ExternalAccountIdentifiers externalAccountIdentifiers = (ExternalAccountIdentifiers) obj;
            return Intrinsics.areEqual(this.externalAccountId, externalAccountIdentifiers.externalAccountId) && Intrinsics.areEqual(this.obfuscatedExternalAccountId, externalAccountIdentifiers.obfuscatedExternalAccountId) && Intrinsics.areEqual(this.obfuscatedExternalProfileId, externalAccountIdentifiers.obfuscatedExternalProfileId);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.externalAccountId.hashCode() * 31) + this.obfuscatedExternalAccountId.hashCode()) * 31) + this.obfuscatedExternalProfileId.hashCode();
    }

    public final String toString() {
        String str = this.externalAccountId;
        String str2 = this.obfuscatedExternalAccountId;
        return "ExternalAccountIdentifiers(externalAccountId=" + str + ", obfuscatedExternalAccountId=" + str2 + ", obfuscatedExternalProfileId=" + this.obfuscatedExternalProfileId + ")";
    }

    public static /* synthetic */ ExternalAccountIdentifiers copy$default(ExternalAccountIdentifiers externalAccountIdentifiers, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = externalAccountIdentifiers.externalAccountId;
        }
        if ((i & 2) != 0) {
            str2 = externalAccountIdentifiers.obfuscatedExternalAccountId;
        }
        if ((i & 4) != 0) {
            str3 = externalAccountIdentifiers.obfuscatedExternalProfileId;
        }
        return externalAccountIdentifiers.copy(str, str2, str3);
    }

    public final ExternalAccountIdentifiers copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        return new ExternalAccountIdentifiers(str, str2, str3);
    }

    public final String component3() {
        return this.obfuscatedExternalProfileId;
    }

    public final String component2() {
        return this.obfuscatedExternalAccountId;
    }

    public final String component1() {
        return this.externalAccountId;
    }
}
