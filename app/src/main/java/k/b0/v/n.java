package k.b0.v;

/* loaded from: classes.dex */
class n extends k.x.c1 {
    static m d = new m(0);
    static m e = new m(1);
    private m c;

    public n(m mVar) {
        super(k.x.z0.A0);
        this.c = mVar;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[2];
        k.x.s0.f(this.c.a, bArr, 0);
        return bArr;
    }
}
