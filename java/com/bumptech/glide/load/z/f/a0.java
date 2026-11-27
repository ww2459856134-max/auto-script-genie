package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
abstract class a0 {
    private static final com.bumptech.glide.load.x.g1.g a = new z();

    static com.bumptech.glide.load.x.z0<Bitmap> a(com.bumptech.glide.load.x.g1.g gVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(gVar, current, i2, i3);
            z = true;
        }
        if (!z) {
            gVar = a;
        }
        return e.e(bitmapB, gVar);
    }

    private static Bitmap b(com.bumptech.glide.load.x.g1.g gVar, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Lock lockF = r0.f();
        lockF.lock();
        Bitmap bitmapD = gVar.d(i2, i3, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapD);
            drawable.setBounds(0, 0, i2, i3);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapD;
        } finally {
            lockF.unlock();
        }
    }
}
