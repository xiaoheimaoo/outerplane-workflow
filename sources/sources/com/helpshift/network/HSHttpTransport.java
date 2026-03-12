package com.helpshift.network;

import com.helpshift.util.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public class HSHttpTransport implements HTTPTransport {
    private static final String TAG = "HttpTransprt";
    private final String NETWORK_ERROR = "Network error: ";

    private void closeHelpshiftSSLSocketFactorySockets(HttpsURLConnection httpsURLConnection) {
    }

    private void fixSSLSocketProtocols(HttpsURLConnection httpsURLConnection) {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:(2:64|(6:66|67|68|(10:176|177|178|185|186|187|188|189|(1:191)|193)(19:72|73|74|75|(3:143|144|145)|77|79|80|81|82|83|84|85|86|87|88|89|(1:91)|93)|19|20))|236|237|67|68|(1:70)|176|177|178|185|186|187|188|189|(0)|193) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:1|2|3|5|6|(5:8|9|(3:12|13|10)|61|62)|(2:64|(6:66|67|68|(10:176|177|178|185|186|187|188|189|(1:191)|193)(19:72|73|74|75|(3:143|144|145)|77|79|80|81|82|83|84|85|86|87|88|89|(1:91)|93)|19|20))|234|235|236|237|67|68|(1:70)|176|177|178|185|186|187|188|189|(0)|193|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:1|2|3|5|6|8|9|(3:12|13|10)|61|62|(2:64|(6:66|67|68|(10:176|177|178|185|186|187|188|189|(1:191)|193)(19:72|73|74|75|(3:143|144|145)|77|79|80|81|82|83|84|85|86|87|88|89|(1:91)|93)|19|20))|234|235|236|237|67|68|(1:70)|176|177|178|185|186|187|188|189|(0)|193|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0279, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x027a, code lost:
        com.helpshift.log.HSLogger.e("Network", "Error in finally closing resources", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x027f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0280, code lost:
        r5 = null;
        r16 = r4;
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0286, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0287, code lost:
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x028f, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0297, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0298, code lost:
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02a1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02a3, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02a4, code lost:
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02ad, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02ae, code lost:
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02b7, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02ba, code lost:
        r4 = r0;
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02c4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x02c6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02c7, code lost:
        r4 = r0;
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02d1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x02d2, code lost:
        r4 = r0;
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x02e8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x02e9, code lost:
        r17 = "Network error: ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x02eb, code lost:
        r4 = r0;
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x02ef, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x02f0, code lost:
        r9 = "Network error: ";
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x02f4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02f6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x02f7, code lost:
        r9 = "Network error: ";
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x02fb, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x02fc, code lost:
        r9 = "Network error: ";
        r11 = null;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x043f: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:251:0x043d */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x043e: MOVE  (r7 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:251:0x043d */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0275 A[Catch: Exception -> 0x0279, TRY_LEAVE, TryCatch #37 {Exception -> 0x0279, blocks: (B:150:0x0270, B:152:0x0275), top: B:261:0x0270 }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x044e A[Catch: Exception -> 0x0452, TRY_LEAVE, TryCatch #70 {Exception -> 0x0452, blocks: (B:253:0x0449, B:255:0x044e), top: B:267:0x0449 }] */
    @Override // com.helpshift.network.HTTPTransport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.helpshift.network.HSResponse makeRequest(com.helpshift.network.HSRequest r20) {
        /*
            Method dump skipped, instructions count: 1112
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.network.HSHttpTransport.makeRequest(com.helpshift.network.HSRequest):com.helpshift.network.HSResponse");
    }

    private String readStream(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            Utils.closeQuietly(bufferedReader);
                            Utils.closeQuietly(inputStreamReader);
                            return sb.toString();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.closeQuietly(bufferedReader);
                        Utils.closeQuietly(inputStreamReader);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }
}
