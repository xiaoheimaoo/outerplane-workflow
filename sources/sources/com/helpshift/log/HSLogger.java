package com.helpshift.log;
/* loaded from: classes3.dex */
public class HSLogger {
    private static ILogger logger;

    private HSLogger() {
    }

    public static void initLogger(ILogger iLogger) {
        logger = iLogger;
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        if (iLogger == null) {
            return;
        }
        iLogger.d(str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        if (iLogger == null) {
            return;
        }
        iLogger.w(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        if (iLogger == null) {
            return;
        }
        iLogger.e(str, str2, th);
    }
}
