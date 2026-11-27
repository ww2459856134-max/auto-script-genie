package k.b0.v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/* loaded from: classes.dex */
final class w2 {
    private static k.y.c x = k.y.c.b(w2.class);
    private l0 a;
    private k2[] b;
    private int c;
    private int d;
    private k.t e;
    private k.w f;
    private ArrayList g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f1970h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f1971i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f1972j;

    /* renamed from: k, reason: collision with root package name */
    private k.x.a f1973k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f1974l;

    /* renamed from: m, reason: collision with root package name */
    private k.x.y f1975m;

    /* renamed from: n, reason: collision with root package name */
    private j1 f1976n;

    /* renamed from: o, reason: collision with root package name */
    private s1 f1977o;
    private k p;
    private TreeSet r;
    private k.x.i1.m0 s;
    private int u;
    private int v;
    private p3 w;
    private k.x.b1 q = new k.x.b1();
    private boolean t = false;

    public w2(l0 l0Var, p3 p3Var, k.w wVar) {
        this.a = l0Var;
        this.w = p3Var;
        this.f = wVar;
        this.s = new k.x.i1.m0(wVar);
    }

    private k.c[] c(int i2) {
        int i3 = this.c - 1;
        boolean z = false;
        while (i3 >= 0 && !z) {
            k2[] k2VarArr = this.b;
            if (k2VarArr[i3] == null || k2VarArr[i3].B(i2) == null) {
                i3--;
            } else {
                z = true;
            }
        }
        k.c[] cVarArr = new k.c[i3 + 1];
        for (int i4 = 0; i4 <= i3; i4++) {
            k2[] k2VarArr2 = this.b;
            cVarArr[i4] = k2VarArr2[i4] != null ? k2VarArr2[i4].B(i2) : null;
        }
        return cVarArr;
    }

    private void q() throws IOException {
        if (this.f1975m != null && this.f1974l.size() == 0) {
            this.f1975m.f(this.a);
            return;
        }
        if (this.f1975m == null && this.f1974l.size() > 0) {
            this.f1975m = new k.x.y(this.w.m() != null ? this.w.m().c() : -1, this.w.o(), this.w.o(), this.f);
        }
        Iterator it = this.f1974l.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            k.d dVarC = oVar.c();
            if (!dVarC.e().a()) {
                if (!dVarC.e().b()) {
                    this.f1975m.a(new k.x.a0(dVarC.e()));
                } else if (oVar.b() == dVarC.e().d() && oVar.getRow() == dVarC.e().e()) {
                    this.f1975m.a(new k.x.a0(dVarC.e()));
                }
            }
        }
        this.f1975m.f(this.a);
    }

    void a() {
        k.r[] rVarArrD = this.f1976n.d();
        ArrayList arrayList = new ArrayList();
        for (k.r rVar : rVarArrD) {
            k.c topLeft = rVar.getTopLeft();
            k.x.h1 h1Var = (k.x.h1) topLeft.e();
            if (h1Var != null && h1Var.J() && !h1Var.O()) {
                try {
                    p pVar = new p(h1Var);
                    k.c bottomRight = rVar.getBottomRight();
                    k.z.b bVar = k.z.b.b;
                    k.z.c cVar = k.z.c.d;
                    k.z.e eVar = k.z.e.d;
                    pVar.W(bVar, cVar, eVar);
                    k.z.b bVar2 = k.z.b.e;
                    pVar.W(bVar2, h1Var.B(bVar2), h1Var.A(bVar2));
                    k.z.b bVar3 = k.z.b.c;
                    pVar.W(bVar3, h1Var.B(bVar3), h1Var.A(bVar3));
                    if (topLeft.getRow() == bottomRight.getRow()) {
                        k.z.b bVar4 = k.z.b.d;
                        pVar.W(bVar4, h1Var.B(bVar4), h1Var.A(bVar4));
                    }
                    if (topLeft.b() == bottomRight.b()) {
                        k.z.b bVar5 = k.z.b.f;
                        pVar.W(bVar5, h1Var.B(bVar5), h1Var.A(bVar5));
                    }
                    int iIndexOf = arrayList.indexOf(pVar);
                    if (iIndexOf != -1) {
                        pVar = (p) arrayList.get(iIndexOf);
                    } else {
                        arrayList.add(pVar);
                    }
                    ((k.b0.k) topLeft).o(pVar);
                    if (bottomRight.getRow() > topLeft.getRow()) {
                        if (bottomRight.b() != topLeft.b()) {
                            p pVar2 = new p(h1Var);
                            pVar2.W(bVar, cVar, eVar);
                            pVar2.W(bVar2, h1Var.B(bVar2), h1Var.A(bVar2));
                            k.z.b bVar6 = k.z.b.d;
                            pVar2.W(bVar6, h1Var.B(bVar6), h1Var.A(bVar6));
                            int iIndexOf2 = arrayList.indexOf(pVar2);
                            if (iIndexOf2 != -1) {
                                pVar2 = (p) arrayList.get(iIndexOf2);
                            } else {
                                arrayList.add(pVar2);
                            }
                            this.w.c(new k.b0.a(topLeft.b(), bottomRight.getRow(), pVar2));
                        }
                        for (int row = topLeft.getRow() + 1; row < bottomRight.getRow(); row++) {
                            p pVar3 = new p(h1Var);
                            pVar3.W(k.z.b.b, k.z.c.d, k.z.e.d);
                            k.z.b bVar7 = k.z.b.e;
                            pVar3.W(bVar7, h1Var.B(bVar7), h1Var.A(bVar7));
                            if (topLeft.b() == bottomRight.b()) {
                                k.z.b bVar8 = k.z.b.f;
                                pVar3.W(bVar8, h1Var.B(bVar8), h1Var.A(bVar8));
                            }
                            int iIndexOf3 = arrayList.indexOf(pVar3);
                            if (iIndexOf3 != -1) {
                                pVar3 = (p) arrayList.get(iIndexOf3);
                            } else {
                                arrayList.add(pVar3);
                            }
                            this.w.c(new k.b0.a(topLeft.b(), row, pVar3));
                        }
                    }
                    if (bottomRight.b() > topLeft.b()) {
                        if (bottomRight.getRow() != topLeft.getRow()) {
                            p pVar4 = new p(h1Var);
                            pVar4.W(k.z.b.b, k.z.c.d, k.z.e.d);
                            k.z.b bVar9 = k.z.b.f;
                            pVar4.W(bVar9, h1Var.B(bVar9), h1Var.A(bVar9));
                            k.z.b bVar10 = k.z.b.c;
                            pVar4.W(bVar10, h1Var.B(bVar10), h1Var.A(bVar10));
                            int iIndexOf4 = arrayList.indexOf(pVar4);
                            if (iIndexOf4 != -1) {
                                pVar4 = (p) arrayList.get(iIndexOf4);
                            } else {
                                arrayList.add(pVar4);
                            }
                            this.w.c(new k.b0.a(bottomRight.b(), topLeft.getRow(), pVar4));
                        }
                        for (int row2 = topLeft.getRow() + 1; row2 < bottomRight.getRow(); row2++) {
                            p pVar5 = new p(h1Var);
                            pVar5.W(k.z.b.b, k.z.c.d, k.z.e.d);
                            k.z.b bVar11 = k.z.b.f;
                            pVar5.W(bVar11, h1Var.B(bVar11), h1Var.A(bVar11));
                            int iIndexOf5 = arrayList.indexOf(pVar5);
                            if (iIndexOf5 != -1) {
                                pVar5 = (p) arrayList.get(iIndexOf5);
                            } else {
                                arrayList.add(pVar5);
                            }
                            this.w.c(new k.b0.a(bottomRight.b(), row2, pVar5));
                        }
                        for (int iB = topLeft.b() + 1; iB < bottomRight.b(); iB++) {
                            p pVar6 = new p(h1Var);
                            pVar6.W(k.z.b.b, k.z.c.d, k.z.e.d);
                            k.z.b bVar12 = k.z.b.c;
                            pVar6.W(bVar12, h1Var.B(bVar12), h1Var.A(bVar12));
                            if (topLeft.getRow() == bottomRight.getRow()) {
                                k.z.b bVar13 = k.z.b.d;
                                pVar6.W(bVar13, h1Var.B(bVar13), h1Var.A(bVar13));
                            }
                            int iIndexOf6 = arrayList.indexOf(pVar6);
                            if (iIndexOf6 != -1) {
                                pVar6 = (p) arrayList.get(iIndexOf6);
                            } else {
                                arrayList.add(pVar6);
                            }
                            this.w.c(new k.b0.a(iB, topLeft.getRow(), pVar6));
                        }
                    }
                    if (bottomRight.b() > topLeft.b() || bottomRight.getRow() > topLeft.getRow()) {
                        p pVar7 = new p(h1Var);
                        pVar7.W(k.z.b.b, k.z.c.d, k.z.e.d);
                        k.z.b bVar14 = k.z.b.f;
                        pVar7.W(bVar14, h1Var.B(bVar14), h1Var.A(bVar14));
                        k.z.b bVar15 = k.z.b.d;
                        pVar7.W(bVar15, h1Var.B(bVar15), h1Var.A(bVar15));
                        if (bottomRight.getRow() == topLeft.getRow()) {
                            k.z.b bVar16 = k.z.b.c;
                            pVar7.W(bVar16, h1Var.B(bVar16), h1Var.A(bVar16));
                        }
                        if (bottomRight.b() == topLeft.b()) {
                            k.z.b bVar17 = k.z.b.e;
                            pVar7.W(bVar17, h1Var.B(bVar17), h1Var.A(bVar17));
                        }
                        int iIndexOf7 = arrayList.indexOf(pVar7);
                        if (iIndexOf7 != -1) {
                            pVar7 = (p) arrayList.get(iIndexOf7);
                        } else {
                            arrayList.add(pVar7);
                        }
                        this.w.c(new k.b0.a(bottomRight.b(), bottomRight.getRow(), pVar7));
                        for (int iB2 = topLeft.b() + 1; iB2 < bottomRight.b(); iB2++) {
                            p pVar8 = new p(h1Var);
                            pVar8.W(k.z.b.b, k.z.c.d, k.z.e.d);
                            k.z.b bVar18 = k.z.b.d;
                            pVar8.W(bVar18, h1Var.B(bVar18), h1Var.A(bVar18));
                            if (topLeft.getRow() == bottomRight.getRow()) {
                                k.z.b bVar19 = k.z.b.c;
                                pVar8.W(bVar19, h1Var.B(bVar19), h1Var.A(bVar19));
                            }
                            int iIndexOf8 = arrayList.indexOf(pVar8);
                            if (iIndexOf8 != -1) {
                                pVar8 = (p) arrayList.get(iIndexOf8);
                            } else {
                                arrayList.add(pVar8);
                            }
                            this.w.c(new k.b0.a(iB2, bottomRight.getRow(), pVar8));
                        }
                    }
                } catch (k.b0.u e) {
                    x.f(e.toString());
                }
            }
        }
    }

    k.x.i1.e[] b() {
        return this.s.a();
    }

    void d(k.x.a aVar) {
        this.f1973k = aVar;
    }

    void e(k kVar) {
        this.p = kVar;
    }

    void f() {
        this.t = true;
    }

    void g(k.x.i1.e[] eVarArr) {
        this.s.b(eVarArr);
    }

    void h(ArrayList arrayList) {
        this.f1972j = arrayList;
    }

    void i(k.x.y yVar, ArrayList arrayList) {
        this.f1975m = yVar;
        this.f1974l = arrayList;
    }

    void j(int i2, int i3) {
        this.c = i2;
        this.d = i3;
    }

    void k(ArrayList arrayList, boolean z) {
        this.s.c(arrayList, z);
    }

    void l(s1 s1Var) {
        this.f1977o = s1Var;
    }

    void m(k.t tVar) {
        this.e = tVar;
    }

    void n(k.x.b1 b1Var) {
        if (b1Var != null) {
            this.q = b1Var;
        }
    }

    void o(k2[] k2VarArr, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, j1 j1Var, TreeSet treeSet, int i2, int i3) {
        this.b = k2VarArr;
        this.g = arrayList;
        this.f1970h = arrayList2;
        this.f1971i = arrayList3;
        this.f1976n = j1Var;
        this.r = treeSet;
        this.u = i2;
        this.v = i3;
    }

    public void p() throws IOException {
        int i2;
        k.y.a.a(this.b != null);
        if (this.t) {
            this.s.d(this.a);
            return;
        }
        this.a.e(new d(d.e));
        int i3 = this.c;
        int i4 = i3 / 32;
        if (i3 - (i4 * 32) != 0) {
            i4++;
        }
        int iC = this.a.c();
        y0 y0Var = new y0(0, this.c, i4);
        this.a.e(y0Var);
        if (this.e.a()) {
            this.a.e(new n(n.e));
        } else {
            this.a.e(new n(n.d));
        }
        this.a.e(new l(100));
        this.a.e(new h2());
        this.a.e(new b1(false));
        this.a.e(new c0(0.001d));
        this.a.e(new p2(this.e.G()));
        this.a.e(new x1(this.e.D()));
        this.a.e(new w1(this.e.C()));
        this.a.e(new p0(true));
        q0 q0Var = new q0();
        q0Var.A(this.v + 1);
        q0Var.B(this.u + 1);
        this.a.e(q0Var);
        this.a.e(new b0(this.e.f(), this.e.f() != 255));
        if (this.u > 0) {
            this.q.D(true);
        }
        if (this.v > 0) {
            this.q.B(true);
        }
        this.q.C(this.e.j());
        this.a.e(this.q);
        if (this.g.size() > 0) {
            int size = this.g.size();
            int[] iArr = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = ((Integer) this.g.get(i5)).intValue();
            }
            this.a.e(new u0(iArr));
        }
        if (this.f1970h.size() > 0) {
            int size2 = this.f1970h.size();
            int[] iArr2 = new int[size2];
            for (int i6 = 0; i6 < size2; i6++) {
                iArr2[i6] = ((Integer) this.f1970h.get(i6)).intValue();
            }
            this.a.e(new h3(iArr2));
        }
        this.a.e(new r0(this.e.n().toString()));
        this.a.e(new n0(this.e.l().toString()));
        this.a.e(new t0(this.e.P()));
        this.a.e(new g3(this.e.S()));
        if (this.e.r() != this.e.g()) {
            this.a.e(new f1(this.e.r()));
        }
        if (this.e.H() != this.e.g()) {
            this.a.e(new j2(this.e.H()));
        }
        if (this.e.K() != this.e.e()) {
            this.a.e(new e3(this.e.K()));
        }
        if (this.e.b() != this.e.e()) {
            this.a.e(new i(this.e.b()));
        }
        s1 s1Var = this.f1977o;
        if (s1Var != null) {
            this.a.e(s1Var);
        }
        this.a.e(new t2(this.e));
        if (this.e.Q()) {
            this.a.e(new a2(this.e.Q()));
            this.a.e(new q2(this.e.Q()));
            this.a.e(new r1(this.e.Q()));
            if (this.e.z() != null) {
                this.a.e(new u1(this.e.z()));
            } else if (this.e.A() != 0) {
                this.a.e(new u1(this.e.A()));
            }
        }
        y0Var.B(this.a.c());
        this.a.e(new a0(this.e.d()));
        k.b0.m mVarG = this.w.o().t().g();
        k.b0.m mVarB = this.w.o().t().b();
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.b() < 256) {
                this.a.e(rVar);
            }
            k.x.h1 h1VarA = rVar.A();
            if (h1VarA != mVarG && rVar.b() < 256) {
                k.c[] cVarArrC = c(rVar.b());
                for (int i7 = 0; i7 < cVarArrC.length; i7++) {
                    if (cVarArrC[i7] != null && (cVarArrC[i7].e() == mVarG || cVarArrC[i7].e() == mVarB)) {
                        ((k.b0.k) cVarArrC[i7]).o(h1VarA);
                    }
                }
            }
        }
        k.x.a aVar = this.f1973k;
        if (aVar != null) {
            aVar.b(this.a);
        }
        this.a.e(new d0(this.c, this.d));
        for (int i8 = 0; i8 < i4; i8++) {
            w wVar = new w(this.a.c());
            int i9 = i8 * 32;
            int iMin = Math.min(32, this.c - i9);
            boolean z = true;
            int i10 = i9;
            while (true) {
                i2 = i9 + iMin;
                if (i10 >= i2) {
                    break;
                }
                k2[] k2VarArr = this.b;
                if (k2VarArr[i10] != null) {
                    k2VarArr[i10].F(this.a);
                    if (z) {
                        wVar.B(this.a.c());
                        z = false;
                    }
                }
                i10++;
            }
            while (i9 < i2) {
                if (this.b[i9] != null) {
                    wVar.A(this.a.c());
                    this.b[i9].G(this.a);
                }
                i9++;
            }
            y0Var.A(this.a.c());
            wVar.C(this.a.c());
            this.a.e(wVar);
        }
        if (!this.f.d()) {
            this.s.d(this.a);
        }
        this.a.e(new k3(this.e));
        if (this.e.p() == 0 && this.e.L() == 0) {
            this.a.e(new s2(s2.f1945i, 0, 0));
        } else {
            this.a.e(new t1(this.e.p(), this.e.L()));
            this.a.e(new s2(s2.f1945i, 0, 0));
            if (this.e.p() != 0) {
                this.a.e(new s2(s2.g, this.e.p(), 0));
            }
            if (this.e.L() != 0) {
                this.a.e(new s2(s2.f1944h, 0, this.e.L()));
            }
            if (this.e.p() != 0 && this.e.L() != 0) {
                this.a.e(new s2(s2.f, this.e.p(), this.e.L()));
            }
            this.a.e(new i3());
        }
        if (this.e.N() != 100) {
            this.a.e(new m2(this.e.N()));
        }
        this.f1976n.e(this.a);
        Iterator it2 = this.f1971i.iterator();
        while (it2.hasNext()) {
            this.a.e((k.b0.q) it2.next());
        }
        k kVar = this.p;
        if (kVar != null) {
            this.a.e(kVar);
        }
        if (this.f1975m != null || this.f1974l.size() > 0) {
            q();
        }
        ArrayList arrayList = this.f1972j;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it3 = this.f1972j.iterator();
            while (it3.hasNext()) {
                ((k.x.n) it3.next()).b(this.a);
            }
        }
        this.a.e(new e0());
        this.a.d(y0Var.y(), iC + 4);
    }
}
