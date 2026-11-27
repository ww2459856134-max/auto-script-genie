package k.a0.a;

/* loaded from: classes.dex */
public class t0 extends k.x.w0 {
    public static s0 d;
    private String c;

    static {
        k.y.c.b(t0.class);
        d = new s0();
    }

    t0(f2 f2Var, k.w wVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        if (bArrC.length == 0) {
            return;
        }
        int iC = k.x.s0.c(bArrC[0], bArrC[1]);
        if (bArrC[2] == 1) {
            this.c = k.x.y0.g(bArrC, iC, 3);
        } else {
            this.c = k.x.y0.d(bArrC, iC, 3, wVar);
        }
    }

    String y() {
        return this.c;
    }

    t0(f2 f2Var, k.w wVar, s0 s0Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        if (bArrC.length == 0) {
            return;
        }
        this.c = k.x.y0.d(bArrC, bArrC[0], 1, wVar);
    }
}
