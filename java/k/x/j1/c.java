package k.x.j1;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class c extends p0 {
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2115h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2116i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2117j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2118k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2119l;

    static {
        k.y.c.b(c.class);
    }

    c() {
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[9];
        bArr[0] = !i() ? i1.f2132o.a() : i1.f2132o.b();
        k.x.s0.f(this.f, bArr, 1);
        k.x.s0.f(this.f2115h, bArr, 3);
        int i2 = this.e;
        if (this.f2117j) {
            i2 |= 32768;
        }
        if (this.f2116i) {
            i2 |= 16384;
        }
        k.x.s0.f(i2, bArr, 5);
        int i3 = this.g;
        if (this.f2119l) {
            i3 |= 32768;
        }
        if (this.f2118k) {
            i3 |= 16384;
        }
        k.x.s0.f(i3, bArr, 7);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        k.x.m.c(this.e, this.f, stringBuffer);
        stringBuffer.append(NameUtil.COLON);
        k.x.m.c(this.g, this.f2115h, stringBuffer);
    }

    int j() {
        return this.e;
    }

    int k() {
        return this.g;
    }

    public int l(byte[] bArr, int i2) {
        this.f = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        this.f2115h = k.x.s0.c(bArr[i2 + 2], bArr[i2 + 3]);
        int iC = k.x.s0.c(bArr[i2 + 4], bArr[i2 + 5]);
        this.e = iC & 255;
        this.f2116i = (iC & 16384) != 0;
        this.f2117j = (iC & 32768) != 0;
        int iC2 = k.x.s0.c(bArr[i2 + 6], bArr[i2 + 7]);
        this.g = iC2 & 255;
        this.f2118k = (iC2 & 16384) != 0;
        this.f2119l = (iC2 & 32768) != 0;
        return 8;
    }

    protected void m(int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = i2;
        this.g = i3;
        this.f = i4;
        this.f2115h = i5;
        this.f2116i = z;
        this.f2118k = z2;
        this.f2117j = z3;
        this.f2119l = z4;
    }

    c(String str) {
        int iIndexOf = str.indexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        k.y.a.a(iIndexOf != -1);
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        this.e = k.x.m.f(strSubstring);
        this.f = k.x.m.i(strSubstring);
        this.g = k.x.m.f(strSubstring2);
        this.f2115h = k.x.m.i(strSubstring2);
        this.f2116i = k.x.m.j(strSubstring);
        this.f2117j = k.x.m.k(strSubstring);
        this.f2118k = k.x.m.j(strSubstring2);
        this.f2119l = k.x.m.k(strSubstring2);
    }
}
