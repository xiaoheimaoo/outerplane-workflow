package com.helpshift.network;

import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes3.dex */
public class URLConnectionProvider {
    /* JADX INFO: Access modifiers changed from: package-private */
    public URL getURL(String str) throws MalformedURLException {
        return new URL(str);
    }
}
