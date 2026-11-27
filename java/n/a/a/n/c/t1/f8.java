package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class f8 implements m8 {
    private final n.a.a.n.c.j1 a;
    private final int b;
    private final int c;

    public f8(n.a.a.n.c.j1 j1Var, int i2) {
        this.c = i2;
        int iA = j1Var.a() - 1;
        if (i2 >= 0 && i2 <= iA) {
            this.a = j1Var;
            this.b = j1Var.getWidth();
            return;
        }
        throw new IllegalArgumentException("Specified row index (" + i2 + ") is outside the allowed range (0.." + iA + ")");
    }

    @Override // n.a.a.n.c.t1.m8
    public n.a.a.n.c.r1.w0 getItem(int i2) {
        if (i2 <= this.b) {
            return this.a.p(this.c, i2);
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
