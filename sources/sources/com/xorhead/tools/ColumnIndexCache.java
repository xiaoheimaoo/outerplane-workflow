package com.xorhead.tools;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class ColumnIndexCache {
    private Map<String, Integer> mMap = new HashMap();

    public int getColumnIndex(Cursor cursor, String str) {
        if (!this.mMap.containsKey(str)) {
            this.mMap.put(str, Integer.valueOf(cursor.getColumnIndex(str)));
        }
        return this.mMap.get(str).intValue();
    }

    public void clear() {
        this.mMap.clear();
    }
}
