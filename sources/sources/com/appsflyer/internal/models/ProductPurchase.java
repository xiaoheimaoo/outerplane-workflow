package com.appsflyer.internal.models;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1c;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA2x;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0001IBy\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001a\u0010\u0015J\u0010\u0010\u001b\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001b\u0010\u0015J\u0010\u0010\u001c\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001c\u0010\u0015J\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001f\u0010\u0015J\u0010\u0010 \u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b \u0010\u0015J\u0010\u0010!\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\u0018J\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u0018J\u0010\u0010#\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b#\u0010\u0015J\u009c\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020&2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b)\u0010\u0018J\u0010\u0010*\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b*\u0010\u0015R\u0017\u0010+\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0018R\u001a\u0010.\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010,\u001a\u0004\b/\u0010\u0018R\u001a\u00100\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0015R\u001a\u00103\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u00101\u001a\u0004\b4\u0010\u0015R\u001a\u00105\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u0010\u0015R\u001a\u00107\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u0010\u0015R\u001a\u00109\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u0010\u0015R\u001a\u0010;\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010\u0015R\u001a\u0010=\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010,\u001a\u0004\b>\u0010\u0018R\u001a\u0010?\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u0010\u0015R\u001a\u0010A\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u0010\u0015R\u001a\u0010C\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010,\u001a\u0004\bD\u0010\u0018R\u001a\u0010E\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010,\u001a\u0004\bF\u0010\u0018R\u001a\u0010G\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bG\u00101\u001a\u0004\bH\u0010\u0015"}, d2 = {"Lcom/appsflyer/internal/models/ProductPurchase;", "", "", "p0", "p1", "", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component10", "component11", "()I", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/appsflyer/internal/models/ProductPurchase;", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "acknowledgementState", "I", "getAcknowledgementState", "consumptionState", "getConsumptionState", "developerPayload", "Ljava/lang/String;", "getDeveloperPayload", "kind", "getKind", "obfuscatedExternalAccountId", "getObfuscatedExternalAccountId", "obfuscatedExternalProfileId", "getObfuscatedExternalProfileId", "orderId", "getOrderId", InAppPurchaseMetaData.KEY_PRODUCT_ID, "getProductId", "purchaseState", "getPurchaseState", "purchaseTimeMillis", "getPurchaseTimeMillis", "purchaseToken", "getPurchaseToken", "purchaseType", "getPurchaseType", FirebaseAnalytics.Param.QUANTITY, "getQuantity", "regionCode", "getRegionCode", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProductPurchase {
    public static final Companion Companion = new Companion(null);
    private final int acknowledgementState;
    private final int consumptionState;
    private final String developerPayload;
    private final String kind;
    private final String obfuscatedExternalAccountId;
    private final String obfuscatedExternalProfileId;
    private final String orderId;
    private final String productId;
    private final int purchaseState;
    private final String purchaseTimeMillis;
    private final String purchaseToken;
    private final int purchaseType;
    private final int quantity;
    private final String regionCode;

    public ProductPurchase(String str, String str2, int i, int i2, String str3, String str4, int i3, int i4, String str5, String str6, int i5, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        this.kind = str;
        this.purchaseTimeMillis = str2;
        this.purchaseState = i;
        this.consumptionState = i2;
        this.developerPayload = str3;
        this.orderId = str4;
        this.purchaseType = i3;
        this.acknowledgementState = i4;
        this.purchaseToken = str5;
        this.productId = str6;
        this.quantity = i5;
        this.obfuscatedExternalAccountId = str7;
        this.obfuscatedExternalProfileId = str8;
        this.regionCode = str9;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getPurchaseTimeMillis() {
        return this.purchaseTimeMillis;
    }

    public final int getPurchaseState() {
        return this.purchaseState;
    }

    public final int getConsumptionState() {
        return this.consumptionState;
    }

    public final String getDeveloperPayload() {
        return this.developerPayload;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final int getPurchaseType() {
        return this.purchaseType;
    }

    public final int getAcknowledgementState() {
        return this.acknowledgementState;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final String getObfuscatedExternalAccountId() {
        return this.obfuscatedExternalAccountId;
    }

    public final String getObfuscatedExternalProfileId() {
        return this.obfuscatedExternalProfileId;
    }

    public final String getRegionCode() {
        return this.regionCode;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/models/ProductPurchase$Companion;", "Lcom/appsflyer/internal/models/Deserialize;", "Lcom/appsflyer/internal/models/ProductPurchase;", "<init>", "()V", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Lcom/appsflyer/internal/models/ProductPurchase;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements Deserialize<ProductPurchase> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int PurchaseClient = 0;
        private static int equals = 1;
        private static int getOneTimePurchaseOfferDetails = 1688888230;
        private static int getPackageName = 1175623904;
        private static int getQuantity = -2078375;
        private static short[] toJsonMap;
        private static byte[] InAppPurchaseEvent = {SignedBytes.MAX_POWER_OF_TWO, 87, 72, -42, -16, -54, -122, -53, -41, -9, -34, -30, -42, -38, -30, 57, -37, Base64.padSymbol, -23, 53, -49, -42, -59, -44, -53, -64, -54, -43, -49, -36, -21, 47, -27, -47, -62, -45, -59, -57, -11, Utf8.REPLACEMENT_BYTE, 58, -38, -63, -43, 57, -51, -43, 125, Ascii.US, 113, 45, 99, 10, Ascii.NAK, 4, Ascii.DC4, 2, Ascii.SI, 3, 5, 121, Ascii.DC4, Ascii.CR, Ascii.SI, Ascii.DC4, Ascii.SO, -90, -40, -100, -15, -100, -8, Byte.MIN_VALUE, -115, -60, -60, -60, -60, -60, -60, -60};
        private static int[] stopObservingTransactions = {-989833201, 1143223520, -1012064137, -1343262758, 1670981312, -859429332, 1785487465, -2009815516, -771224981, 1290596811, 552937098, -65778887, 1218886644, 1666756460, -1614711560, -1162689365, -1805054757, 1026752911};

        private Companion() {
        }

        @Override // com.appsflyer.internal.models.Deserialize
        public final /* synthetic */ ProductPurchase fromJson(JSONObject jSONObject) {
            int i = equals + 59;
            PurchaseClient = i % 128;
            if ((i % 2 != 0 ? '\b' : 'C') == 'C') {
                return fromJson(jSONObject);
            }
            fromJson(jSONObject);
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.appsflyer.internal.models.Deserialize
        @JvmStatic
        public final ProductPurchase fromJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "");
            Object[] objArr = new Object[1];
            a((-582548215) - TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getScrollDefaultDelay() >> 16) - 32, (byte) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (short) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 114), 1175268964 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr);
            String optString = jSONObject.optString(((String) objArr[0]).intern());
            Object[] objArr2 = new Object[1];
            b(new int[]{2005301407, -60183927, -1207719689, 400653573, 1362738546, 420062478, 1113928308, 728412629, 380141090, 726507346}, View.resolveSizeAndState(0, 0, 0) + 18, objArr2);
            String optString2 = jSONObject.optString(((String) objArr2[0]).intern());
            Object[] objArr3 = new Object[1];
            a((-582548210) - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getScrollDefaultDelay() >> 16) - 23, (byte) TextUtils.indexOf("", ""), (short) ((-34) - ExpandableListView.getPackedPositionChild(0L)), 1175268967 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr3);
            int optInt = jSONObject.optInt(((String) objArr3[0]).intern(), -1);
            Object[] objArr4 = new Object[1];
            a((-582548223) - View.combineMeasuredStates(0, 0), (-20) - (ViewConfiguration.getKeyRepeatDelay() >> 16), (byte) View.combineMeasuredStates(0, 0), (short) ((-12) - View.resolveSize(0, 0)), 1175268978 - Color.red(0), objArr4);
            int optInt2 = jSONObject.optInt(((String) objArr4[0]).intern(), -1);
            Object[] objArr5 = new Object[1];
            b(new int[]{-1326057577, 791766696, -1433654798, -1635830386, 2135481497, -322530907, 1308775003, -422984170}, Gravity.getAbsoluteGravity(0, 0) + 16, objArr5);
            String optString3 = jSONObject.optString(((String) objArr5[0]).intern());
            Object[] objArr6 = new Object[1];
            a((-582548211) - Gravity.getAbsoluteGravity(0, 0), (-30) - ImageFormat.getBitsPerPixel(0), (byte) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (short) ((ViewConfiguration.getWindowTouchSlop() >> 8) - 20), 1175268992 - TextUtils.lastIndexOf("", '0', 0, 0), objArr6);
            String optString4 = jSONObject.optString(((String) objArr6[0]).intern());
            Object[] objArr7 = new Object[1];
            a((KeyEvent.getMaxKeyCode() >> 16) - 582548210, TextUtils.indexOf("", "", 0) - 24, (byte) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (short) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 12), 1175268999 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), objArr7);
            int optInt3 = jSONObject.optInt(((String) objArr7[0]).intern(), -1);
            Object[] objArr8 = new Object[1];
            a((-582548224) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (-15) - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (byte) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), (short) (TextUtils.lastIndexOf("", '0', 0, 0) + 57), 1175269011 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr8);
            int optInt4 = jSONObject.optInt(((String) objArr8[0]).intern(), -1);
            Object[] objArr9 = new Object[1];
            b(new int[]{2005301407, -60183927, -1207719689, 400653573, -1054609149, 632850071, -2107846801, -699867247}, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 13, objArr9);
            String optString5 = jSONObject.optString(((String) objArr9[0]).intern());
            Object[] objArr10 = new Object[1];
            a((-582548210) - (ViewConfiguration.getPressedStateDuration() >> 16), (-27) - (ViewConfiguration.getJumpTapTimeout() >> 16), (byte) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), (short) (View.combineMeasuredStates(0, 0) - 71), 1175269029 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr10);
            String optString6 = jSONObject.optString(((String) objArr10[0]).intern());
            Object[] objArr11 = new Object[1];
            b(new int[]{-545346571, -391332314, 443699041, -746527974}, 8 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr11);
            int optInt5 = jSONObject.optInt(((String) objArr11[0]).intern(), -1);
            Object[] objArr12 = new Object[1];
            b(new int[]{-1626725951, 1230683472, 1378003559, -1364087339, 1691992993, 1113039018, 222303335, 2009666220, -608474663, -2045665009, -666539501, 1939553639, 315608314, -2019676651}, ExpandableListView.getPackedPositionChild(0L) + 28, objArr12);
            String optString7 = jSONObject.optString(((String) objArr12[0]).intern());
            Object[] objArr13 = new Object[1];
            b(new int[]{-1626725951, 1230683472, 1378003559, -1364087339, 1691992993, 1113039018, 222303335, 2009666220, 585103710, 1153811338, -732915703, 2036937792, 1227427407, 1561955090}, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 26, objArr13);
            String optString8 = jSONObject.optString(((String) objArr13[0]).intern());
            Object[] objArr14 = new Object[1];
            b(new int[]{-74593020, -1978383024, -1878750948, -1905049167, 1905259955, 1187120085}, 10 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr14);
            String optString9 = jSONObject.optString(((String) objArr14[0]).intern());
            Intrinsics.checkNotNullExpressionValue(optString, "");
            Intrinsics.checkNotNullExpressionValue(optString2, "");
            Intrinsics.checkNotNullExpressionValue(optString3, "");
            Intrinsics.checkNotNullExpressionValue(optString4, "");
            Intrinsics.checkNotNullExpressionValue(optString5, "");
            Intrinsics.checkNotNullExpressionValue(optString6, "");
            Intrinsics.checkNotNullExpressionValue(optString7, "");
            Intrinsics.checkNotNullExpressionValue(optString8, "");
            Intrinsics.checkNotNullExpressionValue(optString9, "");
            ProductPurchase productPurchase = new ProductPurchase(optString, optString2, optInt, optInt2, optString3, optString4, optInt3, optInt4, optString5, optString6, optInt5, optString7, optString8, optString9);
            int i = equals + 89;
            PurchaseClient = i % 128;
            int i2 = i % 2;
            return productPurchase;
        }

        private static void b(int[] iArr, int i, Object[] objArr) {
            int i2;
            int length;
            int[] iArr2;
            AFPurchaseConnectorA1c aFPurchaseConnectorA1c = new AFPurchaseConnectorA1c();
            char[] cArr = new char[4];
            int i3 = 2;
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr3 = stopObservingTransactions;
            if (iArr3 != null) {
                int i4 = $10 + 43;
                $11 = i4 % 128;
                if ((i4 % 2 == 0 ? '=' : '0') != '0') {
                    length = iArr3.length;
                    iArr2 = new int[length];
                } else {
                    length = iArr3.length;
                    iArr2 = new int[length];
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = $10 + 125;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    iArr2[i5] = (int) (iArr3[i5] ^ (-6033101233399176549L));
                    i5++;
                }
                iArr3 = iArr2;
            }
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = stopObservingTransactions;
            if ((iArr5 != null ? '+' : 'V') != '+') {
                i2 = length2;
            } else {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i8 = 0;
                while (i8 < length3) {
                    int i9 = $11 + 119;
                    $10 = i9 % 128;
                    int i10 = i9 % i3;
                    iArr6[i8] = (int) (iArr5[i8] ^ (-6033101233399176549L));
                    i8++;
                    length2 = length2;
                    i3 = 2;
                }
                iArr5 = iArr6;
                i2 = length2;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, i2);
            aFPurchaseConnectorA1c.InAppPurchaseEvent = 0;
            while (true) {
                if (aFPurchaseConnectorA1c.InAppPurchaseEvent >= iArr.length) {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
                int i11 = $11 + 67;
                $10 = i11 % 128;
                int i12 = i11 % 2;
                cArr[0] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent] >> 16);
                cArr[1] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent];
                cArr[2] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1] >> 16);
                cArr[3] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1];
                aFPurchaseConnectorA1c.getQuantity = (cArr[0] << 16) + cArr[1];
                aFPurchaseConnectorA1c.toJsonMap = (cArr[2] << 16) + cArr[3];
                AFPurchaseConnectorA1c.InAppPurchaseEvent(iArr4);
                int i13 = 0;
                while (true) {
                    if (!(i13 >= 16)) {
                        int i14 = $11 + 57;
                        $10 = i14 % 128;
                        int i15 = i14 % 2;
                        aFPurchaseConnectorA1c.getQuantity ^= iArr4[i13];
                        aFPurchaseConnectorA1c.toJsonMap = AFPurchaseConnectorA1c.getQuantity(aFPurchaseConnectorA1c.getQuantity) ^ aFPurchaseConnectorA1c.toJsonMap;
                        int i16 = aFPurchaseConnectorA1c.getQuantity;
                        aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                        aFPurchaseConnectorA1c.toJsonMap = i16;
                        i13++;
                    }
                }
                int i17 = aFPurchaseConnectorA1c.getQuantity;
                aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                aFPurchaseConnectorA1c.toJsonMap = i17;
                aFPurchaseConnectorA1c.toJsonMap ^= iArr4[16];
                aFPurchaseConnectorA1c.getQuantity ^= iArr4[17];
                int i18 = aFPurchaseConnectorA1c.getQuantity;
                int i19 = aFPurchaseConnectorA1c.toJsonMap;
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

        private static void a(int i, int i2, byte b, short s, int i3, Object[] objArr) {
            boolean z;
            int i4;
            int i5;
            char c;
            int i6;
            int length;
            byte[] bArr;
            AFPurchaseConnectorA2x aFPurchaseConnectorA2x = new AFPurchaseConnectorA2x();
            StringBuilder sb = new StringBuilder();
            int i7 = ((int) (getPackageName ^ (-4208132002516133692L))) + i2;
            if (i7 == -1) {
                z = true;
            } else {
                int i8 = $10 + 7;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                z = false;
            }
            if (!(!z)) {
                byte[] bArr2 = InAppPurchaseEvent;
                if (bArr2 != null) {
                    int length2 = bArr2.length;
                    byte[] bArr3 = new byte[length2];
                    int i10 = 0;
                    while (i10 < length2) {
                        int i11 = $10 + 67;
                        $11 = i11 % 128;
                        if (i11 % 2 == 0) {
                            bArr3[i10] = (byte) (bArr2[i10] | (-4208132002516133692L));
                            i10 *= 1;
                        } else {
                            bArr3[i10] = (byte) (bArr2[i10] ^ (-4208132002516133692L));
                            i10++;
                        }
                    }
                    bArr2 = bArr3;
                }
                i7 = bArr2 != null ? (byte) (((byte) (InAppPurchaseEvent[i3 + ((int) (getQuantity ^ (-4208132002516133692L)))] ^ (-4208132002516133692L))) + ((int) (getPackageName ^ (-4208132002516133692L)))) : (short) (((short) (toJsonMap[i3 + ((int) (getQuantity ^ (-4208132002516133692L)))] ^ (-4208132002516133692L))) + ((int) (getPackageName ^ (-4208132002516133692L))));
            }
            if (i7 > 0) {
                aFPurchaseConnectorA2x.getPackageName = ((i3 + i7) - 2) + ((int) (getQuantity ^ (-4208132002516133692L))) + (z ? 1 : 0);
                aFPurchaseConnectorA2x.InAppPurchaseEvent = (char) (((int) (getOneTimePurchaseOfferDetails ^ (-4208132002516133692L))) + i);
                sb.append(aFPurchaseConnectorA2x.InAppPurchaseEvent);
                aFPurchaseConnectorA2x.getQuantity = aFPurchaseConnectorA2x.InAppPurchaseEvent;
                byte[] bArr4 = InAppPurchaseEvent;
                if (bArr4 != null) {
                    int i12 = $11 + 67;
                    $10 = i12 % 128;
                    if (i12 % 2 != 0) {
                        length = bArr4.length;
                        bArr = new byte[length];
                    } else {
                        length = bArr4.length;
                        bArr = new byte[length];
                    }
                    int i13 = 0;
                    while (true) {
                        if ((i13 < length ? '%' : '\f') != '%') {
                            break;
                        }
                        int i14 = $10 + 53;
                        $11 = i14 % 128;
                        int i15 = i14 % 2;
                        bArr[i13] = (byte) (bArr4[i13] ^ (-4208132002516133692L));
                        i13++;
                    }
                    bArr4 = bArr;
                }
                boolean z2 = bArr4 != null;
                aFPurchaseConnectorA2x.getOneTimePurchaseOfferDetails = 1;
                while (aFPurchaseConnectorA2x.getOneTimePurchaseOfferDetails < i7) {
                    if (z2) {
                        int i16 = $10 + 13;
                        $11 = i16 % 128;
                        if ((i16 % 2 == 0 ? 'G' : (char) 28) != 'G') {
                            byte[] bArr5 = InAppPurchaseEvent;
                            aFPurchaseConnectorA2x.getPackageName = aFPurchaseConnectorA2x.getPackageName - 1;
                            c = (char) (aFPurchaseConnectorA2x.getQuantity + (((byte) (((byte) (bArr5[i6] ^ (-4208132002516133692L))) + s)) ^ b));
                        } else {
                            byte[] bArr6 = InAppPurchaseEvent;
                            aFPurchaseConnectorA2x.getPackageName = aFPurchaseConnectorA2x.getPackageName << 1;
                            c = (char) (aFPurchaseConnectorA2x.getQuantity >> (((byte) (((byte) (bArr6[i5] % (-4208132002516133692L))) >>> s)) ^ b));
                        }
                        aFPurchaseConnectorA2x.InAppPurchaseEvent = c;
                    } else {
                        short[] sArr = toJsonMap;
                        aFPurchaseConnectorA2x.getPackageName = aFPurchaseConnectorA2x.getPackageName - 1;
                        aFPurchaseConnectorA2x.InAppPurchaseEvent = (char) (aFPurchaseConnectorA2x.getQuantity + (((short) (((short) (sArr[i4] ^ (-4208132002516133692L))) + s)) ^ b));
                    }
                    sb.append(aFPurchaseConnectorA2x.InAppPurchaseEvent);
                    aFPurchaseConnectorA2x.getQuantity = aFPurchaseConnectorA2x.InAppPurchaseEvent;
                    aFPurchaseConnectorA2x.getOneTimePurchaseOfferDetails++;
                }
            }
            objArr[0] = sb.toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static ProductPurchase fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductPurchase) {
            ProductPurchase productPurchase = (ProductPurchase) obj;
            return Intrinsics.areEqual(this.kind, productPurchase.kind) && Intrinsics.areEqual(this.purchaseTimeMillis, productPurchase.purchaseTimeMillis) && this.purchaseState == productPurchase.purchaseState && this.consumptionState == productPurchase.consumptionState && Intrinsics.areEqual(this.developerPayload, productPurchase.developerPayload) && Intrinsics.areEqual(this.orderId, productPurchase.orderId) && this.purchaseType == productPurchase.purchaseType && this.acknowledgementState == productPurchase.acknowledgementState && Intrinsics.areEqual(this.purchaseToken, productPurchase.purchaseToken) && Intrinsics.areEqual(this.productId, productPurchase.productId) && this.quantity == productPurchase.quantity && Intrinsics.areEqual(this.obfuscatedExternalAccountId, productPurchase.obfuscatedExternalAccountId) && Intrinsics.areEqual(this.obfuscatedExternalProfileId, productPurchase.obfuscatedExternalProfileId) && Intrinsics.areEqual(this.regionCode, productPurchase.regionCode);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((this.kind.hashCode() * 31) + this.purchaseTimeMillis.hashCode()) * 31) + Integer.hashCode(this.purchaseState)) * 31) + Integer.hashCode(this.consumptionState)) * 31) + this.developerPayload.hashCode()) * 31) + this.orderId.hashCode()) * 31) + Integer.hashCode(this.purchaseType)) * 31) + Integer.hashCode(this.acknowledgementState)) * 31) + this.purchaseToken.hashCode()) * 31) + this.productId.hashCode()) * 31) + Integer.hashCode(this.quantity)) * 31) + this.obfuscatedExternalAccountId.hashCode()) * 31) + this.obfuscatedExternalProfileId.hashCode()) * 31) + this.regionCode.hashCode();
    }

    public final String toString() {
        String str = this.kind;
        String str2 = this.purchaseTimeMillis;
        int i = this.purchaseState;
        int i2 = this.consumptionState;
        String str3 = this.developerPayload;
        String str4 = this.orderId;
        int i3 = this.purchaseType;
        int i4 = this.acknowledgementState;
        String str5 = this.purchaseToken;
        String str6 = this.productId;
        int i5 = this.quantity;
        String str7 = this.obfuscatedExternalAccountId;
        String str8 = this.obfuscatedExternalProfileId;
        return "ProductPurchase(kind=" + str + ", purchaseTimeMillis=" + str2 + ", purchaseState=" + i + ", consumptionState=" + i2 + ", developerPayload=" + str3 + ", orderId=" + str4 + ", purchaseType=" + i3 + ", acknowledgementState=" + i4 + ", purchaseToken=" + str5 + ", productId=" + str6 + ", quantity=" + i5 + ", obfuscatedExternalAccountId=" + str7 + ", obfuscatedExternalProfileId=" + str8 + ", regionCode=" + this.regionCode + ")";
    }

    public final ProductPurchase copy(String str, String str2, int i, int i2, String str3, String str4, int i3, int i4, String str5, String str6, int i5, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        return new ProductPurchase(str, str2, i, i2, str3, str4, i3, i4, str5, str6, i5, str7, str8, str9);
    }

    public final String component14() {
        return this.regionCode;
    }

    public final String component13() {
        return this.obfuscatedExternalProfileId;
    }

    public final String component12() {
        return this.obfuscatedExternalAccountId;
    }

    public final int component11() {
        return this.quantity;
    }

    public final String component10() {
        return this.productId;
    }

    public final String component9() {
        return this.purchaseToken;
    }

    public final int component8() {
        return this.acknowledgementState;
    }

    public final int component7() {
        return this.purchaseType;
    }

    public final String component6() {
        return this.orderId;
    }

    public final String component5() {
        return this.developerPayload;
    }

    public final int component4() {
        return this.consumptionState;
    }

    public final int component3() {
        return this.purchaseState;
    }

    public final String component2() {
        return this.purchaseTimeMillis;
    }

    public final String component1() {
        return this.kind;
    }
}
