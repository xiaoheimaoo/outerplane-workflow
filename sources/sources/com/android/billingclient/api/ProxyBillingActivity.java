package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {
    private static final String KEY_ACTIVITY_CODE = "activity_code";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    private static final int RESULT_CODE_PLAY_CANCELED_WITH_ON_CREATE_RUNTIME_EXCEPTION = 5;
    static final int RESULT_CODE_PLAY_CANCELLED = 3;
    static final int RESULT_CODE_PLAY_CANCELLED_WITHOUT_COMPLETE_ACTION = 4;
    private static final String TAG = "ProxyBillingActivity";
    private int activityCode;
    private long billingClientTransactionId;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private boolean sendCancelledBroadcastIfFinished;
    private boolean wasServiceAutoReconnected;

    private zzie getReasonForNullData(int i) {
        return i != -1 ? i != 0 ? i != 3 ? i != 4 ? i != 5 ? zzie.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzie.NULL_DATA_WITH_ON_CREATE_RUNTIME_EXCEPTION_RESULT_CODE : zzie.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE : zzie.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE : zzie.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzie.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
    }

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent makePurchaseUpdatedIntentWithInternalErrorReason(zzie zzieVar, long j) {
        Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
        makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
        makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(6);
        newBuilder.setDebugMessage("An internal error occurred.");
        BillingResult build = newBuilder.build();
        int i = zzcg.zza;
        makePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzcg.zzb(zzieVar, 2, build, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzM());
        makePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        makePurchasesUpdatedIntent.putExtra("billingClientTransactionId", j);
        makePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
        return makePurchasesUpdatedIntent;
    }

    private Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            r5 = this;
            super.onActivityResult(r6, r7, r8)
            r0 = 100
            r1 = 110(0x6e, float:1.54E-43)
            java.lang.String r2 = "ProxyBillingActivity"
            if (r6 == r0) goto L3f
            if (r6 != r1) goto Le
            goto L3f
        Le:
            r7 = 101(0x65, float:1.42E-43)
            if (r6 != r7) goto L27
            int r6 = com.google.android.gms.internal.play_billing.zzc.zza(r8, r2)
            android.os.ResultReceiver r7 = r5.inAppMessageResultReceiver
            if (r7 == 0) goto Ldd
            if (r8 != 0) goto L1e
            r8 = 0
            goto L22
        L1e:
            android.os.Bundle r8 = r8.getExtras()
        L22:
            r7.send(r6, r8)
            goto Ldd
        L27:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Got onActivityResult with wrong requestCode: "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = "; skipping..."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.google.android.gms.internal.play_billing.zzc.zzn(r2, r6)
            goto Ldd
        L3f:
            com.android.billingclient.api.BillingResult r0 = com.google.android.gms.internal.play_billing.zzc.zzh(r8, r2)
            int r0 = r0.getResponseCode()
            r3 = -1
            if (r7 != r3) goto L4d
            if (r0 == 0) goto L67
            r7 = r3
        L4d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Activity finished with resultCode "
            r3.<init>(r4)
            r3.append(r7)
            java.lang.String r4 = " and billing's responseCode: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.play_billing.zzc.zzn(r2, r0)
            r3 = r7
        L67:
            if (r8 == 0) goto Lb2
            android.os.Bundle r7 = r8.getExtras()
            if (r7 == 0) goto La4
            android.os.Bundle r7 = r8.getExtras()
            java.lang.String r0 = "ALTERNATIVE_BILLING_USER_CHOICE_DATA"
            java.lang.String r7 = r7.getString(r0)
            java.lang.String r0 = "LAUNCH_BILLING_FLOW"
            java.lang.String r2 = "INTENT_SOURCE"
            if (r7 == 0) goto L87
            android.content.Intent r7 = r5.makeAlternativeBillingIntent(r7)
            r7.putExtra(r2, r0)
            goto L95
        L87:
            android.content.Intent r7 = r5.makePurchasesUpdatedIntent()
            android.os.Bundle r8 = r8.getExtras()
            r7.putExtras(r8)
            r7.putExtra(r2, r0)
        L95:
            long r2 = r5.billingClientTransactionId
            java.lang.String r8 = "billingClientTransactionId"
            r7.putExtra(r8, r2)
            boolean r8 = r5.wasServiceAutoReconnected
            java.lang.String r0 = "wasServiceAutoReconnected"
            r7.putExtra(r0, r8)
            goto Ld2
        La4:
            java.lang.String r7 = "Got null bundle!"
            com.google.android.gms.internal.play_billing.zzc.zzn(r2, r7)
            com.google.android.gms.internal.play_billing.zzie r7 = com.google.android.gms.internal.play_billing.zzie.NULL_BUNDLE_IN_ACTIVITY_RESULT
            long r2 = r5.billingClientTransactionId
            android.content.Intent r7 = r5.makePurchaseUpdatedIntentWithInternalErrorReason(r7, r2)
            goto Ld2
        Lb2:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Got null data with resultCode "
            r7.<init>(r8)
            r7.append(r3)
            java.lang.String r8 = "!"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.google.android.gms.internal.play_billing.zzc.zzn(r2, r7)
            com.google.android.gms.internal.play_billing.zzie r7 = r5.getReasonForNullData(r3)
            long r2 = r5.billingClientTransactionId
            android.content.Intent r7 = r5.makePurchaseUpdatedIntentWithInternalErrorReason(r7, r2)
        Ld2:
            if (r6 != r1) goto Lda
            java.lang.String r6 = "IS_FIRST_PARTY_PURCHASE"
            r8 = 1
            r7.putExtra(r6, r8)
        Lda:
            r5.sendBroadcast(r7)
        Ldd:
            r6 = 0
            r5.sendCancelledBroadcastIfFinished = r6
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zzc.zzm(TAG, "Launching Play Store billing flow");
            this.activityCode = 100;
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
                if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    this.isFlowFromFirstPartyClient = true;
                    this.activityCode = 110;
                }
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
                this.activityCode = 101;
            } else {
                pendingIntent = null;
            }
            if (getIntent().hasExtra("billingClientTransactionId")) {
                this.billingClientTransactionId = getIntent().getLongExtra("billingClientTransactionId", 0L);
            }
            if (getIntent().hasExtra("wasServiceAutoReconnected")) {
                this.wasServiceAutoReconnected = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
            }
            try {
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e) {
                com.google.android.gms.internal.play_billing.zzc.zzo(TAG, "Got exception while trying to start a purchase flow.", e);
                ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                } else {
                    Intent makePurchaseUpdatedIntentWithInternalErrorReason = makePurchaseUpdatedIntentWithInternalErrorReason(zzie.INTENT_SENDER_EXCEPTION, this.billingClientTransactionId);
                    if (this.isFlowFromFirstPartyClient) {
                        makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    sendBroadcast(makePurchaseUpdatedIntentWithInternalErrorReason);
                }
                this.sendCancelledBroadcastIfFinished = false;
                finish();
                return;
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzm(TAG, "Launching Play Store billing flow from savedInstanceState");
        this.sendCancelledBroadcastIfFinished = bundle.getBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, false);
        if (bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER)) {
            this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
        }
        this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
        this.activityCode = bundle.getInt(KEY_ACTIVITY_CODE, 100);
        if (bundle.containsKey("billingClientTransactionId")) {
            this.billingClientTransactionId = bundle.getLong("billingClientTransactionId");
        }
        if (bundle.containsKey("wasServiceAutoReconnected")) {
            this.wasServiceAutoReconnected = bundle.getBoolean("wasServiceAutoReconnected");
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            if (this.isFlowFromFirstPartyClient) {
                makePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i = this.activityCode;
            if (i == 110 || i == 100) {
                makePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                makePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
            }
            sendBroadcast(makePurchasesUpdatedIntent);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER, resultReceiver);
        }
        bundle.putBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
        bundle.putInt(KEY_ACTIVITY_CODE, this.activityCode);
        bundle.putLong("billingClientTransactionId", this.billingClientTransactionId);
        bundle.putBoolean("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
    }
}
