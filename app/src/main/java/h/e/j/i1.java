package h.e.j;

/* loaded from: classes.dex */
class i1 {
    private final e1 a;
    h.e.d.b[] b;

    i1() {
        this(new e1((e1) null));
    }

    protected final void a() {
        h.e.d.b[] bVarArr = this.b;
        if (bVarArr != null) {
            h.e.d.b bVar = bVarArr[p1.a(1)];
            h.e.d.b bVar2 = this.b[p1.a(2)];
            if (bVar != null && bVar2 != null) {
                f(h.e.d.b.a(bVar, bVar2));
            } else if (bVar != null) {
                f(bVar);
            } else if (bVar2 != null) {
                f(bVar2);
            }
            h.e.d.b bVar3 = this.b[p1.a(16)];
            if (bVar3 != null) {
                e(bVar3);
            }
            h.e.d.b bVar4 = this.b[p1.a(32)];
            if (bVar4 != null) {
                c(bVar4);
            }
            h.e.d.b bVar5 = this.b[p1.a(64)];
            if (bVar5 != null) {
                g(bVar5);
            }
        }
    }

    e1 b() {
        a();
        return this.a;
    }

    void c(h.e.d.b bVar) {
    }

    void d(h.e.d.b bVar) {
    }

    void e(h.e.d.b bVar) {
    }

    void f(h.e.d.b bVar) {
    }

    void g(h.e.d.b bVar) {
    }

    i1(e1 e1Var) {
        this.a = e1Var;
    }
}
