package k.x.j1;

/* loaded from: classes.dex */
public class x {
    private u0 a;

    static {
        k.y.c.b(x.class);
    }

    public x(byte[] bArr, k.c cVar, t tVar, k.x.a1 a1Var, k.w wVar) throws w {
        if (tVar.d() != null && !tVar.d().A()) {
            throw new w(w.e);
        }
        k.y.a.a(a1Var != null);
        this.a = new j1(bArr, cVar, tVar, a1Var, wVar, s0.a);
    }

    public byte[] a() {
        return this.a.a();
    }

    public String b() throws w {
        return this.a.getFormula();
    }

    public void c() throws w {
        this.a.b();
    }

    public x(byte[] bArr, k.c cVar, t tVar, k.x.a1 a1Var, k.w wVar, s0 s0Var) throws w {
        if (tVar.d() != null && !tVar.d().A()) {
            throw new w(w.e);
        }
        k.y.a.a(a1Var != null);
        this.a = new j1(bArr, cVar, tVar, a1Var, wVar, s0Var);
    }

    public x(String str, t tVar, k.x.a1 a1Var, k.w wVar) {
        this.a = new b1(str, tVar, a1Var, wVar, s0.a);
    }

    public x(String str, t tVar, k.x.a1 a1Var, k.w wVar, s0 s0Var) {
        this.a = new b1(str, tVar, a1Var, wVar, s0Var);
    }
}
