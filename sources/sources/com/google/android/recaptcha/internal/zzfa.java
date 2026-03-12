package com.google.android.recaptcha.internal;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzfa implements zzey {
    private final Lazy zza;

    public zzfa() {
        int i = zzav.zza;
        this.zza = LazyKt.lazy(zzez.zza);
    }

    @Override // com.google.android.recaptcha.internal.zzey
    public final zzsc zza(String str, zzto zztoVar) throws zzbd {
        zzbd zzbdVar;
        zzew zzewVar = null;
        try {
            try {
                zzewVar = ((zzex) this.zza.getValue()).zza(str);
                zzewVar.zzc();
                zzewVar.zze(zztoVar.zzd());
                zzsc zzscVar = (zzsc) zzewVar.zza(zzsc.zzi());
                zzewVar.zzd();
                return zzscVar;
            } catch (zzbd e) {
                if (zzewVar == null) {
                    throw e;
                }
                if (Intrinsics.areEqual(e.zza(), zzba.zzau)) {
                    try {
                        zzbdVar = zzbc.zza(zztu.zzg(zzewVar.zzb().getErrorStream()).zzi());
                    } catch (Exception e2) {
                        zzbdVar = new zzbd(zzbb.zzc, zzba.zzG, e2.getMessage());
                    }
                    throw zzbdVar;
                }
                throw e;
            } catch (Exception e3) {
                throw new zzbd(zzbb.zzc, zzba.zzF, e3.getMessage());
            }
        } catch (Throwable th) {
            if (zzewVar != null) {
                zzewVar.zzd();
            }
            throw th;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzey
    public final String zzb(String str) throws zzbd {
        InputStreamReader inputStreamReader;
        try {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/x-protobuffer");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    try {
                        if (Intrinsics.areEqual("gzip", httpURLConnection.getContentEncoding())) {
                            inputStreamReader = new InputStreamReader(new GZIPInputStream(httpURLConnection.getInputStream()));
                        } else {
                            inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                        }
                        return TextStreamsKt.readText(inputStreamReader);
                    } catch (Exception unused) {
                        throw new zzbd(zzbb.zzc, zzba.zzP, null);
                    }
                }
                throw new zzbd(zzbb.zzc, new zzba(httpURLConnection.getResponseCode()), null);
            } catch (Exception unused2) {
                throw new zzbd(zzbb.zzc, zzba.zzO, null);
            }
        } catch (Exception unused3) {
            throw new zzbd(zzbb.zzb, zzba.zzN, null);
        }
    }
}
