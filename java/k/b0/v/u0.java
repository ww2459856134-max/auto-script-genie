package k.b0.v;

/* loaded from: classes.dex */
class u0 extends k.x.c1 {
    private int[] c;

    public u0(int[] iArr) {
        super(k.x.z0.L0);
        this.c = iArr;
    }

    @Override // k.x.c1
    public byte[] y() {
        int[] iArr = this.c;
        int i2 = 2;
        byte[] bArr = new byte[(iArr.length * 6) + 2];
        int i3 = 0;
        k.x.s0.f(iArr.length, bArr, 0);
        while (true) {
            int[] iArr2 = this.c;
            if (i3 >= iArr2.length) {
                return bArr;
            }
            k.x.s0.f(iArr2[i3], bArr, i2);
            k.x.s0.f(255, bArr, i2 + 4);
            i2 += 6;
            i3++;
        }
    }
}
