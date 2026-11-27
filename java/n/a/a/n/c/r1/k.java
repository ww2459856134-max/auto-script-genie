package n.a.a.n.c.r1;

import n.a.a.n.c.d1;

/* loaded from: classes.dex */
public abstract class k implements j {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2384h;

    protected k(d1 d1Var, int i2, int i3, int i4, int i5) {
        this.b = i3;
        this.c = i2;
        this.e = i5;
        this.f = i4;
        this.g = (i5 - i3) + 1;
        this.f2384h = (i4 - i2) + 1;
        if (d1Var != null) {
            this.a = d1Var.g();
            this.d = d1Var.d();
        } else {
            this.a = -1;
            this.d = -1;
        }
    }

    @Override // n.a.a.n.c.r1.j, n.a.a.n.c.j1
    public int a() {
        return (this.f - this.c) + 1;
    }

    @Override // n.a.a.n.c.d1
    public int d() {
        return this.d;
    }

    @Override // n.a.a.n.c.j1
    public boolean e(int i2) {
        return false;
    }

    @Override // n.a.a.n.c.d1
    public int g() {
        return this.a;
    }

    @Override // n.a.a.n.c.r1.j
    public final int getFirstColumn() {
        return this.b;
    }

    @Override // n.a.a.n.c.r1.j
    public final int getFirstRow() {
        return this.c;
    }

    @Override // n.a.a.n.c.r1.j
    public final int getLastColumn() {
        return this.e;
    }

    @Override // n.a.a.n.c.r1.j
    public final int getLastRow() {
        return this.f;
    }

    @Override // n.a.a.n.c.r1.j, n.a.a.n.c.j1
    public int getWidth() {
        return (this.e - this.b) + 1;
    }

    @Override // n.a.a.n.c.r1.j
    public final boolean i(int i2) {
        return this.b <= i2 && this.e >= i2;
    }

    @Override // n.a.a.n.c.i1
    public final w0 j(int i2, int i3, int i4) {
        return v(i2, i3, i4);
    }

    @Override // n.a.a.n.c.r1.j
    public abstract w0 k(int i2, int i3);

    @Override // n.a.a.n.c.r1.j
    public final boolean l(int i2) {
        return this.c <= i2 && this.f >= i2;
    }

    @Override // n.a.a.n.c.r1.j
    public final w0 m(int i2, int i3) {
        int i4 = i2 - this.c;
        int i5 = i3 - this.b;
        if (i4 < 0 || i4 >= this.f2384h) {
            throw new IllegalArgumentException("Specified row index (" + i2 + ") is outside the allowed range (" + this.c + ".." + this.f + ")");
        }
        if (i5 >= 0 && i5 < this.g) {
            return k(i4, i5);
        }
        throw new IllegalArgumentException("Specified column index (" + i3 + ") is outside the allowed range (" + this.b + ".." + i3 + ")");
    }

    @Override // n.a.a.n.c.j1
    public boolean n(int i2, int i3) {
        return false;
    }

    @Override // n.a.a.n.c.j1
    public final w0 p(int i2, int i3) {
        return k(i2, i3);
    }

    @Override // n.a.a.n.c.j1
    public final boolean q() {
        return this.c == this.f;
    }

    @Override // n.a.a.n.c.j1
    public final boolean s() {
        return this.b == this.e;
    }

    public final boolean u(int i2, int i3) {
        return this.c <= i2 && this.f >= i2 && this.b <= i3 && this.e >= i3;
    }

    public abstract w0 v(int i2, int i3, int i4);

    protected k(int i2, int i3, int i4, int i5) {
        this(null, i2, i3, i4, i5);
    }

    protected k(n.a.a.n.c.u1.d1 d1Var) {
        this(d1Var, null);
    }

    protected k(n.a.a.n.c.u1.d1 d1Var, d1 d1Var2) {
        this(d1Var2, d1Var.getFirstRow(), d1Var.getFirstColumn(), d1Var.getLastRow(), d1Var.getLastColumn());
    }
}
