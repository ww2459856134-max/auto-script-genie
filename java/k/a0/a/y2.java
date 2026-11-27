package k.a0.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class y2 implements k.s {
    private int A;
    private int B;
    private ArrayList C;
    private ArrayList D;
    private k.x.a E;
    private n3 F;
    private k.w G;
    private j0 a;
    private n2 b;
    private a c;
    private a d;
    private k.x.n0 e;
    private String f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1872h;

    /* renamed from: i, reason: collision with root package name */
    private k.c[][] f1873i;

    /* renamed from: j, reason: collision with root package name */
    private int f1874j;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList f1879o;
    private ArrayList p;
    private k.x.y q;
    private k.r[] r;
    private boolean s;
    private k.x.b1 t;
    private boolean u;
    private t1 v;
    private l w;
    private k.t x;
    private int[] y;
    private int[] z;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f1876l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private ArrayList f1877m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    private ArrayList f1878n = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f1875k = new ArrayList(10);

    static {
        k.y.c.b(y2.class);
    }

    y2(j0 j0Var, n2 n2Var, k.x.n0 n0Var, a aVar, a aVar2, boolean z, n3 n3Var) throws d {
        this.a = j0Var;
        this.b = n2Var;
        this.e = n0Var;
        this.c = aVar;
        this.d = aVar2;
        this.s = z;
        this.F = n3Var;
        this.G = n3Var.A();
        this.f1874j = j0Var.c();
        if (this.c.B()) {
            this.f1874j -= this.c.y() + 4;
        }
        int i2 = 1;
        while (i2 >= 1) {
            f2 f2VarE = j0Var.e();
            i2 = f2VarE.b() == k.x.z0.d.a ? i2 - 1 : i2;
            if (f2VarE.b() == k.x.z0.c.a) {
                i2++;
            }
        }
    }

    final void A() {
        if (!this.c.D()) {
            this.g = 0;
            this.f1872h = 0;
            this.f1873i = (k.c[][]) Array.newInstance((Class<?>) k.c.class, 0, 0);
        }
        z2 z2Var = new z2(this.a, this.b, this.e, this.c, this.d, this.s, this.F, this.f1874j, this);
        z2Var.A();
        this.g = z2Var.s();
        this.f1872h = z2Var.r();
        this.f1873i = z2Var.g();
        this.f1875k = z2Var.v();
        this.f1876l = z2Var.j();
        this.f1878n = z2Var.n();
        this.D = z2Var.k();
        this.E = z2Var.e();
        this.f1879o = z2Var.h();
        this.p = z2Var.m();
        this.q = z2Var.l();
        this.r = z2Var.q();
        k.t tVarW = z2Var.w();
        this.x = tVarW;
        tVarW.g0(this.u);
        this.y = z2Var.u();
        this.z = z2Var.i();
        this.t = z2Var.x();
        this.v = z2Var.t();
        this.w = z2Var.f();
        this.A = z2Var.p();
        this.B = z2Var.o();
        if (!this.G.j()) {
            System.gc();
        }
        if (this.f1876l.size() > 0) {
            r[] rVarArr = new r[((r) this.f1876l.get(r0.size() - 1)).z() + 1];
        }
        ArrayList arrayList = this.C;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                o1 o1Var = (o1) it.next();
                if (o1Var.y() == k.x.i.d) {
                    if (o1Var.B().length > 0) {
                        n1 n1Var = o1Var.B()[0];
                        this.x.r0(n1Var.b(), n1Var.c(), n1Var.d(), n1Var.e());
                    }
                } else if (o1Var.y() == k.x.i.e) {
                    for (int i2 = 0; i2 < o1Var.B().length; i2++) {
                        n1 n1Var2 = o1Var.B()[i2];
                        if (n1Var2.b() == 0 && n1Var2.d() == 255) {
                            this.x.v0(n1Var2.c(), n1Var2.e());
                        } else {
                            this.x.u0(n1Var2.b(), n1Var2.d());
                        }
                    }
                }
            }
        }
    }

    final void B(boolean z) {
        this.u = z;
    }

    final void C(String str) {
        this.f = str;
    }

    @Override // k.s
    public k.c a(int i2, int i3) {
        if (this.f1873i == null) {
            A();
        }
        k.c[][] cVarArr = this.f1873i;
        k.c cVar = cVarArr[i3][i2];
        if (cVar != null) {
            return cVar;
        }
        k.x.d0 d0Var = new k.x.d0(i2, i3);
        cVarArr[i3][i2] = d0Var;
        return d0Var;
    }

    @Override // k.s
    public int b() {
        if (this.f1873i == null) {
            A();
        }
        return this.g;
    }

    @Override // k.s
    public int d() {
        if (this.f1873i == null) {
            A();
        }
        return this.f1872h;
    }

    void e(o1 o1Var) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(o1Var);
    }

    final void f() {
        this.f1873i = null;
        this.r = null;
        this.f1876l.clear();
        this.f1877m.clear();
        this.f1878n.clear();
        if (this.G.j()) {
            return;
        }
        System.gc();
    }

    public k.x.a g() {
        return this.E;
    }

    @Override // k.s
    public String getName() {
        return this.f;
    }

    @Override // k.s
    public k.t getSettings() {
        return this.x;
    }

    public l h() {
        return this.w;
    }

    public final k.x.i1.e[] i() {
        int size = this.f1879o.size();
        k.x.i1.e[] eVarArr = new k.x.i1.e[size];
        for (int i2 = 0; i2 < size; i2++) {
            eVarArr[i2] = (k.x.i1.e) this.f1879o.get(i2);
        }
        return eVarArr;
    }

    public r[] j() {
        r[] rVarArr = new r[this.f1876l.size()];
        for (int i2 = 0; i2 < this.f1876l.size(); i2++) {
            rVarArr[i2] = (r) this.f1876l.get(i2);
        }
        return rVarArr;
    }

    public final int[] k() {
        return this.z;
    }

    public k.x.n[] l() {
        return (k.x.n[]) this.D.toArray(new k.x.n[this.D.size()]);
    }

    public k.x.y m() {
        return this.q;
    }

    public final k.x.i1.w[] n() {
        return (k.x.i1.w[]) this.p.toArray(new k.x.i1.w[this.p.size()]);
    }

    public k.m[] o() {
        k.m[] mVarArr = new k.m[this.f1878n.size()];
        for (int i2 = 0; i2 < this.f1878n.size(); i2++) {
            mVarArr[i2] = (k.m) this.f1878n.get(i2);
        }
        return mVarArr;
    }

    public int p() {
        return this.B;
    }

    public int q() {
        return this.A;
    }

    public k.r[] r() {
        k.r[] rVarArr = this.r;
        return rVarArr == null ? new k.r[0] : rVarArr;
    }

    public t1 s() {
        return this.v;
    }

    public k.c[] t(int i2) {
        if (this.f1873i == null) {
            A();
        }
        int i3 = this.f1872h - 1;
        boolean z = false;
        while (i3 >= 0 && !z) {
            if (this.f1873i[i2][i3] != null) {
                z = true;
            } else {
                i3--;
            }
        }
        k.c[] cVarArr = new k.c[i3 + 1];
        for (int i4 = 0; i4 <= i3; i4++) {
            cVarArr[i4] = a(i4, i2);
        }
        return cVarArr;
    }

    public final int[] u() {
        return this.y;
    }

    public i2[] v() {
        int size = this.f1875k.size();
        i2[] i2VarArr = new i2[size];
        for (int i2 = 0; i2 < size; i2++) {
            i2VarArr[i2] = (i2) this.f1875k.get(i2);
        }
        return i2VarArr;
    }

    public a w() {
        return this.c;
    }

    public n3 x() {
        return this.F;
    }

    public a y() {
        return this.d;
    }

    public k.x.b1 z() {
        return this.t;
    }
}
