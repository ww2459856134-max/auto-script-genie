package k.x.i1;

import android.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* loaded from: classes.dex */
public class j implements w {

    /* renamed from: n, reason: collision with root package name */
    private static k.y.c f2073n = k.y.c.b(j.class);
    private y a;
    private e0 b;
    private h0 c;
    private boolean d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2074h;

    /* renamed from: i, reason: collision with root package name */
    private k0 f2075i;

    /* renamed from: j, reason: collision with root package name */
    private v f2076j;

    /* renamed from: k, reason: collision with root package name */
    private t f2077k;

    /* renamed from: l, reason: collision with root package name */
    private l0 f2078l;

    /* renamed from: m, reason: collision with root package name */
    private int f2079m;

    public j(e0 e0Var, h0 h0Var, t tVar, v vVar, k.w wVar) {
        boolean z = false;
        this.d = false;
        this.f2076j = vVar;
        this.b = e0Var;
        this.f2077k = tVar;
        this.c = h0Var;
        this.d = false;
        this.f2075i = k0.a;
        tVar.a(e0Var.y());
        this.f2079m = this.f2077k.c() - 1;
        this.f2076j.f(this);
        if (e0Var != null && h0Var != null) {
            z = true;
        }
        k.y.a.a(z);
        l();
    }

    private y k() {
        if (!this.d) {
            l();
        }
        return this.a;
    }

    private void l() {
        y yVarD = this.f2077k.d(this.f2079m);
        this.a = yVarD;
        k.y.a.a(yVarD != null);
        z[] zVarArrN = this.a.n();
        n0 n0Var = (n0) this.a.n()[0];
        this.e = this.c.C();
        this.f = n0Var.m();
        l0 l0VarA = l0.a(n0Var.n());
        this.f2078l = l0VarA;
        if (l0VarA == l0.g) {
            f2073n.f("Unknown shape type");
        }
        g gVar = null;
        for (int i2 = 0; i2 < zVarArrN.length && gVar == null; i2++) {
            if (zVarArrN[i2].h() == b0.f2046o) {
                gVar = (g) zVarArrN[i2];
            }
        }
        if (gVar == null) {
            f2073n.f("Client anchor not found");
        } else {
            this.g = (int) gVar.n();
            this.f2074h = (int) gVar.p();
        }
        this.d = true;
    }

    @Override // k.x.i1.w
    public e0 a() {
        return this.b;
    }

    @Override // k.x.i1.w
    public void b(k.b0.v.l0 l0Var) throws IOException {
        if (this.f2075i == k0.a) {
            l0Var.e(this.c);
        } else {
            l0Var.e(new h0(this.e, h0.f2070l));
        }
    }

    @Override // k.x.i1.w
    public final int c() {
        if (!this.d) {
            l();
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
            l();
        }
        if (this.f2075i == k0.a) {
            return k();
        }
        o0 o0Var = new o0();
        o0Var.m(new n0(this.f2078l, this.f, 2560));
        j0 j0Var = new j0();
        j0Var.m(127, false, false, R.string.accessibility_system_action_dpad_left_label);
        j0Var.m(STBorder.INT_ZIG_ZAG, false, false, 524296);
        j0Var.m(511, false, false, 524288);
        j0Var.m(959, false, false, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        o0Var.m(j0Var);
        o0Var.m(new g(this.g, this.f2074h, r2 + 1, r3 + 1, 1));
        o0Var.m(new h());
        return o0Var;
    }

    @Override // k.x.i1.w
    public k0 getOrigin() {
        return this.f2075i;
    }

    @Override // k.x.i1.w
    public final int getShapeId() {
        if (!this.d) {
            l();
        }
        return this.f;
    }

    @Override // k.x.i1.w
    public void h(k.b0.v.l0 l0Var) {
    }

    public int hashCode() {
        return j.class.getName().hashCode();
    }

    @Override // k.x.i1.w
    public final void i(int i2, int i3, int i4) {
        this.e = i2;
        this.f = i4;
        if (this.f2075i == k0.a) {
            this.f2075i = k0.c;
        }
    }

    @Override // k.x.i1.w
    public void j(v vVar) {
        this.f2076j = vVar;
    }

    public j(w wVar, v vVar, k.w wVar2) {
        this.d = false;
        j jVar = (j) wVar;
        k0 k0Var = jVar.f2075i;
        k0 k0Var2 = k0.a;
        k.y.a.a(k0Var == k0Var2);
        this.b = jVar.b;
        this.c = jVar.c;
        this.d = false;
        this.f2075i = k0Var2;
        this.f2077k = jVar.f2077k;
        this.f2076j = vVar;
        this.f2079m = jVar.f2079m;
        vVar.f(this);
    }

    public j() {
        this.d = false;
        this.d = true;
        this.f2075i = k0.b;
        this.f2078l = l0.e;
    }
}
