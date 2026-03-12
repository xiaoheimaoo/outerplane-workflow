package com.google.googlesignin;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
/* loaded from: classes3.dex */
public class GoogleSignInFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final String FRAGMENT_TAG = "signin.SignInFragment";
    private static final int RC_SIGNIN = 9009;
    private static GoogleSignInFragment theFragment;
    private GoogleApiClient mGoogleApiClient;
    private TokenRequest request = null;
    private State state;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum State {
        NEW,
        READY,
        PENDING,
        PENDING_SILENT,
        BUSY
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        GoogleSignInHelper.logDebug("onConnected!");
        if (this.mGoogleApiClient.hasConnectedApi(Auth.GOOGLE_SIGN_IN_API)) {
            GoogleSignInHelper.logDebug("has connected auth!");
            Auth.GoogleSignInApi.silentSignIn(this.mGoogleApiClient).setResultCallback(new ResultCallback<GoogleSignInResult>() { // from class: com.google.googlesignin.GoogleSignInFragment.1
                @Override // com.google.android.gms.common.api.ResultCallback
                public void onResult(GoogleSignInResult googleSignInResult) {
                    if (googleSignInResult.isSuccess()) {
                        GoogleSignInHelper.nativeOnResult(GoogleSignInFragment.this.request.getHandle(), googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getSignInAccount());
                        GoogleSignInFragment.this.setState(State.READY);
                        return;
                    }
                    GoogleSignInHelper.logError("Error with silentSignIn: " + googleSignInResult.getStatus());
                    GoogleSignInHelper.nativeOnResult(GoogleSignInFragment.this.request.getHandle(), googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getSignInAccount());
                    GoogleSignInFragment.this.setState(State.READY);
                }
            });
            return;
        }
        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.mGoogleApiClient), RC_SIGNIN);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        GoogleSignInHelper.logDebug("onConnectionSuspended() called: " + i);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        GoogleSignInHelper.logError("Connection failed: " + connectionResult.getErrorCode());
        if (connectionResult.hasResolution()) {
            startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.mGoogleApiClient), RC_SIGNIN);
        } else {
            GoogleSignInHelper.nativeOnResult(this.request.getHandle(), connectionResult.getErrorCode(), null);
        }
    }

    public void disconnect() {
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
    }

    public static GoogleSignInFragment getInstance(Activity activity) {
        GoogleSignInFragment googleSignInFragment = (GoogleSignInFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (googleSignInFragment == null) {
            googleSignInFragment = theFragment;
        }
        if (googleSignInFragment == null) {
            GoogleSignInHelper.logDebug("Creating fragment");
            GoogleSignInFragment googleSignInFragment2 = new GoogleSignInFragment();
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            beginTransaction.add(googleSignInFragment2, FRAGMENT_TAG);
            beginTransaction.commitAllowingStateLoss();
            theFragment = googleSignInFragment2;
            return googleSignInFragment2;
        }
        return googleSignInFragment;
    }

    public synchronized boolean submitRequest(TokenRequest tokenRequest) {
        if (this.request != null && this.state != State.READY) {
            GoogleSignInHelper.logError(String.format(Locale.getDefault(), "Existing request: %s ignoring %s.  State = %s", this.request, tokenRequest, this.state));
            return false;
        }
        this.request = tokenRequest;
        return true;
    }

    private synchronized State getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setState(State state) {
        this.state = state;
    }

    public void signOut() {
        clearRequest(true);
        if (this.mGoogleApiClient != null) {
            Auth.GoogleSignInApi.signOut(this.mGoogleApiClient);
        }
    }

    public boolean startSignIn() {
        if (this.request == null) {
            GoogleSignInHelper.logError("Request not configured! Failing authenticate");
            return false;
        } else if (getState() == State.BUSY) {
            GoogleSignInHelper.logError("There is already a pending callback configured.");
            return true;
        } else if (getState() == State.READY) {
            processRequest(false);
            return true;
        } else {
            processWhenReady(false);
            return true;
        }
    }

    public boolean startSignInSilently() {
        if (this.request == null) {
            GoogleSignInHelper.logError("Request not configured! Failing authenticate");
            return false;
        }
        if (getState() == State.BUSY) {
            GoogleSignInHelper.logError("There is already a pending callback configured.");
        } else if (getState() == State.READY) {
            processRequest(true);
        } else {
            processWhenReady(true);
        }
        return true;
    }

    private void processWhenReady(boolean z) {
        GoogleSignInHelper.logInfo("Fragment not initialized yet, waiting to authenticate");
        setState(z ? State.PENDING_SILENT : State.PENDING);
    }

    private void processRequest(boolean z) {
        try {
            if (this.request != null) {
                setState(State.BUSY);
                this.request.getPendingResponse().setResultCallback(new ResultCallback<TokenResult>() { // from class: com.google.googlesignin.GoogleSignInFragment.2
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(TokenResult tokenResult) {
                        GoogleSignInHelper.logDebug(String.format(Locale.getDefault(), "Calling nativeOnResult: handle: %s, status: %d acct: %s", Long.valueOf(tokenResult.getHandle()), Integer.valueOf(tokenResult.getStatus().getStatusCode()), tokenResult.getAccount()));
                        GoogleSignInHelper.nativeOnResult(tokenResult.getHandle(), tokenResult.getStatus().getStatusCode(), tokenResult.getAccount());
                        GoogleSignInFragment.this.clearRequest(false);
                    }
                });
                buildClient(this.request);
                GoogleSignInHelper.logDebug(" Has connected == " + this.mGoogleApiClient.hasConnectedApi(Auth.GOOGLE_SIGN_IN_API));
                if (!this.mGoogleApiClient.hasConnectedApi(Auth.GOOGLE_SIGN_IN_API)) {
                    if (!z) {
                        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.mGoogleApiClient), RC_SIGNIN);
                    } else {
                        Auth.GoogleSignInApi.silentSignIn(this.mGoogleApiClient).setResultCallback(new ResultCallback<GoogleSignInResult>() { // from class: com.google.googlesignin.GoogleSignInFragment.3
                            @Override // com.google.android.gms.common.api.ResultCallback
                            public void onResult(GoogleSignInResult googleSignInResult) {
                                if (googleSignInResult.isSuccess()) {
                                    GoogleSignInHelper.nativeOnResult(GoogleSignInFragment.this.request.getHandle(), googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getSignInAccount());
                                    GoogleSignInFragment.this.setState(State.READY);
                                    return;
                                }
                                GoogleSignInHelper.logError("Error with silentSignIn: " + googleSignInResult.getStatus());
                                GoogleSignInHelper.nativeOnResult(GoogleSignInFragment.this.request.getHandle(), googleSignInResult.getStatus().getStatusCode(), googleSignInResult.getSignInAccount());
                                GoogleSignInFragment.this.setState(State.READY);
                            }
                        });
                    }
                }
                GoogleSignInHelper.logDebug("Done with processRequest!");
                return;
            }
            GoogleSignInHelper.logInfo("No pending configuration, returning");
        } catch (Throwable th) {
            GoogleSignInHelper.logError("Exception caught! " + th.getMessage());
            this.request.setResult(8, null);
        }
    }

    private void buildClient(TokenRequest tokenRequest) {
        GoogleSignInOptions.Builder builder;
        String[] scopes;
        if (tokenRequest.getUseGamesConfig()) {
            GoogleSignInHelper.logDebug("Using DEFAULT_GAMES_SIGN_IN");
            builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        } else {
            GoogleSignInHelper.logDebug("Using DEFAULT_SIGN_IN");
            builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
        }
        if (tokenRequest.getDoAuthCode()) {
            if (!tokenRequest.getWebClientId().isEmpty()) {
                GoogleSignInHelper.logDebug("Requesting AuthCode force = " + tokenRequest.getForceRefresh() + "client: " + tokenRequest.getWebClientId());
                builder.requestServerAuthCode(tokenRequest.getWebClientId(), tokenRequest.getForceRefresh());
            } else {
                GoogleSignInHelper.logError("Web client ID is needed for Auth Code");
                tokenRequest.setResult(10, null);
                throw new IllegalStateException("Web client ID is needed for Auth Code");
            }
        }
        if (tokenRequest.getDoEmail()) {
            GoogleSignInHelper.logDebug("Requesting email");
            builder.requestEmail();
        }
        if (tokenRequest.getDoIdToken()) {
            if (!tokenRequest.getWebClientId().isEmpty()) {
                GoogleSignInHelper.logDebug("Requesting IDToken  client: " + tokenRequest.getWebClientId());
                builder.requestIdToken(tokenRequest.getWebClientId());
            } else {
                GoogleSignInHelper.logError("Web client ID is needed for ID Token");
                tokenRequest.setResult(10, null);
                throw new IllegalStateException("Web client ID is needed for Auth Code");
            }
        }
        if (tokenRequest.getScopes() != null) {
            for (String str : tokenRequest.getScopes()) {
                GoogleSignInHelper.logDebug("Adding scope: " + str);
                builder.requestScopes(new Scope(str), new Scope[0]);
            }
        }
        if (tokenRequest.getHidePopups() && tokenRequest.getUseGamesConfig()) {
            GoogleSignInHelper.logDebug("hiding popup views for games API");
            builder.addExtension(getGamesExtension());
        }
        if (tokenRequest.getAccountName() != null) {
            GoogleSignInHelper.logDebug("Setting accountName: " + tokenRequest.getAccountName());
            builder.setAccountName(tokenRequest.getAccountName());
        }
        GoogleApiClient.Builder addApi = new GoogleApiClient.Builder(getActivity()).addApi(Auth.GOOGLE_SIGN_IN_API, builder.build());
        if (tokenRequest.getUseGamesConfig()) {
            GoogleSignInHelper.logDebug("Adding games API");
            try {
                addApi.addApi(getGamesAPI());
            } catch (Exception e) {
                GoogleSignInHelper.logError("Exception getting Games API: " + e.getMessage());
                tokenRequest.setResult(10, null);
                return;
            }
        }
        if (tokenRequest.getHidePopups()) {
            View view = new View(getActivity());
            view.setVisibility(4);
            view.setClickable(false);
            addApi.setViewForPopups(view);
        }
        GoogleApiClient build = addApi.build();
        this.mGoogleApiClient = build;
        build.connect(2);
    }

    private Api<? extends Api.ApiOptions.NotRequiredOptions> getGamesAPI() {
        try {
            return (Api) Class.forName("com.google.android.gms.games.Games").getField("API").get(null);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Games API requested, but can't load Games class", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Games API requested, but can't load Games API field", e2);
        } catch (NoSuchFieldException e3) {
            throw new IllegalArgumentException("Games API requested, but can't load Games API field", e3);
        }
    }

    private GoogleSignInOptionsExtension getGamesExtension() {
        try {
            Object invoke = Class.forName("com.google.android.gms.games.Games$GamesOptions").getMethod("builder()", new Class[0]).invoke(null, new Object[0]);
            invoke.getClass().getMethod("setShowConnectingPopup", Boolean.TYPE).invoke(invoke, false);
            return (GoogleSignInOptionsExtension) invoke.getClass().getMethod("build", new Class[0]).invoke(invoke, new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Games API requested, butcan't load Games$GamesOptions class", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Games API requested, butcan't invoke builder() static method.", e2);
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Games API requested, butcan't find builder() static method.", e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalArgumentException("Games API requested, butcan't invoke builder() static method.", e4);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null) {
            googleApiClient.connect(2);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        GoogleSignInHelper.logDebug("onResume called");
        if (theFragment != this) {
            theFragment = this;
        }
        super.onResume();
        if (getState() == State.PENDING) {
            GoogleSignInHelper.logDebug("State is pending, calling processRequest(false)");
            processRequest(false);
        } else if (getState() == State.PENDING_SILENT) {
            GoogleSignInHelper.logDebug("State is pending_silent, calling processRequest(true)");
            processRequest(true);
        } else {
            GoogleSignInHelper.logDebug("State is now ready");
            setState(State.READY);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        GoogleSignInHelper.logDebug("onActivityResult: " + i + " " + i2);
        if (i == RC_SIGNIN) {
            GoogleSignInResult signInResultFromIntent = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
            TokenRequest tokenRequest = this.request;
            if (tokenRequest == null) {
                GoogleSignInHelper.logError("Pending request is null, can't return result!");
                return;
            } else if (signInResultFromIntent == null) {
                if (i2 >= 0) {
                    i2 = 13;
                }
                tokenRequest.setResult(i2, null);
                GoogleSignInHelper.logError("GoogleSignIn result is null, returning error.");
                return;
            } else {
                tokenRequest.setResult(signInResultFromIntent.getStatus().getStatusCode(), signInResultFromIntent.getSignInAccount());
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clearRequest(boolean z) {
        if (z) {
            TokenRequest tokenRequest = this.request;
            if (tokenRequest != null) {
                tokenRequest.cancel();
            }
        }
        this.request = null;
        setState(getActivity() != null ? State.READY : State.NEW);
    }
}
