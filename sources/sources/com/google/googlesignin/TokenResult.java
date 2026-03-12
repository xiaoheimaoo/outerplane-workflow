package com.google.googlesignin;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Locale;
/* loaded from: classes3.dex */
public class TokenResult implements Result {
    private GoogleSignInAccount account;
    private long handle;
    private Status status;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TokenResult() {
        this.status = new Status(4);
        this.account = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TokenResult(GoogleSignInAccount googleSignInAccount, int i) {
        this.status = new Status(i);
        this.account = googleSignInAccount;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[2];
        objArr[0] = this.status;
        Object obj = this.account;
        if (obj == null) {
            obj = "<null>";
        }
        objArr[1] = obj;
        return String.format(locale, "Status: %s %s", objArr);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.status;
    }

    public GoogleSignInAccount getAccount() {
        return this.account;
    }

    public void setStatus(int i) {
        this.status = new Status(i);
    }

    public long getHandle() {
        return this.handle;
    }

    public void setHandle(long j) {
        this.handle = j;
    }
}
