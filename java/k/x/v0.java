package k.x;

import k.a0.a.f2;

/* loaded from: classes.dex */
public class v0 extends c1 {
    private k.z.l[] c;
    private boolean d;
    private boolean e;

    public v0(f2 f2Var) {
        super(f2Var);
        this.c = new k.z.l[56];
        this.d = false;
        this.e = true;
    }

    @Override // k.x.c1
    public byte[] y() {
        if (this.e && !this.d) {
            return x().c();
        }
        byte[] bArr = new byte[226];
        s0.f(56, bArr, 0);
        for (int i2 = 0; i2 < 56; i2++) {
            int i3 = (i2 * 4) + 2;
            bArr[i3] = (byte) this.c[i2].c();
            bArr[i3 + 1] = (byte) this.c[i2].b();
            bArr[i3 + 2] = (byte) this.c[i2].a();
        }
        return bArr;
    }
}
