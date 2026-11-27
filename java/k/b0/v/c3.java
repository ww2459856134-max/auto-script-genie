package k.b0.v;

/* loaded from: classes.dex */
class c3 extends k.x.c1 {
    private byte[] c;

    public c3(int i2) {
        super(k.x.z0.B);
        this.c = new byte[i2 * 2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            k.x.s0.f(i4, this.c, i3 * 2);
            i3 = i4;
        }
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.c;
    }
}
