package com.helpshift.log;

import android.util.Log;
import com.helpshift.log.ILogger;
/* loaded from: classes3.dex */
public class InternalHelpshiftLogger implements ILogger {
    private static final String TAG = "Helpshift";
    private LogCollector logCollector;
    private final boolean shouldEnableLogging;

    public InternalHelpshiftLogger(boolean z) {
        this.shouldEnableLogging = z;
    }

    public void setLogCollector(LogCollector logCollector) {
        this.logCollector = logCollector;
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
        if (!this.shouldEnableLogging) {
            if (level == ILogger.LEVEL.ERROR) {
                Log.e(TAG, str3 + (th == null ? "" : th.getMessage()));
                return;
            }
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$helpshift$log$ILogger$LEVEL[level.ordinal()];
        if (i == 1) {
            Log.e(TAG, str3, th);
        } else if (i == 2) {
            Log.w(TAG, str3, th);
        } else if (i == 3) {
            Log.d(TAG, str3, th);
        }
        LogCollector logCollector = this.logCollector;
        if (logCollector != null) {
            logCollector.collectLog(TAG, str3, th, level);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.helpshift.log.InternalHelpshiftLogger$1  reason: invalid class name */
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
