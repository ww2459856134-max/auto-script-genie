package androidx.fragment.app;

/* loaded from: classes.dex */
abstract class p {
    private final i3 a;
    private final h.e.f.c b;

    p(i3 i3Var, h.e.f.c cVar) {
        this.a = i3Var;
        this.b = cVar;
    }

    void a() {
        this.a.d(this.b);
    }

    i3 b() {
        return this.a;
    }

    h.e.f.c c() {
        return this.b;
    }

    boolean d() {
        h3 h3Var;
        h3 h3VarC = h3.c(this.a.f().h0);
        h3 h3VarE = this.a.e();
        return h3VarC == h3VarE || !(h3VarC == (h3Var = h3.VISIBLE) || h3VarE == h3Var);
    }
}
