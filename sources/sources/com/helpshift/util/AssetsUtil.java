package com.helpshift.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class AssetsUtil {
    private static final String TAG = "astsUtl";

    private AssetsUtil() {
    }

    public static boolean resourceExists(Context context, int i) {
        if (context == null || i == 0) {
            return false;
        }
        try {
            return context.getResources().getResourceName(i) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable] */
    public static String readAssetFileContents(Context context, String str) {
        ?? r6;
        BufferedReader bufferedReader;
        IOException e;
        StringBuilder sb;
        if (context == 0) {
            return "";
        }
        Closeable closeable = null;
        try {
            try {
                sb = new StringBuilder();
                context = context.getAssets().open(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(context));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            Utils.closeQuietly(context);
                            Utils.closeQuietly(bufferedReader);
                            return sb2;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Log.e(TAG, "Error in reading the file contents", e);
                        Utils.closeQuietly(context);
                        Utils.closeQuietly(bufferedReader);
                        return "";
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                str = null;
                closeable = context;
                r6 = str;
                Utils.closeQuietly(closeable);
                Utils.closeQuietly(r6);
                throw th;
            }
        } catch (IOException e4) {
            bufferedReader = null;
            e = e4;
            context = 0;
        } catch (Throwable th3) {
            th = th3;
            r6 = 0;
            Utils.closeQuietly(closeable);
            Utils.closeQuietly(r6);
            throw th;
        }
    }
}
