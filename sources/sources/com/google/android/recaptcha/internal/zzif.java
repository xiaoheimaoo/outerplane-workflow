package com.google.android.recaptcha.internal;

import com.singular.sdk.internal.Constants;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzif extends FunctionReferenceImpl implements Function2 {
    public static final zzif zza = new zzif();

    zzif() {
        super(2, zzih.class, Constants.DID_SET_CUSTOM_SDID_KEY, "cs([Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzih) obj).cs((Object[]) obj2);
    }
}
