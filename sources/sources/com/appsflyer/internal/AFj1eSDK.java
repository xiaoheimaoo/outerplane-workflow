package com.appsflyer.internal;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.appsflyer.AFLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0010\u0010%\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\b\u0010&\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\bH\u0002J\u0016\u0010*\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010.\u001a\u00020,H\u0002J\f\u0010/\u001a\u00020\b*\u00020\bH\u0002J \u00100\u001a\u000201*\u0002012\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/appsflyer/internal/util/EventUrlResolver;", "", "idProvider", "Lcom/appsflyer/internal/components/IdProvider;", "serverConfigUrlFormatter", "Lcom/appsflyer/internal/util/ServerConfigUrlFormatter;", "(Lcom/appsflyer/internal/components/IdProvider;Lcom/appsflyer/internal/util/ServerConfigUrlFormatter;)V", "getAdRevenueUrl", "", "getAppsTrackingUrl", "getArsBilling4", "getArsBilling5", "getDdlUrl", "getEventsTrackingUrl", "getFirstLaunchUrl", "getLaunchUrl", NotificationCompat.CATEGORY_EVENT, "Lcom/appsflyer/internal/model/event/AFEvent;", "getManualValidateOneTimePurchaseUrl", "getManualValidateSubscriptionPurchaseUrl", "getPlayIntegrityUrl", "getReferrerTrackingUrl", "getRegisterUrl", "getUrlForArs", "billingVersion", "getUrlForDdlEvent", "devKey", "timestamp", "getUrlForEvent", "getUrlForManualOneTimePurchaseValidation", "getUrlForManualSubscriptionPurchaseValidation", "getUrlForPlayIntegrityReporting", "getUrlForPrivacySandbox", "getUrlForRdMonitor", "getUrlForRegister", "getUrlForValidatePurchase", "getUrlForValidatePurchaseWithWebHandler", "getUrlForViap", "getValidatePurchaseUrl", "getValidatePurchaseWithWebHandlerUrl", "getViapBilling4", "getViapBilling5", "appendBuildNumber", "isAdRevenueEvent", "", "appendConfiguredChannel", "isRegisterEvent", "appendPackageName", "appendSigQueryParam", "Landroid/net/Uri$Builder;", "Companion", "SDK_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFj1eSDK {
    public static final String AFAdRevenueData;
    public static final String areAllFieldsValid;
    public static final String component1;
    public static final String component2;
    public static final String component4;
    private static final String copydefault;
    public static final String getMediationNetwork;
    public final AFk1ySDK getMonetizationNetwork;
    private final AFc1pSDK toString;
    public static final AFa1vSDK getRevenue = new AFa1vSDK(null);
    public static final String getCurrencyIso4217Code = "https://%sadrevenue.%s/api/v2/generic/v6.17.3/android?app_id=";
    public static final String component3 = "https://%smonitorsdk.%s/api/remote-debug/v2.0?app_id=";

    public static String AFAdRevenueData() {
        return "https://privacy-sandbox.appsflyersdk.com/api/trigger";
    }

    private AFj1eSDK(AFc1pSDK aFc1pSDK, AFk1ySDK aFk1ySDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFk1ySDK, "");
        this.toString = aFc1pSDK;
        this.getMonetizationNetwork = aFk1ySDK;
    }

    public /* synthetic */ AFj1eSDK(AFc1pSDK aFc1pSDK, AFk1wSDK aFk1wSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1pSDK, (i & 2) != 0 ? new AFk1wSDK() : aFk1wSDK);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/AFj1eSDK$AFa1vSDK;", "", "<init>", "()V", "", "copydefault", "Ljava/lang/String;", "getMonetizationNetwork", "getCurrencyIso4217Code", "getMediationNetwork", "getRevenue", "areAllFieldsValid", "component2", "AFAdRevenueData", "component3", "component1", "component4"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AFa1vSDK {
        private AFa1vSDK() {
        }

        public /* synthetic */ AFa1vSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String str = AFa1uSDK.AFAdRevenueData + "/androidevent?app_id=";
        copydefault = str;
        AFAdRevenueData = "https://%sattr.%s/api/v" + str;
        getMediationNetwork = "https://%sconversions.%s/api/v" + str;
        component2 = "https://%slaunches.%s/api/v" + str;
        areAllFieldsValid = "https://%sinapps.%s/api/v" + str;
        component1 = "https://%sregister.%s/api/v" + str;
        component4 = "https://%svalidate.%s/api/v" + str;
    }

    public final String getMonetizationNetwork(String str, String str2) {
        String packageName = this.toString.getRevenue.getRevenue.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        String areAllFieldsValid2 = this.toString.areAllFieldsValid();
        String str3 = areAllFieldsValid2;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            areAllFieldsValid2 = "-" + StringsKt.trim((CharSequence) str3).toString();
        }
        if (areAllFieldsValid2 == null) {
            areAllFieldsValid2 = "";
        }
        Uri.Builder appendPath = Uri.parse(this.getMonetizationNetwork.getCurrencyIso4217Code("https://%sdlsdk.%s/v1.0/android/")).buildUpon().appendPath(packageName + StringsKt.trim((CharSequence) areAllFieldsValid2).toString());
        Intrinsics.checkNotNullExpressionValue(appendPath, "");
        if (str == null || str2 == null) {
            String str4 = str == null ? "devKey" : "timestamp";
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, str4.concat(" is null at attempt to generate ddl event url"), new IllegalStateException(str4.concat(" is null")), true, false, false, true);
        } else {
            appendPath.appendQueryParameter("af_sig", AFj1bSDK.getRevenue(str2 + str, str));
        }
        String obj = appendPath.appendQueryParameter("sdk_version", AFa1uSDK.AFAdRevenueData).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final String getRevenue(String str) {
        return str + this.toString.getRevenue.getRevenue.getPackageName();
    }

    public static String getMediationNetwork(String str, boolean z) {
        return str + (!z ? "&buildnumber=6.17.3" : "");
    }

    public static /* synthetic */ String getRevenue(AFj1eSDK aFj1eSDK, String str) {
        return aFj1eSDK.getMonetizationNetwork(str, false);
    }

    public final String getMonetizationNetwork(String str, boolean z) {
        if (z) {
            return str;
        }
        String areAllFieldsValid2 = this.toString.areAllFieldsValid();
        String str2 = areAllFieldsValid2 != null ? "&channel=" + areAllFieldsValid2 : null;
        if (str2 == null) {
            str2 = "";
        }
        return str + str2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AFj1eSDK(AFc1pSDK aFc1pSDK) {
        this(aFc1pSDK, null, 2, null);
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
    }
}
