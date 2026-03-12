package com.appsflyer.internal;

import android.content.Context;
import android.util.Base64;
import com.appsflyer.AFLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFc1rSDK implements AFc1uSDK {
    private final AFc1sSDK AFAdRevenueData;
    private final AFc1oSDK getCurrencyIso4217Code;
    private final AFc1gSDK getMediationNetwork;
    private final Map<String, Integer> getRevenue;

    public AFc1rSDK(AFc1gSDK aFc1gSDK, AFc1oSDK aFc1oSDK) {
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFc1oSDK, "");
        this.getMediationNetwork = aFc1gSDK;
        this.getCurrencyIso4217Code = aFc1oSDK;
        this.AFAdRevenueData = new AFc1sSDK(CollectionsKt.listOf((Object[]) new AFc1vSDK[]{new AFc1vSDK("ConversionsCache", CollectionsKt.listOf(AFe1mSDK.CONVERSION), 1), new AFc1vSDK("AttrCache", CollectionsKt.listOf(AFe1mSDK.ATTR), 1), new AFc1vSDK("OtherCache", CollectionsKt.listOf((Object[]) new AFe1mSDK[]{AFe1mSDK.LAUNCH, AFe1mSDK.INAPP, AFe1mSDK.ADREVENUE, AFe1mSDK.ARS_VALIDATE, AFe1mSDK.PURCHASE_VALIDATE, AFe1mSDK.MANUAL_PURCHASE_VALIDATION, AFe1mSDK.SDK_SERVICES}), 40)}));
        this.getRevenue = MapsKt.mutableMapOf(TuplesKt.to("ConversionsCache", 0), TuplesKt.to("AttrCache", 0), TuplesKt.to("OtherCache", 0));
    }

    private final void AFAdRevenueData() {
        for (AFc1vSDK aFc1vSDK : this.AFAdRevenueData.getCurrencyIso4217Code) {
            String str = aFc1vSDK.getCurrencyIso4217Code;
            Context context = this.getMediationNetwork.getRevenue;
            Intrinsics.checkNotNull(context);
            File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
            if (!file.exists()) {
                file.mkdirs();
                this.getRevenue.put(aFc1vSDK.getCurrencyIso4217Code, 0);
            } else {
                Map<String, Integer> map = this.getRevenue;
                String str2 = aFc1vSDK.getCurrencyIso4217Code;
                File[] listFiles = file.listFiles();
                map.put(str2, Integer.valueOf(listFiles != null ? listFiles.length : 0));
            }
        }
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final List<AFc1tSDK> getMediationNetwork() {
        AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Get Cached Requests", false, 4, null);
        ArrayList arrayList = new ArrayList();
        ArrayList<File> arrayList2 = new ArrayList();
        try {
            Context context = this.getMediationNetwork.getRevenue;
            Intrinsics.checkNotNull(context);
            if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                Context context2 = this.getMediationNetwork.getRevenue;
                Intrinsics.checkNotNull(context2);
                new File(context2.getFilesDir(), "AFRequestCache").mkdir();
            }
            for (AFc1vSDK aFc1vSDK : this.AFAdRevenueData.getCurrencyIso4217Code) {
                String str = aFc1vSDK.getCurrencyIso4217Code;
                Context context3 = this.getMediationNetwork.getRevenue;
                Intrinsics.checkNotNull(context3);
                File file = new File(new File(context3.getFilesDir(), "AFRequestCache"), str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    listFiles = new File[0];
                }
                CollectionsKt.addAll(arrayList2, listFiles);
            }
            for (File file2 : arrayList2) {
                AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Found cached request: " + file2.getName(), false, 4, null);
                AFc1tSDK AFAdRevenueData = AFAdRevenueData(file2);
                if (AFAdRevenueData != null) {
                    arrayList.add(AFAdRevenueData);
                }
            }
        } catch (Exception e) {
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not get cached requests", e, false, false, false, false, 120, null);
        }
        AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Found " + arrayList.size() + " Cached Requests", false, 4, null);
        return arrayList;
    }

    private static AFc1tSDK AFAdRevenueData(File file) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charset.defaultCharset());
            char[] cArr = new char[(int) file.length()];
            inputStreamReader.read(cArr);
            AFc1tSDK aFc1tSDK = new AFc1tSDK(cArr);
            aFc1tSDK.getMediationNetwork = file.getName();
            CloseableKt.closeFinally(inputStreamReader, null);
            return aFc1tSDK;
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.CACHE, "Error while loading request from cache", e, false, false, true, false);
            return null;
        }
    }

    private final boolean getMonetizationNetwork(File file) {
        try {
            file.delete();
            AFAdRevenueData();
            return true;
        } catch (Exception e) {
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not delete " + file.getName() + " from cache", e, false, false, false, false, 120, null);
            return false;
        }
    }

    private final AFc1vSDK getMonetizationNetwork(AFe1mSDK aFe1mSDK) {
        Object obj;
        Iterator<T> it = this.AFAdRevenueData.getCurrencyIso4217Code.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((AFc1vSDK) obj).AFAdRevenueData.contains(aFe1mSDK)) {
                break;
            }
        }
        return (AFc1vSDK) obj;
    }

    private final String getCurrencyIso4217Code(AFe1mSDK aFe1mSDK) {
        String str;
        AFc1vSDK monetizationNetwork = getMonetizationNetwork(aFe1mSDK);
        if (monetizationNetwork == null || (str = monetizationNetwork.getCurrencyIso4217Code) == null) {
            throw new UnsupportedOperationException("Cache do not support this type of events");
        }
        return str;
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final void getCurrencyIso4217Code() {
        try {
            if (this.getCurrencyIso4217Code.getMediationNetwork("AF_CACHE_VERSION", -1) == 1) {
                Context context = this.getMediationNetwork.getRevenue;
                Intrinsics.checkNotNull(context);
                if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                    Context context2 = this.getMediationNetwork.getRevenue;
                    Intrinsics.checkNotNull(context2);
                    new File(context2.getFilesDir(), "AFRequestCache").mkdir();
                }
            } else {
                this.getCurrencyIso4217Code.getRevenue("AF_CACHE_VERSION", 1);
                Context context3 = this.getMediationNetwork.getRevenue;
                Intrinsics.checkNotNull(context3);
                if (new File(context3.getFilesDir(), "AFRequestCache").exists()) {
                    Context context4 = this.getMediationNetwork.getRevenue;
                    Intrinsics.checkNotNull(context4);
                    FilesKt.deleteRecursively(new File(context4.getFilesDir(), "AFRequestCache"));
                    Context context5 = this.getMediationNetwork.getRevenue;
                    Intrinsics.checkNotNull(context5);
                    new File(context5.getFilesDir(), "AFRequestCache").mkdir();
                }
            }
            AFAdRevenueData();
        } catch (Exception e) {
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not init cache", e, false, false, false, false, 120, null);
        }
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final String getMonetizationNetwork(AFc1tSDK aFc1tSDK) {
        File file;
        String valueOf;
        String str;
        List sortedWith;
        List<File> take;
        Intrinsics.checkNotNullParameter(aFc1tSDK, "");
        try {
            AFe1mSDK aFe1mSDK = aFc1tSDK.AFAdRevenueData;
            Intrinsics.checkNotNullExpressionValue(aFe1mSDK, "");
            Context context = this.getMediationNetwork.getRevenue;
            Intrinsics.checkNotNull(context);
            File file2 = new File(new File(context.getFilesDir(), "AFRequestCache"), getCurrencyIso4217Code(aFe1mSDK));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Caching request with URL: " + aFc1tSDK.getCurrencyIso4217Code, false, 4, null);
            valueOf = String.valueOf(System.currentTimeMillis());
            file = new File(file2, valueOf);
        } catch (Exception e) {
            e = e;
            file = null;
        }
        try {
            file.createNewFile();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file.getPath(), true), Charset.defaultCharset());
            OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
            outputStreamWriter2.write("version=");
            outputStreamWriter2.write(aFc1tSDK.getRevenue);
            outputStreamWriter2.write(10);
            outputStreamWriter2.write("url=");
            outputStreamWriter2.write(aFc1tSDK.getCurrencyIso4217Code);
            outputStreamWriter2.write(10);
            outputStreamWriter2.write("data=");
            outputStreamWriter2.write(Base64.encodeToString(aFc1tSDK.getMonetizationNetwork(), 2));
            outputStreamWriter2.write(10);
            AFe1mSDK aFe1mSDK2 = aFc1tSDK.AFAdRevenueData;
            outputStreamWriter2.write("type=");
            outputStreamWriter2.write(aFe1mSDK2.name());
            outputStreamWriter2.write(10);
            outputStreamWriter2.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter, null);
            AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Cache request: done, cacheKey: " + valueOf, false, 4, null);
            AFe1mSDK aFe1mSDK3 = aFc1tSDK.AFAdRevenueData;
            Intrinsics.checkNotNullExpressionValue(aFe1mSDK3, "");
            AFc1vSDK monetizationNetwork = getMonetizationNetwork(aFe1mSDK3);
            Integer valueOf2 = monetizationNetwork != null ? Integer.valueOf(monetizationNetwork.getMediationNetwork) : null;
            if (valueOf2 != null) {
                int intValue = valueOf2.intValue();
                Map<String, Integer> map = this.getRevenue;
                AFc1vSDK monetizationNetwork2 = getMonetizationNetwork(aFe1mSDK3);
                if (monetizationNetwork2 != null && (str = monetizationNetwork2.getCurrencyIso4217Code) != null) {
                    Integer num = map.get(str);
                    int intValue2 = num != null ? num.intValue() : 0;
                    if (intValue2 >= intValue) {
                        int i = (intValue2 + 1) - intValue;
                        AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Cache overflown for type " + aFe1mSDK3 + ", removing " + i + " item(s)", false, 4, null);
                        Context context2 = this.getMediationNetwork.getRevenue;
                        Intrinsics.checkNotNull(context2);
                        File file3 = new File(new File(context2.getFilesDir(), "AFRequestCache"), getCurrencyIso4217Code(aFe1mSDK3));
                        if (!file3.exists()) {
                            file3.mkdirs();
                        }
                        File[] listFiles = file3.listFiles();
                        if (listFiles != null && (sortedWith = ArraysKt.sortedWith(listFiles, new Comparator() { // from class: com.appsflyer.internal.AFc1rSDK.1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((File) t).getName(), ((File) t2).getName());
                            }
                        })) != null && (take = CollectionsKt.take(sortedWith, i)) != null) {
                            for (File file4 : take) {
                                file4.delete();
                                AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Cache entry " + file4.getName() + " removed", false, 4, null);
                            }
                        }
                    }
                    AFAdRevenueData();
                } else {
                    throw new UnsupportedOperationException("Cache do not support this type of events");
                }
            }
            return valueOf;
        } catch (Exception e2) {
            e = e2;
            if (file != null) {
                file.delete();
            }
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not cache request", e, false, false, false, false, 120, null);
            return null;
        }
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final boolean getCurrencyIso4217Code(String str) {
        if (str == null) {
            return false;
        }
        Context context = this.getMediationNetwork.getRevenue;
        Intrinsics.checkNotNull(context);
        if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
            Context context2 = this.getMediationNetwork.getRevenue;
            Intrinsics.checkNotNull(context2);
            new File(context2.getFilesDir(), "AFRequestCache").mkdir();
            return true;
        }
        AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Deleting " + str + " from cache", false, 4, null);
        for (AFc1vSDK aFc1vSDK : this.AFAdRevenueData.getCurrencyIso4217Code) {
            String str2 = aFc1vSDK.getCurrencyIso4217Code;
            Context context3 = this.getMediationNetwork.getRevenue;
            Intrinsics.checkNotNull(context3);
            File file = new File(new File(new File(context3.getFilesDir(), "AFRequestCache"), str2), str);
            if (file.exists()) {
                return getMonetizationNetwork(file);
            }
        }
        return true;
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final void getMonetizationNetwork() {
        try {
            Context context = this.getMediationNetwork.getRevenue;
            Intrinsics.checkNotNull(context);
            if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                Context context2 = this.getMediationNetwork.getRevenue;
                Intrinsics.checkNotNull(context2);
                new File(context2.getFilesDir(), "AFRequestCache").mkdir();
                return;
            }
            for (AFc1vSDK aFc1vSDK : this.AFAdRevenueData.getCurrencyIso4217Code) {
                String str = aFc1vSDK.getCurrencyIso4217Code;
                Context context3 = this.getMediationNetwork.getRevenue;
                Intrinsics.checkNotNull(context3);
                File[] listFiles = new File(new File(context3.getFilesDir(), "AFRequestCache"), str).listFiles();
                if (listFiles != null) {
                    Intrinsics.checkNotNullExpressionValue(listFiles, "");
                    for (File file : listFiles) {
                        AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "ClearCache : Found cached request " + file.getName(), false, 4, null);
                        AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Deleting " + file.getName() + " from cache", false, 4, null);
                        file.delete();
                    }
                }
            }
            Context context4 = this.getMediationNetwork.getRevenue;
            Intrinsics.checkNotNull(context4);
            FilesKt.deleteRecursively(new File(context4.getFilesDir(), "AFRequestCache"));
            AFAdRevenueData();
        } catch (Exception e) {
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not clearCache request", e, false, false, false, false, 120, null);
        }
    }
}
