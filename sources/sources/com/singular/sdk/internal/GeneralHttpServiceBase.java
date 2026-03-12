package com.singular.sdk.internal;

import java.util.Map;
/* loaded from: classes3.dex */
public abstract class GeneralHttpServiceBase {
    private String baseUrl;

    /* loaded from: classes3.dex */
    public interface CompletionHandler {
        void onFailure(String str);

        void onSuccess(String str, int i);
    }

    public abstract void sendRequest(String str, Map<String, String> map, Map<String, String> map2, CompletionHandler completionHandler);

    private GeneralHttpServiceBase() {
    }

    public GeneralHttpServiceBase(String str) {
        this.baseUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getBaseUrl() {
        return this.baseUrl;
    }
}
