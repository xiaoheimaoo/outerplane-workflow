package com.helpshift.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class HSTimer {
    private static final Map<String, Long> sourceTimer = new HashMap();

    private HSTimer() {
    }

    public static void setStartTime(String str) {
        sourceTimer.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static long endTimer(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Utils.isEmpty(str)) {
            return -1L;
        }
        Map<String, Long> map = sourceTimer;
        if (map.containsKey(str)) {
            return currentTimeMillis - map.remove(str).longValue();
        }
        return -1L;
    }
}
