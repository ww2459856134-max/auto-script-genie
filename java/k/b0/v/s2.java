package k.b0.v;

/* loaded from: classes.dex */
class s2 extends k.x.c1 {
    public static final r2 f = new r2(0);
    public static final r2 g = new r2(1);

    /* renamed from: h, reason: collision with root package name */
    public static final r2 f1944h = new r2(2);

    /* renamed from: i, reason: collision with root package name */
    public static final r2 f1945i = new r2(3);
    private r2 c;
    private int d;
    private int e;

    public s2(r2 r2Var, int i2, int i3) {
        super(k.x.z0.M0);
        this.d = i2;
        this.e = i3;
        this.c = r2Var;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[15];
        bArr[0] = (byte) this.c.a;
        k.x.s0.f(this.e, bArr, 1);
        k.x.s0.f(this.d, bArr, 3);
        bArr[7] = 1;
        k.x.s0.f(this.e, bArr, 9);
        k.x.s0.f(this.e, bArr, 11);
        int i2 = this.d;
        bArr[13] = (byte) i2;
        bArr[14] = (byte) i2;
        return bArr;
    }
}
