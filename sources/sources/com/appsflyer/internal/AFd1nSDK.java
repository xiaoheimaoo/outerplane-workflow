package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.media.AudioTrack;
import android.os.Build;
import android.view.ViewConfiguration;
import com.appsflyer.AppsFlyerProperties;
import com.singular.sdk.internal.Constants;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFd1nSDK implements AFd1mSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] component2 = null;
    private static int copy = 1;
    private static char equals;
    private static final int getRevenue;
    private static int hashCode;
    private final AFc1bSDK component1;
    private List<String> getCurrencyIso4217Code = new ArrayList();
    private boolean AFAdRevenueData = true;
    private final Map<String, Object> getMediationNetwork = new HashMap();
    private SecureRandom component3 = new SecureRandom();
    private boolean areAllFieldsValid = true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
    private int getMonetizationNetwork = 0;
    private boolean component4 = false;

    public static /* synthetic */ Object AFAdRevenueData(Object[] objArr, int i, int i2, int i3) {
        int i4 = (i * (-755)) + (i2 * (-755));
        int i5 = ~((~i) | (~i2));
        int i6 = i | i2;
        int i7 = i4 + (i5 * 1512) + (((~(i6 | i3)) | i5) * (-756)) + ((i6 | (~i3)) * 756);
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 3) {
                    AFd1nSDK aFd1nSDK = (AFd1nSDK) objArr[0];
                    int i8 = hashCode + 43;
                    copy = i8 % 128;
                    if (i8 % 2 == 0) {
                    }
                    boolean mediationNetwork = aFd1nSDK.component1.component2().getMediationNetwork("participantInProxy", false);
                    int i9 = hashCode + 45;
                    copy = i9 % 128;
                    int i10 = i9 % 2;
                    return Boolean.valueOf(mediationNetwork);
                }
                AFd1nSDK aFd1nSDK2 = (AFd1nSDK) objArr[0];
                String str = (String) objArr[1];
                String str2 = (String) objArr[2];
                int i11 = copy + 45;
                hashCode = i11 % 128;
                if ((i11 % 2 != 0 ? 'P' : '6') != '6') {
                    String[] strArr = new String[0];
                    strArr[0] = str2;
                    aFd1nSDK2.getCurrencyIso4217Code("server_request", str, strArr);
                } else {
                    aFd1nSDK2.getCurrencyIso4217Code("server_request", str, str2);
                }
                return null;
            }
            return getRevenue(objArr);
        }
        return getMediationNetwork(objArr);
    }

    static {
        component2();
        getRevenue = 98166;
        int i = copy + 61;
        hashCode = i % 128;
        int i2 = i % 2;
    }

    public AFd1nSDK(AFc1bSDK aFc1bSDK) {
        this.component1 = aFc1bSDK;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        if ((r0 ? false : true) != true) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
        component3();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
        getMediationNetwork();
        AFAdRevenueData();
        r1 = com.appsflyer.internal.AFd1nSDK.hashCode + 81;
        com.appsflyer.internal.AFd1nSDK.copy = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
        if (r0 != false) goto L10;
     */
    @Override // com.appsflyer.internal.AFd1mSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean getCurrencyIso4217Code() {
        /*
            r3 = this;
            int r0 = com.appsflyer.internal.AFd1nSDK.hashCode
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.appsflyer.internal.AFd1nSDK.copy = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L35
            com.appsflyer.internal.AFc1bSDK r0 = r3.component1
            com.appsflyer.internal.AFf1lSDK r0 = r0.component1()
            com.appsflyer.internal.AFf1iSDK r0 = r0.AFAdRevenueData
            com.appsflyer.internal.AFi1wSDK r0 = r0.AFAdRevenueData
            com.appsflyer.internal.AFi1ySDK r0 = getMonetizationNetwork(r0)
            com.appsflyer.internal.AFc1bSDK r2 = r3.component1
            com.appsflyer.internal.AFf1lSDK r2 = r2.component1()
            com.appsflyer.internal.AFf1iSDK r2 = r2.AFAdRevenueData
            com.appsflyer.internal.AFi1wSDK r2 = r2.getMediationNetwork
            com.appsflyer.internal.AFi1ySDK r2 = getMonetizationNetwork(r2)
            boolean r0 = r3.getCurrencyIso4217Code(r0, r2)
            r2 = 94
            int r2 = r2 / r1
            if (r0 == 0) goto L60
            goto L5c
        L33:
            r0 = move-exception
            throw r0
        L35:
            com.appsflyer.internal.AFc1bSDK r0 = r3.component1
            com.appsflyer.internal.AFf1lSDK r0 = r0.component1()
            com.appsflyer.internal.AFf1iSDK r0 = r0.AFAdRevenueData
            com.appsflyer.internal.AFi1wSDK r0 = r0.AFAdRevenueData
            com.appsflyer.internal.AFi1ySDK r0 = getMonetizationNetwork(r0)
            com.appsflyer.internal.AFc1bSDK r2 = r3.component1
            com.appsflyer.internal.AFf1lSDK r2 = r2.component1()
            com.appsflyer.internal.AFf1iSDK r2 = r2.AFAdRevenueData
            com.appsflyer.internal.AFi1wSDK r2 = r2.getMediationNetwork
            com.appsflyer.internal.AFi1ySDK r2 = getMonetizationNetwork(r2)
            boolean r0 = r3.getCurrencyIso4217Code(r0, r2)
            r2 = 1
            if (r0 == 0) goto L59
            goto L5a
        L59:
            r1 = r2
        L5a:
            if (r1 == r2) goto L60
        L5c:
            r3.component3()
            goto L70
        L60:
            r3.getMediationNetwork()
            r3.AFAdRevenueData()
            int r1 = com.appsflyer.internal.AFd1nSDK.hashCode
            int r1 = r1 + 81
            int r2 = r1 % 128
            com.appsflyer.internal.AFd1nSDK.copy = r2
            int r1 = r1 % 2
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1nSDK.getCurrencyIso4217Code():boolean");
    }

    private synchronized void component3() {
        int i = hashCode;
        int i2 = i + 109;
        copy = i2 % 128;
        int i3 = i2 % 2;
        if (!this.component4) {
            this.component4 = true;
            getCurrencyIso4217Code("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
            return;
        }
        int i4 = i + 103;
        copy = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final synchronized void AFAdRevenueData() {
        if (!(this.component4) && !this.AFAdRevenueData) {
            int i = copy + 93;
            hashCode = i % 128;
            if ((i % 2 != 0 ? '6' : 'T') == '6') {
                throw null;
            }
            return;
        }
        this.component4 = false;
        this.AFAdRevenueData = false;
        getCurrencyIso4217Code("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        int i2 = hashCode + 41;
        copy = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final synchronized void getRevenue() {
        int i = copy + 53;
        hashCode = i % 128;
        int i2 = i % 2;
        this.getMediationNetwork.clear();
        this.getCurrencyIso4217Code.clear();
        this.getMonetizationNetwork = 0;
        int i3 = copy + 125;
        hashCode = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
        if (r7 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ java.lang.Object getMediationNetwork(java.lang.Object[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            com.appsflyer.internal.AFd1nSDK r1 = (com.appsflyer.internal.AFd1nSDK) r1
            r2 = 1
            r2 = r7[r2]
            java.lang.String r2 = (java.lang.String) r2
            r3 = 2
            r7 = r7[r3]
            android.content.pm.PackageManager r7 = (android.content.pm.PackageManager) r7
            int r7 = com.appsflyer.internal.AFd1nSDK.copy
            int r7 = r7 + 61
            int r4 = r7 % 128
            com.appsflyer.internal.AFd1nSDK.hashCode = r4
            int r7 = r7 % r3
            r4 = 92
            if (r7 == 0) goto L1f
            r7 = 53
            goto L20
        L1f:
            r7 = r4
        L20:
            r5 = 0
            if (r7 == r4) goto L43
            java.util.Map r7 = r1.getMonetizationNetwork(r2)     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFc1bSDK r2 = r1.component1     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFf1cSDK r2 = r2.AFKeystoreWrapper()     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = r2.getMediationNetwork()     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFc1bSDK r6 = r1.component1     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFd1lSDK r6 = r6.getRevenue()     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFd1oSDK r7 = r6.getMediationNetwork(r7, r2)     // Catch: java.lang.Throwable -> L41
            r2 = 37
            int r2 = r2 / r0
            if (r7 != 0) goto L6a
            goto L5d
        L41:
            r7 = move-exception
            goto L90
        L43:
            java.util.Map r7 = r1.getMonetizationNetwork(r2)     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFc1bSDK r0 = r1.component1     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFf1cSDK r0 = r0.AFKeystoreWrapper()     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = r0.getMediationNetwork()     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFc1bSDK r2 = r1.component1     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFd1lSDK r2 = r2.getRevenue()     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFd1oSDK r7 = r2.getMediationNetwork(r7, r0)     // Catch: java.lang.Throwable -> L41
            if (r7 != 0) goto L6a
        L5d:
            java.lang.String r7 = "could not send null proxy data"
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = "request was null"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L41
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r7, r0)     // Catch: java.lang.Throwable -> L41
            return r5
        L6a:
            com.appsflyer.internal.AFc1bSDK r0 = r1.component1     // Catch: java.lang.Throwable -> L41
            java.util.concurrent.ExecutorService r0 = r0.getMediationNetwork()     // Catch: java.lang.Throwable -> L41
            java.util.Objects.requireNonNull(r7)     // Catch: java.lang.Throwable -> L41
            com.appsflyer.internal.AFd1nSDK$$ExternalSyntheticLambda0 r1 = new com.appsflyer.internal.AFd1nSDK$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L41
            r1.<init>()     // Catch: java.lang.Throwable -> L41
            r0.execute(r1)     // Catch: java.lang.Throwable -> L41
            int r7 = com.appsflyer.internal.AFd1nSDK.hashCode
            int r7 = r7 + 75
            int r0 = r7 % 128
            com.appsflyer.internal.AFd1nSDK.copy = r0
            int r7 = r7 % r3
            if (r7 != 0) goto L89
            r7 = 32
            goto L8a
        L89:
            r7 = r4
        L8a:
            if (r7 != r4) goto L8d
            return r5
        L8d:
            throw r5     // Catch: java.lang.Throwable -> L8e
        L8e:
            r7 = move-exception
            throw r7
        L90:
            java.lang.String r0 = "could not send proxy data"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1nSDK.getMediationNetwork(java.lang.Object[]):java.lang.Object");
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final void getCurrencyIso4217Code(String str, String... strArr) {
        int i = hashCode + 105;
        copy = i % 128;
        if ((i % 2 == 0 ? Typography.less : 'Q') != 'Q') {
            getCurrencyIso4217Code("public_api_call", str, strArr);
            int i2 = 57 / 0;
            return;
        }
        getCurrencyIso4217Code("public_api_call", str, strArr);
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final void getMonetizationNetwork(Throwable th) {
        String message;
        int i = copy + 21;
        hashCode = i % 128;
        int i2 = i % 2;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        if (cause == null) {
            message = th.getMessage();
        } else {
            message = cause.getMessage();
            int i3 = hashCode + 61;
            copy = i3 % 128;
            int i4 = i3 % 2;
        }
        getCurrencyIso4217Code("exception", simpleName, getMediationNetwork(message, (cause == null ? (char) 3 : '?') != 3 ? cause.getStackTrace() : th.getStackTrace()));
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final void getMonetizationNetwork(String str, int i, String str2) {
        int i2 = copy + 111;
        hashCode = i2 % 128;
        int i3 = i2 % 2;
        getCurrencyIso4217Code("server_response", str, String.valueOf(i), str2);
        int i4 = hashCode + 5;
        copy = i4 % 128;
        if (!(i4 % 2 == 0)) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final void getRevenue(String str, String str2) {
        int i = copy + 3;
        hashCode = i % 128;
        if (i % 2 == 0) {
            getCurrencyIso4217Code(null, str, str2);
        } else {
            String[] strArr = new String[0];
            strArr[0] = str2;
            getCurrencyIso4217Code(null, str, strArr);
        }
        int i2 = hashCode + 61;
        copy = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int i3 = 81 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r12 = r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(byte r11, java.lang.String r12, int r13, java.lang.Object[] r14) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1nSDK.a(byte, java.lang.String, int, java.lang.Object[]):void");
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final synchronized void getMediationNetwork() {
        int i = copy + 13;
        hashCode = i % 128;
        if ((i % 2 != 0 ? '\'' : (char) 25) != '\'') {
            this.AFAdRevenueData = false;
            getRevenue();
        } else {
            this.AFAdRevenueData = false;
            getRevenue();
        }
        copydefault();
        int i2 = copy + 81;
        hashCode = i2 % 128;
        if ((i2 % 2 != 0 ? 'L' : '(') != '(') {
            int i3 = 88 / 0;
        }
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final void getMonetizationNetwork() {
        int i = copy + 83;
        int i2 = i % 128;
        hashCode = i2;
        int i3 = i % 2;
        this.areAllFieldsValid = false;
        int i4 = i2 + 99;
        copy = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final boolean areAllFieldsValid() {
        int i = copy + 17;
        int i2 = i % 128;
        hashCode = i2;
        int i3 = i % 2;
        boolean z = this.component4;
        int i4 = i2 + 47;
        copy = i4 % 128;
        int i5 = i4 % 2;
        return z;
    }

    private float component1() {
        int i = copy + 29;
        hashCode = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? '!' : (char) 11) == '!') {
            this.component3.nextFloat();
            obj.hashCode();
            throw null;
        }
        float nextFloat = this.component3.nextFloat();
        int i2 = copy + 123;
        hashCode = i2 % 128;
        if (i2 % 2 == 0) {
            return nextFloat;
        }
        obj.hashCode();
        throw null;
    }

    private Map<String, Object> getMonetizationNetwork(String str) {
        int i = copy + 39;
        hashCode = i % 128;
        int i2 = i % 2;
        getMonetizationNetwork(str, this.component1.AFKeystoreWrapper(), this.component1.afInfoLog());
        Map<String, Object> equals2 = equals();
        int i3 = hashCode + 45;
        copy = i3 % 128;
        if (i3 % 2 != 0) {
            return equals2;
        }
        int i4 = 30 / 0;
        return equals2;
    }

    private static String component4() {
        int i = copy + 23;
        int i2 = i % 128;
        hashCode = i2;
        int i3 = i % 2;
        int i4 = i2 + 103;
        copy = i4 % 128;
        if ((i4 % 2 == 0 ? 'E' : '[') != '[') {
            int i5 = 65 / 0;
            return "6.17.3";
        }
        return "6.17.3";
    }

    private boolean copy() {
        if (this.areAllFieldsValid) {
            int i = copy;
            int i2 = i + 91;
            hashCode = i2 % 128;
            int i3 = i2 % 2;
            if ((!this.AFAdRevenueData ? Typography.quote : (char) 5) != 5) {
                int i4 = i + 111;
                hashCode = i4 % 128;
                if (i4 % 2 != 0) {
                    throw null;
                }
                if (!(this.component4)) {
                }
            }
            return true;
        }
        return false;
    }

    private synchronized void getRevenue(String str, String str2, String str3) {
        try {
            Map<String, Object> map = this.getMediationNetwork;
            Object[] objArr = new Object[1];
            a((byte) (114 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), "\u0002\b\u0007\u0003㙰", 6 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr);
            map.put(((String) objArr[0]).intern(), Build.BRAND);
            this.getMediationNetwork.put("model", Build.MODEL);
            this.getMediationNetwork.put("platform", Constants.PLATFORM);
            this.getMediationNetwork.put("platform_version", Build.VERSION.RELEASE);
            if (str != null) {
                try {
                    int i = copy + 43;
                    hashCode = i % 128;
                    int i2 = i % 2;
                    if (!(str.length() <= 0)) {
                        int i3 = copy + 45;
                        hashCode = i3 % 128;
                        int i4 = i3 % 2;
                        this.getMediationNetwork.put("advertiserId", str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if ((str2 != null) && str2.length() > 0) {
                this.getMediationNetwork.put(Constants.DeviceIdentifierKeyspaceKeys.IMEI_KEYSPACE_KEY, str2);
            }
            if ((str3 != null ? 'a' : '*') != '*') {
                int i5 = hashCode + 49;
                copy = i5 % 128;
                int i6 = i5 % 2;
                if (str3.length() > 0) {
                    this.getMediationNetwork.put("android_id", str3);
                    int i7 = hashCode + 63;
                    copy = i7 % 128;
                    int i8 = i7 % 2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void getRevenue(String str, String str2, String str3, String str4) {
        int i = copy + 11;
        hashCode = i % 128;
        int i2 = i % 2;
        try {
            this.getMediationNetwork.put("sdk_version", str);
            if (str2 != null) {
                int i3 = hashCode + 109;
                copy = i3 % 128;
                int i4 = i3 % 2;
                if (str2.length() > 0) {
                    int i5 = copy + 101;
                    hashCode = i5 % 128;
                    if (i5 % 2 == 0) {
                        this.getMediationNetwork.put("devkey", str2);
                    } else {
                        this.getMediationNetwork.put("devkey", str2);
                        throw null;
                    }
                }
            }
            if ((str3 != null ? '*' : (char) 20) != 20 && str3.length() > 0) {
                this.getMediationNetwork.put("originalAppsFlyerId", str3);
            }
            if (str4 != null) {
                if (!(str4.length() <= 0)) {
                    this.getMediationNetwork.put("uid", str4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void getCurrencyIso4217Code(String str, String str2, String str3, String str4) {
        int i = hashCode + 35;
        copy = i % 128;
        int i2 = i % 2;
        if (str != null) {
            try {
                if (!(str.length() <= 0)) {
                    int i3 = hashCode + 7;
                    copy = i3 % 128;
                    int i4 = i3 % 2;
                    this.getMediationNetwork.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        char c = 'M';
        if ((str2 != null) && str2.length() > 0) {
            this.getMediationNetwork.put("app_version", str2);
            int i5 = hashCode + 77;
            copy = i5 % 128;
            if (i5 % 2 == 0) {
            }
        }
        if (str3 == null) {
            c = 'Y';
        }
        if (c != 'Y') {
            int i6 = copy + 63;
            hashCode = i6 % 128;
            int i7 = i6 % 2;
            if (!(str3.length() <= 0)) {
                int i8 = hashCode + 35;
                copy = i8 % 128;
                int i9 = i8 % 2;
                this.getMediationNetwork.put(AppsFlyerProperties.CHANNEL, str3);
            }
        }
        if (str4 != null && str4.length() > 0) {
            this.getMediationNetwork.put("preInstall", str4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r5.getMonetizationNetwork >= 98304) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r5.getMonetizationNetwork >= 98304) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        r0 = java.lang.System.currentTimeMillis();
        r8 = android.text.TextUtils.join(", ", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r6 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
        r6 = new java.lang.StringBuilder().append(r0).append(" ").append(java.lang.Thread.currentThread().getId()).append(" _/AppsFlyer_6.17.3 [").append(r6).append("] ").append(r7).append(" ").append(r8).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
        r6 = new java.lang.StringBuilder().append(r0).append(" ").append(java.lang.Thread.currentThread().getId()).append(" ").append(r7).append("/AppsFlyer_6.17.3 ").append(r8).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a5, code lost:
        r7 = r5.getMonetizationNetwork + (r6.length() << 1);
        r8 = com.appsflyer.internal.AFd1nSDK.getRevenue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b0, code lost:
        if (r7 <= r8) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b2, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b4, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b5, code lost:
        if (r7 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b7, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b9, code lost:
        r6 = r6.substring(0, (r8 - r5.getMonetizationNetwork) / 2);
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c3, code lost:
        r5.getCurrencyIso4217Code.add(r6);
        r5.getMonetizationNetwork += r6.length() << 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d2, code lost:
        if (r7 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d5, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d6, code lost:
        if (r2 == true) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d8, code lost:
        r6 = com.appsflyer.internal.AFd1nSDK.hashCode + 101;
        com.appsflyer.internal.AFd1nSDK.copy = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e4, code lost:
        if ((r6 % 2) != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e6, code lost:
        r6 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e8, code lost:
        r6 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ea, code lost:
        if (r6 == 30) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ec, code lost:
        r5.getCurrencyIso4217Code.add("+~+~ The limit has been exceeded, and no more data is available. +~+~");
        r5.getMonetizationNetwork += 138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fa, code lost:
        r5.getCurrencyIso4217Code.add("+~+~ The limit has been exceeded, and no more data is available. +~+~");
        r5.getMonetizationNetwork *= 10496;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0107, code lost:
        r6 = com.appsflyer.internal.AFd1nSDK.hashCode + 11;
        com.appsflyer.internal.AFd1nSDK.copy = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0114, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void getCurrencyIso4217Code(java.lang.String r6, java.lang.String r7, java.lang.String... r8) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1nSDK.getCurrencyIso4217Code(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    private synchronized Map<String, Object> equals() {
        int i = copy + 47;
        hashCode = i % 128;
        if ((i % 2 != 0 ? '+' : '-') == '-') {
            this.getMediationNetwork.put("data", this.getCurrencyIso4217Code);
            copydefault();
        } else {
            this.getMediationNetwork.put("data", this.getCurrencyIso4217Code);
            copydefault();
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        return this.getMediationNetwork;
    }

    private synchronized void getMonetizationNetwork(String str, AFf1cSDK aFf1cSDK, AFc1eSDK aFc1eSDK) {
        AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
        String string = appsFlyerProperties.getString("remote_debug_static_data");
        this.getMediationNetwork.clear();
        if (string != null) {
            try {
                this.getMediationNetwork.putAll(AFg1hSDK.getMonetizationNetwork(new JSONObject(string)));
                int i = hashCode + 49;
                copy = i % 128;
                if (i % 2 == 0) {
                }
            } catch (Throwable unused) {
            }
        } else {
            getRevenue(this.component1.getCurrencyIso4217Code().component4(), aFf1cSDK.getCurrencyIso4217Code(), aFc1eSDK.AFAdRevenueData);
            getRevenue(new StringBuilder("6.17.3.").append(AFa1uSDK.getRevenue).toString(), this.component1.AFKeystoreWrapper().getMediationNetwork(), appsFlyerProperties.getString("KSAppsFlyerId"), AFb1jSDK.getRevenue(this.component1.getCurrencyIso4217Code().getMonetizationNetwork));
            try {
                int i2 = this.component1.getCurrencyIso4217Code().n_().versionCode;
                getCurrencyIso4217Code(str, String.valueOf(i2), appsFlyerProperties.getString(AppsFlyerProperties.CHANNEL), appsFlyerProperties.getString("preInstallName"));
            } catch (Throwable unused2) {
            }
            appsFlyerProperties.set("remote_debug_static_data", new JSONObject(this.getMediationNetwork).toString());
        }
        this.getMediationNetwork.put("launch_counter", String.valueOf(this.component1.getCurrencyIso4217Code().getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0)));
        int i3 = hashCode + 17;
        copy = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
        if ((r6 != null) != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        r0 = new java.lang.String[r6.length + 1];
        r0[0] = r5;
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
        if (r5 >= r6.length) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
        r3 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        r3 = 'E';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        if (r3 == 'E') goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
        r0[r5] = r6[r5].toString();
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
        r5 = com.appsflyer.internal.AFd1nSDK.copy + 17;
        com.appsflyer.internal.AFd1nSDK.hashCode = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        if ((r5 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r5 == true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
        r5 = 26 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
        return new java.lang.String[]{r5};
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
        if (r6 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String[] getMediationNetwork(java.lang.String r5, java.lang.StackTraceElement[] r6) {
        /*
            int r0 = com.appsflyer.internal.AFd1nSDK.copy
            int r0 = r0 + 49
            int r1 = r0 % 128
            com.appsflyer.internal.AFd1nSDK.hashCode = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L16
            r0 = 54
            int r0 = r0 / r1
            if (r6 != 0) goto L1d
            goto L52
        L14:
            r5 = move-exception
            throw r5
        L16:
            if (r6 != 0) goto L1a
            r0 = r1
            goto L1b
        L1a:
            r0 = r2
        L1b:
            if (r0 == 0) goto L52
        L1d:
            int r0 = r6.length
            int r0 = r0 + r2
            java.lang.String[] r0 = new java.lang.String[r0]
            r0[r1] = r5
            r5 = r2
        L24:
            int r3 = r6.length
            r4 = 69
            if (r5 >= r3) goto L2c
            r3 = 58
            goto L2d
        L2c:
            r3 = r4
        L2d:
            if (r3 == r4) goto L3a
            r3 = r6[r5]
            java.lang.String r3 = r3.toString()
            r0[r5] = r3
            int r5 = r5 + 1
            goto L24
        L3a:
            int r5 = com.appsflyer.internal.AFd1nSDK.copy
            int r5 = r5 + 17
            int r6 = r5 % 128
            com.appsflyer.internal.AFd1nSDK.hashCode = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L48
            r5 = r1
            goto L49
        L48:
            r5 = r2
        L49:
            if (r5 == r2) goto L51
            r5 = 26
            int r5 = r5 / r1
            return r0
        L4f:
            r5 = move-exception
            throw r5
        L51:
            return r0
        L52:
            java.lang.String[] r6 = new java.lang.String[r2]
            r6[r1] = r5
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1nSDK.getMediationNetwork(java.lang.String, java.lang.StackTraceElement[]):java.lang.String[]");
    }

    private synchronized void copydefault() {
        this.getCurrencyIso4217Code = new ArrayList();
        this.getMonetizationNetwork = 0;
        int i = copy + 43;
        hashCode = i % 128;
        int i2 = i % 2;
    }

    private synchronized boolean getCurrencyIso4217Code(AFi1ySDK aFi1ySDK, AFi1ySDK aFi1ySDK2) {
        boolean z;
        boolean z2 = true;
        if (aFi1ySDK == null) {
            int i = hashCode + 9;
            copy = i % 128;
            if (i % 2 == 0) {
                AFAdRevenueData(new Object[]{this}, -788691882, 788691884, System.identityHashCode(this));
            } else {
                AFAdRevenueData(new Object[]{this}, -788691882, 788691884, System.identityHashCode(this));
                z2 = false;
            }
            int i2 = hashCode + 45;
            copy = i2 % 128;
            int i3 = i2 % 2;
            return z2;
        }
        if (!(aFi1ySDK.getMonetizationNetwork())) {
            int i4 = hashCode + 99;
            copy = i4 % 128;
            if (i4 % 2 != 0) {
            }
            return false;
        }
        if ((this.component1.getCurrencyIso4217Code().getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0) <= aFi1ySDK.getCurrencyIso4217Code ? '=' : (char) 5) != '=') {
            z = false;
        } else {
            int i5 = hashCode + 25;
            copy = i5 % 128;
            int i6 = i5 % 2;
            z = true;
        }
        if (!z) {
            int i7 = hashCode + 47;
            copy = i7 % 128;
            int i8 = i7 % 2;
            return false;
        } else if (getRevenue(aFi1ySDK, aFi1ySDK2)) {
            if (getMediationNetwork(aFi1ySDK.getMonetizationNetwork)) {
                return getCurrencyIso4217Code(aFi1ySDK.component3);
            }
            return false;
        } else {
            return false;
        }
    }

    private boolean getRevenue(AFi1ySDK aFi1ySDK, AFi1ySDK aFi1ySDK2) {
        boolean currencyIso4217Code;
        if (!aFi1ySDK.equals(aFi1ySDK2)) {
            currencyIso4217Code = getCurrencyIso4217Code(aFi1ySDK.AFAdRevenueData);
            getMonetizationNetwork(currencyIso4217Code);
        } else {
            int i = hashCode + 51;
            copy = i % 128;
            if ((i % 2 == 0 ? ')' : '(') != '(') {
                AFInAppEventParameterName();
                throw null;
            }
            currencyIso4217Code = AFInAppEventParameterName();
        }
        int i2 = copy + 61;
        hashCode = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 53 / 0;
            return currencyIso4217Code;
        }
        return currencyIso4217Code;
    }

    private static boolean getCurrencyIso4217Code(String str) {
        int i = copy + 45;
        hashCode = i % 128;
        int i2 = i % 2;
        if ((AFk1xSDK.getMonetizationNetwork(str) ? (char) 26 : '0') != 26) {
            new AFd1sSDK();
            return AFd1sSDK.getCurrencyIso4217Code(component4(), str);
        }
        int i3 = hashCode + 43;
        copy = i3 % 128;
        int i4 = i3 % 2;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        if ((com.appsflyer.internal.AFk1xSDK.getMonetizationNetwork(r5) ? 25 : 'I') != 'I') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (com.appsflyer.internal.AFk1xSDK.getMonetizationNetwork(r5) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        r5 = com.appsflyer.internal.AFd1nSDK.copy + 29;
        com.appsflyer.internal.AFd1nSDK.hashCode = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
        if ((r5 % 2) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        r5 = r5.equals(r4.component1.getCurrencyIso4217Code().n_().versionName);
        r0 = com.appsflyer.internal.AFd1nSDK.hashCode + 123;
        com.appsflyer.internal.AFd1nSDK.copy = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean getMediationNetwork(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = com.appsflyer.internal.AFd1nSDK.hashCode
            int r0 = r0 + 97
            int r1 = r0 % 128
            com.appsflyer.internal.AFd1nSDK.copy = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            if (r0 == r2) goto L27
            boolean r0 = com.appsflyer.internal.AFk1xSDK.getMonetizationNetwork(r5)
            r3 = 55
            int r3 = r3 / r1
            r3 = 73
            if (r0 == 0) goto L21
            r0 = 25
            goto L22
        L21:
            r0 = r3
        L22:
            if (r0 == r3) goto L3b
            goto L2d
        L25:
            r5 = move-exception
            throw r5
        L27:
            boolean r0 = com.appsflyer.internal.AFk1xSDK.getMonetizationNetwork(r5)
            if (r0 == 0) goto L3b
        L2d:
            int r5 = com.appsflyer.internal.AFd1nSDK.copy
            int r5 = r5 + 29
            int r0 = r5 % 128
            com.appsflyer.internal.AFd1nSDK.hashCode = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L3a
            return r1
        L3a:
            return r2
        L3b:
            com.appsflyer.internal.AFc1bSDK r0 = r4.component1
            com.appsflyer.internal.AFc1pSDK r0 = r0.getCurrencyIso4217Code()
            android.content.pm.PackageInfo r0 = r0.n_()
            java.lang.String r0 = r0.versionName
            boolean r5 = r5.equals(r0)
            int r0 = com.appsflyer.internal.AFd1nSDK.hashCode
            int r0 = r0 + 123
            int r1 = r0 % 128
            com.appsflyer.internal.AFd1nSDK.copy = r1
            int r0 = r0 % 2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1nSDK.getMediationNetwork(java.lang.String):boolean");
    }

    private boolean getCurrencyIso4217Code(float f) {
        int i = hashCode;
        int i2 = i + 39;
        copy = i2 % 128;
        int i3 = i2 % 2;
        double d = f;
        if (d >= 1.0d) {
            return true;
        }
        if (d > 0.0d) {
            if (component1() <= f) {
                int i4 = hashCode + 123;
                copy = i4 % 128;
                return i4 % 2 != 0;
            }
            return false;
        }
        int i5 = i + 121;
        copy = i5 % 128;
        return i5 % 2 == 0;
    }

    private static AFi1ySDK getMonetizationNetwork(AFi1wSDK aFi1wSDK) {
        AFi1zSDK aFi1zSDK;
        int i = hashCode + 65;
        copy = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            obj.hashCode();
            throw null;
        }
        if (!(aFi1wSDK != null) || (aFi1zSDK = aFi1wSDK.getMonetizationNetwork) == null) {
            int i2 = copy + 85;
            hashCode = i2 % 128;
            int i3 = i2 % 2;
            return null;
        }
        return aFi1zSDK.getMediationNetwork;
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFd1nSDK aFd1nSDK = (AFd1nSDK) objArr[0];
        int i = hashCode + 33;
        copy = i % 128;
        if (i % 2 == 0) {
            aFd1nSDK.component1.component2().getCurrencyIso4217Code("participantInProxy");
            int i2 = 63 / 0;
            return null;
        }
        aFd1nSDK.component1.component2().getCurrencyIso4217Code("participantInProxy");
        return null;
    }

    private void getMonetizationNetwork(boolean z) {
        int i = hashCode + 47;
        copy = i % 128;
        int i2 = i % 2;
        this.component1.component2().getCurrencyIso4217Code("participantInProxy", z);
        int i3 = copy + 39;
        hashCode = i3 % 128;
        if ((i3 % 2 != 0 ? '8' : '2') == '2') {
            return;
        }
        throw null;
    }

    static void component2() {
        component2 = new char[]{58256, 58263, 54893, 58257, 54887, 54907, 54888, 58258, 54891};
        equals = (char) 58256;
    }

    private boolean AFInAppEventParameterName() {
        return ((Boolean) AFAdRevenueData(new Object[]{this}, 59516456, -59516456, System.identityHashCode(this))).booleanValue();
    }

    private void AFKeystoreWrapper() {
        AFAdRevenueData(new Object[]{this}, -788691882, 788691884, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final void getMonetizationNetwork(String str, String str2) {
        AFAdRevenueData(new Object[]{this, str, str2}, 115232387, -115232384, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFd1mSDK
    public final void q_(String str, PackageManager packageManager) {
        AFAdRevenueData(new Object[]{this, str, packageManager}, 389372347, -389372346, System.identityHashCode(this));
    }
}
