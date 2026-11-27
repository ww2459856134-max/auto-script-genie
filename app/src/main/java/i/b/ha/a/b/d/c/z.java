package i.b.ha.a.b.d.c;

/* loaded from: classes.dex */
final class z {
    private final int a;
    private final byte[] b;
    private int c;
    private int d;

    z(int i2) {
        this.a = i2;
        this.b = new byte[i2];
    }

    public boolean a() {
        return this.c != this.d;
    }

    public void b(int i2, int i3) {
        int i4 = this.d - i2;
        int i5 = i3 + i4;
        while (i4 < i5) {
            byte[] bArr = this.b;
            int i6 = this.d;
            int i7 = this.a;
            bArr[i6] = bArr[(i4 + i7) % i7];
            this.d = (i6 + 1) % i7;
            i4++;
        }
    }

    public int c() {
        if (!a()) {
            return -1;
        }
        byte[] bArr = this.b;
        int i2 = this.c;
        byte b = bArr[i2];
        this.c = (i2 + 1) % this.a;
        return b & 255;
    }

    public void d(int i2) {
        byte[] bArr = this.b;
        int i3 = this.d;
        bArr[i3] = (byte) i2;
        this.d = (i3 + 1) % this.a;
    }
}
