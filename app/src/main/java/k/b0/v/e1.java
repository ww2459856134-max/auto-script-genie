package k.b0.v;

/* loaded from: classes.dex */
public abstract class e1 extends o {

    /* renamed from: l, reason: collision with root package name */
    private String f1894l;

    /* renamed from: m, reason: collision with root package name */
    private u2 f1895m;

    /* renamed from: n, reason: collision with root package name */
    private int f1896n;

    static {
        k.y.c.b(e1.class);
    }

    protected e1(int i2, int i3, String str) {
        super(k.x.z0.y, i2, i3);
        this.f1894l = str;
        if (str == null) {
            this.f1894l = "";
        }
    }

    @Override // k.b0.v.o
    void H(k.x.n0 n0Var, u2 u2Var, p3 p3Var) {
        super.H(n0Var, u2Var, p3Var);
        this.f1895m = u2Var;
        int iC = u2Var.c(this.f1894l);
        this.f1896n = iC;
        this.f1894l = this.f1895m.b(iC);
    }

    public String getString() {
        return this.f1894l;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.c;
    }

    @Override // k.c
    public String p() {
        return this.f1894l;
    }

    @Override // k.b0.v.o, k.x.c1
    public byte[] y() {
        byte[] bArrY = super.y();
        byte[] bArr = new byte[bArrY.length + 4];
        System.arraycopy(bArrY, 0, bArr, 0, bArrY.length);
        k.x.s0.a(this.f1896n, bArr, bArrY.length);
        return bArr;
    }

    protected e1(k.o oVar) {
        super(k.x.z0.y, oVar);
        String string = oVar.getString();
        this.f1894l = string;
        if (string == null) {
            this.f1894l = "";
        }
    }
}
