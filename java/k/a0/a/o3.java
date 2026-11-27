package k.a0.a;

/* loaded from: classes.dex */
class o3 extends k.x.w0 {
    private String c;

    public o3(f2 f2Var, boolean z, k.w wVar) {
        super(k.x.z0.Q);
        byte[] bArrC = f2Var.c();
        if (z) {
            this.c = k.x.y0.g(bArrC, 56, 0);
        } else {
            this.c = k.x.y0.d(bArrC, bArrC[1], 1, wVar);
        }
    }

    public String y() {
        return this.c;
    }
}
