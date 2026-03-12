package com.appsflyer.internal;
/* loaded from: classes.dex */
public abstract class AFh1mSDK extends AFh1jSDK {
    private final boolean equals;
    private final boolean toString;

    AFh1mSDK() {
        this(null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AFh1mSDK(String str, Boolean bool, Boolean bool2) {
        super(str, null, Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false));
        this.equals = bool != null ? bool.booleanValue() : true;
        this.toString = true;
    }
}
