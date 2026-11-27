package k.a0.a;

/* loaded from: classes.dex */
class x0 extends k.x.w0 {
    public static w0 d = new w0();
    private int[] c;

    public x0(f2 f2Var) {
        super(f2Var);
        k.y.c.b(x0.class);
        byte[] bArrC = f2Var.c();
        int iC = k.x.s0.c(bArrC[0], bArrC[1]);
        this.c = new int[iC];
        int i2 = 2;
        for (int i3 = 0; i3 < iC; i3++) {
            this.c[i3] = k.x.s0.c(bArrC[i2], bArrC[i2 + 1]);
            i2 += 6;
        }
    }

    public int[] y() {
        return this.c;
    }

    public x0(f2 f2Var, w0 w0Var) {
        super(f2Var);
        k.y.c.b(x0.class);
        byte[] bArrC = f2Var.c();
        int iC = k.x.s0.c(bArrC[0], bArrC[1]);
        this.c = new int[iC];
        int i2 = 2;
        for (int i3 = 0; i3 < iC; i3++) {
            this.c[i3] = k.x.s0.c(bArrC[i2], bArrC[i2 + 1]);
            i2 += 2;
        }
    }
}
