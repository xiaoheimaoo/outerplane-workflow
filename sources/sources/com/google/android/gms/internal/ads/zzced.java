package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzced {
    public static boolean zza(Bundle bundle, Bundle bundle2) {
        Object obj = bundle2;
        obj = bundle2;
        if (bundle != null && bundle2 != null) {
            if (bundle.size() != bundle2.size()) {
                return false;
            }
            for (String str : bundle.keySet()) {
                if (!bundle2.containsKey(str)) {
                    return false;
                }
                Object obj2 = bundle.get(str);
                Object obj3 = bundle2.get(str);
                if (obj2 == null || obj3 == null) {
                    obj = obj3;
                    bundle = obj2;
                } else if (obj2 instanceof Bundle) {
                    if (!(obj3 instanceof Bundle) || !zza((Bundle) obj2, (Bundle) obj3)) {
                        return false;
                    }
                } else if (obj2.getClass().isArray()) {
                    int length = Array.getLength(obj2);
                    if (obj3.getClass().isArray() && length == Array.getLength(obj3)) {
                        for (int i = 0; i < length; i++) {
                            if (!Objects.equal(Array.get(obj2, i), Array.get(obj3, i))) {
                                return false;
                            }
                        }
                        continue;
                    } else {
                        return false;
                    }
                } else if (!obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
        return bundle == null && obj == null;
    }
}
