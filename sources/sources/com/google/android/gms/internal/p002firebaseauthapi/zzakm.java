package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakm  reason: invalid package */
/* loaded from: classes2.dex */
public class zzakm extends IOException {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakp zza() {
        return new zzakp("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzb() {
        return new zzakm("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzc() {
        return new zzakm("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzd() {
        return new zzakm("Protocol message had invalid UTF-8.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zze() {
        return new zzakm("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzf() {
        return new zzakm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzg() {
        return new zzakm("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzh() {
        return new zzakm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzi() {
        return new zzakm("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakm zzj() {
        return new zzakm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzakm(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzakm(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk() {
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zza;
    }
}
