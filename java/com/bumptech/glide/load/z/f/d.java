package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d extends com.bumptech.glide.load.z.c<Bitmap> {
    private final com.bumptech.glide.load.x.g1.g b = new com.bumptech.glide.load.x.g1.h();

    @Override // com.bumptech.glide.load.z.c
    protected com.bumptech.glide.load.x.z0<Bitmap> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]");
        }
        return new e(bitmapDecodeBitmap, this.b);
    }
}
