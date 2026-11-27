package k.b0.v;

/* loaded from: classes.dex */
abstract class h1 extends k.x.c1 {
    private double c;

    public h1(k.x.z0 z0Var, double d) {
        super(z0Var);
        this.c = d;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[8];
        k.x.c0.a(this.c, bArr, 0);
        return bArr;
    }
}
