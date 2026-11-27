package k.x.i1;

import java.util.ArrayList;

/* loaded from: classes.dex */
class o extends x {
    private byte[] c;
    private int d;
    private int e;
    private ArrayList f;

    static {
        k.y.c.b(o.class);
    }

    public o(a0 a0Var) {
        super(a0Var);
        this.f = new ArrayList();
        byte[] bArrA = a();
        k.x.s0.d(bArrA[0], bArrA[1], bArrA[2], bArrA[3]);
        this.d = k.x.s0.d(bArrA[4], bArrA[5], bArrA[6], bArrA[7]);
        this.e = k.x.s0.d(bArrA[8], bArrA[9], bArrA[10], bArrA[11]);
        k.x.s0.d(bArrA[12], bArrA[13], bArrA[14], bArrA[15]);
        int i2 = 16;
        for (int i3 = 0; i3 < this.d; i3++) {
            this.f.add(new n(k.x.s0.c(bArrA[i2], bArrA[i2 + 1]), k.x.s0.c(bArrA[i2 + 2], bArrA[i2 + 3])));
            i2 += 4;
        }
    }

    @Override // k.x.i1.x, k.x.i1.z
    byte[] b() {
        int size = this.f.size();
        this.d = size;
        int i2 = 16;
        byte[] bArr = new byte[(size * 4) + 16];
        this.c = bArr;
        k.x.s0.a(this.e + 1024, bArr, 0);
        k.x.s0.a(this.d, this.c, 4);
        k.x.s0.a(this.e, this.c, 8);
        k.x.s0.a(1, this.c, 12);
        for (int i3 = 0; i3 < this.d; i3++) {
            n nVar = (n) this.f.get(i3);
            k.x.s0.f(nVar.a, this.c, i2);
            k.x.s0.f(nVar.b, this.c, i2 + 2);
            i2 += 4;
        }
        return j(this.c);
    }

    void m(int i2, int i3) {
        this.f.add(new n(i2, i3));
    }

    n n(int i2) {
        return (n) this.f.get(i2);
    }

    public o(int i2, int i3) {
        super(b0.f2040i);
        this.e = i2;
        this.f = new ArrayList();
    }
}
