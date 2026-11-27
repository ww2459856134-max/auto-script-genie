package i.b.ha.a.b.d.c;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public abstract class v implements a2 {
    private long c;
    private byte[] d;
    private byte[] e;

    protected v() {
    }

    private void h() {
        byte[] bArr = this.d;
        if (bArr == null) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 5];
        this.e = bArr2;
        bArr2[0] = 1;
        System.arraycopy(j2.b(this.c), 0, this.e, 1, 4);
        byte[] bArr3 = this.d;
        System.arraycopy(bArr3, 0, this.e, 5, bArr3.length);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        if (this.e == null) {
            h();
        }
        byte[] bArr = this.e;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        g(bArr, i2, i3);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return f();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        return a();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        if (this.e == null) {
            h();
        }
        return l2.f(this.e);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        if (i3 < 5) {
            throw new ZipException("UniCode path extra data must have at least 5 bytes.");
        }
        byte b = bArr[i2];
        if (b != 1) {
            throw new ZipException("Unsupported version [" + ((int) b) + "] for UniCode path extra data.");
        }
        this.c = j2.f(bArr, i2 + 1);
        int i4 = i3 - 5;
        byte[] bArr2 = new byte[i4];
        this.d = bArr2;
        System.arraycopy(bArr, i2 + 5, bArr2, 0, i4);
        this.e = null;
    }

    public long i() {
        return this.c;
    }

    public byte[] j() {
        byte[] bArr = this.d;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    protected v(String str, byte[] bArr, int i2, int i3) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i2, i3);
        this.c = crc32.getValue();
        this.d = str.getBytes(StandardCharsets.UTF_8);
    }
}
