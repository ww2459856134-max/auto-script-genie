package k.b0.v;

/* loaded from: classes.dex */
class c0 extends k.x.c1 {
    private byte[] c;
    private double d;

    public c0(double d) {
        super(k.x.z0.F0);
        this.d = d;
        this.c = new byte[8];
    }

    @Override // k.x.c1
    public byte[] y() {
        k.x.c0.a(this.d, this.c, 0);
        return this.c;
    }
}
