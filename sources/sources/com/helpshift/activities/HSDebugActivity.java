package com.helpshift.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.helpshift.R;
import com.helpshift.log.LogCollector;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.storage.SharedPreferencesStore;
import com.helpshift.util.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class HSDebugActivity extends AppCompatActivity {
    private static final String TAG = "Helpshift_DebugAct";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hs__debug_layout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.id.debug_log_message);
        textView.setText("Preparing logs...");
        try {
            HSPersistentStorage hSPersistentStorage = new HSPersistentStorage(new SharedPreferencesStore(this, HSPersistentStorage.FILE_NAME, 0));
            String str = hSPersistentStorage.getDomain() + "." + hSPersistentStorage.getHost();
            String appName = getAppName();
            File file = new File(getFilesDir() + File.separator + LogCollector.LOG_DIR_PATH);
            StringBuilder sb = new StringBuilder();
            File[] listFiles = file.listFiles();
            if (file.exists() && listFiles != null && listFiles.length > 0) {
                Arrays.sort(listFiles);
                for (File file2 : listFiles) {
                    sb.append("Log File: ").append(file2.getName()).append("\n \n");
                    readFileAsString(file2, sb);
                    sb.append("\n \n");
                }
            }
            sendEmailIntent(sb.toString(), str, appName);
            finish();
        } catch (Exception e) {
            Log.e(TAG, "Error when sharing/reading log", e);
            textView.setText("Error preparing logs: " + e.getMessage());
        }
    }

    private void sendEmailIntent(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"bugs@helpshift.com"});
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.SUBJECT", str2 + " / " + str3 + " / " + getPackageName());
        startActivity(Intent.createChooser(intent, "Send email..."));
    }

    private String getAppName() {
        try {
            return getApplicationInfo().loadLabel(getPackageManager()).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private void readFileAsString(File file, StringBuilder sb) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine).append("\n");
                        } else {
                            Utils.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        Log.e(TAG, "Error reading log file: " + file.getName(), e);
                        if (bufferedReader != null) {
                            Utils.closeQuietly(bufferedReader);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            Utils.closeQuietly(bufferedReader);
                        }
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
