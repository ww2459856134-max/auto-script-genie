package k.x.j1;

/* loaded from: classes.dex */
class g extends p0 {
    private boolean e;

    public g() {
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[2];
        bArr[0] = i1.f2125h.a();
        bArr[1] = (byte) (this.e ? 1 : 0);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        stringBuffer.append(new Boolean(this.e).toString());
    }

    public int j(byte[] bArr, int i2) {
        this.e = bArr[i2] == 1;
        return 1;
    }

    public g(String str) {
        this.e = Boolean.valueOf(str).booleanValue();
    }
}
