package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class s5 extends b6 {
    private int l(int i2) {
        switch (r5.a[n.a.a.n.d.i0.b(i2).ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                throw new IllegalArgumentException("Invalid error code (" + i2 + ")");
        }
    }

    @Override // n.a.a.n.c.t1.l6
    public n.a.a.n.c.r1.w0 g(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            return n.a.a.n.c.r1.o.f2386i;
        } catch (n.a.a.n.c.r1.p e) {
            return new n.a.a.n.c.r1.x(l(e.a().u()));
        }
    }
}
