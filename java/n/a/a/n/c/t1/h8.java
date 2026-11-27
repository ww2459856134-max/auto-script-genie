package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class h8 implements m8 {
    private final n.a.a.n.c.r1.c0 a;
    private final int b;

    public h8(n.a.a.n.c.r1.c0 c0Var) {
        this.b = c0Var.t();
        this.a = c0Var;
    }

    @Override // n.a.a.n.c.t1.m8
    public n.a.a.n.c.r1.w0 getItem(int i2) {
        if (i2 < this.b) {
            return this.a.o(this.a.g() + i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Specified index (");
        sb.append(i2);
        sb.append(") is outside the allowed range (0..");
        sb.append(this.b - 1);
        sb.append(")");
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    @Override // n.a.a.n.c.t1.m8
    public int getSize() {
        return this.b;
    }
}
