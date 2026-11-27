package k.a0.a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
class v implements k.g, n {

    /* renamed from: l, reason: collision with root package name */
    private static final SimpleDateFormat f1865l;

    /* renamed from: m, reason: collision with root package name */
    private static final SimpleDateFormat f1866m;

    /* renamed from: n, reason: collision with root package name */
    private static final TimeZone f1867n;
    private Date a;
    private int b;
    private int c;
    private boolean d;
    private DateFormat e;
    private k.z.d f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private k.x.n0 f1868h;

    /* renamed from: i, reason: collision with root package name */
    private y2 f1869i;

    /* renamed from: j, reason: collision with root package name */
    private k.d f1870j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1871k = false;

    static {
        k.y.c.b(v.class);
        f1865l = new SimpleDateFormat("dd MMM yyyy");
        f1866m = new SimpleDateFormat("HH:mm:ss");
        f1867n = TimeZone.getTimeZone("GMT");
    }

    public v(k.p pVar, int i2, k.x.n0 n0Var, boolean z, y2 y2Var) {
        this.b = pVar.getRow();
        this.c = pVar.b();
        this.g = i2;
        this.f1868h = n0Var;
        this.f1869i = y2Var;
        this.e = n0Var.c(i2);
        double value = pVar.getValue();
        if (Math.abs(value) < 1.0d) {
            if (this.e == null) {
                this.e = f1866m;
            }
            this.d = true;
        } else {
            if (this.e == null) {
                this.e = f1865l;
            }
            this.d = false;
        }
        if (!z && !this.d && value < 61.0d) {
            value += 1.0d;
        }
        this.e.setTimeZone(f1867n);
        this.a = new Date(Math.round((value - (z ? 24107 : 25569)) * 86400.0d) * 1000);
    }

    protected final y2 a() {
        return this.f1869i;
    }

    @Override // k.c
    public final int b() {
        return this.c;
    }

    @Override // k.c, k.a0.a.n
    public k.d c() {
        return this.f1870j;
    }

    @Override // k.c
    public k.z.d e() {
        if (!this.f1871k) {
            this.f = this.f1868h.h(this.g);
            this.f1871k = true;
        }
        return this.f;
    }

    @Override // k.g
    public Date getDate() {
        return this.a;
    }

    @Override // k.c
    public final int getRow() {
        return this.b;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.f1994l;
    }

    @Override // k.a0.a.n
    public void h(k.d dVar) {
        this.f1870j = dVar;
    }

    @Override // k.g
    public boolean i() {
        return this.d;
    }

    @Override // k.c
    public String p() {
        return this.e.format(this.a);
    }
}
