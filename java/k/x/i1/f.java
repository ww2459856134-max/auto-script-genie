package k.x.i1;

import android.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* loaded from: classes.dex */
public class f implements w {
    private static k.y.c r = k.y.c.b(f.class);
    private y a;
    private e0 b;
    private h0 c;
    private boolean d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2057h;

    /* renamed from: i, reason: collision with root package name */
    private k0 f2058i;

    /* renamed from: j, reason: collision with root package name */
    private v f2059j;

    /* renamed from: k, reason: collision with root package name */
    private t f2060k;

    /* renamed from: l, reason: collision with root package name */
    private l0 f2061l;

    /* renamed from: m, reason: collision with root package name */
    private int f2062m;

    /* renamed from: n, reason: collision with root package name */
    private e0 f2063n;

    /* renamed from: o, reason: collision with root package name */
    private s0 f2064o;
    private k.x.r p;
    private k.x.r q;

    public f(e0 e0Var, h0 h0Var, t tVar, v vVar, k.w wVar) {
        boolean z = false;
        this.d = false;
        this.f2059j = vVar;
        this.b = e0Var;
        this.f2060k = tVar;
        this.c = h0Var;
        this.d = false;
        this.f2058i = k0.a;
        tVar.a(e0Var.y());
        this.f2062m = this.f2060k.c() - 1;
        this.f2059j.f(this);
        if (e0Var != null && h0Var != null) {
            z = true;
        }
        k.y.a.a(z);
        m();
    }

    private y l() {
        if (!this.d) {
            m();
        }
        return this.a;
    }

    private void m() {
        y yVarD = this.f2060k.d(this.f2062m);
        this.a = yVarD;
        k.y.a.a(yVarD != null);
        z[] zVarArrN = this.a.n();
        n0 n0Var = (n0) this.a.n()[0];
        this.e = this.c.C();
        this.f = n0Var.m();
        l0 l0VarA = l0.a(n0Var.n());
        this.f2061l = l0VarA;
        if (l0VarA == l0.g) {
            r.f("Unknown shape type");
        }
        g gVar = null;
        for (int i2 = 0; i2 < zVarArrN.length && gVar == null; i2++) {
            if (zVarArrN[i2].h() == b0.f2046o) {
                gVar = (g) zVarArrN[i2];
            }
        }
        if (gVar == null) {
            r.f("Client anchor not found");
        } else {
            this.g = (int) gVar.n();
            this.f2057h = (int) gVar.p();
        }
        this.d = true;
    }

    @Override // k.x.i1.w
    public e0 a() {
        return this.b;
    }

    @Override // k.x.i1.w
    public void b(k.b0.v.l0 l0Var) throws IOException {
        if (this.f2058i != k0.a) {
            l0Var.e(new h0(this.e, h0.f2069k));
            r.f("Writing of additional records for checkboxes not implemented");
            return;
        }
        l0Var.e(this.c);
        e0 e0Var = this.f2063n;
        if (e0Var != null) {
            l0Var.e(e0Var);
        }
        l0Var.e(this.f2064o);
        l0Var.e(this.p);
        k.x.r rVar = this.q;
        if (rVar != null) {
            l0Var.e(rVar);
        }
    }

    @Override // k.x.i1.w
    public final int c() {
        if (!this.d) {
            m();
        }
        return this.e;
    }

    @Override // k.x.i1.w
    public boolean d() {
        return false;
    }

    @Override // k.x.i1.w
    public String e() {
        k.y.a.a(false);
        return null;
    }

    @Override // k.x.i1.w
    public boolean f() {
        return this.b.A();
    }

    @Override // k.x.i1.w
    public y g() {
        if (!this.d) {
            m();
        }
        if (this.f2058i == k0.a) {
            return l();
        }
        o0 o0Var = new o0();
        o0Var.m(new n0(this.f2061l, this.f, 2560));
        j0 j0Var = new j0();
        j0Var.m(127, false, false, R.string.accessibility_system_action_dpad_left_label);
        j0Var.m(STBorder.INT_ZIG_ZAG, false, false, 524296);
        j0Var.m(511, false, false, 524288);
        j0Var.m(959, false, false, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        o0Var.m(j0Var);
        o0Var.m(new g(this.g, this.f2057h, r2 + 1, r3 + 1, 1));
        o0Var.m(new h());
        return o0Var;
    }

    @Override // k.x.i1.w
    public k0 getOrigin() {
        return this.f2058i;
    }

    @Override // k.x.i1.w
    public final int getShapeId() {
        if (!this.d) {
            m();
        }
        return this.f;
    }

    @Override // k.x.i1.w
    public void h(k.b0.v.l0 l0Var) {
    }

    public int hashCode() {
        return f.class.getName().hashCode();
    }

    @Override // k.x.i1.w
    public final void i(int i2, int i3, int i4) {
        this.e = i2;
        this.f = i4;
        if (this.f2058i == k0.a) {
            this.f2058i = k0.c;
        }
    }

    @Override // k.x.i1.w
    public void j(v vVar) {
        this.f2059j = vVar;
    }

    public void k(e0 e0Var) {
        this.f2063n = e0Var;
        this.f2060k.b(e0Var.y());
    }

    public void n(k.x.r rVar) {
        this.q = rVar;
    }

    public void o(k.x.r rVar) {
        this.p = rVar;
    }

    public void p(s0 s0Var) {
        this.f2064o = s0Var;
    }

    public f(w wVar, v vVar, k.w wVar2) {
        this.d = false;
        f fVar = (f) wVar;
        k0 k0Var = fVar.f2058i;
        k0 k0Var2 = k0.a;
        k.y.a.a(k0Var == k0Var2);
        this.b = fVar.b;
        this.c = fVar.c;
        this.d = false;
        this.f2058i = k0Var2;
        this.f2060k = fVar.f2060k;
        this.f2059j = vVar;
        this.f2062m = fVar.f2062m;
        vVar.f(this);
        this.f2063n = fVar.f2063n;
        this.f2064o = fVar.f2064o;
        this.p = fVar.p;
        this.q = fVar.q;
    }
}
