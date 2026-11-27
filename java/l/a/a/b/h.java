package l.a.a.b;

import java.security.SecureRandom;
import java.util.Objects;

/* loaded from: classes.dex */
public class h implements e {
    private final l.a.a.b.i.b a = new l.a.a.b.i.b();
    private byte[] b;

    public h(char[] cArr, long j2, boolean z) throws l.a.a.c.b {
        f(cArr, j2, z);
    }

    private void f(char[] cArr, long j2, boolean z) throws l.a.a.c.b {
        if (cArr == null || cArr.length <= 0) {
            throw new l.a.a.c.b("input password is null or empty, cannot initialize standard encrypter");
        }
        this.a.c(cArr, z);
        this.b = d();
        this.a.c(cArr, z);
        byte[] bArr = this.b;
        bArr[11] = (byte) (j2 >>> 24);
        bArr[10] = (byte) (j2 >>> 16);
        c(bArr);
    }

    @Override // l.a.a.b.e
    public int a(byte[] bArr, int i2, int i3) throws l.a.a.c.b {
        if (i3 < 0) {
            throw new l.a.a.c.b("invalid length specified to decrpyt data");
        }
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            bArr[i4] = b(bArr[i4]);
        }
        return i3;
    }

    protected byte b(byte b) {
        byte b2 = (byte) ((this.a.b() & 255) ^ b);
        this.a.d(b);
        return b2;
    }

    public int c(byte[] bArr) throws l.a.a.c.b {
        Objects.requireNonNull(bArr);
        int length = bArr.length;
        a(bArr, 0, length);
        return length;
    }

    protected byte[] d() {
        byte[] bArr = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < 12; i2++) {
            bArr[i2] = b((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    public byte[] e() {
        return this.b;
    }
}
