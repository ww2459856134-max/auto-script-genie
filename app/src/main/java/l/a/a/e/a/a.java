package l.a.a.e.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
class a extends b<l.a.a.b.a> {
    private int A;
    private int C;
    private int D;
    private byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f2202h;

    /* renamed from: i, reason: collision with root package name */
    private int f2203i;

    /* renamed from: j, reason: collision with root package name */
    private int f2204j;

    /* renamed from: k, reason: collision with root package name */
    private int f2205k;
    private int t;

    public a(k kVar, l.a.a.f.j jVar, char[] cArr, int i2, boolean z) throws IOException {
        super(kVar, jVar, cArr, i2, z);
        this.g = new byte[1];
        this.f2202h = new byte[16];
        this.f2203i = 0;
        this.f2204j = 0;
        this.f2205k = 0;
        this.t = 0;
        this.A = 0;
        this.C = 0;
        this.D = 0;
    }

    private void m(byte[] bArr, int i2) {
        int i3 = this.f2205k;
        int i4 = this.f2204j;
        if (i3 >= i4) {
            i3 = i4;
        }
        this.C = i3;
        System.arraycopy(this.f2202h, this.f2203i, bArr, i2, i3);
        q(this.C);
        n(this.C);
        int i5 = this.A;
        int i6 = this.C;
        this.A = i5 + i6;
        this.f2205k -= i6;
        this.t += i6;
    }

    private void n(int i2) {
        int i3 = this.f2204j - i2;
        this.f2204j = i3;
        if (i3 <= 0) {
            this.f2204j = 0;
        }
    }

    private byte[] o() throws IOException {
        byte[] bArr = new byte[2];
        j(bArr);
        return bArr;
    }

    private byte[] p(l.a.a.f.j jVar) throws IOException {
        if (jVar.c() == null) {
            throw new IOException("invalid aes extra data record");
        }
        l.a.a.f.a aVarC = jVar.c();
        if (aVarC.c() == null) {
            throw new IOException("Invalid aes key strength in aes extra data record");
        }
        byte[] bArr = new byte[aVarC.c().e()];
        j(bArr);
        return bArr;
    }

    private void q(int i2) {
        int i3 = this.f2203i + i2;
        this.f2203i = i3;
        if (i3 >= 15) {
            this.f2203i = 15;
        }
    }

    private void w(byte[] bArr, int i2) throws IOException {
        byte[] bArr2 = new byte[10];
        System.arraycopy(d().b(i2), 0, bArr2, 0, 10);
        if (!Arrays.equals(bArr, bArr2)) {
            throw new IOException("Reached end of data for this entry, but aes verification failed");
        }
    }

    @Override // l.a.a.e.a.b
    protected void c(InputStream inputStream, int i2) throws IOException {
        w(u(inputStream), i2);
    }

    @Override // l.a.a.e.a.b, java.io.InputStream
    public int read() throws IOException {
        if (read(this.g) == -1) {
            return -1;
        }
        return this.g[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.e.a.b
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public l.a.a.b.a i(l.a.a.f.j jVar, char[] cArr, boolean z) throws IOException {
        return new l.a.a.b.a(jVar.c(), cArr, p(jVar), o(), z);
    }

    protected byte[] u(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        if (l.a.a.i.i.l(inputStream, bArr) == 10) {
            return bArr;
        }
        throw new l.a.a.c.b("Invalid AES Mac bytes. Could not read sufficient data");
    }

    @Override // l.a.a.e.a.b, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // l.a.a.e.a.b, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        this.f2205k = i3;
        this.t = i2;
        this.A = 0;
        if (this.f2204j != 0) {
            m(bArr, i2);
            int i4 = this.A;
            if (i4 == i3) {
                return i4;
            }
        }
        if (this.f2205k < 16) {
            byte[] bArr2 = this.f2202h;
            int i5 = super.read(bArr2, 0, bArr2.length);
            this.D = i5;
            this.f2203i = 0;
            if (i5 == -1) {
                this.f2204j = 0;
                int i6 = this.A;
                if (i6 > 0) {
                    return i6;
                }
                return -1;
            }
            this.f2204j = i5;
            m(bArr, this.t);
            int i7 = this.A;
            if (i7 == i3) {
                return i7;
            }
        }
        int i8 = this.t;
        int i9 = this.f2205k;
        int i10 = super.read(bArr, i8, i9 - (i9 % 16));
        if (i10 == -1) {
            int i11 = this.A;
            if (i11 > 0) {
                return i11;
            }
            return -1;
        }
        return i10 + this.A;
    }
}
