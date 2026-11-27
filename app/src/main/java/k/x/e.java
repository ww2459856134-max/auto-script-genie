package k.x;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: k, reason: collision with root package name */
    public static k.y.c f2011k = k.y.c.b(e.class);

    /* renamed from: l, reason: collision with root package name */
    public static final d f2012l = new d(w.x);

    /* renamed from: m, reason: collision with root package name */
    public static final d f2013m = new d(w.y);

    /* renamed from: n, reason: collision with root package name */
    public static final d f2014n = new d(w.z);

    /* renamed from: o, reason: collision with root package name */
    public static final d f2015o = new d(w.A);
    public static final d p = new d(w.B);
    public static final d q = new d(w.C);
    public static final d r = new d(w.D);
    public static final d s = new d(w.E);
    private String a;
    private double b;
    private double c;
    private k.x.i1.k d;
    private k.x.i1.j e;
    private a0 f;
    private w g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2016h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2017i;

    /* renamed from: j, reason: collision with root package name */
    private k.b0.v.o f2018j;

    protected e() {
    }

    private void a() {
        this.f = null;
        this.g = null;
        this.f2016h = false;
        this.e = null;
        this.f2017i = false;
    }

    protected String b() {
        return this.a;
    }

    public double c() {
        return this.c;
    }

    public double d() {
        return this.b;
    }

    public w e() {
        w wVar = this.g;
        if (wVar != null) {
            return wVar;
        }
        if (this.f == null) {
            return null;
        }
        w wVar2 = new w(this.f.A());
        this.g = wVar2;
        return wVar2;
    }

    public boolean f() {
        return this.f2017i;
    }

    public boolean g() {
        return this.f2016h;
    }

    public void h() {
        this.a = null;
        k.x.i1.k kVar = this.d;
        if (kVar != null) {
            this.f2018j.F(kVar);
            this.d = null;
        }
    }

    public void i() {
        if (this.f2017i) {
            w wVarE = e();
            if (!wVarE.b()) {
                this.f2018j.G();
                a();
                return;
            }
            f2011k.f("Cannot remove data validation from " + k.e.b(this.f2018j) + " as it is part of the shared reference " + k.e.a(wVarE.d(), wVarE.e()) + ProcessIdUtil.DEFAULT_PROCESSID + k.e.a(wVarE.f(), wVarE.g()));
        }
    }

    public void j(k.x.i1.j jVar) {
        this.e = jVar;
    }

    public final void k(k.x.i1.k kVar) {
        this.d = kVar;
    }

    public void l(String str, double d, double d2) {
        this.a = str;
        this.b = d;
        this.c = d2;
    }

    public void m(a0 a0Var) {
        k.y.a.a(a0Var != null);
        this.f = a0Var;
        this.f2017i = true;
    }

    public final void n(k.b0.v.o oVar) {
        this.f2018j = oVar;
    }

    public void o(e eVar) {
        if (this.f2017i) {
            f2011k.f("Attempting to share a data validation on cell " + k.e.b(this.f2018j) + " which already has a data validation");
            return;
        }
        a();
        this.g = eVar.e();
        this.f = null;
        this.f2017i = true;
        this.f2016h = eVar.f2016h;
        this.e = eVar.e;
    }

    public e(e eVar) {
        this.a = eVar.a;
        this.b = eVar.b;
        this.c = eVar.c;
        this.f2016h = eVar.f2016h;
        this.f2017i = eVar.f2017i;
        this.f = eVar.f;
        if (eVar.g != null) {
            this.g = new w(eVar.g);
        }
    }
}
