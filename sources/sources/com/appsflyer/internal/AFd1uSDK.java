package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1cSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFd1uSDK implements AFd1zSDK {
    private final AFc1gSDK getCurrencyIso4217Code;

    public AFd1uSDK(AFc1gSDK aFc1gSDK) {
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        this.getCurrencyIso4217Code = aFc1gSDK;
    }

    private final File getMonetizationNetwork() {
        Context context = this.getCurrencyIso4217Code.getRevenue;
        if (context != null) {
            File file = new File(context.getFilesDir(), "AFExceptionsCache");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    public final String getRevenue(Throwable th, String str) {
        String str2;
        File file;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            str2 = null;
            if (monetizationNetwork != null) {
                file = new File(monetizationNetwork, "6.17.3");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else {
                file = null;
            }
            if (file != null) {
                try {
                    AFc1cSDK AFAdRevenueData = AFd1pSDK.AFAdRevenueData(th, str);
                    String str3 = AFAdRevenueData.getRevenue;
                    File file2 = new File(file, str3);
                    if (file2.exists()) {
                        AFc1cSDK.AFa1vSDK aFa1vSDK = AFc1cSDK.AFa1vSDK;
                        AFc1cSDK currencyIso4217Code = AFc1cSDK.AFa1vSDK.getCurrencyIso4217Code(FilesKt.readText$default(file2, null, 1, null));
                        if (currencyIso4217Code != null) {
                            currencyIso4217Code.getCurrencyIso4217Code++;
                            AFAdRevenueData = currencyIso4217Code;
                        }
                    }
                    FilesKt.writeText$default(file2, AFAdRevenueData.getMediationNetwork(), null, 2, null);
                    str2 = str3;
                } catch (Exception e) {
                    AFh1ySDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "Could not cache exception\n " + e.getMessage(), false, 4, null);
                }
            }
        }
        return str2;
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    public final List<AFc1cSDK> getMediationNetwork() {
        List<AFc1cSDK> list;
        File[] listFiles;
        ArrayList arrayList;
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            list = null;
            if (monetizationNetwork != null && (listFiles = monetizationNetwork.listFiles()) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (File file : listFiles) {
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 != null) {
                        Intrinsics.checkNotNullExpressionValue(listFiles2, "");
                        ArrayList arrayList3 = new ArrayList();
                        for (File file2 : listFiles2) {
                            AFc1cSDK.AFa1vSDK aFa1vSDK = AFc1cSDK.AFa1vSDK;
                            Intrinsics.checkNotNullExpressionValue(file2, "");
                            AFc1cSDK currencyIso4217Code = AFc1cSDK.AFa1vSDK.getCurrencyIso4217Code(FilesKt.readText$default(file2, null, 1, null));
                            if (currencyIso4217Code != null) {
                                arrayList3.add(currencyIso4217Code);
                            }
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        arrayList2.add(arrayList);
                    }
                }
                list = CollectionsKt.flatten(arrayList2);
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
        }
        return list;
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    public final int AFAdRevenueData() {
        int i = 0;
        for (AFc1cSDK aFc1cSDK : getMediationNetwork()) {
            i += aFc1cSDK.getCurrencyIso4217Code;
        }
        return i;
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    public final boolean getCurrencyIso4217Code() {
        return getCurrencyIso4217Code(new String[0]);
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    public final boolean getCurrencyIso4217Code(String... strArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(strArr, "");
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            z = true;
            if (monetizationNetwork != null) {
                if (strArr.length == 0) {
                    AFh1ySDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions", false, 4, null);
                    z = FilesKt.deleteRecursively(monetizationNetwork);
                } else {
                    AFh1ySDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions except for: " + ArraysKt.joinToString$default(strArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), false, 4, null);
                    File[] listFiles = monetizationNetwork.listFiles();
                    if (listFiles != null) {
                        Intrinsics.checkNotNullExpressionValue(listFiles, "");
                        ArrayList arrayList = new ArrayList();
                        for (File file : listFiles) {
                            if (!ArraysKt.contains(strArr, file.getName())) {
                                arrayList.add(file);
                            }
                        }
                        ArrayList<File> arrayList2 = arrayList;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                        for (File file2 : arrayList2) {
                            Intrinsics.checkNotNullExpressionValue(file2, "");
                            arrayList3.add(Boolean.valueOf(FilesKt.deleteRecursively(file2)));
                        }
                        Set set = CollectionsKt.toSet(arrayList3);
                        if (set.isEmpty()) {
                            set = SetsKt.setOf(Boolean.TRUE);
                        }
                        Set set2 = set;
                        if (set2.size() != 1 || !((Boolean) CollectionsKt.first(set2)).booleanValue()) {
                            z = false;
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.appsflyer.internal.AFd1zSDK
    public final void getMediationNetwork(int i, int i2) {
        File[] listFiles;
        synchronized (this) {
            File monetizationNetwork = getMonetizationNetwork();
            if (monetizationNetwork != null && (listFiles = monetizationNetwork.listFiles()) != null) {
                Intrinsics.checkNotNullExpressionValue(listFiles, "");
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "");
                    int mediationNetwork = AFk1zSDK.getMediationNetwork(name);
                    if (!(i <= mediationNetwork && mediationNetwork <= i2)) {
                        arrayList.add(file);
                    }
                }
                ArrayList<File> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (File file2 : arrayList2) {
                    Intrinsics.checkNotNullExpressionValue(file2, "");
                    arrayList3.add(Boolean.valueOf(FilesKt.deleteRecursively(file2)));
                }
                ArrayList arrayList4 = arrayList3;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
