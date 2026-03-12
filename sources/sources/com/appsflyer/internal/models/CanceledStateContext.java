package com.appsflyer.internal.models;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA2z;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B1\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÇ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÇ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bHÇ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J@\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cH×\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\rR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0011R\u001c\u0010(\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0013"}, d2 = {"Lcom/appsflyer/internal/models/CanceledStateContext;", "", "Lcom/appsflyer/internal/models/DeveloperInitiatedCancellation;", "p0", "Lcom/appsflyer/internal/models/ReplacementCancellation;", "p1", "Lcom/appsflyer/internal/models/SystemInitiatedCancellation;", "p2", "Lcom/appsflyer/internal/models/UserInitiatedCancellation;", "p3", "<init>", "(Lcom/appsflyer/internal/models/DeveloperInitiatedCancellation;Lcom/appsflyer/internal/models/ReplacementCancellation;Lcom/appsflyer/internal/models/SystemInitiatedCancellation;Lcom/appsflyer/internal/models/UserInitiatedCancellation;)V", "component1", "()Lcom/appsflyer/internal/models/DeveloperInitiatedCancellation;", "component2", "()Lcom/appsflyer/internal/models/ReplacementCancellation;", "component3", "()Lcom/appsflyer/internal/models/SystemInitiatedCancellation;", "component4", "()Lcom/appsflyer/internal/models/UserInitiatedCancellation;", "copy", "(Lcom/appsflyer/internal/models/DeveloperInitiatedCancellation;Lcom/appsflyer/internal/models/ReplacementCancellation;Lcom/appsflyer/internal/models/SystemInitiatedCancellation;Lcom/appsflyer/internal/models/UserInitiatedCancellation;)Lcom/appsflyer/internal/models/CanceledStateContext;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "developerInitiatedCancellation", "Lcom/appsflyer/internal/models/DeveloperInitiatedCancellation;", "getDeveloperInitiatedCancellation", "replacementCancellation", "Lcom/appsflyer/internal/models/ReplacementCancellation;", "getReplacementCancellation", "systemInitiatedCancellation", "Lcom/appsflyer/internal/models/SystemInitiatedCancellation;", "getSystemInitiatedCancellation", "userInitiatedCancellation", "Lcom/appsflyer/internal/models/UserInitiatedCancellation;", "getUserInitiatedCancellation", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CanceledStateContext {
    public static final Companion Companion = new Companion(null);
    private final DeveloperInitiatedCancellation developerInitiatedCancellation;
    private final ReplacementCancellation replacementCancellation;
    private final SystemInitiatedCancellation systemInitiatedCancellation;
    private final UserInitiatedCancellation userInitiatedCancellation;

    public CanceledStateContext(DeveloperInitiatedCancellation developerInitiatedCancellation, ReplacementCancellation replacementCancellation, SystemInitiatedCancellation systemInitiatedCancellation, UserInitiatedCancellation userInitiatedCancellation) {
        this.developerInitiatedCancellation = developerInitiatedCancellation;
        this.replacementCancellation = replacementCancellation;
        this.systemInitiatedCancellation = systemInitiatedCancellation;
        this.userInitiatedCancellation = userInitiatedCancellation;
    }

    public final DeveloperInitiatedCancellation getDeveloperInitiatedCancellation() {
        return this.developerInitiatedCancellation;
    }

    public final ReplacementCancellation getReplacementCancellation() {
        return this.replacementCancellation;
    }

    public final SystemInitiatedCancellation getSystemInitiatedCancellation() {
        return this.systemInitiatedCancellation;
    }

    public final UserInitiatedCancellation getUserInitiatedCancellation() {
        return this.userInitiatedCancellation;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/CanceledStateContext$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/CanceledStateContext;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/CanceledStateContext;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<CanceledStateContext> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getOneTimePurchaseOfferDetails = 1;
        private static int getPackageName = 0;
        private static long getQuantity = 6123178973585501029L;

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ CanceledStateContext fromJson(JSONObject jSONObject) {
            int i = getOneTimePurchaseOfferDetails + 109;
            getPackageName = i % 128;
            char c = i % 2 != 0 ? 'J' : 'R';
            CanceledStateContext fromJson = fromJson(jSONObject);
            if (c == 'J') {
                int i2 = 78 / 0;
            }
            int i3 = getPackageName + 39;
            getOneTimePurchaseOfferDetails = i3 % 128;
            int i4 = i3 % 2;
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final CanceledStateContext fromJson(JSONObject jSONObject) {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a("氬\uda93汈捲ሢ뼨\uf2ac\ue531伐㛘ퟺ슁⫾햮뭔ṝ֨\ue83e颋笰\ue109賣緙壵\udcd2ꎔℯ둈뾠䙆ڎ鄝魳\u1af9", TextUtils.getOffsetAfter("", 0), objArr);
            object = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr[0]).intern(), DeveloperInitiatedCancellation.Companion);
            Object[] objArr2 = new Object[1];
            a("‟\ue833\u206d䅲₂篕킪⇅̮Ѵ\uf5efٴ曚\ue729饎\uda8a䦎\uda99몉뿜괳빋忻鰝郦鄸̤", View.resolveSizeAndState(0, 0, 0), objArr2);
            object2 = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr2[0]).intern(), ReplacementCancellation.Companion);
            Object[] objArr3 = new Object[1];
            a("戟椫扬伪ꆆ旪\udef1㿢䄪蕢ﮛᡈⓖ昫霋쒗\u0b9b宊듖ꇅ\uef3e㽑冡舳틣ဣ൳溒놖\uf5f0⫌", (-1) - ((byte) KeyEvent.getModifierMetaStateMask()), objArr3);
            object3 = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr3[0]).intern(), SystemInitiatedCancellation.Companion);
            Object[] objArr4 = new Object[1];
            a("\udc12发\udc67뗎魶遪␃쩤＋뾛ş\uedd2髛峄淲ㄓ떆慖丷周儱֠ꭊ瞺泣⫁\uf79f鬉ྜ", View.resolveSize(0, 0), objArr4);
            object4 = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr4[0]).intern(), UserInitiatedCancellation.Companion);
            CanceledStateContext canceledStateContext = new CanceledStateContext((DeveloperInitiatedCancellation) object, (ReplacementCancellation) object2, (SystemInitiatedCancellation) object3, (UserInitiatedCancellation) object4);
            int i = getPackageName + 9;
            getOneTimePurchaseOfferDetails = i % 128;
            int i2 = i % 2;
            return canceledStateContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v10, types: [char[]] */
        /* JADX WARN: Type inference failed for: r13v9, types: [char[]] */
        private static void a(String str, int i, Object[] objArr) {
            if (str != 0) {
                int i2 = $11 + 97;
                $10 = i2 % 128;
                if (i2 % 2 != 0) {
                    str = str.toCharArray();
                    int i3 = 22 / 0;
                } else {
                    str = str.toCharArray();
                }
            }
            AFPurchaseConnectorA2z aFPurchaseConnectorA2z = new AFPurchaseConnectorA2z();
            char[] oneTimePurchaseOfferDetails = AFPurchaseConnectorA2z.getOneTimePurchaseOfferDetails(getQuantity ^ 7848782090230080433L, (char[]) str, i);
            aFPurchaseConnectorA2z.getPackageName = 4;
            while (true) {
                if ((aFPurchaseConnectorA2z.getPackageName < oneTimePurchaseOfferDetails.length ? '-' : 'C') != '-') {
                    break;
                }
                int i4 = $10 + 101;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                aFPurchaseConnectorA2z.getOneTimePurchaseOfferDetails = aFPurchaseConnectorA2z.getPackageName - 4;
                oneTimePurchaseOfferDetails[aFPurchaseConnectorA2z.getPackageName] = (char) ((oneTimePurchaseOfferDetails[aFPurchaseConnectorA2z.getPackageName] ^ oneTimePurchaseOfferDetails[aFPurchaseConnectorA2z.getPackageName % 4]) ^ (aFPurchaseConnectorA2z.getOneTimePurchaseOfferDetails * (getQuantity ^ 7848782090230080433L)));
                aFPurchaseConnectorA2z.getPackageName++;
            }
            String str2 = new String(oneTimePurchaseOfferDetails, 4, oneTimePurchaseOfferDetails.length - 4);
            int i6 = $11 + 33;
            $10 = i6 % 128;
            if (!(i6 % 2 == 0)) {
                throw null;
            }
            objArr[0] = str2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CanceledStateContext) {
            CanceledStateContext canceledStateContext = (CanceledStateContext) obj;
            return Intrinsics.areEqual(this.developerInitiatedCancellation, canceledStateContext.developerInitiatedCancellation) && Intrinsics.areEqual(this.replacementCancellation, canceledStateContext.replacementCancellation) && Intrinsics.areEqual(this.systemInitiatedCancellation, canceledStateContext.systemInitiatedCancellation) && Intrinsics.areEqual(this.userInitiatedCancellation, canceledStateContext.userInitiatedCancellation);
        }
        return false;
    }

    public final int hashCode() {
        DeveloperInitiatedCancellation developerInitiatedCancellation = this.developerInitiatedCancellation;
        int hashCode = (developerInitiatedCancellation == null ? 0 : developerInitiatedCancellation.hashCode()) * 31;
        ReplacementCancellation replacementCancellation = this.replacementCancellation;
        int hashCode2 = (hashCode + (replacementCancellation == null ? 0 : replacementCancellation.hashCode())) * 31;
        SystemInitiatedCancellation systemInitiatedCancellation = this.systemInitiatedCancellation;
        int hashCode3 = (hashCode2 + (systemInitiatedCancellation == null ? 0 : systemInitiatedCancellation.hashCode())) * 31;
        UserInitiatedCancellation userInitiatedCancellation = this.userInitiatedCancellation;
        return hashCode3 + (userInitiatedCancellation != null ? userInitiatedCancellation.hashCode() : 0);
    }

    public final String toString() {
        DeveloperInitiatedCancellation developerInitiatedCancellation = this.developerInitiatedCancellation;
        ReplacementCancellation replacementCancellation = this.replacementCancellation;
        SystemInitiatedCancellation systemInitiatedCancellation = this.systemInitiatedCancellation;
        return "CanceledStateContext(developerInitiatedCancellation=" + developerInitiatedCancellation + ", replacementCancellation=" + replacementCancellation + ", systemInitiatedCancellation=" + systemInitiatedCancellation + ", userInitiatedCancellation=" + this.userInitiatedCancellation + ")";
    }

    public static /* synthetic */ CanceledStateContext copy$default(CanceledStateContext canceledStateContext, DeveloperInitiatedCancellation developerInitiatedCancellation, ReplacementCancellation replacementCancellation, SystemInitiatedCancellation systemInitiatedCancellation, UserInitiatedCancellation userInitiatedCancellation, int i, Object obj) {
        if ((i & 1) != 0) {
            developerInitiatedCancellation = canceledStateContext.developerInitiatedCancellation;
        }
        if ((i & 2) != 0) {
            replacementCancellation = canceledStateContext.replacementCancellation;
        }
        if ((i & 4) != 0) {
            systemInitiatedCancellation = canceledStateContext.systemInitiatedCancellation;
        }
        if ((i & 8) != 0) {
            userInitiatedCancellation = canceledStateContext.userInitiatedCancellation;
        }
        return canceledStateContext.copy(developerInitiatedCancellation, replacementCancellation, systemInitiatedCancellation, userInitiatedCancellation);
    }

    public final CanceledStateContext copy(DeveloperInitiatedCancellation developerInitiatedCancellation, ReplacementCancellation replacementCancellation, SystemInitiatedCancellation systemInitiatedCancellation, UserInitiatedCancellation userInitiatedCancellation) {
        return new CanceledStateContext(developerInitiatedCancellation, replacementCancellation, systemInitiatedCancellation, userInitiatedCancellation);
    }

    public final UserInitiatedCancellation component4() {
        return this.userInitiatedCancellation;
    }

    public final SystemInitiatedCancellation component3() {
        return this.systemInitiatedCancellation;
    }

    public final ReplacementCancellation component2() {
        return this.replacementCancellation;
    }

    public final DeveloperInitiatedCancellation component1() {
        return this.developerInitiatedCancellation;
    }
}
