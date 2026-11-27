package k.x.i1;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class s implements w {
    private static k.y.c u = k.y.c.b(s.class);
    public static q v = new q(1);
    public static q w = new q(2);
    public static q x = new q(3);
    private y a;
    private e0 b;
    private h0 c;
    private boolean d;
    private File e;
    private byte[] f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2089h;

    /* renamed from: i, reason: collision with root package name */
    private double f2090i;

    /* renamed from: j, reason: collision with root package name */
    private double f2091j;

    /* renamed from: k, reason: collision with root package name */
    private double f2092k;

    /* renamed from: l, reason: collision with root package name */
    private double f2093l;

    /* renamed from: m, reason: collision with root package name */
    private int f2094m;

    /* renamed from: n, reason: collision with root package name */
    private k0 f2095n;

    /* renamed from: o, reason: collision with root package name */
    private v f2096o;
    private t p;
    private l0 q;
    private int r;
    private int s;
    private q t;

    public s(e0 e0Var, h0 h0Var, t tVar, v vVar, k.s sVar) {
        boolean z = false;
        this.d = false;
        this.f2096o = vVar;
        this.b = e0Var;
        this.p = tVar;
        this.c = h0Var;
        this.d = false;
        this.f2095n = k0.a;
        tVar.a(e0Var.y());
        this.s = this.p.c() - 1;
        this.f2096o.f(this);
        if (e0Var != null && h0Var != null) {
            z = true;
        }
        k.y.a.a(z);
        p();
    }

    private y n() {
        if (!this.d) {
            p();
        }
        return this.a;
    }

    private void p() {
        y yVarD = this.p.d(this.s);
        this.a = yVarD;
        k.y.a.a(yVarD != null);
        z[] zVarArrN = this.a.n();
        n0 n0Var = (n0) this.a.n()[0];
        this.r = n0Var.m();
        this.g = this.c.C();
        l0 l0VarA = l0.a(n0Var.n());
        this.q = l0VarA;
        if (l0VarA == l0.g) {
            u.f("Unknown shape type");
        }
        j0 j0Var = (j0) this.a.n()[1];
        if (j0Var.o(260) != null) {
            this.f2089h = j0Var.o(260).d;
        }
        if (j0Var.o(261) != null) {
            this.e = new File(j0Var.o(261).e);
        } else if (this.q == l0.d) {
            u.f("no filename property for drawing");
            this.e = new File(Integer.toString(this.f2089h));
        }
        g gVar = null;
        for (int i2 = 0; i2 < zVarArrN.length && gVar == null; i2++) {
            if (zVarArrN[i2].h() == b0.f2046o) {
                gVar = (g) zVarArrN[i2];
            }
        }
        if (gVar == null) {
            u.f("client anchor not found");
        } else {
            this.f2090i = gVar.n();
            this.f2091j = gVar.p();
            this.f2092k = gVar.o() - this.f2090i;
            this.f2093l = gVar.q() - this.f2091j;
            this.t = q.a(gVar.m());
        }
        if (this.f2089h == 0) {
            u.f("linked drawings are not supported");
        }
        this.d = true;
    }

    @Override // k.x.i1.w
    public e0 a() {
        return this.b;
    }

    @Override // k.x.i1.w
    public void b(k.b0.v.l0 l0Var) throws IOException {
        if (this.f2095n == k0.a) {
            l0Var.e(this.c);
        } else {
            l0Var.e(new h0(this.g, h0.f2068j));
        }
    }

    @Override // k.x.i1.w
    public final int c() {
        if (!this.d) {
            p();
        }
        return this.g;
    }

    @Override // k.x.i1.w
    public boolean d() {
        return false;
    }

    @Override // k.x.i1.w
    public String e() {
        File file = this.e;
        if (file != null) {
            return file.getPath();
        }
        int i2 = this.f2089h;
        return i2 != 0 ? Integer.toString(i2) : "__new__image__";
    }

    @Override // k.x.i1.w
    public boolean f() {
        return this.b.A();
    }

    @Override // k.x.i1.w
    public y g() {
        if (!this.d) {
            p();
        }
        if (this.f2095n == k0.a) {
            return n();
        }
        o0 o0Var = new o0();
        o0Var.m(new n0(this.q, this.r, 2560));
        j0 j0Var = new j0();
        j0Var.m(260, true, false, this.f2089h);
        if (this.q == l0.d) {
            File file = this.e;
            String path = file != null ? file.getPath() : "";
            j0Var.n(261, true, true, path.length() * 2, path);
            j0Var.m(447, false, false, WXMediaMessage.THUMB_LENGTH_LIMIT);
            j0Var.m(959, false, false, 524288);
            o0Var.m(j0Var);
        }
        double d = this.f2090i;
        double d2 = this.f2091j;
        o0Var.m(new g(d, d2, d + this.f2092k, d2 + this.f2093l, this.t.b()));
        o0Var.m(new h());
        return o0Var;
    }

    @Override // k.x.i1.w
    public k0 getOrigin() {
        return this.f2095n;
    }

    @Override // k.x.i1.w
    public int getShapeId() {
        if (!this.d) {
            p();
        }
        return this.r;
    }

    @Override // k.x.i1.w
    public void h(k.b0.v.l0 l0Var) throws IOException {
    }

    @Override // k.x.i1.w
    public final void i(int i2, int i3, int i4) {
        this.g = i2;
        this.f2089h = i3;
        this.r = i4;
        if (this.f2095n == k0.a) {
            this.f2095n = k0.c;
        }
    }

    @Override // k.x.i1.w
    public void j(v vVar) {
        this.f2096o = vVar;
    }

    public final int k() {
        if (!this.d) {
            p();
        }
        return this.f2089h;
    }

    public byte[] l() throws IOException {
        k0 k0Var = this.f2095n;
        if (k0Var == k0.a || k0Var == k0.c) {
            return m();
        }
        k.y.a.a(k0Var == k0.b);
        File file = this.e;
        if (file == null) {
            k.y.a.a(this.f != null);
            return this.f;
        }
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(this.e);
        fileInputStream.read(bArr, 0, length);
        fileInputStream.close();
        return bArr;
    }

    public byte[] m() {
        k0 k0Var = this.f2095n;
        k.y.a.a(k0Var == k0.a || k0Var == k0.c);
        if (!this.d) {
            p();
        }
        return this.f2096o.h(this.f2089h);
    }

    public int o() {
        return this.f2094m;
    }

    public void q(int i2) {
        this.f2094m = i2;
    }

    protected s(w wVar, v vVar) {
        this.d = false;
        s sVar = (s) wVar;
        k0 k0Var = sVar.f2095n;
        k0 k0Var2 = k0.a;
        k.y.a.a(k0Var == k0Var2);
        this.b = sVar.b;
        this.c = sVar.c;
        this.d = false;
        this.f2095n = k0Var2;
        this.p = sVar.p;
        this.f2096o = vVar;
        this.s = sVar.s;
        vVar.f(this);
    }
}
