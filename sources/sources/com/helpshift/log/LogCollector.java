package com.helpshift.log;

import android.content.Context;
import android.util.Log;
import com.helpshift.log.ILogger;
import java.io.File;
import java.io.FileOutputStream;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class LogCollector {
    public static final String LOG_DIR_PATH = "helpshift" + File.separator + "debugLogs";
    private static final String TAG = "Heplshift_LogCollector";
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private FileOutputStream fos;
    private final File logFile;
    private final long mainThreadId;

    public LogCollector(Context context, String str, long j) {
        File file = new File(context.getFilesDir(), LOG_DIR_PATH);
        file.mkdirs();
        deleteOldFiles(file);
        this.logFile = new File(file, str + ".txt");
        this.mainThreadId = j;
    }

    public void collectLog(final String str, final String str2, final Throwable th, final ILogger.LEVEL level) {
        final long currentTimeMillis = System.currentTimeMillis();
        final long id = Thread.currentThread().getId();
        if (this.fos == null) {
            try {
                this.fos = new FileOutputStream(this.logFile, true);
            } catch (Exception e) {
                Log.e(TAG, "Error opening debug log file: " + this.logFile.getAbsolutePath(), e);
                return;
            }
        }
        try {
            this.executorService.submit(new Runnable() { // from class: com.helpshift.log.LogCollector.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(currentTimeMillis));
                        StringBuilder sb = new StringBuilder();
                        sb.append(format).append(" ").append(LogCollector.this.mainThreadId).append("-").append(id).append(" ").append(level.name()).append("/").append(str).append(" ").append(str2);
                        Throwable th2 = th;
                        sb.append("\n").append(th2 instanceof UnknownHostException ? th2.getMessage() : Log.getStackTraceString(th2)).append("\n");
                        LogCollector.this.fos.write(sb.toString().getBytes());
                    } catch (Exception e2) {
                        Log.e(LogCollector.TAG, "Error writing to debug log file", e2);
                    }
                }
            });
        } catch (Exception e2) {
            Log.e(TAG, "Error submitting to executor", e2);
        }
    }

    private void deleteOldFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 5) {
            return;
        }
        Arrays.sort(listFiles);
        for (int i = 0; i < listFiles.length - 5; i++) {
            if (!listFiles[i].delete()) {
                Log.e(TAG, "File not deleted: " + listFiles[i]);
            }
        }
    }

    public static String getLogFileName() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(System.currentTimeMillis()));
    }
}
