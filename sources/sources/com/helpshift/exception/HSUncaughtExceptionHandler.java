package com.helpshift.exception;

import android.util.Log;
import com.helpshift.Helpshift;
import com.helpshift.log.HSLogger;
import java.lang.Thread;
/* loaded from: classes3.dex */
public class HSUncaughtExceptionHandler {
    private static final String TAG = "UncghtExptnHndlr";

    private HSUncaughtExceptionHandler() {
    }

    public static void init() {
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.helpshift.exception.HSUncaughtExceptionHandler.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (HSUncaughtExceptionHandler.isCausedByHelpshift(th)) {
                    HSLogger.e(HSUncaughtExceptionHandler.TAG, "UNCAUGHT EXCEPTION ", th);
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        });
    }

    static boolean isCausedByHelpshift(Throwable th) {
        if (th == null) {
            return false;
        }
        try {
            return Log.getStackTraceString(th).contains(Helpshift.class.getPackage().getName());
        } catch (Exception e) {
            HSLogger.e(TAG, "Error determining crash from Helpshift", e);
            return false;
        }
    }
}
