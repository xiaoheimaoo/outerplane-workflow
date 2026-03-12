package com.unity3d.player;

import java.lang.reflect.Member;
/* loaded from: classes3.dex */
final class M {
    private final Class a;
    private final String b;
    private final String c;
    private final int d;
    public volatile Member e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(Class cls, String str, String str2) {
        this.a = cls;
        this.b = str;
        this.c = str2;
        int hashCode = str.hashCode();
        this.d = str2.hashCode() + ((hashCode + ((cls.hashCode() + 527) * 31)) * 31);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof M) {
            M m = (M) obj;
            return this.d == m.d && this.c.equals(m.c) && this.b.equals(m.b) && this.a.equals(m.a);
        }
        return false;
    }

    public final int hashCode() {
        return this.d;
    }
}
