package k;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import k.x.j1.z;

/* loaded from: classes.dex */
public final class w {
    private static k.y.c z = k.y.c.b(w.class);
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2003h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2004i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2005j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2006k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2007l;

    /* renamed from: m, reason: collision with root package name */
    private File f2008m;

    /* renamed from: n, reason: collision with root package name */
    private Locale f2009n;

    /* renamed from: o, reason: collision with root package name */
    private z f2010o;
    private String p;
    private boolean v;
    private String x;
    private int a = 5242880;
    private int b = 1048576;
    private HashMap s = new HashMap();
    private String q = k.x.s.e.a();
    private String r = k.x.s.f.a();
    private boolean t = false;
    private boolean u = false;
    private boolean w = false;
    private int y = 0;

    public w() {
        this.v = false;
        this.v = false;
        try {
            D(Boolean.getBoolean("jxl.nowarnings"));
            this.c = Boolean.getBoolean("jxl.nodrawings");
            this.d = Boolean.getBoolean("jxl.nonames");
            this.e = Boolean.getBoolean("jxl.nogc");
            this.f = Boolean.getBoolean("jxl.norat");
            this.g = Boolean.getBoolean("jxl.nomergedcellchecks");
            Boolean.getBoolean("jxl.noformulaadjust");
            this.f2003h = Boolean.getBoolean("jxl.nopropertysets");
            this.f2005j = Boolean.getBoolean("jxl.ignoreblanks");
            this.f2004i = Boolean.getBoolean("jxl.nocellvalidation");
            this.f2006k = Boolean.getBoolean("jxl.autofilter") ? false : true;
            this.f2007l = Boolean.getBoolean("jxl.usetemporaryfileduringwrite");
            String property = System.getProperty("jxl.temporaryfileduringwritedirectory");
            if (property != null) {
                this.f2008m = new File(property);
            }
            this.p = System.getProperty("file.encoding");
        } catch (SecurityException e) {
            z.g("Error accessing system properties.", e);
        }
        try {
            if (System.getProperty("jxl.lang") == null || System.getProperty("jxl.country") == null) {
                this.f2009n = Locale.getDefault();
            } else {
                this.f2009n = new Locale(System.getProperty("jxl.lang"), System.getProperty("jxl.country"));
            }
            if (System.getProperty("jxl.encoding") != null) {
                this.p = System.getProperty("jxl.encoding");
            }
        } catch (SecurityException e2) {
            z.g("Error accessing system properties.", e2);
            this.f2009n = Locale.getDefault();
        }
    }

    public void A(boolean z2) {
        this.v = z2;
    }

    public void B(int i2) {
        this.y = i2;
    }

    public void C(boolean z2) {
        this.t = z2;
    }

    public void D(boolean z2) {
        z.e(z2);
    }

    public void E(boolean z2) {
        this.u = z2;
    }

    public void F(boolean z2) {
        this.w = this.w;
    }

    public void G(String str) {
        this.x = str;
    }

    public int a() {
        return this.b;
    }

    public boolean b() {
        return this.f2006k;
    }

    public boolean c() {
        return this.f2004i;
    }

    public boolean d() {
        return this.c;
    }

    public String e() {
        return this.p;
    }

    public boolean f() {
        return this.v;
    }

    public String g() {
        return this.q;
    }

    public String h() {
        return this.r;
    }

    public z i() {
        if (this.f2010o == null) {
            z zVar = (z) this.s.get(this.f2009n);
            this.f2010o = zVar;
            if (zVar == null) {
                z zVar2 = new z(this.f2009n);
                this.f2010o = zVar2;
                this.s.put(this.f2009n, zVar2);
            }
        }
        return this.f2010o;
    }

    public boolean j() {
        return this.e;
    }

    public int k() {
        return this.y;
    }

    public boolean l() {
        return this.f2005j;
    }

    public int m() {
        return this.a;
    }

    public Locale n() {
        return this.f2009n;
    }

    public boolean o() {
        return this.g;
    }

    public boolean p() {
        return this.d;
    }

    public boolean q() {
        return this.f2003h;
    }

    public boolean r() {
        return this.f;
    }

    public boolean s() {
        return this.t;
    }

    public boolean t() {
        return this.u;
    }

    public File u() {
        return this.f2008m;
    }

    public boolean v() {
        return this.f2007l;
    }

    public boolean w() {
        return this.w;
    }

    public String x() {
        return this.x;
    }

    public void y(int i2) {
    }

    public void z(boolean z2) {
        this.c = z2;
    }
}
