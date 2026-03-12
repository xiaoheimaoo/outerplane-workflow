package com.appsflyer.internal.connector.purcahse;
/* loaded from: classes.dex */
public final class AFPurchaseConnectorA1c {
    public int InAppPurchaseEvent;
    public int getQuantity;
    public int toJsonMap;

    public static void InAppPurchaseEvent(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int getQuantity(int i) {
        AFPurchaseConnectorA1p aFPurchaseConnectorA1p = AFPurchaseConnectorA1p.getQuantity;
        return ((aFPurchaseConnectorA1p.getPackageName[0][(i >>> 24) & 255] + aFPurchaseConnectorA1p.getPackageName[1][(i >>> 16) & 255]) ^ aFPurchaseConnectorA1p.getPackageName[2][(i >>> 8) & 255]) + aFPurchaseConnectorA1p.getPackageName[3][i & 255];
    }
}
