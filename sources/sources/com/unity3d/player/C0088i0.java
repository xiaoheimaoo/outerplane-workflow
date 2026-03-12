package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.unity.androidnotifications.UnityNotificationManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.i0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0088i0 extends FrameLayout {
    private C0081f a;
    private UnityPlayer b;
    private K c;

    public C0088i0(Context context, UnityPlayer unityPlayer) {
        super(context);
        int i;
        this.c = new K(context);
        this.b = unityPlayer;
        C0081f c0081f = new C0081f(context, unityPlayer);
        this.a = c0081f;
        c0081f.setId(context.getResources().getIdentifier("unitySurfaceView", UnityNotificationManager.KEY_ID, context.getPackageName()));
        if (a()) {
            this.a.getHolder().setFormat(-3);
            this.a.setZOrderOnTop(true);
            i = 0;
        } else {
            this.a.getHolder().setFormat(-1);
            i = ViewCompat.MEASURED_STATE_MASK;
        }
        setBackgroundColor(i);
        this.a.getHolder().addCallback(new SurfaceHolder$CallbackC0086h0(this));
        this.a.setFocusable(true);
        this.a.setFocusableInTouchMode(true);
        this.a.setContentDescription(a(context));
        addView(this.a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private static String a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    private static boolean a() {
        Activity activity = UnityPlayer.currentActivity;
        if (activity == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842840});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f) {
        this.a.a(f);
    }

    public final void b() {
        K k = this.c;
        UnityPlayer unityPlayer = this.b;
        J j = k.b;
        if (j != null && j.getParent() != null) {
            unityPlayer.removeView(k.b);
        }
        this.c.b = null;
    }

    public final boolean c() {
        C0081f c0081f = this.a;
        return c0081f != null && c0081f.a();
    }
}
