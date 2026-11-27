package k.a0.a;

/* loaded from: classes.dex */
public class e0 extends k.x.w0 {
    private String c;
    private boolean d;

    static {
        k.y.c.b(e0.class);
    }

    e0(f2 f2Var, k.w wVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        if (k.x.s0.c(bArrC[0], bArrC[1]) == 0) {
            this.d = true;
        }
        if (this.d) {
            byte b = bArrC[6];
            if (bArrC[7] != 0) {
                this.c = k.x.y0.g(bArrC, b, 8);
            } else {
                this.c = k.x.y0.d(bArrC, b, 8, wVar);
            }
        }
    }

    public String getName() {
        return this.c;
    }

    public boolean y() {
        return this.d;
    }
}
