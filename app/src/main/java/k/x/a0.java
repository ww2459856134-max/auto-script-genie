package k.x;

import k.a0.a.f2;

/* loaded from: classes.dex */
public class a0 extends c1 {
    private byte[] c;
    private w d;
    private a1 e;
    private k.x.j1.t f;
    private k.w g;

    static {
        k.y.c.b(a0.class);
    }

    public a0(f2 f2Var, k.x.j1.t tVar, a1 a1Var, k.w wVar) {
        super(f2Var);
        this.c = f2Var.c();
        this.f = tVar;
        this.e = a1Var;
        this.g = wVar;
    }

    private void F() {
        if (this.d == null) {
            this.d = new w(this.c, this.f, this.e, this.g);
        }
    }

    w A() {
        return this.d;
    }

    public int B() {
        if (this.d == null) {
            F();
        }
        return this.d.d();
    }

    public int C() {
        if (this.d == null) {
            F();
        }
        return this.d.e();
    }

    public int D() {
        if (this.d == null) {
            F();
        }
        return this.d.f();
    }

    public int E() {
        if (this.d == null) {
            F();
        }
        return this.d.g();
    }

    void G(y yVar) {
    }

    @Override // k.x.c1
    public byte[] y() {
        w wVar = this.d;
        return wVar == null ? this.c : wVar.c();
    }

    a0(a0 a0Var, k.x.j1.t tVar, a1 a1Var, k.w wVar) {
        super(z0.d1);
        this.e = a1Var;
        this.f = tVar;
        this.g = wVar;
        k.y.a.a(a1Var != null);
        k.y.a.a(tVar != null);
        byte[] bArr = new byte[a0Var.c.length];
        this.c = bArr;
        System.arraycopy(a0Var.c, 0, bArr, 0, bArr.length);
    }

    public a0(w wVar) {
        super(z0.d1);
        this.d = wVar;
    }
}
