package com.helpshift.util;

import com.helpshift.log.HSLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes3.dex */
public class FileUtil {
    private static final String TAG = "fileutil";

    private FileUtil() {
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0041: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:17:0x0041 */
    public static String readFileToString(String str) {
        FileInputStream fileInputStream;
        Exception e;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                File file = new File(str);
                fileInputStream = new FileInputStream(file);
                try {
                    int length = (int) file.length();
                    byte[] bArr = new byte[length];
                    fileInputStream.read(bArr, 0, length);
                    String str2 = new String(bArr);
                    Utils.closeQuietly(fileInputStream);
                    return str2;
                } catch (Exception e2) {
                    e = e2;
                    HSLogger.e(TAG, "Error reading file: " + str, e);
                    Utils.closeQuietly(fileInputStream);
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                Utils.closeQuietly(closeable2);
                throw th;
            }
        } catch (Exception e3) {
            fileInputStream = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            Utils.closeQuietly(closeable2);
            throw th;
        }
    }

    public static void deleteDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (file.delete()) {
                    return;
                }
                HSLogger.d(TAG, "Failed to delete directory : " + str);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2.getAbsolutePath());
                }
                if (!file2.delete()) {
                    HSLogger.d(TAG, "Failed to delete file : " + file2.getPath());
                }
            }
            if (file.delete()) {
                return;
            }
            HSLogger.d(TAG, "Failed to delete directory : " + str);
        }
    }
}
