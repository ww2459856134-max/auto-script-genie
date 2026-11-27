package k.b0.v;

/* loaded from: classes.dex */
class v extends k.x.c1 {
    private int c;
    private int d;

    public v(k.x.s sVar, k.x.s sVar2) {
        super(k.x.z0.Y);
        this.c = sVar.c();
        this.d = sVar2.c();
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[4];
        k.x.s0.f(this.c, bArr, 0);
        k.x.s0.f(this.d, bArr, 2);
        return bArr;
    }

    public v(k.a0.a.t tVar) {
        super(k.x.z0.Y);
        this.c = tVar.y();
        this.d = tVar.z();
    }
}
