package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzhl extends zzhn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.internal.play_billing.zzho.zzi(java.lang.Object, long, boolean):void
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 2
        	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:748)
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1691)
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
    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zzc(java.lang.Object r2, long r3, boolean r5) {
        /*
            r1 = this;
            boolean r0 = com.google.android.gms.internal.play_billing.zzho.zzb
            if (r0 == 0) goto L8
            com.google.android.gms.internal.play_billing.zzho.zzi(r2, r3, r5)
            return
        L8:
            com.google.android.gms.internal.play_billing.zzho.zzj(r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzhl.zzc(java.lang.Object, long, boolean):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zzd(Object obj, long j, byte b) {
        if (zzho.zzb) {
            zzho.zzD(obj, j, b);
        } else {
            zzho.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final boolean zzg(Object obj, long j) {
        if (zzho.zzb) {
            return zzho.zzt(obj, j);
        }
        return zzho.zzu(obj, j);
    }
}
