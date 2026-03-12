package com.appsflyer.internal.models;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1f;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\b\u0086\b\u0018\u0000 W2\u00020\u0001:\u0001WB\u0083\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0012HÇ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001e\u0010\u001aJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0015HÇ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0004HÇ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0006HÇ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b%\u0010\u001aJ\u0010\u0010&\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b&\u0010\u001aJ\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÇ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b)\u0010\u001aJ\u0012\u0010*\u001a\u0004\u0018\u00010\u000eHÇ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b,\u0010\u001aJ¤\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÇ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00103\u001a\u000202HÖ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b5\u0010\u001aR\u001a\u00106\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u001aR\u001c\u00109\u001a\u0004\u0018\u00010\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\"R\u001c\u0010<\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010$R\u001a\u0010?\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u00107\u001a\u0004\b@\u0010\u001aR\u001a\u0010A\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u00107\u001a\u0004\bB\u0010\u001aR \u0010C\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010(R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bF\u00107\u001a\u0004\bG\u0010\u001aR\u001c\u0010H\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010+R\u001a\u0010K\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bK\u00107\u001a\u0004\bL\u0010\u001aR\u001a\u0010M\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bM\u00107\u001a\u0004\bN\u0010\u001aR\u001c\u0010O\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\u001dR\u001a\u0010R\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bR\u00107\u001a\u0004\bS\u0010\u001aR\u001c\u0010T\u001a\u0004\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010 "}, d2 = {"Lcom/appsflyer/internal/models/SubscriptionPurchase;", "", "", "p0", "Lcom/appsflyer/internal/models/CanceledStateContext;", "p1", "Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;", "p2", "p3", "p4", "", "Lcom/appsflyer/internal/models/SubscriptionPurchaseLineItem;", "p5", "p6", "Lcom/appsflyer/internal/models/PausedStateContext;", "p7", "p8", "p9", "Lcom/appsflyer/internal/models/SubscribeWithGoogleInfo;", "p10", "p11", "Lcom/appsflyer/internal/models/TestPurchase;", "p12", "<init>", "(Ljava/lang/String;Lcom/appsflyer/internal/models/CanceledStateContext;Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/appsflyer/internal/models/PausedStateContext;Ljava/lang/String;Ljava/lang/String;Lcom/appsflyer/internal/models/SubscribeWithGoogleInfo;Ljava/lang/String;Lcom/appsflyer/internal/models/TestPurchase;)V", "component1", "()Ljava/lang/String;", "component10", "component11", "()Lcom/appsflyer/internal/models/SubscribeWithGoogleInfo;", "component12", "component13", "()Lcom/appsflyer/internal/models/TestPurchase;", "component2", "()Lcom/appsflyer/internal/models/CanceledStateContext;", "component3", "()Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;", "component4", "component5", "component6", "()Ljava/util/List;", "component7", "component8", "()Lcom/appsflyer/internal/models/PausedStateContext;", "component9", "copy", "(Ljava/lang/String;Lcom/appsflyer/internal/models/CanceledStateContext;Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/appsflyer/internal/models/PausedStateContext;Ljava/lang/String;Ljava/lang/String;Lcom/appsflyer/internal/models/SubscribeWithGoogleInfo;Ljava/lang/String;Lcom/appsflyer/internal/models/TestPurchase;)Lcom/appsflyer/internal/models/SubscriptionPurchase;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "acknowledgementState", "Ljava/lang/String;", "getAcknowledgementState", "canceledStateContext", "Lcom/appsflyer/internal/models/CanceledStateContext;", "getCanceledStateContext", "externalAccountIdentifiers", "Lcom/appsflyer/internal/models/ExternalAccountIdentifiers;", "getExternalAccountIdentifiers", "kind", "getKind", "latestOrderId", "getLatestOrderId", "lineItems", "Ljava/util/List;", "getLineItems", "linkedPurchaseToken", "getLinkedPurchaseToken", "pausedStateContext", "Lcom/appsflyer/internal/models/PausedStateContext;", "getPausedStateContext", "regionCode", "getRegionCode", "startTime", "getStartTime", "subscribeWithGoogleInfo", "Lcom/appsflyer/internal/models/SubscribeWithGoogleInfo;", "getSubscribeWithGoogleInfo", "subscriptionState", "getSubscriptionState", "testPurchase", "Lcom/appsflyer/internal/models/TestPurchase;", "getTestPurchase", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionPurchase {
    public static final Companion Companion = new Companion(null);
    private final String acknowledgementState;
    private final CanceledStateContext canceledStateContext;
    private final ExternalAccountIdentifiers externalAccountIdentifiers;
    private final String kind;
    private final String latestOrderId;
    private final List<SubscriptionPurchaseLineItem> lineItems;
    private final String linkedPurchaseToken;
    private final PausedStateContext pausedStateContext;
    private final String regionCode;
    private final String startTime;
    private final SubscribeWithGoogleInfo subscribeWithGoogleInfo;
    private final String subscriptionState;
    private final TestPurchase testPurchase;

    public SubscriptionPurchase(String str, CanceledStateContext canceledStateContext, ExternalAccountIdentifiers externalAccountIdentifiers, String str2, String str3, List<SubscriptionPurchaseLineItem> list, String str4, PausedStateContext pausedStateContext, String str5, String str6, SubscribeWithGoogleInfo subscribeWithGoogleInfo, String str7, TestPurchase testPurchase) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.acknowledgementState = str;
        this.canceledStateContext = canceledStateContext;
        this.externalAccountIdentifiers = externalAccountIdentifiers;
        this.kind = str2;
        this.latestOrderId = str3;
        this.lineItems = list;
        this.linkedPurchaseToken = str4;
        this.pausedStateContext = pausedStateContext;
        this.regionCode = str5;
        this.startTime = str6;
        this.subscribeWithGoogleInfo = subscribeWithGoogleInfo;
        this.subscriptionState = str7;
        this.testPurchase = testPurchase;
    }

    public final String getAcknowledgementState() {
        return this.acknowledgementState;
    }

    public final CanceledStateContext getCanceledStateContext() {
        return this.canceledStateContext;
    }

    public final ExternalAccountIdentifiers getExternalAccountIdentifiers() {
        return this.externalAccountIdentifiers;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getLatestOrderId() {
        return this.latestOrderId;
    }

    public final List<SubscriptionPurchaseLineItem> getLineItems() {
        return this.lineItems;
    }

    public final String getLinkedPurchaseToken() {
        return this.linkedPurchaseToken;
    }

    public final PausedStateContext getPausedStateContext() {
        return this.pausedStateContext;
    }

    public final String getRegionCode() {
        return this.regionCode;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final SubscribeWithGoogleInfo getSubscribeWithGoogleInfo() {
        return this.subscribeWithGoogleInfo;
    }

    public final String getSubscriptionState() {
        return this.subscriptionState;
    }

    public final TestPurchase getTestPurchase() {
        return this.testPurchase;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/SubscriptionPurchase$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/SubscriptionPurchase;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/SubscriptionPurchase;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<SubscriptionPurchase> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static char InAppPurchaseEvent = 46273;
        private static int PurchaseClient = 1;
        private static long getOneTimePurchaseOfferDetails = 566631410124197933L;
        private static char getPackageName = 6970;
        private static char getQuantity = 34449;
        private static int hashCode = 0;
        private static char toJsonMap = 22370;

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* bridge */ /* synthetic */ SubscriptionPurchase fromJson(JSONObject jSONObject) {
            int i = PurchaseClient + 101;
            hashCode = i % 128;
            int i2 = i % 2;
            SubscriptionPurchase fromJson = fromJson(jSONObject);
            int i3 = PurchaseClient + 85;
            hashCode = i3 % 128;
            int i4 = i3 % 2;
            return fromJson;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        public final SubscriptionPurchase fromJson(JSONObject jSONObject) {
            List list;
            Object object;
            Object object2;
            Object nullable;
            Object object3;
            Object object4;
            Object object5;
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a("뷩\ude9d笉鞳〈䳄\ue946\u05ff꙾", View.getDefaultSize(0, 0) + 25457, objArr);
            JSONArray jSONArray = jSONObject.getJSONArray(((String) objArr[0]).intern());
            Intrinsics.checkNotNullExpressionValue(jSONArray, "");
            list = SubscriptionPurchaseKt.toList(jSONArray);
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (true) {
                if ((it.hasNext() ? 'R' : '#') != 'R') {
                    break;
                }
                int i = hashCode + 85;
                PurchaseClient = i % 128;
                int i2 = i % 2;
                arrayList.add(SubscriptionPurchaseLineItem.Companion.fromJson((JSONObject) it.next()));
            }
            ArrayList arrayList2 = arrayList;
            Object[] objArr2 = new Object[1];
            b("㩃ऋ틌ﷶꓦ\uf49b蛖ᚍಧᆧ১䚠㰟壀斑哱唩詎\ued0e\uf5d6", 20 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr2);
            String optString = jSONObject.optString(((String) objArr2[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            Object[] objArr3 = new Object[1];
            a("뷦恿\u06dd┷쮌\ue9ee豂닜儎瞂ᗪ㡘\udea4ﴙꎐ䇾摁ફ⤛콰", Color.blue(0) + 56731, objArr3);
            object = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr3[0]).intern(), CanceledStateContext.Companion);
            CanceledStateContext canceledStateContext = (CanceledStateContext) object;
            Object[] objArr4 = new Object[1];
            a("뷠\uf7fe⧷揩闻쿤Ƕ민\ueddc⟽姸鏋엔翌뇛\uebe1᷑埓觝쏈痐꿜\ue1aeᮥ䶿螽", 18947 - KeyEvent.getDeadChar(0, 0), objArr4);
            object2 = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr4[0]).intern(), ExternalAccountIdentifiers.Companion);
            ExternalAccountIdentifiers externalAccountIdentifiers = (ExternalAccountIdentifiers) object2;
            Object[] objArr5 = new Object[1];
            b("㽐﨑翌\uf0d8", (ViewConfiguration.getWindowTouchSlop() >> 8) + 4, objArr5);
            String optString2 = jSONObject.optString(((String) objArr5[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString2, "");
            Object[] objArr6 = new Object[1];
            b("癌\ue851\ued0e\uf5d6沙箧憅ᆯ备\ue05dڕ㧾猽杆", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 13, objArr6);
            String optString3 = jSONObject.optString(((String) objArr6[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString3, "");
            Object[] objArr7 = new Object[1];
            b("ⶎ緟큄䷡춵蔐Û目ʯ\ufc7a3䋟矑䈥蚗柭뎊\uf029䰸剁", (ViewConfiguration.getScrollBarSize() >> 8) + 19, objArr7);
            nullable = SubscriptionPurchaseKt.getNullable(jSONObject, ((String) objArr7[0]).intern());
            String str = (String) nullable;
            Object[] objArr8 = new Object[1];
            b("\uf41f鈶\uaa38텋춵蔐\u208f梠閮\ud8de攇狼ݑ謢\ued0e\uf5d6ဿ睥", View.resolveSizeAndState(0, 0, 0) + 18, objArr8);
            object3 = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr8[0]).intern(), PausedStateContext.Companion);
            PausedStateContext pausedStateContext = (PausedStateContext) object3;
            Object[] objArr9 = new Object[1];
            a("뷷睛⢔\udddd霆䡌綤㛷\ue839鵳", 51898 - TextUtils.lastIndexOf("", '0', 0, 0), objArr9);
            String optString4 = jSONObject.optString(((String) objArr9[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString4, "");
            Object[] objArr10 = new Object[1];
            a("뷶⡜难糰\ueb45冰㿢꩓ႈ", 38316 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr10);
            String optString5 = jSONObject.optString(((String) objArr10[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString5, "");
            Object[] objArr11 = new Object[1];
            a("뷶僷柩竣৺᳔㏆웖험\ue8edﾪ銼ꆹ뒙䮈広涒\u009eឞ⩉㥧챰\ue370", 60679 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr11);
            object4 = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr11[0]).intern(), SubscribeWithGoogleInfo.Companion);
            SubscribeWithGoogleInfo subscribeWithGoogleInfo = (SubscribeWithGoogleInfo) object4;
            Object[] objArr12 = new Object[1];
            b("\uebc9ｭ茇⿕雿⚫뷪昏\uddb4뗰ݑ謢\u208f梠閮\ud8de쮦\udcce", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 16, objArr12);
            String optString6 = jSONObject.optString(((String) objArr12[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString6, "");
            Object[] objArr13 = new Object[1];
            a("뷱圅格絞ᙁ⮉㲩톥\ueac5￩鄄\uaa37", ExpandableListView.getPackedPositionChild(0L) + 60134, objArr13);
            object5 = SubscriptionPurchaseKt.toObject(jSONObject, ((String) objArr13[0]).intern(), TestPurchase.Companion);
            SubscriptionPurchase subscriptionPurchase = new SubscriptionPurchase(optString, canceledStateContext, externalAccountIdentifiers, optString2, optString3, arrayList2, str, pausedStateContext, optString4, optString5, subscribeWithGoogleInfo, optString6, (TestPurchase) object5);
            int i3 = PurchaseClient + 61;
            hashCode = i3 % 128;
            if (i3 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            return subscriptionPurchase;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v4, types: [char[]] */
        private static void a(String str, int i, Object[] objArr) {
            if ((str != 0 ? '3' : 'O') != 'O') {
                str = str.toCharArray();
                int i2 = $10 + 105;
                $11 = i2 % 128;
                int i3 = i2 % 2;
            }
            char[] cArr = (char[]) str;
            AFPurchaseConnectorA1g aFPurchaseConnectorA1g = new AFPurchaseConnectorA1g();
            aFPurchaseConnectorA1g.getPackageName = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            aFPurchaseConnectorA1g.InAppPurchaseEvent = 0;
            while (true) {
                if (!(aFPurchaseConnectorA1g.InAppPurchaseEvent < cArr.length)) {
                    break;
                }
                int i4 = $10 + 1;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] = (cArr[aFPurchaseConnectorA1g.InAppPurchaseEvent] ^ (aFPurchaseConnectorA1g.InAppPurchaseEvent * aFPurchaseConnectorA1g.getPackageName)) ^ (getOneTimePurchaseOfferDetails ^ 5319290379872349608L);
                aFPurchaseConnectorA1g.InAppPurchaseEvent++;
            }
            char[] cArr2 = new char[length];
            aFPurchaseConnectorA1g.InAppPurchaseEvent = 0;
            while (true) {
                if ((aFPurchaseConnectorA1g.InAppPurchaseEvent < cArr.length ? 'J' : (char) 5) == 'J') {
                    cArr2[aFPurchaseConnectorA1g.InAppPurchaseEvent] = (char) jArr[aFPurchaseConnectorA1g.InAppPurchaseEvent];
                    aFPurchaseConnectorA1g.InAppPurchaseEvent++;
                } else {
                    objArr[0] = new String(cArr2);
                    return;
                }
            }
        }

        private static void b(String str, int i, Object[] objArr) {
            int i2 = $10 + 21;
            $11 = i2 % 128;
            if (i2 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            char[] charArray = str != null ? str.toCharArray() : str;
            AFPurchaseConnectorA1f aFPurchaseConnectorA1f = new AFPurchaseConnectorA1f();
            char[] cArr = new char[charArray.length];
            aFPurchaseConnectorA1f.getQuantity = 0;
            char[] cArr2 = new char[2];
            while (aFPurchaseConnectorA1f.getQuantity < charArray.length) {
                cArr2[0] = charArray[aFPurchaseConnectorA1f.getQuantity];
                cArr2[1] = charArray[aFPurchaseConnectorA1f.getQuantity + 1];
                int i3 = 58224;
                int i4 = 0;
                while (true) {
                    if ((i4 < 16 ? 'V' : 'A') != 'V') {
                        break;
                    }
                    int i5 = $11 + 87;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    char c = cArr2[1];
                    char c2 = cArr2[0];
                    char c3 = (char) (c - (((c2 + i3) ^ ((c2 << 4) + ((char) (toJsonMap ^ (-177179452616573881L))))) ^ ((c2 >>> 5) + ((char) (getPackageName ^ (-177179452616573881L))))));
                    cArr2[1] = c3;
                    cArr2[0] = (char) (c2 - (((c3 >>> 5) + ((char) (InAppPurchaseEvent ^ (-177179452616573881L)))) ^ ((c3 + i3) ^ ((c3 << 4) + ((char) (getQuantity ^ (-177179452616573881L)))))));
                    i3 -= 40503;
                    i4++;
                }
                cArr[aFPurchaseConnectorA1f.getQuantity] = cArr2[0];
                cArr[aFPurchaseConnectorA1f.getQuantity + 1] = cArr2[1];
                aFPurchaseConnectorA1f.getQuantity += 2;
            }
            objArr[0] = new String(cArr, 0, i);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubscriptionPurchase) {
            SubscriptionPurchase subscriptionPurchase = (SubscriptionPurchase) obj;
            return Intrinsics.areEqual(this.acknowledgementState, subscriptionPurchase.acknowledgementState) && Intrinsics.areEqual(this.canceledStateContext, subscriptionPurchase.canceledStateContext) && Intrinsics.areEqual(this.externalAccountIdentifiers, subscriptionPurchase.externalAccountIdentifiers) && Intrinsics.areEqual(this.kind, subscriptionPurchase.kind) && Intrinsics.areEqual(this.latestOrderId, subscriptionPurchase.latestOrderId) && Intrinsics.areEqual(this.lineItems, subscriptionPurchase.lineItems) && Intrinsics.areEqual(this.linkedPurchaseToken, subscriptionPurchase.linkedPurchaseToken) && Intrinsics.areEqual(this.pausedStateContext, subscriptionPurchase.pausedStateContext) && Intrinsics.areEqual(this.regionCode, subscriptionPurchase.regionCode) && Intrinsics.areEqual(this.startTime, subscriptionPurchase.startTime) && Intrinsics.areEqual(this.subscribeWithGoogleInfo, subscriptionPurchase.subscribeWithGoogleInfo) && Intrinsics.areEqual(this.subscriptionState, subscriptionPurchase.subscriptionState) && Intrinsics.areEqual(this.testPurchase, subscriptionPurchase.testPurchase);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.acknowledgementState.hashCode() * 31;
        CanceledStateContext canceledStateContext = this.canceledStateContext;
        int hashCode2 = (hashCode + (canceledStateContext == null ? 0 : canceledStateContext.hashCode())) * 31;
        ExternalAccountIdentifiers externalAccountIdentifiers = this.externalAccountIdentifiers;
        int hashCode3 = (((((((hashCode2 + (externalAccountIdentifiers == null ? 0 : externalAccountIdentifiers.hashCode())) * 31) + this.kind.hashCode()) * 31) + this.latestOrderId.hashCode()) * 31) + this.lineItems.hashCode()) * 31;
        String str = this.linkedPurchaseToken;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        PausedStateContext pausedStateContext = this.pausedStateContext;
        int hashCode5 = (((((hashCode4 + (pausedStateContext == null ? 0 : pausedStateContext.hashCode())) * 31) + this.regionCode.hashCode()) * 31) + this.startTime.hashCode()) * 31;
        SubscribeWithGoogleInfo subscribeWithGoogleInfo = this.subscribeWithGoogleInfo;
        int hashCode6 = (((hashCode5 + (subscribeWithGoogleInfo == null ? 0 : subscribeWithGoogleInfo.hashCode())) * 31) + this.subscriptionState.hashCode()) * 31;
        TestPurchase testPurchase = this.testPurchase;
        return hashCode6 + (testPurchase != null ? testPurchase.hashCode() : 0);
    }

    public final String toString() {
        String str = this.acknowledgementState;
        CanceledStateContext canceledStateContext = this.canceledStateContext;
        ExternalAccountIdentifiers externalAccountIdentifiers = this.externalAccountIdentifiers;
        String str2 = this.kind;
        String str3 = this.latestOrderId;
        List<SubscriptionPurchaseLineItem> list = this.lineItems;
        String str4 = this.linkedPurchaseToken;
        PausedStateContext pausedStateContext = this.pausedStateContext;
        String str5 = this.regionCode;
        String str6 = this.startTime;
        SubscribeWithGoogleInfo subscribeWithGoogleInfo = this.subscribeWithGoogleInfo;
        String str7 = this.subscriptionState;
        return "SubscriptionPurchase(acknowledgementState=" + str + ", canceledStateContext=" + canceledStateContext + ", externalAccountIdentifiers=" + externalAccountIdentifiers + ", kind=" + str2 + ", latestOrderId=" + str3 + ", lineItems=" + list + ", linkedPurchaseToken=" + str4 + ", pausedStateContext=" + pausedStateContext + ", regionCode=" + str5 + ", startTime=" + str6 + ", subscribeWithGoogleInfo=" + subscribeWithGoogleInfo + ", subscriptionState=" + str7 + ", testPurchase=" + this.testPurchase + ")";
    }

    public final SubscriptionPurchase copy(String str, CanceledStateContext canceledStateContext, ExternalAccountIdentifiers externalAccountIdentifiers, String str2, String str3, List<SubscriptionPurchaseLineItem> list, String str4, PausedStateContext pausedStateContext, String str5, String str6, SubscribeWithGoogleInfo subscribeWithGoogleInfo, String str7, TestPurchase testPurchase) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        return new SubscriptionPurchase(str, canceledStateContext, externalAccountIdentifiers, str2, str3, list, str4, pausedStateContext, str5, str6, subscribeWithGoogleInfo, str7, testPurchase);
    }

    public final TestPurchase component13() {
        return this.testPurchase;
    }

    public final String component12() {
        return this.subscriptionState;
    }

    public final SubscribeWithGoogleInfo component11() {
        return this.subscribeWithGoogleInfo;
    }

    public final String component10() {
        return this.startTime;
    }

    public final String component9() {
        return this.regionCode;
    }

    public final PausedStateContext component8() {
        return this.pausedStateContext;
    }

    public final String component7() {
        return this.linkedPurchaseToken;
    }

    public final List<SubscriptionPurchaseLineItem> component6() {
        return this.lineItems;
    }

    public final String component5() {
        return this.latestOrderId;
    }

    public final String component4() {
        return this.kind;
    }

    public final ExternalAccountIdentifiers component3() {
        return this.externalAccountIdentifiers;
    }

    public final CanceledStateContext component2() {
        return this.canceledStateContext;
    }

    public final String component1() {
        return this.acknowledgementState;
    }
}
