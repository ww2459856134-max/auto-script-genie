package k.a0.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
final class z2 {
    private static k.y.c H = k.y.c.b(z2.class);
    private int[] A;
    private int B;
    private int C;
    private k.t D;
    private k.w E;
    private n3 F;
    private y2 G;
    private j0 a;
    private n2 b;
    private a c;
    private a d;
    private k.x.n0 e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private k.c[][] f1880h;

    /* renamed from: j, reason: collision with root package name */
    private int f1882j;
    private k.x.a p;
    private k.r[] q;
    private k.x.y r;
    private k.x.i1.t u;
    private boolean v;
    private t1 w;
    private l x;
    private k.x.b1 y;
    private int[] z;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f1884l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private ArrayList f1885m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    private ArrayList f1886n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    private ArrayList f1887o = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f1883k = new ArrayList(10);
    private ArrayList s = new ArrayList();
    private ArrayList t = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f1881i = new ArrayList();

    z2(j0 j0Var, n2 n2Var, k.x.n0 n0Var, a aVar, a aVar2, boolean z, n3 n3Var, int i2, y2 y2Var) {
        this.a = j0Var;
        this.b = n2Var;
        this.e = n0Var;
        this.c = aVar;
        this.d = aVar2;
        this.v = z;
        this.F = n3Var;
        this.f1882j = i2;
        this.G = y2Var;
        this.D = new k.t(y2Var);
        this.E = this.F.A();
    }

    private k.c B(b bVar) {
        int iC = this.a.c();
        this.a.i(bVar.B());
        f2 f2VarX = bVar.x();
        j0 j0Var = this.a;
        k.x.n0 n0Var = this.e;
        n3 n3Var = this.F;
        p0 p0Var = new p0(f2VarX, j0Var, n0Var, n3Var, n3Var, p0.f1830n, this.G, this.E);
        try {
            k.c cVarA = p0Var.A();
            if (p0Var.A().getType() == k.f.g) {
                q1 q1Var = (q1) p0Var.A();
                if (this.e.i(p0Var.z())) {
                    k.x.n0 n0Var2 = this.e;
                    n3 n3Var2 = this.F;
                    cVarA = new u(q1Var, n0Var2, n3Var2, n3Var2, this.v, this.G);
                }
            }
            this.a.i(iC);
            return cVarA;
        } catch (k.x.j1.w e) {
            H.f(k.e.a(p0Var.b(), p0Var.getRow()) + " " + e.getMessage());
            return null;
        }
    }

    private void a(k.c cVar) {
        if (cVar.getRow() >= this.f || cVar.b() >= this.g) {
            this.f1881i.add(cVar);
            return;
        }
        if (this.f1880h[cVar.getRow()][cVar.b()] != null) {
            StringBuffer stringBuffer = new StringBuffer();
            k.e.c(cVar.b(), cVar.getRow(), stringBuffer);
            H.f("Cell " + stringBuffer.toString() + " already contains data");
        }
        this.f1880h[cVar.getRow()][cVar.b()] = cVar;
    }

    private void b(int i2, int i3, String str, double d, double d2) {
        k.c cVar = this.f1880h[i3][i2];
        if (cVar == null) {
            H.f("Cell at " + k.e.a(i2, i3) + " not present - adding a blank");
            i1 i1Var = new i1(i3, i2, 0, this.e, this.G);
            k.d dVar = new k.d();
            dVar.l(str, d, d2);
            i1Var.h(dVar);
            a(i1Var);
            return;
        }
        if (cVar instanceof n) {
            n nVar = (n) cVar;
            k.d dVarC = nVar.c();
            if (dVarC == null) {
                dVarC = new k.d();
                nVar.h(dVarC);
            }
            dVarC.l(str, d, d2);
            return;
        }
        H.f("Not able to add comment to cell type " + cVar.getClass().getName() + " at " + k.e.a(i2, i3));
    }

    private void c(int i2, int i3, int i4, int i5, k.x.a0 a0Var) {
        while (i3 <= i5) {
            for (int i6 = i2; i6 <= i4; i6++) {
                k.c cVar = null;
                k.c[][] cVarArr = this.f1880h;
                if (cVarArr.length > i3 && cVarArr[i3].length > i6) {
                    cVar = cVarArr[i3][i6];
                }
                if (cVar == null) {
                    i1 i1Var = new i1(i3, i6, 0, this.e, this.G);
                    k.d dVar = new k.d();
                    dVar.m(a0Var);
                    i1Var.h(dVar);
                    a(i1Var);
                } else if (cVar instanceof n) {
                    n nVar = (n) cVar;
                    k.d dVarC = nVar.c();
                    if (dVarC == null) {
                        dVarC = new k.d();
                        nVar.h(dVarC);
                    }
                    dVarC.m(a0Var);
                } else {
                    H.f("Not able to add comment to cell type " + cVar.getClass().getName() + " at " + k.e.a(i6, i3));
                }
            }
            i3++;
        }
    }

    private boolean d(b bVar) {
        int size = this.f1885m.size();
        boolean zA = false;
        for (int i2 = 0; i2 < size && !zA; i2++) {
            zA = ((t2) this.f1885m.get(i2)).a(bVar);
        }
        return zA;
    }

    private void y(k.x.i1.h0 h0Var, k.x.i1.e0 e0Var, HashMap map) {
        if (e0Var == null) {
            H.f("Object record is not associated with a drawing  record - ignoring");
            return;
        }
        try {
            if (h0Var.E() == k.x.i1.h0.f2068j) {
                if (this.u == null) {
                    this.u = new k.x.i1.t();
                }
                this.t.add(new k.x.i1.s(e0Var, h0Var, this.u, this.F.v(), this.G));
                return;
            }
            if (h0Var.E() == k.x.i1.h0.f2071m) {
                if (this.u == null) {
                    this.u = new k.x.i1.t();
                }
                k.x.i1.k kVar = new k.x.i1.k(e0Var, h0Var, this.u, this.F.v(), this.E);
                f2 f2VarE = this.a.e();
                if (f2VarE.e() == k.x.z0.P0 || f2VarE.e() == k.x.z0.v) {
                    kVar.k(new k.x.i1.e0(f2VarE));
                    f2VarE = this.a.e();
                }
                k.y.a.a(f2VarE.e() == k.x.z0.f2177m);
                kVar.w(new k.x.i1.s0(f2VarE));
                f2 f2VarE2 = this.a.e();
                k.x.z0 z0VarE = f2VarE2.e();
                k.x.z0 z0Var = k.x.z0.v;
                k.y.a.a(z0VarE == z0Var);
                kVar.v(new k.x.r(f2VarE2));
                f2 f2VarE3 = this.a.e();
                if (f2VarE3.e() == z0Var) {
                    kVar.s(new k.x.r(f2VarE3));
                }
                map.put(new Integer(kVar.c()), kVar);
                return;
            }
            if (h0Var.E() == k.x.i1.h0.f2070l) {
                if (this.u == null) {
                    this.u = new k.x.i1.t();
                }
                this.t.add(new k.x.i1.j(e0Var, h0Var, this.u, this.F.v(), this.E));
                return;
            }
            if (h0Var.E() == k.x.i1.h0.f2069k) {
                if (this.u == null) {
                    this.u = new k.x.i1.t();
                }
                k.x.i1.f fVar = new k.x.i1.f(e0Var, h0Var, this.u, this.F.v(), this.E);
                f2 f2VarE4 = this.a.e();
                k.x.z0 z0VarE2 = f2VarE4.e();
                k.x.z0 z0Var2 = k.x.z0.P0;
                k.y.a.a(z0VarE2 == z0Var2 || f2VarE4.e() == k.x.z0.v);
                if (f2VarE4.e() == z0Var2 || f2VarE4.e() == k.x.z0.v) {
                    fVar.k(new k.x.i1.e0(f2VarE4));
                    f2VarE4 = this.a.e();
                }
                k.y.a.a(f2VarE4.e() == k.x.z0.f2177m);
                k.x.i1.s0 s0Var = new k.x.i1.s0(f2VarE4);
                fVar.p(s0Var);
                if (s0Var.A() == 0) {
                    return;
                }
                f2 f2VarE5 = this.a.e();
                k.x.z0 z0VarE3 = f2VarE5.e();
                k.x.z0 z0Var3 = k.x.z0.v;
                k.y.a.a(z0VarE3 == z0Var3);
                fVar.o(new k.x.r(f2VarE5));
                f2 f2VarE6 = this.a.e();
                if (f2VarE6.e() == z0Var3) {
                    fVar.n(new k.x.r(f2VarE6));
                }
                this.t.add(fVar);
                return;
            }
            if (h0Var.E() == k.x.i1.h0.f2067i) {
                if (this.u == null) {
                    this.u = new k.x.i1.t();
                }
                k.x.i1.d dVar = new k.x.i1.d(e0Var, h0Var, this.u, this.F.v(), this.E);
                f2 f2VarE7 = this.a.e();
                k.x.z0 z0VarE4 = f2VarE7.e();
                k.x.z0 z0Var4 = k.x.z0.P0;
                k.y.a.a(z0VarE4 == z0Var4 || f2VarE7.e() == k.x.z0.v);
                if (f2VarE7.e() == z0Var4 || f2VarE7.e() == k.x.z0.v) {
                    dVar.k(new k.x.i1.e0(f2VarE7));
                    f2VarE7 = this.a.e();
                }
                k.y.a.a(f2VarE7.e() == k.x.z0.f2177m);
                dVar.q(new k.x.i1.s0(f2VarE7));
                f2 f2VarE8 = this.a.e();
                k.x.z0 z0VarE5 = f2VarE8.e();
                k.x.z0 z0Var5 = k.x.z0.v;
                k.y.a.a(z0VarE5 == z0Var5);
                dVar.p(new k.x.r(f2VarE8));
                f2 f2VarE9 = this.a.e();
                if (f2VarE9.e() == z0Var5) {
                    dVar.o(new k.x.r(f2VarE9));
                }
                this.t.add(dVar);
                return;
            }
            if (h0Var.E() != k.x.i1.h0.f2066h) {
                if (h0Var.E() != k.x.i1.h0.g) {
                    H.f(h0Var.E() + " Object on sheet \"" + this.G.getName() + "\" not supported - omitting");
                    if (this.u == null) {
                        this.u = new k.x.i1.t();
                    }
                    this.u.a(e0Var.y());
                    if (this.F.v() != null) {
                        this.F.v().k(e0Var, h0Var);
                        return;
                    }
                    return;
                }
                return;
            }
            H.f(h0Var.E() + " Object on sheet \"" + this.G.getName() + "\" not supported - omitting");
            if (this.u == null) {
                this.u = new k.x.i1.t();
            }
            this.u.a(e0Var.y());
            f2 f2VarE10 = this.a.e();
            k.x.z0 z0VarE6 = f2VarE10.e();
            k.x.z0 z0Var6 = k.x.z0.P0;
            k.y.a.a(z0VarE6 == z0Var6 || f2VarE10.e() == k.x.z0.v);
            if (f2VarE10.e() == z0Var6 || f2VarE10.e() == k.x.z0.v) {
                this.u.b(new k.x.i1.e0(f2VarE10).y());
                f2VarE10 = this.a.e();
            }
            k.y.a.a(f2VarE10.e() == k.x.z0.f2177m);
            if (this.F.v() != null) {
                this.F.v().k(e0Var, h0Var);
            }
        } catch (k.x.i1.u e) {
            H.f(e.getMessage() + "...disabling drawings for the remainder of the workbook");
            this.E.z(true);
        }
    }

    private void z() {
        int iMax = this.f;
        int iMax2 = this.g;
        Iterator it = this.f1881i.iterator();
        while (it.hasNext()) {
            k.c cVar = (k.c) it.next();
            iMax = Math.max(iMax, cVar.getRow() + 1);
            iMax2 = Math.max(iMax2, cVar.b() + 1);
        }
        if (iMax2 > this.g) {
            for (int i2 = 0; i2 < this.f; i2++) {
                k.c[] cVarArr = new k.c[iMax2];
                k.c[] cVarArr2 = this.f1880h[i2];
                System.arraycopy(cVarArr2, 0, cVarArr, 0, cVarArr2.length);
                this.f1880h[i2] = cVarArr;
            }
        }
        if (iMax > this.f) {
            k.c[][] cVarArr3 = new k.c[iMax][];
            k.c[][] cVarArr4 = this.f1880h;
            System.arraycopy(cVarArr4, 0, cVarArr3, 0, cVarArr4.length);
            this.f1880h = cVarArr3;
            for (int i3 = this.f; i3 < iMax; i3++) {
                cVarArr3[i3] = new k.c[iMax2];
            }
        }
        this.f = iMax;
        this.g = iMax2;
        Iterator it2 = this.f1881i.iterator();
        while (it2.hasNext()) {
            a((k.c) it2.next());
        }
        this.f1881i.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0358  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void A() {
        k.x.i1.h0 h0Var;
        b bVar;
        k.x.i1.e0 e0Var;
        HashMap map;
        ArrayList arrayList;
        boolean z;
        k.x.b bVar2;
        k.x.f0 f0Var;
        k.x.n nVar;
        HashMap map2;
        ArrayList arrayList2;
        b bVar3;
        int i2;
        int iZ;
        k1 k1Var;
        k.x.b bVar4;
        this.a.i(this.f1882j);
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        char c = 1;
        int i3 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean zD = false;
        k.x.b bVar5 = null;
        k.x.f0 f0Var2 = null;
        k.x.i1.h0 h0Var2 = null;
        k.x.n nVar2 = null;
        b bVar6 = null;
        k.x.i1.e0 e0Var2 = null;
        l3 l3Var = null;
        k.x.r rVar = null;
        while (z2) {
            f2 f2VarE = this.a.e();
            k.x.z0 z0VarE = f2VarE.e();
            if (z0VarE == k.x.z0.l1 && f2VarE.b() == 0) {
                H.f("Biff code zero found");
                if (f2VarE.d() == 10) {
                    H.f("Biff code zero found - trying a dimension record.");
                    f2VarE.f(k.x.z0.f2172h);
                } else {
                    H.f("Biff code zero found - Ignoring.");
                }
            }
            if (z0VarE == k.x.z0.f2172h) {
                a0 a0Var = this.d.A() ? new a0(f2VarE) : new a0(f2VarE, a0.e);
                this.f = a0Var.z();
                int iY = a0Var.y();
                this.g = iY;
                int i4 = this.f;
                int[] iArr = new int[2];
                iArr[c] = iY;
                iArr[i3] = i4;
                this.f1880h = (k.c[][]) Array.newInstance((Class<?>) k.c.class, iArr);
            } else if (z0VarE == k.x.z0.y) {
                a(new e1(f2VarE, this.b, this.e, this.G));
            } else {
                if (z0VarE == k.x.z0.f2178n || z0VarE == k.x.z0.f2179o) {
                    h0Var = h0Var2;
                    bVar = bVar6;
                    e0Var = e0Var2;
                    map = map3;
                    arrayList = arrayList3;
                    z = z2;
                    bVar2 = bVar5;
                    f0Var = f0Var2;
                    nVar = nVar2;
                    b2 b2Var = new b2(f2VarE, this.e, this.G);
                    if (this.e.i(b2Var.z())) {
                        a(new v(b2Var, b2Var.z(), this.e, this.v, this.G));
                    } else {
                        a(b2Var);
                    }
                } else if (z0VarE == k.x.z0.N0) {
                    this.f1886n.add(new a1(f2VarE, this.G, this.E));
                } else if (z0VarE == k.x.z0.G0) {
                    h1 h1Var = new h1(f2VarE, this.G);
                    k.r[] rVarArr = this.q;
                    if (rVarArr == null) {
                        this.q = h1Var.y();
                    } else {
                        k.r[] rVarArr2 = new k.r[rVarArr.length + h1Var.y().length];
                        k.r[] rVarArr3 = this.q;
                        System.arraycopy(rVarArr3, i3, rVarArr2, i3, rVarArr3.length);
                        System.arraycopy(h1Var.y(), i3, rVarArr2, this.q.length, h1Var.y().length);
                        this.q = rVarArr2;
                    }
                } else if (z0VarE == k.x.z0.p) {
                    k1 k1Var2 = new k1(f2VarE);
                    int iZ2 = k1Var2.z();
                    int i5 = i3;
                    while (i5 < iZ2) {
                        int iB = k1Var2.B(i5);
                        int row = k1Var2.getRow();
                        int iY2 = k1Var2.y() + i5;
                        double dA = a2.a(k1Var2.A(i5));
                        k.x.n0 n0Var = this.e;
                        int i6 = iZ2;
                        s1 s1Var = new s1(row, iY2, dA, iB, n0Var, this.G);
                        if (n0Var.i(iB)) {
                            k1Var = k1Var2;
                            bVar4 = bVar5;
                            a(new v(s1Var, iB, this.e, this.v, this.G));
                        } else {
                            k1Var = k1Var2;
                            bVar4 = bVar5;
                            s1Var.a(this.e.f(iB));
                            a(s1Var);
                        }
                        i5++;
                        k1Var2 = k1Var;
                        bVar5 = bVar4;
                        iZ2 = i6;
                    }
                } else {
                    k.x.b bVar7 = bVar5;
                    if (z0VarE == k.x.z0.z) {
                        r1 r1Var = new r1(f2VarE, this.e, this.G);
                        if (this.e.i(r1Var.z())) {
                            a(new v(r1Var, r1Var.z(), this.e, this.v, this.G));
                        } else {
                            a(r1Var);
                        }
                    } else if (z0VarE == k.x.z0.J) {
                        g gVar = new g(f2VarE, this.e, this.G);
                        if (gVar.A()) {
                            a(new c0(gVar.x(), this.e, this.G));
                        } else {
                            a(gVar);
                        }
                    } else if (z0VarE == k.x.z0.j0) {
                        this.D.s0(new x1(f2VarE).y());
                    } else if (z0VarE == k.x.z0.c0) {
                        this.D.t0(new y1(f2VarE).y());
                    } else {
                        if (z0VarE == k.x.z0.s0) {
                            l3Var = this.d.A() ? new l3(f2VarE) : new l3(f2VarE, l3.g);
                            this.D.B0(l3Var.A());
                            this.D.Y(l3Var.y());
                            this.D.A0(true);
                            this.D.m0(l3Var.B());
                        } else if (z0VarE == k.x.z0.Z0) {
                            u1 u1Var = new u1(f2VarE);
                            if (l3Var != null && l3Var.z()) {
                                this.D.E0(u1Var.z());
                                this.D.i0(u1Var.y());
                            }
                        } else if (z0VarE == k.x.z0.v) {
                            rVar = new k.x.r(f2VarE);
                        } else {
                            if (z0VarE == k.x.z0.f2176l) {
                                if (this.E.d()) {
                                    h0Var = h0Var2;
                                    bVar = bVar6;
                                    e0Var = e0Var2;
                                    map2 = map3;
                                    arrayList2 = arrayList3;
                                    z = z2;
                                    bVar2 = bVar7;
                                    f0Var = f0Var2;
                                    nVar = nVar2;
                                } else {
                                    k.x.i1.f0 f0Var3 = new k.x.i1.f0(f2VarE);
                                    k.x.i1.k kVar = (k.x.i1.k) map3.remove(new Integer(f0Var3.A()));
                                    if (kVar == null) {
                                        H.f(" cannot find comment for note id " + f0Var3.A() + "...ignoring");
                                        h0Var = h0Var2;
                                        bVar = bVar6;
                                        e0Var = e0Var2;
                                        map2 = map3;
                                        arrayList2 = arrayList3;
                                        z = z2;
                                        bVar2 = bVar7;
                                        f0Var = f0Var2;
                                        nVar = nVar2;
                                    } else {
                                        kVar.u(f0Var3);
                                        this.t.add(kVar);
                                        z = z2;
                                        bVar2 = bVar7;
                                        map2 = map3;
                                        f0Var = f0Var2;
                                        h0Var = h0Var2;
                                        arrayList2 = arrayList3;
                                        nVar = nVar2;
                                        bVar = bVar6;
                                        e0Var = e0Var2;
                                        b(kVar.l(), kVar.o(), kVar.p(), kVar.q(), kVar.m());
                                    }
                                }
                                map3 = map;
                                arrayList3 = arrayList;
                                bVar6 = bVar;
                                c = 1;
                                i3 = 0;
                            } else {
                                h0Var = h0Var2;
                                bVar = bVar6;
                                e0Var = e0Var2;
                                map2 = map3;
                                arrayList2 = arrayList3;
                                z = z2;
                                bVar2 = bVar7;
                                f0Var = f0Var2;
                                nVar = nVar2;
                                if (z0VarE != k.x.z0.C) {
                                    if (z0VarE == k.x.z0.Z) {
                                        this.D.w0(new z1(f2VarE).y());
                                    } else if (z0VarE == k.x.z0.G) {
                                        if (bVar == null) {
                                            H.f("Shared template formula is null - trying most recent formula template");
                                            ArrayList arrayList4 = this.f1885m;
                                            t2 t2Var = (t2) arrayList4.get(arrayList4.size() - 1);
                                            b bVarC = t2Var != null ? t2Var.c() : bVar;
                                            n3 n3Var = this.F;
                                            this.f1885m.add(new t2(f2VarE, bVarC, n3Var, n3Var, this.G));
                                            f0Var2 = f0Var;
                                            nVar2 = nVar;
                                            h0Var2 = h0Var;
                                            e0Var2 = e0Var;
                                            bVar5 = bVar2;
                                            z2 = z;
                                            map = map2;
                                            arrayList = arrayList2;
                                            bVar = null;
                                        }
                                    } else if (z0VarE == k.x.z0.E || z0VarE == k.x.z0.F) {
                                        map = map2;
                                        arrayList = arrayList2;
                                        j0 j0Var = this.a;
                                        k.x.n0 n0Var2 = this.e;
                                        n3 n3Var2 = this.F;
                                        p0 p0Var = new p0(f2VarE, j0Var, n0Var2, n3Var2, n3Var2, this.G, this.E);
                                        if (p0Var.B()) {
                                            bVar3 = (b) p0Var.A();
                                            zD = d(bVar3);
                                            if (zD) {
                                                bVar3 = bVar;
                                            }
                                            if (!zD && bVar != null) {
                                                a(B(bVar));
                                            }
                                        } else {
                                            k.c cVarA = p0Var.A();
                                            try {
                                                if (p0Var.A().getType() == k.f.g) {
                                                    q1 q1Var = (q1) p0Var.A();
                                                    if (this.e.i(q1Var.z())) {
                                                        k.x.n0 n0Var3 = this.e;
                                                        n3 n3Var3 = this.F;
                                                        cVarA = new u(q1Var, n0Var3, n3Var3, n3Var3, this.v, this.G);
                                                    }
                                                }
                                                a(cVarA);
                                            } catch (k.x.j1.w e) {
                                                H.f(k.e.a(cVarA.b(), cVarA.getRow()) + " " + e.getMessage());
                                            }
                                            bVar3 = bVar;
                                        }
                                        bVar = bVar3;
                                    } else if (z0VarE == k.x.z0.w) {
                                        a(this.d.A() ? new d1(f2VarE, this.e, this.G, this.E) : new d1(f2VarE, this.e, this.G, this.E, d1.f1793n));
                                    } else if (z0VarE == k.x.z0.x) {
                                        k.y.a.a(!this.d.A());
                                        a(new e2(f2VarE, this.e, this.G, this.E, e2.f1802n));
                                    } else if (z0VarE != k.x.z0.A) {
                                        if (z0VarE == k.x.z0.p0) {
                                            this.D.q0(new w1(f2VarE).y());
                                        } else if (z0VarE == k.x.z0.f2175k) {
                                            i2 i2Var = new i2(f2VarE);
                                            if (!i2Var.F() || !i2Var.G() || i2Var.E() || i2Var.D() || i2Var.z() != 0) {
                                                this.f1883k.add(i2Var);
                                            }
                                        } else if (z0VarE == k.x.z0.f2173i) {
                                            if (!this.E.l()) {
                                                a(new e(f2VarE, this.e, this.G));
                                            }
                                        } else if (z0VarE == k.x.z0.f2174j) {
                                            if (!this.E.l()) {
                                                j1 j1Var = new j1(f2VarE);
                                                int i7 = 0;
                                                for (int iZ3 = j1Var.z(); i7 < iZ3; iZ3 = iZ3) {
                                                    a(new i1(j1Var.getRow(), j1Var.y() + i7, j1Var.A(i7), this.e, this.G));
                                                    i7++;
                                                }
                                            }
                                        } else if (z0VarE == k.x.z0.Y0) {
                                            this.D.G0(new j2(f2VarE).y());
                                        } else if (z0VarE == k.x.z0.t) {
                                            this.f1884l.add(new r(f2VarE));
                                        } else if (z0VarE == k.x.z0.d0) {
                                            this.D.e0(new k.l((this.d.A() ? new t0(f2VarE, this.E) : new t0(f2VarE, this.E, t0.d)).y()));
                                        } else if (z0VarE == k.x.z0.e0) {
                                            this.D.c0(new k.l((this.d.A() ? new m0(f2VarE, this.E) : new m0(f2VarE, this.E, m0.d)).y()));
                                        } else if (z0VarE == k.x.z0.i0) {
                                            p2 p2Var = new p2(f2VarE);
                                            if (p2Var.E()) {
                                                if (p2Var.J()) {
                                                    this.D.l0(k.z.i.a);
                                                } else {
                                                    this.D.l0(k.z.i.b);
                                                }
                                                if (p2Var.K()) {
                                                    this.D.n0(k.z.h.b);
                                                } else {
                                                    this.D.n0(k.z.h.a);
                                                }
                                                this.D.p0(k.z.j.a(p2Var.G()));
                                                this.D.f0(p2Var.C());
                                                this.D.d0(p2Var.B());
                                                this.D.z0(p2Var.H());
                                                this.D.o0(p2Var.F());
                                                this.D.b0(p2Var.A());
                                                this.D.Z(p2Var.z());
                                                this.D.j0(p2Var.D());
                                                this.D.F0(p2Var.I());
                                                this.D.V(p2Var.y());
                                                k.x.b1 b1Var = this.y;
                                                if (b1Var != null) {
                                                    this.D.a0(b1Var.A());
                                                }
                                            }
                                        } else if (z0VarE == k.x.z0.R) {
                                            this.y = new k.x.b1(f2VarE);
                                        } else if (z0VarE == k.x.z0.O) {
                                            this.D.W(new w(f2VarE).y());
                                        } else if (z0VarE == k.x.z0.P) {
                                            x xVar = new x(f2VarE);
                                            if (xVar.y() != 0) {
                                                this.D.X(xVar.y());
                                            }
                                        } else {
                                            if (z0VarE == k.x.z0.b1) {
                                                nVar2 = new k.x.n(new k.x.p(f2VarE));
                                                this.f1887o.add(nVar2);
                                                f0Var2 = f0Var;
                                            } else if (z0VarE == k.x.z0.c1) {
                                                nVar.a(new k.x.q(f2VarE));
                                            } else if (z0VarE == k.x.z0.V) {
                                                f0Var2 = new k.x.f0(f2VarE);
                                                nVar2 = nVar;
                                            } else {
                                                if (z0VarE == k.x.z0.W) {
                                                    bVar5 = new k.x.b(f2VarE);
                                                    f0Var2 = f0Var;
                                                } else if (z0VarE == k.x.z0.X) {
                                                    if (!this.E.b()) {
                                                        k.x.c cVar = new k.x.c(f2VarE);
                                                        if (this.p == null) {
                                                            this.p = new k.x.a(f0Var, bVar2);
                                                            bVar5 = null;
                                                            f0Var2 = null;
                                                        } else {
                                                            f0Var2 = f0Var;
                                                            bVar5 = bVar2;
                                                        }
                                                        this.p.a(cVar);
                                                    }
                                                } else if (z0VarE == k.x.z0.R0) {
                                                    this.D.k0(new f1(f2VarE).y());
                                                } else if (z0VarE == k.x.z0.S0) {
                                                    this.D.y0(new h2(f2VarE).y());
                                                } else if (z0VarE == k.x.z0.T0) {
                                                    this.D.C0(new f3(f2VarE).y());
                                                } else if (z0VarE == k.x.z0.U0) {
                                                    this.D.U(new h(f2VarE).y());
                                                } else if (z0VarE == k.x.z0.L0) {
                                                    this.z = (this.d.A() ? new x0(f2VarE) : new x0(f2VarE, x0.d)).y();
                                                } else if (z0VarE == k.x.z0.K0) {
                                                    this.A = (this.d.A() ? new i3(f2VarE) : new i3(f2VarE, i3.d)).y();
                                                } else if (z0VarE == k.x.z0.X0) {
                                                    this.w = new t1(f2VarE);
                                                    while (this.a.f().e() == k.x.z0.v) {
                                                        f2VarE.a(this.a.e());
                                                    }
                                                } else if (z0VarE != k.x.z0.e1) {
                                                    arrayList = arrayList2;
                                                    if (z0VarE == k.x.z0.f0) {
                                                        this.D.h0(new p(f2VarE).y());
                                                    } else if (z0VarE == k.x.z0.g0) {
                                                        this.D.D0(new p(f2VarE).y());
                                                    } else if (z0VarE != k.x.z0.d1) {
                                                        if (z0VarE == k.x.z0.O0) {
                                                            h0Var2 = new k.x.i1.h0(f2VarE);
                                                            if (this.E.d()) {
                                                                map = map2;
                                                                e0Var2 = e0Var;
                                                            } else {
                                                                if (e0Var != null || rVar == null) {
                                                                    e0Var2 = e0Var;
                                                                    map = map2;
                                                                } else {
                                                                    H.f("Cannot find drawing record - using continue record");
                                                                    e0Var2 = new k.x.i1.e0(rVar.x());
                                                                    map = map2;
                                                                    rVar = null;
                                                                }
                                                                y(h0Var2, e0Var2, map);
                                                                arrayList.add(new Integer(h0Var2.C()));
                                                            }
                                                            if (h0Var2.E() != k.x.i1.h0.g) {
                                                                f0Var2 = f0Var;
                                                                nVar2 = nVar;
                                                                bVar5 = bVar2;
                                                                z2 = z;
                                                                h0Var2 = null;
                                                                e0Var2 = null;
                                                            }
                                                            f0Var2 = f0Var;
                                                            nVar2 = nVar;
                                                        } else {
                                                            map = map2;
                                                            if (z0VarE == k.x.z0.P0) {
                                                                if (!this.E.d()) {
                                                                    if (e0Var != null) {
                                                                        this.u.b(e0Var.y());
                                                                    }
                                                                    e0Var2 = new k.x.i1.e0(f2VarE);
                                                                    if (z3) {
                                                                        e0Var2.B();
                                                                        f0Var2 = f0Var;
                                                                        nVar2 = nVar;
                                                                        h0Var2 = h0Var;
                                                                        bVar5 = bVar2;
                                                                        z2 = z;
                                                                        z3 = false;
                                                                    } else {
                                                                        f0Var2 = f0Var;
                                                                        nVar2 = nVar;
                                                                        h0Var2 = h0Var;
                                                                    }
                                                                }
                                                            } else if (z0VarE == k.x.z0.f1) {
                                                                this.x = new l(f2VarE);
                                                            } else if (z0VarE == k.x.z0.A0) {
                                                                this.D.T(new m(f2VarE).y());
                                                            } else if (z0VarE == k.x.z0.L) {
                                                                this.D.x0(new o2(f2VarE).y());
                                                            } else if (z0VarE == k.x.z0.l0) {
                                                                q0 q0Var = new q0(f2VarE);
                                                                if (q0Var.z() > 0) {
                                                                    i2 = 1;
                                                                    iZ = q0Var.z() - 1;
                                                                } else {
                                                                    i2 = 1;
                                                                    iZ = 0;
                                                                }
                                                                this.B = iZ;
                                                                this.C = q0Var.y() > 0 ? q0Var.z() - i2 : 0;
                                                            } else if (z0VarE == k.x.z0.c) {
                                                                a aVar = new a(f2VarE);
                                                                k.y.a.a(!aVar.D());
                                                                int iC = (this.a.c() - f2VarE.d()) - 4;
                                                                f2 f2VarE2 = this.a.e();
                                                                while (f2VarE2.b() != k.x.z0.d.a) {
                                                                    f2VarE2 = this.a.e();
                                                                }
                                                                if (aVar.B()) {
                                                                    if (this.F.d().A()) {
                                                                        if (this.u == null) {
                                                                            this.u = new k.x.i1.t();
                                                                        }
                                                                        if (!this.E.d()) {
                                                                            k.x.i1.e eVar = new k.x.i1.e(e0Var, h0Var, this.u, iC, this.a.c(), this.a, this.E);
                                                                            this.s.add(eVar);
                                                                            if (this.F.v() != null) {
                                                                                this.F.v().a(eVar);
                                                                            }
                                                                        }
                                                                    } else {
                                                                        H.f("only biff8 charts are supported");
                                                                    }
                                                                    h0Var2 = null;
                                                                    e0Var2 = null;
                                                                } else {
                                                                    h0Var2 = h0Var;
                                                                    e0Var2 = e0Var;
                                                                }
                                                                if (this.c.B()) {
                                                                    z = false;
                                                                }
                                                                f0Var2 = f0Var;
                                                                nVar2 = nVar;
                                                            } else if (z0VarE == k.x.z0.d) {
                                                                f0Var2 = f0Var;
                                                                nVar2 = nVar;
                                                                h0Var2 = h0Var;
                                                                e0Var2 = e0Var;
                                                                bVar5 = bVar2;
                                                                z2 = false;
                                                            }
                                                        }
                                                        bVar5 = bVar2;
                                                        z2 = z;
                                                    } else if (!this.E.c()) {
                                                        n3 n3Var4 = this.F;
                                                        k.x.a0 a0Var2 = new k.x.a0(f2VarE, n3Var4, n3Var4, n3Var4.A());
                                                        k.x.y yVar = this.r;
                                                        if (yVar != null) {
                                                            yVar.a(a0Var2);
                                                            c(a0Var2.B(), a0Var2.C(), a0Var2.D(), a0Var2.E(), a0Var2);
                                                        } else {
                                                            H.f("cannot add data validity settings");
                                                        }
                                                    }
                                                    map = map2;
                                                } else if (this.E.c()) {
                                                    arrayList = arrayList2;
                                                    map = map2;
                                                } else {
                                                    k.x.z zVar = new k.x.z(f2VarE);
                                                    if (zVar.D() != -1) {
                                                        arrayList = arrayList2;
                                                        if (arrayList.contains(new Integer(zVar.D()))) {
                                                            this.r = new k.x.y(zVar);
                                                        } else {
                                                            H.f("object id " + zVar.D() + " referenced  by data validity list record not found - ignoring");
                                                        }
                                                    } else if (e0Var == null || h0Var != null) {
                                                        this.r = new k.x.y(zVar);
                                                        arrayList = arrayList2;
                                                    } else {
                                                        if (this.u == null) {
                                                            this.u = new k.x.i1.t();
                                                        }
                                                        this.t.add(new k.x.i1.r(e0Var, this.u, this.F.v()));
                                                        this.r = new k.x.y(zVar);
                                                        arrayList = arrayList2;
                                                        e0Var2 = null;
                                                        f0Var2 = f0Var;
                                                        nVar2 = nVar;
                                                        h0Var2 = h0Var;
                                                        bVar5 = bVar2;
                                                        z2 = z;
                                                        map = map2;
                                                    }
                                                    e0Var2 = e0Var;
                                                    f0Var2 = f0Var;
                                                    nVar2 = nVar;
                                                    h0Var2 = h0Var;
                                                    bVar5 = bVar2;
                                                    z2 = z;
                                                    map = map2;
                                                }
                                                nVar2 = nVar;
                                                h0Var2 = h0Var;
                                                e0Var2 = e0Var;
                                                z2 = z;
                                                map = map2;
                                                arrayList = arrayList2;
                                            }
                                            h0Var2 = h0Var;
                                            e0Var2 = e0Var;
                                            bVar5 = bVar2;
                                            z2 = z;
                                            map = map2;
                                            arrayList = arrayList2;
                                        }
                                    }
                                }
                                map3 = map;
                                arrayList3 = arrayList;
                                bVar6 = bVar;
                                c = 1;
                                i3 = 0;
                            }
                            map = map2;
                            arrayList = arrayList2;
                        }
                        bVar = bVar6;
                        map = map3;
                        arrayList = arrayList3;
                        bVar5 = bVar7;
                        map3 = map;
                        arrayList3 = arrayList;
                        bVar6 = bVar;
                        c = 1;
                        i3 = 0;
                    }
                    h0Var = h0Var2;
                    bVar = bVar6;
                    e0Var = e0Var2;
                    map = map3;
                    arrayList = arrayList3;
                    z = z2;
                    bVar2 = bVar7;
                    f0Var = f0Var2;
                    nVar = nVar2;
                }
                f0Var2 = f0Var;
                nVar2 = nVar;
                h0Var2 = h0Var;
                e0Var2 = e0Var;
                bVar5 = bVar2;
                z2 = z;
                map3 = map;
                arrayList3 = arrayList;
                bVar6 = bVar;
                c = 1;
                i3 = 0;
            }
            h0Var = h0Var2;
            bVar = bVar6;
            e0Var = e0Var2;
            map = map3;
            arrayList = arrayList3;
            z = z2;
            bVar2 = bVar5;
            f0Var = f0Var2;
            nVar = nVar2;
            f0Var2 = f0Var;
            nVar2 = nVar;
            h0Var2 = h0Var;
            e0Var2 = e0Var;
            bVar5 = bVar2;
            z2 = z;
            map3 = map;
            arrayList3 = arrayList;
            bVar6 = bVar;
            c = 1;
            i3 = 0;
        }
        k.x.i1.h0 h0Var3 = h0Var2;
        b bVar8 = bVar6;
        k.x.i1.e0 e0Var3 = e0Var2;
        HashMap map4 = map3;
        this.a.h();
        if (this.f1881i.size() > 0) {
            z();
        }
        Iterator it = this.f1885m.iterator();
        while (it.hasNext()) {
            for (k.c cVar2 : ((t2) it.next()).b(this.e, this.v)) {
                a(cVar2);
            }
        }
        if (!zD && bVar8 != null) {
            a(B(bVar8));
        }
        if (e0Var3 != null && this.F.v() != null) {
            this.F.v().k(e0Var3, h0Var3);
        }
        if (map4.isEmpty()) {
            return;
        }
        H.f("Not all comments have a corresponding Note record");
    }

    final k.x.a e() {
        return this.p;
    }

    final l f() {
        return this.x;
    }

    final k.c[][] g() {
        return this.f1880h;
    }

    final ArrayList h() {
        return this.s;
    }

    final int[] i() {
        return this.A;
    }

    final ArrayList j() {
        return this.f1884l;
    }

    final ArrayList k() {
        return this.f1887o;
    }

    final k.x.y l() {
        return this.r;
    }

    final ArrayList m() {
        return this.t;
    }

    final ArrayList n() {
        return this.f1886n;
    }

    public int o() {
        return this.C;
    }

    public int p() {
        return this.B;
    }

    final k.r[] q() {
        return this.q;
    }

    final int r() {
        return this.g;
    }

    final int s() {
        return this.f;
    }

    final t1 t() {
        return this.w;
    }

    final int[] u() {
        return this.z;
    }

    final ArrayList v() {
        return this.f1883k;
    }

    final k.t w() {
        return this.D;
    }

    final k.x.b1 x() {
        return this.y;
    }
}
