package org.opencv.android;

import android.graphics.Bitmap;
import org.opencv.core.Mat;

/* loaded from: classes2.dex */
public abstract class Utils {
    public static void a(Bitmap bitmap, Mat mat) {
        b(bitmap, mat, false);
    }

    public static void b(Bitmap bitmap, Mat mat, boolean z) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        nBitmapToMat2(bitmap, mat.a, z);
    }

    public static void c(Mat mat, Bitmap bitmap) {
        d(mat, bitmap, false);
    }

    public static void d(Mat mat, Bitmap bitmap, boolean z) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        nMatToBitmap2(mat.a, bitmap, z);
    }

    private static native void nBitmapToMat2(Bitmap bitmap, long j2, boolean z);

    private static native void nMatToBitmap2(long j2, Bitmap bitmap, boolean z);
}
