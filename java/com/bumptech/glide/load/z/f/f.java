package com.bumptech.glide.load.z.f;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: classes.dex */
public abstract class f implements com.bumptech.glide.load.v<Bitmap> {
    @Override // com.bumptech.glide.load.v
    public final com.bumptech.glide.load.x.z0<Bitmap> a(Context context, com.bumptech.glide.load.x.z0<Bitmap> z0Var, int i2, int i3) {
        if (!com.bumptech.glide.b0.p.r(i2, i3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.load.x.g1.g gVarF = com.bumptech.glide.c.c(context).f();
        Bitmap bitmap = z0Var.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(gVarF, bitmap, i2, i3);
        return bitmap.equals(bitmapC) ? z0Var : e.e(bitmapC, gVarF);
    }

    protected abstract Bitmap c(com.bumptech.glide.load.x.g1.g gVar, Bitmap bitmap, int i2, int i3);
}
