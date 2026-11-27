package l.a.a.f;

import java.util.List;

/* loaded from: classes.dex */
public abstract class b extends p {
    private int b;
    private byte[] c;
    private l.a.a.f.t.d d;
    private long e;

    /* renamed from: i, reason: collision with root package name */
    private int f2219i;

    /* renamed from: j, reason: collision with root package name */
    private int f2220j;

    /* renamed from: k, reason: collision with root package name */
    private String f2221k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2222l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2224n;

    /* renamed from: o, reason: collision with root package name */
    private o f2225o;
    private a p;
    private boolean q;
    private List<h> r;
    private boolean s;
    private long f = 0;
    private long g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f2218h = 0;

    /* renamed from: m, reason: collision with root package name */
    private l.a.a.f.t.e f2223m = l.a.a.f.t.e.NONE;

    public void A(boolean z) {
        this.f2222l = z;
    }

    public void B(l.a.a.f.t.e eVar) {
        this.f2223m = eVar;
    }

    public void C(List<h> list) {
        this.r = list;
    }

    public void D(int i2) {
        this.f2220j = i2;
    }

    public void E(String str) {
        this.f2221k = str;
    }

    public void F(int i2) {
        this.f2219i = i2;
    }

    public void G(boolean z) {
        this.q = z;
    }

    public void H(byte[] bArr) {
        this.c = bArr;
    }

    public void I(long j2) {
        this.e = j2;
    }

    public void J(long j2) {
        this.f2218h = j2;
    }

    public void K(int i2) {
        this.b = i2;
    }

    public void L(o oVar) {
        this.f2225o = oVar;
    }

    public a c() {
        return this.p;
    }

    public long d() {
        return this.g;
    }

    public l.a.a.f.t.d e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            return j().equals(((b) obj).j());
        }
        return false;
    }

    public long f() {
        return this.f;
    }

    public l.a.a.f.t.e g() {
        return this.f2223m;
    }

    public List<h> h() {
        return this.r;
    }

    public int i() {
        return this.f2220j;
    }

    public String j() {
        return this.f2221k;
    }

    public int k() {
        return this.f2219i;
    }

    public byte[] l() {
        return this.c;
    }

    public long m() {
        return this.e;
    }

    public long n() {
        return this.f2218h;
    }

    public int o() {
        return this.b;
    }

    public o p() {
        return this.f2225o;
    }

    public boolean q() {
        return this.f2224n;
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.f2222l;
    }

    public boolean t() {
        return this.q;
    }

    public void u(a aVar) {
        this.p = aVar;
    }

    public void v(long j2) {
        this.g = j2;
    }

    public void w(l.a.a.f.t.d dVar) {
        this.d = dVar;
    }

    public void x(long j2) {
        this.f = j2;
    }

    public void y(boolean z) {
        this.f2224n = z;
    }

    public void z(boolean z) {
        this.s = z;
    }
}
