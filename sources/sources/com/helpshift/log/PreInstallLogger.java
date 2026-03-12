package com.helpshift.log;

import android.util.Log;
import com.helpshift.log.ILogger;
/* loaded from: classes3.dex */
public class PreInstallLogger implements ILogger {
    private static final String TAG = "PreInstallLogger";
    private final boolean isApplicationInDebugMode;

    public PreInstallLogger(boolean z) {
        this.isApplicationInDebugMode = z;
    }

    @Override // com.helpshift.log.ILogger
    public void d(String str, String str2) {
        d(str, str2, null);
    }

    @Override // com.helpshift.log.ILogger
    public void w(String str, String str2) {
        w(str, str2, null);
    }

    @Override // com.helpshift.log.ILogger
    public void e(String str, String str2) {
        e(str, str2, null);
    }

    @Override // com.helpshift.log.ILogger
    public void d(String str, String str2, Throwable th) {
        logMessage(ILogger.LEVEL.DEBUG, str, str2, th);
    }

    @Override // com.helpshift.log.ILogger
    public void w(String str, String str2, Throwable th) {
        logMessage(ILogger.LEVEL.WARN, str, str2, th);
    }

    @Override // com.helpshift.log.ILogger
    public void e(String str, String str2, Throwable th) {
        logMessage(ILogger.LEVEL.ERROR, str, str2, th);
    }

    private void logMessage(ILogger.LEVEL level, String str, String str2, Throwable th) {
        String str3 = str + " : " + str2;
        int i = AnonymousClass1.$SwitchMap$com$helpshift$log$ILogger$LEVEL[level.ordinal()];
        if (i == 1) {
            Log.e(TAG, str3, th);
        } else if (i == 2) {
            Log.w(TAG, str3, th);
        } else if (i == 3 && this.isApplicationInDebugMode) {
            Log.d(TAG, str3, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.helpshift.log.PreInstallLogger$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$helpshift$log$ILogger$LEVEL;

        static {
            int[] iArr = new int[ILogger.LEVEL.values().length];
            $SwitchMap$com$helpshift$log$ILogger$LEVEL = iArr;
            try {
                iArr[ILogger.LEVEL.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$helpshift$log$ILogger$LEVEL[ILogger.LEVEL.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$helpshift$log$ILogger$LEVEL[ILogger.LEVEL.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
