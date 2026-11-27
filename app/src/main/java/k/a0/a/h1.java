package k.a0.a;

/* loaded from: classes.dex */
public class h1 extends k.x.w0 {
    private k.r[] c;

    h1(f2 f2Var, k.s sVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        int iC = k.x.s0.c(bArrC[0], bArrC[1]);
        this.c = new k.r[iC];
        int i2 = 2;
        for (int i3 = 0; i3 < iC; i3++) {
            int iC2 = k.x.s0.c(bArrC[i2], bArrC[i2 + 1]);
            int iC3 = k.x.s0.c(bArrC[i2 + 2], bArrC[i2 + 3]);
            this.c[i3] = new k.x.x0(sVar, k.x.s0.c(bArrC[i2 + 4], bArrC[i2 + 5]), iC2, k.x.s0.c(bArrC[i2 + 6], bArrC[i2 + 7]), iC3);
            i2 += 8;
        }
    }

    public k.r[] y() {
        return this.c;
    }
}
