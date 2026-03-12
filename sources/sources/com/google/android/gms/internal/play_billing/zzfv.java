package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfu;
import com.google.android.gms.internal.play_billing.zzfv;
import java.io.IOException;
import java.util.List;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public abstract class zzfv<MessageType extends zzfv<MessageType, BuilderType>, BuilderType extends zzfu<MessageType, BuilderType>> implements zzim {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzg(Iterable iterable, List list) {
        zzfu.zzc(iterable, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zze(zzix zzixVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final zzgk zzf() {
        try {
            int zzk = zzk();
            zzgk zzgkVar = zzgk.zzb;
            byte[] bArr = new byte[zzk];
            zzgo zzgoVar = new zzgo(bArr, 0, zzk);
            zzJ(zzgoVar);
            zzgoVar.zzB();
            return new zzgi(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzh() {
        try {
            int zzk = zzk();
            byte[] bArr = new byte[zzk];
            zzgo zzgoVar = new zzgo(bArr, 0, zzk);
            zzJ(zzgoVar);
            zzgoVar.zzB();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
