package k.b0.v;

import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
class r extends k.x.c1 {
    private byte[] c;
    private int d;
    private k.x.h1 e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1941h;

    /* renamed from: i, reason: collision with root package name */
    private int f1942i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1943j;

    public r(k.a0.a.r rVar, int i2, k.x.n0 n0Var) {
        super(k.x.z0.t);
        this.d = i2;
        this.g = rVar.D();
        int iE = rVar.E();
        this.f = iE;
        this.e = n0Var.h(iE);
        this.f1942i = rVar.B();
        this.f1943j = rVar.y();
    }

    public k.x.h1 A() {
        return this.e;
    }

    void B(k.x.r0 r0Var) {
        this.f = r0Var.a(this.f);
    }

    void C(boolean z) {
        this.f1941h = z;
    }

    void D(int i2) {
        this.g = i2;
    }

    public int b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.d != rVar.d || this.f != rVar.f || this.g != rVar.g || this.f1941h != rVar.f1941h || this.f1942i != rVar.f1942i || this.f1943j != rVar.f1943j) {
            return false;
        }
        k.x.h1 h1Var = this.e;
        if ((h1Var != null || rVar.e == null) && (h1Var == null || rVar.e != null)) {
            return h1Var.equals(rVar.e);
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((((((10823 + this.d) * 79) + this.f) * 79) + this.g) * 79) + (this.f1941h ? 1 : 0);
        k.x.h1 h1Var = this.e;
        return h1Var != null ? i2 ^ h1Var.hashCode() : i2;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[12];
        this.c = bArr;
        k.x.s0.f(this.d, bArr, 0);
        k.x.s0.f(this.d, this.c, 2);
        k.x.s0.f(this.g, this.c, 4);
        k.x.s0.f(this.f, this.c, 6);
        int i2 = (this.f1942i << 8) | 6;
        if (this.f1941h) {
            i2 |= 1;
        }
        this.f1942i = (i2 & 1792) / 256;
        if (this.f1943j) {
            i2 |= XMLEvent.CHANGE_PREFIX_MAPPING;
        }
        k.x.s0.f(i2, this.c, 8);
        return this.c;
    }
}
