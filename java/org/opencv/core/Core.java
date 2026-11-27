package org.opencv.core;

/* loaded from: classes2.dex */
public abstract class Core {
    static {
        e();
        b();
        f();
        g();
        h();
        i();
    }

    public static String a() {
        return getBuildInformation_0();
    }

    private static String b() {
        return "opencv_java341";
    }

    public static long c() {
        return getTickCount_0();
    }

    public static double d() {
        return getTickFrequency_0();
    }

    private static String e() {
        return "3.4.1";
    }

    private static int f() {
        return 3;
    }

    private static int g() {
        return 4;
    }

    private static native String getBuildInformation_0();

    private static native long getTickCount_0();

    private static native double getTickFrequency_0();

    private static int h() {
        return 1;
    }

    private static String i() {
        return "";
    }

    public static a j(Mat mat) {
        return k(mat, null);
    }

    public static a k(Mat mat, Mat mat2) {
        a aVar = new a();
        double[] dArrN_minMaxLocManual = n_minMaxLocManual(mat.a, mat2 != null ? mat2.a : 0L);
        double d = dArrN_minMaxLocManual[0];
        aVar.a = dArrN_minMaxLocManual[1];
        c cVar = aVar.b;
        cVar.a = dArrN_minMaxLocManual[2];
        cVar.b = dArrN_minMaxLocManual[3];
        c cVar2 = aVar.c;
        cVar2.a = dArrN_minMaxLocManual[4];
        cVar2.b = dArrN_minMaxLocManual[5];
        return aVar;
    }

    private static native double[] n_minMaxLocManual(long j2, long j3);
}
