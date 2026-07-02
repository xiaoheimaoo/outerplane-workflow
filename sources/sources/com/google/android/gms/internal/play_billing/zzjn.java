package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzjn extends zzjp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjp
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjp
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.internal.play_billing.zzjq.zzi(java.lang.Object, long, boolean):void
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1685)
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1660)
        	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:130)
        	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:123)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:481)
        	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:92)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:484)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1079)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1088)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:115)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	... 1 more
        */
    @Override // com.google.android.gms.internal.play_billing.zzjp
    public final void zzc(java.lang.Object r2, long r3, boolean r5) {
        /*
            r1 = this;
            boolean r0 = com.google.android.gms.internal.play_billing.zzjq.zzb
            if (r0 == 0) goto L8
            com.google.android.gms.internal.play_billing.zzjq.zzi(r2, r3, r5)
            return
        L8:
            com.google.android.gms.internal.play_billing.zzjq.zzj(r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzjn.zzc(java.lang.Object, long, boolean):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzjp
    public final void zzd(Object obj, long j, byte b) {
        if (zzjq.zzb) {
            zzjq.zzD(obj, j, b);
        } else {
            zzjq.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjp
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjp
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjp
    public final boolean zzg(Object obj, long j) {
        if (zzjq.zzb) {
            return zzjq.zzt(obj, j);
        }
        return zzjq.zzu(obj, j);
    }
}
