package com.appsflyer.internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFi1fSDKT8615$AFa1uSDK implements OnCompleteListener<IntegrityTokenResponse> {
    private final long getMediationNetwork;
    private /* synthetic */ AFi1jSDK getRevenue;

    public AFi1fSDKT8615$AFa1uSDK(AFi1jSDK aFi1jSDK, long j) {
        this.getRevenue = aFi1jSDK;
        this.getMediationNetwork = j;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<IntegrityTokenResponse> task) {
        Object invoke;
        String str;
        Intrinsics.checkNotNullParameter(task, "");
        if (task.isSuccessful()) {
            str = task.getResult().token();
            invoke = null;
        } else {
            try {
                Object[] objArr = {this.getRevenue, task.getException()};
                Object obj = AFi1hSDK.d.get(-556555390);
                if (obj == null) {
                    obj = ((Class) AFi1hSDK.getCurrencyIso4217Code((char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 37 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Color.red(0))).getMethod("AFAdRevenueData", (Class) AFi1hSDK.getCurrencyIso4217Code((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 35 - TextUtils.indexOf((CharSequence) "", '0', 0), KeyEvent.keyCodeFromString("")), Exception.class);
                    AFi1hSDK.d.put(-556555390, obj);
                }
                invoke = ((Method) obj).invoke(null, objArr);
                str = null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        Object[] objArr2 = {this.getRevenue, Long.valueOf(this.getMediationNetwork), str, invoke};
        Object obj2 = AFi1hSDK.d.get(1107971505);
        if (obj2 == null) {
            obj2 = ((Class) AFi1hSDK.getCurrencyIso4217Code((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 35, Process.myPid() >> 22)).getMethod("getCurrencyIso4217Code", (Class) AFi1hSDK.getCurrencyIso4217Code((char) (ViewConfiguration.getPressedStateDuration() >> 16), 36 - View.MeasureSpec.getSize(0), ViewConfiguration.getScrollBarFadeDuration() >> 16), Long.TYPE, String.class, String.class);
            AFi1hSDK.d.put(1107971505, obj2);
        }
        ((Method) obj2).invoke(null, objArr2);
        Object[] objArr3 = {this.getRevenue};
        Object obj3 = AFi1hSDK.d.get(1522770359);
        if (obj3 == null) {
            obj3 = ((Class) AFi1hSDK.getCurrencyIso4217Code((char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 36, TextUtils.getCapsMode("", 0, 0))).getMethod("getCurrencyIso4217Code", (Class) AFi1hSDK.getCurrencyIso4217Code((char) (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 36, 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
            AFi1hSDK.d.put(1522770359, obj3);
        }
        ((CountDownLatch) ((Method) obj3).invoke(null, objArr3)).countDown();
    }
}
