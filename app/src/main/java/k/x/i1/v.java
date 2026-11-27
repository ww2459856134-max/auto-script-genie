package k.x.i1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import k.a0.a.f2;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* loaded from: classes.dex */
public class v implements c0 {

    /* renamed from: n, reason: collision with root package name */
    private static k.y.c f2097n = k.y.c.b(v.class);
    private byte[] a;
    private y b;
    private a c;
    private boolean d;
    private ArrayList e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2098h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2099i;

    /* renamed from: j, reason: collision with root package name */
    private k0 f2100j;

    /* renamed from: k, reason: collision with root package name */
    private HashMap f2101k;

    /* renamed from: l, reason: collision with root package name */
    private int f2102l;

    /* renamed from: m, reason: collision with root package name */
    private int f2103m;

    public v(k0 k0Var) {
        this.f2100j = k0Var;
        this.d = k0Var == k0.b;
        this.e = new ArrayList();
        this.f2101k = new HashMap();
        this.f2099i = false;
        this.f2102l = 1;
        this.f2103m = 1024;
    }

    private void e(byte[] bArr) {
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            byte[] bArr3 = new byte[bArr.length];
            this.a = bArr3;
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        } else {
            byte[] bArr4 = new byte[bArr2.length + bArr.length];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr4, this.a.length, bArr.length);
            this.a = bArr4;
        }
    }

    private a g() {
        if (this.c == null) {
            if (!this.d) {
                j();
            }
            z[] zVarArrN = this.b.n();
            if (zVarArrN.length > 1 && zVarArrN[1].h() == b0.e) {
                this.c = (a) zVarArrN[1];
            }
        }
        return this.c;
    }

    private void j() {
        a0 a0Var = new a0(this, 0);
        k.y.a.a(a0Var.h());
        y yVar = new y(a0Var);
        this.b = yVar;
        k.y.a.a(yVar.e() == this.a.length);
        k.y.a.a(this.b.h() == b0.d);
        this.d = true;
    }

    public void a(e eVar) {
        this.g++;
    }

    public void b(w wVar) {
        if (this.f2100j == k0.a) {
            this.f2100j = k0.c;
            a aVarG = g();
            this.f2098h = (((o) this.b.n()[0]).n(1).a - this.f) - 1;
            int iP = aVarG != null ? aVarG.p() : 0;
            this.f = iP;
            if (aVarG != null) {
                k.y.a.a(iP == aVarG.p());
            }
        }
        if (!(wVar instanceof s)) {
            this.f2102l++;
            this.f2103m++;
            wVar.j(this);
            wVar.i(this.f2102l, this.f + 1, this.f2103m);
            if (this.e.size() > this.f2102l) {
                f2097n.f("drawings length " + this.e.size() + " exceeds the max object id " + this.f2102l);
                return;
            }
            return;
        }
        s sVar = (s) wVar;
        s sVar2 = (s) this.f2101k.get(wVar.e());
        if (sVar2 != null) {
            sVar2.q(sVar2.o() + 1);
            sVar.j(this);
            sVar.i(sVar2.c(), sVar2.k(), sVar2.getShapeId());
            return;
        }
        this.f2102l++;
        this.f2103m++;
        this.e.add(sVar);
        sVar.j(this);
        sVar.i(this.f2102l, this.f + 1, this.f2103m);
        this.f++;
        this.f2101k.put(sVar.e(), sVar);
    }

    public void c(d0 d0Var) {
        e(d0Var.y());
    }

    public void d(f2 f2Var) {
        e(f2Var.c());
    }

    final void f(w wVar) {
        this.e.add(wVar);
        this.f2102l = Math.max(this.f2102l, wVar.c());
        this.f2103m = Math.max(this.f2103m, wVar.getShapeId());
    }

    @Override // k.x.i1.c0
    public byte[] getData() {
        return this.a;
    }

    byte[] h(int i2) {
        int iP = g().p();
        this.f = iP;
        k.y.a.a(i2 <= iP);
        k0 k0Var = this.f2100j;
        k.y.a.a(k0Var == k0.a || k0Var == k0.c);
        return ((b) g().n()[i2 - 1]).m();
    }

    public boolean i() {
        return this.f2099i;
    }

    public void k(e0 e0Var, h0 h0Var) {
        this.f2099i = true;
        if (h0Var != null) {
            this.f2102l = Math.max(this.f2102l, h0Var.C());
        }
    }

    public void l(v vVar) {
        this.f2099i = vVar.f2099i;
        this.f2102l = vVar.f2102l;
        this.f2103m = vVar.f2103m;
    }

    public void m(k.b0.v.l0 l0Var) throws IOException {
        k0 k0Var = this.f2100j;
        int i2 = 0;
        if (k0Var == k0.b) {
            p pVar = new p();
            int i3 = this.f;
            o oVar = new o(this.g + i3 + 1, i3);
            oVar.m(1, 0);
            oVar.m(this.f + 1, 0);
            pVar.m(oVar);
            a aVar = new a();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof s) {
                    aVar.m(new b((s) next));
                    i2++;
                }
            }
            if (i2 > 0) {
                aVar.q(i2);
                pVar.m(aVar);
            }
            pVar.m(new j0());
            pVar.m(new r0());
            this.a = pVar.b();
        } else if (k0Var == k0.c) {
            p pVar2 = new p();
            int i4 = this.f;
            o oVar2 = new o(this.g + i4 + 1, i4);
            oVar2.m(1, 0);
            oVar2.m(this.f2098h + this.f + 1, 0);
            pVar2.m(oVar2);
            a aVar2 = new a();
            aVar2.q(this.f);
            a aVarG = g();
            if (aVarG != null) {
                for (z zVar : aVarG.n()) {
                    aVar2.m((b) zVar);
                }
            }
            Iterator it2 = this.e.iterator();
            while (it2.hasNext()) {
                w wVar = (w) it2.next();
                if (wVar instanceof s) {
                    s sVar = (s) wVar;
                    if (sVar.getOrigin() == k0.b) {
                        aVar2.m(new b(sVar));
                    }
                }
            }
            pVar2.m(aVar2);
            j0 j0Var = new j0();
            j0Var.m(STBorder.INT_ZIG_ZAG, false, false, 524296);
            j0Var.m(385, false, false, 134217737);
            j0Var.m(448, false, false, 134217792);
            pVar2.m(j0Var);
            pVar2.m(new r0());
            this.a = pVar2.b();
        }
        l0Var.e(new d0(this.a));
    }

    public v(v vVar) {
        this.a = vVar.a;
        this.b = vVar.b;
        this.c = vVar.c;
        this.d = vVar.d;
        this.a = vVar.a;
        this.b = vVar.b;
        this.c = vVar.c;
        this.f = vVar.f;
        this.g = vVar.g;
        this.f2098h = vVar.f2098h;
        this.f2099i = vVar.f2099i;
        this.f2100j = vVar.f2100j;
        this.f2101k = (HashMap) vVar.f2101k.clone();
        this.f2102l = vVar.f2102l;
        this.f2103m = vVar.f2103m;
        this.e = new ArrayList();
    }
}
