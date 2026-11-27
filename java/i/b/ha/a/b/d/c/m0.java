package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class m0 implements a2 {
    public static final l2 f = new l2(41246);
    private short c;
    private boolean d;
    private int e;

    public m0() {
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        return l2.b(this.c | (this.d ? Short.MIN_VALUE : (short) 0));
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        if (i3 >= 2) {
            int iE = l2.e(bArr, i2);
            this.c = (short) (iE & 32767);
            this.d = (iE & 32768) != 0;
        } else {
            throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + i3);
        }
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return new l2(this.e + 2);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return f;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        byte[] bArr = new byte[this.e + 2];
        l2.g(this.c | (this.d ? Short.MIN_VALUE : (short) 0), bArr, 0);
        return bArr;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return new l2(2);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        b(bArr, i2, i3);
        this.e = i3 - 2;
    }

    public boolean h() {
        return this.d;
    }

    public short i() {
        return this.c;
    }

    public m0(int i2, boolean z, int i3) {
        if (i2 < 0 || i2 > 32767) {
            throw new IllegalArgumentException("Alignment must be between 0 and 0x7fff, was: " + i2);
        }
        if (i3 >= 0) {
            this.c = (short) i2;
            this.d = z;
            this.e = i3;
        } else {
            throw new IllegalArgumentException("Padding must not be negative, was: " + i3);
        }
    }
}
