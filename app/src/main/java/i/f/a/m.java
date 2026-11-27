package i.f.a;

/* loaded from: classes.dex */
public final class m extends i {
    private final byte[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public m(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.d = i2;
        this.e = i3;
        this.f = 0;
        this.g = 0;
        int i4 = i2 * i3;
        this.c = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            this.c[i5] = (byte) (((((i6 >> 16) & 255) + ((i6 >> 7) & 510)) + (i6 & 255)) / 4);
        }
    }

    @Override // i.f.a.i
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i2 = this.d;
        if (iD == i2 && iA == this.e) {
            return this.c;
        }
        int i3 = iD * iA;
        byte[] bArr = new byte[i3];
        int i4 = (this.g * i2) + this.f;
        if (iD == i2) {
            System.arraycopy(this.c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < iA; i5++) {
            System.arraycopy(this.c, i4, bArr, i5 * iD, iD);
            i4 += this.d;
        }
        return bArr;
    }

    @Override // i.f.a.i
    public byte[] c(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.c, ((i2 + this.g) * this.d) + this.f, bArr, 0, iD);
        return bArr;
    }
}
