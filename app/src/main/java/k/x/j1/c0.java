package k.x.j1;

/* loaded from: classes.dex */
class c0 extends n0 {
    private static k.y.c g = k.y.c.b(c0.class);
    private double e;
    private boolean f;

    public c0() {
        this.f = false;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = {i1.f2126i.a(), 0, 0};
        k.x.s0.f((int) this.e, bArr, 1);
        return bArr;
    }

    @Override // k.x.j1.n0
    public double j() {
        return this.e;
    }

    boolean k() {
        return this.f;
    }

    public int l(byte[] bArr, int i2) {
        this.e = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        return 2;
    }

    public c0(String str) {
        try {
            this.e = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            g.g(e, e);
            this.e = 0.0d;
        }
        double d = this.e;
        this.f = d != ((double) ((short) ((int) d)));
    }
}
