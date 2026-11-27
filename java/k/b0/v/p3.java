package k.b0.v;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class p3 implements k.b0.s {
    private static k.y.c E = k.y.c.b(p3.class);
    private static final char[] F = {'*', NameUtil.COLON, '?', '\\'};
    private w2 B;
    private k.w C;
    private q3 D;
    private String a;
    private l0 b;
    private k.x.n0 d;
    private u2 e;

    /* renamed from: l, reason: collision with root package name */
    private s1 f1929l;

    /* renamed from: m, reason: collision with root package name */
    private k f1930m;

    /* renamed from: o, reason: collision with root package name */
    private k.x.y f1932o;
    private k.x.a u;
    private k.x.i1.j w;
    private int y;
    private int z;
    private k2[] c = new k2[0];

    /* renamed from: j, reason: collision with root package name */
    private int f1927j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f1928k = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1931n = false;
    private boolean x = false;
    private TreeSet f = new TreeSet(new o3());
    private TreeSet g = new TreeSet();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f1925h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private j1 f1926i = new j1(this);
    private ArrayList p = new ArrayList();
    private ArrayList q = new ArrayList();
    private ArrayList r = new ArrayList();
    private ArrayList s = new ArrayList();
    private ArrayList t = new ArrayList();
    private ArrayList v = new ArrayList();
    private k.t A = new k.t(this);

    public p3(String str, l0 l0Var, k.x.n0 n0Var, u2 u2Var, k.w wVar, q3 q3Var) {
        this.a = w(str);
        this.b = l0Var;
        this.D = q3Var;
        this.d = n0Var;
        this.e = u2Var;
        this.C = wVar;
        this.B = new w2(this.b, this, this.C);
    }

    private void g(int i2) {
        r rVarL = l(i2);
        k.z.f font = rVarL.A().getFont();
        k.z.f font2 = k.b0.t.c.getFont();
        int iMax = 0;
        for (int i3 = 0; i3 < this.f1927j; i3++) {
            k2[] k2VarArr = this.c;
            o oVarB = k2VarArr[i3] != null ? k2VarArr[i3].B(i2) : null;
            if (oVarB != null) {
                String strP = oVarB.p();
                k.z.f font3 = oVarB.e().getFont();
                if (font3.equals(font2)) {
                    font3 = font;
                }
                int iK = font3.k();
                int length = strP.length();
                if (font3.t() || font3.s() > 400) {
                    length += 2;
                }
                iMax = Math.max(iMax, length * iK * 256);
            }
        }
        rVarL.D(iMax / font2.k());
    }

    private void h() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            g(((Integer) it.next()).intValue());
        }
    }

    private String w(String str) {
        int i2 = 0;
        if (str.length() > 31) {
            E.f("Sheet name " + str + " too long - truncating");
            str = str.substring(0, 31);
        }
        if (str.charAt(0) == '\'') {
            E.f("Sheet naming cannot start with ' - removing");
            str = str.substring(1);
        }
        while (true) {
            char[] cArr = F;
            if (i2 >= cArr.length) {
                return str;
            }
            String strReplace = str.replace(cArr[i2], '@');
            if (str != strReplace) {
                E.f(cArr[i2] + " is not a valid character within a sheet name - replacing");
            }
            i2++;
            str = strReplace;
        }
    }

    @Override // k.s
    public k.c a(int i2, int i3) {
        return q(i2, i3);
    }

    @Override // k.s
    public int b() {
        return this.f1927j;
    }

    @Override // k.b0.s
    public void c(k.b0.k kVar) throws k.b0.u {
        if (kVar.getType() == k.f.b && kVar != null && kVar.e() == null) {
            return;
        }
        o oVar = (o) kVar;
        if (oVar.E()) {
            throw new d1(d1.d);
        }
        int row = kVar.getRow();
        k2 k2VarN = n(row);
        o oVarB = k2VarN.B(oVar.b());
        boolean z = (oVarB == null || oVarB.c() == null || oVarB.c().e() == null || !oVarB.c().e().b()) ? false : true;
        if (kVar.c() != null && kVar.c().f() && z) {
            k.x.w wVarE = oVarB.c().e();
            E.f("Cannot add cell at " + k.e.b(oVar) + " because it is part of the shared cell validation group " + k.e.a(wVarE.d(), wVarE.e()) + ProcessIdUtil.DEFAULT_PROCESSID + k.e.a(wVarE.f(), wVarE.g()));
            return;
        }
        if (z) {
            k.b0.l lVarU = kVar.u();
            if (lVarU == null) {
                lVarU = new k.b0.l();
                kVar.d(lVarU);
            }
            lVarU.o(oVarB.c());
        }
        k2VarN.A(oVar);
        this.f1927j = Math.max(row + 1, this.f1927j);
        this.f1928k = Math.max(this.f1928k, k2VarN.C());
        oVar.H(this.d, this.e, this);
    }

    @Override // k.s
    public int d() {
        return this.f1928k;
    }

    void e(k.x.i1.w wVar) {
        this.r.add(wVar);
        k.y.a.a(!(wVar instanceof k.x.i1.s));
    }

    void f(o oVar) {
        this.v.add(oVar);
    }

    @Override // k.s
    public String getName() {
        return this.a;
    }

    @Override // k.s
    public k.t getSettings() {
        return this.A;
    }

    void i() {
        this.B.o(this.c, this.p, this.q, this.f1925h, this.f1926i, this.f, this.y, this.z);
        this.B.j(b(), d());
        this.B.a();
    }

    void j(k.s sVar) {
        this.A = new k.t(sVar.getSettings(), this);
        v2 v2Var = new v2(sVar, this);
        v2Var.l(this.f);
        v2Var.o(this.d);
        v2Var.p(this.f1925h);
        v2Var.r(this.f1926i);
        v2Var.s(this.p);
        v2Var.k(this.q);
        v2Var.t(this.B);
        v2Var.n(this.r);
        v2Var.q(this.s);
        v2Var.m(this.t);
        v2Var.u(this.v);
        v2Var.a();
        this.f1932o = v2Var.e();
        this.w = v2Var.d();
        this.f1929l = v2Var.h();
        this.f1931n = v2Var.j();
        this.f1930m = v2Var.c();
        this.f1927j = v2Var.i();
        this.u = v2Var.b();
        this.y = v2Var.g();
        this.z = v2Var.f();
    }

    k.x.i1.e[] k() {
        return this.B.b();
    }

    r l(int i2) {
        Iterator it = this.f.iterator();
        boolean z = false;
        r rVar = null;
        while (it.hasNext() && !z) {
            rVar = (r) it.next();
            if (rVar.b() >= i2) {
                z = true;
            }
        }
        if (z && rVar.b() == i2) {
            return rVar;
        }
        return null;
    }

    k.x.i1.j m() {
        return this.w;
    }

    k2 n(int i2) throws l2 {
        if (i2 >= 65536) {
            throw new l2();
        }
        k2[] k2VarArr = this.c;
        if (i2 >= k2VarArr.length) {
            k2[] k2VarArr2 = new k2[Math.max(k2VarArr.length + 10, i2 + 1)];
            this.c = k2VarArr2;
            System.arraycopy(k2VarArr, 0, k2VarArr2, 0, k2VarArr.length);
        }
        k2 k2Var = this.c[i2];
        if (k2Var != null) {
            return k2Var;
        }
        k2 k2Var2 = new k2(i2, this);
        this.c[i2] = k2Var2;
        return k2Var2;
    }

    q3 o() {
        return this.D;
    }

    k.w p() {
        return this.C;
    }

    public k.b0.k q(int i2, int i3) {
        k2[] k2VarArr = this.c;
        o oVarB = (i3 >= k2VarArr.length || k2VarArr[i3] == null) ? null : k2VarArr[i3].B(i2);
        return oVarB == null ? new k.x.d0(i2, i3) : oVarB;
    }

    boolean r() {
        return this.f1931n;
    }

    void s(k.x.r0 r0Var, k.x.r0 r0Var2, k.x.r0 r0Var3) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((r) it.next()).B(r0Var);
        }
        int i2 = 0;
        while (true) {
            k2[] k2VarArr = this.c;
            if (i2 >= k2VarArr.length) {
                break;
            }
            if (k2VarArr[i2] != null) {
                k2VarArr[i2].D(r0Var);
            }
            i2++;
        }
        for (k.x.i1.e eVar : k()) {
            eVar.f(r0Var, r0Var2, r0Var3);
        }
    }

    void t(o oVar) {
        k.x.y yVar = this.f1932o;
        if (yVar != null) {
            yVar.e(oVar.b(), oVar.getRow());
        }
        ArrayList arrayList = this.v;
        if (arrayList == null || arrayList.remove(oVar)) {
            return;
        }
        E.f("Could not remove validated cell " + k.e.b(oVar));
    }

    void u(k.x.i1.w wVar) {
        int size = this.r.size();
        this.r.remove(wVar);
        int size2 = this.r.size();
        this.x = true;
        k.y.a.a(size2 == size - 1);
    }

    void v(k.x.i1.j jVar) {
        this.w = jVar;
    }

    public void x() throws IOException {
        boolean zI = this.x;
        if (this.D.o() != null) {
            zI |= this.D.o().i();
        }
        if (this.g.size() > 0) {
            h();
        }
        this.B.o(this.c, this.p, this.q, this.f1925h, this.f1926i, this.f, this.y, this.z);
        this.B.j(b(), d());
        this.B.m(this.A);
        this.B.l(this.f1929l);
        this.B.k(this.r, zI);
        this.B.e(this.f1930m);
        this.B.i(this.f1932o, this.v);
        this.B.h(this.t);
        this.B.d(this.u);
        this.B.p();
    }
}
