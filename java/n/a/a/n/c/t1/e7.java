package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class e7 extends i7 {
    private final n.a.a.n.c.j1 b;
    private final int c;

    public e7(n.a.a.n.c.j1 j1Var) {
        super(j1Var.getWidth() * j1Var.a());
        this.b = j1Var;
        this.c = j1Var.getWidth();
    }

    @Override // n.a.a.n.c.t1.i7
    protected n.a.a.n.c.r1.w0 c(int i2) {
        int i3 = this.c;
        return this.b.p(i2 / i3, i2 % i3);
    }
}
