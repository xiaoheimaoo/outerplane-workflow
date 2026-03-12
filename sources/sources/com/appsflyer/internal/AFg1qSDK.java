package com.appsflyer.internal;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AdRevenueScheme;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFg1sSDK;
import com.singular.sdk.internal.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFg1qSDK implements AFg1rSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int i = 1;
    private static int w;
    private final AFg1sSDK AFAdRevenueData;
    private final Lazy AFKeystoreWrapper;
    private final AFc1pSDK areAllFieldsValid;
    private final AFc1oSDK component1;
    private final AFg1vSDK component2;
    private final AFh1tSDK component3;
    private final AFi1sSDK component4;
    private final AFf1cSDK copy;
    private final Lazy copydefault;
    private final AFc1gSDK equals;
    private final AFi1lSDK getCurrencyIso4217Code;
    private final Context getMediationNetwork;
    private final AFj1pSDK getMonetizationNetwork;
    private final String getRevenue;
    private final AFg1xSDK hashCode;
    private final AFc1eSDK toString;
    private static char[] AFInAppEventType = {35909, 35928, 35921, 35926, 35927, 35903, 35904, 35924, 35933, 35910, 35931, 35879, 35908, 35905, 35911};
    private static int AFLogger = 1912311267;
    private static boolean AFInAppEventParameterName = true;
    private static boolean registerClient = true;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object getMediationNetwork(java.lang.Object[] r5, int r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.getMediationNetwork(java.lang.Object[], int, int, int):java.lang.Object");
    }

    public AFg1qSDK(String str, Context context, AFi1lSDK aFi1lSDK, AFg1sSDK aFg1sSDK, AFj1pSDK aFj1pSDK, AFg1vSDK aFg1vSDK, AFh1tSDK aFh1tSDK, AFc1oSDK aFc1oSDK, AFc1pSDK aFc1pSDK, AFi1sSDK aFi1sSDK, AFf1cSDK aFf1cSDK, AFc1gSDK aFc1gSDK, AFg1xSDK aFg1xSDK, AFc1eSDK aFc1eSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFi1lSDK, "");
        Intrinsics.checkNotNullParameter(aFg1sSDK, "");
        Intrinsics.checkNotNullParameter(aFj1pSDK, "");
        Intrinsics.checkNotNullParameter(aFg1vSDK, "");
        Intrinsics.checkNotNullParameter(aFh1tSDK, "");
        Intrinsics.checkNotNullParameter(aFc1oSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFi1sSDK, "");
        Intrinsics.checkNotNullParameter(aFf1cSDK, "");
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFg1xSDK, "");
        Intrinsics.checkNotNullParameter(aFc1eSDK, "");
        this.getRevenue = str;
        this.getMediationNetwork = context;
        this.getCurrencyIso4217Code = aFi1lSDK;
        this.AFAdRevenueData = aFg1sSDK;
        this.getMonetizationNetwork = aFj1pSDK;
        this.component2 = aFg1vSDK;
        this.component3 = aFh1tSDK;
        this.component1 = aFc1oSDK;
        this.areAllFieldsValid = aFc1pSDK;
        this.component4 = aFi1sSDK;
        this.copy = aFf1cSDK;
        this.equals = aFc1gSDK;
        this.hashCode = aFg1xSDK;
        this.toString = aFc1eSDK;
        this.copydefault = LazyKt.lazy(new Function0<AppsFlyerProperties>() { // from class: com.appsflyer.internal.AFg1qSDK.5
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getCurrencyIso4217Code */
            public final AppsFlyerProperties invoke() {
                return AppsFlyerProperties.getInstance();
            }
        });
        this.AFKeystoreWrapper = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.appsflyer.internal.AFg1qSDK.3
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFAdRevenueData */
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            }
        });
    }

    private final AppsFlyerProperties getMonetizationNetwork() {
        int i2 = i + 79;
        w = i2 % 128;
        if ((i2 % 2 != 0 ? ')' : 'J') != 'J') {
            int i3 = 88 / 0;
            return (AppsFlyerProperties) this.copydefault.getValue();
        }
        return (AppsFlyerProperties) this.copydefault.getValue();
    }

    private final SimpleDateFormat getMediationNetwork() {
        int i2 = i + 87;
        w = i2 % 128;
        int i3 = i2 % 2;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) this.AFKeystoreWrapper.getValue();
        int i4 = w + 45;
        i = i4 % 128;
        if ((i4 % 2 == 0 ? '\\' : 'N') != '\\') {
            return simpleDateFormat;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getMonetizationNetwork(AFh1jSDK aFh1jSDK) {
        int i2 = i + 21;
        w = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        Map<String, Object> map = aFh1jSDK.getCurrencyIso4217Code;
        if ((aFh1jSDK.getMediationNetwork() ? 'Z' : '-') == 'Z') {
            getCurrencyIso4217Code(aFh1jSDK, aFh1jSDK.areAllFieldsValid, this.toString.getMonetizationNetwork, this.toString.getCurrencyIso4217Code);
        } else if (!(aFh1jSDK instanceof AFh1fSDK)) {
            Intrinsics.checkNotNullExpressionValue(map, "");
            String str = aFh1jSDK.component4;
            Intrinsics.checkNotNullExpressionValue(str, "");
            getMediationNetwork(new Object[]{this, map, str}, 1127076864, -1127076862, System.identityHashCode(this));
        }
        if ((CollectionsKt.listOf((Object[]) new AFe1mSDK[]{AFe1mSDK.CONVERSION, AFe1mSDK.LAUNCH, AFe1mSDK.INAPP}).contains(aFh1jSDK.getCurrencyIso4217Code()) ? 'F' : '9') != '9') {
            Intrinsics.checkNotNullExpressionValue(map, "");
            hashCode(map);
        }
        if ((aFh1jSDK.getMonetizationNetwork() ? '\n' : '1') != '1') {
            int i4 = w + 29;
            i = i4 % 128;
            int i5 = i4 % 2;
            Intrinsics.checkNotNullExpressionValue(map, "");
            component1(map);
            int i6 = w + 81;
            i = i6 % 128;
            int i7 = i6 % 2;
        }
        Intrinsics.checkNotNullExpressionValue(map, "");
        w(map);
        AFKeystoreWrapper(map);
        getMediationNetwork(new Object[]{this, map}, -2015365334, 2015365335, System.identityHashCode(this));
        AFLogger(map);
        getMediationNetwork(map);
        AFAdRevenueData(map, aFh1jSDK.getMediationNetwork());
        e(map);
        d(map);
        AFAdRevenueData(map, aFh1jSDK);
        map.put("af_events_api", "1");
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getMediationNetwork(AFh1jSDK aFh1jSDK) {
        int i2 = i + 55;
        w = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        Map<String, Object> map = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map, "");
        AFAdRevenueData(map);
        Map<String, Object> map2 = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        getCurrencyIso4217Code(map2, aFh1jSDK.component1);
        Map<String, Object> map3 = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map3, "");
        AFAdRevenueData(map3, aFh1jSDK.component1);
        Map<String, Object> map4 = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map4, "");
        registerClient(map4);
        Map<String, Object> map5 = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map5, "");
        afDebugLog(map5);
        Map<String, Object> map6 = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map6, "");
        AFe1mSDK currencyIso4217Code = aFh1jSDK.getCurrencyIso4217Code();
        Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
        getMediationNetwork(new Object[]{this, map6, currencyIso4217Code}, -1926240735, 1926240745, System.identityHashCode(this));
        int i4 = i + 119;
        w = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private final void AFAdRevenueData(Map<String, Object> map) {
        try {
            long longValue = ((Long) getMediationNetwork(new Object[]{this}, -1521351773, 1521351785, System.identityHashCode(this))).longValue();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            map.put("installDate", simpleDateFormat.format(new Date(longValue)));
            int i2 = i + 15;
            w = i2 % 128;
            if ((i2 % 2 != 0 ? '[' : ')') == ')') {
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        } catch (Exception e) {
            AFLogger.afErrorLog("Exception while collecting install date. ", e);
        }
    }

    private final void getCurrencyIso4217Code(Map<String, Object> map, int i2) {
        int i3 = i + 75;
        w = i3 % 128;
        int i4 = i3 % 2;
        try {
            if ((this.areAllFieldsValid.n_().versionCode > this.component1.getMediationNetwork("versionCode", 0) ? 'R' : '=') != '=') {
                int i5 = i + 39;
                w = i5 % 128;
                int i6 = i5 % 2;
                this.component1.getRevenue("versionCode", this.areAllFieldsValid.n_().versionCode);
            }
            map.put("app_version_code", String.valueOf(this.areAllFieldsValid.n_().versionCode));
            map.put("app_version_name", this.areAllFieldsValid.n_().versionName);
            map.put("targetSDKver", Integer.valueOf(this.areAllFieldsValid.getRevenue.getRevenue.getApplicationInfo().targetSdkVersion));
            map.put("date1", getMediationNetwork().format(new Date(((Long) getMediationNetwork(new Object[]{this}, -1521351773, 1521351785, System.identityHashCode(this))).longValue())));
            map.put("date2", getMediationNetwork().format(new Date(this.areAllFieldsValid.n_().lastUpdateTime)));
            Object[] objArr = new Object[1];
            a(null, "\u008d\u0085\u0087\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", null, 126 - TextUtils.lastIndexOf("", '0', 0), objArr);
            String intern = ((String) objArr[0]).intern();
            SimpleDateFormat mediationNetwork = getMediationNetwork();
            Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
            map.put(intern, getCurrencyIso4217Code(mediationNetwork, i2));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting app version data ", th, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v19, types: [char[]] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v13, types: [byte[]] */
    private static void a(String str, String str2, int[] iArr, int i2, Object[] objArr) {
        int i3;
        char[] cArr;
        int i4 = $11 + 111;
        $10 = i4 % 128;
        if (!(i4 % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if ((str2 != 0 ? (char) 7 : 'I') != 'I') {
            str2 = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) str2;
        if (!(str == 0)) {
            str = str.toCharArray();
        }
        char[] cArr2 = (char[]) str;
        AFk1iSDK aFk1iSDK = new AFk1iSDK();
        char[] cArr3 = AFInAppEventType;
        if (cArr3 != null) {
            int i5 = $11 + 115;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = $11 + 53;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                cArr4[i7] = (char) (cArr3[i7] ^ 1825820251896122634L);
            }
            cArr3 = cArr4;
        }
        int i10 = (int) (1825820251896122634L ^ AFLogger);
        if (!registerClient) {
            if (!AFInAppEventParameterName) {
                aFk1iSDK.getCurrencyIso4217Code = iArr.length;
                char[] cArr5 = new char[aFk1iSDK.getCurrencyIso4217Code];
                aFk1iSDK.getMediationNetwork = 0;
                while (aFk1iSDK.getMediationNetwork < aFk1iSDK.getCurrencyIso4217Code) {
                    cArr5[aFk1iSDK.getMediationNetwork] = (char) (cArr3[iArr[(aFk1iSDK.getCurrencyIso4217Code - 1) - aFk1iSDK.getMediationNetwork] - i2] - i10);
                    aFk1iSDK.getMediationNetwork++;
                }
                objArr[0] = new String(cArr5);
                return;
            }
            aFk1iSDK.getCurrencyIso4217Code = cArr2.length;
            char[] cArr6 = new char[aFk1iSDK.getCurrencyIso4217Code];
            aFk1iSDK.getMediationNetwork = 0;
            while (aFk1iSDK.getMediationNetwork < aFk1iSDK.getCurrencyIso4217Code) {
                int i11 = $10 + 77;
                $11 = i11 % 128;
                if (i11 % 2 == 0) {
                    cArr6[aFk1iSDK.getMediationNetwork] = (char) (cArr3[cArr2[(aFk1iSDK.getCurrencyIso4217Code << 1) >>> aFk1iSDK.getMediationNetwork] + i2] >>> i10);
                    i3 = aFk1iSDK.getMediationNetwork % 0;
                } else {
                    cArr6[aFk1iSDK.getMediationNetwork] = (char) (cArr3[cArr2[(aFk1iSDK.getCurrencyIso4217Code - 1) - aFk1iSDK.getMediationNetwork] - i2] - i10);
                    i3 = aFk1iSDK.getMediationNetwork + 1;
                }
                aFk1iSDK.getMediationNetwork = i3;
            }
            objArr[0] = new String(cArr6);
            return;
        }
        int i12 = $11 + 119;
        $10 = i12 % 128;
        if (i12 % 2 != 0) {
            aFk1iSDK.getCurrencyIso4217Code = bArr.length;
            cArr = new char[aFk1iSDK.getCurrencyIso4217Code];
            aFk1iSDK.getMediationNetwork = 1;
        } else {
            aFk1iSDK.getCurrencyIso4217Code = bArr.length;
            cArr = new char[aFk1iSDK.getCurrencyIso4217Code];
            aFk1iSDK.getMediationNetwork = 0;
        }
        while (true) {
            if (aFk1iSDK.getMediationNetwork >= aFk1iSDK.getCurrencyIso4217Code) {
                objArr[0] = new String(cArr);
                return;
            }
            int i13 = $10 + 29;
            $11 = i13 % 128;
            int i14 = i13 % 2;
            cArr[aFk1iSDK.getMediationNetwork] = (char) (cArr3[bArr[(aFk1iSDK.getCurrencyIso4217Code - 1) - aFk1iSDK.getMediationNetwork] + i2] - i10);
            aFk1iSDK.getMediationNetwork++;
        }
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getCurrencyIso4217Code(AFh1jSDK aFh1jSDK) {
        int i2 = w + 1;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        Map<String, Object> map = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map, "");
        getCurrencyIso4217Code(map, aFh1jSDK.getMediationNetwork());
        areAllFieldsValid(map);
        getMediationNetwork(new Object[]{map}, -43428876, 43428885, (int) System.currentTimeMillis());
        getRevenue(map);
        getMediationNetwork(new Object[]{this, map, this.toString.AFAdRevenueData}, -361587280, 361587287, System.identityHashCode(this));
        i(map);
        map.put("cell", MapsKt.mapOf(TuplesKt.to("mcc", Integer.valueOf(this.getMediationNetwork.getResources().getConfiguration().mcc)), TuplesKt.to("mnc", Integer.valueOf(this.getMediationNetwork.getResources().getConfiguration().mnc))));
        map.put("sig", (String) getMediationNetwork(new Object[]{this}, -1875348758, 1875348758, System.identityHashCode(this)));
        map.put("last_boot_time", Long.valueOf(areAllFieldsValid()));
        map.put("disk", (String) getMediationNetwork(new Object[0], -879088668, 879088672, (int) System.currentTimeMillis()));
        int i4 = w + 85;
        i = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getCurrencyIso4217Code(Map<String, Object> map) {
        String[] strArr;
        int i2 = i + 15;
        w = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String string = getMonetizationNetwork().getString(AppsFlyerProperties.APP_ID);
        if ((string != null ? ':' : '6') == ':') {
            int i4 = w + 53;
            i = i4 % 128;
            int i5 = i4 % 2;
            map.put(AppsFlyerProperties.APP_ID, string);
        }
        String string2 = getMonetizationNetwork().getString(AppsFlyerProperties.CURRENCY_CODE);
        if (string2 != null) {
            if (string2.length() != 3) {
                String obj = new StringBuilder("WARNING: currency code should be 3 characters!!! '").append(string2).append("' is not a legal value.").toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                AFLogger.afWarnLog(obj);
                int i6 = i + 87;
                w = i6 % 128;
                int i7 = i6 % 2;
            }
            map.put("currency", string2);
        }
        String string3 = getMonetizationNetwork().getString(AppsFlyerProperties.IS_UPDATE);
        if (string3 != null) {
            map.put("isUpdate", string3);
        }
        String string4 = getMonetizationNetwork().getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
        Object obj2 = null;
        if (string4 != null) {
            int i8 = w + 123;
            i = i8 % 128;
            if (i8 % 2 == 0) {
                map.put("customData", string4);
                throw null;
            }
            map.put("customData", string4);
        }
        String string5 = getMonetizationNetwork().getString(AppsFlyerProperties.APP_USER_ID);
        if (string5 != null) {
            map.put("appUserId", string5);
        }
        String string6 = getMonetizationNetwork().getString(AppsFlyerProperties.USER_EMAILS);
        if (string6 != null) {
            int i9 = w + 39;
            i = i9 % 128;
            int i10 = i9 % 2;
            map.put("user_emails", string6);
        }
        AFb1uSDK aFb1uSDK = this.toString.getRevenue;
        if ((aFb1uSDK != null ? '?' : '7') == '?' && (strArr = aFb1uSDK.getMediationNetwork) != null) {
            int i11 = i + 19;
            w = i11 % 128;
            if (i11 % 2 == 0) {
                map.put("sharing_filter", strArr);
                return;
            }
            map.put("sharing_filter", strArr);
            obj2.hashCode();
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void AFAdRevenueData(AFh1jSDK aFh1jSDK) {
        boolean z;
        AFd1aSDK aFd1aSDK;
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        Object obj = null;
        if (this.areAllFieldsValid.component1()) {
            AFh1pSDK aFh1pSDK = this.areAllFieldsValid.AFAdRevenueData.component2;
            if ((aFh1pSDK == null ? '=' : (char) 18) != 18) {
                int i2 = w + 101;
                i = i2 % 128;
                int i3 = i2 % 2;
                return;
            }
            String str = aFh1pSDK.component1;
            if (!(str == null || str.length() == 0)) {
                aFh1jSDK.getMonetizationNetwork("gaidError", aFh1pSDK.component1);
            }
            if (aFh1pSDK.getRevenue != null) {
                int i4 = w + 121;
                i = i4 % 128;
                int i5 = i4 % 2;
                if (aFh1pSDK.getMediationNetwork != null) {
                    aFh1jSDK.getMonetizationNetwork("advertiserId", aFh1pSDK.getRevenue);
                    aFh1jSDK.getMonetizationNetwork("advertiserIdEnabled", String.valueOf(aFh1pSDK.getMediationNetwork));
                    aFh1jSDK.getMonetizationNetwork("isGaidWithGps", String.valueOf(aFh1pSDK.getCurrencyIso4217Code));
                }
            }
        } else {
            int i6 = i + 37;
            w = i6 % 128;
            if ((i6 % 2 != 0 ? 'H' : 'W') == 'H') {
                Map<String, Object> monetizationNetwork = AFa1uSDK.getMonetizationNetwork(aFh1jSDK.getCurrencyIso4217Code);
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
                monetizationNetwork.put("ad_ids_disabled", Boolean.TRUE);
                obj.hashCode();
                throw null;
            }
            Map<String, Object> monetizationNetwork2 = AFa1uSDK.getMonetizationNetwork(aFh1jSDK.getCurrencyIso4217Code);
            Intrinsics.checkNotNullExpressionValue(monetizationNetwork2, "");
            monetizationNetwork2.put("ad_ids_disabled", Boolean.TRUE);
        }
        AFh1pSDK aFh1pSDK2 = this.areAllFieldsValid.AFAdRevenueData.component2;
        if (aFh1pSDK2 != null) {
            int i7 = w + 45;
            i = i7 % 128;
            int i8 = i7 % 2;
            z = Intrinsics.areEqual(aFh1pSDK2.component2, Boolean.TRUE);
        } else {
            z = false;
        }
        aFh1jSDK.getMonetizationNetwork("GAID_retry", String.valueOf(z));
        if (!CollectionsKt.listOf((Object[]) new AFe1mSDK[]{AFe1mSDK.CONVERSION, AFe1mSDK.LAUNCH}).contains(aFh1jSDK.getCurrencyIso4217Code()) || (aFd1aSDK = this.toString.component4) == null) {
            return;
        }
        int i9 = w + 7;
        i = i9 % 128;
        if ((i9 % 2 == 0 ? (char) 17 : (char) 29) != 29) {
            Map<String, Object> monetizationNetwork3 = AFa1uSDK.getMonetizationNetwork(aFh1jSDK.getCurrencyIso4217Code);
            Intrinsics.checkNotNullExpressionValue(monetizationNetwork3, "");
            monetizationNetwork3.put("fetchAdIdLatency", Long.valueOf(aFd1aSDK.getRevenue));
            obj.hashCode();
            throw null;
        }
        Map<String, Object> monetizationNetwork4 = AFa1uSDK.getMonetizationNetwork(aFh1jSDK.getCurrencyIso4217Code);
        Intrinsics.checkNotNullExpressionValue(monetizationNetwork4, "");
        monetizationNetwork4.put("fetchAdIdLatency", Long.valueOf(aFd1aSDK.getRevenue));
        int i10 = i + 33;
        w = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 92 / 0;
        }
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFg1qSDK aFg1qSDK = (AFg1qSDK) objArr[0];
        int i2 = w + 55;
        i = i2 % 128;
        int i3 = i2 % 2;
        String N_ = AFj1iSDK.N_(aFg1qSDK.getMediationNetwork.getApplicationContext().getPackageManager(), aFg1qSDK.getMediationNetwork.getApplicationContext().getPackageName());
        int i4 = i + 121;
        w = i4 % 128;
        if ((i4 % 2 != 0 ? '\t' : '?') != '\t') {
            return N_;
        }
        int i5 = 27 / 0;
        return N_;
    }

    private static long areAllFieldsValid() {
        int i2 = w + 121;
        i = i2 % 128;
        int i3 = i2 % 2;
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        int i4 = w + 3;
        i = i4 % 128;
        int i5 = i4 % 2;
        return currentTimeMillis;
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final long getCurrencyIso4217Code() {
        int i2 = i + 7;
        w = i2 % 128;
        int i3 = i2 % 2;
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = w + 105;
        i = i4 % 128;
        int i5 = i4 % 2;
        return currentTimeMillis;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        long blockSizeLong = statFs.getBlockSizeLong();
        long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
        long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
        double pow = Math.pow(2.0d, 20.0d);
        String str = ((long) (availableBlocksLong / pow)) + "/" + ((long) (blockCountLong / pow));
        int i2 = w + 117;
        i = i2 % 128;
        if ((i2 % 2 == 0 ? '5' : '?') != '5') {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private void AFAdRevenueData(Map<String, Object> map, boolean z) {
        int i2 = i + 53;
        w = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        map.put("platformextension", this.getRevenue);
        if (z) {
            map.put("platform_extension_v2", this.getCurrencyIso4217Code.AFAdRevenueData());
            int i4 = i + 125;
            w = i4 % 128;
            int i5 = i4 % 2;
        }
    }

    private void component1(Map<String, Object> map) {
        int i2 = w + 53;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        AFf1cSDK.getMonetizationNetwork(map, this.areAllFieldsValid);
        int i4 = i + 43;
        w = i4 % 128;
        if ((i4 % 2 != 0 ? (char) 27 : '+') != 27) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0072, code lost:
        if ((r8.areAllFieldsValid.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 1) <= 5) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
        if (r8.areAllFieldsValid.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0) <= 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008c, code lost:
        r10 = com.appsflyer.internal.AFg1qSDK.i + 85;
        com.appsflyer.internal.AFg1qSDK.w = r10 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0095, code lost:
        if ((r10 % 2) != 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0097, code lost:
        r0.putAll(r8.getMonetizationNetwork.AFAdRevenueData());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a1, code lost:
        r0.putAll(r8.getMonetizationNetwork.AFAdRevenueData());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void getCurrencyIso4217Code(java.util.Map<java.lang.String, java.lang.Object> r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "ro.product.cpu.abi"
            java.lang.String r1 = getMediationNetwork(r1)
            java.lang.String r2 = "cpu_abi"
            r0.put(r2, r1)
            java.lang.String r1 = "ro.product.cpu.abi2"
            java.lang.String r1 = getMediationNetwork(r1)
            java.lang.String r2 = "cpu_abi2"
            r0.put(r2, r1)
            java.lang.String r1 = "os.arch"
            java.lang.String r1 = getMediationNetwork(r1)
            java.lang.String r2 = "arch"
            r0.put(r2, r1)
            java.lang.String r1 = "ro.build.display.id"
            java.lang.String r1 = getMediationNetwork(r1)
            java.lang.String r2 = "build_display_id"
            r0.put(r2, r1)
            if (r10 == 0) goto Lae
            int r10 = com.appsflyer.internal.AFg1qSDK.w
            int r10 = r10 + 41
            int r1 = r10 % 128
            com.appsflyer.internal.AFg1qSDK.i = r1
            r1 = 2
            int r10 = r10 % r1
            r2 = 76
            if (r10 != 0) goto L4b
            r10 = 73
            goto L4c
        L4b:
            r10 = r2
        L4c:
            java.lang.String r3 = "appsFlyerCount"
            r4 = 217750002(0xcfa99f2, float:3.8611251E-31)
            r5 = -217749996(0xfffffffff3056614, float:-1.0568937E31)
            r6 = 1
            r7 = 0
            if (r10 == r2) goto L75
            java.lang.Object[] r10 = new java.lang.Object[r1]
            r10[r7] = r8
            r10[r6] = r0
            int r2 = java.lang.System.identityHashCode(r8)
            getMediationNetwork(r10, r5, r4, r2)
            com.appsflyer.internal.AFc1pSDK r10 = r8.areAllFieldsValid
            com.appsflyer.internal.AFc1oSDK r10 = r10.getMonetizationNetwork
            int r10 = r10.getMediationNetwork(r3, r6)
            r2 = 5
            if (r10 > r2) goto L71
            goto L72
        L71:
            r6 = r7
        L72:
            if (r6 == 0) goto Lae
            goto L8c
        L75:
            java.lang.Object[] r10 = new java.lang.Object[r1]
            r10[r7] = r8
            r10[r6] = r0
            int r2 = java.lang.System.identityHashCode(r8)
            getMediationNetwork(r10, r5, r4, r2)
            com.appsflyer.internal.AFc1pSDK r10 = r8.areAllFieldsValid
            com.appsflyer.internal.AFc1oSDK r10 = r10.getMonetizationNetwork
            int r10 = r10.getMediationNetwork(r3, r7)
            if (r10 > r1) goto Lae
        L8c:
            int r10 = com.appsflyer.internal.AFg1qSDK.i
            int r10 = r10 + 85
            int r2 = r10 % 128
            com.appsflyer.internal.AFg1qSDK.w = r2
            int r10 = r10 % r1
            if (r10 != 0) goto La1
            com.appsflyer.internal.AFj1pSDK r10 = r8.getMonetizationNetwork
            java.util.Map r10 = r10.AFAdRevenueData()
            r0.putAll(r10)
            goto Lae
        La1:
            com.appsflyer.internal.AFj1pSDK r9 = r8.getMonetizationNetwork
            java.util.Map r9 = r9.AFAdRevenueData()
            r0.putAll(r9)
            r9 = 0
            throw r9     // Catch: java.lang.Throwable -> Lac
        Lac:
            r9 = move-exception
            throw r9
        Lae:
            com.appsflyer.internal.AFg1vSDK r10 = r8.component2
            android.content.Context r1 = r8.getMediationNetwork
            java.util.Map r10 = r10.getMediationNetwork(r1)
            java.lang.String r1 = "dim"
            r0.put(r1, r10)
            java.lang.String r10 = "deviceData"
            r9.put(r10, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.getCurrencyIso4217Code(java.util.Map, boolean):void");
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getRevenue(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        AFi1pSDK aFi1pSDK = this.component4.getMediationNetwork;
        boolean z = true;
        AFi1tSDK AFAdRevenueData = aFi1pSDK != null ? aFi1pSDK.AFAdRevenueData() : null;
        if (AFAdRevenueData != null) {
            map.put("network", AFAdRevenueData.getRevenue);
            map.put("ivc", Boolean.valueOf(AFAdRevenueData.getCurrencyIso4217Code()));
            if (getMonetizationNetwork().getBoolean(AppsFlyerProperties.DISABLE_NETWORK_DATA, false)) {
                int i2 = i + 95;
                w = i2 % 128;
                int i3 = i2 % 2;
                z = false;
            } else {
                int i4 = i + 89;
                w = i4 % 128;
                int i5 = i4 % 2;
            }
            if ((z ? '/' : '*') == '/') {
                String str = AFAdRevenueData.getCurrencyIso4217Code;
                if (str != null) {
                    map.put("operator", str);
                }
                String str2 = AFAdRevenueData.getMediationNetwork;
                if (str2 != null) {
                    map.put("carrier", str2);
                    return;
                }
            }
            int i6 = i + 7;
            w = i6 % 128;
            if (i6 % 2 == 0) {
                return;
            }
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getCurrencyIso4217Code(Map<String, Object> map, int i2, int i3) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put("counter", String.valueOf(i2));
        map.put("iaecounter", String.valueOf(i3));
        boolean z = false;
        if (!(component4())) {
            int i4 = w + 115;
            i = i4 % 128;
            int i5 = i4 % 2;
            z = true;
        } else {
            int i6 = i + 61;
            w = i6 % 128;
            int i7 = i6 % 2;
        }
        map.put("isFirstCall", String.valueOf(z));
        int i8 = w + 37;
        i = i8 % 128;
        int i9 = i8 % 2;
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getMonetizationNetwork(Map<String, Object> map) {
        Object m539constructorimpl;
        int i2 = w + 27;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String str = this.toString.getMediationNetwork;
        Object obj = null;
        if ((str != null ? (char) 30 : '\b') == 30) {
            int i4 = i + 25;
            w = i4 % 128;
            if (i4 % 2 != 0) {
                map.get("af_deeplink");
                obj.hashCode();
                throw null;
            } else if (map.get("af_deeplink") != null) {
                AFLogger.afDebugLog("Skip 'af' payload as deeplink was found by path");
            } else {
                try {
                    Result.Companion companion = Result.Companion;
                    AFg1qSDK aFg1qSDK = this;
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("isPush", "true");
                    map.put("af_deeplink", jSONObject.toString());
                    m539constructorimpl = Result.m539constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m539constructorimpl = Result.m539constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m542exceptionOrNullimpl = Result.m542exceptionOrNullimpl(m539constructorimpl);
                if ((m542exceptionOrNullimpl != null ? 'E' : 'M') != 'M') {
                    int i5 = w + 123;
                    i = i5 % 128;
                    int i6 = i5 % 2;
                    AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.GENERAL, "Exception while trying to create JSONObject from pushPayload", m542exceptionOrNullimpl, false, false, false, false, 120, null);
                }
                Result.m538boximpl(m539constructorimpl);
            }
        }
        this.toString.getMediationNetwork = null;
        int i7 = i + 53;
        w = i7 % 128;
        int i8 = i7 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c A[ORIG_RETURN, RETURN] */
    @Override // com.appsflyer.internal.AFg1rSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getRevenue(com.appsflyer.internal.AFh1jSDK r7) {
        /*
            r6 = this;
            int r0 = com.appsflyer.internal.AFg1qSDK.i
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.appsflyer.internal.AFg1qSDK.w = r1
            int r0 = r0 % 2
            java.lang.String r1 = "open_referrer"
            r2 = 0
            java.lang.String r3 = ""
            if (r0 != 0) goto L5d
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r7.getCurrencyIso4217Code
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.String r3 = r7.getMediationNetwork
            r0.put(r1, r3)
            java.lang.String r1 = r7.component2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L37
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r5 = 80
            if (r1 == 0) goto L31
            r1 = 31
            goto L32
        L31:
            r1 = r5
        L32:
            if (r1 == r5) goto L35
            goto L37
        L35:
            r1 = r3
            goto L38
        L37:
            r1 = r4
        L38:
            if (r1 != 0) goto L5c
            int r1 = com.appsflyer.internal.AFg1qSDK.i
            int r1 = r1 + 41
            int r5 = r1 % 128
            com.appsflyer.internal.AFg1qSDK.w = r5
            int r1 = r1 % 2
            if (r1 == 0) goto L47
            r3 = r4
        L47:
            java.lang.String r1 = "af_web_referrer"
            if (r3 == r4) goto L51
            java.lang.String r7 = r7.component2
            r0.put(r1, r7)
            goto L5c
        L51:
            java.lang.String r7 = r7.component2
            r0.put(r1, r7)
            r2.hashCode()     // Catch: java.lang.Throwable -> L5a
            throw r2     // Catch: java.lang.Throwable -> L5a
        L5a:
            r7 = move-exception
            throw r7
        L5c:
            return
        L5d:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r7.getCurrencyIso4217Code
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.String r3 = r7.getMediationNetwork
            r0.put(r1, r3)
            java.lang.String r7 = r7.component2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            throw r2     // Catch: java.lang.Throwable -> L6f
        L6f:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.getRevenue(com.appsflyer.internal.AFh1jSDK):void");
    }

    private static /* synthetic */ Object component1(Object[] objArr) {
        AFg1qSDK aFg1qSDK = (AFg1qSDK) objArr[0];
        Map map = (Map) objArr[1];
        AFg1sSDK.AFa1uSDK AFAdRevenueData = aFg1qSDK.AFAdRevenueData.AFAdRevenueData(aFg1qSDK.getMediationNetwork);
        float f = AFAdRevenueData.getRevenue;
        String str = AFAdRevenueData.AFAdRevenueData;
        map.put("btl", String.valueOf(f));
        if (!(str == null)) {
            int i2 = w + 95;
            i = i2 % 128;
            int i3 = i2 % 2;
            map.put("btch", str);
        }
        int i4 = i + 31;
        w = i4 % 128;
        if ((i4 % 2 != 0 ? 'c' : '+') != '+') {
            int i5 = 14 / 0;
            return null;
        }
        return null;
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFg1qSDK aFg1qSDK = (AFg1qSDK) objArr[0];
        Map map = (Map) objArr[1];
        int i2 = i + 77;
        w = i2 % 128;
        Object obj = null;
        if (!(i2 % 2 != 0)) {
            Intrinsics.checkNotNullParameter(map, "");
            String string = aFg1qSDK.getMonetizationNetwork().getString(AppsFlyerProperties.ONELINK_ID);
            String string2 = aFg1qSDK.getMonetizationNetwork().getString(AppsFlyerProperties.ONELINK_VERSION);
            if (string != null) {
                map.put("onelink_id", string);
            }
            if (string2 != null) {
                map.put("onelink_ver", string2);
                int i3 = i + 121;
                w = i3 % 128;
                int i4 = i3 % 2;
            }
            return null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        aFg1qSDK.getMonetizationNetwork().getString(AppsFlyerProperties.ONELINK_ID);
        aFg1qSDK.getMonetizationNetwork().getString(AppsFlyerProperties.ONELINK_VERSION);
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object areAllFieldsValid(Object[] objArr) {
        boolean z = true;
        Map map = (Map) objArr[1];
        Intrinsics.checkNotNullParameter(map, "");
        AFh1tSDK aFh1tSDK = ((AFg1qSDK) objArr[0]).component3;
        HashMap hashMap = new HashMap(aFh1tSDK.AFAdRevenueData);
        aFh1tSDK.AFAdRevenueData.clear();
        aFh1tSDK.getCurrencyIso4217Code.getCurrencyIso4217Code("gcd");
        Intrinsics.checkNotNullExpressionValue(hashMap, "");
        if ((!hashMap.isEmpty() ? '4' : '*') != '*') {
            int i2 = i + 111;
            w = i2 % 128;
            int i3 = i2 % 2;
        } else {
            int i4 = i + 29;
            w = i4 % 128;
            int i5 = i4 % 2;
            z = false;
        }
        if ((z ? 'Y' : (char) 19) != 19) {
            int i6 = w + 31;
            i = i6 % 128;
            if ((i6 % 2 == 0 ? '2' : 'R') != '2') {
                Map<String, Object> monetizationNetwork = AFa1uSDK.getMonetizationNetwork(map);
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
                monetizationNetwork.put("gcd", hashMap);
                return null;
            }
            Map<String, Object> monetizationNetwork2 = AFa1uSDK.getMonetizationNetwork(map);
            Intrinsics.checkNotNullExpressionValue(monetizationNetwork2, "");
            monetizationNetwork2.put("gcd", hashMap);
            int i7 = 88 / 0;
            return null;
        }
        return null;
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        AFg1qSDK aFg1qSDK = (AFg1qSDK) objArr[0];
        Map map = (Map) objArr[1];
        String str = (String) objArr[2];
        int i2 = w + 81;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            String monetizationNetwork = aFg1qSDK.component1.getMonetizationNetwork("prev_event_name", null);
            if (monetizationNetwork != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prev_event_timestamp", aFg1qSDK.component1.getCurrencyIso4217Code("prev_event_timestamp", -1L));
                jSONObject.put("prev_event_name", monetizationNetwork);
                map.put("prev_event", jSONObject);
            }
            aFg1qSDK.component1.AFAdRevenueData("prev_event_name", str);
            aFg1qSDK.component1.getRevenue("prev_event_timestamp", System.currentTimeMillis());
            int i4 = i + 59;
            w = i4 % 128;
            if ((i4 % 2 != 0 ? 'S' : (char) 6) == 6) {
                return null;
            }
            throw null;
        } catch (Exception e) {
            AFLogger.afErrorLog("Error while processing previous event.", e);
            return null;
        }
    }

    private String getMonetizationNetwork(int i2) {
        boolean z;
        int i3 = w + 57;
        i = i3 % 128;
        String str = null;
        if (i3 % 2 == 0) {
            this.component1.getRevenue("INSTALL_STORE");
            str.hashCode();
            throw null;
        }
        if (this.component1.getRevenue("INSTALL_STORE")) {
            return this.component1.getMonetizationNetwork("INSTALL_STORE", null);
        }
        if (!(i2 <= 1)) {
            int i4 = w + 117;
            i = i4 % 128;
            int i5 = i4 % 2;
            z = false;
        } else {
            z = true;
        }
        if (!(z)) {
            int i6 = i + 23;
            w = i6 % 128;
            int i7 = i6 % 2;
        } else {
            str = component2();
        }
        this.component1.AFAdRevenueData("INSTALL_STORE", str);
        return str;
    }

    private String component2() {
        String string = getMonetizationNetwork().getString(AppsFlyerProperties.AF_STORE_FROM_API);
        if ((string == null ? '#' : (char) 0) != 0) {
            int i2 = w + 75;
            i = i2 % 128;
            int i3 = i2 % 2;
            string = getCurrencyIso4217Code("AF_STORE");
        }
        int i4 = i + 95;
        w = i4 % 128;
        if ((i4 % 2 != 0 ? 'J' : 'E') == 'E') {
            return string;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private String getCurrencyIso4217Code(SimpleDateFormat simpleDateFormat, int i2) {
        Intrinsics.checkNotNullParameter(simpleDateFormat, "");
        String monetizationNetwork = this.component1.getMonetizationNetwork("appsFlyerFirstInstall", null);
        if (monetizationNetwork == null) {
            int i3 = i + 125;
            w = i3 % 128;
            if ((i3 % 2 != 0 ? '=' : ',') == ',' ? i2 > 1 : i2 > 0) {
                monetizationNetwork = "";
            } else {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                String format = simpleDateFormat.format(new Date());
                int i4 = i + 121;
                w = i4 % 128;
                int i5 = i4 % 2;
                monetizationNetwork = format;
            }
            this.component1.AFAdRevenueData("appsFlyerFirstInstall", monetizationNetwork);
            int i6 = w + 59;
            i = i6 % 128;
            int i7 = i6 % 2;
        }
        AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.GENERAL, "AppsFlyer: first launch date: " + monetizationNetwork, false, 4, null);
        Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
        return monetizationNetwork;
    }

    private boolean component4() {
        int i2 = i + 59;
        w = i2 % 128;
        int i3 = i2 % 2;
        boolean parseBoolean = Boolean.parseBoolean(this.component1.getMonetizationNetwork("sentSuccessfully", null));
        int i4 = i + 69;
        w = i4 % 128;
        int i5 = i4 % 2;
        return parseBoolean;
    }

    private String AFAdRevenueData(int i2) {
        String str;
        int i3 = i + 53;
        w = i3 % 128;
        int i4 = i3 % 2;
        String string = getMonetizationNetwork().getString("preInstallName");
        if (string != null) {
            int i5 = w + 15;
            i = i5 % 128;
            if (i5 % 2 == 0) {
                int i6 = 12 / 0;
                return string;
            }
            return string;
        }
        Object obj = null;
        if (this.component1.getRevenue("preInstallName")) {
            str = this.component1.getMonetizationNetwork("preInstallName", null);
        } else {
            if ((i2 <= 1 ? 'b' : '4') != '4') {
                int i7 = i + 99;
                w = i7 % 128;
                if (i7 % 2 != 0) {
                    equals();
                    throw null;
                }
                String equals = equals();
                if (equals == null) {
                    int i8 = w + 19;
                    i = i8 % 128;
                    if (!(i8 % 2 != 0)) {
                        getCurrencyIso4217Code("AF_PRE_INSTALL_NAME");
                        obj.hashCode();
                        throw null;
                    }
                    equals = getCurrencyIso4217Code("AF_PRE_INSTALL_NAME");
                }
                string = equals;
            }
            if (string != null) {
                this.component1.AFAdRevenueData("preInstallName", string);
            }
            str = string;
        }
        if (!(str == null)) {
            int i9 = w + 73;
            i = i9 % 128;
            int i10 = i9 % 2;
            getMonetizationNetwork().set("preInstallName", str);
        }
        return str;
    }

    private static /* synthetic */ Object component3(Object[] objArr) {
        AFg1qSDK aFg1qSDK = (AFg1qSDK) objArr[0];
        boolean z = true;
        Map map = (Map) objArr[1];
        String str = (String) objArr[2];
        int i2 = w + 85;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        if (!(!aFg1qSDK.getMonetizationNetwork().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false))) {
            map.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            return null;
        }
        String mediationNetwork = aFg1qSDK.copy.getMediationNetwork(aFg1qSDK.component1);
        String str2 = mediationNetwork;
        if (str2 != null) {
            if ((str2.length() == 0 ? 'I' : ':') == ':') {
                z = false;
            }
        }
        if (!z) {
            int i4 = w + 87;
            i = i4 % 128;
            if (i4 % 2 == 0) {
                map.put(Constants.DeviceIdentifierKeyspaceKeys.IMEI_KEYSPACE_KEY, mediationNetwork);
                int i5 = 7 / 0;
            } else {
                map.put(Constants.DeviceIdentifierKeyspaceKeys.IMEI_KEYSPACE_KEY, mediationNetwork);
            }
        }
        String revenue = aFg1qSDK.getRevenue(str);
        if (revenue != null) {
            int i6 = w + 43;
            i = i6 % 128;
            if ((i6 % 2 == 0 ? (char) 5 : '?') != 5) {
                aFg1qSDK.component1.AFAdRevenueData("androidIdCached", revenue);
                map.put("android_id", revenue);
            } else {
                aFg1qSDK.component1.AFAdRevenueData("androidIdCached", revenue);
                map.put("android_id", revenue);
                int i7 = 37 / 0;
            }
        } else {
            AFLogger.afInfoLog("Android ID was not collected.");
        }
        AFb1mSDK currencyIso4217Code = AFb1kSDK.getCurrencyIso4217Code(aFg1qSDK.getMediationNetwork);
        if (currencyIso4217Code != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Boolean bool = currencyIso4217Code.getMediationNetwork;
            Intrinsics.checkNotNullExpressionValue(bool, "");
            linkedHashMap.put("isManual", bool);
            String str3 = currencyIso4217Code.getCurrencyIso4217Code;
            Intrinsics.checkNotNullExpressionValue(str3, "");
            linkedHashMap.put("val", str3);
            Boolean bool2 = currencyIso4217Code.getRevenue;
            if (bool2 != null) {
                linkedHashMap.put("isLat", bool2);
            }
            map.put(Constants.DeviceIdentifierKeyspaceKeys.OAID_KEYSPACE_KEY, linkedHashMap);
        }
        return null;
    }

    private final String getRevenue(String str) {
        int i2;
        if (getMonetizationNetwork().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, false)) {
            String str2 = str;
            if ((str2 == null || str2.length() == 0 ? '5' : '3') != '3') {
                int i3 = w + 39;
                i = i3 % 128;
                if (i3 % 2 == 0) {
                    copy();
                    throw null;
                }
                if ((copy() ? '\r' : '.') == '\r') {
                    str = (String) getMediationNetwork(new Object[]{this}, 969328908, -969328900, System.identityHashCode(this));
                    i2 = i + 55;
                    w = i2 % 128;
                    int i4 = i2 % 2;
                    return str;
                }
                return null;
            }
        }
        if ((str != null ? 'I' : '9') != '9') {
            i2 = i + 85;
            w = i2 % 128;
            int i42 = i2 % 2;
            return str;
        }
        return null;
    }

    private static /* synthetic */ Object component2(Object[] objArr) {
        AFg1qSDK aFg1qSDK = (AFg1qSDK) objArr[0];
        int i2 = i + 79;
        w = i2 % 128;
        int i3 = i2 % 2;
        Object obj = null;
        String monetizationNetwork = aFg1qSDK.component1.getMonetizationNetwork("androidIdCached", null);
        try {
            String string = Settings.Secure.getString(aFg1qSDK.getMediationNetwork.getContentResolver(), "android_id");
            if (!(string == null)) {
                int i4 = i + 13;
                w = i4 % 128;
                int i5 = i4 % 2;
                return string;
            }
        } catch (Exception e) {
            AFLogger.afErrorLog(e.getMessage(), e);
        }
        if ((monetizationNetwork != null ? (char) 30 : 'F') != 'F') {
            AFLogger.afDebugLog("use cached AndroidId: " + monetizationNetwork);
            int i6 = w + 3;
            i = i6 % 128;
            if (i6 % 2 == 0) {
                obj.hashCode();
                throw null;
            }
            return monetizationNetwork;
        }
        return null;
    }

    private static void areAllFieldsValid(Map<String, Object> map) {
        int i2 = i + 59;
        w = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        Object[] objArr = new Object[1];
        a(null, "\u008f\u0089\u0087\u0083\u008e", null, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 126, objArr);
        map.put(((String) objArr[0]).intern(), Build.BRAND);
        map.put("device", Build.DEVICE);
        map.put("product", Build.PRODUCT);
        map.put(Constants.RequestParamsKeys.SDK_VERSION_KEY, String.valueOf(Build.VERSION.SDK_INT));
        map.put("model", Build.MODEL);
        map.put("deviceType", Build.TYPE);
        int i4 = i + 21;
        w = i4 % 128;
        int i5 = i4 % 2;
    }

    private void getCurrencyIso4217Code(AFh1jSDK aFh1jSDK, String str, String str2, AFb1rSDK aFb1rSDK) {
        int i2 = w + 53;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        Map<String, Object> map = aFh1jSDK.getCurrencyIso4217Code;
        if (aFh1jSDK.getCurrencyIso4217Code() == AFe1mSDK.CONVERSION) {
            int i4 = w + 13;
            i = i4 % 128;
            int i5 = i4 % 2;
            Intrinsics.checkNotNullExpressionValue(map, "");
            equals(map);
            copy(map);
            toString(map);
            AFa1zSDK.getMonetizationNetwork(this.equals, this.areAllFieldsValid);
            int i6 = w + 3;
            i = i6 % 128;
            int i7 = i6 % 2;
        }
        Intrinsics.checkNotNullExpressionValue(map, "");
        copydefault(map);
        getMediationNetwork(new Object[]{this, map}, 1978462197, -1978462194, System.identityHashCode(this));
        getMediationNetwork(new Object[]{this, map}, -2029029470, 2029029475, System.identityHashCode(this));
        getMonetizationNetwork(map, str2);
        AFAdRevenueData(map, str);
        AFInAppEventParameterName(map);
        if (!(aFb1rSDK == null)) {
            int i8 = i + 9;
            w = i8 % 128;
            if (i8 % 2 == 0) {
                aFb1rSDK.getMonetizationNetwork(map);
                return;
            }
            aFb1rSDK.getMonetizationNetwork(map);
            int i9 = 18 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if ((!getMonetizationNetwork().isOtherSdkStringDisabled() ? 22 : '%') != '%') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        if ((!getMonetizationNetwork().isOtherSdkStringDisabled() ? '@' : 'R') != '@') goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        r5.put("batteryLevel", java.lang.String.valueOf(r4.AFAdRevenueData.AFAdRevenueData(r4.getMediationNetwork).getRevenue));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void equals(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            int r0 = com.appsflyer.internal.AFg1qSDK.w
            int r0 = r0 + 85
            int r1 = r0 % 128
            com.appsflyer.internal.AFg1qSDK.i = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 12
            if (r0 != 0) goto L10
            r0 = r2
            goto L12
        L10:
            r0 = 18
        L12:
            if (r0 == r2) goto L27
            com.appsflyer.AppsFlyerProperties r0 = r4.getMonetizationNetwork()
            boolean r0 = r0.isOtherSdkStringDisabled()
            r3 = 37
            if (r0 != 0) goto L23
            r0 = 22
            goto L24
        L23:
            r0 = r3
        L24:
            if (r0 == r3) goto L4f
            goto L3c
        L27:
            com.appsflyer.AppsFlyerProperties r0 = r4.getMonetizationNetwork()
            boolean r0 = r0.isOtherSdkStringDisabled()
            int r3 = r1 / 0
            r3 = 64
            if (r0 != 0) goto L37
            r0 = r3
            goto L39
        L37:
            r0 = 82
        L39:
            if (r0 == r3) goto L3c
            goto L4f
        L3c:
            com.appsflyer.internal.AFg1sSDK r0 = r4.AFAdRevenueData
            android.content.Context r3 = r4.getMediationNetwork
            com.appsflyer.internal.AFg1sSDK$AFa1uSDK r0 = r0.AFAdRevenueData(r3)
            float r0 = r0.getRevenue
            java.lang.String r3 = "batteryLevel"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r5.put(r3, r0)
        L4f:
            int r5 = com.appsflyer.internal.AFg1qSDK.i
            int r5 = r5 + 69
            int r0 = r5 % 128
            com.appsflyer.internal.AFg1qSDK.w = r0
            int r5 = r5 % r1
            if (r5 == 0) goto L5c
            r5 = r2
            goto L5e
        L5c:
            r5 = 86
        L5e:
            if (r5 == r2) goto L61
            return
        L61:
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L66
            throw r5     // Catch: java.lang.Throwable -> L66
        L66:
            r5 = move-exception
            throw r5
        L68:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.equals(java.util.Map):void");
    }

    private final void copy(Map<String, Object> map) {
        UiModeManager uiModeManager;
        int i2 = w + 19;
        i = i2 % 128;
        if (i2 % 2 != 0 || Build.VERSION.SDK_INT >= 117) {
            uiModeManager = (UiModeManager) this.getMediationNetwork.getSystemService(UiModeManager.class);
        } else {
            Object systemService = this.getMediationNetwork.getSystemService("uimode");
            uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
        }
        if (uiModeManager != null) {
            if (uiModeManager.getCurrentModeType() == 4) {
                map.put("tv", Boolean.TRUE);
                int i3 = w + 63;
                i = i3 % 128;
                int i4 = i3 % 2;
            }
        }
    }

    private void hashCode(Map<String, Object> map) {
        int i2 = w + 101;
        i = i2 % 128;
        if (i2 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("is_pc", Boolean.valueOf(this.getMediationNetwork.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")));
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        map.put("is_pc", Boolean.valueOf(this.getMediationNetwork.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")));
    }

    private final void toString(Map<String, Object> map) {
        int i2 = i + 117;
        w = i2 % 128;
        if (i2 % 2 == 0) {
            if (AFg1kSDK.AFAdRevenueData(this.getMediationNetwork)) {
                map.put("inst_app", Boolean.TRUE);
                int i3 = w + 29;
                i = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
            return;
        }
        AFg1kSDK.AFAdRevenueData(this.getMediationNetwork);
        throw null;
    }

    private void copydefault(Map<String, Object> map) {
        TimeUnit timeUnit;
        long j;
        long seconds;
        Intrinsics.checkNotNullParameter(map, "");
        long currencyIso4217Code = this.component1.getCurrencyIso4217Code("AppsFlyerTimePassedSincePrevLaunch", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        this.component1.getRevenue("AppsFlyerTimePassedSincePrevLaunch", currentTimeMillis);
        if ((currencyIso4217Code > 0 ? (char) 19 : 'O') != 19) {
            int i2 = i + 13;
            w = i2 % 128;
            int i3 = i2 % 2;
            seconds = -1;
        } else {
            int i4 = w + 121;
            i = i4 % 128;
            if (!(i4 % 2 == 0)) {
                timeUnit = TimeUnit.MILLISECONDS;
                j = currentTimeMillis - currencyIso4217Code;
            } else {
                timeUnit = TimeUnit.MILLISECONDS;
                j = currentTimeMillis % currencyIso4217Code;
            }
            seconds = timeUnit.toSeconds(j);
        }
        map.put("timepassedsincelastlaunch", String.valueOf(seconds));
    }

    private static void getMonetizationNetwork(Map<String, Object> map, String str) {
        int i2 = w + 43;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        if (str != null) {
            int i4 = w + 77;
            i = i4 % 128;
            int i5 = i4 % 2;
            map.put("phone", str);
            int i6 = i + 1;
            w = i6 % 128;
            int i7 = i6 % 2;
        }
    }

    private void AFAdRevenueData(Map<String, Object> map, String str) {
        boolean z;
        int i2 = w + 101;
        i = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            int i3 = i + 17;
            w = i3 % 128;
            if (i3 % 2 != 0) {
                map.put("referrer", str);
                obj.hashCode();
                throw null;
            }
            map.put("referrer", str);
            int i4 = i + 67;
            w = i4 % 128;
            int i5 = i4 % 2;
        }
        String monetizationNetwork = this.component1.getMonetizationNetwork("extraReferrers", null);
        if (monetizationNetwork != null) {
            map.put("extraReferrers", monetizationNetwork);
        }
        String referrer = getMonetizationNetwork().getReferrer(this.component1);
        String str3 = referrer;
        if (str3 == null || str3.length() == 0) {
            int i6 = i + 17;
            w = i6 % 128;
            int i7 = i6 % 2;
            z = true;
        } else {
            z = false;
        }
        if (!(!z)) {
            return;
        }
        int i8 = w + 67;
        i = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 10 / 0;
            if ((map.get("referrer") == null ? 'U' : '#') != 'U') {
                return;
            }
        } else if (map.get("referrer") != null) {
            return;
        }
        map.put("referrer", referrer);
    }

    private void AFInAppEventParameterName(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        long j = this.component3.hashCode;
        if (j != 0) {
            int i2 = i + 41;
            w = i2 % 128;
            int i3 = i2 % 2;
            map.put("prev_session_dur", Long.valueOf(j));
            int i4 = w + 31;
            i = i4 % 128;
            int i5 = i4 % 2;
        }
        int i6 = i + 111;
        w = i6 % 128;
        int i7 = i6 % 2;
    }

    private static void AFKeystoreWrapper(Map<String, Object> map) {
        int i2 = w + 41;
        i = i2 % 128;
        if (i2 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            AFa1zSDK aFa1zSDK = AFa1zSDK.INSTANCE;
            Object monetizationNetwork = AFa1zSDK.getMonetizationNetwork();
            AFa1zSDK aFa1zSDK2 = AFa1zSDK.INSTANCE;
            String revenue = AFa1zSDK.getRevenue();
            if (monetizationNetwork != null) {
                if (!(revenue != null)) {
                    return;
                }
                if (!(Integer.parseInt(revenue) <= 0)) {
                    int i3 = i + 57;
                    w = i3 % 128;
                    int i4 = i3 % 2;
                    map.put("reinstallCounter", revenue);
                    map.put("originalAppsflyerId", monetizationNetwork);
                    return;
                }
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        AFa1zSDK aFa1zSDK3 = AFa1zSDK.INSTANCE;
        AFa1zSDK.getMonetizationNetwork();
        AFa1zSDK aFa1zSDK4 = AFa1zSDK.INSTANCE;
        AFa1zSDK.getRevenue();
        throw null;
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        AFg1qSDK aFg1qSDK = (AFg1qSDK) objArr[0];
        Map map = (Map) objArr[1];
        int i2 = i + 119;
        w = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 17 : '?') != 17) {
            Intrinsics.checkNotNullParameter(map, "");
            map.putAll(aFg1qSDK.hashCode.getCurrencyIso4217Code());
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            map.putAll(aFg1qSDK.hashCode.getCurrencyIso4217Code());
            int i3 = 68 / 0;
        }
        int i4 = i + 53;
        w = i4 % 128;
        if (!(i4 % 2 == 0)) {
            int i5 = 1 / 0;
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        if ((r2.length() == 0) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void AFLogger(java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.appsflyer.AppsFlyerProperties r0 = r7.getMonetizationNetwork()
            java.lang.String r1 = "sdkExtension"
            java.lang.String r0 = r0.getString(r1)
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L18
            r5 = r3
            goto L19
        L18:
            r5 = r4
        L19:
            if (r5 == 0) goto L1c
            goto L31
        L1c:
            int r5 = com.appsflyer.internal.AFg1qSDK.i
            int r5 = r5 + 39
            int r6 = r5 % 128
            com.appsflyer.internal.AFg1qSDK.w = r6
            int r5 = r5 % 2
            int r2 = r2.length()
            if (r2 != 0) goto L2e
            r2 = r4
            goto L2f
        L2e:
            r2 = r3
        L2f:
            if (r2 == 0) goto L32
        L31:
            r3 = r4
        L32:
            r2 = 51
            if (r3 != 0) goto L38
            r3 = r2
            goto L3a
        L38:
            r3 = 43
        L3a:
            if (r3 == r2) goto L3d
            goto L4a
        L3d:
            int r2 = com.appsflyer.internal.AFg1qSDK.i
            int r2 = r2 + 117
            int r3 = r2 % 128
            com.appsflyer.internal.AFg1qSDK.w = r3
            int r2 = r2 % 2
            r8.put(r1, r0)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.AFLogger(java.util.Map):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
        if ((r2) != false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void AFAdRevenueData(java.util.Map<java.lang.String, java.lang.Object> r9, int r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.AFAdRevenueData(java.util.Map, int):void");
    }

    private void registerClient(Map<String, Object> map) {
        int i2 = w + 51;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        map.put("af_preinstalled", String.valueOf(this.areAllFieldsValid.getMediationNetwork(this.getMediationNetwork)));
        int i4 = w + 91;
        i = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        throw null;
    }

    private static /* synthetic */ Object component4(Object[] objArr) {
        Map map = (Map) objArr[0];
        int i2 = i + 107;
        w = i2 % 128;
        try {
        } catch (Exception e) {
            AFLogger.afErrorLog("Exception while collecting display language name. ", e);
        }
        if (!(i2 % 2 != 0)) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("lang", Locale.getDefault().getDisplayLanguage());
            try {
                map.put("lang_code", Locale.getDefault().getLanguage());
                int i3 = w + 51;
                i = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                AFLogger.afErrorLog("Exception while collecting display language code. ", e2);
            }
            try {
                map.put(AdRevenueScheme.COUNTRY, Locale.getDefault().getCountry());
                return null;
            } catch (Exception e3) {
                AFLogger.afErrorLog("Exception while collecting country name. ", e3);
                return null;
            }
        }
        Intrinsics.checkNotNullParameter(map, "");
        map.put("lang", Locale.getDefault().getDisplayLanguage());
        throw null;
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getMediationNetwork(Map<String, Object> map) {
        int i2 = w + 77;
        i = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String revenue = AFb1jSDK.getRevenue(this.areAllFieldsValid.getMonetizationNetwork);
        if (!(revenue == null)) {
            map.put("uid", revenue);
            Boolean valueOf = Boolean.valueOf(this.areAllFieldsValid.getMonetizationNetwork.getMediationNetwork("CUSTOM_INSTALL_ID_APPLIED", false));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
            if (valueOf.booleanValue()) {
                map.put("custom_install_id", Boolean.TRUE);
                return;
            }
            return;
        }
        int i4 = w + 93;
        i = i4 % 128;
        if ((i4 % 2 == 0 ? Typography.greater : '\b') == '\b') {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
        if ((r0 ? false : true) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        r0 = com.appsflyer.internal.AFg1qSDK.i + 33;
        com.appsflyer.internal.AFg1qSDK.w = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        if ((r0 % 2) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
        r0 = 'L';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
        r0 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        if (r0 == 'L') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
        r6.put("tokenRefreshConfigured", java.lang.Boolean.FALSE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
        r6.put("tokenRefreshConfigured", java.lang.Boolean.FALSE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
        r6.put("registeredUninstall", java.lang.Boolean.valueOf(com.appsflyer.internal.AFg1tSDK.getCurrencyIso4217Code(r5.component1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0088, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
        if ((r0 ? false : true) != true) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r5 = this;
            int r0 = com.appsflyer.internal.AFg1qSDK.w
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.appsflyer.internal.AFg1qSDK.i = r1
            int r0 = r0 % 2
            java.lang.String r1 = "didConfigureTokenRefreshService="
            java.lang.String r2 = ""
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            android.content.Context r0 = r5.getMediationNetwork
            boolean r0 = com.appsflyer.internal.AFg1tSDK.getMediationNetwork(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.StringBuilder r1 = r2.append(r0)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afDebugLog(r1)
            r1 = 45
            int r1 = r1 / r4
            if (r0 != 0) goto L31
            r4 = r3
        L31:
            if (r4 == r3) goto L55
            goto L79
        L34:
            r6 = move-exception
            throw r6
        L36:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            android.content.Context r0 = r5.getMediationNetwork
            boolean r0 = com.appsflyer.internal.AFg1tSDK.getMediationNetwork(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.StringBuilder r1 = r2.append(r0)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afDebugLog(r1)
            if (r0 != 0) goto L52
            goto L53
        L52:
            r3 = r4
        L53:
            if (r3 == 0) goto L79
        L55:
            int r0 = com.appsflyer.internal.AFg1qSDK.i
            int r0 = r0 + 33
            int r1 = r0 % 128
            com.appsflyer.internal.AFg1qSDK.w = r1
            int r0 = r0 % 2
            r1 = 76
            if (r0 == 0) goto L65
            r0 = r1
            goto L66
        L65:
            r0 = 6
        L66:
            java.lang.String r2 = "tokenRefreshConfigured"
            if (r0 == r1) goto L70
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r6.put(r2, r0)
            goto L79
        L70:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r6.put(r2, r0)
            r6 = 0
            throw r6     // Catch: java.lang.Throwable -> L77
        L77:
            r6 = move-exception
            throw r6
        L79:
            com.appsflyer.internal.AFc1oSDK r0 = r5.component1
            boolean r0 = com.appsflyer.internal.AFg1tSDK.getCurrencyIso4217Code(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r1 = "registeredUninstall"
            r6.put(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.e(java.util.Map):void");
    }

    private void i(Map<String, Object> map) {
        AFb1mSDK l_;
        int i2 = i + 57;
        w = i2 % 128;
        if (i2 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            l_ = AFb1kSDK.l_(this.getMediationNetwork.getContentResolver());
            int i3 = 54 / 0;
            if (l_ == null) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            l_ = AFb1kSDK.l_(this.getMediationNetwork.getContentResolver());
            if (!(l_ != null)) {
                return;
            }
        }
        int i4 = w + 97;
        i = i4 % 128;
        int i5 = i4 % 2;
        map.put("amazon_aid", l_.getCurrencyIso4217Code);
        map.put("amazon_aid_limit", String.valueOf(l_.getRevenue));
    }

    private void d(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        if ((this.component1.getRevenue("is_stop_tracking_used") ? '5' : 'H') != 'H') {
            int i2 = w + 49;
            i = i2 % 128;
            int i3 = i2 % 2;
            map.put("istu", String.valueOf(this.component1.getMediationNetwork("is_stop_tracking_used", false)));
            int i4 = w + 79;
            i = i4 % 128;
            int i5 = i4 % 2;
        }
        int i6 = i + 125;
        w = i6 % 128;
        if ((i6 % 2 != 0 ? (char) 28 : '(') != 28) {
            return;
        }
        throw null;
    }

    private void w(Map<String, Object> map) {
        int i2 = i + 31;
        w = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            this.copy.getMediationNetwork();
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        String mediationNetwork = this.copy.getMediationNetwork();
        String str = mediationNetwork;
        if ((str == null) || str.length() == 0) {
            return;
        }
        int i3 = w + 83;
        i = i3 % 128;
        if (i3 % 2 != 0) {
            map.put("appsflyerKey", mediationNetwork);
            return;
        }
        map.put("appsflyerKey", mediationNetwork);
        obj.hashCode();
        throw null;
    }

    private void afDebugLog(Map<String, Object> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, "");
        if (getMonetizationNetwork().getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
            int i2 = w + 113;
            i = i2 % 128;
            int i3 = i2 % 2;
            try {
                this.getMediationNetwork.getPackageManager().getApplicationInfo("com.facebook.katana", 0);
                str = this.areAllFieldsValid.getRevenue(this.getMediationNetwork);
                int i4 = i + 105;
                w = i4 % 128;
                int i5 = i4 % 2;
            } catch (Throwable unused) {
                str = null;
            }
            if (!(str == null)) {
                int i6 = i + 119;
                w = i6 % 128;
                int i7 = i6 % 2;
                map.put("fb", str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
        if (r1.toString.equals != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
        if ((r12 != null) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
        r12 = com.appsflyer.internal.AFg1qSDK.i + 93;
        com.appsflyer.internal.AFg1qSDK.w = r12 % 128;
        r12 = r12 % 2;
        com.appsflyer.internal.AFh1ySDK.i$default(com.appsflyer.AFLogger.INSTANCE, com.appsflyer.internal.AFg1cSDK.APP_SET_ID, "App Set Id was collected, but will not be included in the payload.To prevent collection entirely, call disableAppSetId() before initializing the SDK.", false, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
        com.appsflyer.internal.AFh1ySDK.i$default(com.appsflyer.AFLogger.INSTANCE, com.appsflyer.internal.AFg1cSDK.APP_SET_ID, "App Set ID collection is disabled. Skipping inclusion in the event payload.", false, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ java.lang.Object copydefault(java.lang.Object[] r12) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1qSDK.copydefault(java.lang.Object[]):java.lang.Object");
    }

    private static List<AFe1mSDK> copydefault() {
        int i2 = i + 103;
        w = i2 % 128;
        int i3 = i2 % 2;
        List<AFe1mSDK> listOf = CollectionsKt.listOf((Object[]) new AFe1mSDK[]{AFe1mSDK.CONVERSION, AFe1mSDK.LAUNCH, AFe1mSDK.INAPP, AFe1mSDK.MANUAL_PURCHASE_VALIDATION, AFe1mSDK.ARS_VALIDATE, AFe1mSDK.PURCHASE_VALIDATE, AFe1mSDK.ADREVENUE});
        int i4 = i + 67;
        w = i4 % 128;
        int i5 = i4 % 2;
        return listOf;
    }

    private static String AFAdRevenueData(AFc1oSDK aFc1oSDK, String str) {
        int i2 = i + 77;
        w = i2 % 128;
        int i3 = i2 % 2;
        String monetizationNetwork = aFc1oSDK.getMonetizationNetwork("CACHED_CHANNEL", null);
        if (!(monetizationNetwork == null)) {
            int i4 = w + 27;
            i = i4 % 128;
            int i5 = i4 % 2;
            return monetizationNetwork;
        }
        aFc1oSDK.AFAdRevenueData("CACHED_CHANNEL", str);
        return str;
    }

    private static String getMediationNetwork(String str) {
        int i2 = i + 95;
        w = i2 % 128;
        int i3 = i2 % 2;
        Object obj = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            Intrinsics.checkNotNull(invoke, "");
            String str2 = (String) invoke;
            int i4 = w + 69;
            i = i4 % 128;
            if ((i4 % 2 == 0 ? '`' : 'W') != '`') {
                return str2;
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    private final String getCurrencyIso4217Code(String str) {
        int i2 = i + 63;
        w = i2 % 128;
        int i3 = i2 % 2;
        String monetizationNetwork = this.areAllFieldsValid.getMonetizationNetwork(str);
        int i4 = i + 3;
        w = i4 % 128;
        if (!(i4 % 2 != 0)) {
            return monetizationNetwork;
        }
        throw null;
    }

    private final String equals() {
        File AFAdRevenueData = AFAdRevenueData(getMediationNetwork("ro.appsflyer.preinstall.path"));
        if ((getMonetizationNetwork(AFAdRevenueData) ? (char) 16 : (char) 7) != 7) {
            AFAdRevenueData = AFAdRevenueData(getCurrencyIso4217Code("AF_PRE_INSTALL_PATH"));
        }
        if ((getMonetizationNetwork(AFAdRevenueData) ? '=' : (char) 11) != 11) {
            AFAdRevenueData = AFAdRevenueData("/data/local/tmp/pre_install.appsflyer");
        }
        if (getMonetizationNetwork(AFAdRevenueData)) {
            AFAdRevenueData = AFAdRevenueData("/etc/pre_install.appsflyer");
            int i2 = i + 51;
            w = i2 % 128;
            int i3 = i2 % 2;
        }
        if (!getMonetizationNetwork(AFAdRevenueData)) {
            String packageName = this.getMediationNetwork.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            return getMonetizationNetwork(AFAdRevenueData, packageName);
        }
        int i4 = w + 101;
        i = i4 % 128;
        int i5 = i4 % 2;
        return null;
    }

    private static File AFAdRevenueData(String str) {
        boolean z;
        if ((str != null ? (char) 15 : (char) 22) != 22) {
            try {
                if (StringsKt.trim((CharSequence) str).toString().length() > 0) {
                    z = true;
                } else {
                    int i2 = w + 3;
                    i = i2 % 128;
                    int i3 = i2 % 2;
                    z = false;
                }
                if (z) {
                    return new File(StringsKt.trim((CharSequence) str).toString());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        }
        int i4 = i + 5;
        w = i4 % 128;
        int i5 = i4 % 2;
        return null;
    }

    private static boolean getMonetizationNetwork(File file) {
        int i2 = i + 93;
        w = i2 % 128;
        int i3 = i2 % 2;
        if ((file != null ? 'D' : Typography.greater) == 'D') {
            if (!(!file.exists())) {
                int i4 = w + 39;
                i = i4 % 128;
                int i5 = i4 % 2;
                return false;
            }
        }
        return true;
    }

    private static String getMonetizationNetwork(File file, String str) {
        Properties properties;
        int i2 = w;
        int i3 = i2 + 87;
        i = i3 % 128;
        if (i3 % 2 == 0) {
            throw null;
        }
        InputStreamReader inputStreamReader = null;
        try {
            try {
                if (file != null) {
                    try {
                        properties = new Properties();
                        inputStreamReader = new InputStreamReader(new FileInputStream(file), Charset.defaultCharset());
                    } catch (FileNotFoundException unused) {
                        inputStreamReader = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = null;
                    }
                    try {
                        properties.load(inputStreamReader);
                        AFLogger.afInfoLog("Found PreInstall property!");
                        String property = properties.getProperty(str);
                        try {
                            inputStreamReader.close();
                        } catch (Throwable th2) {
                            AFLogger.afErrorLog(th2.getMessage(), th2);
                        }
                        return property;
                    } catch (FileNotFoundException unused2) {
                        AFLogger.afDebugLog("PreInstall file wasn't found: " + file.getAbsolutePath());
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        AFLogger.afErrorLog(th.getMessage(), th);
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        return null;
                    }
                }
                int i4 = i2 + 39;
                i = i4 % 128;
                if ((i4 % 2 == 0 ? (char) 11 : 'X') != 'X') {
                    int i5 = 58 / 0;
                }
                return null;
            } catch (Throwable th4) {
                AFLogger.afErrorLog(th4.getMessage(), th4);
            }
        } catch (Throwable th5) {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th6) {
                    AFLogger.afErrorLog(th6.getMessage(), th6);
                }
            }
            throw th5;
        }
    }

    private static void AFAdRevenueData(Map<String, Object> map, AFh1jSDK aFh1jSDK) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        String str = aFh1jSDK.component4;
        if (str != null) {
            map.put("eventName", str);
            map.put("eventValue", new JSONObject(aFh1jSDK.AFAdRevenueData == null ? new HashMap() : aFh1jSDK.AFAdRevenueData).toString());
        }
    }

    private final boolean copy() {
        return ((Boolean) getMediationNetwork(new Object[]{this}, -932948428, 932948439, System.identityHashCode(this))).booleanValue();
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final void getMonetizationNetwork(Map<String, Object> map, AFe1mSDK aFe1mSDK) {
        getMediationNetwork(new Object[]{this, map, aFe1mSDK}, -1926240735, 1926240745, System.identityHashCode(this));
    }

    private static void unregisterClient(Map<String, Object> map) {
        getMediationNetwork(new Object[]{map}, -43428876, 43428885, (int) System.currentTimeMillis());
    }

    private void AFInAppEventType(Map<String, Object> map) {
        getMediationNetwork(new Object[]{this, map}, -2015365334, 2015365335, System.identityHashCode(this));
    }

    private final String component1() {
        return (String) getMediationNetwork(new Object[]{this}, 969328908, -969328900, System.identityHashCode(this));
    }

    private void getCurrencyIso4217Code(Map<String, Object> map, String str) {
        getMediationNetwork(new Object[]{this, map, str}, -361587280, 361587287, System.identityHashCode(this));
    }

    private void getMediationNetwork(Map<String, Object> map, String str) {
        getMediationNetwork(new Object[]{this, map, str}, 1127076864, -1127076862, System.identityHashCode(this));
    }

    private void component2(Map<String, ? extends Object> map) {
        getMediationNetwork(new Object[]{this, map}, -2029029470, 2029029475, System.identityHashCode(this));
    }

    private void component3(Map<String, Object> map) {
        getMediationNetwork(new Object[]{this, map}, 1978462197, -1978462194, System.identityHashCode(this));
    }

    private final void component4(Map<String, Object> map) {
        getMediationNetwork(new Object[]{this, map}, -217749996, 217750002, System.identityHashCode(this));
    }

    private static String component3() {
        return (String) getMediationNetwork(new Object[0], -879088668, 879088672, (int) System.currentTimeMillis());
    }

    private String getRevenue() throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {
        return (String) getMediationNetwork(new Object[]{this}, -1875348758, 1875348758, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFg1rSDK
    public final Long AFAdRevenueData() {
        return (Long) getMediationNetwork(new Object[]{this}, -1521351773, 1521351785, System.identityHashCode(this));
    }
}
