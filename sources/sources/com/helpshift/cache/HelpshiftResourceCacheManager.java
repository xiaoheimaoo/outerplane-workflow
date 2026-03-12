package com.helpshift.cache;

import com.google.common.net.HttpHeaders;
import com.helpshift.log.HSLogger;
import com.helpshift.network.HSDownloaderNetwork;
import com.helpshift.network.HSDownloaderResponse;
import com.helpshift.storage.ISharedPreferencesStore;
import com.helpshift.util.FileUtil;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HelpshiftResourceCacheManager {
    private static final String CACHE_URL_MAPPING_ETAG = "url_mapping_etag";
    private static final String CACHE_URL_MAPPING_LAST_SUCCESS_TIME = "url_mapping_last_success_time";
    private static final String ETAG_SUFFIX = "_etag";
    private static final String HEADERS_SUFFIX = "_headers";
    private static final String MIMETYPE_SUFFIX = "_mimetype";
    private static final String RESOURCE_LAST_SUCCESS_TIME_SUFFIX = "_last_success_time";
    private static final String TAG = "resCacheMngr";
    private final String appFileDirPath;
    private Map<String, Long> cacheURLMapping = new HashMap();
    private String cacheUrlConfigFileName;
    private String cacheUrlConfigRoute;
    private final HSDownloaderNetwork hsDownloaderNetwork;
    private final ResourceCacheEvictStrategy resourceCacheEvictStrategy;
    private final ISharedPreferencesStore resourceCacheSharedPref;
    private String subdirPath;

    public HelpshiftResourceCacheManager(ISharedPreferencesStore iSharedPreferencesStore, HSDownloaderNetwork hSDownloaderNetwork, ResourceCacheEvictStrategy resourceCacheEvictStrategy, String str, String str2, String str3, String str4) {
        this.hsDownloaderNetwork = hSDownloaderNetwork;
        this.resourceCacheSharedPref = iSharedPreferencesStore;
        this.resourceCacheEvictStrategy = resourceCacheEvictStrategy;
        this.appFileDirPath = str;
        this.cacheUrlConfigRoute = str2;
        this.cacheUrlConfigFileName = str3;
        this.subdirPath = str4;
    }

    public boolean shouldCacheUrl(String str) {
        boolean z = false;
        if (Utils.isEmpty(str)) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = this.cacheURLMapping.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (str.startsWith(it.next().getKey())) {
                z = true;
                break;
            }
        }
        HSLogger.d(TAG, "Should cache url? " + z + "   with path - " + str);
        return z;
    }

    private long getTTLForResource(String str) {
        if (Utils.isEmpty(str)) {
            return 0L;
        }
        Long l = 0L;
        Iterator<Map.Entry<String, Long>> it = this.cacheURLMapping.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Long> next = it.next();
            if (str.startsWith(next.getKey())) {
                l = this.cacheURLMapping.get(next.getKey());
                break;
            }
        }
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void ensureCacheURLsListAvailable() {
        String string = getString(CACHE_URL_MAPPING_ETAG);
        long j = getLong(CACHE_URL_MAPPING_LAST_SUCCESS_TIME);
        File file = new File(getCacheURLsConfigFilePath());
        boolean exists = file.exists();
        if (!exists) {
            file.getParentFile().mkdirs();
            string = "";
        }
        if (!exists || Utils.isEmpty(string) || j < System.currentTimeMillis() - getCacheURLsConfigTTL() || j < System.currentTimeMillis() - Utils.TIME_7DAYS_MILLIS) {
            fetchCacheURLsMapping(string, file);
        }
        this.cacheURLMapping = getCacheURLMapping();
    }

    private Map<String, Long> getCacheURLMapping() {
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONObject(FileUtil.readFileToString(getCacheURLsConfigFilePath())).getJSONArray("url_paths");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                hashMap.put(jSONObject.getString("path"), Long.valueOf(jSONObject.optLong("ttl", Utils.TIME_24HRS_MILLIS)));
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error getting URLs mapping", e);
        }
        return hashMap;
    }

    private long getCacheURLsConfigTTL() {
        try {
            return new JSONObject(FileUtil.readFileToString(getCacheURLsConfigFilePath())).optLong("ttl", Utils.TIME_24HRS_MILLIS);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error getting cache mapping ttl", e);
            return Utils.TIME_24HRS_MILLIS;
        }
    }

    private void fetchCacheURLsMapping(String str, File file) {
        HashMap hashMap = new HashMap();
        if (Utils.isNotEmpty(str)) {
            hashMap.put(HttpHeaders.IF_NONE_MATCH, str);
        }
        HSDownloaderResponse downloadResource = this.hsDownloaderNetwork.downloadResource(this.cacheUrlConfigRoute, hashMap, file);
        if (!downloadResource.isSuccess) {
            HSLogger.e(TAG, "Failed to download the URLs mapping file " + this.cacheUrlConfigRoute + " Error code " + downloadResource.status);
            return;
        }
        setString(CACHE_URL_MAPPING_ETAG, downloadResource.etag);
        setLong(CACHE_URL_MAPPING_LAST_SUCCESS_TIME, System.currentTimeMillis());
    }

    public InputStream fetchCachedResource(String str, String str2, String str3, Map<String, String> map) {
        String generateStorageKey = generateStorageKey(str2, str3);
        String str4 = generateStorageKey + RESOURCE_LAST_SUCCESS_TIME_SUFFIX;
        long j = this.resourceCacheSharedPref.getLong(str4);
        String str5 = generateStorageKey + ETAG_SUFFIX;
        String string = this.resourceCacheSharedPref.getString(str5);
        long tTLForResource = getTTLForResource(str2);
        String resourceCacheDirPath = getResourceCacheDirPath();
        String str6 = resourceCacheDirPath + File.separator + generateStorageKey;
        File file = new File(str6);
        boolean exists = file.exists();
        try {
            if (shouldFetchNewResource(exists, string, j, tTLForResource)) {
                if (!exists) {
                    file.getParentFile().mkdirs();
                    string = "";
                }
                String str7 = string;
                File file2 = new File(str6 + "_temp");
                if (Utils.isNotEmpty(str7)) {
                    map.put(HttpHeaders.IF_NONE_MATCH, str7);
                }
                HSDownloaderResponse downloadResource = this.hsDownloaderNetwork.downloadResource(str, map, file2);
                if (!downloadResource.isSuccess) {
                    HSLogger.e(TAG, "Failed to download the cache resource " + str + " Error Code " + downloadResource.status);
                    return null;
                } else if (!updateCache(downloadResource, str5, str4, file, file2, generateStorageKey)) {
                    return null;
                } else {
                    deleteOlderCachedResources(resourceCacheDirPath, str2, file.getName());
                }
            }
            return new BufferedInputStream(new FileInputStream(file));
        } catch (Exception e) {
            HSLogger.e(TAG, "Error while fetching resource file: " + str, e);
            return null;
        }
    }

    private boolean shouldFetchNewResource(boolean z, String str, long j, long j2) {
        return !z || Utils.isEmpty(str) || j < System.currentTimeMillis() - j2 || j < System.currentTimeMillis() - Utils.TIME_7DAYS_MILLIS;
    }

    private boolean updateCache(HSDownloaderResponse hSDownloaderResponse, String str, String str2, File file, File file2, String str3) {
        setString(str, hSDownloaderResponse.etag);
        setLong(str2, System.currentTimeMillis());
        int i = hSDownloaderResponse.status;
        if (i < 200 || i > 300) {
            return true;
        }
        if (!file.delete()) {
            HSLogger.d(TAG, "Failed to delete file : " + file.getAbsolutePath());
        }
        if (!file2.renameTo(file)) {
            HSLogger.e(TAG, "Failed to rename temporary file: " + file2.getAbsolutePath());
            return false;
        }
        String str4 = str3 + MIMETYPE_SUFFIX;
        String str5 = hSDownloaderResponse.mimetype;
        if (str5.contains("text/html")) {
            str5 = "text/html";
        }
        if (Utils.isNotEmpty(str5)) {
            setString(str4, str5);
        }
        setString(str3 + HEADERS_SUFFIX, hSDownloaderResponse.headers.toString());
        return true;
    }

    private void deleteOlderCachedResources(String str, String str2, String str3) {
        deleteOlderCachedResource(str, str2, str3);
    }

    private void deleteOlderCachedResource(String str, String str2, String str3) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        String generateStorageKey = generateStorageKey(str2, null);
        for (File file : listFiles) {
            String name = file.getName();
            if (!name.equals(str3) && this.resourceCacheEvictStrategy.shouldEvictCache(name, generateStorageKey) && !file.delete()) {
                HSLogger.d(TAG, "Failed to delete file : " + file.getPath());
            }
        }
    }

    public Map<String, String> getCachedResponseHeadersForResource(String str, String str2) {
        return JsonUtils.jsonStringToStringMap(getString(generateStorageKey(str, str2) + HEADERS_SUFFIX));
    }

    public String getResourceMimeType(String str, String str2) {
        return this.resourceCacheSharedPref.getString(generateStorageKey(str, str2) + MIMETYPE_SUFFIX);
    }

    private String generateStorageKey(String str, String str2) {
        StringBuilder append = new StringBuilder().append(str).append("_");
        if (str2 == null) {
            str2 = "";
        }
        return append.append(str2).toString().replaceAll("[^a-zA-Z0-9]", "_");
    }

    private String getResourceCacheDirPath() {
        return this.appFileDirPath + File.separator + "helpshift" + File.separator + "resource_cache" + File.separator + this.subdirPath;
    }

    private String getCacheURLsConfigFilePath() {
        return getResourceCacheDirPath() + File.separator + this.cacheUrlConfigFileName;
    }

    private void setString(String str, String str2) {
        this.resourceCacheSharedPref.putString(str, str2);
    }

    private void setLong(String str, long j) {
        this.resourceCacheSharedPref.putLong(str, j);
    }

    private String getString(String str) {
        return this.resourceCacheSharedPref.getString(str);
    }

    private long getLong(String str) {
        return this.resourceCacheSharedPref.getLong(str);
    }

    public void deleteAllCachedFiles() {
        FileUtil.deleteDir(getResourceCacheDirPath());
        this.resourceCacheSharedPref.clear();
        this.cacheURLMapping.clear();
    }
}
