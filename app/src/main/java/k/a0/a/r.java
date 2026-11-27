package k.a0.a;

import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class r extends k.x.w0 {
    private byte[] c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1845h;

    /* renamed from: i, reason: collision with root package name */
    private int f1846i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1847j;

    r(f2 f2Var) {
        super(k.x.z0.t);
        byte[] bArrC = f2Var.c();
        this.c = bArrC;
        this.d = k.x.s0.c(bArrC[0], bArrC[1]);
        byte[] bArr = this.c;
        this.e = k.x.s0.c(bArr[2], bArr[3]);
        byte[] bArr2 = this.c;
        this.g = k.x.s0.c(bArr2[4], bArr2[5]);
        byte[] bArr3 = this.c;
        this.f = k.x.s0.c(bArr3[6], bArr3[7]);
        byte[] bArr4 = this.c;
        int iC = k.x.s0.c(bArr4[8], bArr4[9]);
        this.f1845h = (iC & 1) != 0;
        this.f1846i = (iC & 1792) >> 8;
        this.f1847j = (iC & XMLEvent.CHANGE_PREFIX_MAPPING) != 0;
    }

    public boolean A() {
        return this.f1845h;
    }

    public int B() {
        return this.f1846i;
    }

    public int C() {
        return this.d;
    }

    public int D() {
        return this.g;
    }

    public int E() {
        return this.f;
    }

    public boolean y() {
        return this.f1847j;
    }

    public int z() {
        return this.e;
    }
}
