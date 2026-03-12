package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import androidx.core.view.ViewCompat;
/* loaded from: classes3.dex */
final class J extends View implements PixelCopy.OnPixelCopyFinishedListener {
    Bitmap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(Context context) {
        super(context);
    }

    public final void a(SurfaceView surfaceView) {
        Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        this.a = createBitmap;
        PixelCopy.request(surfaceView, createBitmap, this, new Handler(Looper.getMainLooper()));
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        if (i == 0) {
            setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(ViewCompat.MEASURED_STATE_MASK), new BitmapDrawable(getResources(), this.a)}));
        }
    }
}
