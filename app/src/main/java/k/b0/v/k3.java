package k.b0.v;

/* loaded from: classes.dex */
class k3 extends k.x.c1 {
    private byte[] c;

    public k3(k.t tVar) {
        super(k.x.z0.s0);
        int i2 = (tVar.J() ? 2 : 0) | 4 | 0;
        int i3 = (tVar.h() ? i2 | 16 : i2) | 32 | 128;
        i3 = (tVar.p() == 0 && tVar.L() == 0) ? i3 : i3 | 8 | 256;
        i3 = tVar.R() ? i3 | 1536 : i3;
        i3 = tVar.v() ? i3 | 2048 : i3;
        byte[] bArr = new byte[18];
        this.c = bArr;
        k.x.s0.f(i3, bArr, 0);
        k.x.s0.f(64, this.c, 6);
        k.x.s0.f(tVar.u(), this.c, 10);
        k.x.s0.f(tVar.s(), this.c, 12);
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.c;
    }
}
