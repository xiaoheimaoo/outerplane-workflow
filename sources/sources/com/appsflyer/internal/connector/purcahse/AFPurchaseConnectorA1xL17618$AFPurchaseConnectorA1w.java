package com.appsflyer.internal.connector.purcahse;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import com.appsflyer.api.InAppPurchaseEvent;
import com.appsflyer.api.PurchaseClient;
import com.appsflyer.api.SubscriptionPurchaseEvent;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFPurchaseConnectorA1xL17618$AFPurchaseConnectorA1w implements AFPurchaseConnectorA1r.AFPurchaseConnectorA1x {
    private /* synthetic */ PurchaseClient getPackageName;

    public AFPurchaseConnectorA1xL17618$AFPurchaseConnectorA1w(PurchaseClient purchaseClient) {
        this.getPackageName = purchaseClient;
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r.AFPurchaseConnectorA1x
    public final void getOneTimePurchaseOfferDetails(List<SubscriptionPurchaseEvent> list) {
        Intrinsics.checkNotNullParameter(list, "");
        try {
            Object[] objArr = {this.getPackageName};
            Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-762062235);
            if (obj == null) {
                obj = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - KeyEvent.normalizeMetaState(0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 41951))).getMethod("toJsonMap", (Class) AFPurchaseConnectorA1w.getQuantity((ViewConfiguration.getLongPressTimeout() >> 16) + 70, MotionEvent.axisFromString("") + 1, (char) (41951 - (ViewConfiguration.getKeyRepeatTimeout() >> 16))));
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-762062235, obj);
            }
            if (!((Set) ((Method) obj).invoke(null, objArr)).contains("subs")) {
                AFLogger.afDebugLog("Not configured for auto Subscription logging");
                return;
            }
            Object[] objArr2 = {this.getPackageName, list};
            Object obj2 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-852589472);
            if (obj2 == null) {
                obj2 = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - View.resolveSize(0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (41951 - View.MeasureSpec.getMode(0)))).getMethod("toJsonMap", (Class) AFPurchaseConnectorA1w.getQuantity(69 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), ViewConfiguration.getJumpTapTimeout() >> 16, (char) (41951 - TextUtils.getTrimmedLength(""))), List.class);
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-852589472, obj2);
            }
            Object invoke = ((Method) obj2).invoke(null, objArr2);
            PurchaseClient purchaseClient = this.getPackageName;
            Object[] objArr3 = {purchaseClient};
            Object obj3 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-138748531);
            if (obj3 == null) {
                obj3 = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - Color.green(0), TextUtils.getCapsMode("", 0, 0), (char) (41951 - (Process.myPid() >> 22)))).getMethod("getQuantity", (Class) AFPurchaseConnectorA1w.getQuantity(70 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (View.resolveSizeAndState(0, 0, 0) + 41951)));
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-138748531, obj3);
            }
            Object[] objArr4 = {purchaseClient, Boolean.valueOf(((Boolean) ((Method) obj3).invoke(null, objArr3)).booleanValue()), true, list, invoke};
            Object obj4 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-545983492);
            if (obj4 == null) {
                obj4 = ((Class) AFPurchaseConnectorA1w.getQuantity((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 71, TextUtils.getCapsMode("", 0, 0), (char) (41951 - View.resolveSizeAndState(0, 0, 0)))).getMethod("getOneTimePurchaseOfferDetails", (Class) AFPurchaseConnectorA1w.getQuantity(MotionEvent.axisFromString("") + 71, ViewConfiguration.getWindowTouchSlop() >> 8, (char) (41951 - (ViewConfiguration.getKeyRepeatTimeout() >> 16))), Boolean.TYPE, Boolean.TYPE, List.class, Map.class);
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-545983492, obj4);
            }
            ((Method) obj4).invoke(null, objArr4);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r.AFPurchaseConnectorA1x
    public final void getQuantity(List<SubscriptionPurchaseEvent> list) {
        Intrinsics.checkNotNullParameter(list, "");
        try {
            Object[] objArr = {this.getPackageName};
            Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-762062235);
            if (obj == null) {
                obj = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - ExpandableListView.getPackedPositionGroup(0L), View.resolveSizeAndState(0, 0, 0), (char) (ExpandableListView.getPackedPositionGroup(0L) + 41951))).getMethod("toJsonMap", (Class) AFPurchaseConnectorA1w.getQuantity(71 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), Color.argb(0, 0, 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 41952)));
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-762062235, obj);
            }
            if (!((Set) ((Method) obj).invoke(null, objArr)).contains("subs")) {
                AFLogger.afDebugLog("Not configured for auto Subscription logging");
                return;
            }
            Object[] objArr2 = {this.getPackageName, list};
            Object obj2 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-852589472);
            if (obj2 == null) {
                obj2 = ((Class) AFPurchaseConnectorA1w.getQuantity((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 70, Gravity.getAbsoluteGravity(0, 0), (char) (View.getDefaultSize(0, 0) + 41951))).getMethod("toJsonMap", (Class) AFPurchaseConnectorA1w.getQuantity(70 - TextUtils.indexOf("", ""), KeyEvent.getDeadChar(0, 0), (char) (View.getDefaultSize(0, 0) + 41951)), List.class);
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-852589472, obj2);
            }
            Object invoke = ((Method) obj2).invoke(null, objArr2);
            PurchaseClient purchaseClient = this.getPackageName;
            Object[] objArr3 = {purchaseClient};
            Object obj3 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-138748531);
            if (obj3 == null) {
                obj3 = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - Gravity.getAbsoluteGravity(0, 0), 1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (View.combineMeasuredStates(0, 0) + 41951))).getMethod("getQuantity", (Class) AFPurchaseConnectorA1w.getQuantity(71 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (41951 - TextUtils.getTrimmedLength(""))));
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-138748531, obj3);
            }
            Object[] objArr4 = {purchaseClient, Boolean.valueOf(((Boolean) ((Method) obj3).invoke(null, objArr3)).booleanValue()), false, list, invoke};
            Object obj4 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-545983492);
            if (obj4 == null) {
                obj4 = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - ExpandableListView.getPackedPositionType(0L), ViewConfiguration.getKeyRepeatDelay() >> 16, (char) (41951 - (ViewConfiguration.getFadingEdgeLength() >> 16)))).getMethod("getOneTimePurchaseOfferDetails", (Class) AFPurchaseConnectorA1w.getQuantity(TextUtils.lastIndexOf("", '0', 0) + 71, View.MeasureSpec.getMode(0), (char) (41950 - TextUtils.indexOf((CharSequence) "", '0'))), Boolean.TYPE, Boolean.TYPE, List.class, Map.class);
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-545983492, obj4);
            }
            ((Method) obj4).invoke(null, objArr4);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r.AFPurchaseConnectorA1x
    public final void toJsonMap(List<InAppPurchaseEvent> list) {
        Intrinsics.checkNotNullParameter(list, "");
        try {
            Object[] objArr = {this.getPackageName};
            Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-762062235);
            if (obj == null) {
                obj = ((Class) AFPurchaseConnectorA1w.getQuantity((ViewConfiguration.getWindowTouchSlop() >> 8) + 70, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 41951))).getMethod("toJsonMap", (Class) AFPurchaseConnectorA1w.getQuantity(TextUtils.lastIndexOf("", '0') + 71, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (41951 - Color.blue(0))));
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-762062235, obj);
            }
            if (!((Set) ((Method) obj).invoke(null, objArr)).contains("inapp")) {
                AFLogger.afDebugLog("Not configured for auto In-App purchase logging.");
                return;
            }
            Object[] objArr2 = {this.getPackageName, list};
            Object obj2 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(1916049152);
            if (obj2 == null) {
                obj2 = ((Class) AFPurchaseConnectorA1w.getQuantity((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 70, View.MeasureSpec.getMode(0), (char) (41951 - (Process.myTid() >> 22)))).getMethod("InAppPurchaseEvent", (Class) AFPurchaseConnectorA1w.getQuantity(70 - TextUtils.getOffsetAfter("", 0), TextUtils.indexOf("", "", 0), (char) (41951 - TextUtils.getTrimmedLength(""))), List.class);
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(1916049152, obj2);
            }
            Object invoke = ((Method) obj2).invoke(null, objArr2);
            PurchaseClient purchaseClient = this.getPackageName;
            Object[] objArr3 = {purchaseClient};
            Object obj3 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-138748531);
            if (obj3 == null) {
                obj3 = ((Class) AFPurchaseConnectorA1w.getQuantity((KeyEvent.getMaxKeyCode() >> 16) + 70, 1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 41952))).getMethod("getQuantity", (Class) AFPurchaseConnectorA1w.getQuantity((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 69, 1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 41952)));
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-138748531, obj3);
            }
            Object[] objArr4 = {purchaseClient, Boolean.valueOf(((Boolean) ((Method) obj3).invoke(null, objArr3)).booleanValue()), list, invoke};
            Object obj4 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-1651426271);
            if (obj4 == null) {
                obj4 = ((Class) AFPurchaseConnectorA1w.getQuantity(70 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 41950))).getMethod("getQuantity", (Class) AFPurchaseConnectorA1w.getQuantity(71 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), View.MeasureSpec.getSize(0), (char) (41951 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))), Boolean.TYPE, List.class, Map.class);
                AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-1651426271, obj4);
            }
            ((Method) obj4).invoke(null, objArr4);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
