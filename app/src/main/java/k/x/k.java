package k.x;

/* loaded from: classes.dex */
public class k {
    private int a;
    private byte[] b;
    private int c;

    public k() {
        this(1024);
    }

    private void c(int i2) {
        while (true) {
            int i3 = this.c;
            int i4 = i3 + i2;
            byte[] bArr = this.b;
            if (i4 < bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[bArr.length + this.a];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            this.b = bArr2;
        }
    }

    public void a(byte b) {
        c(1);
        byte[] bArr = this.b;
        int i2 = this.c;
        bArr[i2] = b;
        this.c = i2 + 1;
    }

    public void b(byte[] bArr) {
        c(bArr.length);
        System.arraycopy(bArr, 0, this.b, this.c, bArr.length);
        this.c += bArr.length;
    }

    public byte[] d() {
        int i2 = this.c;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.b, 0, bArr, 0, i2);
        return bArr;
    }

    public k(int i2) {
        this.a = i2;
        this.b = new byte[1024];
        this.c = 0;
    }
}
