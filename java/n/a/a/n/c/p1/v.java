package n.a.a.n.c.p1;

import n.a.a.n.c.j1;
import n.a.a.n.c.r1.m0;
import n.a.a.n.c.r1.w0;

/* loaded from: classes.dex */
class v implements n.a.a.n.c.r1.j {
    final /* synthetic */ int a;
    final /* synthetic */ w0 b;

    v(w wVar, int i2, w0 w0Var) {
        this.a = i2;
        this.b = w0Var;
    }

    @Override // n.a.a.n.c.r1.j, n.a.a.n.c.j1
    public int a() {
        return 1;
    }

    @Override // n.a.a.n.c.r1.j
    public n.a.a.n.c.r1.j c(int i2, int i3, int i4, int i5) {
        return null;
    }

    @Override // n.a.a.n.c.d1
    public int d() {
        return 0;
    }

    @Override // n.a.a.n.c.j1
    public boolean e(int i2) {
        return false;
    }

    @Override // n.a.a.n.c.j1
    public j1 f(int i2) {
        return null;
    }

    @Override // n.a.a.n.c.d1
    public int g() {
        return 0;
    }

    @Override // n.a.a.n.c.r1.j
    public int getFirstColumn() {
        return 0;
    }

    @Override // n.a.a.n.c.r1.j
    public int getFirstRow() {
        return 0;
    }

    @Override // n.a.a.n.c.r1.j
    public int getLastColumn() {
        return this.a - 1;
    }

    @Override // n.a.a.n.c.r1.j
    public int getLastRow() {
        return 0;
    }

    @Override // n.a.a.n.c.r1.j, n.a.a.n.c.j1
    public int getWidth() {
        return this.a;
    }

    @Override // n.a.a.n.c.j1
    public j1 h(int i2) {
        return null;
    }

    @Override // n.a.a.n.c.r1.j
    public boolean i(int i2) {
        return i2 < this.a;
    }

    @Override // n.a.a.n.c.i1
    public w0 j(int i2, int i3, int i4) {
        return m(i3, i4);
    }

    @Override // n.a.a.n.c.r1.j
    public w0 k(int i2, int i3) {
        return m(i2, i3);
    }

    @Override // n.a.a.n.c.r1.j
    public boolean l(int i2) {
        return i2 == 0;
    }

    @Override // n.a.a.n.c.r1.j
    public w0 m(int i2, int i3) {
        return i3 == 0 ? this.b : new m0("");
    }

    @Override // n.a.a.n.c.j1
    public boolean n(int i2, int i3) {
        return false;
    }

    @Override // n.a.a.n.c.j1
    public w0 p(int i2, int i3) {
        return m(i2, i3);
    }

    @Override // n.a.a.n.c.j1
    public boolean s() {
        return false;
    }
}
