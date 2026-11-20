package com.vagames.security;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
/* loaded from: classes3.dex */
public class SecurityNative {
    private static final String SECRET_SALT = "bkrnuqtfvucoqikfavwebtkmo";

    private static String getSigningCertSha256Fingerprint(Context context) {
        Signature[] signatureArr;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 134217728);
                if (packageInfo.signingInfo == null) {
                    return "";
                }
                signatureArr = packageInfo.signingInfo.getApkContentsSigners();
            } else {
                signatureArr = packageManager.getPackageInfo(packageName, 64).signatures;
            }
            if (signatureArr != null && signatureArr.length != 0) {
                return bytesToHexNoColon(MessageDigest.getInstance("SHA-256").digest(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded()));
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String bytesToHexNoColon(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }

    private static String bytesToHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", Integer.valueOf(bArr[i] & 255)));
        }
        return sb.toString();
    }

    private static String sha256(String str) {
        try {
            return bytesToHex(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    private static String sha256Hex(byte[] bArr) throws Exception {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(bArr);
        StringBuilder sb = new StringBuilder();
        int length = digest.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(digest[i])));
        }
        return sb.toString();
    }

    public static String getClientToken(Context context, String str) {
        if (context == null || str == null) {
            return "";
        }
        String packageName = getPackageName(context);
        return sha256((packageName + ":" + str + ":bkrnuqtfvucoqikfavwe:" + getSigningCertSha256Fingerprint(context)).toLowerCase());
    }
}
