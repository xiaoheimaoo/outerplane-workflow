package com.vagames.auth;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.unity3d.player.UnityPlayer;
/* loaded from: classes3.dex */
public class GoogleSignInBridge {
    private static final String TAG = "GoogleSignInBridge";

    public static void start(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, SignInProxyActivity.class);
        intent.putExtra("goName", str);
        intent.putExtra("callback", str2);
        intent.putExtra("webClientId", str3);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void send(String str, String str2, String str3) {
        UnityPlayer.UnitySendMessage(str, str2, str3);
    }

    public static void signOut() {
        try {
            Activity activity = UnityPlayer.currentActivity;
            if (activity == null) {
                Log.e(TAG, "signOut: currentActivity is null");
            } else {
                GoogleSignIn.getClient(activity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()).signOut().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.vagames.auth.GoogleSignInBridge$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        Log.d(GoogleSignInBridge.TAG, "Google signOut complete");
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "signOut failed: " + e.getMessage());
        }
    }
}
