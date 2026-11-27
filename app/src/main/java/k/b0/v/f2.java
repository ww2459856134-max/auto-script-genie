package k.b0.v;

/* loaded from: classes.dex */
class f2 extends e2 implements k.q {

    /* renamed from: o, reason: collision with root package name */
    private static k.y.c f1900o = k.y.c.b(f2.class);

    public f2(k.x.o0 o0Var) {
        super(o0Var);
    }

    @Override // k.b0.v.e2
    protected byte[] K() {
        byte[] bArrI = super.I();
        q3 q3VarO = C().o();
        k.x.j1.x xVar = new k.x.j1.x(Double.toString(getValue()), q3VarO, q3VarO, q3VarO.r());
        try {
            xVar.c();
        } catch (k.x.j1.w e) {
            f1900o.f(e.getMessage());
        }
        byte[] bArrA = xVar.a();
        int length = bArrA.length + 16;
        byte[] bArr = new byte[length];
        k.x.s0.f(bArrA.length, bArr, 14);
        System.arraycopy(bArrA, 0, bArr, 16, bArrA.length);
        bArr[8] = (byte) (bArr[8] | 2);
        byte[] bArr2 = new byte[bArrI.length + length];
        System.arraycopy(bArrI, 0, bArr2, 0, bArrI.length);
        System.arraycopy(bArr, 0, bArr2, bArrI.length, length);
        k.x.c0.a(getValue(), bArr2, 6);
        return bArr2;
    }

    @Override // k.p
    public double getValue() {
        return ((k.q) J()).getValue();
    }
}
