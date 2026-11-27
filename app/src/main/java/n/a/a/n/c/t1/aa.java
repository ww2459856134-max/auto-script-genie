package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class aa {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final n.a.a.n.c.r1.c0 e;
    private final n.a.a.n.c.r1.j f;

    public aa(n.a.a.n.c.r1.c0 c0Var) {
        this.e = c0Var;
        this.f = null;
        this.a = c0Var.getRow();
        this.b = c0Var.b();
        this.d = 1;
        this.c = 1;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public n.a.a.n.c.r1.j e(int i2, int i3, int i4, int i5) {
        n.a.a.n.c.r1.c0 c0Var = this.e;
        return c0Var == null ? this.f.c(i2, i3, i4, i5) : c0Var.c(i2, i3, i4, i5);
    }

    public aa(n.a.a.n.c.r1.j jVar) {
        this.e = null;
        this.f = jVar;
        this.a = jVar.getFirstRow();
        this.b = jVar.getFirstColumn();
        this.d = (jVar.getLastRow() - jVar.getFirstRow()) + 1;
        this.c = (jVar.getLastColumn() - jVar.getFirstColumn()) + 1;
    }
}
