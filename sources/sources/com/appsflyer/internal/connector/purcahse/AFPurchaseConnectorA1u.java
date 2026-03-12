package com.appsflyer.internal.connector.purcahse;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public class AFPurchaseConnectorA1u implements BillingClientStateListener, PurchasesUpdatedListener, AFPurchaseConnectorA1r, AFPurchaseConnectorA1y {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int PurchaseClientBuilder = 0;
    private static int logSubscriptions = 1;
    private static long setSandbox = 1913538383092066235L;
    private AFPurchaseConnectorA1r.AFPurchaseConnectorA1x InAppPurchaseEvent;
    private ScheduledExecutorService equals;
    private final BillingClient getOneTimePurchaseOfferDetails;
    private final AFPurchaseConnectorA1l getPackageName;
    final SharedPreferences getQuantity;
    private final AFPurchaseConnectorA1v stopObservingTransactions;
    final Context toJsonMap;
    private final PurchasesResponseListener startObservingTransactions = new PurchasesResponseListener() { // from class: com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.5
        @Override // com.android.billingclient.api.PurchasesResponseListener
        public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
            if (billingResult.getResponseCode() != 0) {
                AFLogger.afWarnLog("[PurchaseConnector]: Failed to query purchases history");
            } else if (list.isEmpty()) {
                AFPurchaseConnectorA1u.this.getQuantity.edit().putBoolean("inapp_purchases_history_processed", true).apply();
                AFLogger.afDebugLog("[PurchaseConnector]: No history for non-consumed one-time purchases found");
            } else {
                AFPurchaseConnectorA1u.this.getPackageName(list);
            }
        }
    };
    private final PurchasesResponseListener PurchaseClient = new PurchasesResponseListener() { // from class: com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.1
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getOneTimePurchaseOfferDetails = 1;
        private static int[] getPackageName = {1480127459, 1870905519, -2086726114, -1195519311, -721237928, 1029398052, 1886925259, 513191056, -1623653556, -402706125, -2037654713, 233685496, -1374427459, 130651729, -1313398039, -1738649748, -1699343426, 1532763029};
        private static int getQuantity;

        @Override // com.android.billingclient.api.PurchasesResponseListener
        public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
            int i = getQuantity + 117;
            getOneTimePurchaseOfferDetails = i % 128;
            if (i % 2 == 0) {
                billingResult.getResponseCode();
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            if ((billingResult.getResponseCode() != 0 ? 'X' : '#') == 'X') {
                AFLogger.afWarnLog("[PurchaseConnector]: Failed to query purchases history");
                return;
            }
            if (!(list.isEmpty())) {
                AFPurchaseConnectorA1u.this.getPackageName(billingResult, list, true);
                int i2 = getOneTimePurchaseOfferDetails + 81;
                getQuantity = i2 % 128;
                if (i2 % 2 != 0) {
                    int i3 = 43 / 0;
                    return;
                }
                return;
            }
            int i4 = getQuantity + 101;
            getOneTimePurchaseOfferDetails = i4 % 128;
            int i5 = i4 % 2;
            SharedPreferences.Editor edit = AFPurchaseConnectorA1u.this.getQuantity.edit();
            Object[] objArr = new Object[1];
            a(new int[]{781822138, 818696279, 1224573440, -2078472429, -624357308, -34214158, -544312192, 273047310, -785581712, -501433753, -78984151, 684984616}, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 23, objArr);
            edit.putBoolean(((String) objArr[0]).intern(), true).apply();
            AFLogger.afDebugLog("[PurchaseConnector]: No active subscriptions and/or non-consumed one-time purchases found");
        }

        private static void a(int[] iArr, int i, Object[] objArr) {
            int i2;
            int length;
            int[] iArr2;
            int i3;
            int length2;
            int[] iArr3;
            int i4;
            AFPurchaseConnectorA1c aFPurchaseConnectorA1c = new AFPurchaseConnectorA1c();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr4 = getPackageName;
            if (!(iArr4 == null)) {
                int i5 = $11 + 79;
                $10 = i5 % 128;
                if (i5 % 2 != 0) {
                    length2 = iArr4.length;
                    iArr3 = new int[length2];
                    i4 = 1;
                } else {
                    length2 = iArr4.length;
                    iArr3 = new int[length2];
                    i4 = 0;
                }
                while (i4 < length2) {
                    int i6 = $10 + 81;
                    $11 = i6 % 128;
                    if (!(i6 % 2 == 0 ? true : false)) {
                        iArr3[i4] = (int) (iArr4[i4] ^ (-6033101233399176549L));
                        i4++;
                    } else {
                        iArr3[i4] = (int) (iArr4[i4] - 6033101233399176549L);
                        i4 >>= 1;
                    }
                }
                iArr4 = iArr3;
            }
            int length3 = iArr4.length;
            int[] iArr5 = new int[length3];
            int[] iArr6 = getPackageName;
            if (iArr6 != null) {
                int i7 = $10 + 107;
                $11 = i7 % 128;
                if (i7 % 2 == 0) {
                    length = iArr6.length;
                    iArr2 = new int[length];
                    i3 = 1;
                } else {
                    length = iArr6.length;
                    iArr2 = new int[length];
                    i3 = 0;
                }
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    iArr2[i3] = (int) (iArr6[i3] ^ (-6033101233399176549L));
                    i3++;
                    length3 = length3;
                }
                i2 = length3;
                iArr6 = iArr2;
            } else {
                i2 = length3;
            }
            System.arraycopy(iArr6, 0, iArr5, 0, i2);
            aFPurchaseConnectorA1c.InAppPurchaseEvent = 0;
            while (aFPurchaseConnectorA1c.InAppPurchaseEvent < iArr.length) {
                cArr[0] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent] >> 16);
                cArr[1] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent];
                cArr[2] = (char) (iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1] >> 16);
                cArr[3] = (char) iArr[aFPurchaseConnectorA1c.InAppPurchaseEvent + 1];
                aFPurchaseConnectorA1c.getQuantity = (cArr[0] << 16) + cArr[1];
                aFPurchaseConnectorA1c.toJsonMap = (cArr[2] << 16) + cArr[3];
                AFPurchaseConnectorA1c.InAppPurchaseEvent(iArr5);
                int i8 = 0;
                while (i8 < 16) {
                    aFPurchaseConnectorA1c.getQuantity ^= iArr5[i8];
                    aFPurchaseConnectorA1c.toJsonMap = AFPurchaseConnectorA1c.getQuantity(aFPurchaseConnectorA1c.getQuantity) ^ aFPurchaseConnectorA1c.toJsonMap;
                    int i9 = aFPurchaseConnectorA1c.getQuantity;
                    aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                    aFPurchaseConnectorA1c.toJsonMap = i9;
                    i8++;
                    int i10 = $10 + 73;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                }
                int i12 = aFPurchaseConnectorA1c.getQuantity;
                aFPurchaseConnectorA1c.getQuantity = aFPurchaseConnectorA1c.toJsonMap;
                aFPurchaseConnectorA1c.toJsonMap = i12;
                aFPurchaseConnectorA1c.toJsonMap ^= iArr5[16];
                aFPurchaseConnectorA1c.getQuantity ^= iArr5[17];
                int i13 = aFPurchaseConnectorA1c.getQuantity;
                int i14 = aFPurchaseConnectorA1c.toJsonMap;
                cArr[0] = (char) (aFPurchaseConnectorA1c.getQuantity >>> 16);
                cArr[1] = (char) aFPurchaseConnectorA1c.getQuantity;
                cArr[2] = (char) (aFPurchaseConnectorA1c.toJsonMap >>> 16);
                cArr[3] = (char) aFPurchaseConnectorA1c.toJsonMap;
                AFPurchaseConnectorA1c.InAppPurchaseEvent(iArr5);
                cArr2[aFPurchaseConnectorA1c.InAppPurchaseEvent * 2] = cArr[0];
                cArr2[(aFPurchaseConnectorA1c.InAppPurchaseEvent * 2) + 1] = cArr[1];
                cArr2[(aFPurchaseConnectorA1c.InAppPurchaseEvent * 2) + 2] = cArr[2];
                cArr2[(aFPurchaseConnectorA1c.InAppPurchaseEvent * 2) + 3] = cArr[3];
                aFPurchaseConnectorA1c.InAppPurchaseEvent += 2;
                int i15 = $10 + 79;
                $11 = i15 % 128;
                int i16 = i15 % 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }
    };
    private final PurchasesResponseListener hashCode = new PurchasesResponseListener() { // from class: com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u$$ExternalSyntheticLambda0
        @Override // com.android.billingclient.api.PurchasesResponseListener
        public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
            AFPurchaseConnectorA1u.this.toJsonMap(billingResult, list);
        }
    };
    private boolean autoLogInApps = true;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v7, types: [char[]] */
    private static void a(String str, int i, Object[] objArr) {
        if ((str != 0 ? 'I' : 'W') == 'I') {
            int i2 = $11 + 55;
            $10 = i2 % 128;
            if (i2 % 2 != 0) {
                str.toCharArray();
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            str = str.toCharArray();
        }
        AFPurchaseConnectorA2z aFPurchaseConnectorA2z = new AFPurchaseConnectorA2z();
        char[] oneTimePurchaseOfferDetails = AFPurchaseConnectorA2z.getOneTimePurchaseOfferDetails(setSandbox ^ 7848782090230080433L, (char[]) str, i);
        aFPurchaseConnectorA2z.getPackageName = 4;
        while (true) {
            if ((aFPurchaseConnectorA2z.getPackageName < oneTimePurchaseOfferDetails.length ? '-' : '3') == '3') {
                objArr[0] = new String(oneTimePurchaseOfferDetails, 4, oneTimePurchaseOfferDetails.length - 4);
                return;
            }
            int i3 = $11 + 63;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            aFPurchaseConnectorA2z.getOneTimePurchaseOfferDetails = aFPurchaseConnectorA2z.getPackageName - 4;
            oneTimePurchaseOfferDetails[aFPurchaseConnectorA2z.getPackageName] = (char) ((oneTimePurchaseOfferDetails[aFPurchaseConnectorA2z.getPackageName] ^ oneTimePurchaseOfferDetails[aFPurchaseConnectorA2z.getPackageName % 4]) ^ (aFPurchaseConnectorA2z.getOneTimePurchaseOfferDetails * (setSandbox ^ 7848782090230080433L)));
            aFPurchaseConnectorA2z.getPackageName++;
            int i5 = $10 + 39;
            $11 = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void toJsonMap(BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() == 0) {
            getPackageName(billingResult, list, false);
            int i = PurchaseClientBuilder + 63;
            logSubscriptions = i % 128;
            if (i % 2 != 0) {
                return;
            }
            int i2 = 66 / 0;
            return;
        }
        int i3 = PurchaseClientBuilder + 31;
        logSubscriptions = i3 % 128;
        if (!(i3 % 2 == 0)) {
            AFLogger.afWarnLog("[PurchaseConnector]: Failed to query purchases history");
            return;
        }
        AFLogger.afWarnLog("[PurchaseConnector]: Failed to query purchases history");
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public AFPurchaseConnectorA1u(Context context, AFPurchaseConnectorA1x aFPurchaseConnectorA1x, SharedPreferences sharedPreferences, AFPurchaseConnectorA1l aFPurchaseConnectorA1l) {
        aFPurchaseConnectorA1x = aFPurchaseConnectorA1x == null ? new AFPurchaseConnectorA1x(this) : aFPurchaseConnectorA1x;
        this.toJsonMap = context;
        this.getQuantity = sharedPreferences;
        this.getOneTimePurchaseOfferDetails = BillingClient.newBuilder(AFPurchaseConnectorA1u.this.toJsonMap).setListener(aFPurchaseConnectorA1x.getOneTimePurchaseOfferDetails).enablePendingPurchases().build();
        this.getPackageName = aFPurchaseConnectorA1l;
        this.stopObservingTransactions = new AFPurchaseConnectorA1v(this, getQuantity());
    }

    void getPackageName(List<Purchase> list) {
        HashSet hashSet = new HashSet();
        Iterator<Purchase> it = list.iterator();
        while (true) {
            if ((it.hasNext() ? '%' : '*') != '%') {
                this.getPackageName.toJsonMap(hashSet);
                this.getQuantity.edit().putBoolean("inapp_purchases_history_processed", true).apply();
                return;
            }
            int i = logSubscriptions + 73;
            PurchaseClientBuilder = i % 128;
            int i2 = i % 2;
            hashSet.add(it.next().getPurchaseToken());
            int i3 = PurchaseClientBuilder + 39;
            logSubscriptions = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r
    public void toJsonMap(AFPurchaseConnectorA1r.AFPurchaseConnectorA1x aFPurchaseConnectorA1x) {
        int i = PurchaseClientBuilder + 119;
        int i2 = i % 128;
        logSubscriptions = i2;
        if (!(i % 2 == 0)) {
            this.InAppPurchaseEvent = aFPurchaseConnectorA1x;
        } else {
            this.InAppPurchaseEvent = aFPurchaseConnectorA1x;
            int i3 = 76 / 0;
        }
        int i4 = i2 + 55;
        PurchaseClientBuilder = i4 % 128;
        if ((i4 % 2 != 0 ? '@' : 'F') != '@') {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r
    public void InAppPurchaseEvent() {
        int i = PurchaseClientBuilder + 91;
        logSubscriptions = i % 128;
        int i2 = i % 2;
        if (this.autoLogInApps) {
            this.autoLogInApps = false;
            this.getOneTimePurchaseOfferDetails.startConnection(this);
            Context context = this.toJsonMap;
            if ((context instanceof Application ? '2' : (char) 11) != 11) {
                int i3 = logSubscriptions + 39;
                PurchaseClientBuilder = i3 % 128;
                if (i3 % 2 == 0) {
                    ((Application) context).registerActivityLifecycleCallbacks(this.stopObservingTransactions);
                } else {
                    ((Application) context).registerActivityLifecycleCallbacks(this.stopObservingTransactions);
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
            }
        }
        int i4 = logSubscriptions + 5;
        PurchaseClientBuilder = i4 % 128;
        if (!(i4 % 2 == 0)) {
            int i5 = 46 / 0;
        }
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r
    public void getPackageName() {
        int i = PurchaseClientBuilder + 15;
        logSubscriptions = i % 128;
        int i2 = i % 2;
        if (!(this.autoLogInApps)) {
            this.autoLogInApps = true;
            this.getOneTimePurchaseOfferDetails.endConnection();
        }
        int i3 = PurchaseClientBuilder + 19;
        logSubscriptions = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 26 : '_') != 26) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r
    public boolean getOneTimePurchaseOfferDetails() {
        int i = logSubscriptions;
        int i2 = i + 73;
        PurchaseClientBuilder = i2 % 128;
        int i3 = i2 % 2;
        boolean z = this.autoLogInApps;
        int i4 = i + 57;
        PurchaseClientBuilder = i4 % 128;
        if ((i4 % 2 != 0 ? (char) 20 : 'F') != 20) {
            return z;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if ((r5.equals == null) != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.concurrent.ScheduledExecutorService getQuantity() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.PurchaseClientBuilder     // Catch: java.lang.Throwable -> L4a
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.logSubscriptions = r2     // Catch: java.lang.Throwable -> L4a
            r2 = 2
            int r0 = r0 % r2
            r3 = 0
            if (r0 != 0) goto L1c
            java.util.concurrent.ScheduledExecutorService r0 = r5.equals     // Catch: java.lang.Throwable -> L4a
            r4 = 20
            int r4 = r4 / r3
            if (r0 != 0) goto L16
            goto L17
        L16:
            r1 = r3
        L17:
            if (r1 == 0) goto L34
            goto L29
        L1a:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L4a
        L1c:
            java.util.concurrent.ScheduledExecutorService r0 = r5.equals     // Catch: java.lang.Throwable -> L4a
            r1 = 91
            if (r0 != 0) goto L24
            r0 = r1
            goto L26
        L24:
            r0 = 41
        L26:
            if (r0 == r1) goto L29
            goto L34
        L29:
            java.util.concurrent.ScheduledExecutorService r0 = java.util.concurrent.Executors.newScheduledThreadPool(r2)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Throwable -> L4a
            r5.equals = r0     // Catch: java.lang.Throwable -> L4a
        L34:
            java.util.concurrent.ScheduledExecutorService r0 = r5.equals     // Catch: java.lang.Throwable -> L4a
            int r1 = com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.logSubscriptions     // Catch: java.lang.Throwable -> L4a
            int r1 = r1 + 5
            int r4 = r1 % 128
            com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.PurchaseClientBuilder = r4     // Catch: java.lang.Throwable -> L4a
            int r1 = r1 % r2
            if (r1 == 0) goto L48
            r1 = 68
            int r1 = r1 / r3
            monitor-exit(r5)
            return r0
        L46:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L4a
        L48:
            monitor-exit(r5)
            return r0
        L4a:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.getQuantity():java.util.concurrent.ScheduledExecutorService");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (r0.getBoolean(((java.lang.String) r5[0]).intern(), false) != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c A[Catch: all -> 0x00ce, TryCatch #1 {all -> 0x00ce, blocks: (B:26:0x0078, B:30:0x00c2, B:29:0x008c), top: B:40:0x0078 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void stopObservingTransactions() {
        /*
            r10 = this;
            int r0 = com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.PurchaseClientBuilder
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.logSubscriptions = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            java.lang.String r3 = "搜摽炽\uf4c5䆏\uaacc䧨⚍瑓\ue4e0姜㛭䐠풂榴ۊ名쑌祷ᘵⓎ둮।昁㒱ꐁᤧ"
            if (r0 == 0) goto L31
            android.content.SharedPreferences r0 = r10.getQuantity     // Catch: java.lang.Throwable -> L77
            int r4 = android.view.ViewConfiguration.getWindowTouchSlop()     // Catch: java.lang.Throwable -> L77
            int r4 = r4 >> 8
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L77
            a(r3, r4, r5)     // Catch: java.lang.Throwable -> L77
            r3 = r5[r2]     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r3.intern()     // Catch: java.lang.Throwable -> L77
            boolean r0 = r0.getBoolean(r3, r2)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L61
            goto L4c
        L31:
            android.content.SharedPreferences r0 = r10.getQuantity     // Catch: java.lang.Throwable -> L77
            int r4 = android.view.ViewConfiguration.getWindowTouchSlop()     // Catch: java.lang.Throwable -> L77
            int r4 = r4 + 83
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L77
            a(r3, r4, r5)     // Catch: java.lang.Throwable -> L77
            r3 = r5[r2]     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r3.intern()     // Catch: java.lang.Throwable -> L77
            boolean r0 = r0.getBoolean(r3, r2)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L61
        L4c:
            int r0 = com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.logSubscriptions
            int r0 = r0 + 63
            int r3 = r0 % 128
            com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.PurchaseClientBuilder = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L59
            r1 = r2
        L59:
            if (r1 == 0) goto L5c
            return
        L5c:
            r0 = 5
            int r0 = r0 / r2
            return
        L5f:
            r0 = move-exception
            throw r0
        L61:
            com.android.billingclient.api.BillingClient r0 = r10.getOneTimePurchaseOfferDetails     // Catch: java.lang.Throwable -> L77
            com.android.billingclient.api.QueryPurchasesParams$Builder r3 = com.android.billingclient.api.QueryPurchasesParams.newBuilder()     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = "subs"
            com.android.billingclient.api.QueryPurchasesParams$Builder r3 = r3.setProductType(r4)     // Catch: java.lang.Throwable -> L77
            com.android.billingclient.api.QueryPurchasesParams r3 = r3.build()     // Catch: java.lang.Throwable -> L77
            com.android.billingclient.api.PurchasesResponseListener r4 = r10.PurchaseClient     // Catch: java.lang.Throwable -> L77
            r0.queryPurchasesAsync(r3, r4)     // Catch: java.lang.Throwable -> L77
            return
        L77:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lce
            r3[r2] = r0     // Catch: java.lang.Throwable -> Lce
            java.util.Map r4 = com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1w.PurchaseClientCompanion     // Catch: java.lang.Throwable -> Lce
            r5 = -1174844903(0xffffffffb9f94a19, float:-4.7548188E-4)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lce
            java.lang.Object r4 = r4.get(r6)     // Catch: java.lang.Throwable -> Lce
            if (r4 == 0) goto L8c
            goto Lc2
        L8c:
            java.lang.String r4 = ""
            r6 = 48
            int r4 = android.text.TextUtils.indexOf(r4, r6, r2, r2)     // Catch: java.lang.Throwable -> Lce
            int r4 = 69 - r4
            long r6 = android.widget.ExpandableListView.getPackedPositionForGroup(r2)     // Catch: java.lang.Throwable -> Lce
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            int r6 = 70 - r6
            int r7 = android.graphics.ImageFormat.getBitsPerPixel(r2)     // Catch: java.lang.Throwable -> Lce
            int r7 = (-1) - r7
            char r7 = (char) r7     // Catch: java.lang.Throwable -> Lce
            java.lang.Object r4 = com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1w.getQuantity(r4, r6, r7)     // Catch: java.lang.Throwable -> Lce
            java.lang.Class r4 = (java.lang.Class) r4     // Catch: java.lang.Throwable -> Lce
            java.lang.String r6 = "getQuantity"
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> Lce
            java.lang.Class<java.lang.Throwable> r8 = java.lang.Throwable.class
            r7[r2] = r8     // Catch: java.lang.Throwable -> Lce
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch: java.lang.Throwable -> Lce
            java.util.Map r2 = com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1w.PurchaseClientCompanion     // Catch: java.lang.Throwable -> Lce
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lce
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> Lce
        Lc2:
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4     // Catch: java.lang.Throwable -> Lce
            r2 = 0
            r4.invoke(r2, r3)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r2 = "[PurchaseConnector]: Failed to log purchases history"
            com.appsflyer.AFLogger.afErrorLog(r2, r0, r1)
            return
        Lce:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()
            if (r1 == 0) goto Ld6
            throw r1
        Ld6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u.stopObservingTransactions():void");
    }

    private void equals() {
        int i = PurchaseClientBuilder + 49;
        logSubscriptions = i % 128;
        int i2 = i % 2;
        try {
            if (this.getQuantity.getBoolean("inapp_purchases_history_processed", false)) {
                return;
            }
            this.getOneTimePurchaseOfferDetails.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), this.startObservingTransactions);
            int i3 = PurchaseClientBuilder + 27;
            logSubscriptions = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            try {
                Object[] objArr = {th};
                Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-1174844903);
                if (obj == null) {
                    obj = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 69 - Process.getGidForName(""), (char) View.MeasureSpec.getSize(0))).getMethod("getQuantity", Throwable.class);
                    AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-1174844903, obj);
                }
                ((Method) obj).invoke(null, objArr);
                AFLogger.afErrorLog("[PurchaseConnector]: Failed to log purchases history", th, true);
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }

    void getPackageName(BillingResult billingResult, List<Purchase> list, boolean z) {
        int i = logSubscriptions + 31;
        PurchaseClientBuilder = i % 128;
        int i2 = i % 2;
        try {
            if ((billingResult.getResponseCode() == 0) && list != null) {
                if ((this.getOneTimePurchaseOfferDetails == null ? (char) 29 : '\"') != '\"') {
                    AFLogger.afWarnLog("[PurchaseConnector]: Got Ars billing callback but billing client is missing!");
                    return;
                }
                Set<String> quantity = this.getPackageName.getQuantity();
                AFLogger.afDebugLog(new StringBuilder("tokens: ").append(Arrays.deepToString(quantity.toArray(new String[0]))).toString());
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator<Purchase> it = list.iterator();
                while (true) {
                    if ((it.hasNext() ? 'c' : '9') != 'c') {
                        if (arrayList2.isEmpty()) {
                            return;
                        }
                        getOneTimePurchaseOfferDetails("subs", arrayList, arrayList2, z);
                        getOneTimePurchaseOfferDetails("inapp", arrayList, arrayList2, z);
                        int i3 = PurchaseClientBuilder + 99;
                        logSubscriptions = i3 % 128;
                        int i4 = i3 % 2;
                        return;
                    }
                    int i5 = PurchaseClientBuilder + 107;
                    logSubscriptions = i5 % 128;
                    if (!(i5 % 2 != 0)) {
                        Object[] objArr = {it.next().getPurchaseToken()};
                        Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-857619108);
                        if (obj == null) {
                            obj = ((Class) AFPurchaseConnectorA1w.getQuantity((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 70, (Process.myPid() >> 22) + 70, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("getQuantity", String.class);
                            AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-857619108, obj);
                        }
                        quantity.contains(((Method) obj).invoke(null, objArr));
                        throw null;
                    }
                    Purchase next = it.next();
                    Object[] objArr2 = {next.getPurchaseToken()};
                    Object obj2 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-857619108);
                    if (obj2 == null) {
                        obj2 = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - TextUtils.getTrimmedLength(""), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 70, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getQuantity", String.class);
                        AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-857619108, obj2);
                    }
                    if ((!quantity.contains(((Method) obj2).invoke(null, objArr2)) ? (char) 7 : '4') == 7) {
                        arrayList2.add(next);
                        arrayList.addAll(next.getProducts());
                        int i6 = PurchaseClientBuilder + 101;
                        logSubscriptions = i6 % 128;
                        int i7 = i6 % 2;
                    }
                }
            }
            AFLogger.afWarnLog(new StringBuilder("[PurchaseConnector]: Failed to setup Ars Play billing service: ").append(billingResult.getResponseCode()).append(" ").append(billingResult.getDebugMessage()).toString());
            int i8 = logSubscriptions + 39;
            PurchaseClientBuilder = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 73 / 0;
            }
        } catch (Throwable th) {
            try {
                Object[] objArr3 = {th};
                Object obj3 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-1174844903);
                if (obj3 == null) {
                    obj3 = ((Class) AFPurchaseConnectorA1w.getQuantity(((Process.getThreadPriority(0) + 20) >> 6) + 70, 70 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) KeyEvent.getDeadChar(0, 0))).getMethod("getQuantity", Throwable.class);
                    AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-1174844903, obj3);
                }
                ((Method) obj3).invoke(null, objArr3);
                AFLogger.afErrorLog("[PurchaseConnector]: Failed to query new purchase details", th, true);
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }

    private void getOneTimePurchaseOfferDetails(String str, List<String> list, List<Purchase> list2, boolean z) {
        int i = logSubscriptions + 11;
        PurchaseClientBuilder = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            "subs".equals(str);
            throw null;
        }
        if ((!"subs".equals(str)) && !"inapp".equals(str)) {
            AFLogger.afWarnLog(new StringBuilder("[PurchaseConnector]: ").append(str).append(" SKU type is illegal").toString());
            return;
        }
        StringBuilder append = new StringBuilder("[PurchaseConnector]: Querying Sku details:\n\ttype: ").append(str).append("\n\tSkus: ");
        try {
            Object[] objArr = {list, ", "};
            Object obj2 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-1211899119);
            if (obj2 == null) {
                obj2 = ((Class) AFPurchaseConnectorA1w.getQuantity(TextUtils.getTrimmedLength("") + 70, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 70, (char) KeyEvent.keyCodeFromString(""))).getMethod("getPackageName", List.class, CharSequence.class);
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-1211899119, obj2);
            }
            AFLogger.afDebugLog(append.append((String) ((Method) obj2).invoke(null, objArr)).toString());
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            int i2 = PurchaseClientBuilder + 57;
            logSubscriptions = i2 % 128;
            int i3 = i2 % 2;
            while (it.hasNext()) {
                int i4 = PurchaseClientBuilder + 35;
                logSubscriptions = i4 % 128;
                if (i4 % 2 == 0) {
                    arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId(it.next()).setProductType(str).build());
                    obj.hashCode();
                    throw null;
                }
                arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId(it.next()).setProductType(str).build());
            }
            QueryProductDetailsParams build = QueryProductDetailsParams.newBuilder().setProductList(arrayList).build();
            if ((this.InAppPurchaseEvent == null ? '?' : (char) 4) != 4) {
                AFLogger.afWarnLog("[PurchaseConnector]: Skipping queryProductDetailsAsync because BillingUpdatesListener is null");
                return;
            }
            this.getOneTimePurchaseOfferDetails.queryProductDetailsAsync(build, new AFPurchaseConnectorA1n(str, this.InAppPurchaseEvent, list2, z));
            int i5 = logSubscriptions + 83;
            PurchaseClientBuilder = i5 % 128;
            if (i5 % 2 == 0) {
                return;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(BillingResult billingResult) {
        int i = logSubscriptions + 91;
        PurchaseClientBuilder = i % 128;
        int i2 = i % 2;
        AFLogger.afDebugLog("[PurchaseConnector]: onBillingSetupFinished");
        if (billingResult.getResponseCode() != 0) {
            return;
        }
        stopObservingTransactions();
        equals();
        int i3 = PurchaseClientBuilder + 3;
        logSubscriptions = i3 % 128;
        if ((i3 % 2 == 0 ? 'O' : 'G') != 'O') {
            return;
        }
        int i4 = 83 / 0;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        int i = logSubscriptions + 47;
        PurchaseClientBuilder = i % 128;
        int i2 = i % 2;
        AFLogger.afDebugLog("[PurchaseConnector]: onBillingServiceDisconnected");
        int i3 = PurchaseClientBuilder + 1;
        logSubscriptions = i3 % 128;
        if ((i3 % 2 == 0 ? 'D' : (char) 24) != 'D') {
            return;
        }
        throw null;
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        int i = logSubscriptions + 17;
        PurchaseClientBuilder = i % 128;
        int i2 = i % 2;
        AFLogger.afDebugLog("[PurchaseConnector]: onPurchasesUpdated");
        getPackageName(billingResult, list, false);
        int i3 = logSubscriptions + 9;
        PurchaseClientBuilder = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1y
    public void toJsonMap() {
        int i = PurchaseClientBuilder + 101;
        logSubscriptions = i % 128;
        int i2 = i % 2;
        SharedPreferences sharedPreferences = this.getQuantity;
        Object[] objArr = new Object[1];
        a("搜摽炽\uf4c5䆏\uaacc䧨⚍瑓\ue4e0姜㛭䐠풂榴ۊ名쑌祷ᘵⓎ둮।昁㒱ꐁᤧ", (-1) - TextUtils.indexOf((CharSequence) "", '0', 0), objArr);
        if (sharedPreferences.getBoolean(((String) objArr[0]).intern(), false)) {
            int i3 = PurchaseClientBuilder + 57;
            logSubscriptions = i3 % 128;
            if ((i3 % 2 == 0 ? '-' : (char) 24) == '-') {
                this.getOneTimePurchaseOfferDetails.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("subs").build(), this.hashCode);
                throw null;
            }
            this.getOneTimePurchaseOfferDetails.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("subs").build(), this.hashCode);
            int i4 = logSubscriptions + 51;
            PurchaseClientBuilder = i4 % 128;
            int i5 = i4 % 2;
        }
        if (this.getQuantity.getBoolean("inapp_purchases_history_processed", false)) {
            this.getOneTimePurchaseOfferDetails.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), this.hashCode);
            int i6 = PurchaseClientBuilder + 75;
            logSubscriptions = i6 % 128;
            int i7 = i6 % 2;
        }
    }

    /* loaded from: classes.dex */
    public class AFPurchaseConnectorA1x implements AFPurchaseConnectorA1r.AFPurchaseConnectorA1w<BillingClient> {
        final PurchasesUpdatedListener getOneTimePurchaseOfferDetails;

        public AFPurchaseConnectorA1x(PurchasesUpdatedListener purchasesUpdatedListener) {
            this.getOneTimePurchaseOfferDetails = purchasesUpdatedListener;
        }
    }
}
