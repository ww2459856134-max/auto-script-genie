package n.a.a.n.c.r1;

import n.a.a.n.c.d1;

/* loaded from: classes.dex */
public abstract class d0 implements c0 {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    protected d0(d1 d1Var, int i2, int i3) {
        if (d1Var == null) {
            throw new IllegalArgumentException("sheetRange must not be null");
        }
        this.a = d1Var.g();
        this.b = d1Var.d();
        this.c = i2;
        this.d = i3;
    }

    @Override // n.a.a.n.c.r1.c0
    public final int b() {
        return this.d;
    }

    @Override // n.a.a.n.c.r1.c0, n.a.a.n.c.d1
    public int d() {
        return this.b;
    }

    @Override // n.a.a.n.c.r1.c0, n.a.a.n.c.d1
    public int g() {
        return this.a;
    }

    @Override // n.a.a.n.c.r1.c0
    public final int getRow() {
        return this.c;
    }

    @Override // n.a.a.n.c.r1.c0
    public int t() {
        return (this.b - this.a) + 1;
    }
}
