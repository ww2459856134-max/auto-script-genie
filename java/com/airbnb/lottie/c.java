package com.airbnb.lottie;

/* loaded from: classes.dex */
public abstract class c {
    public static boolean a;
    private static boolean b;
    private static String[] c;
    private static long[] d;
    private static int e;
    private static int f;

    public static void a(String str) {
        if (b) {
            int i2 = e;
            if (i2 == 20) {
                f++;
                return;
            }
            c[i2] = str;
            d[i2] = System.nanoTime();
            h.e.f.d.a(str);
            e++;
        }
    }

    public static float b(String str) {
        int i2 = f;
        if (i2 > 0) {
            f = i2 - 1;
            return 0.0f;
        }
        if (!b) {
            return 0.0f;
        }
        int i3 = e - 1;
        e = i3;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(c[i3])) {
            h.e.f.d.b();
            return (System.nanoTime() - d[e]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[e] + ".");
    }
}
