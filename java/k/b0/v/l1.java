package k.b0.v;

import java.util.List;

/* loaded from: classes.dex */
class l1 extends k.x.c1 {
    private int c;
    private int d;
    private int e;
    private int[] f;
    private int[] g;

    public l1(List list) {
        super(k.x.z0.p);
        this.c = ((k.b0.h) list.get(0)).getRow();
        this.d = ((k.b0.h) list.get(0)).b();
        this.e = (r1 + list.size()) - 1;
        this.f = new int[list.size()];
        this.g = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f[i2] = (int) ((k.b0.h) list.get(i2)).getValue();
            this.g[i2] = ((o) list.get(i2)).D();
        }
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[(this.f.length * 6) + 6];
        k.x.s0.f(this.c, bArr, 0);
        k.x.s0.f(this.d, bArr, 2);
        int i2 = 4;
        for (int i3 = 0; i3 < this.f.length; i3++) {
            k.x.s0.f(this.g[i3], bArr, i2);
            k.x.s0.a((this.f[i3] << 2) | 2, bArr, i2 + 2);
            i2 += 6;
        }
        k.x.s0.f(this.e, bArr, i2);
        return bArr;
    }
}
