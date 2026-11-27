package i.b.ha.a.b.d.c;

import java.util.Arrays;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public abstract class k0 implements a2 {
    private final l2 c;
    private byte[] d;
    private byte[] e;

    protected k0(l2 l2Var) {
        this.c = l2Var;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        byte[] bArr = this.e;
        return bArr != null ? o2.c(bArr) : e();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i3 + i2);
        i(bArrCopyOfRange);
        if (this.d == null) {
            j(bArrCopyOfRange);
        }
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return l2.f(this.d);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return this.c;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        return o2.c(this.d);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return this.e != null ? new l2(this.e.length) : c();
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        j(Arrays.copyOfRange(bArr, i2, i3 + i2));
    }

    protected final void h(int i2, int i3) throws ZipException {
        if (i3 >= i2) {
            return;
        }
        throw new ZipException(getClass().getName() + " is too short, only " + i3 + " bytes, expected at least " + i2);
    }

    public void i(byte[] bArr) {
        this.e = o2.c(bArr);
    }

    public void j(byte[] bArr) {
        this.d = o2.c(bArr);
    }
}
