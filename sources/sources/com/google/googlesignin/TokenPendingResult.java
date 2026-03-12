package com.google.googlesignin;

import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class TokenPendingResult extends PendingResult<TokenResult> {
    private static final String TAG = "TokenPendingResult";
    private CountDownLatch latch = new CountDownLatch(1);
    private final long requestHandle;
    private TokenResult result;
    private ResultCallback<? super TokenResult> resultCallback;

    public TokenPendingResult(long j) {
        this.requestHandle = j;
        TokenResult tokenResult = new TokenResult();
        this.result = tokenResult;
        tokenResult.setHandle(j);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public TokenResult await() {
        try {
            this.latch.await();
        } catch (InterruptedException unused) {
            setResult(null, 14);
        }
        return getResult();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public TokenResult await(long j, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                setResult(null, 15);
            }
        } catch (InterruptedException unused) {
            setResult(null, 14);
        }
        return getResult();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        setResult(null, 16);
        this.latch.countDown();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        return getResult() != null && getResult().getStatus().isCanceled();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void setResultCallback(ResultCallback<? super TokenResult> resultCallback) {
        if (this.latch.getCount() == 0) {
            resultCallback.onResult(getResult());
        } else {
            setCallback(resultCallback);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void setResultCallback(ResultCallback<? super TokenResult> resultCallback, long j, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                setResult(null, 15);
            }
        } catch (InterruptedException unused) {
            setResult(null, 14);
        }
        resultCallback.onResult(getResult());
    }

    private synchronized void setCallback(ResultCallback<? super TokenResult> resultCallback) {
        this.resultCallback = resultCallback;
    }

    private synchronized ResultCallback<? super TokenResult> getCallback() {
        return this.resultCallback;
    }

    public synchronized void setResult(GoogleSignInAccount googleSignInAccount, int i) {
        TokenResult tokenResult = new TokenResult(googleSignInAccount, i);
        this.result = tokenResult;
        tokenResult.setHandle(this.requestHandle);
    }

    private synchronized TokenResult getResult() {
        return this.result;
    }

    public void setStatus(int i) {
        this.result.setStatus(i);
        this.latch.countDown();
        ResultCallback<? super TokenResult> callback = getCallback();
        TokenResult result = getResult();
        if (callback != null) {
            Log.d(TAG, " Calling onResult for callback. result: " + result);
            getCallback().onResult(result);
        }
    }
}
