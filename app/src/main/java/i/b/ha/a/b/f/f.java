package i.b.ha.a.b.f;

/* loaded from: classes.dex */
public abstract class f {
    public static int a(int i2, long j2) {
        try {
            return Math.addExact(i2, Math.toIntExact(j2));
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Argument too large or result overflows", e);
        }
    }
}
