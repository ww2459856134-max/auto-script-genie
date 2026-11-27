package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class m3 extends b6 {
    public static final p6 b = new m3(1);
    public static final p6 c = new m3(2);
    public static final p6 d = new m3(5);
    public static final p6 e = new m3(11);
    public static final p6 f = new m3(12);
    public static final p6 g = new m3(13);
    private final int a;

    private m3(int i2) {
        this.a = i2;
    }

    private int l(double d2) {
        if (((int) d2) == 0) {
            int i2 = this.a;
            if (i2 == 1) {
                return 1900;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 5) {
                return 0;
            }
        }
        int i3 = n.a.a.n.d.y.j(d2 + 5.78125E-6d, false).get(this.a);
        return this.a == 2 ? i3 + 1 : i3;
    }

    @Override // n.a.a.n.c.t1.l6
    public final n.a.a.n.c.r1.w0 g(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            return n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, i3)) < 0.0d ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(l(r3));
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }
}
