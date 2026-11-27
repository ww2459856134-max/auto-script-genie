package k.b0.v;

/* loaded from: classes.dex */
class g1 extends k.x.c1 {
    private byte c;
    private byte d;
    private byte[] e;

    public g1(int i2, int i3) {
        super(k.x.z0.z0);
        byte b = (byte) i2;
        this.c = b;
        byte b2 = (byte) i3;
        this.d = b2;
        this.e = new byte[]{b, b2};
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.e;
    }
}
