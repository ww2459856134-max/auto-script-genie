package l.a.a.f;

/* loaded from: classes.dex */
public class s {
    private l.a.a.f.t.d a;
    private l.a.a.f.t.c b;
    private boolean c;
    private l.a.a.f.t.e d;
    private boolean e;
    private boolean f;
    private l.a.a.f.t.a g;

    /* renamed from: h, reason: collision with root package name */
    private l.a.a.f.t.b f2234h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2235i;

    /* renamed from: j, reason: collision with root package name */
    private long f2236j;

    /* renamed from: k, reason: collision with root package name */
    private String f2237k;

    /* renamed from: l, reason: collision with root package name */
    private String f2238l;

    /* renamed from: m, reason: collision with root package name */
    private long f2239m;

    /* renamed from: n, reason: collision with root package name */
    private long f2240n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2241o;
    private boolean p;
    private String q;
    private String r;
    private r s;
    private g t;
    private boolean u;

    public s() {
        this.a = l.a.a.f.t.d.DEFLATE;
        this.b = l.a.a.f.t.c.NORMAL;
        this.c = false;
        this.d = l.a.a.f.t.e.NONE;
        this.e = true;
        this.f = true;
        this.g = l.a.a.f.t.a.KEY_STRENGTH_256;
        this.f2234h = l.a.a.f.t.b.TWO;
        this.f2235i = true;
        this.f2239m = 0L;
        this.f2240n = -1L;
        this.f2241o = true;
        this.p = true;
        this.s = r.INCLUDE_LINKED_FILE_ONLY;
    }

    public void A(long j2) {
        this.f2236j = j2;
    }

    public void B(long j2) {
        this.f2240n = j2;
    }

    public void C(String str) {
        this.f2238l = str;
    }

    public void D(long j2) {
        if (j2 < 0) {
            this.f2239m = 0L;
        } else {
            this.f2239m = j2;
        }
    }

    public void E(boolean z) {
        this.f2241o = z;
    }

    public l.a.a.f.t.a a() {
        return this.g;
    }

    public l.a.a.f.t.b b() {
        return this.f2234h;
    }

    public l.a.a.f.t.c c() {
        return this.b;
    }

    public l.a.a.f.t.d d() {
        return this.a;
    }

    public String e() {
        return this.f2237k;
    }

    public l.a.a.f.t.e f() {
        return this.d;
    }

    public long g() {
        return this.f2236j;
    }

    public long h() {
        return this.f2240n;
    }

    public g i() {
        return this.t;
    }

    public String j() {
        return this.r;
    }

    public String k() {
        return this.f2238l;
    }

    public long l() {
        return this.f2239m;
    }

    public String m() {
        return this.q;
    }

    public r n() {
        return this.s;
    }

    public boolean o() {
        return this.c;
    }

    public boolean p() {
        return this.f2235i;
    }

    public boolean q() {
        return this.p;
    }

    public boolean r() {
        return this.e;
    }

    public boolean s() {
        return this.f;
    }

    public boolean t() {
        return this.u;
    }

    public boolean u() {
        return this.f2241o;
    }

    public void v(l.a.a.f.t.c cVar) {
        this.b = cVar;
    }

    public void w(l.a.a.f.t.d dVar) {
        this.a = dVar;
    }

    public void x(String str) {
        this.f2237k = str;
    }

    public void y(boolean z) {
        this.c = z;
    }

    public void z(l.a.a.f.t.e eVar) {
        this.d = eVar;
    }

    public s(s sVar) {
        this.a = l.a.a.f.t.d.DEFLATE;
        this.b = l.a.a.f.t.c.NORMAL;
        this.c = false;
        this.d = l.a.a.f.t.e.NONE;
        this.e = true;
        this.f = true;
        this.g = l.a.a.f.t.a.KEY_STRENGTH_256;
        this.f2234h = l.a.a.f.t.b.TWO;
        this.f2235i = true;
        this.f2239m = 0L;
        this.f2240n = -1L;
        this.f2241o = true;
        this.p = true;
        this.s = r.INCLUDE_LINKED_FILE_ONLY;
        this.a = sVar.d();
        this.b = sVar.c();
        this.c = sVar.o();
        this.d = sVar.f();
        this.e = sVar.r();
        this.f = sVar.s();
        this.g = sVar.a();
        this.f2234h = sVar.b();
        this.f2235i = sVar.p();
        this.f2236j = sVar.g();
        this.f2237k = sVar.e();
        this.f2238l = sVar.k();
        this.f2239m = sVar.l();
        this.f2240n = sVar.h();
        this.f2241o = sVar.u();
        this.p = sVar.q();
        this.q = sVar.m();
        this.r = sVar.j();
        this.s = sVar.n();
        this.t = sVar.i();
        this.u = sVar.t();
    }
}
