package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public abstract class zzin<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzlp {
    @Override // 
    /* renamed from: zza */
    public abstract BuilderType zzb(zzjk zzjkVar, zzjt zzjtVar) throws IOException;

    @Override // 
    /* renamed from: zzag */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzkp {
        try {
            zzjk zza = zzjk.zza(bArr, 0, i2, false);
            zzb(zza, zzjt.zza);
            zza.zzb(0);
            return this;
        } catch (zzkp e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzjt zzjtVar) throws zzkp {
        try {
            zzjk zza = zzjk.zza(bArr, 0, i2, false);
            zzb(zza, zzjtVar);
            zza.zzb(0);
            return this;
        } catch (zzkp e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final /* synthetic */ zzlp zza(byte[] bArr) throws zzkp {
        return zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final /* synthetic */ zzlp zza(byte[] bArr, zzjt zzjtVar) throws zzkp {
        return zza(bArr, 0, bArr.length, zzjtVar);
    }

    private final String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzkj.zza(iterable);
        if (iterable instanceof zzkx) {
            List<?> zza = ((zzkx) iterable).zza();
            zzkx zzkxVar = (zzkx) list;
            int size = list.size();
            for (Object obj : zza) {
                if (obj == null) {
                    String str = "Element at index " + (zzkxVar.size() - size) + " is null.";
                    for (int size2 = zzkxVar.size() - 1; size2 >= size; size2--) {
                        zzkxVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                } else if (obj instanceof zziy) {
                    zzkxVar.zza((zziy) obj);
                } else if (obj instanceof byte[]) {
                    zzkxVar.zza(zziy.zza((byte[]) obj));
                } else {
                    zzkxVar.add((String) obj);
                }
            }
        } else if (iterable instanceof zzly) {
            list.addAll((Collection) iterable);
        } else {
            if (iterable instanceof Collection) {
                int size3 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size3);
                } else if (list instanceof zzmd) {
                    ((zzmd) list).zzb(list.size() + size3);
                }
            }
            int size4 = list.size();
            if ((iterable instanceof List) && (iterable instanceof RandomAccess)) {
                List list2 = (List) iterable;
                int size5 = list2.size();
                for (int i = 0; i < size5; i++) {
                    Object obj2 = (Object) list2.get(i);
                    if (obj2 == 0) {
                        zza(list, size4);
                    }
                    list.add(obj2);
                }
                return;
            }
            for (Object obj3 : iterable) {
                if (obj3 == null) {
                    zza(list, size4);
                }
                list.add(obj3);
            }
        }
    }

    private static void zza(List<?> list, int i) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        for (int size = list.size() - 1; size >= i; size--) {
            list.remove(size);
        }
        throw new NullPointerException(str);
    }
}
