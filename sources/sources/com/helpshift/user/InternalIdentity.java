package com.helpshift.user;

import com.helpshift.util.Utils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class InternalIdentity {
    public final String identityKey;
    public final String identityValue;
    public final Map<String, String> metaData;

    public InternalIdentity(String str, String str2, Map<String, String> map) {
        this.identityKey = Utils.isEmpty(str) ? "" : str;
        this.identityValue = Utils.isEmpty(str2) ? "" : str2;
        this.metaData = Utils.isEmpty(map) ? new HashMap<>() : map;
    }
}
