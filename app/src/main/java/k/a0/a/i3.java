package k.a0.a;

/* loaded from: classes.dex */
class i3 extends k.x.w0 {
    public static h3 d = new h3();
    private int[] c;

    public i3(f2 f2Var) {
        super(f2Var);
        k.y.c.b(i3.class);
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

    public i3(f2 f2Var, h3 h3Var) {
        super(f2Var);
        k.y.c.b(i3.class);
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
