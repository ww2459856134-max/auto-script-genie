package k.b0.v;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class q3 extends k.b0.t implements k.x.j1.t, k.x.a1 {
    private k.x.n0 f;
    private l0 g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f1933h;

    /* renamed from: i, reason: collision with root package name */
    private k.x.j0 f1934i;

    /* renamed from: j, reason: collision with root package name */
    private k0 f1935j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f1936k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f1937l;

    /* renamed from: m, reason: collision with root package name */
    private HashMap f1938m;

    /* renamed from: n, reason: collision with root package name */
    private u2 f1939n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1940o;
    private boolean p;
    private k.w q;
    private ArrayList r;
    private k.x.i1.v s;
    private y2 t;
    private boolean u;
    private k v;
    private v w;
    private String[] x;
    private k.x.d1[] y;
    private static k.y.c z = k.y.c.b(q3.class);
    private static Object A = new Object();

    public q3(OutputStream outputStream, k.v vVar, boolean z2, k.w wVar) throws IndexOutOfBoundsException, IOException {
        k.a0.a.n3 n3Var = (k.a0.a.n3) vVar;
        synchronized (A) {
            k.b0.t.a.B();
            k.b0.t.b.B();
            k.b0.t.c.V();
            k.b0.t.d.V();
            k.b0.t.e.V();
            z.f1986o.V();
        }
        this.f1940o = z2;
        this.f1933h = new ArrayList();
        this.f1939n = new u2();
        this.f1938m = new HashMap();
        this.f1934i = n3Var.x();
        this.f = n3Var.y();
        this.p = false;
        this.q = wVar;
        this.r = new ArrayList();
        this.t = new y2();
        this.g = new l0(outputStream, wVar, n3Var.t());
        this.u = false;
        if (!wVar.q()) {
            this.u = n3Var.q();
        }
        if (n3Var.u() != null) {
            this.w = new v(n3Var.u());
        }
        this.x = n3Var.r();
        this.y = n3Var.C();
        if (n3Var.w() != null) {
            this.f1935j = new k0(n3Var.w());
            k.a0.a.d3[] d3VarArrB = n3Var.B();
            this.f1936k = new ArrayList(d3VarArrB.length);
            for (k.a0.a.d3 d3Var : d3VarArrB) {
                if (d3Var.C() == k.a0.a.d3.g || d3Var.C() == k.a0.a.d3.f1796h) {
                    this.f1936k.add(new b3(d3Var, this.q));
                } else if (d3Var.C() != k.a0.a.d3.f1797i) {
                    z.f("unsupported supbook type - ignoring");
                }
            }
        }
        if (n3Var.v() != null) {
            this.s = new k.x.i1.v(n3Var.v());
        }
        if (this.u && n3Var.s() != null) {
            this.v = new k(n3Var.s());
        }
        if (!this.q.p()) {
            k.a0.a.o1[] o1VarArrZ = n3Var.z();
            this.f1937l = new ArrayList(o1VarArrZ.length);
            for (int i2 = 0; i2 < o1VarArrZ.length; i2++) {
                if (o1VarArrZ[i2].D()) {
                    n1 n1Var = new n1(o1VarArrZ[i2], i2);
                    this.f1937l.add(n1Var);
                    this.f1938m.put(n1Var.getName(), n1Var);
                } else {
                    z.f("Cannot copy Biff7 name records - ignoring");
                }
            }
        }
        m(vVar);
        k.x.i1.v vVar2 = this.s;
        if (vVar2 != null) {
            vVar2.l(n3Var.v());
        }
    }

    private void m(k.v vVar) throws IndexOutOfBoundsException {
        int i2 = vVar.i();
        this.p = vVar.n();
        for (int i3 = 0; i3 < i2; i3++) {
            k.s sVarJ = vVar.j(i3);
            ((p3) n(sVarJ.getName(), i3, false)).j(sVarJ);
        }
    }

    private k.b0.s n(String str, int i2, boolean z2) {
        k0 k0Var;
        p3 p3Var = new p3(str, this.g, this.f, this.f1939n, this.q, this);
        if (i2 <= 0) {
            this.f1933h.add(0, p3Var);
            i2 = 0;
        } else if (i2 > this.f1933h.size()) {
            i2 = this.f1933h.size();
            this.f1933h.add(p3Var);
        } else {
            this.f1933h.add(i2, p3Var);
        }
        if (z2 && (k0Var = this.f1935j) != null) {
            k0Var.D(i2);
        }
        ArrayList arrayList = this.f1936k;
        if (arrayList != null && arrayList.size() > 0) {
            b3 b3Var = (b3) this.f1936k.get(0);
            if (b3Var.F() == b3.f1889j) {
                b3Var.A(this.f1933h.size());
            }
        }
        return p3Var;
    }

    private int p(String str) {
        String[] strArrS = s();
        for (int i2 = 0; i2 < strArrS.length; i2++) {
            if (str.equals(strArrS[i2])) {
                return i2;
            }
        }
        return -1;
    }

    private void u() {
        k.x.r0 r0VarL = this.f.l();
        k.x.r0 r0VarK = this.f.k();
        k.x.r0 r0VarJ = this.f.j(r0VarL, r0VarK);
        for (int i2 = 0; i2 < this.f1933h.size(); i2++) {
            ((p3) this.f1933h.get(i2)).s(r0VarJ, r0VarL, r0VarK);
        }
    }

    @Override // k.x.j1.t
    public String a(int i2) {
        b3 b3Var = (b3) this.f1936k.get(this.f1935j.C(i2));
        int iA = this.f1935j.A(i2);
        if (b3Var.F() == b3.f1889j) {
            return g(iA).getName();
        }
        if (b3Var.F() != b3.f1890k) {
            z.f("Unknown Supbook 1");
            return "[UNKNOWN]";
        }
        return b3Var.B() + b3Var.E(iA);
    }

    @Override // k.x.a1
    public String b(int i2) {
        k.y.a.a(i2 >= 0 && i2 < this.f1937l.size());
        return ((n1) this.f1937l.get(i2)).getName();
    }

    @Override // k.x.j1.t
    public int c(String str) {
        if (this.f1935j == null) {
            this.f1935j = new k0();
            ArrayList arrayList = new ArrayList();
            this.f1936k = arrayList;
            arrayList.add(new b3(q(), this.q));
        }
        Iterator it = this.f1933h.iterator();
        boolean z2 = false;
        int i2 = 0;
        while (it.hasNext() && !z2) {
            if (((p3) it.next()).getName().equals(str)) {
                z2 = true;
            } else {
                i2++;
            }
        }
        if (z2) {
            b3 b3Var = (b3) this.f1936k.get(0);
            if (b3Var.F() != b3.f1889j || b3Var.C() != q()) {
                z.f("Cannot find sheet " + str + " in supbook record");
            }
            return this.f1935j.B(0, i2);
        }
        int iLastIndexOf = str.lastIndexOf(93);
        int iLastIndexOf2 = str.lastIndexOf(91);
        int size = -1;
        if (iLastIndexOf == -1 || iLastIndexOf2 == -1) {
            z.f("Square brackets");
            return -1;
        }
        String strSubstring = str.substring(iLastIndexOf + 1);
        String strSubstring2 = str.substring(iLastIndexOf2 + 1, iLastIndexOf);
        String str2 = str.substring(0, iLastIndexOf2) + strSubstring2;
        b3 b3Var2 = null;
        boolean z3 = false;
        for (int i3 = 0; i3 < this.f1936k.size() && !z3; i3++) {
            b3Var2 = (b3) this.f1936k.get(i3);
            if (b3Var2.F() == b3.f1890k && b3Var2.B().equals(str2)) {
                z3 = true;
                size = i3;
            }
        }
        if (!z3) {
            b3Var2 = new b3(str2, this.q);
            size = this.f1936k.size();
            this.f1936k.add(b3Var2);
        }
        return this.f1935j.B(size, b3Var2.D(strSubstring));
    }

    @Override // k.x.j1.t
    public k.a0.a.a d() {
        return null;
    }

    @Override // k.x.a1
    public int e(String str) {
        n1 n1Var = (n1) this.f1938m.get(str);
        if (n1Var != null) {
            return n1Var.A();
        }
        return -1;
    }

    @Override // k.b0.t
    public void f() throws d1, IOException {
        this.g.a(this.f1940o);
    }

    @Override // k.b0.t
    public k.b0.s g(int i2) {
        return (k.b0.s) this.f1933h.get(i2);
    }

    @Override // k.b0.t
    public void h() throws IOException {
        for (int i2 = 0; i2 < q(); i2++) {
            p3 p3Var = (p3) g(i2);
            p3Var.i();
            k.r rVarB = p3Var.getSettings().B();
            if (rVarB != null) {
                k(k.x.i.d, p3Var, rVarB.getTopLeft().b(), rVarB.getTopLeft().getRow(), rVarB.getBottomRight().b(), rVarB.getBottomRight().getRow(), false);
            }
            k.r rVarF = p3Var.getSettings().F();
            k.r rVarE = p3Var.getSettings().E();
            if (rVarF != null && rVarE != null) {
                j(k.x.i.e, p3Var, rVarF.getTopLeft().b(), rVarF.getTopLeft().getRow(), rVarF.getBottomRight().b(), rVarF.getBottomRight().getRow(), rVarE.getTopLeft().b(), rVarE.getTopLeft().getRow(), rVarE.getBottomRight().b(), rVarE.getBottomRight().getRow(), false);
            } else if (rVarF != null) {
                k(k.x.i.e, p3Var, rVarF.getTopLeft().b(), rVarF.getTopLeft().getRow(), rVarF.getBottomRight().b(), rVarF.getBottomRight().getRow(), false);
            } else if (rVarE != null) {
                k(k.x.i.e, p3Var, rVarE.getTopLeft().b(), rVarE.getTopLeft().getRow(), rVarE.getBottomRight().b(), rVarE.getBottomRight().getRow(), false);
            }
        }
        if (!this.q.r()) {
            u();
        }
        this.g.e(new d(d.d));
        if (this.q.t()) {
            this.g.e(new d3());
        }
        this.g.e(new a1());
        this.g.e(new g1(0, 0));
        this.g.e(new z0());
        this.g.e(new r3(this.q.x()));
        this.g.e(new q());
        this.g.e(new x());
        if (this.q.f()) {
            this.g.e(new f0());
        }
        this.g.e(new c3(q()));
        if (this.u) {
            this.g.e(new q1());
        }
        k kVar = this.v;
        if (kVar != null) {
            this.g.e(kVar);
        }
        this.g.e(new o0());
        this.g.e(new l3(this.q.w()));
        this.g.e(new a2(this.p));
        this.g.e(new u1((String) null));
        this.g.e(new z1(false));
        this.g.e(new y1());
        boolean z2 = false;
        int i3 = 0;
        for (int i4 = 0; i4 < q() && !z2; i4++) {
            if (((p3) g(i4)).getSettings().R()) {
                i3 = i4;
                z2 = true;
            }
        }
        if (!z2) {
            ((p3) g(0)).getSettings().A0(true);
            i3 = 0;
        }
        this.g.e(new j3(i3));
        this.g.e(new e(false));
        this.g.e(new s0(this.q.k()));
        this.g.e(new o1(false));
        this.g.e(new v1(false));
        this.g.e(new i2(this.q.s()));
        this.g.e(new g(true));
        this.f1934i.d(this.g);
        this.f.n(this.g);
        if (this.f.g() != null) {
            this.g.e(this.f.g());
        }
        this.g.e(new f3());
        int[] iArr = new int[q()];
        for (int i5 = 0; i5 < q(); i5++) {
            iArr[i5] = this.g.c();
            k.b0.s sVarG = g(i5);
            j jVar = new j(sVarG.getName());
            if (sVarG.getSettings().O()) {
                jVar.B();
            }
            if (((p3) this.f1933h.get(i5)).r()) {
                jVar.A();
            }
            this.g.e(jVar);
        }
        if (this.w == null) {
            k.x.s sVarB = k.x.s.b(this.q.g());
            k.x.s sVar = k.x.s.g;
            if (sVarB == sVar) {
                k.y.c cVar = z;
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown country code ");
                sb.append(this.q.g());
                sb.append(" using ");
                k.x.s sVar2 = k.x.s.e;
                sb.append(sVar2.a());
                cVar.f(sb.toString());
                sVarB = sVar2;
            }
            k.x.s sVarB2 = k.x.s.b(this.q.h());
            this.w = new v(sVarB, sVarB2);
            if (sVarB2 == sVar) {
                z.f("Unknown country code " + this.q.g() + " using " + k.x.s.f.a());
            }
        }
        this.g.e(this.w);
        String[] strArr = this.x;
        if (strArr != null && strArr.length > 0) {
            for (int i6 = 0; i6 < this.x.length; i6++) {
                this.g.e(new i0(this.x[i6]));
            }
        }
        if (this.y != null) {
            int i7 = 0;
            while (true) {
                k.x.d1[] d1VarArr = this.y;
                if (i7 >= d1VarArr.length) {
                    break;
                }
                this.g.e(d1VarArr[i7]);
                i7++;
            }
        }
        if (this.f1935j != null) {
            for (int i8 = 0; i8 < this.f1936k.size(); i8++) {
                this.g.e((b3) this.f1936k.get(i8));
            }
            this.g.e(this.f1935j);
        }
        if (this.f1937l != null) {
            for (int i9 = 0; i9 < this.f1937l.size(); i9++) {
                this.g.e((n1) this.f1937l.get(i9));
            }
        }
        k.x.i1.v vVar = this.s;
        if (vVar != null) {
            vVar.m(this.g);
        }
        this.f1939n.d(this.g);
        this.g.e(new e0());
        for (int i10 = 0; i10 < q(); i10++) {
            l0 l0Var = this.g;
            l0Var.d(k.x.s0.b(l0Var.c()), iArr[i10] + 4);
            ((p3) g(i10)).x();
        }
    }

    void i(k.x.i1.w wVar) {
        if (this.s == null) {
            this.s = new k.x.i1.v(k.x.i1.k0.b);
        }
        this.s.b(wVar);
    }

    void j(k.x.i iVar, k.b0.s sVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        if (this.f1937l == null) {
            this.f1937l = new ArrayList();
        }
        n1 n1Var = new n1(iVar, p(sVar.getName()), c(sVar.getName()), i7, i9, i6, i8, i3, i5, i2, i4, z2);
        this.f1937l.add(n1Var);
        this.f1938m.put(iVar, n1Var);
    }

    void k(k.x.i iVar, k.b0.s sVar, int i2, int i3, int i4, int i5, boolean z2) {
        if (this.f1937l == null) {
            this.f1937l = new ArrayList();
        }
        n1 n1Var = new n1(iVar, p(sVar.getName()), c(sVar.getName()), i3, i5, i2, i4, z2);
        this.f1937l.add(n1Var);
        this.f1938m.put(iVar, n1Var);
    }

    void l(o oVar) {
        this.r.add(oVar);
    }

    k.x.i1.v o() {
        return this.s;
    }

    public int q() {
        return this.f1933h.size();
    }

    k.w r() {
        return this.q;
    }

    public String[] s() {
        int iQ = q();
        String[] strArr = new String[iQ];
        for (int i2 = 0; i2 < iQ; i2++) {
            strArr[i2] = g(i2).getName();
        }
        return strArr;
    }

    y2 t() {
        return this.t;
    }
}
