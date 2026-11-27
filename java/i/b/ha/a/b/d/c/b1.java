package i.b.ha.a.b.d.c;

import java.util.Arrays;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class b1 extends k0 {

    /* renamed from: h, reason: collision with root package name */
    static final l2 f1403h = new l2(23);
    private long f;
    private int g;

    public b1() {
        super(f1403h);
    }

    private void k(String str, int i2, int i3, int i4) throws ZipException {
        if (i3 + i2 <= i4) {
            return;
        }
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: " + str + " " + i2 + " doesn't fit into " + i4 + " bytes of data at position " + i3);
    }

    @Override // i.b.ha.a.b.d.c.k0, i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        super.b(bArr, i2, i3);
        l(bArr, i2, i3);
    }

    @Override // i.b.ha.a.b.d.c.k0, i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        super.g(bArr, i2, i3);
        m(bArr, i2, i3);
    }

    public void l(byte[] bArr, int i2, int i3) throws ZipException {
        h(12, i3);
        l2.e(bArr, i2);
        i0.b(l2.e(bArr, i2 + 2));
        l2.e(bArr, i2 + 4);
        l2.e(bArr, i2 + 6);
        long jF = j2.f(bArr, i2 + 8);
        this.f = jF;
        if (jF > 0) {
            h(16, i3);
            j0.b(l2.e(bArr, i2 + 12));
            this.g = l2.e(bArr, i2 + 14);
        }
    }

    public void m(byte[] bArr, int i2, int i3) throws ZipException {
        h(4, i3);
        int iE = l2.e(bArr, i2);
        k("ivSize", iE, 4, i3);
        int i4 = i2 + 4;
        h(i4, iE);
        Arrays.copyOfRange(bArr, i4, iE);
        int i5 = iE + 16;
        h(i5, i3);
        int i6 = i2 + iE;
        l2.e(bArr, i6 + 6);
        i0.b(l2.e(bArr, i6 + 8));
        l2.e(bArr, i6 + 10);
        l2.e(bArr, i6 + 12);
        int iE2 = l2.e(bArr, i6 + 14);
        k("erdSize", iE2, i5, i3);
        int i7 = i6 + 16;
        h(i7, iE2);
        Arrays.copyOfRange(bArr, i7, iE2);
        int i8 = iE + 20 + iE2;
        h(i8, i3);
        long jF = j2.f(bArr, i7 + iE2);
        this.f = jF;
        if (jF == 0) {
            h(i8 + 2, i3);
            int iE3 = l2.e(bArr, i6 + 20 + iE2);
            k("vSize", iE3, iE + 22 + iE2, i3);
            if (iE3 < 4) {
                throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + iE3 + " is too small to hold CRC");
            }
            int i9 = i6 + 22 + iE2;
            int i10 = iE3 - 4;
            h(i9, i10);
            Arrays.copyOfRange(bArr, i9, i10);
            int i11 = (i9 + iE3) - 4;
            h(i11, 4);
            Arrays.copyOfRange(bArr, i11, 4);
            return;
        }
        h(i8 + 6, i3);
        j0.b(l2.e(bArr, i6 + 20 + iE2));
        int i12 = i6 + 22 + iE2;
        this.g = l2.e(bArr, i12);
        int i13 = i6 + 24 + iE2;
        int iE4 = l2.e(bArr, i13);
        if (iE4 < this.g) {
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: resize " + iE4 + " is too small to hold hashSize" + this.g);
        }
        k("resize", iE4, iE + 24 + iE2, i3);
        Arrays.copyOfRange(bArr, i13, this.g);
        int i14 = this.g;
        Arrays.copyOfRange(bArr, i13 + i14, iE4 - i14);
        h(iE + 26 + iE2 + iE4 + 2, i3);
        int iE5 = l2.e(bArr, i6 + 26 + iE2 + iE4);
        if (iE5 >= 4) {
            k("vSize", iE5, iE + 22 + iE2 + iE4, i3);
            int i15 = i12 + iE4;
            Arrays.copyOfRange(bArr, i15, iE5 - 4);
            Arrays.copyOfRange(bArr, (i15 + iE5) - 4, 4);
            return;
        }
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + iE5 + " is too small to hold CRC");
    }
}
