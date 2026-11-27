package i.b.ha.a.b.d.c;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class s0 implements a2 {
    private static final l2 e = new l2(44225);
    private byte[] c;
    private byte[] d;

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        byte[] bArr = this.d;
        return bArr == null ? e() : o2.c(bArr);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) {
        this.d = Arrays.copyOfRange(bArr, i2, i2 + i3);
        if (this.c == null) {
            g(bArr, i2, i3);
        }
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return l2.f(this.c);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return e;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        return o2.c(this.c);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return this.d == null ? c() : new l2(this.d.length);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) {
        this.c = Arrays.copyOfRange(bArr, i2, i3 + i2);
    }
}
