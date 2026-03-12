package com.helpshift.network;

import com.helpshift.log.HSLogger;
import com.helpshift.network.exception.HSRootApiException;
import com.helpshift.network.exception.NetworkException;
import com.helpshift.user.UserConstants;
import com.helpshift.util.Utils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RetryNetworkWithNewToken implements HSNetwork {
    static final String ERROR = "error";
    static String INVALID_ACCESS_TOKEN = "Invalid access token";
    static String MISSING_ACCESS_TOKEN = "Missing access token";
    static String USER_IDENTITY_FEATURE_NOT_ENABLED = "Access to feature User identity is disallowed. Reason: Feature not enabled";
    private final String TAG = "RetryNetworkWithNewToken";
    private final HTTPTransport httpTransport;
    private final boolean isUserWithIdentity;
    private final HSNetwork network;
    private final Map<String, String> tokenMap;
    private final UserManagerProxy userManagerProxy;

    public RetryNetworkWithNewToken(HSNetwork hSNetwork, UserManagerProxy userManagerProxy, HTTPTransport hTTPTransport, boolean z, Map<String, String> map) {
        this.network = hSNetwork;
        this.userManagerProxy = userManagerProxy;
        this.httpTransport = hTTPTransport;
        this.tokenMap = map;
        this.isUserWithIdentity = z;
    }

    @Override // com.helpshift.network.HSNetwork
    public HSResponse makeRequest(HSRequestData hSRequestData) {
        String rotateAndGetNewToken;
        if (!this.isUserWithIdentity) {
            return this.network.makeRequest(hSRequestData);
        }
        addTokenAccessTokenInHeaders(hSRequestData);
        HSResponse makeRequest = this.network.makeRequest(hSRequestData);
        if (isFeatureDisabled(makeRequest)) {
            HSLogger.e("RetryNetworkWithNewToken", "Received 403.Feature is not enabled");
            throw HSRootApiException.wrap(null, NetworkException.IDENTITY_FEATURE_NOT_ENABLED);
        } else if (!shouldRotateToken(makeRequest) || (rotateAndGetNewToken = rotateAndGetNewToken()) == null) {
            return makeRequest;
        } else {
            updateTokenInHeaders(hSRequestData.headers, rotateAndGetNewToken);
            HSResponse makeRequest2 = this.network.makeRequest(hSRequestData);
            if (shouldRotateToken(makeRequest2)) {
                throw HSRootApiException.wrap(null, NetworkException.SESSION_EXPIRED);
            }
            return makeRequest2;
        }
    }

    private void addTokenAccessTokenInHeaders(HSRequestData hSRequestData) {
        if (this.isUserWithIdentity) {
            updateTokenInHeaders(hSRequestData.headers, (String) Utils.getOrDefault(this.tokenMap, UserConstants.ACCESS_TOKEN, ""));
        }
    }

    private void updateTokenInHeaders(Map<String, String> map, String str) {
        map.put(NetworkUtils.X_HS_ACCESS_TOKEN, str);
    }

    private String rotateAndGetNewToken() {
        try {
            HSResponse makeRequest = this.httpTransport.makeRequest(this.userManagerProxy.getRequestBodyForRotatingToken((String) Utils.getOrDefault(this.tokenMap, UserConstants.REFRESH_TOKEN, "")));
            if (!makeRequest.isNetworkCallSuccess()) {
                if (makeRequest.getStatus() >= 400 && makeRequest.getStatus() < 500) {
                    HSLogger.d("RetryNetworkWithNewToken", "Rotating token network call failed");
                    throw HSRootApiException.wrap(null, NetworkException.SESSION_EXPIRED);
                }
                return null;
            }
            JSONObject jSONObject = new JSONObject(makeRequest.getResponseString());
            String optString = jSONObject.optString(UserConstants.ACCESS_TOKEN, "");
            String optString2 = jSONObject.optString(UserConstants.REFRESH_TOKEN, "");
            long optLong = jSONObject.optLong(UserConstants.REFRESH_TOKEN_TTL, 0L);
            if (Utils.isEmpty(optString) || Utils.isEmpty(optString2)) {
                HSLogger.d("RetryNetworkWithNewToken", "new token is empty, failing the call");
                throw HSRootApiException.wrap(null, NetworkException.SESSION_EXPIRED);
            }
            this.userManagerProxy.updateNewTokensInStorage(optString, optString2, optLong);
            return optString;
        } catch (HSRootApiException e) {
            if (e.exceptionType == NetworkException.SESSION_EXPIRED) {
                throw e;
            }
            HSLogger.e("RetryNetworkWithNewToken", "HSRoot error in rotating token", e);
            return null;
        } catch (Exception e2) {
            HSLogger.e("RetryNetworkWithNewToken", "Error in rotating token", e2);
            return null;
        }
    }

    private boolean shouldRotateToken(HSResponse hSResponse) {
        return isTokenMissing(hSResponse) || isAccessTokenInvalid(hSResponse);
    }

    private boolean isFeatureDisabled(HSResponse hSResponse) {
        try {
            if (hSResponse.getStatus() != 403) {
                return false;
            }
            return new JSONObject(hSResponse.getResponseString()).optString("error", "").equals(USER_IDENTITY_FEATURE_NOT_ENABLED);
        } catch (Exception e) {
            HSLogger.e("RetryNetworkWithNewToken", "Error in checking if feature is disabled", e);
            return false;
        }
    }

    private boolean isTokenMissing(HSResponse hSResponse) {
        try {
            if (hSResponse.getStatus() != 400) {
                return false;
            }
            return new JSONObject(hSResponse.getResponseString()).optString("error", "").equals(MISSING_ACCESS_TOKEN);
        } catch (Exception e) {
            HSLogger.e("RetryNetworkWithNewToken", "Error in checking  if token is missing", e);
            return false;
        }
    }

    private boolean isAccessTokenInvalid(HSResponse hSResponse) {
        try {
            if (hSResponse.getStatus() != 401) {
                return false;
            }
            return new JSONObject(hSResponse.getResponseString()).optString("error", "").equals(INVALID_ACCESS_TOKEN);
        } catch (Exception e) {
            HSLogger.e("RetryNetworkWithNewToken", "Error in checking if access token is invalid", e);
            return false;
        }
    }
}
