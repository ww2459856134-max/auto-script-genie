package i.f.a.v.m;

/* loaded from: classes.dex */
public abstract class a {
    public static float a(float f, float f2, float f3, float f4) {
        double d = f - f3;
        double d2 = f2 - f4;
        return (float) Math.sqrt((d * d) + (d2 * d2));
    }

    public static float b(int i2, int i3, int i4, int i5) {
        double d = i2 - i4;
        double d2 = i3 - i5;
        return (float) Math.sqrt((d * d) + (d2 * d2));
    }

    public static int c(float f) {
        return (int) (f + (f < 0.0f ? -0.5f : 0.5f));
    }

    public static int d(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }
}
