package k.x;

import k.a0.a.f2;

/* loaded from: classes.dex */
public class p extends c1 {
    private o c;
    private o[] d;
    private int e;
    private boolean f;
    private byte[] g;

    static {
        k.y.c.b(p.class);
    }

    public p(f2 f2Var) {
        super(f2Var);
        this.f = false;
        this.g = x().c();
    }

    @Override // k.x.c1
    public byte[] y() {
        if (!this.f) {
            return this.g;
        }
        int i2 = 14;
        byte[] bArr = new byte[(this.d.length * 8) + 14];
        int i3 = 0;
        System.arraycopy(this.g, 0, bArr, 0, 4);
        s0.f(this.c.a, bArr, 4);
        s0.f(this.c.c, bArr, 6);
        s0.f(this.c.b, bArr, 8);
        s0.f(this.c.d, bArr, 10);
        s0.f(this.e, bArr, 12);
        while (true) {
            o[] oVarArr = this.d;
            if (i3 >= oVarArr.length) {
                return bArr;
            }
            s0.f(oVarArr[i3].a, bArr, i2);
            s0.f(this.d[i3].c, bArr, i2 + 2);
            s0.f(this.d[i3].b, bArr, i2 + 4);
            s0.f(this.d[i3].d, bArr, i2 + 6);
            i2 += 8;
            i3++;
        }
    }
}
