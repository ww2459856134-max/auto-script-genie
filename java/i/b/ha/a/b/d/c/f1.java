package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class f1 implements a2 {

    /* renamed from: h, reason: collision with root package name */
    static final l2 f1410h = new l2(1);
    private x1 c;
    private x1 d;
    private x1 e;
    private j2 f;
    private byte[] g;

    private int h(byte[] bArr) {
        int i2;
        x1 x1Var = this.c;
        if (x1Var != null) {
            System.arraycopy(x1Var.a(), 0, bArr, 0, 8);
            i2 = 8;
        } else {
            i2 = 0;
        }
        x1 x1Var2 = this.d;
        if (x1Var2 == null) {
            return i2;
        }
        System.arraycopy(x1Var2.a(), 0, bArr, i2, 8);
        return i2 + 8;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        byte[] bArr = new byte[f().c()];
        int iH = h(bArr);
        x1 x1Var = this.e;
        if (x1Var != null) {
            System.arraycopy(x1Var.a(), 0, bArr, iH, 8);
            iH += 8;
        }
        j2 j2Var = this.f;
        if (j2Var != null) {
            System.arraycopy(j2Var.a(), 0, bArr, iH, 4);
        }
        return bArr;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        byte[] bArr2 = new byte[i3];
        this.g = bArr2;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        if (i3 >= 28) {
            g(bArr, i2, i3);
            return;
        }
        if (i3 != 24) {
            if (i3 % 8 == 4) {
                this.f = new j2(bArr, (i2 + i3) - 4);
            }
        } else {
            this.c = new x1(bArr, i2);
            int i4 = i2 + 8;
            this.d = new x1(bArr, i4);
            this.e = new x1(bArr, i4 + 8);
        }
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return new l2(this.c != null ? 16 : 0);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return f1410h;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        x1 x1Var = this.c;
        if (x1Var == null && this.d == null) {
            return i.b.ha.a.b.f.e.a;
        }
        if (x1Var == null || this.d == null) {
            throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
        }
        byte[] bArr = new byte[16];
        h(bArr);
        return bArr;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return new l2((this.c != null ? 8 : 0) + (this.d != null ? 8 : 0) + (this.e == null ? 0 : 8) + (this.f != null ? 4 : 0));
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        if (i3 == 0) {
            return;
        }
        if (i3 < 16) {
            throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
        }
        this.c = new x1(bArr, i2);
        int i4 = i2 + 8;
        this.d = new x1(bArr, i4);
        int i5 = i4 + 8;
        int i6 = i3 - 16;
        if (i6 >= 8) {
            this.e = new x1(bArr, i5);
            i5 += 8;
            i6 -= 8;
        }
        if (i6 >= 4) {
            this.f = new j2(bArr, i5);
        }
    }

    public x1 i() {
        return this.d;
    }

    public j2 j() {
        return this.f;
    }

    public x1 k() {
        return this.e;
    }

    public x1 l() {
        return this.c;
    }

    public void m(boolean z, boolean z2, boolean z3, boolean z4) throws ZipException {
        byte[] bArr = this.g;
        if (bArr != null) {
            int i2 = 0;
            int i3 = (z ? 8 : 0) + (z2 ? 8 : 0) + (z3 ? 8 : 0) + (z4 ? 4 : 0);
            if (bArr.length < i3) {
                throw new ZipException("Central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + i3 + " but is " + this.g.length);
            }
            if (z) {
                this.c = new x1(this.g, 0);
                i2 = 8;
            }
            if (z2) {
                this.d = new x1(this.g, i2);
                i2 += 8;
            }
            if (z3) {
                this.e = new x1(this.g, i2);
                i2 += 8;
            }
            if (z4) {
                this.f = new j2(this.g, i2);
            }
        }
    }

    public void n(x1 x1Var) {
        this.d = x1Var;
    }

    public void o(j2 j2Var) {
        this.f = j2Var;
    }

    public void p(x1 x1Var) {
        this.e = x1Var;
    }

    public void q(x1 x1Var) {
        this.c = x1Var;
    }
}
