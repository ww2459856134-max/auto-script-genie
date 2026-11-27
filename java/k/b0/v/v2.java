package k.b0.v;

import java.util.ArrayList;
import java.util.TreeSet;

/* loaded from: classes.dex */
class v2 {
    private static k.y.c x = k.y.c.b(v2.class);
    private k.a0.a.y2 a;
    private p3 b;
    private k.w c;
    private TreeSet d;
    private k.x.n0 e;
    private ArrayList f;
    private j1 g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f1962h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f1963i;

    /* renamed from: j, reason: collision with root package name */
    private w2 f1964j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f1965k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f1966l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList f1967m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList f1968n;

    /* renamed from: o, reason: collision with root package name */
    private k.x.a f1969o;
    private k.x.y p;
    private k.x.i1.j q;
    private s1 r;
    private boolean s = false;
    private k t;
    private int u;
    private int v;
    private int w;

    public v2(k.s sVar, k.b0.s sVar2) {
        this.a = (k.a0.a.y2) sVar;
        p3 p3Var = (p3) sVar2;
        this.b = p3Var;
        this.c = p3Var.o().r();
    }

    private k.b0.k v(k.c cVar) {
        k.f type = cVar.getType();
        if (type == k.f.c) {
            return new k.b0.g((k.o) cVar);
        }
        if (type == k.f.d) {
            return new k.b0.h((k.p) cVar);
        }
        if (type == k.f.f1994l) {
            return new k.b0.f((k.g) cVar);
        }
        if (type == k.f.e) {
            return new k.b0.b((k.a) cVar);
        }
        if (type == k.f.g) {
            return new f2((k.x.o0) cVar);
        }
        if (type == k.f.f1991i) {
            return new g2((k.x.o0) cVar);
        }
        if (type == k.f.f1992j) {
            return new b2((k.x.o0) cVar);
        }
        if (type == k.f.f1990h) {
            return new c2((k.x.o0) cVar);
        }
        if (type == k.f.f1993k) {
            return new d2((k.x.o0) cVar);
        }
        if (type != k.f.b || cVar.e() == null) {
            return null;
        }
        return new k.b0.a(cVar);
    }

    public void a() {
        w();
        for (k.a0.a.r rVar : this.a.j()) {
            for (int iC = rVar.C(); iC <= rVar.z(); iC++) {
                r rVar2 = new r(rVar, iC, this.e);
                rVar2.C(rVar.A());
                this.d.add(rVar2);
            }
        }
        for (k.m mVar : this.a.o()) {
            this.f.add(new k.b0.q(mVar, this.b));
        }
        for (k.r rVar3 : this.a.r()) {
            this.g.a(new k.x.x0((k.x.x0) rVar3, this.b));
        }
        try {
            k.a0.a.i2[] i2VarArrV = this.a.v();
            for (int i2 = 0; i2 < i2VarArrV.length; i2++) {
                this.b.n(i2VarArrV[i2].B()).E(i2VarArrV[i2].A(), i2VarArrV[i2].G(), i2VarArrV[i2].E(), i2VarArrV[i2].z(), i2VarArrV[i2].y(), i2VarArrV[i2].D() ? this.e.h(i2VarArrV[i2].C()) : null);
                this.u = Math.max(this.u, i2VarArrV[i2].B() + 1);
            }
        } catch (l2 unused) {
            k.y.a.a(false);
        }
        int[] iArrU = this.a.u();
        if (iArrU != null) {
            for (int i3 : iArrU) {
                this.f1962h.add(new Integer(i3));
            }
        }
        int[] iArrK = this.a.k();
        if (iArrK != null) {
            for (int i4 : iArrK) {
                this.f1963i.add(new Integer(i4));
            }
        }
        this.f1964j.g(this.a.i());
        k.x.i1.w[] wVarArrN = this.a.n();
        for (int i5 = 0; i5 < wVarArrN.length; i5++) {
            if (wVarArrN[i5] instanceof k.x.i1.s) {
                k.b0.r rVar4 = new k.b0.r(wVarArrN[i5], this.b.o().o());
                this.f1965k.add(rVar4);
                this.f1966l.add(rVar4);
            } else if (wVarArrN[i5] instanceof k.x.i1.k) {
                k.x.i1.k kVar = new k.x.i1.k(wVarArrN[i5], this.b.o().o(), this.c);
                this.f1965k.add(kVar);
                o oVar = (o) this.b.q(kVar.l(), kVar.o());
                k.y.a.a(oVar.c() != null);
                oVar.u().k(kVar);
            } else if (wVarArrN[i5] instanceof k.x.i1.d) {
                this.f1965k.add(new k.x.i1.d(wVarArrN[i5], this.b.o().o(), this.c));
            } else if (wVarArrN[i5] instanceof k.x.i1.j) {
                this.f1965k.add(new k.x.i1.j(wVarArrN[i5], this.b.o().o(), this.c));
            } else if (wVarArrN[i5] instanceof k.x.i1.f) {
                this.f1965k.add(new k.x.i1.f(wVarArrN[i5], this.b.o().o(), this.c));
            }
        }
        k.x.y yVarM = this.a.m();
        if (yVarM != null) {
            k.x.y yVar = new k.x.y(yVarM, this.b.o(), this.b.o(), this.c);
            this.p = yVar;
            int iB = yVar.b();
            if (iB != 0) {
                this.q = (k.x.i1.j) this.f1965k.get(iB);
            }
        }
        k.x.n[] nVarArrL = this.a.l();
        if (nVarArrL.length > 0) {
            for (k.x.n nVar : nVarArrL) {
                this.f1967m.add(nVar);
            }
        }
        this.f1969o = this.a.g();
        this.f1964j.n(this.a.z());
        if (this.a.w().B()) {
            this.s = true;
            this.f1964j.f();
        }
        if (this.a.s() != null) {
            if (this.a.y().z()) {
                x.f("Cannot copy Biff7 print settings record - ignoring");
            } else {
                this.r = new s1(this.a.s());
            }
        }
        if (this.a.h() != null) {
            this.t = new k(this.a.h());
        }
        this.v = this.a.q();
        this.w = this.a.p();
    }

    k.x.a b() {
        return this.f1969o;
    }

    k c() {
        return this.t;
    }

    k.x.i1.j d() {
        return this.q;
    }

    k.x.y e() {
        return this.p;
    }

    public int f() {
        return this.w;
    }

    public int g() {
        return this.v;
    }

    s1 h() {
        return this.r;
    }

    int i() {
        return this.u;
    }

    boolean j() {
        return this.s;
    }

    void k(ArrayList arrayList) {
        this.f1963i = arrayList;
    }

    void l(TreeSet treeSet) {
        this.d = treeSet;
    }

    void m(ArrayList arrayList) {
        this.f1967m = arrayList;
    }

    void n(ArrayList arrayList) {
        this.f1965k = arrayList;
    }

    void o(k.x.n0 n0Var) {
        this.e = n0Var;
    }

    void p(ArrayList arrayList) {
        this.f = arrayList;
    }

    void q(ArrayList arrayList) {
        this.f1966l = arrayList;
    }

    void r(j1 j1Var) {
        this.g = j1Var;
    }

    void s(ArrayList arrayList) {
        this.f1962h = arrayList;
    }

    void t(w2 w2Var) {
        this.f1964j = w2Var;
    }

    void u(ArrayList arrayList) {
        this.f1968n = arrayList;
    }

    void w() {
        int iB = this.a.b();
        for (int i2 = 0; i2 < iB; i2++) {
            for (k.c cVar : this.a.t(i2)) {
                k.b0.k kVarV = v(cVar);
                if (kVarV != null) {
                    try {
                        this.b.c(kVarV);
                        if (kVarV.c() != null && kVarV.c().f()) {
                            this.f1968n.add(kVarV);
                        }
                    } catch (k.b0.u unused) {
                        k.y.a.a(false);
                    }
                }
            }
        }
        this.u = this.b.b();
    }
}
