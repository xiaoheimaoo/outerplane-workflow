package com.helpshift;

import android.util.Log;
import com.helpshift.concurrency.HSThreadFactory;
import com.helpshift.core.HSContext;
import com.helpshift.log.HSLogger;
import com.helpshift.util.Utils;
import com.singular.sdk.internal.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HSDebugLog {
    private static final int DBGL_MSG_LIMIT = 10000;
    private static final int DBGL_TAG_LIMIT = 100;
    private static final int DBGL_THROWABLE_LIMIT = 5000;
    private static final String TAG = "DebugLog";
    private static final ExecutorService executor = Executors.newSingleThreadExecutor(new HSThreadFactory("debugLogThread"));

    private HSDebugLog() {
    }

    private static void appendLog(final Integer num, final String str, final String str2, final Throwable th) {
        if (Utils.isEmpty(str2)) {
            str2 = "";
        }
        if (str2.length() > 10000) {
            str2 = str2.substring(0, 10000);
        }
        if (Utils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        try {
            executor.submit(new Runnable() { // from class: com.helpshift.HSDebugLog.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jsonify = HSDebugLog.jsonify(num, str, str2, th);
                        if (jsonify.length() != 0) {
                            HSContext.getInstance().getConfigManager().addDebugLog(jsonify);
                        }
                    } catch (Exception e) {
                        HSLogger.e(HSDebugLog.TAG, "Failed to update DebugLog", e);
                    }
                }
            });
        } catch (Exception e) {
            HSLogger.e(TAG, "Error executing Debug logs update", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject jsonify(Integer num, String str, String str2, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("l", num);
            jSONObject.put("t", str);
            jSONObject.put("m", str2);
            if (th != null) {
                jSONObject.put(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, getStackTraceString(th));
            }
            return jSONObject;
        } catch (JSONException e) {
            HSLogger.e(TAG, "Failed to create JSONObject debugLog", e);
            return new JSONObject();
        }
    }

    public static int v(String str, String str2) {
        return v(str, str2, null);
    }

    public static int v(String str, String str2, Throwable th) {
        int v = Log.v(str, str2, th);
        appendLog(2, str, str2, th);
        return v;
    }

    public static int d(String str, String str2) {
        return d(str, str2, null);
    }

    public static int d(String str, String str2, Throwable th) {
        int d = Log.d(str, str2, th);
        appendLog(3, str, str2, th);
        return d;
    }

    public static int i(String str, String str2) {
        return i(str, str2, null);
    }

    public static int i(String str, String str2, Throwable th) {
        int i = Log.i(str, str2, th);
        appendLog(4, str, str2, th);
        return i;
    }

    public static int w(String str, String str2) {
        return w(str, str2, null);
    }

    public static int w(String str, String str2, Throwable th) {
        int e = Log.e(str, str2, th);
        appendLog(5, str, str2, th);
        return e;
    }

    public static boolean isLoggable(String str, int i) {
        return Log.isLoggable(str, i);
    }

    public static int w(String str, Throwable th) {
        return w(str, "", th);
    }

    public static int e(String str, String str2) {
        return e(str, str2, null);
    }

    public static int e(String str, String str2, Throwable th) {
        int e = Log.e(str, str2, th);
        appendLog(6, str, str2, th);
        return e;
    }

    public static int wtf(String str, String str2) {
        return wtf(str, str2, null);
    }

    public static int wtf(String str, Throwable th) {
        return wtf(str, "", th);
    }

    public static int wtf(String str, String str2, Throwable th) {
        int wtf = Log.wtf(str, str2, th);
        appendLog(-1, str, str2, th);
        return wtf;
    }

    public static String getStackTraceString(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return !Utils.isEmpty(stackTraceString) ? stackTraceString.length() > 5000 ? stackTraceString.substring(0, 5000) : stackTraceString : "";
    }
}
