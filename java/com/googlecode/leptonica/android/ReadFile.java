package com.googlecode.leptonica.android;

import android.graphics.Bitmap;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class ReadFile {
    private static final String a;

    static {
        System.loadLibrary("jpeg");
        System.loadLibrary("pngx");
        System.loadLibrary("leptonica");
        a = ReadFile.class.getSimpleName();
    }

    public static Pix a(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e(a, "Bitmap must be non-null");
            return null;
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            Log.e(a, "Bitmap config must be ARGB_8888");
            return null;
        }
        long jNativeReadBitmap = nativeReadBitmap(bitmap);
        if (jNativeReadBitmap != 0) {
            return new Pix(jNativeReadBitmap);
        }
        Log.e(a, "Failed to read pix from bitmap");
        return null;
    }

    private static native long nativeReadBitmap(Bitmap bitmap);
}
