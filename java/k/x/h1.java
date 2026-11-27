package k.x;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import k.a0.a.f2;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class h1 extends c1 implements k.z.d {
    private static k.y.c N = k.y.c.b(h1.class);
    private static final int[] O = {14, 15, 16, 17, 18, 19, 20, 21, 22, 45, 46, 47};
    private static final DateFormat[] P = {SimpleDateFormat.getDateInstance(3), SimpleDateFormat.getDateInstance(2), new SimpleDateFormat("d-MMM"), new SimpleDateFormat("MMM-yy"), new SimpleDateFormat("h:mm a"), new SimpleDateFormat("h:mm:ss a"), new SimpleDateFormat("H:mm"), new SimpleDateFormat("H:mm:ss"), new SimpleDateFormat("M/d/yy H:mm"), new SimpleDateFormat("mm:ss"), new SimpleDateFormat("H:mm:ss"), new SimpleDateFormat("mm:ss.S")};
    private static int[] Q = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 37, 38, 39, 40, 41, 42, 43, 44, 48};
    private static NumberFormat[] R = {new DecimalFormat("0"), new DecimalFormat("0.00"), new DecimalFormat("#,##0"), new DecimalFormat("#,##0.00"), new DecimalFormat("$#,##0;($#,##0)"), new DecimalFormat("$#,##0;($#,##0)"), new DecimalFormat("$#,##0.00;($#,##0.00)"), new DecimalFormat("$#,##0.00;($#,##0.00)"), new DecimalFormat("0%"), new DecimalFormat("0.00%"), new DecimalFormat("0.00E00"), new DecimalFormat("#,##0;(#,##0)"), new DecimalFormat("#,##0;(#,##0)"), new DecimalFormat("#,##0.00;(#,##0.00)"), new DecimalFormat("#,##0.00;(#,##0.00)"), new DecimalFormat("#,##0;(#,##0)"), new DecimalFormat("$#,##0;($#,##0)"), new DecimalFormat("#,##0.00;(#,##0.00)"), new DecimalFormat("$#,##0.00;($#,##0.00)"), new DecimalFormat("##0.0E0")};
    public static final f1 S = new f1();
    public static final f1 T = new f1();
    protected static final g1 U = new g1();
    protected static final g1 V = new g1();
    private k.z.e A;
    private k.z.e B;
    private k.z.k C;
    private int D;
    private int E;
    private i0 F;
    private b0 G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private n0 L;
    private f1 M;
    public int c;
    private int d;
    private g1 e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private DateFormat f2021h;

    /* renamed from: i, reason: collision with root package name */
    private NumberFormat f2022i;

    /* renamed from: j, reason: collision with root package name */
    private byte f2023j;

    /* renamed from: k, reason: collision with root package name */
    private int f2024k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2025l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2026m;

    /* renamed from: n, reason: collision with root package name */
    private k.z.a f2027n;

    /* renamed from: o, reason: collision with root package name */
    private k.z.o f2028o;
    private k.z.g p;
    private boolean q;
    private int r;
    private boolean s;
    private k.z.c t;
    private k.z.c u;
    private k.z.c v;
    private k.z.c w;
    private k.z.e x;
    private k.z.e y;
    private k.z.e z;

    public h1(f2 f2Var, k.w wVar, f1 f1Var) {
        super(f2Var);
        this.M = f1Var;
        byte[] bArrC = x().c();
        this.f2024k = s0.c(bArrC[0], bArrC[1]);
        this.c = s0.c(bArrC[2], bArrC[3]);
        this.f = false;
        this.g = false;
        int i2 = 0;
        while (true) {
            int[] iArr = O;
            if (i2 >= iArr.length || this.f) {
                break;
            }
            if (this.c == iArr[i2]) {
                this.f = true;
                this.f2021h = P[i2];
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            int[] iArr2 = Q;
            if (i3 >= iArr2.length || this.g) {
                break;
            }
            if (this.c == iArr2[i3]) {
                this.g = true;
                DecimalFormat decimalFormat = (DecimalFormat) R[i3].clone();
                decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(wVar.n()));
                this.f2022i = decimalFormat;
            }
            i3++;
        }
        int iC = s0.c(bArrC[4], bArrC[5]);
        int i4 = (65520 & iC) >> 4;
        this.d = i4;
        g1 g1Var = (iC & 4) == 0 ? U : V;
        this.e = g1Var;
        this.f2025l = (iC & 1) != 0;
        this.f2026m = (iC & 2) != 0;
        if (g1Var == U && (i4 & 4095) == 4095) {
            this.d = 0;
            N.f("Invalid parent format found - ignoring");
        }
        this.H = false;
        this.I = true;
        this.J = false;
        this.K = false;
    }

    private void L() {
        int i2 = this.c;
        h[] hVarArr = h.b;
        if (i2 >= hVarArr.length || hVarArr[i2] == null) {
            this.L.e(i2);
        } else {
            h hVar = hVarArr[i2];
        }
        this.F = this.L.d().b(this.f2024k);
        byte[] bArrC = x().c();
        int iC = s0.c(bArrC[4], bArrC[5]);
        int i3 = (65520 & iC) >> 4;
        this.d = i3;
        g1 g1Var = (iC & 4) == 0 ? U : V;
        this.e = g1Var;
        this.f2025l = (iC & 1) != 0;
        this.f2026m = (iC & 2) != 0;
        if (g1Var == U && (i3 & 4095) == 4095) {
            this.d = 0;
            N.f("Invalid parent format found - ignoring");
        }
        int iC2 = s0.c(bArrC[6], bArrC[7]);
        if ((iC2 & 8) != 0) {
            this.q = true;
        }
        this.f2027n = k.z.a.a(iC2 & 7);
        this.f2028o = k.z.o.a((iC2 >> 4) & 7);
        this.p = k.z.g.a((iC2 >> 8) & 255);
        int iC3 = s0.c(bArrC[8], bArrC[9]);
        this.r = iC3 & 15;
        this.s = (iC3 & 16) != 0;
        f1 f1Var = this.M;
        f1 f1Var2 = S;
        if (f1Var == f1Var2) {
            this.f2023j = bArrC[9];
        }
        int iC4 = s0.c(bArrC[10], bArrC[11]);
        this.t = k.z.c.b(iC4 & 7);
        this.u = k.z.c.b((iC4 >> 4) & 7);
        this.v = k.z.c.b((iC4 >> 8) & 7);
        this.w = k.z.c.b((iC4 >> 12) & 7);
        int iC5 = s0.c(bArrC[12], bArrC[13]);
        this.x = k.z.e.a(iC5 & 127);
        this.y = k.z.e.a((iC5 & 16256) >> 7);
        int iC6 = s0.c(bArrC[14], bArrC[15]);
        this.z = k.z.e.a(iC6 & 127);
        this.A = k.z.e.a((iC6 & 16256) >> 7);
        if (this.M == f1Var2) {
            this.C = k.z.k.a((s0.c(bArrC[16], bArrC[17]) & 64512) >> 10);
            k.z.e eVarA = k.z.e.a(s0.c(bArrC[18], bArrC[19]) & 63);
            this.B = eVarA;
            if (eVarA == k.z.e.c || eVarA == k.z.e.e) {
                this.B = k.z.e.f;
            }
        } else {
            this.C = k.z.k.c;
            this.B = k.z.e.f;
        }
        this.J = true;
    }

    public k.z.e A(k.z.b bVar) {
        if (bVar == k.z.b.a || bVar == k.z.b.b) {
            return k.z.e.g;
        }
        if (!this.J) {
            L();
        }
        return bVar == k.z.b.e ? this.x : bVar == k.z.b.f ? this.y : bVar == k.z.b.c ? this.z : bVar == k.z.b.d ? this.A : k.z.e.d;
    }

    public k.z.c B(k.z.b bVar) {
        if (bVar == k.z.b.a || bVar == k.z.b.b) {
            return k.z.c.d;
        }
        if (!this.J) {
            L();
        }
        return bVar == k.z.b.e ? this.t : bVar == k.z.b.f ? this.u : bVar == k.z.b.c ? this.v : bVar == k.z.b.d ? this.w : k.z.c.d;
    }

    public DateFormat C() {
        return this.f2021h;
    }

    public int D() {
        return this.f2024k;
    }

    public int E() {
        return this.c;
    }

    protected final boolean F() {
        return this.f2026m;
    }

    protected final boolean G() {
        return this.f2025l;
    }

    public NumberFormat H() {
        return this.f2022i;
    }

    public final int I() {
        return this.E;
    }

    public final boolean J() {
        if (!this.J) {
            L();
        }
        k.z.c cVar = this.t;
        k.z.c cVar2 = k.z.c.d;
        return (cVar == cVar2 && this.u == cVar2 && this.v == cVar2 && this.w == cVar2) ? false : true;
    }

    public final void K(int i2, n0 n0Var, j0 j0Var) throws u0 {
        this.E = i2;
        this.L = n0Var;
        if (this.I || this.K) {
            this.H = true;
            return;
        }
        if (!this.F.isInitialized()) {
            j0Var.a(this.F);
        }
        if (!this.G.isInitialized()) {
            n0Var.a(this.G);
        }
        this.f2024k = this.F.A();
        this.c = this.G.m();
        this.H = true;
    }

    public boolean M() {
        return this.f;
    }

    public boolean N() {
        return this.g;
    }

    public final boolean O() {
        return this.I;
    }

    void P(r0 r0Var) {
        this.E = r0Var.a(this.E);
        if (this.e == U) {
            this.d = r0Var.a(this.d);
        }
    }

    public void Q(i0 i0Var) {
        this.F = i0Var;
    }

    void R(int i2) {
        this.f2024k = i2;
    }

    void S(int i2) {
        this.c = i2;
    }

    protected void T(k.z.b bVar, k.z.c cVar, k.z.e eVar) {
        k.y.a.a(!this.H);
        if (eVar == k.z.e.d || eVar == k.z.e.c) {
            eVar = k.z.e.g;
        }
        if (bVar == k.z.b.e) {
            this.t = cVar;
            this.x = eVar;
        } else if (bVar == k.z.b.f) {
            this.u = cVar;
            this.y = eVar;
        } else if (bVar == k.z.b.c) {
            this.v = cVar;
            this.z = eVar;
        } else if (bVar == k.z.b.d) {
            this.w = cVar;
            this.A = eVar;
        }
        this.f2023j = (byte) (this.f2023j | 32);
    }

    protected void U(g1 g1Var, int i2) {
        this.e = g1Var;
        this.d = i2;
    }

    public final void V() {
        if (this.H) {
            N.f("A default format has been initialized");
        }
        this.H = false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        if (!this.J) {
            L();
        }
        if (!h1Var.J) {
            h1Var.L();
        }
        if (this.e == h1Var.e && this.d == h1Var.d && this.f2025l == h1Var.f2025l && this.f2026m == h1Var.f2026m && this.f2023j == h1Var.f2023j && this.f2027n == h1Var.f2027n && this.f2028o == h1Var.f2028o && this.p == h1Var.p && this.q == h1Var.q && this.s == h1Var.s && this.r == h1Var.r && this.t == h1Var.t && this.u == h1Var.u && this.v == h1Var.v && this.w == h1Var.w && this.x == h1Var.x && this.y == h1Var.y && this.z == h1Var.z && this.A == h1Var.A && this.B == h1Var.B && this.C == h1Var.C) {
            if (this.H && h1Var.H) {
                if (this.f2024k != h1Var.f2024k || this.c != h1Var.c) {
                    return false;
                }
            } else if (!this.F.equals(h1Var.F) || !this.G.equals(h1Var.G)) {
            }
            return true;
        }
        return false;
    }

    @Override // k.z.d
    public k.z.f getFont() {
        if (!this.J) {
            L();
        }
        return this.F;
    }

    public int hashCode() {
        if (!this.J) {
            L();
        }
        int i2 = ((((((629 + (this.f2026m ? 1 : 0)) * 37) + (this.f2025l ? 1 : 0)) * 37) + (this.q ? 1 : 0)) * 37) + (this.s ? 1 : 0);
        g1 g1Var = this.e;
        if (g1Var == U) {
            i2 = (i2 * 37) + 1;
        } else if (g1Var == V) {
            i2 = (i2 * 37) + 2;
        }
        return (37 * ((((((((((((((((((((((((((((((i2 * 37) + (this.f2027n.b() + 1)) * 37) + (this.f2028o.b() + 1)) * 37) + this.p.b()) ^ this.t.a().hashCode()) ^ this.u.a().hashCode()) ^ this.v.a().hashCode()) ^ this.w.a().hashCode()) * 37) + this.x.b()) * 37) + this.y.b()) * 37) + this.z.b()) * 37) + this.A.b()) * 37) + this.B.b()) * 37) + this.C.b() + 1) * 37) + this.f2023j) * 37) + this.d) * 37) + this.f2024k) * 37) + this.c)) + this.r;
    }

    public final boolean isInitialized() {
        return this.H;
    }

    @Override // k.x.c1
    public byte[] y() {
        if (!this.J) {
            L();
        }
        byte[] bArr = new byte[20];
        s0.f(this.f2024k, bArr, 0);
        s0.f(this.c, bArr, 2);
        int i2 = G() ? 1 : 0;
        if (F()) {
            i2 |= 2;
        }
        if (this.e == V) {
            i2 |= 4;
            this.d = 65535;
        }
        s0.f((this.d << 4) | i2, bArr, 4);
        int iB = this.f2027n.b();
        if (this.q) {
            iB |= 8;
        }
        s0.f(iB | (this.f2028o.b() << 4) | (this.p.b() << 8), bArr, 6);
        bArr[9] = 16;
        int iC = (this.u.c() << 4) | this.t.c() | (this.v.c() << 8) | (this.w.c() << 12);
        s0.f(iC, bArr, 10);
        if (iC != 0) {
            int iB2 = (((byte) this.x.b()) & 127) | ((((byte) this.y.b()) & 127) << 7);
            int iB3 = (((byte) this.z.b()) & 127) | ((((byte) this.A.b()) & 127) << 7);
            s0.f(iB2, bArr, 12);
            s0.f(iB3, bArr, 14);
        }
        s0.f(this.C.b() << 10, bArr, 16);
        s0.f(this.B.b() | XMLEvent.ENTITY_REFERENCE, bArr, 18);
        int i3 = this.D | (this.r & 15);
        this.D = i3;
        if (this.s) {
            this.D = 16 | i3;
        } else {
            this.D = i3 & 239;
        }
        bArr[8] = (byte) this.D;
        if (this.M == S) {
            bArr[9] = this.f2023j;
        }
        return bArr;
    }

    public h1(i0 i0Var, b0 b0Var) {
        super(z0.I);
        this.H = false;
        this.f2025l = true;
        this.f2026m = false;
        this.f2027n = k.z.a.c;
        this.f2028o = k.z.o.c;
        this.p = k.z.g.c;
        this.q = false;
        k.z.c cVar = k.z.c.d;
        this.t = cVar;
        this.u = cVar;
        this.v = cVar;
        this.w = cVar;
        k.z.e eVar = k.z.e.f2184l;
        this.x = eVar;
        this.y = eVar;
        this.z = eVar;
        this.A = eVar;
        this.C = k.z.k.c;
        this.B = k.z.e.f;
        this.r = 0;
        this.s = false;
        this.f2023j = (byte) 124;
        this.d = 0;
        this.e = null;
        this.F = i0Var;
        this.G = b0Var;
        this.M = S;
        this.I = false;
        this.K = false;
        this.J = true;
        k.y.a.a(i0Var != null);
        k.y.a.a(this.G != null);
    }

    protected h1(h1 h1Var) {
        super(z0.I);
        this.H = false;
        this.f2025l = h1Var.f2025l;
        this.f2026m = h1Var.f2026m;
        this.f2027n = h1Var.f2027n;
        this.f2028o = h1Var.f2028o;
        this.p = h1Var.p;
        this.q = h1Var.q;
        this.t = h1Var.t;
        this.u = h1Var.u;
        this.v = h1Var.v;
        this.w = h1Var.w;
        this.x = h1Var.x;
        this.y = h1Var.y;
        this.z = h1Var.z;
        this.A = h1Var.A;
        this.C = h1Var.C;
        this.e = h1Var.e;
        this.r = h1Var.r;
        this.s = h1Var.s;
        this.d = h1Var.d;
        this.B = h1Var.B;
        this.F = h1Var.F;
        this.G = h1Var.G;
        this.f2024k = h1Var.f2024k;
        this.c = h1Var.c;
        this.J = h1Var.J;
        this.M = S;
        this.I = false;
        this.K = true;
    }
}
