package k.x.i1;

import java.io.IOException;

/* loaded from: classes.dex */
class b extends x {
    private c c;
    private byte[] d;
    private int e;
    private int f;
    private boolean g;

    static {
        k.y.c.b(b.class);
    }

    public b(a0 a0Var) {
        super(a0Var);
        this.c = c.a(d());
        this.g = false;
        byte[] bArrA = a();
        this.f = k.x.s0.d(bArrA[24], bArrA[25], bArrA[26], bArrA[27]);
    }

    @Override // k.x.i1.x, k.x.i1.z
    public byte[] b() {
        if (this.g) {
            this.d[0] = (byte) this.c.b();
            this.d[1] = (byte) this.c.b();
            k.x.s0.a(this.e + 8 + 17, this.d, 20);
            k.x.s0.a(this.f, this.d, 24);
            k.x.s0.a(0, this.d, 28);
            byte[] bArr = this.d;
            bArr[32] = 0;
            bArr[33] = 0;
            bArr[34] = 126;
            bArr[35] = 1;
            bArr[36] = 0;
            bArr[37] = 110;
            k.x.s0.f(61470, bArr, 38);
            k.x.s0.a(this.e + 17, this.d, 40);
        } else {
            this.d = a();
        }
        return j(this.d);
    }

    byte[] m() {
        byte[] bArrA = a();
        int length = bArrA.length - 61;
        byte[] bArr = new byte[length];
        System.arraycopy(bArrA, 61, bArr, 0, length);
        return bArr;
    }

    public b(s sVar) throws IOException {
        super(b0.f2041j);
        this.c = c.d;
        l(2);
        k(this.c.b());
        byte[] bArrL = sVar.l();
        int length = bArrL.length;
        this.e = length;
        byte[] bArr = new byte[length + 61];
        this.d = bArr;
        System.arraycopy(bArrL, 0, bArr, 61, length);
        this.f = sVar.o();
        this.g = true;
    }
}
