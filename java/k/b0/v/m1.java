package k.b0.v;

/* loaded from: classes.dex */
class m1 {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    m1(k.a0.a.n1 n1Var) {
        this.a = n1Var.b();
        this.b = n1Var.c();
        this.c = n1Var.d();
        this.d = n1Var.e();
        this.e = n1Var.a();
    }

    byte[] a() {
        byte[] bArr = new byte[10];
        k.x.s0.f(this.e, bArr, 0);
        k.x.s0.f(this.b, bArr, 2);
        k.x.s0.f(this.d, bArr, 4);
        k.x.s0.f(this.a & 255, bArr, 6);
        k.x.s0.f(this.c & 255, bArr, 8);
        return bArr;
    }

    m1(int i2, int i3, int i4, int i5, int i6) {
        this.a = i5;
        this.b = i3;
        this.c = i6;
        this.d = i4;
        this.e = i2;
    }
}
