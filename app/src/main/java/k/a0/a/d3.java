package k.a0.a;

/* loaded from: classes.dex */
public class d3 extends k.x.w0 {
    public static final c3 g;

    /* renamed from: h, reason: collision with root package name */
    public static final c3 f1796h;

    /* renamed from: i, reason: collision with root package name */
    public static final c3 f1797i;

    /* renamed from: j, reason: collision with root package name */
    public static final c3 f1798j;

    /* renamed from: k, reason: collision with root package name */
    public static final c3 f1799k;
    private c3 c;
    private int d;
    private String e;
    private String[] f;

    static {
        k.y.c.b(d3.class);
        g = new c3();
        f1796h = new c3();
        f1797i = new c3();
        f1798j = new c3();
        f1799k = new c3();
    }

    d3(f2 f2Var, k.w wVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        if (bArrC.length == 4) {
            if (bArrC[2] == 1 && bArrC[3] == 4) {
                this.c = g;
            } else if (bArrC[2] == 1 && bArrC[3] == 58) {
                this.c = f1797i;
            } else {
                this.c = f1799k;
            }
        } else if (bArrC[0] == 0 && bArrC[1] == 0) {
            this.c = f1798j;
        } else {
            this.c = f1796h;
        }
        if (this.c == g) {
            this.d = k.x.s0.c(bArrC[0], bArrC[1]);
        }
        if (this.c == f1796h) {
            E(bArrC, wVar);
        }
    }

    private String D(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = (i2 * 2) + i3;
        while (i3 < i4) {
            char c = (char) k.x.s0.c(bArr[i3], bArr[i3 + 1]);
            if (c == 1) {
                i3 += 2;
                stringBuffer.append((char) k.x.s0.c(bArr[i3], bArr[i3 + 1]));
                stringBuffer.append(":\\\\");
            } else if (c == 2) {
                stringBuffer.append('\\');
            } else if (c == 3) {
                stringBuffer.append('\\');
            } else if (c == 4) {
                stringBuffer.append("..\\");
            } else {
                stringBuffer.append(c);
            }
            i3 += 2;
        }
        return stringBuffer.toString();
    }

    private void E(byte[] bArr, k.w wVar) {
        int i2;
        this.d = k.x.s0.c(bArr[0], bArr[1]);
        int iC = k.x.s0.c(bArr[2], bArr[3]) - 1;
        int i3 = 6;
        if (bArr[4] != 0) {
            i3 = 7;
            if (k.x.s0.c(bArr[5], bArr[6]) == 0) {
                this.e = k.x.y0.g(bArr, iC, 7);
            } else {
                this.e = D(bArr, iC, 7);
            }
            iC *= 2;
        } else if (bArr[5] == 0) {
            this.e = k.x.y0.d(bArr, iC, 6, wVar);
        } else {
            this.e = y(bArr, iC, 6);
        }
        int i4 = iC + i3;
        this.f = new String[this.d];
        for (int i5 = 0; i5 < this.f.length; i5++) {
            int iC2 = k.x.s0.c(bArr[i4], bArr[i4 + 1]);
            int i6 = i4 + 2;
            if (bArr[i6] == 0) {
                this.f[i5] = k.x.y0.d(bArr, iC2, i4 + 3, wVar);
                i2 = iC2 + 3;
            } else if (bArr[i6] == 1) {
                this.f[i5] = k.x.y0.g(bArr, iC2, i4 + 3);
                i2 = (iC2 * 2) + 3;
            }
            i4 += i2;
        }
    }

    private String y(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = i2 + i3;
        while (i3 < i4) {
            char c = (char) bArr[i3];
            if (c == 1) {
                i3++;
                stringBuffer.append((char) bArr[i3]);
                stringBuffer.append(":\\\\");
            } else if (c == 2) {
                stringBuffer.append('\\');
            } else if (c == 3) {
                stringBuffer.append('\\');
            } else if (c == 4) {
                stringBuffer.append("..\\");
            } else {
                stringBuffer.append(c);
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    public int A() {
        return this.d;
    }

    public String B(int i2) {
        return this.f[i2];
    }

    public c3 C() {
        return this.c;
    }

    public String z() {
        return this.e;
    }
}
