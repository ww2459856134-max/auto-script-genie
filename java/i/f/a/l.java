package i.f.a;

/* loaded from: classes.dex */
public final class l extends i {
    private final byte[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public l(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.c = bArr;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        if (z) {
            h(i6, i7);
        }
    }

    private void h(int i2, int i3) {
        byte[] bArr = this.c;
        int i4 = (this.g * this.d) + this.f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.d;
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
