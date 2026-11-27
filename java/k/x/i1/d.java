package k.x.i1;

import java.io.IOException;
import k.x.y0;

/* loaded from: classes.dex */
public class d implements w {
    private static k.y.c s = k.y.c.b(d.class);
    private y a;
    private y b;
    private e0 c;
    private h0 d;
    private boolean e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private k0 f2047h;

    /* renamed from: i, reason: collision with root package name */
    private v f2048i;

    /* renamed from: j, reason: collision with root package name */
    private t f2049j;

    /* renamed from: k, reason: collision with root package name */
    private l0 f2050k;

    /* renamed from: l, reason: collision with root package name */
    private int f2051l;

    /* renamed from: m, reason: collision with root package name */
    private e0 f2052m;

    /* renamed from: n, reason: collision with root package name */
    private s0 f2053n;

    /* renamed from: o, reason: collision with root package name */
    private k.x.r f2054o;
    private k.x.r p;
    private String q;
    private k.w r;

    public d(e0 e0Var, h0 h0Var, t tVar, v vVar, k.w wVar) {
        boolean z = false;
        this.e = false;
        this.f2048i = vVar;
        this.c = e0Var;
        this.f2049j = tVar;
        this.d = h0Var;
        this.e = false;
        this.r = wVar;
        this.f2047h = k0.a;
        tVar.a(e0Var.y());
        this.f2051l = this.f2049j.c() - 1;
        this.f2048i.f(this);
        if (this.c != null && this.d != null) {
            z = true;
        }
        k.y.a.a(z);
        n();
    }

    private y l() {
        if (!this.e) {
            n();
        }
        return this.a;
    }

    private void n() {
        y yVarD = this.f2049j.d(this.f2051l);
        this.a = yVarD;
        k.y.a.a(yVarD != null);
        z[] zVarArrN = this.a.n();
        n0 n0Var = (n0) this.a.n()[0];
        this.f = this.d.C();
        this.g = n0Var.m();
        l0 l0VarA = l0.a(n0Var.n());
        this.f2050k = l0VarA;
        if (l0VarA == l0.g) {
            s.f("Unknown shape type");
        }
        g gVar = null;
        for (int i2 = 0; i2 < zVarArrN.length && gVar == null; i2++) {
            if (zVarArrN[i2].h() == b0.f2046o) {
                gVar = (g) zVarArrN[i2];
            }
        }
        if (gVar == null) {
            s.f("Client anchor not found");
        } else {
            gVar.n();
            gVar.p();
        }
        this.e = true;
    }

    @Override // k.x.i1.w
    public e0 a() {
        return this.c;
    }

    @Override // k.x.i1.w
    public void b(k.b0.v.l0 l0Var) throws IOException {
        if (this.f2047h == k0.a) {
            l0Var.e(this.d);
            e0 e0Var = this.f2052m;
            if (e0Var != null) {
                l0Var.e(e0Var);
            }
            l0Var.e(this.f2053n);
            l0Var.e(this.f2054o);
            k.x.r rVar = this.p;
            if (rVar != null) {
                l0Var.e(rVar);
                return;
            }
            return;
        }
        k.y.a.a(false);
        l0Var.e(new h0(this.f, h0.f2071m));
        l0Var.e(new e0(new i().b()));
        l0Var.e(new s0(m()));
        byte[] bArr = new byte[(this.q.length() * 2) + 1];
        bArr[0] = 1;
        y0.e(this.q, bArr, 1);
        l0Var.e(new k.x.r(bArr));
        byte[] bArr2 = new byte[16];
        k.x.s0.f(0, bArr2, 0);
        k.x.s0.f(0, bArr2, 2);
        k.x.s0.f(this.q.length(), bArr2, 8);
        k.x.s0.f(0, bArr2, 10);
        l0Var.e(new k.x.r(bArr2));
    }

    @Override // k.x.i1.w
    public final int c() {
        if (!this.e) {
            n();
        }
        return this.f;
    }

    @Override // k.x.i1.w
    public boolean d() {
        return true;
    }

    @Override // k.x.i1.w
    public String e() {
        k.y.a.a(false);
        return null;
    }

    @Override // k.x.i1.w
    public boolean f() {
        return this.f2052m.A();
    }

    @Override // k.x.i1.w
    public y g() {
        if (!this.e) {
            n();
        }
        if (this.f2047h == k0.a) {
            return l();
        }
        k.y.a.a(false);
        return this.b;
    }

    @Override // k.x.i1.w
    public k0 getOrigin() {
        return this.f2047h;
    }

    @Override // k.x.i1.w
    public final int getShapeId() {
        if (!this.e) {
            n();
        }
        return this.g;
    }

    @Override // k.x.i1.w
    public void h(k.b0.v.l0 l0Var) {
    }

    public int hashCode() {
        return this.q.hashCode();
    }

    @Override // k.x.i1.w
    public final void i(int i2, int i3, int i4) {
        this.f = i2;
        this.g = i4;
        if (this.f2047h == k0.a) {
            this.f2047h = k0.c;
        }
    }

    @Override // k.x.i1.w
    public void j(v vVar) {
        this.f2048i = vVar;
    }

    public void k(e0 e0Var) {
        this.f2052m = e0Var;
        this.f2049j.b(e0Var.y());
    }

    public String m() {
        if (this.q == null) {
            k.y.a.a(this.f2054o != null);
            byte[] bArrY = this.f2054o.y();
            if (bArrY[0] == 0) {
                this.q = y0.d(bArrY, bArrY.length - 1, 1, this.r);
            } else {
                this.q = y0.g(bArrY, (bArrY.length - 1) / 2, 1);
            }
        }
        return this.q;
    }

    public void o(k.x.r rVar) {
        this.p = rVar;
    }

    public void p(k.x.r rVar) {
        this.f2054o = rVar;
    }

    public void q(s0 s0Var) {
        this.f2053n = s0Var;
    }

    public d(w wVar, v vVar, k.w wVar2) {
        this.e = false;
        d dVar = (d) wVar;
        k0 k0Var = dVar.f2047h;
        k0 k0Var2 = k0.a;
        k.y.a.a(k0Var == k0Var2);
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = false;
        this.f2047h = k0Var2;
        this.f2049j = dVar.f2049j;
        this.f2048i = vVar;
        this.f2051l = dVar.f2051l;
        vVar.f(this);
        this.f2052m = dVar.f2052m;
        this.f2053n = dVar.f2053n;
        this.f2054o = dVar.f2054o;
        this.p = dVar.p;
        this.r = wVar2;
    }
}
