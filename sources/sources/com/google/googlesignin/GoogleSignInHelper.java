package com.google.googlesignin;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes3.dex */
public class GoogleSignInHelper {
    private static final String TAG = "SignInFragment";
    public static boolean loggingEnabled = false;

    public static native void nativeOnResult(long j, int i, GoogleSignInAccount googleSignInAccount);

    public static void enableDebugLogging(boolean z) {
        loggingEnabled = z;
    }

    public static void configure(Activity activity, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str2, String[] strArr, long j) {
        logDebug("TokenFragment.configure called");
        TokenRequest tokenRequest = new TokenRequest(z, str, z2, z3, z4, z5, z6, str2, strArr, j);
        GoogleSignInFragment googleSignInFragment = GoogleSignInFragment.getInstance(activity);
        if (tokenRequest.isValid()) {
            if (googleSignInFragment.submitRequest(tokenRequest)) {
                return;
            }
            logError("There is already a pending authentication token request!");
            return;
        }
        nativeOnResult(j, 10, null);
    }

    public static void signIn(Activity activity, long j) {
        logDebug("AuthHelperFragment.authenticate called!");
        if (GoogleSignInFragment.getInstance(activity).startSignIn()) {
            return;
        }
        nativeOnResult(j, 10, null);
    }

    public static void signInSilently(Activity activity, long j) {
        logDebug("AuthHelperFragment.signinSilently called!");
        if (GoogleSignInFragment.getInstance(activity).startSignInSilently()) {
            return;
        }
        nativeOnResult(j, 10, null);
    }

    public static void signOut(Activity activity) {
        GoogleSignInFragment.getInstance(activity).signOut();
    }

    public static void disconnect(Activity activity) {
        GoogleSignInFragment.getInstance(activity).disconnect();
    }

    public static void logInfo(String str) {
        if (loggingEnabled) {
            Log.i(TAG, str);
        }
    }

    public static void logError(String str) {
        Log.e(TAG, str);
    }

    public static void logDebug(String str) {
        if (loggingEnabled) {
            Log.d(TAG, str);
        }
    }
}
