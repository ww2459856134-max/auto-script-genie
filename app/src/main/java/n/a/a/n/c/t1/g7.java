package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class g7 extends i7 {
    private final n.a.a.n.c.r1.c0 b;
    private final int c;

    public g7(n.a.a.n.c.r1.c0 c0Var) {
        super(c0Var.t());
        this.b = c0Var;
        this.c = c0Var.t();
    }

    @Override // n.a.a.n.c.t1.i7
    protected n.a.a.n.c.r1.w0 c(int i2) {
        return this.b.o((i2 % this.c) + this.b.g());
    }
}
