package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.android.billingclient.api.BillingClient;
import com.appsflyer.AFAdRevenueData;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFPurchaseDetails;
import com.appsflyer.AppsFlyerConsent;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidationCallback;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFa1uSDK;
import com.appsflyer.internal.AFb1aSDK;
import com.appsflyer.internal.AFd1xSDK;
import com.appsflyer.internal.AFe1nSDK;
import com.appsflyer.internal.AFj1qSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1l;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.google.android.gms.common.GoogleApiAvailability;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFa1uSDK extends AppsFlyerLib {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String AFAdRevenueData;
    private static char[] AFInAppEventParameterName = null;
    private static int AFInAppEventType = 0;
    private static int AFKeystoreWrapper = 0;
    private static boolean AFLogger = false;
    private static AFa1uSDK areAllFieldsValid = null;
    private static int d = 1;
    static AppsFlyerInAppPurchaseValidatorListener getCurrencyIso4217Code;
    public static final String getRevenue;
    private static boolean registerClient;
    Application component3;
    private volatile SharedPreferences copy;
    private Map<Long, String> copydefault;
    private AFf1nSDK equals;
    private boolean toString;
    public volatile AppsFlyerConversionListener getMediationNetwork = null;
    private long component4 = -1;
    long getMonetizationNetwork = -1;
    private long component2 = TimeUnit.SECONDS.toMillis(5);
    boolean component1 = false;
    private final AFc1dSDK hashCode = new AFc1dSDK();

    public static /* synthetic */ Object getRevenue(Object[] objArr, int i, int i2, int i3) {
        int i4 = (i * (-1335)) + (i2 * (-667));
        int i5 = ~i2;
        int i6 = i | i3;
        switch (i4 + (((~i6) | i5) * (-668)) + ((i | (~(i3 | i5))) * 1336) + ((i6 | i5) * 668)) {
            case 1:
                return getCurrencyIso4217Code(objArr);
            case 2:
                int i7 = AFKeystoreWrapper + 89;
                d = i7 % 128;
                int i8 = i7 % 2;
                ((AFa1uSDK) objArr[0]).setSharingFilterForPartners((String[]) objArr[1]);
                int i9 = AFKeystoreWrapper + 21;
                d = i9 % 128;
                int i10 = i9 % 2;
                return null;
            case 3:
                AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                int i11 = d + 109;
                AFKeystoreWrapper = i11 % 128;
                int i12 = i11 % 2;
                getCurrencyIso4217Code(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION, Boolean.toString(booleanValue));
                int i13 = d + 105;
                AFKeystoreWrapper = i13 % 128;
                int i14 = i13 % 2;
                return null;
            case 4:
                return getMonetizationNetwork(objArr);
            case 5:
                return getRevenue(objArr);
            case 6:
                int intValue = ((Number) objArr[1]).intValue();
                int i15 = AFKeystoreWrapper + 61;
                d = i15 % 128;
                int i16 = i15 % 2;
                ((AFa1uSDK) objArr[0]).component2 = TimeUnit.SECONDS.toMillis(intValue);
                int i17 = d + 111;
                AFKeystoreWrapper = i17 % 128;
                int i18 = i17 % 2;
                return null;
            case 7:
                return getMediationNetwork(objArr);
            case 8:
                return AFAdRevenueData(objArr);
            case 9:
                return areAllFieldsValid(objArr);
            case 10:
                int i19 = AFKeystoreWrapper + 7;
                d = i19 % 128;
                int i20 = i19 % 2;
                ((AFa1uSDK) objArr[0]).logEvent((Context) objArr[1], (String) objArr[2], (Map) objArr[3], null);
                int i21 = AFKeystoreWrapper + 119;
                d = i21 % 128;
                int i22 = i21 % 2;
                return null;
            case 11:
                return component4(objArr);
            case 12:
                AFa1uSDK aFa1uSDK2 = (AFa1uSDK) objArr[0];
                boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
                int i23 = d + 111;
                AFKeystoreWrapper = i23 % 128;
                int i24 = i23 % 2;
                AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(booleanValue2)));
                getRevenue(new Object[]{AppsFlyerProperties.DISABLE_NETWORK_DATA, Boolean.valueOf(booleanValue2)}, -222394073, 222394090, (int) System.currentTimeMillis());
                int i25 = AFKeystoreWrapper + 69;
                d = i25 % 128;
                int i26 = i25 % 2;
                return null;
            case 13:
                return component2(objArr);
            case 14:
                return component3(objArr);
            case 15:
                return component1(objArr);
            case 16:
                AFa1uSDK aFa1uSDK3 = (AFa1uSDK) objArr[0];
                Context context = (Context) objArr[1];
                URI uri = (URI) objArr[2];
                int i27 = AFKeystoreWrapper + 37;
                int i28 = i27 % 128;
                d = i28;
                int i29 = i27 % 2;
                if ((uri != null ? (char) 17 : (char) 11) != 11) {
                    int i30 = i28 + 1;
                    AFKeystoreWrapper = i30 % 128;
                    int i31 = i30 % 2;
                    if (!uri.toString().isEmpty()) {
                        if (context == null) {
                            ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK3}, 389316487, -389316474, System.identityHashCode(aFa1uSDK3))).i().getMediationNetwork(new StringBuilder("Context is \"").append(context).append("\"").toString(), DeepLinkResult.Error.NETWORK);
                            return null;
                        }
                        aFa1uSDK3.getMediationNetwork(context);
                        ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK3}, 389316487, -389316474, System.identityHashCode(aFa1uSDK3))).i().g_(AFa1gSDK.getMonetizationNetwork(((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK3}, 389316487, -389316474, System.identityHashCode(aFa1uSDK3))).afErrorLogForExcManagerOnly()), Uri.parse(uri.toString()));
                        return null;
                    }
                }
                ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK3}, 389316487, -389316474, System.identityHashCode(aFa1uSDK3))).i().getMediationNetwork(new StringBuilder("Link is \"").append(uri).append("\"").toString(), DeepLinkResult.Error.NETWORK);
                return null;
            case 17:
                return copy(objArr);
            case 18:
                AFa1uSDK aFa1uSDK4 = (AFa1uSDK) objArr[0];
                int i32 = d + 47;
                AFKeystoreWrapper = i32 % 128;
                return (AFj1qSDK[]) ((i32 % 2 != 0 ? '5' : (char) 26) != '5' ? ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK4}, 389316487, -389316474, System.identityHashCode(aFa1uSDK4))).AFLogger().getCurrencyIso4217Code.toArray(new AFj1qSDK[0]) : ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK4}, 389316487, -389316474, System.identityHashCode(aFa1uSDK4))).AFLogger().getCurrencyIso4217Code.toArray(new AFj1qSDK[1]));
            case 19:
                return toString(objArr);
            case 20:
                AFa1uSDK aFa1uSDK5 = (AFa1uSDK) objArr[0];
                ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK5}, 389316487, -389316474, System.identityHashCode(aFa1uSDK5))).afInfoLog().getRevenue = new AFb1uSDK((String[]) objArr[1]);
                int i33 = d + 31;
                AFKeystoreWrapper = i33 % 128;
                int i34 = i33 % 2;
                return null;
            case 21:
                return hashCode(objArr);
            case 22:
                return copydefault(objArr);
            case 23:
                Context context2 = (Context) objArr[1];
                String str = (String) objArr[2];
                ((AFa1uSDK) objArr[0]).getMediationNetwork(context2);
                AFg1tSDK aFg1tSDK = new AFg1tSDK(context2);
                if (str == null || str.trim().isEmpty()) {
                    AFLogger.INSTANCE.w(AFg1cSDK.UNINSTALL, "Firebase Token is either empty or null and was not registered.");
                    return null;
                }
                AFLogger.INSTANCE.i(AFg1cSDK.UNINSTALL, "Firebase Refreshed Token = ".concat(String.valueOf(str)));
                AFf1aSDK revenue = aFg1tSDK.getRevenue();
                if (revenue == null || !str.equals(revenue.getMonetizationNetwork)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z = revenue == null || currentTimeMillis - revenue.getCurrencyIso4217Code > TimeUnit.SECONDS.toMillis(2L);
                    AFf1aSDK aFf1aSDK = new AFf1aSDK(str, currentTimeMillis, !z);
                    aFg1tSDK.getMonetizationNetwork.AFAdRevenueData("afUninstallToken", aFf1aSDK.getMonetizationNetwork);
                    aFg1tSDK.getMonetizationNetwork.getRevenue("afUninstallToken_received_time", aFf1aSDK.getCurrencyIso4217Code);
                    aFg1tSDK.getMonetizationNetwork.getCurrencyIso4217Code("afUninstallToken_queued", aFf1aSDK.getMediationNetwork);
                    if (z) {
                        AFa1uSDK monetizationNetwork = getMonetizationNetwork();
                        AFc1bSDK aFc1bSDK = (AFc1bSDK) getRevenue(new Object[]{monetizationNetwork}, 389316487, -389316474, System.identityHashCode(monetizationNetwork));
                        AFf1pSDK aFf1pSDK = new AFf1pSDK(str, aFc1bSDK);
                        AFe1nSDK copydefault = aFc1bSDK.copydefault();
                        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFf1pSDK));
                        return null;
                    }
                    return null;
                }
                return null;
            case 24:
                AFa1uSDK aFa1uSDK6 = (AFa1uSDK) objArr[0];
                Map<String, Object> map = (Map) objArr[2];
                PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback = (PurchaseHandler.PurchaseValidationCallback) objArr[3];
                int i35 = d + 5;
                AFKeystoreWrapper = i35 % 128;
                int i36 = i35 % 2;
                aFa1uSDK6.getMediationNetwork((Context) objArr[1]);
                PurchaseHandler areAllFieldsValid2 = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK6}, 389316487, -389316474, System.identityHashCode(aFa1uSDK6))).areAllFieldsValid();
                if (areAllFieldsValid2.getMonetizationNetwork(map, purchaseValidationCallback, AFPurchaseConnectorA1l.getPackageName)) {
                    AFe1bSDK aFe1bSDK = new AFe1bSDK(map, purchaseValidationCallback, areAllFieldsValid2.AFAdRevenueData);
                    AFe1nSDK aFe1nSDK = areAllFieldsValid2.getCurrencyIso4217Code;
                    aFe1nSDK.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFe1bSDK));
                }
                int i37 = d + 65;
                AFKeystoreWrapper = i37 % 128;
                int i38 = i37 % 2;
                return null;
            default:
                AFa1uSDK aFa1uSDK7 = (AFa1uSDK) objArr[0];
                boolean booleanValue3 = ((Boolean) objArr[1]).booleanValue();
                int i39 = AFKeystoreWrapper + 57;
                d = i39 % 128;
                if ((i39 % 2 == 0 ? '\t' : '3') != '\t') {
                    ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK7}, 389316487, -389316474, System.identityHashCode(aFa1uSDK7))).equals().getCurrencyIso4217Code("setCollectAndroidID", String.valueOf(booleanValue3));
                } else {
                    AFd1mSDK equals = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK7}, 389316487, -389316474, System.identityHashCode(aFa1uSDK7))).equals();
                    String[] strArr = new String[1];
                    strArr[1] = String.valueOf(booleanValue3);
                    equals.getCurrencyIso4217Code("setCollectAndroidID", strArr);
                }
                getCurrencyIso4217Code(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(booleanValue3));
                getCurrencyIso4217Code(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(booleanValue3));
                return null;
        }
    }

    static {
        component3();
        getRevenue = "356";
        AFAdRevenueData = "6.17";
        getCurrencyIso4217Code = null;
        areAllFieldsValid = new AFa1uSDK();
        int i = d + 61;
        AFKeystoreWrapper = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        int i2 = 48 / 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v16, types: [byte[]] */
    private static void a(String str, String str2, int[] iArr, int i, Object[] objArr) {
        char[] cArr;
        if (!(str2 == 0)) {
            str2 = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) str2;
        char[] cArr2 = str;
        if (str != null) {
            int i2 = $10 + 117;
            $11 = i2 % 128;
            if (!(i2 % 2 != 0)) {
                str.toCharArray();
                throw null;
            }
            cArr2 = str.toCharArray();
        }
        char[] cArr3 = cArr2;
        AFk1iSDK aFk1iSDK = new AFk1iSDK();
        char[] cArr4 = AFInAppEventParameterName;
        if (!(cArr4 == null)) {
            int length = cArr4.length;
            char[] cArr5 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr5[i3] = (char) (cArr4[i3] ^ 1825820251896122634L);
            }
            cArr4 = cArr5;
        }
        int i4 = (int) (AFInAppEventType ^ 1825820251896122634L);
        if (AFLogger) {
            int i5 = $11 + 21;
            $10 = i5 % 128;
            if (!(i5 % 2 == 0)) {
                aFk1iSDK.getCurrencyIso4217Code = bArr.length;
                cArr = new char[aFk1iSDK.getCurrencyIso4217Code];
                aFk1iSDK.getMediationNetwork = 1;
            } else {
                aFk1iSDK.getCurrencyIso4217Code = bArr.length;
                cArr = new char[aFk1iSDK.getCurrencyIso4217Code];
                aFk1iSDK.getMediationNetwork = 0;
            }
            while (aFk1iSDK.getMediationNetwork < aFk1iSDK.getCurrencyIso4217Code) {
                cArr[aFk1iSDK.getMediationNetwork] = (char) (cArr4[bArr[(aFk1iSDK.getCurrencyIso4217Code - 1) - aFk1iSDK.getMediationNetwork] + i] - i4);
                aFk1iSDK.getMediationNetwork++;
            }
            objArr[0] = new String(cArr);
        } else if (registerClient) {
            aFk1iSDK.getCurrencyIso4217Code = cArr3.length;
            char[] cArr6 = new char[aFk1iSDK.getCurrencyIso4217Code];
            aFk1iSDK.getMediationNetwork = 0;
            int i6 = $10 + 121;
            $11 = i6 % 128;
            while (true) {
                int i7 = i6 % 2;
                if ((aFk1iSDK.getMediationNetwork < aFk1iSDK.getCurrencyIso4217Code ? ';' : Typography.less) != ';') {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i8 = $10 + 115;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                cArr6[aFk1iSDK.getMediationNetwork] = (char) (cArr4[cArr3[(aFk1iSDK.getCurrencyIso4217Code - 1) - aFk1iSDK.getMediationNetwork] - i] - i4);
                aFk1iSDK.getMediationNetwork++;
                i6 = $10 + 115;
                $11 = i6 % 128;
            }
        } else {
            aFk1iSDK.getCurrencyIso4217Code = iArr.length;
            char[] cArr7 = new char[aFk1iSDK.getCurrencyIso4217Code];
            aFk1iSDK.getMediationNetwork = 0;
            while (true) {
                if ((aFk1iSDK.getMediationNetwork < aFk1iSDK.getCurrencyIso4217Code ? 'O' : 'M') == 'M') {
                    objArr[0] = new String(cArr7);
                    return;
                } else {
                    cArr7[aFk1iSDK.getMediationNetwork] = (char) (cArr4[iArr[(aFk1iSDK.getCurrencyIso4217Code - 1) - aFk1iSDK.getMediationNetwork] - i] - i4);
                    aFk1iSDK.getMediationNetwork++;
                }
            }
        }
    }

    private static /* synthetic */ Object component2(Object[] objArr) {
        int i = d + 45;
        int i2 = i % 128;
        AFKeystoreWrapper = i2;
        int i3 = i % 2;
        AFc1dSDK aFc1dSDK = ((AFa1uSDK) objArr[0]).hashCode;
        int i4 = i2 + 73;
        d = i4 % 128;
        if ((i4 % 2 == 0 ? '?' : '\'') != '?') {
            return aFc1dSDK;
        }
        int i5 = 82 / 0;
        return aFc1dSDK;
    }

    public final void getMediationNetwork(Context context) {
        int i = d + 37;
        int i2 = i % 128;
        AFKeystoreWrapper = i2;
        int i3 = i % 2;
        AFc1dSDK aFc1dSDK = this.hashCode;
        if (context != null) {
            int i4 = i2 + 25;
            d = i4 % 128;
            Object obj = null;
            if (i4 % 2 == 0) {
                AFc1gSDK aFc1gSDK = aFc1dSDK.getMonetizationNetwork;
                throw null;
            }
            AFc1gSDK aFc1gSDK2 = aFc1dSDK.getMonetizationNetwork;
            if (context != null) {
                int i5 = AFKeystoreWrapper + 3;
                d = i5 % 128;
                if (i5 % 2 != 0) {
                    aFc1gSDK2.getRevenue = context.getApplicationContext();
                    return;
                }
                aFc1gSDK2.getRevenue = context.getApplicationContext();
                obj.hashCode();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFAdRevenueData(AFf1oSDK aFf1oSDK) {
        int i = d + 61;
        AFKeystoreWrapper = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            AFc1bSDK aFc1bSDK = (AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
            AFf1oSDK aFf1oSDK2 = AFf1oSDK.SUCCESS;
            obj.hashCode();
            throw null;
        }
        AFc1bSDK aFc1bSDK2 = (AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
        if (aFf1oSDK == AFf1oSDK.SUCCESS) {
            int i2 = AFKeystoreWrapper + 103;
            d = i2 % 128;
            if (i2 % 2 == 0) {
                aFc1bSDK2.afWarnLog().getRevenue();
                obj.hashCode();
                throw null;
            }
            aFc1bSDK2.afWarnLog().getRevenue();
        }
        if ((!aFc1bSDK2.equals().getCurrencyIso4217Code() ? '+' : 'c') == 'c') {
            aFc1bSDK2.afErrorLog().getMediationNetwork();
            return;
        }
        int i3 = AFKeystoreWrapper + 77;
        d = i3 % 128;
        int i4 = i3 % 2;
        aFc1bSDK2.afErrorLog().AFAdRevenueData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
        if ((r5.equals == null) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final synchronized com.appsflyer.internal.AFf1nSDK AFAdRevenueData() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L4f
            int r0 = r0 + 83
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.d = r1     // Catch: java.lang.Throwable -> L4f
            int r0 = r0 % 2
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L11
            r0 = r3
            goto L12
        L11:
            r0 = r2
        L12:
            if (r0 == 0) goto L21
            com.appsflyer.internal.AFf1nSDK r0 = r5.equals     // Catch: java.lang.Throwable -> L4f
            r2 = 22
            if (r0 != 0) goto L1d
            r0 = 41
            goto L1e
        L1d:
            r0 = r2
        L1e:
            if (r0 == r2) goto L49
            goto L2c
        L21:
            com.appsflyer.internal.AFf1nSDK r0 = r5.equals     // Catch: java.lang.Throwable -> L4f
            r4 = 14
            int r4 = r4 / r3
            if (r0 != 0) goto L29
            goto L2a
        L29:
            r2 = r3
        L2a:
            if (r2 == 0) goto L49
        L2c:
            int r1 = r1 + 123
            int r0 = r1 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r0     // Catch: java.lang.Throwable -> L4f
            int r1 = r1 % 2
            if (r1 != 0) goto L3e
            com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda0 r0 = new com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L4f
            r0.<init>()     // Catch: java.lang.Throwable -> L4f
            r5.equals = r0     // Catch: java.lang.Throwable -> L4f
            goto L49
        L3e:
            com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda0 r0 = new com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L4f
            r0.<init>()     // Catch: java.lang.Throwable -> L4f
            r5.equals = r0     // Catch: java.lang.Throwable -> L4f
            r0 = 0
            throw r0     // Catch: java.lang.Throwable -> L47
        L47:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L4f
        L49:
            com.appsflyer.internal.AFf1nSDK r0 = r5.equals     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r5)
            return r0
        L4d:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L4f
        L4f:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.AFAdRevenueData():com.appsflyer.internal.AFf1nSDK");
    }

    public AFa1uSDK() {
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afErrorLog().getMediationNetwork();
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afErrorLog().getRevenue();
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).copydefault().getMonetizationNetwork.add(new C0006AFa1uSDK());
    }

    public static AFa1uSDK getMonetizationNetwork() {
        int i = d + 87;
        int i2 = i % 128;
        AFKeystoreWrapper = i2;
        int i3 = i % 2;
        AFa1uSDK aFa1uSDK = areAllFieldsValid;
        int i4 = i2 + 85;
        d = i4 % 128;
        int i5 = i4 % 2;
        return aFa1uSDK;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilterForAllPartners() {
        int i = d + 113;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        setSharingFilterForPartners("all");
        int i3 = AFKeystoreWrapper + 57;
        d = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        int i = d + 65;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        getMediationNetwork(context);
        PurchaseHandler areAllFieldsValid2 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).areAllFieldsValid();
        if (areAllFieldsValid2.getMonetizationNetwork(map, purchaseValidationCallback, BillingClient.FeatureType.SUBSCRIPTIONS)) {
            AFe1jSDK aFe1jSDK = new AFe1jSDK(map, purchaseValidationCallback, areAllFieldsValid2.AFAdRevenueData);
            AFe1nSDK aFe1nSDK = areAllFieldsValid2.getCurrencyIso4217Code;
            aFe1nSDK.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFe1jSDK));
            int i3 = AFKeystoreWrapper + 91;
            d = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        int i = d + 45;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? '@' : 'W') != '@') {
            AFa1rSDK i2 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i();
            i2.getMonetizationNetwork = str;
            i2.getMediationNetwork = map;
            int i3 = AFKeystoreWrapper + 99;
            d = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        AFa1rSDK i5 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i();
        i5.getMonetizationNetwork = str;
        i5.getMediationNetwork = map;
        throw null;
    }

    private static /* synthetic */ Object component3(Object[] objArr) {
        int i = AFKeystoreWrapper + 59;
        d = i % 128;
        int i2 = i % 2;
        ((AFa1uSDK) objArr[0]).subscribeForDeepLink((DeepLinkListener) objArr[1], TimeUnit.SECONDS.toMillis(3L));
        int i3 = AFKeystoreWrapper + 11;
        d = i3 % 128;
        if ((i3 % 2 == 0 ? 'R' : (char) 23) == 23) {
            return null;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener, long j) {
        int i = AFKeystoreWrapper + 61;
        d = i % 128;
        if ((i % 2 == 0 ? 'Q' : 'S') != 'S') {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().getRevenue = deepLinkListener;
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().component2 = j;
            int i2 = 45 / 0;
            return;
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().getRevenue = deepLinkListener;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().component2 = j;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void performOnDeepLinking(final Intent intent, Context context) {
        int i = AFKeystoreWrapper + 45;
        int i2 = i % 128;
        d = i2;
        int i3 = i % 2;
        Object obj = null;
        if (intent == null) {
            int i4 = i2 + 71;
            AFKeystoreWrapper = i4 % 128;
            if (!(i4 % 2 != 0)) {
                ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().getMediationNetwork("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
                return;
            }
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().getMediationNetwork("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
            obj.hashCode();
            throw null;
        } else if (context == null) {
            int i5 = i2 + 123;
            AFKeystoreWrapper = i5 % 128;
            if ((i5 % 2 != 0 ? 'A' : '<') == '<') {
                ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().getMediationNetwork("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
                return;
            }
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i().getMediationNetwork("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
            int i6 = 4 / 0;
        } else {
            final Context applicationContext = context.getApplicationContext();
            getMediationNetwork(applicationContext);
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).getMediationNetwork().execute(new Runnable() { // from class: com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AFa1uSDK.this.e_(applicationContext, intent);
                }
            });
            int i7 = d + 97;
            AFKeystoreWrapper = i7 % 128;
            if (i7 % 2 == 0) {
                return;
            }
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ java.lang.Object hashCode(java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.hashCode(java.lang.Object[]):java.lang.Object");
    }

    private static /* synthetic */ Object areAllFieldsValid(Object[] objArr) {
        AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        String[] strArr = (String[]) objArr[1];
        int i = d + 47;
        AFKeystoreWrapper = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? (char) 25 : 'N') == 'N') {
            List<String> asList = Arrays.asList(strArr);
            List<List<String>> list = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).i().AFAdRevenueData;
            if ((!list.contains(asList) ? 'b' : '/') != '/') {
                list.add(asList);
                int i2 = AFKeystoreWrapper + 71;
                d = i2 % 128;
                int i3 = i2 % 2;
            }
            return null;
        }
        ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).i().AFAdRevenueData.contains(Arrays.asList(strArr));
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPartnerData(String str, Map<String, Object> map) {
        int i = AFKeystoreWrapper + 9;
        d = i % 128;
        int i2 = i % 2;
        AFc1eSDK afInfoLog = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afInfoLog();
        if (afInfoLog.getCurrencyIso4217Code == null) {
            afInfoLog.getCurrencyIso4217Code = new AFb1rSDK();
        }
        AFb1rSDK aFb1rSDK = afInfoLog.getCurrencyIso4217Code;
        if (str != null) {
            int i3 = d + 53;
            AFKeystoreWrapper = i3 % 128;
            int i4 = i3 % 2;
            if (!str.isEmpty()) {
                Object obj = null;
                if (map != null) {
                    int i5 = d + 5;
                    AFKeystoreWrapper = i5 % 128;
                    if (!(i5 % 2 == 0)) {
                        map.isEmpty();
                        throw null;
                    }
                    if ((map.isEmpty() ? ' ' : ')') != ' ') {
                        AFLogger.afDebugLog(new StringBuilder("Setting partner data for ").append(str).append(": ").append(map).toString());
                        int length = new JSONObject(map).toString().length();
                        if (length <= 1000) {
                            aFb1rSDK.getRevenue.put(str, map);
                            aFb1rSDK.getCurrencyIso4217Code.remove(str);
                            return;
                        }
                        AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
                        HashMap hashMap = new HashMap();
                        hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                        aFb1rSDK.getCurrencyIso4217Code.put(str, hashMap);
                        return;
                    }
                }
                AFLogger.afWarnLog(aFb1rSDK.getRevenue.remove(str) == null ? "Partner data is missing or `null`" : "Cleared partner data for ".concat(String.valueOf(str)));
                int i6 = d + 65;
                AFKeystoreWrapper = i6 % 128;
                if ((i6 % 2 != 0 ? '\t' : '^') != '\t') {
                    return;
                }
                obj.hashCode();
                throw null;
            }
        }
        AFLogger.afWarnLog("Partner ID is missing or `null`");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r7 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r7 == false) goto L37;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setDisableAdvertisingIdentifiers(boolean r7) {
        /*
            r6 = this;
            int r0 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r0 = r0 + 39
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.d = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            java.lang.String r3 = "setDisableAdvertisingIdentifiers: "
            if (r0 == 0) goto L23
            java.lang.String r0 = java.lang.String.valueOf(r7)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.afDebugLog(r0)
            if (r7 != 0) goto L35
            goto L33
        L23:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.afDebugLog(r0)
            r0 = 82
            int r0 = r0 / r1
            if (r7 != 0) goto L35
        L33:
            r0 = r2
            goto L36
        L35:
            r0 = r1
        L36:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.appsflyer.internal.AFb1kSDK.getMediationNetwork = r0
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r1] = r6
            int r3 = java.lang.System.identityHashCode(r6)
            r4 = 389316487(0x17347f87, float:5.83221E-25)
            r5 = -389316474(0xffffffffe8cb8086, float:-7.68809E24)
            java.lang.Object r0 = getRevenue(r0, r4, r5, r3)
            com.appsflyer.internal.AFc1bSDK r0 = (com.appsflyer.internal.AFc1bSDK) r0
            com.appsflyer.internal.AFc1eSDK r3 = r0.afInfoLog()
            r3.component3 = r7
            if (r7 == 0) goto L8f
            int r7 = com.appsflyer.internal.AFa1uSDK.d
            int r7 = r7 + 109
            int r3 = r7 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r3
            int r7 = r7 % 2
            if (r7 == 0) goto L66
            r7 = r1
            goto L67
        L66:
            r7 = r2
        L67:
            r3 = 0
            if (r7 == 0) goto L83
            com.appsflyer.internal.AFc1eSDK r7 = r0.afInfoLog()
            r7.component2 = r3
            int r7 = com.appsflyer.internal.AFa1uSDK.d
            int r7 = r7 + 7
            int r0 = r7 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r0
            int r7 = r7 % 2
            if (r7 == 0) goto L7d
            r1 = r2
        L7d:
            if (r1 == r2) goto L80
            return
        L80:
            throw r3     // Catch: java.lang.Throwable -> L81
        L81:
            r7 = move-exception
            throw r7
        L83:
            com.appsflyer.internal.AFc1eSDK r7 = r0.afInfoLog()
            r7.component2 = r3
            r3.hashCode()     // Catch: java.lang.Throwable -> L8d
            throw r3     // Catch: java.lang.Throwable -> L8d
        L8d:
            r7 = move-exception
            throw r7
        L8f:
            com.appsflyer.internal.AFe1nSDK r7 = r0.copydefault()
            com.appsflyer.internal.AFe1fSDK r0 = new com.appsflyer.internal.AFe1fSDK
            com.appsflyer.internal.AFc1bSDK r1 = r6.getCurrencyIso4217Code()
            r0.<init>(r1)
            java.util.concurrent.Executor r1 = r7.AFAdRevenueData
            com.appsflyer.internal.AFe1nSDK$3 r2 = new com.appsflyer.internal.AFe1nSDK$3
            r2.<init>(r0)
            r1.execute(r2)
            return
        La7:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.setDisableAdvertisingIdentifiers(boolean):void");
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        Context context = (Context) objArr[1];
        AFj1kSDK aFj1kSDK = new AFj1kSDK((Intent) objArr[2]);
        if (aFj1kSDK.getCurrencyIso4217Code("appsflyer_preinstall") != null) {
            int i = AFKeystoreWrapper + 53;
            d = i % 128;
            if (i % 2 == 0) {
                getRevenue(new Object[]{aFj1kSDK.getCurrencyIso4217Code("appsflyer_preinstall")}, 698517988, -698517984, (int) System.currentTimeMillis());
                throw null;
            }
            getRevenue(new Object[]{aFj1kSDK.getCurrencyIso4217Code("appsflyer_preinstall")}, 698517988, -698517984, (int) System.currentTimeMillis());
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String currencyIso4217Code = aFj1kSDK.getCurrencyIso4217Code("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(currencyIso4217Code)));
        if (currencyIso4217Code != null) {
            int i2 = AFKeystoreWrapper + 87;
            d = i2 % 128;
            int i3 = i2 % 2;
            ((AFc1oSDK) getRevenue(new Object[]{aFa1uSDK, context}, -1595266545, 1595266567, System.identityHashCode(aFa1uSDK))).AFAdRevenueData("referrer", currencyIso4217Code);
            AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
            appsFlyerProperties.set("AF_REFERRER", currencyIso4217Code);
            appsFlyerProperties.AFAdRevenueData = currencyIso4217Code;
            if (AppsFlyerProperties.getInstance().AFAdRevenueData()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                aFa1uSDK.getMediationNetwork(context, AFh1xSDK.onReceive);
                aFa1uSDK.getRevenue(currencyIso4217Code);
                int i4 = d + 55;
                AFKeystoreWrapper = i4 % 128;
                int i5 = i4 % 2;
            }
        }
        int i6 = d + 35;
        AFKeystoreWrapper = i6 % 128;
        if ((i6 % 2 != 0 ? ')' : '\'') != '\'') {
            int i7 = 83 / 0;
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8 A[LOOP:4: B:25:0x007a->B:50:0x00f8, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void AFAdRevenueData(org.json.JSONObject r13) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.AFAdRevenueData(org.json.JSONObject):void");
    }

    public final void getMonetizationNetwork(Context context, String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String monetizationNetwork = ((AFc1oSDK) getRevenue(new Object[]{this, context}, -1595266545, 1595266567, System.identityHashCode(this))).getMonetizationNetwork("extraReferrers", null);
            if (monetizationNetwork == null) {
                jSONObject = new JSONObject();
                jSONArray2 = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(monetizationNetwork);
                if (jSONObject2.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
                jSONArray2 = jSONArray;
                jSONObject = jSONObject2;
            }
            if (((long) jSONArray2.length()) < 5) {
                int i = AFKeystoreWrapper + 21;
                d = i % 128;
                int i2 = i % 2;
                jSONArray2.put(currentTimeMillis);
                int i3 = d + 57;
                AFKeystoreWrapper = i3 % 128;
                int i4 = i3 % 2;
            }
            if (jSONObject.length() >= 4) {
                int i5 = AFKeystoreWrapper + 117;
                d = i5 % 128;
                if (i5 % 2 != 0) {
                    AFAdRevenueData(jSONObject);
                } else {
                    AFAdRevenueData(jSONObject);
                    int i6 = 14 / 0;
                }
            }
            jSONObject.put(str, jSONArray2.toString());
            ((AFc1oSDK) getRevenue(new Object[]{this, context}, -1595266545, 1595266567, System.identityHashCode(this))).AFAdRevenueData("extraReferrers", jSONObject.toString());
        } catch (JSONException e) {
            AFLogger.afErrorLogForExcManagerOnly("error at addReferrer", e);
        } catch (Throwable th) {
            AFLogger.afErrorLog(new StringBuilder("Couldn't save referrer - ").append(str).append(": ").toString(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void getMediationNetwork(AFc1bSDK aFc1bSDK) {
        int i = d + 49;
        AFKeystoreWrapper = i % 128;
        boolean z = i % 2 != 0;
        aFc1bSDK.AFInAppEventType().getMonetizationNetwork();
        if (z) {
            int i2 = 22 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void stop(boolean z, Context context) {
        int i = AFKeystoreWrapper + 63;
        d = i % 128;
        int i2 = i % 2;
        getMediationNetwork(context);
        final AFc1bSDK aFc1bSDK = (AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
        aFc1bSDK.AFKeystoreWrapper().getRevenue(z);
        aFc1bSDK.getMediationNetwork().submit(new Runnable() { // from class: com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AFa1uSDK.getMediationNetwork(AFc1bSDK.this);
            }
        });
        if ((z ? 'B' : 'I') != 'I') {
            int i3 = AFKeystoreWrapper + 31;
            d = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 25 : 'H') != 25) {
                aFc1bSDK.component2().getCurrencyIso4217Code("is_stop_tracking_used", true);
            } else {
                aFc1bSDK.component2().getCurrencyIso4217Code("is_stop_tracking_used", false);
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getSdkVersion() {
        int i = AFKeystoreWrapper + 105;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("getSdkVersion", new String[0]);
        String component2 = AFc1pSDK.component2();
        int i3 = AFKeystoreWrapper + 125;
        d = i3 % 128;
        if (i3 % 2 != 0) {
            return component2;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void onPause(Context context) {
        int i = d + 57;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? 'R' : '\f') != 'R') {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afDebugLog().getMonetizationNetwork();
            return;
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afDebugLog().getMonetizationNetwork();
        int i2 = 92 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDebugLog(boolean z) {
        int i = d + 65;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        setLogLevel(!z ? AFLogger.LogLevel.NONE : AFLogger.LogLevel.DEBUG);
        int i3 = AFKeystoreWrapper + 3;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setImeiData(String str) {
        Object revenue;
        int i = d + 37;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? '5' : (char) 19) != 19) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setImeiData", str);
            revenue = getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
        } else {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setImeiData", str);
            revenue = getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
        }
        ((AFc1bSDK) revenue).AFKeystoreWrapper().getCurrencyIso4217Code(str);
        int i2 = AFKeystoreWrapper + 61;
        d = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOaidData(String str) {
        int i = AFKeystoreWrapper + 3;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setOaidData", str);
        AFb1kSDK.getRevenue = str;
        int i3 = AFKeystoreWrapper + 3;
        d = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAndroidIdData(String str) {
        int i = AFKeystoreWrapper + 25;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setAndroidIdData", str);
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afInfoLog().AFAdRevenueData = str;
        int i3 = d + 53;
        AFKeystoreWrapper = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void getCurrencyIso4217Code(String str, String str2) {
        int i = AFKeystoreWrapper + 5;
        d = i % 128;
        if (!(i % 2 == 0)) {
            AppsFlyerProperties.getInstance().set(str, str2);
            int i2 = AFKeystoreWrapper + 105;
            d = i2 % 128;
            if ((i2 % 2 == 0 ? ':' : '&') != '&') {
                int i3 = 84 / 0;
                return;
            }
            return;
        }
        AppsFlyerProperties.getInstance().set(str, str2);
        throw null;
    }

    private static /* synthetic */ Object copy(Object[] objArr) {
        String str = (String) objArr[0];
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        int i = AFKeystoreWrapper + 83;
        d = i % 128;
        if ((i % 2 == 0 ? 'W' : '(') == '(') {
            AppsFlyerProperties.getInstance().set(str, booleanValue);
            return null;
        }
        AppsFlyerProperties.getInstance().set(str, booleanValue);
        throw null;
    }

    private static String getCurrencyIso4217Code(String str) {
        int i = AFKeystoreWrapper + 105;
        d = i % 128;
        if (i % 2 == 0) {
            AppsFlyerProperties.getInstance().getString(str);
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        return AppsFlyerProperties.getInstance().getString(str);
    }

    private static boolean AFAdRevenueData(String str) {
        int i = AFKeystoreWrapper + 63;
        d = i % 128;
        if (i % 2 == 0) {
        }
        boolean z = AppsFlyerProperties.getInstance().getBoolean(str, false);
        int i2 = d + 87;
        AFKeystoreWrapper = i2 % 128;
        int i3 = i2 % 2;
        return z;
    }

    public final boolean getRevenue() {
        int i = d + 27;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        if ((AFAdRevenueData(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID) ? 'A' : (char) 25) != 25) {
            if (!(getMediationNetwork() != null)) {
                int i3 = d + 49;
                AFKeystoreWrapper = i3 % 128;
                return i3 % 2 == 0;
            }
            return false;
        }
        return false;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void waitForCustomerUserId(boolean z) {
        int i = d + 43;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        getRevenue(new Object[]{AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, Boolean.valueOf(z)}, -222394073, 222394090, (int) System.currentTimeMillis());
        int i3 = AFKeystoreWrapper + 107;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerIdAndLogSession(String str, Context context) {
        if ((context != null ? (char) 5 : 'S') != 5) {
            return;
        }
        int i = d + 101;
        AFKeystoreWrapper = i % 128;
        if (i % 2 != 0) {
            getRevenue();
            Object obj = null;
            obj.hashCode();
            throw null;
        } else if (!getRevenue()) {
            setCustomerUserId(str);
            AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
            int i2 = AFKeystoreWrapper + 51;
            d = i2 % 128;
            int i3 = i2 % 2;
        } else {
            setCustomerUserId(str);
            AFLogger.afInfoLog(new StringBuilder("CustomerUserId set: ").append(str).append(" - Initializing AppsFlyer Tacking").toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component2());
            getMediationNetwork(context, AFh1xSDK.setCustomerIdAndLogSession);
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMediationNetwork();
            if ((referrer == null ? 'R' : 'X') != 'X') {
                referrer = "";
            }
            if (context instanceof Activity) {
                int i4 = d + 113;
                AFKeystoreWrapper = i4 % 128;
                if ((i4 % 2 != 0 ? (char) 27 : 'a') != 'a') {
                    ((Activity) context).getIntent();
                    int i5 = 4 / 0;
                } else {
                    ((Activity) context).getIntent();
                }
            }
            getRevenue(context, referrer);
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getOutOfStore(Context context) {
        int i = AFKeystoreWrapper + 107;
        d = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? 'U' : (char) 26) == 26) {
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_STORE_FROM_API);
            if ((string != null ? '\n' : ';') != ';') {
                return string;
            }
            String currencyIso4217Code = getCurrencyIso4217Code(context, "AF_STORE");
            if ((currencyIso4217Code != null ? 'F' : (char) 28) == 'F') {
                int i2 = AFKeystoreWrapper + 71;
                d = i2 % 128;
                if ((i2 % 2 == 0 ? 'K' : (char) 22) != 22) {
                    int i3 = 72 / 0;
                    return currencyIso4217Code;
                }
                return currencyIso4217Code;
            }
            AFLogger.afInfoLog("No out-of-store value set");
            return null;
        }
        AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_STORE_FROM_API);
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOutOfStore(String str) {
        int i = d;
        int i2 = i + 75;
        AFKeystoreWrapper = i2 % 128;
        int i3 = i2 % 2;
        if (str != null) {
            int i4 = i + 1;
            AFKeystoreWrapper = i4 % 128;
            if (i4 % 2 != 0) {
            }
            String lowerCase = str.toLowerCase(Locale.getDefault());
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_STORE_FROM_API, lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.afWarnLog("Cannot set setOutOfStore with null", true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005a, code lost:
        if ((!r7.equals(com.appsflyer.AppsFlyerProperties.getInstance().getString(com.appsflyer.AppsFlyerProperties.ONELINK_ID)) ? '5' : 'a') != 'a') goto L14;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setAppInviteOneLink(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = com.appsflyer.internal.AFa1uSDK.d
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r1
            int r0 = r0 % 2
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r6
            int r3 = java.lang.System.identityHashCode(r6)
            r4 = 389316487(0x17347f87, float:5.83221E-25)
            r5 = -389316474(0xffffffffe8cb8086, float:-7.68809E24)
            java.lang.Object r1 = getRevenue(r1, r4, r5, r3)
            com.appsflyer.internal.AFc1bSDK r1 = (com.appsflyer.internal.AFc1bSDK) r1
            com.appsflyer.internal.AFd1mSDK r1 = r1.equals()
            java.lang.String[] r0 = new java.lang.String[r0]
            r0[r2] = r7
            java.lang.String r2 = "setAppInviteOneLink"
            r1.getCurrencyIso4217Code(r2, r0)
            java.lang.String r0 = "setAppInviteOneLink = "
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r0 = r0.concat(r1)
            com.appsflyer.AFLogger.afInfoLog(r0)
            r0 = 86
            if (r7 == 0) goto L41
            r1 = 33
            goto L42
        L41:
            r1 = r0
        L42:
            java.lang.String r2 = "oneLinkSlug"
            if (r1 == r0) goto L5c
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r2)
            boolean r0 = r7.equals(r0)
            r1 = 97
            if (r0 != 0) goto L59
            r0 = 53
            goto L5a
        L59:
            r0 = r1
        L5a:
            if (r0 == r1) goto L77
        L5c:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkDomain"
            r0.remove(r1)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkVersion"
            r0.remove(r1)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkScheme"
            r0.remove(r1)
        L77:
            getCurrencyIso4217Code(r2, r7)
            int r7 = com.appsflyer.internal.AFa1uSDK.d
            int r7 = r7 + 91
            int r0 = r7 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r0
            int r7 = r7 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.setAppInviteOneLink(java.lang.String):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAdditionalData(Map<String, Object> map) {
        int i = d + 23;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        if (map != null) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
        }
        int i3 = AFKeystoreWrapper + 9;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        if ((r18 != null ? 7 : 31) != 31) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        if ((r18 == null) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        if (r18.getIntent() == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
        ((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r17}, 389316487, -389316474, java.lang.System.identityHashCode(r17))).equals().getCurrencyIso4217Code("sendPushNotificationData", r18.getLocalClassName(), new java.lang.StringBuilder("activity_intent_").append(r18.getIntent().toString()).toString());
        r3 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper + 85;
        com.appsflyer.internal.AFa1uSDK.d = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
        if (r18 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
        ((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r17}, 389316487, -389316474, java.lang.System.identityHashCode(r17))).equals().getCurrencyIso4217Code("sendPushNotificationData", r18.getLocalClassName(), "activity_intent_null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
        ((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r17}, 389316487, -389316474, java.lang.System.identityHashCode(r17))).equals().getCurrencyIso4217Code("sendPushNotificationData", "activity_null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
        r3 = ((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r17}, 389316487, -389316474, java.lang.System.identityHashCode(r17))).afInfoLog();
        r3.getMediationNetwork = getCurrencyIso4217Code(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
        if (r3.getMediationNetwork == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:
        r5 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e3, code lost:
        if (r17.copydefault != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e5, code lost:
        com.appsflyer.AFLogger.afInfoLog("pushes: initializing pushes history..");
        r17.copydefault = new java.util.concurrent.ConcurrentHashMap();
        r13 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f4, code lost:
        r11 = com.appsflyer.AppsFlyerProperties.getInstance().getLong("pushPayloadMaxAging", 1800000);
        r7 = r17.copydefault.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010b, code lost:
        r13 = com.appsflyer.internal.AFa1uSDK.d + 79;
        com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r13 % 128;
        r13 = r13 % 2;
        r13 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0119, code lost:
        if (r7.hasNext() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011b, code lost:
        r15 = r7.next();
        r9 = new org.json.JSONObject(r3.getMediationNetwork);
        r8 = new org.json.JSONObject(r17.copydefault.get(r15));
        r16 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0145, code lost:
        if (r9.opt("pid").equals(r8.opt("pid")) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0147, code lost:
        r4 = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0149, code lost:
        r4 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x014b, code lost:
        if (r4 == 24) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x015a, code lost:
        if (r9.opt("c").equals(r8.opt("c")) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x015c, code lost:
        com.appsflyer.AFLogger.afInfoLog(new java.lang.StringBuilder("PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: ").append(r8).append(", new: ").append(r9).append(")").toString());
        r3.getMediationNetwork = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x017f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0188, code lost:
        if ((r5 - r15.longValue()) <= r11) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x018a, code lost:
        r4 = com.appsflyer.internal.AFa1uSDK.d + 63;
        com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0194, code lost:
        r17.copydefault.remove(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x019f, code lost:
        if (r15.longValue() > r13) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01a1, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a3, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a5, code lost:
        if (r4 == true) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a7, code lost:
        r13 = r15.longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01ab, code lost:
        r7 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b4, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b5, code lost:
        r13 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b6, code lost:
        com.appsflyer.AFLogger.afErrorLog(new java.lang.StringBuilder("Error while handling push notification measurement: ").append(r0.getClass().getSimpleName()).toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e1, code lost:
        if (r17.copydefault.size() == com.appsflyer.AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", 2)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01e3, code lost:
        com.appsflyer.AFLogger.afInfoLog(new java.lang.StringBuilder("pushes: removing oldest overflowing push (oldest push:").append(r13).append(")").toString());
        r17.copydefault.remove(java.lang.Long.valueOf(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0202, code lost:
        r17.copydefault.put(java.lang.Long.valueOf(r5), r3.getMediationNetwork);
        start(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0210, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendPushNotificationData(android.app.Activity r18) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.sendPushNotificationData(android.app.Activity):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(String... strArr) {
        int i = d + 89;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? 'F' : '@') != '@') {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setUserEmails", strArr);
            setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
            int i2 = 48 / 0;
            return;
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        int i = 0;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setUserEmails", (String[]) arrayList.toArray(new String[strArr.length + 1]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        String str = null;
        while (true) {
            if ((i < length ? 'I' : 'G') != 'I') {
                hashMap.put(str, arrayList2);
                AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
                int i2 = d + 35;
                AFKeystoreWrapper = i2 % 128;
                if (i2 % 2 == 0) {
                    return;
                }
                throw null;
            }
            int i3 = d + 121;
            AFKeystoreWrapper = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 26 : '#') == 26) {
                String str2 = strArr[i];
                if (AnonymousClass2.getRevenue[emailsCryptType.ordinal()] != 2) {
                    arrayList2.add(AFj1bSDK.getCurrencyIso4217Code(str2));
                    str = "sha256_el_arr";
                } else {
                    arrayList2.add(str2);
                    str = "plain_el_arr";
                }
                i++;
            } else {
                String str3 = strArr[i];
                int i4 = AnonymousClass2.getRevenue[emailsCryptType.ordinal()];
                throw null;
            }
        }
    }

    /* renamed from: com.appsflyer.internal.AFa1uSDK$2  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] getRevenue;

        static {
            int[] iArr = new int[AppsFlyerProperties.EmailsCryptType.values().length];
            getRevenue = iArr;
            try {
                iArr[AppsFlyerProperties.EmailsCryptType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getRevenue[AppsFlyerProperties.EmailsCryptType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectIMEI(boolean z) {
        int i = AFKeystoreWrapper + 111;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setCollectIMEI", String.valueOf(z));
        getCurrencyIso4217Code(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        getCurrencyIso4217Code(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
        int i3 = d + 115;
        AFKeystoreWrapper = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setCollectOaid(boolean z) {
        int i = d + 43;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setCollectOaid", String.valueOf(z));
        getCurrencyIso4217Code(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
        int i3 = AFKeystoreWrapper + 55;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setResolveDeepLinkURLs(String... strArr) {
        int i = d + 51;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", Arrays.toString(strArr)));
        AFa1rSDK i3 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).i();
        i3.component4.clear();
        i3.component4.addAll(Arrays.asList(strArr));
        int i4 = AFKeystoreWrapper + 37;
        d = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOneLinkCustomDomain(String... strArr) {
        Object revenue;
        int i = d + 91;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? (char) 24 : 'G') != 'G') {
            AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", Arrays.toString(strArr)));
            revenue = getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
        } else {
            AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", Arrays.toString(strArr)));
            revenue = getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
        }
        ((AFc1bSDK) revenue).i().areAllFieldsValid = strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void copy() {
        AFi1qSDK aFi1qSDK;
        int i = AFKeystoreWrapper + 125;
        d = i % 128;
        if ((i % 2 == 0 ? 'P' : 'O') == 'P') {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afRDLog().getMonetizationNetwork();
            throw null;
        }
        if ((((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afRDLog().getMonetizationNetwork() ? '\\' : 'D') != 'D') {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afRDLog().getRevenue();
        }
        AFi1sSDK w = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).w();
        if (Build.VERSION.SDK_INT >= 31) {
            aFi1qSDK = new AFi1oSDK(w.getCurrencyIso4217Code);
        } else {
            aFi1qSDK = new AFi1qSDK(w.getCurrencyIso4217Code);
            int i2 = d + 67;
            AFKeystoreWrapper = i2 % 128;
            int i3 = i2 % 2;
        }
        w.getMediationNetwork = aFi1qSDK;
        AFf1cSDK AFKeystoreWrapper2 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper();
        AFf1cSDK.getRevenue(new Object[]{AFKeystoreWrapper2, ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).getCurrencyIso4217Code()}, 826598914, -826598912, System.identityHashCode(AFKeystoreWrapper2));
        AFh1tSDK component3 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component3();
        component3.component2 = System.currentTimeMillis();
        int mediationNetwork = component3.getMediationNetwork.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0);
        if (mediationNetwork == 1 && component3.getCurrencyIso4217Code.getRevenue("first_launch")) {
            int i4 = d + 71;
            AFKeystoreWrapper = i4 % 128;
            int i5 = i4 % 2;
            component3.getMonetizationNetwork.putAll(component3.AFAdRevenueData("first_launch"));
        }
        if (mediationNetwork > 0) {
            if ((component3.getCurrencyIso4217Code.getRevenue("gcd") ? (char) 23 : 'W') == 23) {
                int i6 = d + 75;
                AFKeystoreWrapper = i6 % 128;
                int i7 = i6 % 2;
                component3.AFAdRevenueData.putAll(component3.AFAdRevenueData("gcd"));
            }
        }
        component3.hashCode = component3.getCurrencyIso4217Code.getCurrencyIso4217Code("prev_session_dur", 0L);
        component2();
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFInAppEventType().getCurrencyIso4217Code();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMediationNetwork(boolean z) {
        int i = AFKeystoreWrapper;
        int i2 = i + 113;
        d = i2 % 128;
        int i3 = i2 % 2;
        if (!(z)) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afErrorLog().getMonetizationNetwork();
            return;
        }
        int i4 = i + 99;
        d = i4 % 128;
        int i5 = i4 % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afErrorLog().getCurrencyIso4217Code();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void equals() {
        getCurrencyIso4217Code(new AFh1kSDK());
        int i = AFKeystoreWrapper + 69;
        d = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        int i2 = 11 / 0;
    }

    private static /* synthetic */ Object component1(Object[] objArr) {
        final AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        String str = (String) objArr[1];
        AppsFlyerConversionListener appsFlyerConversionListener = (AppsFlyerConversionListener) objArr[2];
        Context context = (Context) objArr[3];
        int i = AFKeystoreWrapper + 65;
        d = i % 128;
        if (i % 2 == 0) {
            boolean z = aFa1uSDK.toString;
            throw null;
        } else if (aFa1uSDK.toString) {
            return aFa1uSDK;
        } else {
            aFa1uSDK.toString = true;
            ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).AFKeystoreWrapper().getMonetizationNetwork(str);
            if (context != null) {
                aFa1uSDK.getMediationNetwork(context);
                Application O_ = AFj1iSDK.O_(context);
                if (O_ == null) {
                    return aFa1uSDK;
                }
                aFa1uSDK.component3 = O_;
                ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).getMediationNetwork().execute(new Runnable() { // from class: com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        AFa1uSDK.this.copy();
                    }
                });
                AFe1nSDK copydefault = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).copydefault();
                copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(new AFe1fSDK(aFa1uSDK.getCurrencyIso4217Code())));
                ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).afWarnLog().getMediationNetwork(new AFd1xSDK.AFa1ySDK() { // from class: com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda4
                    @Override // com.appsflyer.internal.AFd1xSDK.AFa1ySDK
                    public final void onConfigurationChanged(boolean z2) {
                        AFa1uSDK.this.getMediationNetwork(z2);
                    }
                });
                ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).component1().getRevenue(aFa1uSDK.AFAdRevenueData());
                AFj1rSDK AFLogger2 = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).AFLogger();
                Runnable runnable = new Runnable() { // from class: com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        AFa1uSDK.this.equals();
                    }
                };
                AFi1bSDK monetizationNetwork = AFLogger2.getMonetizationNetwork(runnable);
                Runnable revenue = AFLogger2.getRevenue(monetizationNetwork, runnable);
                AFLogger2.getCurrencyIso4217Code.add(monetizationNetwork);
                AFLogger2.getCurrencyIso4217Code.add(new AFj1mSDK(AFLogger2.getMonetizationNetwork.getCurrencyIso4217Code(), revenue));
                AFLogger2.getCurrencyIso4217Code.add(new AFj1zSDK(revenue, AFLogger2.getMonetizationNetwork, new AFj1vSDK()));
                AFLogger2.getCurrencyIso4217Code.add(new AFj1lSDK(revenue, AFLogger2.getMonetizationNetwork));
                AFLogger2.getCurrencyIso4217Code.add(new AFj1uSDK(AFLogger2.getMonetizationNetwork.getMediationNetwork(), AFLogger2.getMonetizationNetwork.getCurrencyIso4217Code(), revenue));
                AFLogger2.getMediationNetwork(revenue);
                AFj1qSDK[] aFj1qSDKArr = (AFj1qSDK[]) AFLogger2.getCurrencyIso4217Code.toArray(new AFj1qSDK[0]);
                int length = aFj1qSDKArr.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3 = AFKeystoreWrapper + 89;
                    d = i3 % 128;
                    if (i3 % 2 == 0) {
                        aFj1qSDKArr[i2].getCurrencyIso4217Code(AFLogger2.getMonetizationNetwork.registerClient().getRevenue);
                        i2 += 21;
                    } else {
                        aFj1qSDKArr[i2].getCurrencyIso4217Code(AFLogger2.getMonetizationNetwork.registerClient().getRevenue);
                        i2++;
                    }
                }
                if (!AFLogger2.getMediationNetwork()) {
                    AFLogger2.AFAdRevenueData(AFLogger2.getMonetizationNetwork.registerClient().getRevenue, revenue, AFLogger2.getMonetizationNetwork);
                    int i4 = AFKeystoreWrapper + 47;
                    d = i4 % 128;
                    int i5 = i4 % 2;
                }
            } else {
                AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "context is null, Google Install Referrer will be not initialized");
            }
            AFd1mSDK equals = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).equals();
            String[] strArr = new String[2];
            strArr[0] = str;
            strArr[1] = (appsFlyerConversionListener == null ? (char) 31 : (char) 15) != 31 ? "conversionDataListener" : "null";
            equals.getCurrencyIso4217Code("init", strArr);
            AFLogger.INSTANCE.force(AFg1cSDK.GENERAL, String.format("Initializing AppsFlyer SDK: (v%s.%s)", "6.17.3", getRevenue));
            aFa1uSDK.getMediationNetwork = appsFlyerConversionListener;
            return aFa1uSDK;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMediationNetwork(AFi1jSDK aFi1jSDK) {
        int i = d + 57;
        AFKeystoreWrapper = i % 128;
        char c = i % 2 != 0 ? '_' : (char) 19;
        getMonetizationNetwork(aFi1jSDK);
        if (c == 19) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private void component2() {
        int i = AFKeystoreWrapper + 77;
        d = i % 128;
        int i2 = i % 2;
        try {
            final AFi1jSDK v = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).v();
            if (v == null) {
                return;
            }
            if ((v.getMonetizationNetwork() ? (char) 5 : ';') != 5) {
                if ((!v.getMediationNetwork() ? 'O' : (char) 3) != 3) {
                    getMonetizationNetwork(v);
                    return;
                }
                return;
            }
            int i3 = d + 9;
            AFKeystoreWrapper = i3 % 128;
            int i4 = i3 % 2;
            v.getMonetizationNetwork(new AFi1eSDK() { // from class: com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda7
                @Override // com.appsflyer.internal.AFi1eSDK
                public final void onRequestFinished() {
                    AFa1uSDK.this.getMediationNetwork(v);
                }
            });
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("Error at attempt to request PIA token", th);
            AFLogger.afRDLog("Get PIA token failed with exception:".concat(String.valueOf(th)));
        }
    }

    private void getMonetizationNetwork(AFi1jSDK aFi1jSDK) {
        AFf1ySDK aFf1ySDK = new AFf1ySDK(aFi1jSDK, getCurrencyIso4217Code().getCurrencyIso4217Code(), getCurrencyIso4217Code(), getCurrencyIso4217Code().component4(), getCurrencyIso4217Code().registerClient());
        AFe1nSDK copydefault = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).copydefault();
        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFf1ySDK));
        int i = AFKeystoreWrapper + 1;
        d = i % 128;
        int i2 = i % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void enableFacebookDeferredApplinks(boolean z) {
        int i = AFKeystoreWrapper + 47;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).unregisterClient().getMonetizationNetwork(z);
        int i3 = AFKeystoreWrapper + 73;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context) {
        int i = d + 27;
        AFKeystoreWrapper = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? 'X' : '>') == '>') {
            start(context, null);
            int i2 = d + 61;
            AFKeystoreWrapper = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        start(context, null);
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String str) {
        int i = AFKeystoreWrapper + 1;
        d = i % 128;
        int i2 = i % 2;
        start(context, str, null);
        int i3 = AFKeystoreWrapper + 29;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        if (((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afDebugLog().getCurrencyIso4217Code()) {
            return;
        }
        if (!this.toString) {
            getMediationNetwork("start");
            if ((str == null ? '.' : 'A') != 'A') {
                int i = AFKeystoreWrapper + 79;
                int i2 = i % 128;
                d = i2;
                if (i % 2 == 0) {
                    throw null;
                } else if (appsFlyerRequestListener != null) {
                    int i3 = i2 + 21;
                    AFKeystoreWrapper = i3 % 128;
                    if ((i3 % 2 != 0 ? 'P' : 'N') != 'P') {
                        appsFlyerRequestListener.onError(41, "No dev key");
                        return;
                    } else {
                        appsFlyerRequestListener.onError(88, "No dev key");
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        getMediationNetwork(context);
        final AFh1tSDK component3 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component3();
        component3.getRevenue(AFh1uSDK.getRevenue(context));
        if ((this.component3 == null ? '3' : 'M') == '3') {
            int i4 = AFKeystoreWrapper + 35;
            d = i4 % 128;
            int i5 = i4 % 2;
            Application O_ = AFj1iSDK.O_(context);
            if (!(O_ != null)) {
                return;
            }
            int i6 = AFKeystoreWrapper + 109;
            d = i6 % 128;
            int i7 = i6 % 2;
            this.component3 = O_;
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("start", str);
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.GENERAL;
        String str2 = getRevenue;
        aFLogger.i(aFg1cSDK, String.format("Starting AppsFlyer: (v%s.%s)", "6.17.3", str2));
        AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, new StringBuilder("Build Number: ").append(str2).toString());
        AppsFlyerProperties.getInstance().loadProperties(((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component2());
        if (TextUtils.isEmpty(str)) {
            if (!(!TextUtils.isEmpty(((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMediationNetwork()))) {
                int i8 = AFKeystoreWrapper + 63;
                d = i8 % 128;
                if (i8 % 2 != 0) {
                    copydefault();
                    if (appsFlyerRequestListener == null) {
                        return;
                    }
                } else {
                    copydefault();
                    int i9 = 69 / 0;
                    if (appsFlyerRequestListener == null) {
                        return;
                    }
                }
                int i10 = d + 29;
                AFKeystoreWrapper = i10 % 128;
                int i11 = i10 % 2;
                appsFlyerRequestListener.onError(41, "No dev key");
                return;
            }
        } else {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMonetizationNetwork(str);
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component1().getRevenue(AFAdRevenueData());
        component4();
        c_(this.component3.getBaseContext(), this.hashCode.getCurrencyIso4217Code().n_());
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).unregisterClient().getMediationNetwork();
        this.hashCode.afDebugLog().getCurrencyIso4217Code(context, new AFb1aSDK.AFa1ySDK() { // from class: com.appsflyer.internal.AFa1uSDK.3
            @Override // com.appsflyer.internal.AFb1aSDK.AFa1ySDK
            public final void getMonetizationNetwork(AFh1rSDK aFh1rSDK) {
                component3.getMonetizationNetwork();
                AFa1uSDK aFa1uSDK = AFa1uSDK.this;
                AFc1bSDK aFc1bSDK = (AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK));
                aFc1bSDK.component1().getRevenue(AFa1uSDK.this.AFAdRevenueData());
                AFa1uSDK.this.component4();
                int mediationNetwork = aFc1bSDK.getCurrencyIso4217Code().getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0);
                AFLogger.afInfoLog("onBecameForeground");
                if (mediationNetwork < 2) {
                    AFa1uSDK aFa1uSDK2 = AFa1uSDK.this;
                    ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK2}, 389316487, -389316474, System.identityHashCode(aFa1uSDK2))).copy().getMonetizationNetwork();
                }
                AFh1eSDK aFh1eSDK = new AFh1eSDK();
                AFa1uSDK aFa1uSDK3 = AFa1uSDK.this;
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK3}, 389316487, -389316474, System.identityHashCode(aFa1uSDK3))).i().f_(AFa1gSDK.AFAdRevenueData(aFh1eSDK), aFh1rSDK.getMediationNetwork, aFc1bSDK.registerClient().getRevenue);
                AFh1qSDK afLogForce = aFc1bSDK.afLogForce();
                if (afLogForce != null && aFh1rSDK.getMediationNetwork != null) {
                    Intent intent = aFh1rSDK.getMediationNetwork;
                    AFa1uSDK aFa1uSDK4 = AFa1uSDK.this;
                    afLogForce.u_(intent, ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK4}, 389316487, -389316474, System.identityHashCode(aFa1uSDK4))).i());
                }
                AFa1uSDK aFa1uSDK5 = AFa1uSDK.this;
                aFh1eSDK.getMonetizationNetwork = appsFlyerRequestListener;
                aFa1uSDK5.getMediationNetwork(aFh1eSDK, aFh1rSDK);
                AFa1uSDK aFa1uSDK6 = AFa1uSDK.this;
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK6}, 389316487, -389316474, System.identityHashCode(aFa1uSDK6))).AFAdRevenueData().AFAdRevenueData();
                AFa1uSDK aFa1uSDK7 = AFa1uSDK.this;
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK7}, 389316487, -389316474, System.identityHashCode(aFa1uSDK7))).AFAdRevenueData().getRevenue.getCurrencyIso4217Code("didSendRevenueTriggerOnLastBackground", false);
            }

            @Override // com.appsflyer.internal.AFb1aSDK.AFa1ySDK
            public final void getMediationNetwork() {
                AFa1uSDK aFa1uSDK = AFa1uSDK.this;
                Context context2 = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).registerClient().getRevenue;
                AFLogger.afInfoLog("onBecameBackground");
                AFh1tSDK aFh1tSDK = component3;
                long currentTimeMillis = System.currentTimeMillis();
                if (aFh1tSDK.component3 != 0) {
                    long j = currentTimeMillis - aFh1tSDK.component3;
                    if (j > 0 && j < 1000) {
                        j = 1000;
                    }
                    aFh1tSDK.hashCode = TimeUnit.MILLISECONDS.toSeconds(j);
                    aFh1tSDK.getCurrencyIso4217Code.getRevenue("prev_session_dur", aFh1tSDK.hashCode);
                } else {
                    AFLogger.afInfoLog("Metrics: fg ts is missing");
                }
                AFLogger.afInfoLog("callStatsBackground background call");
                AFa1uSDK aFa1uSDK2 = AFa1uSDK.this;
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK2}, 389316487, -389316474, System.identityHashCode(aFa1uSDK2))).afWarnLog().getCurrencyIso4217Code();
                AFa1uSDK aFa1uSDK3 = AFa1uSDK.this;
                AFd1mSDK equals = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK3}, 389316487, -389316474, System.identityHashCode(aFa1uSDK3))).equals();
                if (equals.areAllFieldsValid()) {
                    equals.AFAdRevenueData();
                    if (context2 != null && !AppsFlyerLib.getInstance().isStopped()) {
                        equals.q_(context2.getPackageName(), context2.getPackageManager());
                    }
                    equals.getRevenue();
                } else {
                    AFLogger.afDebugLog("RD status is OFF");
                }
                AFa1uSDK aFa1uSDK4 = AFa1uSDK.this;
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK4}, 389316487, -389316474, System.identityHashCode(aFa1uSDK4))).copy().getMediationNetwork();
                AFa1uSDK aFa1uSDK5 = AFa1uSDK.this;
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK5}, 389316487, -389316474, System.identityHashCode(aFa1uSDK5))).afErrorLogForExcManagerOnly().getMediationNetwork();
                AFa1uSDK aFa1uSDK6 = AFa1uSDK.this;
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK6}, 389316487, -389316474, System.identityHashCode(aFa1uSDK6))).AFAdRevenueData().AFAdRevenueData();
                AFa1uSDK aFa1uSDK7 = AFa1uSDK.this;
                AFh1qSDK afLogForce = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK7}, 389316487, -389316474, System.identityHashCode(aFa1uSDK7))).afLogForce();
                if (afLogForce != null) {
                    afLogForce.getCurrencyIso4217Code();
                }
            }
        });
    }

    private static void c_(Context context, PackageInfo packageInfo) {
        try {
            if (packageInfo.applicationInfo != null) {
                int i = AFKeystoreWrapper + 7;
                d = i % 128;
                if (i % 2 != 0) {
                    if (!((packageInfo.applicationInfo.flags & 32768) != 0 ? true : true)) {
                        if ((Build.VERSION.SDK_INT >= 31 ? '!' : '?') == '!') {
                            if (context.getResources().getIdentifier("appsflyer_data_extraction_rules", "xml", context.getPackageName()) != 0) {
                                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "appsflyer_data_extraction_rules.xml detected, using AppsFlyer data extraction rules for AppsFlyer SDK data", true);
                                int i2 = d + 109;
                                AFKeystoreWrapper = i2 % 128;
                                int i3 = i2 % 2;
                                return;
                            }
                            AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "'allowBackup' is set to true; appsflyer_data_extraction_rules.xml is NOT detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <data-extraction-rules> both in <device-transfer> and <cloud-backup>.\nIf Appsflyer's Purchase Connector is in use then you also must add to <device-transfer> and <cloud-backup> the following excludes: <exclude domain=\"sharedpref\" path=\"appsflyer-purchase-data\"/> AND <exclude domain=\"database\" path=\"afpurchases.db\"/>", true);
                            return;
                        }
                        if ((context.getResources().getIdentifier("appsflyer_backup_rules", "xml", context.getPackageName()) != 0 ? 'L' : (char) 1) != 1) {
                            AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                            return;
                        } else {
                            AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "'allowBackup' is set to true; appsflyer_backup_rules.xml is NOT detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules.\nIf Appsflyer's Purchase Connector is in use then you also must add the following to your rules: <exclude domain=\"sharedpref\" path=\"appsflyer-purchase-data\"/> AND <exclude domain=\"database\" path=\"afpurchases.db\"/>", true);
                            return;
                        }
                    }
                    return;
                }
                int i4 = packageInfo.applicationInfo.flags;
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception while checking BackupRules: ", th);
        }
    }

    public static String getMediationNetwork() {
        int i = d + 63;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        String currencyIso4217Code = getCurrencyIso4217Code(AppsFlyerProperties.APP_USER_ID);
        int i3 = AFKeystoreWrapper + 85;
        d = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 76 / 0;
            return currencyIso4217Code;
        }
        return currencyIso4217Code;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerUserId(String str) {
        int i = AFKeystoreWrapper + 25;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        getCurrencyIso4217Code(AppsFlyerProperties.APP_USER_ID, str);
        getRevenue(new Object[]{AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false}, -222394073, 222394090, (int) System.currentTimeMillis());
        int i3 = AFKeystoreWrapper + 5;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPhoneNumber(String str) {
        int i = AFKeystoreWrapper + 23;
        d = i % 128;
        if ((i % 2 == 0 ? (char) 26 : 'c') != 26) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afInfoLog().getMonetizationNetwork = AFj1bSDK.getCurrencyIso4217Code(str);
            int i2 = AFKeystoreWrapper + 5;
            d = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afInfoLog().getMonetizationNetwork = AFj1bSDK.getCurrencyIso4217Code(str);
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAppId(String str) {
        int i = AFKeystoreWrapper + 111;
        d = i % 128;
        if (!(i % 2 != 0)) {
            AFd1mSDK equals = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals();
            String[] strArr = new String[0];
            strArr[0] = str;
            equals.getCurrencyIso4217Code("setAppId", strArr);
        } else {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setAppId", str);
        }
        getCurrencyIso4217Code(AppsFlyerProperties.APP_ID, str);
        int i2 = d + 89;
        AFKeystoreWrapper = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setExtension(String str) {
        int i = d + 9;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
        int i3 = AFKeystoreWrapper + 23;
        d = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        int i4 = 59 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setIsUpdate(boolean z) {
        int i = d + 55;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? (char) 22 : '@') != 22) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setIsUpdate", String.valueOf(z));
        } else {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setIsUpdate", String.valueOf(z));
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCurrencyCode(String str) {
        int i = AFKeystoreWrapper + 117;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
        int i3 = d + 15;
        AFKeystoreWrapper = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logLocation(Context context, double d2, double d3) {
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("logLocation", String.valueOf(d2), String.valueOf(d3));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGITUDE, Double.toString(d3));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d2));
        AFAdRevenueData(context, AFInAppEventType.LOCATION_COORDINATES, hashMap);
        int i = d + 59;
        AFKeystoreWrapper = i % 128;
        if (!(i % 2 == 0)) {
            int i2 = 60 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logSession(Context context) {
        int i = AFKeystoreWrapper + 25;
        d = i % 128;
        int i2 = i % 2;
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("logSession", new String[0]);
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getMonetizationNetwork();
        getMediationNetwork(context, AFh1xSDK.logSession);
        AFAdRevenueData(context, (String) null, (Map<String, Object>) null);
        int i3 = AFKeystoreWrapper + 107;
        d = i3 % 128;
        if ((i3 % 2 == 0 ? '\t' : 'W') != '\t') {
            return;
        }
        int i4 = 63 / 0;
    }

    private void getMediationNetwork(Context context, AFh1xSDK aFh1xSDK) {
        int i = d + 29;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        getMediationNetwork(context);
        AFh1tSDK component3 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component3();
        AFh1uSDK revenue = AFh1uSDK.getRevenue(context);
        if ((component3.getCurrencyIso4217Code() ? (char) 28 : (char) 26) == 28) {
            int i3 = d + 125;
            AFKeystoreWrapper = i3 % 128;
            if (i3 % 2 != 0) {
                component3.getMonetizationNetwork.put("api_name", aFh1xSDK.toString());
                component3.getRevenue(revenue);
                int i4 = 2 / 0;
            } else {
                component3.getMonetizationNetwork.put("api_name", aFh1xSDK.toString());
                component3.getRevenue(revenue);
            }
        }
        component3.getMonetizationNetwork();
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logAdRevenue(AFAdRevenueData aFAdRevenueData, Map<String, Object> map) {
        if (!this.toString) {
            getMediationNetwork("logAdRevenue");
            int i = AFKeystoreWrapper + 119;
            d = i % 128;
            int i2 = i % 2;
        } else if (!aFAdRevenueData.areAllFieldsValid()) {
            int i3 = AFKeystoreWrapper + 9;
            d = i3 % 128;
            if (i3 % 2 != 0) {
                AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "Invalid ad revenue parameters provided");
                return;
            }
            AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "Invalid ad revenue parameters provided");
            int i4 = 32 / 0;
        } else {
            if ((((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMonetizationNetwork() ? '^' : ')') == ')') {
                if (AFk1xSDK.getRevenue(((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMediationNetwork())) {
                    copydefault();
                    return;
                } else {
                    getMonetizationNetwork(new AFh1nSDK(aFAdRevenueData, map));
                    return;
                }
            }
            int i5 = AFKeystoreWrapper + 87;
            d = i5 % 128;
            if ((i5 % 2 == 0 ? 'N' : (char) 24) != 'N') {
                AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "SDK is stopped");
                return;
            }
            AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "SDK is stopped");
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    private AFh1rSDK AFAdRevenueData(Context context) {
        int i = AFKeystoreWrapper + 87;
        d = i % 128;
        int i2 = i % 2;
        Object obj = null;
        if (context instanceof Activity) {
            AFh1rSDK aFh1rSDK = new AFh1rSDK((Activity) context, getCurrencyIso4217Code().d());
            int i3 = AFKeystoreWrapper + 67;
            d = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return aFh1rSDK;
            }
            obj.hashCode();
            throw null;
        }
        return null;
    }

    private void AFAdRevenueData(Context context, String str, Map<String, Object> map) {
        AFh1hSDK aFh1hSDK = new AFh1hSDK();
        aFh1hSDK.component4 = str;
        aFh1hSDK.AFAdRevenueData = map;
        getMediationNetwork(aFh1hSDK, AFAdRevenueData(context));
        int i = d + 7;
        AFKeystoreWrapper = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        int i2 = 38 / 0;
    }

    final void getMediationNetwork(AFh1jSDK aFh1jSDK, AFh1rSDK aFh1rSDK) {
        AppsFlyerRequestListener appsFlyerRequestListener;
        AFAdRevenueData(aFh1jSDK, aFh1rSDK);
        if ((((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMediationNetwork() == null ? 'V' : '%') != 'V') {
            String referrer = AppsFlyerProperties.getInstance().getReferrer(((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component2());
            if (!(referrer != null)) {
                int i = d + 117;
                AFKeystoreWrapper = i % 128;
                if (i % 2 != 0) {
                    throw null;
                }
                referrer = "";
            }
            aFh1jSDK.areAllFieldsValid = referrer;
            getMonetizationNetwork(aFh1jSDK);
            return;
        }
        int i2 = AFKeystoreWrapper + 117;
        d = i2 % 128;
        if ((i2 % 2 == 0 ? 'U' : 'N') != 'N') {
            AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            appsFlyerRequestListener = aFh1jSDK.getMonetizationNetwork;
            int i3 = 1 / 0;
            if (appsFlyerRequestListener == null) {
                return;
            }
        } else {
            AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            appsFlyerRequestListener = aFh1jSDK.getMonetizationNetwork;
            if (appsFlyerRequestListener == null) {
                return;
            }
        }
        appsFlyerRequestListener.onError(41, "No dev key");
    }

    private static void AFAdRevenueData(AFh1jSDK aFh1jSDK, AFh1rSDK aFh1rSDK) {
        int i = d + 89;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? '^' : (char) 14) == '^') {
            Object obj = null;
            obj.hashCode();
            throw null;
        } else if (aFh1rSDK != null) {
            aFh1jSDK.getMediationNetwork = aFh1rSDK.AFAdRevenueData;
            aFh1jSDK.component2 = aFh1rSDK.getMonetizationNetwork;
            int i2 = AFKeystoreWrapper + 95;
            d = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void anonymizeUser(boolean z) {
        int i = d + 67;
        AFKeystoreWrapper = i % 128;
        if (i % 2 == 0) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("anonymizeUser", String.valueOf(z));
        } else {
            AFd1mSDK equals = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals();
            String[] strArr = new String[1];
            strArr[1] = String.valueOf(z);
            equals.getCurrencyIso4217Code("anonymizeUser", strArr);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
        int i2 = AFKeystoreWrapper + 87;
        d = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        int i3 = 42 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = d + 111;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? '!' : 'W') != 'W') {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("registerConversionListener", new String[1]);
        } else {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("registerConversionListener", new String[0]);
        }
        getRevenue(appsFlyerConversionListener);
    }

    private void getRevenue(AppsFlyerConversionListener appsFlyerConversionListener) {
        if (appsFlyerConversionListener != null) {
            this.getMediationNetwork = appsFlyerConversionListener;
            int i = d + 109;
            AFKeystoreWrapper = i % 128;
            if ((i % 2 != 0 ? (char) 2 : '_') != 2) {
                return;
            }
            int i2 = 20 / 0;
            return;
        }
        int i3 = d + 13;
        AFKeystoreWrapper = i3 % 128;
        int i4 = i3 % 2;
    }

    private static /* synthetic */ Object component4(Object[] objArr) {
        AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        int i = AFKeystoreWrapper + 21;
        d = i % 128;
        if (!(i % 2 == 0)) {
            ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).equals().getCurrencyIso4217Code("unregisterConversionListener", new String[0]);
        } else {
            ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).equals().getCurrencyIso4217Code("unregisterConversionListener", new String[0]);
        }
        aFa1uSDK.getMediationNetwork = null;
        int i2 = d + 57;
        AFKeystoreWrapper = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 28 : 'Y') != 28) {
            return null;
        }
        int i3 = 95 / 0;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
        if ((r9 == null ? 'c' : 3) != 'c') goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
        com.appsflyer.internal.AFa1uSDK.getCurrencyIso4217Code = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
        r8 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper + 9;
        com.appsflyer.internal.AFa1uSDK.d = r8 % 128;
        r8 = r8 % 2;
        com.appsflyer.AFLogger.afDebugLog("registerValidatorListener null listener");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
        if ((r9 != null) != false) goto L10;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void registerValidatorListener(android.content.Context r8, com.appsflyer.AppsFlyerInAppPurchaseValidatorListener r9) {
        /*
            r7 = this;
            int r8 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r8 = r8 + 97
            int r0 = r8 % 128
            com.appsflyer.internal.AFa1uSDK.d = r0
            int r8 = r8 % 2
            java.lang.String r0 = "registerValidatorListener called"
            java.lang.String r1 = "registerValidatorListener"
            r2 = -389316474(0xffffffffe8cb8086, float:-7.68809E24)
            r3 = 389316487(0x17347f87, float:5.83221E-25)
            r4 = 1
            r5 = 0
            if (r8 != 0) goto L38
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r5] = r7
            int r6 = java.lang.System.identityHashCode(r7)
            java.lang.Object r8 = getRevenue(r8, r3, r2, r6)
            com.appsflyer.internal.AFc1bSDK r8 = (com.appsflyer.internal.AFc1bSDK) r8
            com.appsflyer.internal.AFd1mSDK r8 = r8.equals()
            java.lang.String[] r2 = new java.lang.String[r5]
            r8.getCurrencyIso4217Code(r1, r2)
            com.appsflyer.AFLogger.afDebugLog(r0)
            if (r9 != 0) goto L35
            r4 = r5
        L35:
            if (r4 == 0) goto L5e
            goto L5b
        L38:
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r5] = r7
            int r4 = java.lang.System.identityHashCode(r7)
            java.lang.Object r8 = getRevenue(r8, r3, r2, r4)
            com.appsflyer.internal.AFc1bSDK r8 = (com.appsflyer.internal.AFc1bSDK) r8
            com.appsflyer.internal.AFd1mSDK r8 = r8.equals()
            java.lang.String[] r2 = new java.lang.String[r5]
            r8.getCurrencyIso4217Code(r1, r2)
            com.appsflyer.AFLogger.afDebugLog(r0)
            r8 = 99
            if (r9 != 0) goto L58
            r0 = r8
            goto L59
        L58:
            r0 = 3
        L59:
            if (r0 == r8) goto L5e
        L5b:
            com.appsflyer.internal.AFa1uSDK.getCurrencyIso4217Code = r9
            return
        L5e:
            int r8 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r8 = r8 + 9
            int r9 = r8 % 128
            com.appsflyer.internal.AFa1uSDK.d = r9
            int r8 = r8 % 2
            java.lang.String r8 = "registerValidatorListener null listener"
            com.appsflyer.AFLogger.afDebugLog(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.registerValidatorListener(android.content.Context, com.appsflyer.AppsFlyerInAppPurchaseValidatorListener):void");
    }

    public static String getMediationNetwork(SimpleDateFormat simpleDateFormat, long j) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j));
        int i = AFKeystoreWrapper + 35;
        d = i % 128;
        int i2 = i % 2;
        return format;
    }

    private void getRevenue(Context context, String str) {
        AFh1eSDK aFh1eSDK = new AFh1eSDK();
        getMediationNetwork(context);
        aFh1eSDK.component4 = null;
        aFh1eSDK.AFAdRevenueData = null;
        aFh1eSDK.areAllFieldsValid = str;
        aFh1eSDK.getMediationNetwork = null;
        getMonetizationNetwork(aFh1eSDK);
        int i = AFKeystoreWrapper + 5;
        d = i % 128;
        int i2 = i % 2;
    }

    private boolean areAllFieldsValid() {
        int i = AFKeystoreWrapper + 19;
        d = i % 128;
        int i2 = i % 2;
        if (this.component4 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.component4;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            String mediationNetwork = getMediationNetwork(simpleDateFormat, this.component4);
            String mediationNetwork2 = getMediationNetwork(simpleDateFormat, this.getMonetizationNetwork);
            if (currentTimeMillis < this.component2) {
                if ((!isStopped() ? (char) 17 : '!') != '!') {
                    int i3 = AFKeystoreWrapper + 121;
                    d = i3 % 128;
                    if (i3 % 2 != 0) {
                        AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", mediationNetwork, mediationNetwork2, Long.valueOf(currentTimeMillis), Long.valueOf(this.component2)));
                        return true;
                    }
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[4];
                    objArr[1] = mediationNetwork;
                    objArr[1] = mediationNetwork2;
                    objArr[4] = Long.valueOf(currentTimeMillis);
                    objArr[2] = Long.valueOf(this.component2);
                    AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", objArr));
                    return false;
                }
            }
            if (!isStopped()) {
                int i4 = d + 97;
                AFKeystoreWrapper = i4 % 128;
                int i5 = i4 % 2;
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", mediationNetwork, mediationNetwork2, Long.valueOf(currentTimeMillis)));
            }
        } else {
            if (!isStopped()) {
                int i6 = AFKeystoreWrapper + 77;
                d = i6 % 128;
                if (i6 % 2 == 0) {
                    AFLogger.afInfoLog("Sending first launch for this session!");
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
                AFLogger.afInfoLog("Sending first launch for this session!");
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        if ((r9.length() <= 2) != true) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r9.length() > 5) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        r9 = com.appsflyer.internal.AFa1uSDK.d + 35;
        com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        if ((r9 % 2) != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
        if (((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r8}, 389316487, -389316474, java.lang.System.identityHashCode(r8))).AFLogger().AFAdRevenueData(r0) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        com.appsflyer.internal.AFj1aSDK.AFAdRevenueData(((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r8}, 389316487, -389316474, java.lang.System.identityHashCode(r8))).getMonetizationNetwork(), new com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda1(r8, r0), 5, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
        ((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r8}, 389316487, -389316474, java.lang.System.identityHashCode(r8))).AFLogger().AFAdRevenueData(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ae, code lost:
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void getRevenue(java.lang.String r9) {
        /*
            r8 = this;
            com.appsflyer.internal.AFh1lSDK r0 = new com.appsflyer.internal.AFh1lSDK
            r0.<init>()
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r8
            int r4 = java.lang.System.identityHashCode(r8)
            r5 = 389316487(0x17347f87, float:5.83221E-25)
            r6 = -389316474(0xffffffffe8cb8086, float:-7.68809E24)
            java.lang.Object r2 = getRevenue(r2, r5, r6, r4)
            com.appsflyer.internal.AFc1bSDK r2 = (com.appsflyer.internal.AFc1bSDK) r2
            com.appsflyer.internal.AFc1pSDK r2 = r2.getCurrencyIso4217Code()
            com.appsflyer.internal.AFc1oSDK r2 = r2.getMonetizationNetwork
            java.lang.String r4 = "appsFlyerCount"
            int r2 = r2.getMediationNetwork(r4, r3)
            com.appsflyer.internal.AFh1jSDK r0 = r0.getMonetizationNetwork(r2)
            r0.areAllFieldsValid = r9
            r2 = 89
            if (r9 == 0) goto L34
            r4 = 78
            goto L35
        L34:
            r4 = r2
        L35:
            r7 = 2
            if (r4 == r2) goto Lb1
            int r2 = com.appsflyer.internal.AFa1uSDK.d
            int r2 = r2 + 39
            int r4 = r2 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r4
            int r2 = r2 % r7
            if (r2 == 0) goto L4f
            int r9 = r9.length()
            if (r9 <= r7) goto L4b
            r9 = r3
            goto L4c
        L4b:
            r9 = r1
        L4c:
            if (r9 == r1) goto Lb1
            goto L56
        L4f:
            int r9 = r9.length()
            r2 = 5
            if (r9 <= r2) goto Lb1
        L56:
            int r9 = com.appsflyer.internal.AFa1uSDK.d
            int r9 = r9 + 35
            int r2 = r9 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r2
            int r9 = r9 % r7
            if (r9 != 0) goto L98
            java.lang.Object[] r9 = new java.lang.Object[r1]
            r9[r3] = r8
            int r2 = java.lang.System.identityHashCode(r8)
            java.lang.Object r9 = getRevenue(r9, r5, r6, r2)
            com.appsflyer.internal.AFc1bSDK r9 = (com.appsflyer.internal.AFc1bSDK) r9
            com.appsflyer.internal.AFj1rSDK r9 = r9.AFLogger()
            boolean r9 = r9.AFAdRevenueData(r0)
            if (r9 == 0) goto Lb1
            java.lang.Object[] r9 = new java.lang.Object[r1]
            r9[r3] = r8
            int r1 = java.lang.System.identityHashCode(r8)
            java.lang.Object r9 = getRevenue(r9, r5, r6, r1)
            com.appsflyer.internal.AFc1bSDK r9 = (com.appsflyer.internal.AFc1bSDK) r9
            java.util.concurrent.ScheduledExecutorService r9 = r9.getMonetizationNetwork()
            com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda1 r1 = new com.appsflyer.internal.AFa1uSDK$$ExternalSyntheticLambda1
            r1.<init>()
            r2 = 5
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.appsflyer.internal.AFj1aSDK.AFAdRevenueData(r9, r1, r2, r0)
            goto Lb1
        L98:
            java.lang.Object[] r9 = new java.lang.Object[r1]
            r9[r3] = r8
            int r1 = java.lang.System.identityHashCode(r8)
            java.lang.Object r9 = getRevenue(r9, r5, r6, r1)
            com.appsflyer.internal.AFc1bSDK r9 = (com.appsflyer.internal.AFc1bSDK) r9
            com.appsflyer.internal.AFj1rSDK r9 = r9.AFLogger()
            r9.AFAdRevenueData(r0)
            r9 = 0
            throw r9     // Catch: java.lang.Throwable -> Laf
        Laf:
            r9 = move-exception
            throw r9
        Lb1:
            int r9 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r9 = r9 + 111
            int r0 = r9 % 128
            com.appsflyer.internal.AFa1uSDK.d = r0
            int r9 = r9 % r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.getRevenue(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMediationNetwork(AFh1jSDK aFh1jSDK) {
        int i = d + 11;
        AFKeystoreWrapper = i % 128;
        char c = i % 2 != 0 ? ']' : (char) 15;
        getCurrencyIso4217Code(aFh1jSDK);
        if (c == 15) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    final void getCurrencyIso4217Code(AFh1jSDK aFh1jSDK) {
        boolean z;
        long j;
        AFj1qSDK[] aFj1qSDKArr;
        Context context = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).registerClient().getRevenue;
        if ((context == null ? (char) 21 : '?') != 21) {
            String mediationNetwork = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMediationNetwork();
            AppsFlyerRequestListener appsFlyerRequestListener = aFh1jSDK.getMonetizationNetwork;
            if (mediationNetwork == null || mediationNetwork.length() == 0) {
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ", true);
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyer will not track this event.", true);
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(41, "No dev key");
                    return;
                }
                return;
            }
            AFc1oSDK aFc1oSDK = (AFc1oSDK) getRevenue(new Object[]{this, context}, -1595266545, 1595266567, System.identityHashCode(this));
            AppsFlyerProperties.getInstance().saveProperties(aFc1oSDK);
            if (!((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMonetizationNetwork()) {
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, new StringBuilder("sendWithEvent from activity: ").append(context.getClass().getName()).toString(), true);
            }
            boolean mediationNetwork2 = aFh1jSDK.getMediationNetwork();
            Map<String, ?> revenue = getRevenue(aFh1jSDK);
            if ((((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMonetizationNetwork() ? '#' : 'I') == '#') {
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyerLib.sendWithEvent");
                int i = d + 109;
                AFKeystoreWrapper = i % 128;
                int i2 = i % 2;
            }
            int monetizationNetwork = getMonetizationNetwork(aFc1oSDK, false);
            getRevenue(new Object[]{this, revenue}, 1290570600, -1290570599, System.identityHashCode(this));
            AFa1tSDK aFa1tSDK = new AFa1tSDK(getCurrencyIso4217Code(), aFh1jSDK.getMonetizationNetwork(revenue).getMonetizationNetwork(monetizationNetwork), getCurrencyIso4217Code().unregisterClient().getCurrencyIso4217Code());
            if (!(!mediationNetwork2)) {
                z = false;
                for (AFj1qSDK aFj1qSDK : (AFj1qSDK[]) getRevenue(new Object[]{this}, -187960988, 187961006, System.identityHashCode(this))) {
                    if (aFj1qSDK.areAllFieldsValid == AFj1qSDK.AFa1vSDK.STARTED) {
                        AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, new StringBuilder("Failed to get ").append(aFj1qSDK.getCurrencyIso4217Code).append(" referrer, wait ...").toString());
                        z = true;
                    }
                }
                if (((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).unregisterClient().getRevenue()) {
                    AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "fetching Facebook deferred AppLink data, wait ...");
                    z = true;
                }
                if (((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().AFAdRevenueData()) {
                    int i3 = d + 15;
                    AFKeystoreWrapper = i3 % 128;
                    int i4 = i3 % 2;
                    z = true;
                }
            } else {
                z = false;
            }
            ScheduledExecutorService monetizationNetwork2 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).getMonetizationNetwork();
            if ((z ? '.' : '7') != '7') {
                int i5 = AFKeystoreWrapper + 99;
                d = i5 % 128;
                if (i5 % 2 == 0) {
                    int i6 = 29 / 0;
                }
                j = 500;
            } else {
                j = 0;
            }
            AFj1aSDK.AFAdRevenueData(monetizationNetwork2, aFa1tSDK, j, TimeUnit.MILLISECONDS);
            return;
        }
        int i7 = d + 71;
        AFKeystoreWrapper = i7 % 128;
        if (i7 % 2 == 0) {
            AFLogger.INSTANCE.d(AFg1cSDK.ATTRIBUTION, "sendWithEvent - got null context. skipping event/launch.", true);
        } else {
            AFLogger.INSTANCE.d(AFg1cSDK.ATTRIBUTION, "sendWithEvent - got null context. skipping event/launch.", true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if ((com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) != true) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:
        if ((!com.appsflyer.internal.AFk1xSDK.getRevenue(((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r1}, 389316487, -389316474, java.lang.System.identityHashCode(r1))).afInfoLog().AFAdRevenueData)) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
        if (com.appsflyer.internal.AFk1xSDK.getRevenue(((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r1}, 389316487, -389316474, java.lang.System.identityHashCode(r1))).afInfoLog().AFAdRevenueData) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
        if (r8.remove("android_id") == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ad, code lost:
        com.appsflyer.AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cc, code lost:
        if (com.appsflyer.internal.AFk1xSDK.getRevenue(((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r1}, 389316487, -389316474, java.lang.System.identityHashCode(r1))).AFKeystoreWrapper().getCurrencyIso4217Code()) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ce, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cf, code lost:
        if (r0 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
        if (r8.remove(com.singular.sdk.internal.Constants.DeviceIdentifierKeyspaceKeys.IMEI_KEYSPACE_KEY) == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d9, code lost:
        com.appsflyer.AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00de, code lost:
        r8 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper + 55;
        com.appsflyer.internal.AFa1uSDK.d = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e8, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
        if ((!com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, true) ? 11 : 19) != 11) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ java.lang.Object getCurrencyIso4217Code(java.lang.Object[] r8) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.getCurrencyIso4217Code(java.lang.Object[]):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, Object> getRevenue(AFh1jSDK aFh1jSDK) {
        int i;
        boolean z = false;
        Context context = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).registerClient().getRevenue;
        AFc1oSDK aFc1oSDK = (AFc1oSDK) getRevenue(new Object[]{this, context}, -1595266545, 1595266567, System.identityHashCode(this));
        AFg1rSDK component4 = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).component4();
        boolean monetizationNetwork = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMonetizationNetwork();
        boolean mediationNetwork = aFh1jSDK.getMediationNetwork();
        Map<String, Object> map = aFh1jSDK.getCurrencyIso4217Code;
        long time = new Date().getTime();
        Object[] objArr = new Object[1];
        a(null, "\u0089\u0086\u0081\u0084\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", null, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 128, objArr);
        map.put(((String) objArr[0]).intern(), Long.toString(time));
        try {
            if ((monetizationNetwork ? ' ' : '@') == ' ') {
                int i2 = AFKeystoreWrapper + 29;
                d = i2 % 128;
                int i3 = i2 % 2;
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyer SDK Reporting has been stopped", true);
                i = AFKeystoreWrapper + 123;
            } else {
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, new StringBuilder("******* sendTrackingWithEvent: ").append(mediationNetwork ? "Launch" : aFh1jSDK.component4).toString(), true);
                i = AFKeystoreWrapper + 57;
            }
            d = i % 128;
            int i4 = i % 2;
            component2(context);
            int monetizationNetwork2 = getMonetizationNetwork(aFc1oSDK, mediationNetwork);
            int mediationNetwork2 = getMediationNetwork(aFc1oSDK, aFh1jSDK.component4 != null);
            if (!mediationNetwork) {
                z = true;
            }
            if (!z && monetizationNetwork2 == 1) {
                AppsFlyerProperties.getInstance().getRevenue = true;
            }
            component4.getCurrencyIso4217Code(map, monetizationNetwork2, mediationNetwork2);
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Error while preparing to send event", th, true, true, true);
        }
        int i5 = AFKeystoreWrapper + 115;
        d = i5 % 128;
        int i6 = i5 % 2;
        return map;
    }

    private static void component2(Context context) {
        try {
            List asList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
            if (!(asList.contains("android.permission.INTERNET"))) {
                int i = AFKeystoreWrapper + 73;
                d = i % 128;
                int i2 = i % 2;
                AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
            }
            if (!(asList.contains("android.permission.ACCESS_NETWORK_STATE"))) {
                int i3 = d + 95;
                AFKeystoreWrapper = i3 % 128;
                int i4 = i3 % 2;
                AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
            }
            if (Build.VERSION.SDK_INT > 32) {
                if (!(asList.contains("com.google.android.gms.permission.AD_ID") ? false : true)) {
                    return;
                }
                AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Permission com.google.android.gms.permission.AD_ID is missing in the AndroidManifest.xml");
                int i5 = AFKeystoreWrapper + 33;
                d = i5 % 128;
                int i6 = i5 % 2;
            }
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception while validation permissions. ", e);
        }
    }

    @Deprecated
    public static Map<String, Object> getMonetizationNetwork(Map<String, Object> map) {
        Map<String, Object> map2;
        int i = d + 27;
        AFKeystoreWrapper = i % 128;
        int i2 = i % 2;
        if (!(map.containsKey("meta"))) {
            HashMap hashMap = new HashMap();
            map.put("meta", hashMap);
            map2 = hashMap;
        } else {
            int i3 = AFKeystoreWrapper + 109;
            d = i3 % 128;
            int i4 = i3 % 2;
            map2 = (Map) map.get("meta");
        }
        int i5 = AFKeystoreWrapper + 7;
        d = i5 % 128;
        if ((i5 % 2 == 0 ? (char) 30 : (char) 28) != 30) {
            return map2;
        }
        int i6 = 71 / 0;
        return map2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r2 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getCurrencyIso4217Code(android.app.Activity r8) {
        /*
            r0 = 55
            if (r8 == 0) goto L7
            r1 = 46
            goto L8
        L7:
            r1 = r0
        L8:
            r2 = 0
            if (r1 == r0) goto L92
            android.content.Intent r0 = r8.getIntent()
            r1 = 63
            if (r0 == 0) goto L16
            r3 = 87
            goto L17
        L16:
            r3 = r1
        L17:
            if (r3 == r1) goto L92
            int r1 = com.appsflyer.internal.AFa1uSDK.d
            int r1 = r1 + 123
            int r3 = r1 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r3
            int r1 = r1 % 2
            android.os.Bundle r1 = r0.getExtras()     // Catch: java.lang.Throwable -> L86
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L2d
            r5 = r3
            goto L2e
        L2d:
            r5 = r4
        L2e:
            if (r5 == r4) goto L92
            int r4 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r4 = r4 + 125
            int r5 = r4 % 128
            com.appsflyer.internal.AFa1uSDK.d = r5
            int r4 = r4 % 2
            r5 = 8
            if (r4 != 0) goto L40
            r4 = r5
            goto L42
        L40:
            r4 = 95
        L42:
            java.lang.String r6 = "af"
            if (r4 == r5) goto L4d
            java.lang.String r2 = r1.getString(r6)     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L92
            goto L56
        L4d:
            java.lang.String r2 = r1.getString(r6)     // Catch: java.lang.Throwable -> L86
            r4 = 53
            int r4 = r4 / r3
            if (r2 == 0) goto L92
        L56:
            int r3 = com.appsflyer.internal.AFa1uSDK.d
            int r3 = r3 + 11
            int r4 = r3 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r4
            int r3 = r3 % 2
            com.appsflyer.AFLogger r3 = com.appsflyer.AFLogger.INSTANCE     // Catch: java.lang.Throwable -> L86
            com.appsflyer.internal.AFg1cSDK r4 = com.appsflyer.internal.AFg1cSDK.ENGAGEMENT     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = "Push Notification received af payload = "
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = r5.concat(r7)     // Catch: java.lang.Throwable -> L86
            r3.w(r4, r5)     // Catch: java.lang.Throwable -> L86
            r1.remove(r6)     // Catch: java.lang.Throwable -> L86
            android.content.Intent r0 = r0.putExtras(r1)     // Catch: java.lang.Throwable -> L86
            r8.setIntent(r0)     // Catch: java.lang.Throwable -> L86
            int r8 = com.appsflyer.internal.AFa1uSDK.d
            int r8 = r8 + 69
            int r0 = r8 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r0
            int r8 = r8 % 2
            goto L92
        L86:
            r8 = move-exception
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.ENGAGEMENT
            java.lang.String r3 = r8.getMessage()
            r0.e(r1, r3, r8)
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.getCurrencyIso4217Code(android.app.Activity):java.lang.String");
    }

    public static boolean getRevenue(Context context) {
        try {
            if ((GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0 ? '1' : '\b') == '1') {
                int i = AFKeystoreWrapper + 71;
                d = i % 128;
                if (i % 2 != 0) {
                    return true;
                }
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            int i2 = d + 107;
            AFKeystoreWrapper = i2 % 128;
            if ((i2 % 2 != 0 ? '_' : 'W') != '_') {
                return true;
            }
            int i3 = 15 / 0;
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "WARNING:  Google Play Services is unavailable. ", e);
            return false;
        }
    }

    private String getCurrencyIso4217Code(Context context, String str) {
        int i = AFKeystoreWrapper + 117;
        d = i % 128;
        int i2 = i % 2;
        if ((context == null ? Typography.dollar : 'O') != 'O') {
            return null;
        }
        getMediationNetwork(context);
        String monetizationNetwork = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).getCurrencyIso4217Code().getMonetizationNetwork(str);
        int i3 = AFKeystoreWrapper + 33;
        d = i3 % 128;
        int i4 = i3 % 2;
        return monetizationNetwork;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        try {
            if ((str != null ? (char) 3 : 'I') != 'I') {
                int i = d + 73;
                AFKeystoreWrapper = i % 128;
                if ((i % 2 != 0 ? '_' : 'D') != 'D') {
                    jSONObject.put("pid", str);
                    int i2 = 48 / 0;
                } else {
                    jSONObject.put("pid", str);
                }
            }
            if (str2 != null) {
                jSONObject.put("c", str2);
                int i3 = d + 69;
                AFKeystoreWrapper = i3 % 128;
                int i4 = i3 % 2;
            }
            if (str3 != null) {
                jSONObject.put("af_siteid", str3);
            }
        } catch (JSONException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
        }
        if (jSONObject.has("pid")) {
            int i5 = d + 77;
            AFKeystoreWrapper = i5 % 128;
            int i6 = i5 % 2;
            getCurrencyIso4217Code("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        String str = (String) objArr[0];
        try {
            if ((new JSONObject(str).has("pid") ? (char) 24 : ']') == ']') {
                AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                int i = AFKeystoreWrapper + 113;
                d = i % 128;
                int i2 = i % 2;
                return null;
            }
            int i3 = AFKeystoreWrapper + 45;
            d = i3 % 128;
            if (!(i3 % 2 != 0)) {
                getCurrencyIso4217Code("preInstallName", str);
                throw null;
            }
            getCurrencyIso4217Code("preInstallName", str);
            int i4 = d + 43;
            AFKeystoreWrapper = i4 % 128;
            int i5 = i4 % 2;
            return null;
        } catch (JSONException e) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e);
            return null;
        }
    }

    final void component4() {
        int i = AFKeystoreWrapper + 9;
        d = i % 128;
        int i2 = i % 2;
        if (!AFe1dSDK.component2()) {
            AFc1bSDK aFc1bSDK = (AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
            AFe1nSDK copydefault = aFc1bSDK.copydefault();
            copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(new AFe1dSDK(aFc1bSDK)));
            return;
        }
        int i3 = AFKeystoreWrapper + 45;
        d = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        int i4 = 68 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final boolean isPreInstalledApp(Context context) {
        int i = AFKeystoreWrapper + 35;
        d = i % 128;
        int i2 = i % 2;
        getMediationNetwork(context);
        boolean mediationNetwork = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).getCurrencyIso4217Code().getMediationNetwork(context);
        int i3 = AFKeystoreWrapper + 15;
        d = i3 % 128;
        int i4 = i3 % 2;
        return mediationNetwork;
    }

    public static String getCurrencyIso4217Code(AFc1oSDK aFc1oSDK, String str) {
        Object obj = null;
        String monetizationNetwork = aFc1oSDK.getMonetizationNetwork("CACHED_CHANNEL", null);
        if (monetizationNetwork == null) {
            aFc1oSDK.AFAdRevenueData("CACHED_CHANNEL", str);
            int i = d + 77;
            AFKeystoreWrapper = i % 128;
            if ((i % 2 == 0 ? (char) 22 : 'M') == 22) {
                return str;
            }
            throw null;
        }
        int i2 = d;
        int i3 = i2 + 99;
        AFKeystoreWrapper = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 30 : (char) 24) == 30) {
            int i4 = 83 / 0;
        }
        int i5 = i2 + 111;
        AFKeystoreWrapper = i5 % 128;
        if ((i5 % 2 == 0 ? 'P' : 'S') == 'P') {
            return monetizationNetwork;
        }
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAttributionId(Context context) {
        int i = d + 21;
        AFKeystoreWrapper = i % 128;
        if (!(i % 2 != 0)) {
            getMediationNetwork(context);
            return ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).getCurrencyIso4217Code().getRevenue(context);
        }
        getMediationNetwork(context);
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).getCurrencyIso4217Code().getRevenue(context);
        throw null;
    }

    public static SharedPreferences d_(Context context) {
        int i = AFKeystoreWrapper + 43;
        d = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? '\n' : '%') == '\n') {
            SharedPreferences sharedPreferences = getMonetizationNetwork().copy;
            throw null;
        }
        if (getMonetizationNetwork().copy == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                getMonetizationNetwork().copy = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        SharedPreferences sharedPreferences2 = getMonetizationNetwork().copy;
        int i2 = AFKeystoreWrapper + 21;
        d = i2 % 128;
        if (i2 % 2 != 0) {
            return sharedPreferences2;
        }
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object copydefault(Object[] objArr) {
        AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        Context context = (Context) objArr[1];
        int i = AFKeystoreWrapper + 51;
        d = i % 128;
        if ((i % 2 == 0 ? '\t' : '$') == '$') {
            aFa1uSDK.getMediationNetwork(context);
            AFc1oSDK component2 = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).component2();
            int i2 = AFKeystoreWrapper + 47;
            d = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 23 : '@') != 23) {
                return component2;
            }
            int i3 = 57 / 0;
            return component2;
        }
        aFa1uSDK.getMediationNetwork(context);
        ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).component2();
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public static int getMonetizationNetwork(AFc1oSDK aFc1oSDK, boolean z) {
        int i = d + 95;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? 'E' : '4') == 'E') {
            AFAdRevenueData(aFc1oSDK, "appsFlyerCount", z);
            throw null;
        }
        int AFAdRevenueData2 = AFAdRevenueData(aFc1oSDK, "appsFlyerCount", z);
        int i2 = d + 97;
        AFKeystoreWrapper = i2 % 128;
        int i3 = i2 % 2;
        return AFAdRevenueData2;
    }

    private static int getMediationNetwork(AFc1oSDK aFc1oSDK, boolean z) {
        int i = AFKeystoreWrapper + 15;
        d = i % 128;
        if (i % 2 != 0) {
            return AFAdRevenueData(aFc1oSDK, "appsFlyerInAppEventCount", z);
        }
        AFAdRevenueData(aFc1oSDK, "appsFlyerInAppEventCount", z);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        if ((r6) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if ((r6 ? 'S' : 'T') != 'S') goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        r0 = r0 + 1;
        r4.getRevenue(r5, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int AFAdRevenueData(com.appsflyer.internal.AFc1oSDK r4, java.lang.String r5, boolean r6) {
        /*
            int r0 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r0 = r0 + 33
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.d = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            if (r0 == r2) goto L1f
            int r0 = r4.getMediationNetwork(r5, r1)
            if (r6 == 0) goto L1b
            r6 = r2
            goto L1c
        L1b:
            r6 = r1
        L1c:
            if (r6 == 0) goto L32
            goto L2e
        L1f:
            int r0 = r4.getMediationNetwork(r5, r2)
            r3 = 83
            if (r6 == 0) goto L29
            r6 = r3
            goto L2b
        L29:
            r6 = 84
        L2b:
            if (r6 == r3) goto L2e
            goto L32
        L2e:
            int r0 = r0 + r2
            r4.getRevenue(r5, r0)
        L32:
            int r4 = com.appsflyer.internal.AFa1uSDK.d
            int r4 = r4 + 99
            int r5 = r4 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L40
            r4 = r1
            goto L41
        L40:
            r4 = r2
        L41:
            if (r4 == r2) goto L49
            r4 = 63
            int r4 = r4 / r1
            return r0
        L47:
            r4 = move-exception
            throw r4
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.AFAdRevenueData(com.appsflyer.internal.AFc1oSDK, java.lang.String, boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
        if ((r8 == null ? ':' : '\t') != ':') goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
        getMediationNetwork(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
        return com.appsflyer.internal.AFb1jSDK.getRevenue(((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r7}, 389316487, -389316474, java.lang.System.identityHashCode(r7))).getCurrencyIso4217Code().getMonetizationNetwork);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        r8 = com.appsflyer.internal.AFa1uSDK.d + 115;
        com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r8 == null) goto L11;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getAppsFlyerUID(android.content.Context r8) {
        /*
            r7 = this;
            int r0 = com.appsflyer.internal.AFa1uSDK.d
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            java.lang.String r3 = "getAppsFlyerUID"
            r4 = -389316474(0xffffffffe8cb8086, float:-7.68809E24)
            r5 = 389316487(0x17347f87, float:5.83221E-25)
            if (r0 == r1) goto L35
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r0[r2] = r7
            int r6 = java.lang.System.identityHashCode(r7)
            java.lang.Object r0 = getRevenue(r0, r5, r4, r6)
            com.appsflyer.internal.AFc1bSDK r0 = (com.appsflyer.internal.AFc1bSDK) r0
            com.appsflyer.internal.AFd1mSDK r0 = r0.equals()
            java.lang.String[] r6 = new java.lang.String[r2]
            r0.getCurrencyIso4217Code(r3, r6)
            if (r8 != 0) goto L56
            goto L72
        L35:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r0[r2] = r7
            int r6 = java.lang.System.identityHashCode(r7)
            java.lang.Object r0 = getRevenue(r0, r5, r4, r6)
            com.appsflyer.internal.AFc1bSDK r0 = (com.appsflyer.internal.AFc1bSDK) r0
            com.appsflyer.internal.AFd1mSDK r0 = r0.equals()
            java.lang.String[] r6 = new java.lang.String[r2]
            r0.getCurrencyIso4217Code(r3, r6)
            r0 = 58
            if (r8 != 0) goto L52
            r3 = r0
            goto L54
        L52:
            r3 = 9
        L54:
            if (r3 == r0) goto L72
        L56:
            r7.getMediationNetwork(r8)
            java.lang.Object[] r8 = new java.lang.Object[r1]
            r8[r2] = r7
            int r0 = java.lang.System.identityHashCode(r7)
            java.lang.Object r8 = getRevenue(r8, r5, r4, r0)
            com.appsflyer.internal.AFc1bSDK r8 = (com.appsflyer.internal.AFc1bSDK) r8
            com.appsflyer.internal.AFc1pSDK r8 = r8.getCurrencyIso4217Code()
            com.appsflyer.internal.AFc1oSDK r8 = r8.getMonetizationNetwork
            java.lang.String r8 = com.appsflyer.internal.AFb1jSDK.getRevenue(r8)
            return r8
        L72:
            int r8 = com.appsflyer.internal.AFa1uSDK.d
            int r8 = r8 + 115
            int r0 = r8 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r0
            int r8 = r8 % 2
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.getAppsFlyerUID(android.content.Context):java.lang.String");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        AFd1mSDK equals = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str3;
        strArr[3] = str4;
        strArr[4] = str5;
        strArr[5] = map == null ? "" : map.toString();
        equals.getCurrencyIso4217Code("validateAndTrackInAppPurchase", strArr);
        if (!((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFKeystoreWrapper().getMonetizationNetwork()) {
            AFLogger.INSTANCE.i(AFg1cSDK.PURCHASE_VALIDATION, new StringBuilder("Validate in app called with parameters: ").append(str3).append(" ").append(str4).append(" ").append(str5).toString());
        }
        if (str != null && str4 != null) {
            int i = AFKeystoreWrapper;
            int i2 = i + 55;
            d = i2 % 128;
            int i3 = i2 % 2;
            if (str2 != null) {
                int i4 = i + 105;
                int i5 = i4 % 128;
                d = i5;
                if ((i4 % 2 == 0 ? (char) 0 : 'A') == 0) {
                    throw null;
                } else if (str5 != null) {
                    int i6 = i5 + 35;
                    AFKeystoreWrapper = i6 % 128;
                    int i7 = i6 % 2;
                    if (str3 != null) {
                        new Thread(new AFa1vSDK(context.getApplicationContext(), getCurrencyIso4217Code().AFKeystoreWrapper().getMediationNetwork(), str, str2, str3, str4, str5, map)).start();
                        return;
                    }
                }
            }
        }
        AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = getCurrencyIso4217Code;
        if (!(appsFlyerInAppPurchaseValidatorListener != null)) {
            return;
        }
        appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
    }

    private static /* synthetic */ Object toString(Object[] objArr) {
        boolean monetizationNetwork;
        AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        int i = AFKeystoreWrapper + 99;
        d = i % 128;
        if (!(i % 2 != 0)) {
            monetizationNetwork = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).AFKeystoreWrapper().getMonetizationNetwork();
            int i2 = 64 / 0;
        } else {
            monetizationNetwork = ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).AFKeystoreWrapper().getMonetizationNetwork();
        }
        int i3 = AFKeystoreWrapper + 107;
        d = i3 % 128;
        if ((i3 % 2 == 0 ? '\f' : '*') == '*') {
            return Boolean.valueOf(monetizationNetwork);
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setLogLevel(AFLogger.LogLevel logLevel) {
        boolean z;
        if (logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()) {
            int i = d + 125;
            AFKeystoreWrapper = i % 128;
            int i2 = i % 2;
            z = true;
        } else {
            int i3 = d + 43;
            AFKeystoreWrapper = i3 % 128;
            int i4 = i3 % 2;
            z = false;
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals().getCurrencyIso4217Code("log", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
        if (!z) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afErrorLog().getRevenue();
            int i5 = AFKeystoreWrapper + 11;
            d = i5 % 128;
            if ((i5 % 2 == 0 ? 'B' : ',') == ',') {
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afErrorLog().areAllFieldsValid();
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setHost(String str, String str2) {
        String str3;
        if (AFk1xSDK.getMonetizationNetwork(str2)) {
            AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
            return;
        }
        int i = d;
        int i2 = i + 5;
        AFKeystoreWrapper = i2 % 128;
        int i3 = i2 % 2;
        if ((str != null ? '_' : 'Y') != 'Y') {
            int i4 = i + 67;
            AFKeystoreWrapper = i4 % 128;
            int i5 = i4 % 2;
            str3 = str.trim();
        } else {
            str3 = "";
        }
        AFe1ySDK.getMediationNetwork(new AFe1wSDK(str3, str2.trim()));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostName() {
        int i = d + 59;
        AFKeystoreWrapper = i % 128;
        if (i % 2 != 0) {
            ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFInAppEventParameterName().getCurrencyIso4217Code();
            throw null;
        }
        return ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).AFInAppEventParameterName().getCurrencyIso4217Code();
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        int i = d + 11;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? '=' : '2') != '2') {
            int i2 = 26 / 0;
            return ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).AFInAppEventParameterName().getMonetizationNetwork();
        }
        return ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).AFInAppEventParameterName().getMonetizationNetwork();
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFa1uSDK aFa1uSDK = (AFa1uSDK) objArr[0];
        PluginInfo pluginInfo = (PluginInfo) objArr[1];
        int i = AFKeystoreWrapper + 79;
        d = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            Objects.requireNonNull(pluginInfo);
            ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).e().getMediationNetwork(pluginInfo);
            return null;
        }
        Objects.requireNonNull(pluginInfo);
        ((AFc1bSDK) getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).e().getMediationNetwork(pluginInfo);
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setConsentData(AppsFlyerConsent appsFlyerConsent) {
        int i = AFKeystoreWrapper + 117;
        d = i % 128;
        int i2 = i % 2;
        Objects.requireNonNull(appsFlyerConsent);
        ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).afInfoLog().areAllFieldsValid = appsFlyerConsent;
        int i3 = AFKeystoreWrapper + 63;
        d = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void validateAndLogInAppPurchase(AFPurchaseDetails aFPurchaseDetails, Map<String, String> map, AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback) {
        AFe1nSDK copydefault = this.hashCode.copydefault();
        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(new AFf1zSDK(this.hashCode, AppsFlyerProperties.getInstance(), aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback)));
        int i = d + 119;
        AFKeystoreWrapper = i % 128;
        if ((i % 2 != 0 ? (char) 11 : '-') == '-') {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static void getMediationNetwork(String str) {
        AFLogger.INSTANCE.w(AFg1cSDK.SDK_LIFECYCLE, new StringBuilder("ERROR: AppsFlyer SDK is not initialized! The API call '").append(str).append("()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.").toString());
        int i = AFKeystoreWrapper + 3;
        d = i % 128;
        if (i % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static void copydefault() {
        int i = d + 121;
        AFKeystoreWrapper = i % 128;
        if (!(i % 2 != 0 ? true : false)) {
            AFLogger.INSTANCE.w(AFg1cSDK.SDK_LIFECYCLE, "ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
        } else {
            AFLogger.INSTANCE.w(AFg1cSDK.SDK_LIFECYCLE, "ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        if ((!r7.toString ? '\\' : '<') != '<') goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        if ((!r7.toString ? 7 : 6) != 7) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
        if (((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r7}, 389316487, -389316474, java.lang.System.identityHashCode(r7))).getCurrencyIso4217Code().getRevenue("APPSFLYER_ALLOW_CUSTOM_INSTALL_ID") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
        com.appsflyer.AFLogger.INSTANCE.d(com.appsflyer.internal.AFg1cSDK.GENERAL, "APPSFLYER_ALLOW_CUSTOM_INSTALL_ID Manifest flag should be set to true first");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0087, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
        if (r8 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (r0 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008f, code lost:
        r8 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper + 83;
        com.appsflyer.internal.AFa1uSDK.d = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
        if ((r8 % 2) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009d, code lost:
        com.appsflyer.AFLogger.INSTANCE.d(com.appsflyer.internal.AFg1cSDK.GENERAL, "AppsFlyer installId can't be null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
        com.appsflyer.AFLogger.INSTANCE.d(com.appsflyer.internal.AFg1cSDK.GENERAL, "AppsFlyer installId can't be null");
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r8.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
        com.appsflyer.internal.AFb1jSDK.getCurrencyIso4217Code(r8, ((com.appsflyer.internal.AFc1bSDK) getRevenue(new java.lang.Object[]{r7}, 389316487, -389316474, java.lang.System.identityHashCode(r7))).component2());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c8, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c9, code lost:
        com.appsflyer.AFLogger.INSTANCE.d(com.appsflyer.internal.AFg1cSDK.GENERAL, "AppsFlyerLib.init() method should be called first");
        r8 = com.appsflyer.internal.AFa1uSDK.d + 57;
        com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
        if ((r8 % 2) == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e0, code lost:
        r8 = 52 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e4, code lost:
        return;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setInstallId(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.setInstallId(java.lang.String):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void disableAppSetId() {
        int i = AFKeystoreWrapper + 11;
        d = i % 128;
        ((AFc1bSDK) (i % 2 == 0 ? getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this)) : getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this)))).afInfoLog().component1 = true;
        int i2 = AFKeystoreWrapper + 33;
        d = i2 % 128;
        if ((i2 % 2 == 0 ? '9' : '7') == '7') {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.appsflyer.internal.AFa1uSDK$AFa1uSDK  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0006AFa1uSDK implements AFe1sSDK {
        @Override // com.appsflyer.internal.AFe1sSDK
        public final void getMediationNetwork(AFe1lSDK<?> aFe1lSDK) {
        }

        C0006AFa1uSDK() {
        }

        @Override // com.appsflyer.internal.AFe1sSDK
        public final void getMonetizationNetwork(AFe1lSDK<?> aFe1lSDK, AFe1uSDK aFe1uSDK) {
            JSONObject AFAdRevenueData;
            AFf1aSDK revenue;
            if (aFe1lSDK instanceof AFf1uSDK) {
                AFf1uSDK aFf1uSDK = (AFf1uSDK) aFe1lSDK;
                boolean z = aFe1lSDK instanceof AFf1rSDK;
                if (z && getMediationNetwork()) {
                    AFf1rSDK aFf1rSDK = (AFf1rSDK) aFe1lSDK;
                    if (aFf1rSDK.AFAdRevenueData == AFe1uSDK.SUCCESS || aFf1rSDK.getMonetizationNetwork == 1) {
                        AFg1iSDK aFg1iSDK = new AFg1iSDK(aFf1rSDK, AFa1uSDK.this.getCurrencyIso4217Code().component2());
                        AFa1uSDK aFa1uSDK = AFa1uSDK.this;
                        AFe1nSDK copydefault = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK}, 389316487, -389316474, System.identityHashCode(aFa1uSDK))).copydefault();
                        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFg1iSDK));
                    }
                }
                AFa1uSDK aFa1uSDK2 = AFa1uSDK.this;
                AFh1qSDK afLogForce = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK2}, 389316487, -389316474, System.identityHashCode(aFa1uSDK2))).afLogForce();
                if (afLogForce != null && z) {
                    afLogForce.getMonetizationNetwork((AFf1rSDK) aFe1lSDK, new Function0() { // from class: com.appsflyer.internal.AFa1uSDK$AFa1uSDK$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit monetizationNetwork;
                            monetizationNetwork = AFa1uSDK.C0006AFa1uSDK.this.getMonetizationNetwork();
                            return monetizationNetwork;
                        }
                    });
                }
                if (aFe1uSDK == AFe1uSDK.SUCCESS) {
                    AFa1uSDK aFa1uSDK3 = AFa1uSDK.this;
                    ((AFc1oSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK3, aFa1uSDK3.component3}, -1595266545, 1595266567, System.identityHashCode(aFa1uSDK3))).AFAdRevenueData("sentSuccessfully", "true");
                    if (!(aFe1lSDK instanceof AFf1pSDK) && (revenue = new AFg1tSDK(AFa1uSDK.this.component3).getRevenue()) != null && revenue.getMediationNetwork) {
                        String str = revenue.getMonetizationNetwork;
                        AFLogger.INSTANCE.d(AFg1cSDK.UNINSTALL, "Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                        AFa1uSDK monetizationNetwork = AFa1uSDK.getMonetizationNetwork();
                        AFc1bSDK aFc1bSDK = (AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork}, 389316487, -389316474, System.identityHashCode(monetizationNetwork));
                        AFf1pSDK aFf1pSDK = new AFf1pSDK(str, aFc1bSDK);
                        AFe1nSDK copydefault2 = aFc1bSDK.copydefault();
                        copydefault2.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFf1pSDK));
                    }
                    ResponseNetwork responseNetwork = ((AFe1eSDK) aFf1uSDK).component3;
                    if (responseNetwork != null && (AFAdRevenueData = AFa1oSDK.AFAdRevenueData((String) responseNetwork.getBody())) != null) {
                        AFa1uSDK.this.component1 = AFAdRevenueData.optBoolean("send_background", false);
                    }
                    if (z) {
                        AFa1uSDK.this.getMonetizationNetwork = System.currentTimeMillis();
                    }
                }
            } else if (!(aFe1lSDK instanceof AFg1iSDK) || aFe1uSDK == AFe1uSDK.SUCCESS) {
            } else {
                AFg1nSDK aFg1nSDK = new AFg1nSDK(AFa1uSDK.this.getCurrencyIso4217Code());
                AFa1uSDK aFa1uSDK4 = AFa1uSDK.this;
                AFe1nSDK copydefault3 = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{aFa1uSDK4}, 389316487, -389316474, System.identityHashCode(aFa1uSDK4))).copydefault();
                copydefault3.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFg1nSDK));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit getMonetizationNetwork() {
            AFa1uSDK.this.getCurrencyIso4217Code(new AFh1kSDK());
            return Unit.INSTANCE;
        }

        private boolean getMediationNetwork() {
            return AFa1uSDK.this.getMediationNetwork != null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap hashMap = map == null ? null : new HashMap(map);
        getMediationNetwork(context);
        AFh1hSDK aFh1hSDK = new AFh1hSDK();
        aFh1hSDK.component4 = str;
        aFh1hSDK.getMonetizationNetwork = appsFlyerRequestListener;
        if (hashMap != null && hashMap.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap hashMap3 = new HashMap();
                hashMap3.put("x", Float.valueOf(motionEvent.getX()));
                hashMap3.put("y", Float.valueOf(motionEvent.getY()));
                hashMap2.put("loc", hashMap3);
                hashMap2.put("pf", Float.valueOf(motionEvent.getPressure()));
                hashMap2.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                hashMap2.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.INSTANCE.w(AFg1cSDK.PREDICT, "Parsing failed due to invalid input in 'af_touch_obj'.", true);
            }
            Map<String, ?> singletonMap = Collections.singletonMap("tch_data", hashMap2);
            hashMap.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFh1hSDK.getMonetizationNetwork(singletonMap);
        }
        aFh1hSDK.AFAdRevenueData = hashMap;
        AFd1mSDK equals = ((AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this))).equals();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = new JSONObject(aFh1hSDK.AFAdRevenueData == null ? new HashMap() : aFh1hSDK.AFAdRevenueData).toString();
        equals.getCurrencyIso4217Code("logEvent", strArr);
        if (str == null) {
            getMediationNetwork(context, AFh1xSDK.logEvent);
        }
        getMediationNetwork(aFh1hSDK, AFAdRevenueData(context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
        if ((!areAllFieldsValid()) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
        if (areAllFieldsValid() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        r5 = r5.getMonetizationNetwork;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0067, code lost:
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006a, code lost:
        if (r1 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006c, code lost:
        r0 = com.appsflyer.internal.AFa1uSDK.d + 7;
        com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r0 % 128;
        r0 = r0 % 2;
        r5.onError(10, "Event timeout. Check 'minTimeBetweenSessions' param");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void getMonetizationNetwork(com.appsflyer.internal.AFh1jSDK r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.component4
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L12
            int r0 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r0 = r0 + 25
            int r3 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.d = r3
            int r0 = r0 % 2
            r0 = r2
            goto L13
        L12:
            r0 = r1
        L13:
            boolean r3 = r4.getRevenue()
            if (r3 == 0) goto L34
            int r5 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r5 = r5 + 107
            int r0 = r5 % 128
            com.appsflyer.internal.AFa1uSDK.d = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L27
            r5 = r1
            goto L28
        L27:
            r5 = r2
        L28:
            java.lang.String r0 = "CustomerUserId not set, reporting is disabled"
            if (r5 == r2) goto L30
            com.appsflyer.AFLogger.afInfoLog(r0, r1)
            return
        L30:
            com.appsflyer.AFLogger.afInfoLog(r0, r2)
            return
        L34:
            if (r0 == 0) goto L89
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r3 = "launchProtectEnabled"
            boolean r0 = r0.getBoolean(r3, r2)
            if (r0 == 0) goto L7e
            int r0 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper
            int r0 = r0 + 105
            int r3 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.d = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L5f
            boolean r0 = r4.areAllFieldsValid()
            r3 = 53
            int r3 = r3 / r1
            if (r0 == 0) goto L59
            r0 = r1
            goto L5a
        L59:
            r0 = r2
        L5a:
            if (r0 == 0) goto L65
            goto L83
        L5d:
            r5 = move-exception
            throw r5
        L5f:
            boolean r0 = r4.areAllFieldsValid()
            if (r0 == 0) goto L83
        L65:
            com.appsflyer.attribution.AppsFlyerRequestListener r5 = r5.getMonetizationNetwork
            if (r5 == 0) goto L6a
            r1 = r2
        L6a:
            if (r1 == 0) goto L7d
            int r0 = com.appsflyer.internal.AFa1uSDK.d
            int r0 = r0 + 7
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper = r1
            int r0 = r0 % 2
            r0 = 10
            java.lang.String r1 = "Event timeout. Check 'minTimeBetweenSessions' param"
            r5.onError(r0, r1)
        L7d:
            return
        L7e:
            java.lang.String r0 = "Allowing multiple launches within a 5 second time window."
            com.appsflyer.AFLogger.afInfoLog(r0)
        L83:
            long r0 = java.lang.System.currentTimeMillis()
            r4.component4 = r0
        L89:
            r4.getCurrencyIso4217Code(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1uSDK.getMonetizationNetwork(com.appsflyer.internal.AFh1jSDK):void");
    }

    static void component3() {
        AFInAppEventParameterName = new char[]{35848, 35853, 35850, 35871, 35840, 35844, 35852, 35870, 35867};
        AFInAppEventType = 1912311211;
        registerClient = true;
        AFLogger = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_(Context context, Intent intent) {
        getRevenue(new Object[]{this, context, intent}, 253751881, -253751860, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPluginInfo(PluginInfo pluginInfo) {
        getRevenue(new Object[]{this, pluginInfo}, 1343916491, -1343916486, System.identityHashCode(this));
    }

    private AFj1qSDK[] component1() {
        return (AFj1qSDK[]) getRevenue(new Object[]{this}, -187960988, 187961006, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setMinTimeBetweenSessions(int i) {
        getRevenue(new Object[]{this, Integer.valueOf(i)}, 1308989660, -1308989654, i);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostPrefix() {
        return (String) getRevenue(new Object[]{this}, 103305784, -103305776, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final boolean isStopped() {
        return ((Boolean) getRevenue(new Object[]{this}, 224962975, -224962956, System.identityHashCode(this))).booleanValue();
    }

    public final AFc1oSDK getCurrencyIso4217Code(Context context) {
        return (AFc1oSDK) getRevenue(new Object[]{this, context}, -1595266545, 1595266567, System.identityHashCode(this));
    }

    private static void getMonetizationNetwork(String str) {
        getRevenue(new Object[]{str}, 698517988, -698517984, (int) System.currentTimeMillis());
    }

    private void getRevenue(Map<String, Object> map) {
        getRevenue(new Object[]{this, map}, 1290570600, -1290570599, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void unregisterConversionListener() {
        getRevenue(new Object[]{this}, 1122585742, -1122585731, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(Context context, String str, Map<String, Object> map) {
        getRevenue(new Object[]{this, context, str, map}, -1613836572, 1613836582, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        return (AppsFlyerLib) getRevenue(new Object[]{this, str, appsFlyerConversionListener, context}, 519263238, -519263223, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectAndroidID(boolean z) {
        getRevenue(new Object[]{this, Boolean.valueOf(z)}, 454542992, -454542992, System.identityHashCode(this));
    }

    private static void getRevenue(String str, boolean z) {
        getRevenue(new Object[]{str, Boolean.valueOf(z)}, -222394073, 222394090, (int) System.currentTimeMillis());
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void updateServerUninstallToken(Context context, String str) {
        getRevenue(new Object[]{this, context, str}, 912251885, -912251862, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void enableTCFDataCollection(boolean z) {
        getRevenue(new Object[]{this, Boolean.valueOf(z)}, 163982159, -163982156, System.identityHashCode(this));
    }

    final void b_(Context context, Intent intent) {
        getRevenue(new Object[]{this, context, intent}, -1666869813, 1666869820, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDisableNetworkData(boolean z) {
        getRevenue(new Object[]{this, Boolean.valueOf(z)}, 775079759, -775079747, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void addPushNotificationDeepLinkPath(String... strArr) {
        getRevenue(new Object[]{this, strArr}, -503631880, 503631889, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        getRevenue(new Object[]{this, deepLinkListener}, 1831672072, -1831672058, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendInAppPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        getRevenue(new Object[]{this, context, map, purchaseValidationCallback}, 788315212, -788315188, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setSharingFilterForPartners(String... strArr) {
        getRevenue(new Object[]{this, strArr}, -251208297, 251208317, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilter(String... strArr) {
        getRevenue(new Object[]{this, strArr}, -134062068, 134062070, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void performOnAppAttribution(Context context, URI uri) {
        getRevenue(new Object[]{this, context, uri}, 1798513644, -1798513628, System.identityHashCode(this));
    }

    public final AFc1bSDK getCurrencyIso4217Code() {
        return (AFc1bSDK) getRevenue(new Object[]{this}, 389316487, -389316474, System.identityHashCode(this));
    }
}
