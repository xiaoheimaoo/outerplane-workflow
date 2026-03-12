package com.vagames.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
/* loaded from: classes3.dex */
public class SignInProxyActivity extends Activity {
    private static final int RC_SIGN_IN = 9001;
    private String callback;
    private String goName;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.goName = getIntent().getStringExtra("goName");
        this.callback = getIntent().getStringExtra("callback");
        startActivityForResult(GoogleSignIn.getClient((Activity) this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getIntent().getStringExtra("webClientId")).requestEmail().build()).getSignInIntent(), RC_SIGN_IN);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == RC_SIGN_IN) {
            try {
                GoogleSignInAccount result = GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class);
                String idToken = result != null ? result.getIdToken() : null;
                if (idToken != null && !idToken.isEmpty()) {
                    GoogleSignInBridge.send(this.goName, this.callback, "OK:" + idToken);
                } else {
                    GoogleSignInBridge.send(this.goName, this.callback, "ERROR:IdToken is null");
                }
            } catch (ApiException e) {
                if (e.getStatusCode() == 12501) {
                    GoogleSignInBridge.send(this.goName, this.callback, "CANCELED");
                } else {
                    GoogleSignInBridge.send(this.goName, this.callback, "ERROR:" + e.getStatusCode() + " " + e.getMessage());
                }
            }
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
    }
}
