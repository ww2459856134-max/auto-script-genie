package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
public final class g0 implements a2 {
    static final l2 c = new l2(51966);
    private static final l2 d = new l2(0);

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] a() {
        return i.b.ha.a.b.f.e.a;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        g(bArr, i2, i3);
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 c() {
        return d;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 d() {
        return c;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public byte[] e() {
        return i.b.ha.a.b.f.e.a;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public l2 f() {
        return d;
    }

    @Override // i.b.ha.a.b.d.c.a2
    public void g(byte[] bArr, int i2, int i3) throws ZipException {
        if (i3 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
