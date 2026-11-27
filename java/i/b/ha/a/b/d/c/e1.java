package i.b.ha.a.b.d.c;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class e1 implements a2, Cloneable, Serializable {
    static final l2 f = new l2(30837);
    private static final l2 g = new l2(0);

    /* renamed from: h, reason: collision with root package name */
    private static final BigInteger f1408h = BigInteger.valueOf(1000);
    private int c = 1;
    private BigInteger d;
    private BigInteger e;

    public e1() {
        h();
    }

    private void h() {
        BigInteger bigInteger = f1408h;
        this.d = bigInteger;
        this.e = bigInteger;
    }

    static byte[] i(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && bArr[i3] == 0; i3++) {
            i2++;
        }
        int iMax = Math.max(1, bArr.length - i2);
        byte[] bArr2 = new byte[iMax];
        int length2 = iMax - (bArr.length - i2);
        System.arraycopy(bArr, i2, bArr2, length2, iMax - length2);
        return bArr2;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        return i.b.ha.a.b.f.e.a;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return new l2(i.b.ha.a.d.b.a(i(this.d.toByteArray())) + 3 + i.b.ha.a.d.b.a(i(this.e.toByteArray())));
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return f;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        byte[] byteArray = this.d.toByteArray();
        byte[] byteArray2 = this.e.toByteArray();
        byte[] bArrI = i(byteArray);
        int iA = i.b.ha.a.d.b.a(bArrI);
        byte[] bArrI2 = i(byteArray2);
        int iA2 = i.b.ha.a.d.b.a(bArrI2);
        byte[] bArr = new byte[iA + 3 + iA2];
        if (bArrI != null) {
            o2.k(bArrI);
        }
        if (bArrI2 != null) {
            o2.k(bArrI2);
        }
        bArr[0] = o2.p(this.c);
        bArr[1] = o2.p(iA);
        if (bArrI != null) {
            System.arraycopy(bArrI, 0, bArr, 2, iA);
        }
        int i2 = 2 + iA;
        int i3 = i2 + 1;
        bArr[i2] = o2.p(iA2);
        if (bArrI2 != null) {
            System.arraycopy(bArrI2, 0, bArr, i3, iA2);
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return this.c == e1Var.c && this.d.equals(e1Var.d) && this.e.equals(e1Var.e);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return g;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        h();
        if (i3 < 3) {
            throw new ZipException("X7875_NewUnix length is too short, only " + i3 + " bytes");
        }
        int i4 = i2 + 1;
        this.c = defpackage.a.a(bArr[i2]);
        int i5 = i4 + 1;
        int iA = defpackage.a.a(bArr[i4]);
        int i6 = iA + 3;
        if (i6 > i3) {
            throw new ZipException("X7875_NewUnix invalid: uidSize " + iA + " doesn't fit into " + i3 + " bytes");
        }
        int i7 = iA + i5;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, i7);
        o2.k(bArrCopyOfRange);
        this.d = new BigInteger(1, bArrCopyOfRange);
        int i8 = i7 + 1;
        int iA2 = defpackage.a.a(bArr[i7]);
        if (i6 + iA2 <= i3) {
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i8, iA2 + i8);
            o2.k(bArrCopyOfRange2);
            this.e = new BigInteger(1, bArrCopyOfRange2);
        } else {
            throw new ZipException("X7875_NewUnix invalid: gidSize " + iA2 + " doesn't fit into " + i3 + " bytes");
        }
    }

    public int hashCode() {
        return ((this.c * (-1234567)) ^ Integer.rotateLeft(this.d.hashCode(), 16)) ^ this.e.hashCode();
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.d + " GID=" + this.e;
    }
}
