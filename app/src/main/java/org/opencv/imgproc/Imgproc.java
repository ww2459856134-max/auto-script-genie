package org.opencv.imgproc;

import org.opencv.core.Mat;
import org.opencv.core.d;

/* loaded from: classes2.dex */
public abstract class Imgproc {
    private static native void GaussianBlur_2(long j2, long j3, double d, double d2, double d3);

    public static void a(Mat mat, Mat mat2, d dVar, double d) {
        GaussianBlur_2(mat.a, mat2.a, dVar.a, dVar.b, d);
    }

    public static void b(Mat mat, Mat mat2, int i2) {
        cvtColor_1(mat.a, mat2.a, i2);
    }

    public static void c(Mat mat, Mat mat2, int i2, int i3) {
        cvtColor_0(mat.a, mat2.a, i2, i3);
    }

    private static native void cvtColorTwoPlane_0(long j2, long j3, long j4, int i2);

    private static native void cvtColor_0(long j2, long j3, int i2, int i3);

    private static native void cvtColor_1(long j2, long j3, int i2);

    public static void d(Mat mat, Mat mat2, Mat mat3, int i2) {
        cvtColorTwoPlane_0(mat.a, mat2.a, mat3.a, i2);
    }

    public static void e(Mat mat, Mat mat2, Mat mat3, int i2) {
        matchTemplate_1(mat.a, mat2.a, mat3.a, i2);
    }

    public static double f(Mat mat, Mat mat2, double d, double d2, int i2) {
        return threshold_0(mat.a, mat2.a, d, d2, i2);
    }

    private static native void matchTemplate_1(long j2, long j3, long j4, int i2);

    private static native double threshold_0(long j2, long j3, double d, double d2, int i2);
}
