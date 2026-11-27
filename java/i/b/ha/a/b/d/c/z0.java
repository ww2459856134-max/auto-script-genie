package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class z0 extends k0 {
    static final l2 f = new l2(21);

    public z0() {
        super(f);
    }

    @Override // i.b.ha.a.b.d.c.k0, i.b.ha.a.b.d.c.a2
    public void b(byte[] bArr, int i2, int i3) throws ZipException {
        h(4, i3);
        super.b(bArr, i2, i3);
        l2.e(bArr, i2);
        j0.b(l2.e(bArr, i2 + 2));
    }
}
