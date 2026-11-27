package i.e.a.k;

/* loaded from: classes.dex */
public abstract class i extends i.e.a.l.o {
    private static i.e.a.l.o g;

    /* renamed from: h, reason: collision with root package name */
    private static i.e.a.l.o f1628h;

    /* renamed from: i, reason: collision with root package name */
    private static final i.e.a.l.o f1629i;

    static {
        i.e.a.l.o oVar = new i.e.a.l.o(2048);
        f1629i = oVar;
        i.e.a.l.o.f(oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
        n(oVar.a);
        n(oVar.b);
        n(oVar.d);
        n(oVar.e);
        p(oVar.c);
        l(oVar.b);
    }

    public static final i.e.a.l.o g() {
        if (g == null) {
            i.e.a.l.o oVar = new i.e.a.l.o(2048);
            g = oVar;
            i.e.a.l.o.f(oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
            k(g.a);
            k(g.b);
            k(g.d);
            k(g.e);
            j(g.c);
            l(g.b);
        }
        return g;
    }

    public static final i.e.a.l.o h() {
        if (f1628h == null) {
            i.e.a.l.o oVar = new i.e.a.l.o(2048);
            f1628h = oVar;
            i.e.a.l.o.f(oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
            m(f1628h.a);
            m(f1628h.b);
            m(f1628h.d);
            m(f1628h.e);
            l(f1628h.b);
        }
        return f1628h;
    }

    public static final i.e.a.l.o i() {
        return f1629i;
    }

    private static void j(int[] iArr) {
        o(iArr);
        int length = iArr.length;
        for (int i2 = 128; i2 < length; i2++) {
            int i3 = iArr[i2];
            if (i3 == 2 || i3 == 3) {
                iArr[i2] = 4;
            }
        }
    }

    private static void k(int[] iArr) {
        q(iArr, 127);
    }

    private static void l(int[] iArr) {
        iArr[9] = 4;
    }

    private static void m(int[] iArr) {
        for (int i2 = 127; i2 <= 159; i2++) {
            iArr[i2] = 4;
        }
        q(iArr, 255);
    }

    private static void n(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 128; i2 < length; i2++) {
            if (iArr[i2] == 0) {
                iArr[i2] = 5;
            }
        }
    }

    private static void o(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 256; i2 < length; i2++) {
            int i3 = iArr[i2];
            if (i3 == 2 || i3 == 3) {
                iArr[i2] = 4;
            }
        }
    }

    private static void p(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 128; i2 < length; i2++) {
            if (i.e.a.l.p.e(i2)) {
                iArr[i2] = 6;
            } else if (i.e.a.l.p.d(i2)) {
                iArr[i2] = 5;
            } else {
                iArr[i2] = 0;
            }
        }
    }

    private static void q(int[] iArr, int i2) {
        int length = iArr.length;
        for (int i3 = i2 + 1; i3 < length; i3++) {
            if (iArr[i3] == 0) {
                iArr[i3] = 4;
            }
        }
    }
}
