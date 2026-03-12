package com.helpshift.util;
/* loaded from: classes3.dex */
public class ValuePair<F, S> {
    public final F first;
    public final S second;

    public ValuePair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <F, S> ValuePair<F, S> from(F f, S s) {
        return new ValuePair<>(f, s);
    }
}
