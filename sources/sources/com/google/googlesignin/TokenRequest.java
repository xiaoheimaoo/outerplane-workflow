package com.google.googlesignin;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.PendingResult;
import java.util.Locale;
/* loaded from: classes3.dex */
public class TokenRequest {
    private String accountName;
    private boolean doAuthCode;
    private boolean doEmail;
    private boolean doIdToken;
    private boolean forceRefresh;
    private long handle;
    private boolean hidePopups;
    private TokenPendingResult pendingResponse;
    private String[] scopes;
    private boolean useGamesConfig;
    private String webClientId;

    public TokenRequest(boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str2, String[] strArr, long j) {
        this.pendingResponse = new TokenPendingResult(j);
        this.useGamesConfig = z;
        this.webClientId = str;
        this.doAuthCode = z2;
        this.forceRefresh = z3;
        this.doEmail = z4;
        this.doIdToken = z5;
        this.hidePopups = z6;
        this.accountName = str2;
        this.handle = j;
        if (strArr != null && strArr.length > 0) {
            String[] strArr2 = new String[strArr.length];
            this.scopes = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            return;
        }
        this.scopes = null;
    }

    public PendingResult<TokenResult> getPendingResponse() {
        return this.pendingResponse;
    }

    public void setResult(int i, GoogleSignInAccount googleSignInAccount) {
        this.pendingResponse.setResult(googleSignInAccount, i);
        this.pendingResponse.setStatus(i);
    }

    public void cancel() {
        this.pendingResponse.cancel();
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s(a:%b:e:%b:i:%b)", Integer.toHexString(hashCode()), Boolean.valueOf(this.doAuthCode), Boolean.valueOf(this.doEmail), Boolean.valueOf(this.doIdToken));
    }

    public String getWebClientId() {
        String str = this.webClientId;
        return str == null ? "" : str;
    }

    public boolean getForceRefresh() {
        return this.forceRefresh;
    }

    public boolean isValid() {
        String str = this.webClientId;
        if (str == null || str.isEmpty()) {
            if (this.doAuthCode) {
                GoogleSignInHelper.logError("Invalid configuration, auth code requires web client id");
                return false;
            } else if (this.doIdToken) {
                GoogleSignInHelper.logError("Invalid configuration, id token requires web client id");
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public long getHandle() {
        return this.handle;
    }

    public boolean getUseGamesConfig() {
        return this.useGamesConfig;
    }

    public boolean getDoAuthCode() {
        return this.doAuthCode;
    }

    public boolean getDoEmail() {
        return this.doEmail;
    }

    public boolean getDoIdToken() {
        return this.doIdToken;
    }

    public String[] getScopes() {
        return this.scopes;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public boolean getHidePopups() {
        return this.hidePopups;
    }
}
