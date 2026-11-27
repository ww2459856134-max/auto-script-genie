package k.b0.v;

/* loaded from: classes.dex */
class u1 extends k.x.c1 {
    private byte[] c;

    public u1(String str) {
        super(k.x.z0.p0);
        if (str == null) {
            byte[] bArr = new byte[2];
            this.c = bArr;
            k.x.s0.f(0, bArr, 0);
            return;
        }
        byte[] bytes = str.getBytes();
        int i2 = 0;
        int iA = 0;
        while (i2 < bytes.length) {
            byte b = bytes[i2];
            i2++;
            iA ^= A(b, i2);
        }
        int length = (bytes.length ^ iA) ^ 52811;
        byte[] bArr2 = new byte[2];
        this.c = bArr2;
        k.x.s0.f(length, bArr2, 0);
    }

    private int A(int i2, int i3) {
        int i4 = i2 & 32767;
        while (i3 > 0) {
            i4 = (i4 & 16384) != 0 ? ((i4 << 1) & 32767) + 1 : (i4 << 1) & 32767;
            i3--;
        }
        return i4;
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.c;
    }

    public u1(int i2) {
        super(k.x.z0.p0);
        byte[] bArr = new byte[2];
        this.c = bArr;
        k.x.s0.f(i2, bArr, 0);
    }
}
