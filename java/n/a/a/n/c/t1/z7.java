package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class z7 implements m8 {
    private final n.a.a.n.c.j1 a;
    private final int b;
    private final int c;

    public z7(n.a.a.n.c.j1 j1Var, int i2) {
        this.c = i2;
        int width = j1Var.getWidth() - 1;
        if (i2 >= 0 && i2 <= width) {
            this.a = j1Var;
            this.b = j1Var.a();
            return;
        }
        throw new IllegalArgumentException("Specified column index (" + i2 + ") is outside the allowed range (0.." + width + ")");
    }

    @Override // n.a.a.n.c.t1.m8
    public n.a.a.n.c.r1.w0 getItem(int i2) {
        if (i2 <= this.b) {
            return this.a.p(i2, this.c);
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
