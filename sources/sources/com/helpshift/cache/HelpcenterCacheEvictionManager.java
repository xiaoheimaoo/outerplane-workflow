package com.helpshift.cache;

import com.helpshift.log.HSLogger;
import com.helpshift.storage.HSPersistentStorage;
import java.io.File;
/* loaded from: classes3.dex */
public class HelpcenterCacheEvictionManager {
    private static final long CACHE_EVICTION_OPERATION_INTERVAL = 604800000;
    private static final long MAX_CACHE_INTERVAL = 2592000000L;
    private static final String TAG = "HCCacheEvctnMngr";
    private final String appFileDirPath;
    private final HSPersistentStorage persistentStorage;
    private String subdirPath;

    public HelpcenterCacheEvictionManager(HSPersistentStorage hSPersistentStorage, String str, String str2) {
        this.persistentStorage = hSPersistentStorage;
        this.appFileDirPath = str;
        this.subdirPath = str2;
    }

    public void deleteOlderHelpcenterCachedFiles() {
        long currentTimeMillis = System.currentTimeMillis();
        long lastHCCacheEvictedTime = this.persistentStorage.getLastHCCacheEvictedTime();
        if (lastHCCacheEvictedTime == 0) {
            updateLastCacheEvictedTime(currentTimeMillis);
        } else if (currentTimeMillis - lastHCCacheEvictedTime >= 604800000) {
            updateLastCacheEvictedTime(currentTimeMillis);
            File[] listFiles = new File(getResourceCacheDirPath()).listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            for (File file : listFiles) {
                long lastModified = file.lastModified();
                if (lastModified != 0 && currentTimeMillis - lastModified > MAX_CACHE_INTERVAL && !file.delete()) {
                    HSLogger.d(TAG, "Failed to delete file : " + file.getPath());
                }
            }
        }
    }

    private void updateLastCacheEvictedTime(long j) {
        this.persistentStorage.setLastHCCacheEvictedTime(j);
    }

    private String getResourceCacheDirPath() {
        return this.appFileDirPath + File.separator + "helpshift" + File.separator + "resource_cache" + File.separator + this.subdirPath;
    }
}
