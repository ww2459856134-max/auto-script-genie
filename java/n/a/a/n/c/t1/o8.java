package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class o8 implements m8 {
    private final n.a.a.n.c.r1.w0 a;

    public o8(n.a.a.n.c.r1.w0 w0Var) {
        this.a = w0Var;
    }

    @Override // n.a.a.n.c.t1.m8
    public n.a.a.n.c.r1.w0 getItem(int i2) {
        if (i2 == 0) {
            return this.a;
        }
        throw new IllegalStateException("Invalid index (" + i2 + ") only zero is allowed");
    }

    @Override // n.a.a.n.c.t1.m8
    public int getSize() {
        return 1;
    }
}
