package com.appsflyer.internal.connector.purcahse;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.api.InAppPurchaseEvent;
import com.appsflyer.api.PurchaseClient;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFPurchaseConnectorA1xL17618$AFPurchaseConnectorA1y implements PurchaseHandler.PurchaseValidationCallback {
    private /* synthetic */ List<InAppPurchaseEvent> getOneTimePurchaseOfferDetails;
    private /* synthetic */ PurchaseClient getQuantity;

    public AFPurchaseConnectorA1xL17618$AFPurchaseConnectorA1y(PurchaseClient purchaseClient, List<InAppPurchaseEvent> list) {
        this.getQuantity = purchaseClient;
        this.getOneTimePurchaseOfferDetails = list;
    }

    @Override // com.appsflyer.PurchaseHandler.PurchaseValidationCallback
    public final void onResponse(ResponseNetwork<String> responseNetwork) {
        Intrinsics.checkNotNullParameter(responseNetwork, "");
        boolean isSuccessful = responseNetwork.isSuccessful();
        if (isSuccessful) {
            try {
                Object[] objArr = {this.getQuantity, this.getOneTimePurchaseOfferDetails};
                Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(2011750110);
                if (obj == null) {
                    obj = ((Class) AFPurchaseConnectorA1w.getQuantity(69 - TextUtils.indexOf((CharSequence) "", '0', 0), TextUtils.lastIndexOf("", '0') + 1, (char) (41951 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))).getMethod("getPackageName", (Class) AFPurchaseConnectorA1w.getQuantity(Color.alpha(0) + 70, Color.red(0), (char) (TextUtils.getCapsMode("", 0, 0) + 41951)), List.class);
                    AFPurchaseConnectorA1w.PurchaseClientCompanion.put(2011750110, obj);
                }
                ((Method) obj).invoke(null, objArr);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        Object[] objArr2 = {this.getQuantity};
        Object obj2 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-892438429);
        if (obj2 == null) {
            obj2 = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - (ViewConfiguration.getLongPressTimeout() >> 16), Process.myTid() >> 22, (char) (41951 - (Process.myPid() >> 22)))).getMethod("getPackageName", (Class) AFPurchaseConnectorA1w.getQuantity((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 70, ViewConfiguration.getPressedStateDuration() >> 16, (char) ((KeyEvent.getMaxKeyCode() >> 16) + 41951)));
            AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-892438429, obj2);
        }
        PurchaseClient.InAppPurchaseValidationResultListener inAppPurchaseValidationResultListener = (PurchaseClient.InAppPurchaseValidationResultListener) ((Method) obj2).invoke(null, objArr2);
        if (inAppPurchaseValidationResultListener != null) {
            if (isSuccessful) {
                Object[] objArr3 = {responseNetwork};
                Object obj3 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-933417750);
                if (obj3 == null) {
                    obj3 = ((Class) AFPurchaseConnectorA1w.getQuantity((Process.myPid() >> 22) + 70, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 70, (char) KeyEvent.keyCodeFromString(""))).getMethod("InAppPurchaseEvent", ResponseNetwork.class);
                    AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-933417750, obj3);
                }
                inAppPurchaseValidationResultListener.onResponse(((Method) obj3).invoke(null, objArr3));
                return;
            }
            String body = responseNetwork.getBody();
            Intrinsics.checkNotNullExpressionValue(body, "");
            inAppPurchaseValidationResultListener.onFailure(body, null);
        }
    }

    @Override // com.appsflyer.PurchaseHandler.PurchaseValidationCallback
    public final void onFailure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        try {
            Object[] objArr = {this.getQuantity};
            Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(794963980);
            if (obj == null) {
                obj = ((Class) AFPurchaseConnectorA1w.getQuantity(TextUtils.indexOf((CharSequence) "", '0') + 71, ViewConfiguration.getLongPressTimeout() >> 16, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 41951))).getMethod("getOneTimePurchaseOfferDetails", (Class) AFPurchaseConnectorA1w.getQuantity(TextUtils.indexOf((CharSequence) "", '0', 0) + 71, KeyEvent.normalizeMetaState(0), (char) (41999 - AndroidCharacter.getMirror('0'))));
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(794963980, obj);
            }
            PurchaseClient.SubscriptionPurchaseValidationResultListener subscriptionPurchaseValidationResultListener = (PurchaseClient.SubscriptionPurchaseValidationResultListener) ((Method) obj).invoke(null, objArr);
            if (subscriptionPurchaseValidationResultListener != null) {
                subscriptionPurchaseValidationResultListener.onFailure("[PurchaseConnector]: Communication exception", th);
            }
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }
}
