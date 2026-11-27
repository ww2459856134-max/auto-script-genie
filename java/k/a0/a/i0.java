package k.a0.a;

/* loaded from: classes.dex */
public class i0 extends k.x.w0 {
    private static k.y.c d = k.y.c.b(i0.class);
    public static g0 e = new g0();
    private h0[] c;

    i0(f2 f2Var, k.w wVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        int iC = k.x.s0.c(bArrC[0], bArrC[1]);
        int i2 = 2;
        if (bArrC.length < (iC * 6) + 2) {
            this.c = new h0[0];
            d.f("Could not process external sheets.  Formulas may be compromised.");
            return;
        }
        this.c = new h0[iC];
        for (int i3 = 0; i3 < iC; i3++) {
            this.c[i3] = new h0(k.x.s0.c(bArrC[i2], bArrC[i2 + 1]), k.x.s0.c(bArrC[i2 + 2], bArrC[i2 + 3]), k.x.s0.c(bArrC[i2 + 4], bArrC[i2 + 5]));
            i2 += 6;
        }
    }

    public int A() {
        h0[] h0VarArr = this.c;
        if (h0VarArr != null) {
            return h0VarArr.length;
        }
        return 0;
    }

    public int B(int i2) {
        return this.c[i2].a;
    }

    public int y(int i2) {
        return this.c[i2].b;
    }

    public int z(int i2) {
        return this.c[i2].c;
    }

    i0(f2 f2Var, k.w wVar, g0 g0Var) {
        super(f2Var);
        d.f("External sheet record for Biff 7 not supported");
    }
}
