package com.android.billingclient.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import androidx.work.WorkRequest;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziz;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import com.helpshift.HelpshiftEvent;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes.dex */
public class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private PendingPurchasesParams zzD;
    private boolean zzE;
    private boolean zzF;
    private volatile BillingClientStateListener zzG;
    private ExecutorService zzH;
    private final Long zzI;
    private com.google.android.gms.internal.play_billing.zzbl zzJ;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final String zzd;
    private final Handler zze;
    private volatile zzs zzf;
    private Context zzg;
    private zzch zzh;
    private volatile com.google.android.gms.internal.play_billing.zzam zzi;
    private volatile zzbf zzj;
    private boolean zzk;
    private boolean zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str, BillingClient.Builder builder) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzbq(), str, null, null, null, null, builder);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzch zzchVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzc.zzt(str2);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(this.zzI.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzchVar != null) {
            this.zzh = zzchVar;
        } else {
            this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzs(this.zzg, purchasesUpdatedListener, null, zzbVar, null, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzF = zzbVar != null;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        startConnection(new zzbq(j));
    }

    public static /* synthetic */ Void zzA(BillingClientImpl billingClientImpl, ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        billingClientImpl.zzaA(externalOfferAvailabilityListener);
        return null;
    }

    public static /* synthetic */ Void zzB(BillingClientImpl billingClientImpl, ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.zzaC(externalOfferInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void zzC(BillingClientImpl billingClientImpl, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, String str) {
        billingClientImpl.zzay(externalOfferReportingDetailsListener, null);
        return null;
    }

    public static /* synthetic */ Void zzD(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        billingClientImpl.zzax(alternativeBillingOnlyReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void zzE(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        billingClientImpl.zzaz(alternativeBillingOnlyAvailabilityListener);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Future zzG(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future submit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaj
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return submit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static /* synthetic */ void zzH(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    public static /* synthetic */ void zzI(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 9, billingResult);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbt.zzk());
    }

    public static /* synthetic */ void zzJ(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 13, billingResult);
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    public static /* synthetic */ void zzL(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 3, billingResult);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    public static /* synthetic */ void zzN(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 7, billingResult);
        productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
    }

    public static /* synthetic */ void zzP(BillingClientImpl billingClientImpl, BillingResult billingResult) {
        if (billingClientImpl.zzf.zzd() != null) {
            billingClientImpl.zzf.zzd().onPurchasesUpdated(billingResult, null);
            return;
        }
        zzs zzsVar = billingClientImpl.zzf;
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
    }

    private final /* synthetic */ Void zzaA(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzB) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzq(24, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbm(externalOfferAvailabilityListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support launching external offer flow.");
                zzaJ(externalOfferAvailabilityListener, zzcj.zzA, zzie.LAUNCH_EXTERNAL_OFFER_FLOW_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaJ(externalOfferAvailabilityListener, zzcj.zzh, zzie.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaB(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzm(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbi(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzj, zzie.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzh, zzie.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaC(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaK(externalOfferInformationDialogListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzo(22, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbk(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaK(externalOfferInformationDialogListener, zzcj.zzj, zzie.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaK(externalOfferInformationDialogListener, zzcj.zzh, zzie.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final void zzaD(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        int zza;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Consuming purchase with token: " + purchaseToken);
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaG(consumeResponseListener, purchaseToken, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                return;
            }
            if (this.zzp) {
                String packageName = this.zzg.getPackageName();
                boolean z = this.zzp;
                String str2 = this.zzc;
                String str3 = this.zzd;
                long longValue = this.zzI.longValue();
                Bundle bundle = new Bundle();
                if (z) {
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str2, str3, longValue);
                }
                Bundle zze = zzamVar.zze(9, packageName, purchaseToken, bundle);
                zza = zze.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zzc.zzj(zze, "BillingClient");
            } else {
                zza = zzamVar.zza(3, this.zzg.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult zza2 = zzcj.zza(zza, str);
            if (zza != 0) {
                zzie zzieVar = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                zzaG(consumeResponseListener, purchaseToken, zza2, zzieVar, "Error consuming purchase with token. Response code: " + zza, null);
                return;
            }
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Successfully consumed purchase.");
            consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
        } catch (DeadObjectException e) {
            zzaG(consumeResponseListener, purchaseToken, zzcj.zzj, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
        } catch (Exception e2) {
            zzaG(consumeResponseListener, purchaseToken, zzcj.zzh, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e2);
        }
    }

    private final void zzaE(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        zzbf(zzieVar, 3, billingResult, zzcg.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaF(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 14, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    private final void zzaG(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, zzie zzieVar, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str2, exc);
        zzbf(zzieVar, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaH(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 15, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaI(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 24, billingResult, zzcg.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 23, billingResult, zzcg.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaK(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 25, billingResult, zzcg.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    private final void zzaL(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "getBillingConfig got an exception.", exc);
        zzbf(zzieVar, 13, billingResult, zzcg.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaM(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 16, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    private final void zzaN(int i, zzie zzieVar, Exception exc) {
        zzhx zzhxVar;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "showInAppMessages error.", exc);
        zzch zzchVar = this.zzh;
        String zza = zzcg.zza(exc);
        try {
            zzic zzc = zzig.zzc();
            zzc.zzo(i);
            if (zzieVar != null) {
                zzc.zzn(zzieVar);
            }
            if (zza != null) {
                zzc.zza(zza);
            }
            zzhv zzc2 = zzhx.zzc();
            zzc2.zzl(zzc);
            zzc2.zzp(30);
            zzhxVar = (zzhx) zzc2.zze();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            zzhxVar = null;
        }
        zzchVar.zza(zzhxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaO(zzhx zzhxVar) {
        try {
            this.zzh.zzb(zzhxVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaP(zzhx zzhxVar, long j, boolean z) {
        try {
            this.zzh.zze(zzhxVar, this.zzm, j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaQ(zzib zzibVar) {
        try {
            this.zzh.zzg(zzibVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaR(zzie zzieVar, BillingResult billingResult, int i) {
        try {
            int i2 = zzcg.zza;
            zzhv zzhvVar = (zzhv) zzcg.zzb(zzieVar, 6, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzm();
            zzjt zzc = zzjv.zzc();
            zzc.zza(i > 0);
            zzc.zzl(i);
            zzhvVar.zzo(zzc);
            zzaO((zzhx) zzhvVar.zze());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaS(int i) {
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            String zzaZ = zzaZ(this.zzb);
            String zzaZ2 = zzaZ(i);
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Setting clientState from " + zzaZ + " to " + zzaZ2);
            this.zzb = i;
        }
    }

    private final synchronized void zzaT() {
        ExecutorService executorService = this.zzH;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzH = null;
        }
    }

    private final void zzaU(BillingClientStateListener billingClientStateListener, int i) {
        zzie zzieVar;
        BillingResult billingResult;
        boolean bindService;
        BillingResult billingResult2;
        synchronized (this.zza) {
            if (zzaY()) {
                billingResult = zzap(i);
            } else {
                if (this.zzb == 1) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                    zzie zzieVar2 = zzie.BILLING_CLIENT_CONNECTING;
                    billingResult2 = zzcj.zzd;
                    zzaR(zzieVar2, billingResult2, i);
                } else if (this.zzb == 3) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    zzie zzieVar3 = zzie.BILLING_CLIENT_CLOSED;
                    billingResult2 = zzcj.zzj;
                    zzaR(zzieVar3, billingResult2, i);
                } else {
                    zzaS(1);
                    if (i == 0) {
                        this.zzG = billingClientStateListener;
                        i = 0;
                    }
                    zzaV();
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Starting in-app billing setup.");
                    this.zzj = new zzbf(this, billingClientStateListener, i, null);
                    this.zzj.zzc();
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> queryIntentServices = this.zzg.getPackageManager().queryIntentServices(intent, 0);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        zzieVar = zzie.INTENT_SERVICE_NOT_FOUND;
                    } else {
                        ResolveInfo resolveInfo = queryIntentServices.get(0);
                        if (resolveInfo.serviceInfo != null) {
                            String str = resolveInfo.serviceInfo.packageName;
                            String str2 = resolveInfo.serviceInfo.name;
                            if (Objects.equals(str, "com.android.vending") && str2 != null) {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                synchronized (this.zza) {
                                    if (this.zzb == 2) {
                                        billingResult = zzap(i);
                                    } else if (this.zzb != 1) {
                                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                        zzie zzieVar4 = zzie.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                        billingResult2 = zzcj.zzj;
                                        zzaR(zzieVar4, billingResult2, i);
                                    } else {
                                        zzbf zzbfVar = this.zzj;
                                        if (i <= 0 || Build.VERSION.SDK_INT < 29) {
                                            bindService = this.zzg.bindService(intent2, zzbfVar, 1);
                                        } else {
                                            bindService = this.zzg.bindService(intent2, 1, zzF(), zzbfVar);
                                        }
                                        if (bindService) {
                                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service was bonded successfully.");
                                            billingResult = null;
                                        } else {
                                            zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                        }
                                    }
                                }
                            } else {
                                zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            }
                        } else {
                            zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                        }
                    }
                    zzaS(0);
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Billing service unavailable on device.");
                    BillingResult billingResult3 = zzcj.zzb;
                    zzaR(zzieVar, billingResult3, i);
                    billingResult = billingResult3;
                }
                billingResult = billingResult2;
            }
        }
        if (billingResult != null) {
            billingClientStateListener.onBillingSetupFinished(billingResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaV() {
        synchronized (this.zza) {
            if (this.zzj != null) {
                this.zzg.unbindService(this.zzj);
                this.zzi = null;
                this.zzj = null;
            }
        }
    }

    private final boolean zzaW(long j) {
        try {
            BillingResult billingResult = (BillingResult) zzar(1).get(Build.VERSION.SDK_INT < 29 ? 0L : 3000L, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                int responseCode = billingResult.getResponseCode();
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + responseCode);
            } else {
                int responseCode2 = billingResult.getResponseCode();
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + responseCode2);
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
        }
        return zzaY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzaX(long j) {
        long max;
        com.google.android.gms.internal.play_billing.zzbi zzb = com.google.android.gms.internal.play_billing.zzbi.zzb(this.zzJ);
        long j2 = 30000;
        for (int i = 1; i <= 3; i++) {
            try {
                max = Math.max(0L, j2);
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
            }
            if (max <= 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                return zzaY();
            }
            BillingResult billingResult = (BillingResult) zzar(i).get(max, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
                return zzaY();
            }
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            j2 = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS - zzb.zza(TimeUnit.MILLISECONDS);
            long pow = ((long) Math.pow(2.0d, i - 1)) * 1000;
            if (j2 < pow) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                return zzaY();
            }
            if (i < 3 && pow > 0) {
                try {
                    Thread.sleep(pow);
                    j2 = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS - zzb.zza(TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e2);
                }
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Max retries reached.");
        return zzaY();
    }

    private final boolean zzaY() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzi != null && this.zzj != null) {
                z = true;
            }
        }
        return z;
    }

    private static final String zzaZ(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzac(BillingClientImpl billingClientImpl, int i) {
        billingClientImpl.zzm = i;
        billingClientImpl.zzC = i >= 26;
        billingClientImpl.zzB = i >= 24;
        billingClientImpl.zzA = i >= 23;
        billingClientImpl.zzz = i >= 22;
        billingClientImpl.zzy = i >= 21;
        billingClientImpl.zzx = i >= 20;
        billingClientImpl.zzw = i >= 19;
        billingClientImpl.zzv = i >= 18;
        billingClientImpl.zzu = i >= 17;
        billingClientImpl.zzt = i >= 16;
        billingClientImpl.zzs = i >= 15;
        billingClientImpl.zzr = i >= 14;
        billingClientImpl.zzq = i >= 12;
        billingClientImpl.zzp = i >= 9;
        billingClientImpl.zzo = i >= 8;
        billingClientImpl.zzn = i >= 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzae(BillingClientImpl billingClientImpl, int i) {
        if (i == 0) {
            synchronized (billingClientImpl.zza) {
                if (billingClientImpl.zzb == 3) {
                    return;
                }
                billingClientImpl.zzaS(2);
                zzs zzsVar = billingClientImpl.zzf != null ? billingClientImpl.zzf : null;
                if (zzsVar != null) {
                    zzsVar.zzg(billingClientImpl.zzy);
                    return;
                }
                return;
            }
        }
        billingClientImpl.zzaS(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzai(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzal(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                return com.google.android.gms.internal.play_billing.zzc.zzd(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL);
            }
            return zzamVar.zzg(i, this.zzg.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzj, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzh, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzam(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                return com.google.android.gms.internal.play_billing.zzc.zzd(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL);
            }
            return zzamVar.zzf(3, this.zzg.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzj, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzh, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzan() {
        return Looper.myLooper() == null ? this.zze : new Handler(Looper.myLooper());
    }

    private final zzbo zzao(BillingResult billingResult, zzie zzieVar, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        zzbf(zzieVar, 7, billingResult, zzcg.zza(exc));
        return new zzbo(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList(), new ArrayList());
    }

    private final BillingResult zzap(int i) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzhz zzc = zzib.zzc();
        zzc.zzo(6);
        zzjt zzc2 = zzjv.zzc();
        zzc2.zzn(true);
        zzc2.zza(i > 0);
        zzc2.zzl(i);
        zzc.zzn(zzc2);
        zzaQ((zzib) zzc.zze());
        return zzcj.zzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaq() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzcj.zzj;
                }
            }
        }
        return zzcj.zzh;
    }

    private final com.google.android.gms.internal.play_billing.zzcz zzar(final int i) {
        if (!this.zzE || zzaY()) {
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
            return com.google.android.gms.internal.play_billing.zzcu.zza(zzcj.zzi);
        }
        return com.google.android.gms.internal.play_billing.zzu.zza(new com.google.android.gms.internal.play_billing.zzr() { // from class: com.android.billingclient.api.zzu
            @Override // com.google.android.gms.internal.play_billing.zzr
            public final Object zza(com.google.android.gms.internal.play_billing.zzp zzpVar) {
                return BillingClientImpl.zzq(BillingClientImpl.this, i, zzpVar);
            }
        });
    }

    private final /* synthetic */ Object zzas(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzcj.zzj;
                zzbd(zzieVar, 3, billingResult);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                zzie zzieVar2 = zzie.EMPTY_PURCHASE_TOKEN;
                BillingResult billingResult2 = zzcj.zzg;
                zzbd(zzieVar2, 3, billingResult2);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            } else if (this.zzp) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaE(acknowledgePurchaseResponseListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long longValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, longValue);
                    Bundle zzd = zzamVar.zzd(9, packageName, purchaseToken, bundle);
                    acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zza(com.google.android.gms.internal.play_billing.zzc.zzb(zzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzc.zzj(zzd, "BillingClient")));
                    return null;
                }
            } else {
                zzie zzieVar3 = zzie.API_VERSION_NOT_V9;
                BillingResult billingResult3 = zzcj.zza;
                zzbd(zzieVar3, 3, billingResult3);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
            }
            return null;
        } catch (DeadObjectException e) {
            zzaE(acknowledgePurchaseResponseListener, zzcj.zzj, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e2) {
            zzaE(acknowledgePurchaseResponseListener, zzcj.zzh, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e2);
            return null;
        }
    }

    private final /* synthetic */ Object zzat(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzcj.zzj;
                zzbd(zzieVar, 13, billingResult);
                billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            } else if (this.zzv) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaL(billingConfigResponseListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long longValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, longValue);
                    zzamVar.zzn(18, packageName, bundle, new zzbj(billingConfigResponseListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support get billing config.");
                zzie zzieVar2 = zzie.GET_BILLING_CONFIG_NOT_SUPPORTED;
                BillingResult billingResult2 = zzcj.zzy;
                zzbd(zzieVar2, 13, billingResult2);
                billingConfigResponseListener.onBillingConfigResponse(billingResult2, null);
            }
        } catch (DeadObjectException e) {
            zzaL(billingConfigResponseListener, zzcj.zzj, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaL(billingConfigResponseListener, zzcj.zzh, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Object zzau(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaN(-1, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzr(12, this.zzg.getPackageName(), bundle, new zzbn(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaN(-1, zzie.SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaN(6, zzie.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final String zzav(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzg.getPackageName();
        }
        return null;
    }

    private static String zzaw() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private final /* synthetic */ Void zzax(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzk(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbg(alternativeBillingOnlyReportingDetailsListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzD, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzh, zzie.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzay(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, String str) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzz) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    long j = this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).firstInstallTime;
                    String str2 = this.zzc;
                    String str3 = this.zzd;
                    long longValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str2, str3, longValue);
                    bundle.putLong("appInstallTimeMillis", j);
                    zzamVar.zzl(22, packageName, bundle, new zzbh(externalOfferReportingDetailsListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support external offer.");
                zzaI(externalOfferReportingDetailsListener, zzcj.zzt, zzie.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaI(externalOfferReportingDetailsListener, zzcj.zzh, zzie.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaz(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
                zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzp(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbl(alternativeBillingOnlyAvailabilityListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzD, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzh, zzie.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final zzcw zzba(int i, BillingResult billingResult, zzie zzieVar, String str, Exception exc) {
        zzbf(zzieVar, 9, billingResult, zzcg.zza(exc));
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        return new zzcw(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0169 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.billingclient.api.zzcw zzbb(java.lang.String r17, boolean r18, int r19) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzbb(java.lang.String, boolean, int):com.android.billingclient.api.zzcw");
    }

    private final void zzbc(BillingResult billingResult, zzie zzieVar, int i) {
        zzib zzibVar = null;
        zzhx zzhxVar = null;
        if (billingResult.getResponseCode() != 0) {
            int i2 = zzcg.zza;
            try {
                zzhv zzc = zzhx.zzc();
                zzic zzc2 = zzig.zzc();
                zzc2.zzo(billingResult.getResponseCode());
                zzc2.zzl(billingResult.getDebugMessage());
                zzc2.zzn(zzieVar);
                zzc.zzl(zzc2);
                zzc.zzp(5);
                zziw zzc3 = zziz.zzc();
                zzc3.zza(i);
                zzc.zzm((zziz) zzc3.zze());
                zzhxVar = (zzhx) zzc.zze();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            }
            zzaO(zzhxVar);
            return;
        }
        int i3 = zzcg.zza;
        try {
            zzhz zzc4 = zzib.zzc();
            zzc4.zzo(5);
            zziw zzc5 = zziz.zzc();
            zzc5.zza(i);
            zzc4.zzl((zziz) zzc5.zze());
            zzibVar = (zzib) zzc4.zze();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e2);
        }
        zzaQ(zzibVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbd(zzie zzieVar, int i, BillingResult billingResult) {
        try {
            int i2 = zzcg.zza;
            zzaO(zzcg.zzb(zzieVar, i, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbe(zzie zzieVar, int i, BillingResult billingResult, long j) {
        try {
            int i2 = zzcg.zza;
            this.zzh.zzc(zzcg.zzb(zzieVar, 2, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzm, j);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbf(zzie zzieVar, int i, BillingResult billingResult, String str) {
        try {
            int i2 = zzcg.zza;
            zzaO(zzcg.zzb(zzieVar, i, billingResult, str, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbg(zzie zzieVar, int i, BillingResult billingResult, long j, boolean z) {
        try {
            int i2 = zzcg.zza;
            zzaP(zzcg.zzb(zzieVar, 2, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbh(zzie zzieVar, int i, BillingResult billingResult, String str, long j, boolean z) {
        try {
            int i2 = zzcg.zza;
            zzaP(zzcg.zzb(zzieVar, 2, billingResult, str, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private void zzbi(int i) {
        try {
            int i2 = zzcg.zza;
            zzaQ(zzcg.zzc(i, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ BillingResult zzl(Exception exc) {
        if (exc instanceof DeadObjectException) {
            return zzcj.zzj;
        }
        return zzcj.zzh;
    }

    public static /* synthetic */ Object zzq(BillingClientImpl billingClientImpl, int i, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        billingClientImpl.zzaU(new zzbc(billingClientImpl, zzpVar), i);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object zzr(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        if (!billingClientImpl.zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            billingClientImpl.zzbd(zzieVar, 4, billingResult);
            consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
            return null;
        }
        billingClientImpl.zzaD(consumeParams, consumeResponseListener);
        return null;
    }

    public static /* synthetic */ Object zzs(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener, QueryProductDetailsParams queryProductDetailsParams) {
        if (!billingClientImpl.zzaX(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            billingClientImpl.zzbd(zzieVar, 7, billingResult);
            productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
            return null;
        } else if (!billingClientImpl.zzu) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Querying product details is not supported.");
            zzie zzieVar2 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
            BillingResult billingResult2 = zzcj.zzr;
            billingClientImpl.zzbd(zzieVar2, 7, billingResult2);
            productDetailsResponseListener.onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
            return null;
        } else {
            zzbo zzg = billingClientImpl.zzg(queryProductDetailsParams);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zza(zzg.zza(), zzg.zzb()), new QueryProductDetailsResult(zzg.zzc(), zzg.zzd()));
            return null;
        }
    }

    public static /* synthetic */ Object zzt(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) {
        billingClientImpl.zzas(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
        return null;
    }

    public static /* synthetic */ Object zzu(BillingClientImpl billingClientImpl, Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.zzau(bundle, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Object zzv(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        billingClientImpl.zzat(billingConfigResponseListener);
        return null;
    }

    public static /* synthetic */ Void zzz(BillingClientImpl billingClientImpl, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) {
        billingClientImpl.zzaB(alternativeBillingOnlyInformationDialogListener, activity, resultReceiver);
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzt(BillingClientImpl.this, acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzab
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzL(BillingClientImpl.this, acknowledgePurchaseResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, zzaq);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzaq);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzak
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzr(BillingClientImpl.this, consumeResponseListener, consumeParams);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzH(BillingClientImpl.this, consumeResponseListener, consumeParams);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, zzaq);
            consumeResponseListener.onConsumeResponse(zzaq, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzaf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzD(BillingClientImpl.this, alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzag
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        if (zzG(new Callable(externalOfferReportingDetailsListener, null) { // from class: com.android.billingclient.api.zzaq
            public final /* synthetic */ ExternalOfferReportingDetailsListener zzb;

            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzC(BillingClientImpl.this, this.zzb, null);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzar
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaI(externalOfferReportingDetailsListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaI(externalOfferReportingDetailsListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbi(12);
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    this.zzf.zzf();
                }
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Unbinding from service.");
                zzaV();
                zzaT();
                zzaS(3);
                this.zzG = null;
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzad
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzv(BillingClientImpl.this, billingConfigResponseListener);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzJ(BillingClientImpl.this, billingConfigResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, zzaq);
            billingConfigResponseListener.onBillingConfigResponse(zzaq, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzah
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzE(BillingClientImpl.this, alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzai
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzau
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzA(BillingClientImpl.this, externalOfferAvailabilityListener);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzv
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaJ(externalOfferAvailabilityListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaJ(externalOfferAvailabilityListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        char c;
        if (!zzaW(3000L)) {
            BillingResult billingResult = zzcj.zzj;
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            if (billingResult.getResponseCode() != 0) {
                zzbd(zzieVar, 5, billingResult);
            } else {
                zzbi(5);
            }
            return billingResult;
        }
        int i = zzcj.zzG;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 103272:
                if (str.equals("hhh")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 104265:
                if (str.equals("iii")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 106251:
                if (str.equals(BillingClient.FeatureType.EXTERNAL_OFFER)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 107244:
                if (str.equals("lll")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 108237:
                if (str.equals("mmm")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 109230:
                if (str.equals("nnn")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                BillingResult billingResult2 = this.zzk ? zzcj.zzi : zzcj.zzl;
                zzbc(billingResult2, zzie.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                return billingResult2;
            case 1:
                BillingResult billingResult3 = this.zzl ? zzcj.zzi : zzcj.zzm;
                zzbc(billingResult3, zzie.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                return billingResult3;
            case 2:
                BillingResult billingResult4 = this.zzo ? zzcj.zzi : zzcj.zzn;
                zzbc(billingResult4, zzie.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                return billingResult4;
            case 3:
                BillingResult billingResult5 = this.zzq ? zzcj.zzi : zzcj.zzs;
                zzbc(billingResult5, zzie.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                return billingResult5;
            case 4:
                BillingResult billingResult6 = this.zzs ? zzcj.zzi : zzcj.zzo;
                zzbc(billingResult6, zzie.CROSS_APP_NOT_SUPPORTED, 6);
                return billingResult6;
            case 5:
                BillingResult billingResult7 = this.zzr ? zzcj.zzi : zzcj.zzq;
                zzbc(billingResult7, zzie.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                return billingResult7;
            case 6:
                BillingResult billingResult8 = this.zzt ? zzcj.zzi : zzcj.zzp;
                zzbc(billingResult8, zzie.MULTI_ITEM_NOT_SUPPORTED, 8);
                return billingResult8;
            case 7:
                BillingResult billingResult9 = this.zzt ? zzcj.zzi : zzcj.zzp;
                zzbc(billingResult9, zzie.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                return billingResult9;
            case '\b':
                BillingResult billingResult10 = this.zzu ? zzcj.zzi : zzcj.zzr;
                zzbc(billingResult10, zzie.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                return billingResult10;
            case '\t':
                BillingResult billingResult11 = this.zzv ? zzcj.zzi : zzcj.zzy;
                zzbc(billingResult11, zzie.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                return billingResult11;
            case '\n':
                BillingResult billingResult12 = this.zzv ? zzcj.zzi : zzcj.zzz;
                zzbc(billingResult12, zzie.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                return billingResult12;
            case 11:
                BillingResult billingResult13 = this.zzx ? zzcj.zzi : zzcj.zzC;
                zzbc(billingResult13, zzie.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                return billingResult13;
            case '\f':
                BillingResult billingResult14 = this.zzy ? zzcj.zzi : zzcj.zzD;
                zzbc(billingResult14, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                return billingResult14;
            case '\r':
                BillingResult billingResult15 = this.zzB ? zzcj.zzi : zzcj.zzA;
                zzbc(billingResult15, zzie.LAUNCH_EXTERNAL_OFFER_FLOW_NOT_SUPPORTED, 18);
                return billingResult15;
            case 14:
                BillingResult billingResult16 = this.zzA ? zzcj.zzi : zzcj.zzu;
                zzbc(billingResult16, zzie.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                return billingResult16;
            case 15:
                BillingResult billingResult17 = this.zzB ? zzcj.zzi : zzcj.zzv;
                zzbc(billingResult17, zzie.AUTO_PAY_NOT_SUPPORTED, 20);
                return billingResult17;
            case 16:
                BillingResult billingResult18 = this.zzC ? zzcj.zzi : zzcj.zzw;
                zzbc(billingResult18, zzie.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                return billingResult18;
            default:
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
                BillingResult billingResult19 = zzcj.zzx;
                zzbc(billingResult19, zzie.UNKNOWN_FEATURE, 1);
                return billingResult19;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        if (this.zzE) {
            return true;
        }
        return zzaY();
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x050a  */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r29, final com.android.billingclient.api.BillingFlowParams r30) {
        /*
            Method dump skipped, instructions count: 1698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzal
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.zzs(BillingClientImpl.this, productDetailsResponseListener, queryProductDetailsParams);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzap
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzN(BillingClientImpl.this, productDetailsResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, zzaq);
            productDetailsResponseListener.onProductDetailsResponse(zzaq, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        if (zzG(new zzaw(this, purchasesResponseListener, queryPurchasesParams.zza(), false), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzat
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzI(BillingClientImpl.this, purchasesResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, zzaq);
            purchasesResponseListener.onQueryPurchasesResponse(zzaq, com.google.android.gms.internal.play_billing.zzbt.zzk());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!zzaW(3000L)) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
            return zzcj.zzj;
        } else if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzcj.zzs;
        } else {
            View findViewById = activity.findViewById(16908290);
            IBinder windowToken = findViewById.getWindowToken();
            Rect rect = new Rect();
            findViewById.getGlobalVisibleRect(rect);
            final Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
            bundle.putInt("KEY_DIMEN_LEFT", rect.left);
            bundle.putInt("KEY_DIMEN_TOP", rect.top);
            bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
            bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
            bundle.putString("playBillingLibraryVersion", this.zzc);
            String str = this.zzd;
            if (str != null) {
                bundle.putString("playBillingLibraryWrapperVersion", str);
            }
            bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
            Handler handler = this.zze;
            final zzax zzaxVar = new zzax(this, handler, inAppMessageResponseListener);
            zzG(new Callable() { // from class: com.android.billingclient.api.zzas
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.zzu(BillingClientImpl.this, bundle, activity, zzaxVar);
                    return null;
                }
            }, 5000L, null, handler, zzF());
            return zzcj.zzi;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized ExecutorService zzF() {
        if (this.zzH == null) {
            this.zzH = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzc.zza, new zzav(this));
        }
        return this.zzH;
    }

    public final void zzag(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.zze.post(runnable);
        }
    }

    final zzbo zzg(QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String zzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzbt zza = queryProductDetailsParams.zza();
        int size = zza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<QueryProductDetailsParams.Product> arrayList3 = new ArrayList(zza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.zzc;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar != null) {
                    boolean z = this.zzw && this.zzD.isEnabledForPrepaidPlans();
                    zzav(queryProductDetailsParams);
                    zzav(queryProductDetailsParams);
                    zzav(queryProductDetailsParams);
                    zzav(queryProductDetailsParams);
                    Bundle zzj = zzamVar.zzj(true != this.zzx ? 17 : 20, this.zzg.getPackageName(), zzb, bundle, com.google.android.gms.internal.play_billing.zzc.zzf(str, this.zzd, arrayList3, null, null, com.google.android.gms.internal.play_billing.zza.zza(z, true, false, true, false, true), this.zzI.longValue()));
                    if (zzj != null) {
                        if (zzj.containsKey("DETAILS_LIST")) {
                            ArrayList<String> stringArrayList = zzj.getStringArrayList("DETAILS_LIST");
                            if (stringArrayList != null) {
                                ArrayList arrayList5 = new ArrayList();
                                int size3 = stringArrayList.size();
                                for (int i4 = 0; i4 < size3; i4++) {
                                    try {
                                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i4));
                                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got product details: ".concat(productDetails.toString()));
                                        arrayList5.add(productDetails);
                                    } catch (JSONException e) {
                                        return zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                                    }
                                }
                                ArrayList<String> stringArrayList2 = zzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                                new ArrayList();
                                try {
                                    ArrayList arrayList6 = new ArrayList();
                                    if (stringArrayList2 != null) {
                                        for (String str2 : stringArrayList2) {
                                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(str2);
                                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                                            arrayList6.add(unfetchedProduct);
                                        }
                                    } else {
                                        for (QueryProductDetailsParams.Product product : arrayList3) {
                                            Iterator it = arrayList5.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    ProductDetails productDetails2 = (ProductDetails) it.next();
                                                    if (!product.zza().equals(productDetails2.getProductId()) || !product.zzb().equals(productDetails2.getProductType())) {
                                                    }
                                                } else {
                                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put(InAppPurchaseMetaData.KEY_PRODUCT_ID, product.zza()).put(HelpshiftEvent.DATA_MESSAGE_TYPE, product.zzb()).put("statusCode", 0).toString()));
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    arrayList.addAll(arrayList5);
                                    arrayList2.addAll(arrayList6);
                                    i = i2;
                                } catch (JSONException e2) {
                                    return zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e2);
                                }
                            } else {
                                return zzao(zzcj.zzB, zzie.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                            }
                        } else {
                            int zzb2 = com.google.android.gms.internal.play_billing.zzc.zzb(zzj, "BillingClient");
                            String zzj2 = com.google.android.gms.internal.play_billing.zzc.zzj(zzj, "BillingClient");
                            if (zzb2 != 0) {
                                BillingResult zza2 = zzcj.zza(zzb2, zzj2);
                                zzie zzieVar = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                                return zzao(zza2, zzieVar, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + zzb2, null);
                            }
                            return zzao(zzcj.zza(6, zzj2), zzie.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                        }
                    } else {
                        return zzao(zzcj.zzB, zzie.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                    }
                } else {
                    return zzao(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
            } catch (DeadObjectException e3) {
                return zzao(zzcj.zzj, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzao(zzcj.zzh, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzbo(0, "", arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzch zzj() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult zzm(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zze.post(new Runnable() { // from class: com.android.billingclient.api.zzac
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzP(BillingClientImpl.this, billingResult);
            }
        });
        return billingResult;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzaW(3000L)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            zzbd(zzieVar, 16, billingResult);
            return billingResult;
        } else if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzie zzieVar2 = zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED;
            BillingResult billingResult2 = zzcj.zzD;
            zzbd(zzieVar2, 16, billingResult2);
            return billingResult2;
        } else {
            Handler handler = this.zze;
            final zzay zzayVar = new zzay(this, handler, alternativeBillingOnlyInformationDialogListener);
            if (zzG(new Callable() { // from class: com.android.billingclient.api.zzy
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.zzz(BillingClientImpl.this, alternativeBillingOnlyInformationDialogListener, activity, zzayVar);
                    return null;
                }
            }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzz
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
                }
            }, handler, zzF()) == null) {
                BillingResult zzaq = zzaq();
                zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 16, zzaq);
                return zzaq;
            }
            return zzcj.zzi;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzaW(3000L)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            zzbd(zzieVar, 25, billingResult);
            return billingResult;
        } else if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support external offer.");
            zzie zzieVar2 = zzie.EXTERNAL_OFFER_NOT_SUPPORTED;
            BillingResult billingResult2 = zzcj.zzt;
            zzbd(zzieVar2, 25, billingResult2);
            return billingResult2;
        } else {
            Handler handler = this.zze;
            final zzaz zzazVar = new zzaz(this, handler, externalOfferInformationDialogListener);
            if (zzG(new Callable() { // from class: com.android.billingclient.api.zzan
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.zzB(BillingClientImpl.this, externalOfferInformationDialogListener, activity, zzazVar);
                    return null;
                }
            }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzao
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzaK(externalOfferInformationDialogListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
                }
            }, handler, zzF()) == null) {
                BillingResult zzaq = zzaq();
                zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 25, zzaq);
                return zzaq;
            }
            return zzcj.zzi;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        zzaU(billingClientStateListener, 0);
    }

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = str;
        this.zzd = zzaw();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, str, (zzch) null, builder);
    }

    private BillingClientImpl(String str) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = str;
        this.zzd = zzaw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, Context context, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long valueOf = Long.valueOf(new Random().nextLong());
        this.zzI = valueOf;
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String zzaw = zzaw();
        this.zzd = zzaw;
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(BuildConfig.VERSION_NAME);
        if (zzaw != null) {
            zzc.zzt(zzaw);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(valueOf.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, String str, zzch zzchVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzc.zzt(str2);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(this.zzI.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzchVar != null) {
            this.zzh = zzchVar;
        } else {
            this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzs(this.zzg, purchasesUpdatedListener, null, null, userChoiceBillingListener, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzF = userChoiceBillingListener != null;
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long valueOf = Long.valueOf(new Random().nextLong());
        this.zzI = valueOf;
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String zzaw = zzaw();
        this.zzd = zzaw;
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzs(BuildConfig.VERSION_NAME);
        if (zzaw != null) {
            zzc.zzt(zzaw);
        }
        zzc.zzq(this.zzg.getPackageName());
        zzc.zzn(valueOf.longValue());
        zzc.zzr(builder.zza);
        zzc.zza(Build.VERSION.SDK_INT);
        zzc.zzp(772604006L);
        try {
            zzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new zzs(this.zzg, null, null, null, null, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        this.zzd = zzaw();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, (zzb) null, BuildConfig.VERSION_NAME, (zzch) null, builder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, BuildConfig.VERSION_NAME, null, userChoiceBillingListener, null, null, builder);
    }
}
