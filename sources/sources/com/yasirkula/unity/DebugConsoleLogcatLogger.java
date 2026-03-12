package com.yasirkula.unity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class DebugConsoleLogcatLogger {
    private LogcatWorker worker;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class LogcatWorker implements Runnable {
        private String command;
        private DebugConsoleLogcatLogReceiver logReceiver;
        private volatile boolean running = true;

        public LogcatWorker(DebugConsoleLogcatLogReceiver debugConsoleLogcatLogReceiver, String str) {
            this.logReceiver = debugConsoleLogcatLogReceiver;
            this.command = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runtime.getRuntime().exec("logcat -c");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(this.command).getInputStream()));
                while (this.running) {
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        this.logReceiver.OnLogReceived(readLine);
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        public void terminate() {
            this.running = false;
        }
    }

    public void Start(DebugConsoleLogcatLogReceiver debugConsoleLogcatLogReceiver, String str) {
        String str2;
        Stop();
        if (debugConsoleLogcatLogReceiver == null) {
            return;
        }
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > 0) {
                str2 = "logcat " + trim;
                this.worker = new LogcatWorker(debugConsoleLogcatLogReceiver, str2);
                new Thread(this.worker).start();
            }
        }
        str2 = "logcat";
        this.worker = new LogcatWorker(debugConsoleLogcatLogReceiver, str2);
        new Thread(this.worker).start();
    }

    public void Stop() {
        LogcatWorker logcatWorker = this.worker;
        if (logcatWorker != null) {
            logcatWorker.terminate();
            this.worker = null;
        }
    }
}
