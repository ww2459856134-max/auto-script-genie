package i.e.a.j;

/* loaded from: classes.dex */
public abstract class o extends i.e.a.l.o {
    private static i.e.a.l.o g;

    /* renamed from: h, reason: collision with root package name */
    private static i.e.a.l.o f1601h;

    /* renamed from: i, reason: collision with root package name */
    private static final i.e.a.l.o f1602i;

    static {
        i.e.a.l.o oVar = new i.e.a.l.o();
        f1602i = oVar;
        j(oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
    }

    protected static void g(int[] iArr) {
        for (int i2 = 128; i2 <= 255; i2++) {
            iArr[i2] = 1;
        }
    }

    private static void h(int[] iArr) {
        for (int i2 = 128; i2 < 256; i2++) {
            iArr[i2] = (i2 & 224) == 192 ? 5 : (i2 & 240) == 224 ? 6 : (i2 & 248) == 240 ? 7 : 1;
        }
    }

    private static void i(int[] iArr) {
        for (int i2 = 128; i2 < 256; i2++) {
            iArr[i2] = (i2 & 224) == 192 ? 5 : (i2 & 240) == 224 ? 6 : (i2 & 248) == 240 ? 7 : 1;
        }
    }

    public static void j(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        i.e.a.l.o.d(iArr);
        i(iArr);
        i.e.a.l.o.a(iArr2);
        i(iArr2);
        i.e.a.l.o.c(iArr3);
        h(iArr3);
        i.e.a.l.o.b(iArr4);
        i(iArr4);
        iArr5[93] = 11;
        iArr5[62] = 17;
        i.e.a.l.o.d(iArr5);
        i(iArr5);
        iArr5[38] = 0;
        iArr5[60] = 0;
        iArr5[93] = 11;
        iArr5[63] = 12;
        iArr5[45] = 13;
    }

    public static final synchronized i.e.a.l.o k() {
        if (g == null) {
            i.e.a.l.o oVar = new i.e.a.l.o();
            g = oVar;
            i.e.a.l.o.f(oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
            g(g.a);
            g(g.b);
            g(g.c);
            g(g.d);
            g(g.e);
        }
        return g;
    }

    public static final synchronized i.e.a.l.o l() {
        if (f1601h == null) {
            i.e.a.l.o oVar = new i.e.a.l.o();
            f1601h = oVar;
            i.e.a.l.o.f(oVar.a, oVar.b, oVar.c, oVar.d, oVar.e);
        }
        return f1601h;
    }

    public static final i.e.a.l.o m() {
        return f1602i;
    }
}
