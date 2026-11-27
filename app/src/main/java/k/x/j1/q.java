package k.x.j1;

/* loaded from: classes.dex */
class q extends n0 {
    private static k.y.c f = k.y.c.b(q.class);
    private double e;

    public q() {
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[9];
        bArr[0] = i1.f2127j.a();
        k.x.c0.a(this.e, bArr, 1);
        return bArr;
    }

    @Override // k.x.j1.n0
    public double j() {
        return this.e;
    }

    public int k(byte[] bArr, int i2) {
        this.e = k.x.c0.b(bArr, i2);
        return 8;
    }

    q(double d) {
        this.e = d;
    }

    public q(String str) {
        try {
            this.e = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            f.g(e, e);
            this.e = 0.0d;
        }
    }
}
