package k.x.i1;

import k.a0.a.f2;
import k.x.c1;
import k.x.z0;

/* loaded from: classes.dex */
public class h0 extends c1 {
    private static final k.y.c f = k.y.c.b(h0.class);
    public static final g0 g;

    /* renamed from: h, reason: collision with root package name */
    public static final g0 f2066h;

    /* renamed from: i, reason: collision with root package name */
    public static final g0 f2067i;

    /* renamed from: j, reason: collision with root package name */
    public static final g0 f2068j;

    /* renamed from: k, reason: collision with root package name */
    public static final g0 f2069k;

    /* renamed from: l, reason: collision with root package name */
    public static final g0 f2070l;

    /* renamed from: m, reason: collision with root package name */
    public static final g0 f2071m;

    /* renamed from: n, reason: collision with root package name */
    public static final g0 f2072n;
    private g0 c;
    private boolean d;
    private int e;

    static {
        new g0(0, "Group");
        new g0(1, "Line");
        new g0(2, "Rectangle");
        new g0(3, "Oval");
        new g0(4, "Arc");
        g = new g0(5, "Chart");
        f2066h = new g0(6, "Text");
        f2067i = new g0(7, "Button");
        f2068j = new g0(8, "Picture");
        new g0(9, "Polygon");
        f2069k = new g0(11, "Checkbox");
        new g0(12, "Option");
        new g0(13, "Edit Box");
        new g0(14, "Label");
        new g0(15, "Dialogue Box");
        new g0(16, "Spin Box");
        new g0(17, "Scrollbar");
        new g0(18, "List Box");
        new g0(19, "Group Box");
        f2070l = new g0(20, "Combo Box");
        new g0(30, "MS Office Drawing");
        new g0(20, "Form Combo Box");
        f2071m = new g0(25, "Excel Note");
        f2072n = new g0(255, "Unknown");
    }

    public h0(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = f2Var.c();
        int iC = k.x.s0.c(bArrC[4], bArrC[5]);
        this.d = true;
        g0 g0VarA = g0.a(iC);
        this.c = g0VarA;
        if (g0VarA == f2072n) {
            f.f("unknown object type code " + iC);
        }
        this.e = k.x.s0.c(bArrC[6], bArrC[7]);
    }

    private byte[] A() {
        byte[] bArr = new byte[70];
        k.x.s0.f(21, bArr, 0);
        k.x.s0.f(18, bArr, 2);
        k.x.s0.f(this.c.a, bArr, 4);
        k.x.s0.f(this.e, bArr, 6);
        k.x.s0.f(0, bArr, 8);
        k.x.s0.f(12, bArr, 22);
        k.x.s0.f(20, bArr, 24);
        bArr[36] = 1;
        bArr[38] = 4;
        bArr[42] = 16;
        bArr[46] = 19;
        bArr[48] = -18;
        bArr[49] = 31;
        bArr[52] = 4;
        bArr[56] = 1;
        bArr[57] = 6;
        bArr[60] = 2;
        bArr[62] = 8;
        bArr[64] = 64;
        k.x.s0.f(0, bArr, 66);
        k.x.s0.f(0, bArr, 68);
        return bArr;
    }

    private byte[] B() {
        byte[] bArr = new byte[52];
        k.x.s0.f(21, bArr, 0);
        k.x.s0.f(18, bArr, 2);
        k.x.s0.f(this.c.a, bArr, 4);
        k.x.s0.f(this.e, bArr, 6);
        k.x.s0.f(16401, bArr, 8);
        k.x.s0.f(13, bArr, 22);
        k.x.s0.f(22, bArr, 24);
        k.x.s0.f(0, bArr, 48);
        k.x.s0.f(0, bArr, 50);
        return bArr;
    }

    private byte[] D() {
        byte[] bArr = new byte[38];
        k.x.s0.f(21, bArr, 0);
        k.x.s0.f(18, bArr, 2);
        k.x.s0.f(this.c.a, bArr, 4);
        k.x.s0.f(this.e, bArr, 6);
        k.x.s0.f(24593, bArr, 8);
        k.x.s0.f(7, bArr, 22);
        k.x.s0.f(2, bArr, 24);
        k.x.s0.f(65535, bArr, 26);
        k.x.s0.f(8, bArr, 28);
        k.x.s0.f(2, bArr, 30);
        k.x.s0.f(1, bArr, 32);
        k.x.s0.f(0, bArr, 34);
        k.x.s0.f(0, bArr, 36);
        return bArr;
    }

    public int C() {
        return this.e;
    }

    public g0 E() {
        return this.c;
    }

    @Override // k.x.w0
    public f2 x() {
        return super.x();
    }

    @Override // k.x.c1
    public byte[] y() {
        if (this.d) {
            return x().c();
        }
        g0 g0Var = this.c;
        if (g0Var == f2068j || g0Var == g) {
            return D();
        }
        if (g0Var == f2071m) {
            return B();
        }
        if (g0Var == f2070l) {
            return A();
        }
        k.y.a.a(false);
        return null;
    }

    h0(int i2, g0 g0Var) {
        super(z0.O0);
        this.e = i2;
        this.c = g0Var;
    }
}
