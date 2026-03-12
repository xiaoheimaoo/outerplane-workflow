package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.util.Arrays;
import java.util.Scanner;
/* loaded from: classes.dex */
public final class AFc1tSDK {
    public AFe1mSDK AFAdRevenueData;
    public String getCurrencyIso4217Code;
    public String getMediationNetwork;
    private byte[] getMonetizationNetwork;
    String getRevenue;

    public AFc1tSDK(String str, byte[] bArr, String str2, AFe1mSDK aFe1mSDK) {
        this.getCurrencyIso4217Code = str;
        this.getMonetizationNetwork = bArr;
        this.getRevenue = str2;
        this.AFAdRevenueData = aFe1mSDK;
    }

    public AFc1tSDK(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.getCurrencyIso4217Code = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.getRevenue = nextLine.substring(8).trim();
            } else if (nextLine.startsWith("data=")) {
                this.getMonetizationNetwork = Base64.decode(nextLine.substring(5).trim(), 2);
            } else if (nextLine.startsWith("type=")) {
                String trim = nextLine.substring(5).trim();
                try {
                    this.AFAdRevenueData = AFe1mSDK.valueOf(trim);
                } catch (Exception e) {
                    AFLogger.afErrorLog("CACHE: Unknown task type: ".concat(String.valueOf(trim)), e);
                }
            }
        }
        scanner.close();
    }

    public final byte[] getMonetizationNetwork() {
        return this.getMonetizationNetwork;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AFc1tSDK aFc1tSDK = (AFc1tSDK) obj;
            String str = this.getRevenue;
            if (str == null ? aFc1tSDK.getRevenue != null : !str.equals(aFc1tSDK.getRevenue)) {
                return false;
            }
            if (!Arrays.equals(this.getMonetizationNetwork, aFc1tSDK.getMonetizationNetwork)) {
                return false;
            }
            String str2 = this.getCurrencyIso4217Code;
            if (str2 == null ? aFc1tSDK.getCurrencyIso4217Code != null : !str2.equals(aFc1tSDK.getCurrencyIso4217Code)) {
                return false;
            }
            String str3 = this.getMediationNetwork;
            if (str3 == null ? aFc1tSDK.getMediationNetwork != null : !str3.equals(aFc1tSDK.getMediationNetwork)) {
                return false;
            }
            if (this.AFAdRevenueData == aFc1tSDK.AFAdRevenueData) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.getRevenue;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Arrays.hashCode(this.getMonetizationNetwork)) * 31;
        String str2 = this.getCurrencyIso4217Code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.getMediationNetwork;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        AFe1mSDK aFe1mSDK = this.AFAdRevenueData;
        return hashCode3 + (aFe1mSDK != null ? aFe1mSDK.hashCode() : 0);
    }
}
