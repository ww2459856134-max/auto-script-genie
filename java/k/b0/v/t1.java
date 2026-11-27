package k.b0.v;

/* loaded from: classes.dex */
class t1 extends k.x.c1 {
    private int c;
    private int d;

    public t1(int i2, int i3) {
        super(k.x.z0.Z0);
        this.c = i3;
        this.d = i2;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[10];
        int i2 = 0;
        k.x.s0.f(this.d, bArr, 0);
        k.x.s0.f(this.c, bArr, 2);
        int i3 = this.c;
        if (i3 > 0) {
            k.x.s0.f(i3, bArr, 4);
        }
        int i4 = this.d;
        if (i4 > 0) {
            k.x.s0.f(i4, bArr, 6);
        }
        int i5 = this.c;
        if (i5 > 0 && this.d == 0) {
            i2 = 2;
        } else if (i5 == 0 && this.d > 0) {
            i2 = 1;
        } else if (i5 <= 0 || this.d <= 0) {
            i2 = 3;
        }
        k.x.s0.f(i2, bArr, 8);
        return bArr;
    }
}
