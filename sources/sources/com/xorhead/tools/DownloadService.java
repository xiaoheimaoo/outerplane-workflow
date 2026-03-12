package com.xorhead.tools;

import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.PeriodicWorkRequest;
import com.singular.sdk.internal.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class DownloadService extends BroadcastReceiver {
    private static final long DOWNLOAD_ID_ERROR = -1;
    private static final String LOG_TAG = "BackgroundDownloader";
    private static Context context;
    private static float currentDownloadSize;
    private static String[] destinationPaths;
    private static String downloadingString;
    private static String endString;
    private static long[] fileSizes;
    private static Handler handler;
    private static int index;
    private static long lastDownloadId;
    private static DownloadManager mCachedDownloadManager;
    private static int maxCount;
    private static Runnable runnable;
    private static String startString;
    private static float totalDownloadSize;
    private static String[] urls;
    private static ColumnIndexCache mIndexCache = new ColumnIndexCache();
    private static HashMap<Long, Long> downloadMap = null;
    private static Boolean completeDownload = false;
    private static Boolean stopDownload = false;

    public static void startDownloads(Context context2, String[] strArr, String[] strArr2, long[] jArr, float f, float f2, String str, String str2, String str3) throws MalformedURLException {
        context = context2;
        urls = strArr;
        destinationPaths = strArr2;
        startString = str;
        downloadingString = str2;
        endString = str3;
        fileSizes = jArr;
        maxCount = strArr.length;
        downloadMap = new HashMap<>();
        totalDownloadSize = f;
        currentDownloadSize = f2;
        lastDownloadId = 0L;
        index = -1;
        completeDownload = false;
        stopDownload = false;
        Context context3 = context;
        if (context3 == null) {
            return;
        }
        getDownloadManager(context3);
        for (int i = 0; i < 20; i++) {
            RunDownload();
        }
        ShowNotify(startString);
        handler = new Handler(Looper.getMainLooper());
        Runnable runnable2 = new Runnable() { // from class: com.xorhead.tools.DownloadService.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadService.ShowNotify(String.format(DownloadService.downloadingString, String.valueOf((int) ((((int) DownloadService.currentDownloadSize) / ((int) DownloadService.totalDownloadSize)) * 100.0f)) + "%"));
                DownloadService.handler.postDelayed(this, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
            }
        };
        runnable = runnable2;
        handler.postDelayed(runnable2, 600000L);
    }

    private static synchronized void RunDownload() {
        synchronized (DownloadService.class) {
            if (stopDownload.booleanValue()) {
                return;
            }
            int i = index + 1;
            index = i;
            String[] strArr = urls;
            if (i >= strArr.length) {
                return;
            }
            Long valueOf = Long.valueOf(download(context, strArr[i], destinationPaths[i], startString, endString, 2));
            if (valueOf.longValue() != -1) {
                Log.d("Unity", "download start : " + urls[index] + "  download id : " + valueOf);
                downloadMap.put(valueOf, Long.valueOf(fileSizes[index]));
                if (maxCount - 1 == index) {
                    lastDownloadId = valueOf.longValue();
                    handler.removeCallbacks(runnable);
                }
            } else {
                Log.d("Unity", "download start fail url : " + urls[index]);
            }
        }
    }

    public static void stopDownloads(Context context2) {
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.removeCallbacks(runnable);
        }
        stopDownload = true;
        if (context == null) {
            return;
        }
        destinationPaths = null;
        if (mCachedDownloadManager == null) {
            return;
        }
        try {
            for (Long l : (Long[]) downloadMap.keySet().toArray(new Long[(int) downloadMap.keySet().stream().count()])) {
                ParcelFileDescriptor openDownloadedFile = mCachedDownloadManager.openDownloadedFile(l.longValue());
                if (openDownloadedFile != null) {
                    openDownloadedFile.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context2, Intent intent) {
        if (stopDownload.booleanValue()) {
            return;
        }
        String action = intent != null ? intent.getAction() : null;
        if (action == null) {
            return;
        }
        if (action.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
            long longExtra = intent.getLongExtra("extra_download_id", 0L);
            if (lastDownloadId == longExtra) {
                Handler handler2 = handler;
                if (handler2 != null) {
                    handler2.removeCallbacks(runnable);
                }
                ShowNotify(endString);
                return;
            }
            HashMap<Long, Long> hashMap = downloadMap;
            if (hashMap == null || !hashMap.containsKey(Long.valueOf(longExtra))) {
                return;
            }
            Log.d("Unity", "complete downloadID : " + longExtra + ", download size : " + downloadMap.get(Long.valueOf(longExtra)));
            currentDownloadSize += ((float) downloadMap.get(Long.valueOf(longExtra)).longValue()) / 1048576.0f;
            downloadMap.remove(Long.valueOf(longExtra));
            RunDownload();
            return;
        }
        long longExtra2 = intent.getLongExtra("extra_download_id", 0L);
        HashMap<Long, Long> hashMap2 = downloadMap;
        if (hashMap2 == null || !hashMap2.containsKey(Long.valueOf(longExtra2))) {
            return;
        }
        Log.d("Unity", "download error! : " + action);
    }

    public static long download(Context context2, String str, String str2, String str3, String str4, int i) {
        if (stopDownload.booleanValue() || context2 == null || str == null || str.isEmpty()) {
            return -1L;
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setTitle(str3).setDescription(str4).setDestinationUri(Uri.fromFile(new File(str2))).setNotificationVisibility(i);
        return getDownloadManager(context2).enqueue(request);
    }

    public static void cancelDownload(Context context2, long j) {
        if (j == -1) {
            return;
        }
        getDownloadManager(context2).remove(j);
    }

    public static float getDownloadProgress(Context context2, long j) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(j);
        Cursor query2 = getDownloadManager(context2).query(query);
        try {
            if (query2.moveToFirst()) {
                long j2 = query2.getLong(mIndexCache.getColumnIndex(query2, "total_size"));
                if (j2 == -1) {
                    j2 = 1;
                }
                return ((float) query2.getLong(mIndexCache.getColumnIndex(query2, "bytes_so_far"))) / ((float) j2);
            }
            Log.e(LOG_TAG, "No download was found with the given ID.");
            if (query2 != null) {
                query2.close();
                return 0.0f;
            }
            return 0.0f;
        } finally {
            if (query2 != null) {
                query2.close();
            }
        }
    }

    public static long getDownloadOperation(Context context2, String str) {
        Cursor query = getDownloadManager(context2).query(new DownloadManager.Query());
        do {
            try {
                if (!query.moveToNext()) {
                    if (query != null) {
                        query.close();
                        return -1L;
                    }
                    return -1L;
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        } while (!query.getString(mIndexCache.getColumnIndex(query, "uri")).equals(str));
        return query.getLong(mIndexCache.getColumnIndex(query, "_id"));
    }

    private static int getDownloadStatus(Context context2, long j) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(j);
        Cursor query2 = getDownloadManager(context2).query(query);
        try {
            if (query2.moveToFirst()) {
                return query2.getInt(mIndexCache.getColumnIndex(query2, NotificationCompat.CATEGORY_STATUS));
            }
            Log.e(LOG_TAG, "not found..");
            if (query2 != null) {
                query2.close();
                return 16;
            }
            return 16;
        } finally {
            if (query2 != null) {
                query2.close();
            }
        }
    }

    private static DownloadManager getDownloadManager(Context context2) {
        if (context2 == null) {
            throw new IllegalArgumentException("context should not be null!");
        }
        if (mCachedDownloadManager == null) {
            mCachedDownloadManager = (DownloadManager) context2.getSystemService("download");
        }
        return mCachedDownloadManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ShowNotify(String str) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Context context2 = context;
        intent.setClass(context2, context2.getClass());
        intent.setFlags(536870912);
        RingtoneManager.getDefaultUri(2);
        NotificationManagerCompat.from(context).notify(1000, new NotificationCompat.Builder(context, "BackgroundDownload").setSmallIcon(context.getResources().getIdentifier(Constants.SMALL, "drawable", context.getPackageName())).setContentTitle("OuterPlane").setContentText(str).setPriority(2).setContentIntent(PendingIntent.getActivity(context, index + 100, intent, 167772160)).setAutoCancel(true).build());
    }

    private static void ShowProgressNotify() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Context context2 = context;
        intent.setClass(context2, context2.getClass());
        intent.setFlags(536870912);
        RingtoneManager.getDefaultUri(2);
        NotificationManagerCompat.from(context).notify(1000, new NotificationCompat.Builder(context, "BackgroundDownload").setSmallIcon(context.getResources().getIdentifier(Constants.SMALL, "drawable", context.getPackageName())).setContentTitle(downloadingString).setContentText(String.valueOf((int) ((((int) currentDownloadSize) / ((int) totalDownloadSize)) * 100.0f)) + "%").setPriority(2).setProgress((int) totalDownloadSize, (int) currentDownloadSize, false).setContentIntent(PendingIntent.getActivity(context, 101, intent, 167772160)).setAutoCancel(true).build());
    }
}
