package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract class i7 implements m8 {
    private final int a;

    protected i7(int i2) {
        this.a = i2;
    }

    protected abstract n.a.a.n.c.r1.w0 c(int i2);

    @Override // n.a.a.n.c.t1.m8
    public n.a.a.n.c.r1.w0 getItem(int i2) {
        if (i2 >= 0 && i2 <= this.a) {
            return c(i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Specified index ");
        sb.append(i2);
        sb.append(" is outside range (0..");
        sb.append(this.a - 1);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // n.a.a.n.c.t1.m8
    public final int getSize() {
        return this.a;
    }
}
