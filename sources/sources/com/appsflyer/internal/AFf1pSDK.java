package com.appsflyer.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
/* loaded from: classes.dex */
public final class AFf1pSDK extends AFf1uSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFInAppEventParameterName = 1760829264;
    private static int AFInAppEventType = 2059786070;
    private static byte[] AFKeystoreWrapper = {-102, 97, -125, 124, 108};
    private static short[] AFLogger = null;
    private static int d = 0;
    private static int registerClient = -1524191679;
    private static int unregisterClient = 1;
    private final AFc1pSDK copydefault;
    private final AFg1rSDK equals;
    private final String hashCode;
    private final AFc1gSDK toString;

    public static /* synthetic */ Object getMediationNetwork(Object[] objArr, int i, int i2, int i3) {
        int i4 = ~i2;
        int i5 = (i * 319) + (i2 * (-317)) + (((~((~i) | i3)) | i4) * (-318));
        int i6 = ~(i4 | i3);
        int i7 = ~i3;
        return (i5 + ((i6 | (~((i7 | i) | i2))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)) + (((~((i | i2) | i3)) | (~((i4 | i7) | i))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) != 1 ? getMonetizationNetwork(objArr) : getMediationNetwork(objArr);
    }

    public AFf1pSDK(String str, AFc1bSDK aFc1bSDK) {
        super(new AFg1uSDK(), aFc1bSDK, str);
        this.copydefault = aFc1bSDK.getCurrencyIso4217Code();
        this.toString = aFc1bSDK.registerClient();
        this.hashCode = str;
        this.equals = aFc1bSDK.component4();
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final void getRevenue() {
        int i = unregisterClient + 55;
        d = i % 128;
        int i2 = i % 2;
        super.getRevenue();
        ResponseNetwork responseNetwork = ((AFe1eSDK) this).component3;
        if ((responseNetwork != null ? 'H' : (char) 29) == 'H') {
            if ((responseNetwork.isSuccessful() ? 'M' : '6') == 'M') {
                equals();
            }
        }
        int i3 = d + 49;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r0 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r3.getRevenue() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        r13.getMonetizationNetwork("app_version_code", java.lang.Integer.toString(r12.copydefault.n_().versionCode));
        r13.getMonetizationNetwork("app_version_name", r12.copydefault.n_().versionName);
        r13.getMonetizationNetwork("app_name", (java.lang.String) getMediationNetwork(new java.lang.Object[]{r12, r0.getPackageManager()}, -182789500, 182789500, java.lang.System.identityHashCode(r12)));
        r13.getMonetizationNetwork("installDate", com.appsflyer.internal.AFa1uSDK.getMediationNetwork(new java.text.SimpleDateFormat("yyyy-MM-dd_HHmmssZ", java.util.Locale.US), r12.copydefault.n_().firstInstallTime));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008c, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008d, code lost:
        com.appsflyer.AFLogger.afErrorLog("Exception while collecting application version info.", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x019c, code lost:
        com.appsflyer.AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01a8, code lost:
        throw new java.lang.IllegalStateException("CustomerUserId not set, register is not sent");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b0, code lost:
        throw new java.lang.IllegalStateException("Context is not provided, can't send register request");
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0 != null) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // com.appsflyer.internal.AFf1uSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void getMediationNetwork(com.appsflyer.internal.AFh1jSDK r13) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1pSDK.getMediationNetwork(com.appsflyer.internal.AFh1jSDK):void");
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        PackageManager packageManager = (PackageManager) objArr[1];
        ApplicationInfo applicationInfo = ((AFf1pSDK) objArr[0]).copydefault.n_().applicationInfo;
        Object obj = null;
        if (applicationInfo == null) {
            int i = unregisterClient + 103;
            d = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
            return "";
        }
        String obj2 = packageManager.getApplicationLabel(applicationInfo).toString();
        int i2 = d + 73;
        unregisterClient = i2 % 128;
        if (i2 % 2 != 0) {
            return obj2;
        }
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.internal.AFf1uSDK
    protected final void areAllFieldsValid(AFh1jSDK aFh1jSDK) {
        int i = unregisterClient + 23;
        d = i % 128;
        if ((i % 2 != 0 ? 'E' : '!') == '!') {
            String component4 = this.copydefault.component4();
            if (component4 != null) {
                aFh1jSDK.getMonetizationNetwork("advertiserId", component4);
                int i2 = d + 35;
                unregisterClient = i2 % 128;
                int i3 = i2 % 2;
                return;
            }
            return;
        }
        this.copydefault.component4();
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFf1pSDK aFf1pSDK = (AFf1pSDK) objArr[0];
        int i = d + 35;
        int i2 = i % 128;
        unregisterClient = i2;
        int i3 = i % 2;
        int i4 = i2 + 69;
        d = i4 % 128;
        if (!(i4 % 2 == 0)) {
            int i5 = 75 / 0;
            return false;
        }
        return false;
    }

    private void equals() {
        int i = d + 41;
        unregisterClient = i % 128;
        int i2 = i % 2;
        ((AFf1uSDK) this).areAllFieldsValid.getCurrencyIso4217Code("sentRegisterRequestToAF", true);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
        int i3 = d + 9;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.internal.AFf1uSDK
    protected final void getRevenue(AFh1jSDK aFh1jSDK) {
        int i = unregisterClient + 7;
        d = i % 128;
        if ((i % 2 != 0 ? '_' : (char) 15) == 15) {
            return;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(int r13, byte r14, short r15, int r16, int r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1pSDK.a(int, byte, short, int, int, java.lang.Object[]):void");
    }

    @Override // com.appsflyer.internal.AFf1uSDK
    protected final void getCurrencyIso4217Code(AFh1jSDK aFh1jSDK) {
        int i = unregisterClient + 53;
        d = i % 128;
        int i2 = i % 2;
    }

    @Override // com.appsflyer.internal.AFf1uSDK
    protected final void getMonetizationNetwork(AFh1jSDK aFh1jSDK) {
        int i = d + 103;
        unregisterClient = i % 128;
        int i2 = i % 2;
    }

    @Override // com.appsflyer.internal.AFf1uSDK
    protected final void AFAdRevenueData(AFh1jSDK aFh1jSDK) {
        int i = unregisterClient + 29;
        d = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFf1uSDK, com.appsflyer.internal.AFe1eSDK
    protected final boolean copydefault() {
        return ((Boolean) getMediationNetwork(new Object[]{this}, 222839034, -222839033, System.identityHashCode(this))).booleanValue();
    }

    private String s_(PackageManager packageManager) {
        return (String) getMediationNetwork(new Object[]{this, packageManager}, -182789500, 182789500, System.identityHashCode(this));
    }
}
