package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class kc extends mc {
    private final n.a.a.n.c.r1.c0 b;
    private final int c;

    public kc(n.a.a.n.c.r1.c0 c0Var) {
        super(c0Var.t());
        this.b = c0Var;
        this.c = c0Var.t();
    }

    @Override // n.a.a.n.c.t1.mc
    protected n.a.a.n.c.r1.w0 c(int i2) {
        return this.b.o((i2 % this.c) + this.b.g());
    }
}
