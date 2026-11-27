package i.b.ha.a.b.d.c;

import java.nio.file.attribute.FileTime;
import java.util.Objects;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class x0 implements a2 {
    public static final l2 f = new l2(10);
    private static final l2 g = new l2(1);

    /* renamed from: h, reason: collision with root package name */
    private static final l2 f1449h = new l2(24);
    private x1 c;
    private x1 d;
    private x1 e;

    public x0() {
        x1 x1Var = x1.d;
        this.c = x1Var;
        this.d = x1Var;
        this.e = x1Var;
    }

    private static x1 h(FileTime fileTime) {
        if (fileTime == null) {
            return null;
        }
        return new x1(i.b.ha.a.c.h.b.a.g(fileTime));
    }

    private void l(byte[] bArr, int i2, int i3) {
        if (i3 >= 26) {
            if (f1449h.equals(new l2(bArr, i2))) {
                int i4 = i2 + 2;
                this.c = new x1(bArr, i4);
                int i5 = i4 + 8;
                this.d = new x1(bArr, i5);
                this.e = new x1(bArr, i5 + 8);
            }
        }
    }

    private void m() {
        x1 x1Var = x1.d;
        this.c = x1Var;
        this.d = x1Var;
        this.e = x1Var;
    }

    private static FileTime t(x1 x1Var) {
        if (x1Var == null || x1.d.equals(x1Var)) {
            return null;
        }
        return i.b.ha.a.c.h.b.a.d(x1Var.c());
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        return e();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        m();
        g(bArr, i2, i3);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return new l2(32);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return f;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        byte[] bArr = new byte[c().c()];
        System.arraycopy(g.a(), 0, bArr, 4, 2);
        System.arraycopy(f1449h.a(), 0, bArr, 6, 2);
        System.arraycopy(this.c.a(), 0, bArr, 8, 8);
        System.arraycopy(this.d.a(), 0, bArr, 16, 8);
        System.arraycopy(this.e.a(), 0, bArr, 24, 8);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return Objects.equals(this.c, x0Var.c) && Objects.equals(this.d, x0Var.d) && Objects.equals(this.e, x0Var.e);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return c();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        int i4 = i3 + i2;
        int iC = i2 + 4;
        while (iC + 4 <= i4) {
            l2 l2Var = new l2(bArr, iC);
            int i5 = iC + 2;
            if (l2Var.equals(g)) {
                l(bArr, i5, i4 - i5);
                return;
            }
            iC = i5 + new l2(bArr, i5).c() + 2;
        }
    }

    public int hashCode() {
        x1 x1Var = this.c;
        int iHashCode = x1Var != null ? (-123) ^ x1Var.hashCode() : -123;
        x1 x1Var2 = this.d;
        if (x1Var2 != null) {
            iHashCode ^= Integer.rotateLeft(x1Var2.hashCode(), 11);
        }
        x1 x1Var3 = this.e;
        return x1Var3 != null ? iHashCode ^ Integer.rotateLeft(x1Var3.hashCode(), 22) : iHashCode;
    }

    public FileTime i() {
        return t(this.d);
    }

    public FileTime j() {
        return t(this.e);
    }

    public FileTime k() {
        return t(this.c);
    }

    public void n(FileTime fileTime) {
        o(h(fileTime));
    }

    public void o(x1 x1Var) {
        if (x1Var == null) {
            x1Var = x1.d;
        }
        this.d = x1Var;
    }

    public void p(FileTime fileTime) {
        q(h(fileTime));
    }

    public void q(x1 x1Var) {
        if (x1Var == null) {
            x1Var = x1.d;
        }
        this.e = x1Var;
    }

    public void r(FileTime fileTime) {
        s(h(fileTime));
    }

    public void s(x1 x1Var) {
        if (x1Var == null) {
            x1Var = x1.d;
        }
        this.c = x1Var;
    }

    public String toString() {
        return "0x000A Zip Extra Field: Modify:[" + k() + "]  Access:[" + i() + "]  Create:[" + j() + "] ";
    }
}
