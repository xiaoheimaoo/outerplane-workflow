package com.appsflyer.internal;

import android.adservices.measurement.MeasurementManager;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import com.appsflyer.AFLogger;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import kotlin.Pair;
/* loaded from: classes.dex */
public final class AFj1iSDK {
    public static boolean L_(Context context, Intent intent) {
        return context.getPackageManager().queryIntentServices(intent, 0).size() > 0;
    }

    public static boolean AFAdRevenueData(Context context) {
        if (context != null && Build.VERSION.SDK_INT >= 33) {
            try {
                return ((MeasurementManager) context.getApplicationContext().getSystemService(MeasurementManager.class)) != null;
            } catch (Throwable th) {
                AFLogger.INSTANCE.e(AFg1cSDK.PRIVACY_SANDBOX, th.getMessage() != null ? th.getMessage() : "", th, false, false);
            }
        }
        return false;
    }

    public static boolean getMediationNetwork(Context context) {
        if (context != null) {
            try {
                IntegrityManagerFactory.create(context);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean getMonetizationNetwork(Context context) {
        if (context != null) {
            try {
                AppSet.getClient(context);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean getRevenue(Context context) {
        if (context != null) {
            try {
                if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean getMediationNetwork(Context context, String str) {
        int checkPermission = context.checkPermission(str, Process.myPid(), Process.myUid());
        AFLogger.afRDLog(new StringBuilder("is Permission Available: ").append(str).append("; res: ").append(checkPermission).toString());
        return checkPermission == 0;
    }

    public static boolean getMonetizationNetwork() {
        return Build.BRAND.equals("OPPO");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> M_(android.content.pm.PackageInfo r10, java.util.Map<java.lang.String, java.lang.String> r11, android.net.Uri r12) {
        /*
            java.lang.String r0 = "install_time"
            java.util.Set r1 = r12.getQueryParameterNames()
            java.util.Iterator r1 = r1.iterator()
        La:
            boolean r2 = r1.hasNext()
            java.lang.String r3 = "media_source"
            java.lang.String r4 = "agency"
            if (r2 == 0) goto L69
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r5 = r12.getQueryParameter(r2)
            boolean r6 = r11.containsKey(r2)
            if (r6 != 0) goto L64
            int r6 = r2.hashCode()
            r7 = -1420799080(0xffffffffab505398, float:-7.4012454E-13)
            r8 = 2
            r9 = 1
            if (r6 == r7) goto L4d
            r7 = 99
            if (r6 == r7) goto L43
            r7 = 110987(0x1b18b, float:1.55526E-40)
            if (r6 == r7) goto L39
            goto L57
        L39:
            java.lang.String r6 = "pid"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L57
            r6 = r9
            goto L58
        L43:
            java.lang.String r6 = "c"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L57
            r6 = 0
            goto L58
        L4d:
            java.lang.String r6 = "af_prt"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L57
            r6 = r8
            goto L58
        L57:
            r6 = -1
        L58:
            if (r6 == 0) goto L61
            if (r6 == r9) goto L65
            if (r6 == r8) goto L5f
            goto L64
        L5f:
            r3 = r4
            goto L65
        L61:
            java.lang.String r3 = "campaign"
            goto L65
        L64:
            r3 = r2
        L65:
            r11.put(r3, r5)
            goto La
        L69:
            boolean r1 = r11.containsKey(r0)     // Catch: java.lang.Exception -> L90
            if (r1 != 0) goto L96
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch: java.lang.Exception -> L90
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Exception -> L90
            r2.<init>(r1, r5)     // Catch: java.lang.Exception -> L90
            long r5 = r10.firstInstallTime     // Catch: java.lang.Exception -> L90
            java.lang.String r10 = "UTC"
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r10)     // Catch: java.lang.Exception -> L90
            r2.setTimeZone(r10)     // Catch: java.lang.Exception -> L90
            java.util.Date r10 = new java.util.Date     // Catch: java.lang.Exception -> L90
            r10.<init>(r5)     // Catch: java.lang.Exception -> L90
            java.lang.String r10 = r2.format(r10)     // Catch: java.lang.Exception -> L90
            r11.put(r0, r10)     // Catch: java.lang.Exception -> L90
            goto L96
        L90:
            r10 = move-exception
            java.lang.String r0 = "Could not fetch install time. "
            com.appsflyer.AFLogger.afErrorLog(r0, r10)
        L96:
            java.lang.String r10 = "af_deeplink"
            boolean r10 = r11.containsKey(r10)
            if (r10 == 0) goto Lab
            java.lang.String r10 = "af_status"
            boolean r0 = r11.containsKey(r10)
            if (r0 != 0) goto Lab
            java.lang.String r0 = "Non-organic"
            r11.put(r10, r0)
        Lab:
            boolean r10 = r11.containsKey(r4)
            if (r10 == 0) goto Lb4
            r11.remove(r3)
        Lb4:
            java.lang.String r10 = r12.getPath()
            if (r10 == 0) goto Lbf
            java.lang.String r0 = "path"
            r11.put(r0, r10)
        Lbf:
            java.lang.String r10 = r12.getScheme()
            if (r10 == 0) goto Lca
            java.lang.String r0 = "scheme"
            r11.put(r0, r10)
        Lca:
            java.lang.String r10 = r12.getHost()
            if (r10 == 0) goto Ld5
            java.lang.String r12 = "host"
            r11.put(r12, r10)
        Ld5:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1iSDK.M_(android.content.pm.PackageInfo, java.util.Map, android.net.Uri):java.util.Map");
    }

    public static String N_(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        if (signatureArr == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
        messageDigest.update(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded());
        return String.format("%032X", new BigInteger(1, messageDigest.digest()));
    }

    public static long getCurrencyIso4217Code(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return 0L;
        }
    }

    public static String getRevenue(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return "";
        }
    }

    public static Pair<Long, String> getMonetizationNetwork(Context context, String str) {
        long j;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (Build.VERSION.SDK_INT >= 28) {
                j = packageInfo.getLongVersionCode();
            } else {
                j = packageInfo.versionCode;
            }
            return new Pair<>(Long.valueOf(j), packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            return new Pair<>(0L, "");
        }
    }

    public static Application O_(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        if (context instanceof Activity) {
            return ((Activity) context).getApplication();
        }
        try {
            return (Application) context.getApplicationContext();
        } catch (ClassCastException unused) {
            AFLogger.afErrorLog("Application or Activity Context should be used", new IllegalStateException(), true, true);
            return null;
        }
    }
}
