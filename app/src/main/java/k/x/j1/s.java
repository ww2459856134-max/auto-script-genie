package k.x.j1;

/* loaded from: classes.dex */
class s extends p0 {
    private u e;

    public s() {
    }

    @Override // k.x.j1.t0
    byte[] a() {
        return new byte[]{i1.g.a(), (byte) this.e.a()};
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.e.b());
    }

    public int j(byte[] bArr, int i2) {
        this.e = u.c(bArr[i2]);
        return 1;
    }

    public s(String str) {
        this.e = u.d(str);
    }
}
