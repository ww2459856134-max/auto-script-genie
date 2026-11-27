package i.b.ha.a.b.d.c;

import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class w implements a2, Cloneable {

    /* renamed from: i, reason: collision with root package name */
    static final l2 f1443i = new l2(30062);
    private int c;
    private int d;
    private int e;
    private boolean g;
    private String f = "";

    /* renamed from: h, reason: collision with root package name */
    private CRC32 f1444h = new CRC32();

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        return e();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        g(bArr, i2, i3);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return new l2(i().getBytes(Charset.defaultCharset()).length + 14);
    }

    public Object clone() {
        try {
            w wVar = (w) super.clone();
            wVar.f1444h = new CRC32();
            return wVar;
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return f1443i;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        int iC = c().c() - 4;
        byte[] bArr = new byte[iC];
        System.arraycopy(l2.b(j()), 0, bArr, 0, 2);
        byte[] bytes = i().getBytes(Charset.defaultCharset());
        System.arraycopy(j2.b(bytes.length), 0, bArr, 2, 4);
        System.arraycopy(l2.b(l()), 0, bArr, 6, 2);
        System.arraycopy(l2.b(h()), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.f1444h.reset();
        this.f1444h.update(bArr);
        byte[] bArr2 = new byte[iC + 4];
        System.arraycopy(j2.b(this.f1444h.getValue()), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, iC);
        return bArr2;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return c();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        if (i3 < 14) {
            throw new ZipException("The length is too short, only " + i3 + " bytes, expected at least 14");
        }
        long jF = j2.f(bArr, i2);
        int i4 = i3 - 4;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2 + 4, bArr2, 0, i4);
        this.f1444h.reset();
        this.f1444h.update(bArr2);
        long value = this.f1444h.getValue();
        if (jF != value) {
            throw new ZipException("Bad CRC checksum, expected " + Long.toHexString(jF) + " instead of " + Long.toHexString(value));
        }
        int iE = l2.e(bArr2, 0);
        int iF = (int) j2.f(bArr2, 2);
        if (iF < 0 || iF > i4 - 10) {
            throw new ZipException("Bad symbolic link name length " + iF + " in ASI extra field");
        }
        this.d = l2.e(bArr2, 6);
        this.e = l2.e(bArr2, 8);
        if (iF == 0) {
            this.f = "";
        } else {
            byte[] bArr3 = new byte[iF];
            System.arraycopy(bArr2, 10, bArr3, 0, iF);
            this.f = new String(bArr3, Charset.defaultCharset());
        }
        o((iE & 16384) != 0);
        p(iE);
    }

    public int h() {
        return this.e;
    }

    public String i() {
        return this.f;
    }

    public int j() {
        return this.c;
    }

    protected int k(int i2) {
        return (i2 & 4095) | (n() ? 40960 : m() ? 16384 : 32768);
    }

    public int l() {
        return this.d;
    }

    public boolean m() {
        return this.g && !n();
    }

    public boolean n() {
        return !i().isEmpty();
    }

    public void o(boolean z) {
        this.g = z;
        this.c = k(this.c);
    }

    public void p(int i2) {
        this.c = k(i2);
    }
}
