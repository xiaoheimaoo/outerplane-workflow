package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzag  reason: invalid package */
/* loaded from: classes2.dex */
final class zzag {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + String.valueOf(obj2));
        } else if (obj2 != null) {
        } else {
            throw new NullPointerException("null value in entry: " + String.valueOf(obj) + "=null");
        }
    }
}
