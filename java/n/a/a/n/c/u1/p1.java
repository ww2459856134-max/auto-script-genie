package n.a.a.n.c.u1;

/* loaded from: classes.dex */
public final class p1 extends y0 {
    private p1(int i2, n.a.a.n.c.s1.b bVar) {
        super(i2, bVar.f(), bVar.e(), bVar.c());
    }

    public static p1 B(int i2) {
        n.a.a.n.c.s1.b bVarB = n.a.a.n.c.s1.d.b(i2);
        if (bVarB != null) {
            return new p1(i2, bVarB);
        }
        throw new IllegalStateException("Invalid built-in function index (" + i2 + ")");
    }

    @Override // n.a.a.n.c.u1.k2
    public byte k() {
        return (byte) 33;
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return 3;
    }
}
