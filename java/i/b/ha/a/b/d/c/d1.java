package i.b.ha.a.b.d.c;

import java.io.Serializable;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class d1 implements a2, Cloneable, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final l2 f1404j = new l2(21589);
    private byte c;
    private boolean d;
    private boolean e;
    private boolean f;
    private j2 g;

    /* renamed from: h, reason: collision with root package name */
    private j2 f1405h;

    /* renamed from: i, reason: collision with root package name */
    private j2 f1406i;

    private static FileTime A(j2 j2Var) {
        if (j2Var != null) {
            return i.b.ha.a.c.h.b.a.a(j2Var.c());
        }
        return null;
    }

    private static j2 B(long j2) {
        if (i.b.ha.a.c.h.b.a.b(j2)) {
            return new j2(j2);
        }
        throw new IllegalArgumentException("X5455 timestamps must fit in a signed 32 bit integer: " + j2);
    }

    private static Date C(j2 j2Var) {
        if (j2Var != null) {
            return new Date(j2Var.c() * 1000);
        }
        return null;
    }

    private static j2 h(FileTime fileTime) {
        if (fileTime == null) {
            return null;
        }
        return B(i.b.ha.a.c.h.b.a.i(fileTime));
    }

    private void s() {
        x((byte) 0);
        this.g = null;
        this.f1405h = null;
        this.f1406i = null;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        return Arrays.copyOf(e(), f().c());
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        s();
        g(bArr, i2, i3);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return new l2((this.d ? 4 : 0) + 1 + ((!this.e || this.f1405h == null) ? 0 : 4) + ((!this.f || this.f1406i == null) ? 0 : 4));
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return f1404j;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        j2 j2Var;
        j2 j2Var2;
        byte[] bArr = new byte[c().c()];
        bArr[0] = 0;
        int i2 = 1;
        if (this.d) {
            bArr[0] = (byte) (bArr[0] | 1);
            System.arraycopy(this.g.a(), 0, bArr, 1, 4);
            i2 = 5;
        }
        if (this.e && (j2Var2 = this.f1405h) != null) {
            bArr[0] = (byte) (bArr[0] | 2);
            System.arraycopy(j2Var2.a(), 0, bArr, i2, 4);
            i2 += 4;
        }
        if (this.f && (j2Var = this.f1406i) != null) {
            bArr[0] = (byte) (bArr[0] | 4);
            System.arraycopy(j2Var.a(), 0, bArr, i2, 4);
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return (this.c & 7) == (d1Var.c & 7) && Objects.equals(this.g, d1Var.g) && Objects.equals(this.f1405h, d1Var.f1405h) && Objects.equals(this.f1406i, d1Var.f1406i);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return new l2((this.d ? 4 : 0) + 1);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        int i4;
        int i5;
        s();
        if (i3 < 1) {
            throw new ZipException("X5455_ExtendedTimestamp too short, only " + i3 + " bytes");
        }
        int i6 = i3 + i2;
        int i7 = i2 + 1;
        x(bArr[i2]);
        if (!this.d || (i5 = i7 + 4) > i6) {
            this.d = false;
        } else {
            this.g = new j2(bArr, i7);
            i7 = i5;
        }
        if (!this.e || (i4 = i7 + 4) > i6) {
            this.e = false;
        } else {
            this.f1405h = new j2(bArr, i7);
            i7 = i4;
        }
        if (!this.f || i7 + 4 > i6) {
            this.f = false;
        } else {
            this.f1406i = new j2(bArr, i7);
        }
    }

    public int hashCode() {
        int iRotateLeft = (this.c & 7) * (-123);
        j2 j2Var = this.g;
        if (j2Var != null) {
            iRotateLeft ^= j2Var.hashCode();
        }
        j2 j2Var2 = this.f1405h;
        if (j2Var2 != null) {
            iRotateLeft ^= Integer.rotateLeft(j2Var2.hashCode(), 11);
        }
        j2 j2Var3 = this.f1406i;
        return j2Var3 != null ? iRotateLeft ^ Integer.rotateLeft(j2Var3.hashCode(), 22) : iRotateLeft;
    }

    public FileTime i() {
        return A(this.f1405h);
    }

    public Date k() {
        return C(this.f1405h);
    }

    public FileTime l() {
        return A(this.f1406i);
    }

    public Date m() {
        return C(this.f1406i);
    }

    public FileTime n() {
        return A(this.g);
    }

    public Date o() {
        return C(this.g);
    }

    public boolean p() {
        return this.d;
    }

    public boolean q() {
        return this.e;
    }

    public boolean r() {
        return this.f;
    }

    public void t(FileTime fileTime) {
        u(h(fileTime));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("0x5455 Zip Extra Field: Flags=");
        sb.append(Integer.toBinaryString(o2.p(this.c)));
        sb.append(" ");
        if (this.d && this.g != null) {
            Date dateO = o();
            sb.append(" Modify:[");
            sb.append(dateO);
            sb.append("] ");
        }
        if (this.e && this.f1405h != null) {
            Date dateK = k();
            sb.append(" Access:[");
            sb.append(dateK);
            sb.append("] ");
        }
        if (this.f && this.f1406i != null) {
            Date dateM = m();
            sb.append(" Create:[");
            sb.append(dateM);
            sb.append("] ");
        }
        return sb.toString();
    }

    public void u(j2 j2Var) {
        this.e = j2Var != null;
        byte b = this.c;
        this.c = (byte) (j2Var != null ? b | 2 : b & (-3));
        this.f1405h = j2Var;
    }

    public void v(FileTime fileTime) {
        w(h(fileTime));
    }

    public void w(j2 j2Var) {
        this.f = j2Var != null;
        byte b = this.c;
        this.c = (byte) (j2Var != null ? b | 4 : b & (-5));
        this.f1406i = j2Var;
    }

    public void x(byte b) {
        this.c = b;
        this.d = (b & 1) == 1;
        this.e = (b & 2) == 2;
        this.f = (b & 4) == 4;
    }

    public void y(FileTime fileTime) {
        z(h(fileTime));
    }

    public void z(j2 j2Var) {
        this.d = j2Var != null;
        this.c = (byte) (j2Var != null ? 1 | this.c : this.c & (-2));
        this.g = j2Var;
    }
}
