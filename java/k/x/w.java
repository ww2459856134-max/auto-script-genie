package k.x;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.text.DecimalFormat;
import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes.dex */
public class w {
    public static final t A;
    public static final t B;
    public static final t C;
    public static final t D;
    public static final t E;
    private static k.y.c w = k.y.c.b(w.class);
    public static final t x;
    public static final t y;
    public static final t z;
    private u a;
    private v b;
    private t c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2162h;

    /* renamed from: i, reason: collision with root package name */
    private String f2163i;

    /* renamed from: j, reason: collision with root package name */
    private String f2164j;

    /* renamed from: k, reason: collision with root package name */
    private String f2165k;

    /* renamed from: l, reason: collision with root package name */
    private String f2166l;

    /* renamed from: m, reason: collision with root package name */
    private k.x.j1.x f2167m;

    /* renamed from: n, reason: collision with root package name */
    private String f2168n;

    /* renamed from: o, reason: collision with root package name */
    private k.x.j1.x f2169o;
    private String p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;

    static {
        new u(0, "any");
        new u(1, XmlErrorCodes.INT);
        new u(2, "dec");
        new u(3, XmlErrorCodes.LIST);
        new u(4, XmlErrorCodes.DATE);
        new u(5, "time");
        new u(6, "strlen");
        new u(7, "form");
        new v(0);
        new v(1);
        new v(2);
        x = new t(0, "{0} <= x <= {1}");
        y = new t(1, "!({0} <= x <= {1}");
        z = new t(2, "x == {0}");
        A = new t(3, "x != {0}");
        B = new t(4, "x > {0}");
        C = new t(5, "x < {0}");
        D = new t(6, "x >= {0}");
        E = new t(7, "x <= {0}");
        new DecimalFormat("#.#");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0177 A[Catch: w -> 0x01ad, TryCatch #0 {w -> 0x01ad, blocks: (B:66:0x016e, B:68:0x0177, B:70:0x0193), top: B:75:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0193 A[Catch: w -> 0x01ad, TRY_LEAVE, TryCatch #0 {w -> 0x01ad, blocks: (B:66:0x016e, B:68:0x0177, B:70:0x0193), top: B:75:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w(byte[] bArr, k.x.j1.t tVar, a1 a1Var, k.w wVar) {
        int i2;
        int iC;
        int i3;
        int iC2;
        int i4;
        int iC3;
        int iC4;
        int i5;
        boolean z2 = true;
        k.y.a.a(a1Var != null);
        this.v = false;
        int iD = s0.d(bArr[0], bArr[1], bArr[2], bArr[3]);
        this.a = u.a(iD & 15);
        this.b = v.a((iD & 112) >> 4);
        this.c = t.a((15728640 & iD) >> 20);
        this.d = (iD & 128) != 0;
        this.e = (iD & 256) != 0;
        this.f = (iD & 512) != 0;
        this.g = (262144 & iD) != 0;
        this.f2162h = (iD & 524288) != 0;
        int iC5 = s0.c(bArr[4], bArr[5]);
        int i6 = 7;
        if (iC5 > 0 && bArr[6] == 0) {
            this.f2163i = y0.d(bArr, iC5, 7, wVar);
            i6 = iC5 + 3 + 4;
        } else if (iC5 > 0) {
            this.f2163i = y0.g(bArr, iC5, 7);
            i6 = 4 + (iC5 * 2) + 3;
        }
        int iC6 = s0.c(bArr[i6], bArr[i6 + 1]);
        try {
            if (iC6 > 0 && bArr[i6 + 2] == 0) {
                this.f2164j = y0.d(bArr, iC6, i6 + 3, wVar);
            } else if (iC6 > 0) {
                this.f2164j = y0.g(bArr, iC6, i6 + 3);
                iC6 *= 2;
            } else {
                i2 = i6 + 3;
                iC = s0.c(bArr[i2], bArr[i2 + 1]);
                if (iC <= 0 && bArr[i2 + 2] == 0) {
                    this.f2165k = y0.d(bArr, iC, i2 + 3, wVar);
                } else if (iC <= 0) {
                    this.f2165k = y0.g(bArr, iC, i2 + 3);
                    iC *= 2;
                } else {
                    i3 = i2 + 3;
                    iC2 = s0.c(bArr[i3], bArr[i3 + 1]);
                    if (iC2 > 0 && bArr[i3 + 2] == 0) {
                        this.f2166l = y0.d(bArr, iC2, i3 + 3, wVar);
                    } else {
                        if (iC2 > 0) {
                            i4 = i3 + 3;
                            iC3 = s0.c(bArr[i4], bArr[i4 + 1]);
                            int i7 = i4 + 4;
                            int i8 = i7 + iC3;
                            iC4 = s0.c(bArr[i8], bArr[i8 + 1]);
                            int i9 = i8 + 4;
                            int i10 = i9 + iC4 + 2;
                            this.r = s0.c(bArr[i10], bArr[i10 + 1]);
                            int i11 = i10 + 2;
                            this.t = s0.c(bArr[i11], bArr[i11 + 1]);
                            int i12 = i11 + 2;
                            this.q = s0.c(bArr[i12], bArr[i12 + 1]);
                            int i13 = i12 + 2;
                            int iC7 = s0.c(bArr[i13], bArr[i13 + 1]);
                            this.s = iC7;
                            i5 = this.r;
                            if (i5 == this.t && this.q == iC7) {
                                z2 = false;
                            }
                            this.u = z2;
                            d0 d0Var = new d0(this.q, i5);
                            if (iC3 != 0) {
                                byte[] bArr2 = new byte[iC3];
                                System.arraycopy(bArr, i7, bArr2, 0, iC3);
                                k.x.j1.x xVar = new k.x.j1.x(bArr2, d0Var, tVar, a1Var, wVar, k.x.j1.s0.b);
                                this.f2167m = xVar;
                                xVar.c();
                            }
                            if (iC4 == 0) {
                                byte[] bArr3 = new byte[iC4];
                                System.arraycopy(bArr, i9, bArr3, 0, iC4);
                                k.x.j1.x xVar2 = new k.x.j1.x(bArr3, d0Var, tVar, a1Var, wVar, k.x.j1.s0.b);
                                this.f2169o = xVar2;
                                xVar2.c();
                                return;
                            }
                            return;
                        }
                        this.f2166l = y0.g(bArr, iC2, i3 + 3);
                        iC2 *= 2;
                    }
                    i4 = i3 + iC2 + 3;
                    iC3 = s0.c(bArr[i4], bArr[i4 + 1]);
                    int i72 = i4 + 4;
                    int i82 = i72 + iC3;
                    iC4 = s0.c(bArr[i82], bArr[i82 + 1]);
                    int i92 = i82 + 4;
                    int i102 = i92 + iC4 + 2;
                    this.r = s0.c(bArr[i102], bArr[i102 + 1]);
                    int i112 = i102 + 2;
                    this.t = s0.c(bArr[i112], bArr[i112 + 1]);
                    int i122 = i112 + 2;
                    this.q = s0.c(bArr[i122], bArr[i122 + 1]);
                    int i132 = i122 + 2;
                    int iC72 = s0.c(bArr[i132], bArr[i132 + 1]);
                    this.s = iC72;
                    i5 = this.r;
                    if (i5 == this.t) {
                        z2 = false;
                    }
                    this.u = z2;
                    d0 d0Var2 = new d0(this.q, i5);
                    if (iC3 != 0) {
                    }
                    if (iC4 == 0) {
                    }
                }
                i3 = i2 + iC + 3;
                iC2 = s0.c(bArr[i3], bArr[i3 + 1]);
                if (iC2 > 0) {
                    if (iC2 > 0) {
                    }
                }
                iC3 = s0.c(bArr[i4], bArr[i4 + 1]);
                int i722 = i4 + 4;
                int i822 = i722 + iC3;
                iC4 = s0.c(bArr[i822], bArr[i822 + 1]);
                int i922 = i822 + 4;
                int i1022 = i922 + iC4 + 2;
                this.r = s0.c(bArr[i1022], bArr[i1022 + 1]);
                int i1122 = i1022 + 2;
                this.t = s0.c(bArr[i1122], bArr[i1122 + 1]);
                int i1222 = i1122 + 2;
                this.q = s0.c(bArr[i1222], bArr[i1222 + 1]);
                int i1322 = i1222 + 2;
                int iC722 = s0.c(bArr[i1322], bArr[i1322 + 1]);
                this.s = iC722;
                i5 = this.r;
                if (i5 == this.t) {
                }
                this.u = z2;
                d0 d0Var22 = new d0(this.q, i5);
                if (iC3 != 0) {
                }
                if (iC4 == 0) {
                }
            }
            d0 d0Var222 = new d0(this.q, i5);
            if (iC3 != 0) {
            }
            if (iC4 == 0) {
            }
        } catch (k.x.j1.w e) {
            w.f(e.getMessage() + " for cells " + m.a(this.q, this.r) + ProcessIdUtil.DEFAULT_PROCESSID + m.a(this.s, this.t));
            return;
        }
        i2 = i6 + iC6 + 3;
        iC = s0.c(bArr[i2], bArr[i2 + 1]);
        if (iC <= 0) {
            if (iC <= 0) {
            }
        }
        iC2 = s0.c(bArr[i3], bArr[i3 + 1]);
        if (iC2 > 0) {
        }
        iC3 = s0.c(bArr[i4], bArr[i4 + 1]);
        int i7222 = i4 + 4;
        int i8222 = i7222 + iC3;
        iC4 = s0.c(bArr[i8222], bArr[i8222 + 1]);
        int i9222 = i8222 + 4;
        int i10222 = i9222 + iC4 + 2;
        this.r = s0.c(bArr[i10222], bArr[i10222 + 1]);
        int i11222 = i10222 + 2;
        this.t = s0.c(bArr[i11222], bArr[i11222 + 1]);
        int i12222 = i11222 + 2;
        this.q = s0.c(bArr[i12222], bArr[i12222 + 1]);
        int i13222 = i12222 + 2;
        int iC7222 = s0.c(bArr[i13222], bArr[i13222 + 1]);
        this.s = iC7222;
        i5 = this.r;
        if (i5 == this.t) {
        }
        this.u = z2;
    }

    public boolean a() {
        return this.v;
    }

    public boolean b() {
        return this.u;
    }

    public byte[] c() {
        k.x.j1.x xVar = this.f2167m;
        byte[] bArrA = xVar != null ? xVar.a() : new byte[0];
        k.x.j1.x xVar2 = this.f2169o;
        byte[] bArrA2 = xVar2 != null ? xVar2.a() : new byte[0];
        byte[] bArr = new byte[(this.f2163i.length() * 2) + 4 + 3 + (this.f2164j.length() * 2) + 3 + (this.f2165k.length() * 2) + 3 + (this.f2166l.length() * 2) + 3 + bArrA.length + 2 + bArrA2.length + 2 + 4 + 10];
        int iB = this.a.b() | 0 | (this.b.b() << 4) | (this.c.b() << 20);
        if (this.d) {
            iB |= 128;
        }
        if (this.e) {
            iB |= 256;
        }
        if (this.f) {
            iB |= 512;
        }
        if (this.g) {
            iB |= WXMediaMessage.NATIVE_GAME__THUMB_LIMIT;
        }
        if (this.f2162h) {
            iB |= 524288;
        }
        s0.a(iB, bArr, 0);
        s0.f(this.f2163i.length(), bArr, 4);
        bArr[6] = 1;
        y0.e(this.f2163i, bArr, 7);
        int length = 7 + (this.f2163i.length() * 2);
        s0.f(this.f2164j.length(), bArr, length);
        int i2 = length + 2;
        bArr[i2] = 1;
        int i3 = i2 + 1;
        y0.e(this.f2164j, bArr, i3);
        int length2 = i3 + (this.f2164j.length() * 2);
        s0.f(this.f2165k.length(), bArr, length2);
        int i4 = length2 + 2;
        bArr[i4] = 1;
        int i5 = i4 + 1;
        y0.e(this.f2165k, bArr, i5);
        int length3 = i5 + (this.f2165k.length() * 2);
        s0.f(this.f2166l.length(), bArr, length3);
        int i6 = length3 + 2;
        bArr[i6] = 1;
        int i7 = i6 + 1;
        y0.e(this.f2166l, bArr, i7);
        int length4 = i7 + (this.f2166l.length() * 2);
        s0.f(bArrA.length, bArr, length4);
        int i8 = length4 + 4;
        System.arraycopy(bArrA, 0, bArr, i8, bArrA.length);
        int length5 = i8 + bArrA.length;
        s0.f(bArrA2.length, bArr, length5);
        int i9 = length5 + 4;
        System.arraycopy(bArrA2, 0, bArr, i9, bArrA2.length);
        int length6 = i9 + bArrA2.length;
        s0.f(1, bArr, length6);
        int i10 = length6 + 2;
        s0.f(this.r, bArr, i10);
        int i11 = i10 + 2;
        s0.f(this.t, bArr, i11);
        int i12 = i11 + 2;
        s0.f(this.q, bArr, i12);
        s0.f(this.s, bArr, i12 + 2);
        return bArr;
    }

    public int d() {
        return this.q;
    }

    public int e() {
        return this.r;
    }

    public int f() {
        return this.s;
    }

    public int g() {
        return this.t;
    }

    public void h(int i2, int i3, k.x.j1.t tVar, a1 a1Var, k.w wVar) throws k.x.j1.w {
        if (this.u) {
            return;
        }
        this.r = i3;
        this.t = i3;
        this.q = i2;
        this.s = i2;
        k.x.j1.x xVar = new k.x.j1.x(this.f2168n, tVar, a1Var, wVar, k.x.j1.s0.b);
        this.f2167m = xVar;
        xVar.c();
        if (this.p != null) {
            k.x.j1.x xVar2 = new k.x.j1.x(this.p, tVar, a1Var, wVar, k.x.j1.s0.b);
            this.f2169o = xVar2;
            xVar2.c();
        }
    }

    public w(w wVar) {
        this.v = true;
        this.a = wVar.a;
        this.b = wVar.b;
        this.c = wVar.c;
        this.d = wVar.d;
        this.e = wVar.e;
        this.f = wVar.f;
        this.g = wVar.g;
        this.f2162h = wVar.f2162h;
        this.f2163i = wVar.f2163i;
        this.f2165k = wVar.f2165k;
        this.f2164j = wVar.f2164j;
        this.f2166l = wVar.f2166l;
        this.u = wVar.u;
        this.r = wVar.r;
        this.t = wVar.t;
        this.q = wVar.q;
        this.s = wVar.s;
        String str = wVar.f2168n;
        if (str != null) {
            this.f2168n = str;
            this.p = wVar.p;
            return;
        }
        try {
            this.f2168n = wVar.f2167m.b();
            k.x.j1.x xVar = wVar.f2169o;
            this.p = xVar != null ? xVar.b() : null;
        } catch (k.x.j1.w e) {
            w.f("Cannot parse validation formula:  " + e.getMessage());
        }
    }
}
