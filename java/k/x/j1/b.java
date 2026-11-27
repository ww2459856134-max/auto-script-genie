package k.x.j1;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class b extends p0 {
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2106h;

    /* renamed from: i, reason: collision with root package name */
    private int f2107i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2108j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2109k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2110l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2111m;

    /* renamed from: n, reason: collision with root package name */
    private t f2112n;

    static {
        k.y.c.b(b.class);
    }

    b(t tVar) {
        this.f2112n = tVar;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[11];
        bArr[0] = i1.r.a();
        k.x.s0.f(this.e, bArr, 1);
        k.x.s0.f(this.g, bArr, 3);
        k.x.s0.f(this.f2107i, bArr, 5);
        int i2 = this.f;
        if (this.f2109k) {
            i2 |= 32768;
        }
        if (this.f2108j) {
            i2 |= 16384;
        }
        k.x.s0.f(i2, bArr, 7);
        int i3 = this.f2106h;
        if (this.f2111m) {
            i3 |= 32768;
        }
        if (this.f2110l) {
            i3 |= 16384;
        }
        k.x.s0.f(i3, bArr, 9);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        k.x.m.b(this.e, this.f, this.g, this.f2112n, stringBuffer);
        stringBuffer.append(NameUtil.COLON);
        k.x.m.c(this.f2106h, this.f2107i, stringBuffer);
    }

    int j() {
        return this.f;
    }

    int k() {
        return this.f2106h;
    }

    public int l(byte[] bArr, int i2) {
        this.e = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        this.g = k.x.s0.c(bArr[i2 + 2], bArr[i2 + 3]);
        this.f2107i = k.x.s0.c(bArr[i2 + 4], bArr[i2 + 5]);
        int iC = k.x.s0.c(bArr[i2 + 6], bArr[i2 + 7]);
        this.f = iC & 255;
        this.f2108j = (iC & 16384) != 0;
        this.f2109k = (iC & 32768) != 0;
        int iC2 = k.x.s0.c(bArr[i2 + 8], bArr[i2 + 9]);
        this.f2106h = iC2 & 255;
        this.f2110l = (iC2 & 16384) != 0;
        this.f2111m = (iC2 & 32768) != 0;
        return 10;
    }

    protected void m(int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = i2;
        this.f = i3;
        this.f2106h = i4;
        this.g = i5;
        this.f2107i = i6;
        this.f2108j = z;
        this.f2110l = z2;
        this.f2109k = z3;
        this.f2111m = z4;
    }

    b(String str, t tVar) throws w {
        this.f2112n = tVar;
        int iLastIndexOf = str.lastIndexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        k.y.a.a(iLastIndexOf != -1);
        String strSubstring = str.substring(iLastIndexOf + 1);
        int iIndexOf = str.indexOf(33);
        String strSubstring2 = str.substring(iIndexOf + 1, iLastIndexOf);
        this.f = k.x.m.f(strSubstring2);
        this.g = k.x.m.i(strSubstring2);
        String strSubstring3 = str.substring(0, iIndexOf);
        if (strSubstring3.charAt(0) == '\'' && strSubstring3.charAt(strSubstring3.length() - 1) == '\'') {
            strSubstring3 = strSubstring3.substring(1, strSubstring3.length() - 1);
        }
        int iC = tVar.c(strSubstring3);
        this.e = iC;
        if (iC >= 0) {
            this.f2106h = k.x.m.f(strSubstring);
            this.f2107i = k.x.m.i(strSubstring);
            this.f2108j = true;
            this.f2109k = true;
            this.f2110l = true;
            this.f2111m = true;
            return;
        }
        throw new w(w.f2147h, strSubstring3);
    }
}
