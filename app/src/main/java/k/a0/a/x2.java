package k.a0.a;

/* loaded from: classes.dex */
public class x2 extends b implements k.o, k.x.o0, k.u {
    protected static final w2 q;
    private String p;

    static {
        k.y.c.b(x2.class);
        q = new w2();
    }

    public x2(f2 f2Var, j0 j0Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var, k.w wVar) {
        super(f2Var, n0Var, tVar, a1Var, y2Var, j0Var.c());
        int iC = j0Var.c();
        int iC2 = j0Var.c();
        f2 f2VarE = j0Var.e();
        boolean z = false;
        int i2 = 0;
        while (f2VarE.e() != k.x.z0.D && i2 < 4) {
            f2VarE = j0Var.e();
            i2++;
        }
        k.y.a.b(i2 < 4, " @ " + iC);
        byte[] bArrC = f2VarE.c();
        f2 f2VarF = j0Var.f();
        while (f2VarF.e() == k.x.z0.v) {
            f2 f2VarE2 = j0Var.e();
            byte[] bArr = new byte[(bArrC.length + f2VarE2.d()) - 1];
            System.arraycopy(bArrC, 0, bArr, 0, bArrC.length);
            System.arraycopy(f2VarE2.c(), 1, bArr, bArrC.length, f2VarE2.d() - 1);
            f2VarF = j0Var.f();
            bArrC = bArr;
        }
        int iC3 = k.x.s0.c(bArrC[0], bArrC[1]);
        int i3 = 3;
        if (bArrC.length == iC3 + 2) {
            i3 = 2;
        } else if (bArrC[2] == 1) {
            z = true;
        }
        if (z) {
            this.p = k.x.y0.g(bArrC, iC3, i3);
        } else {
            this.p = k.x.y0.d(bArrC, iC3, i3, wVar);
        }
        j0Var.i(iC2);
    }

    @Override // k.o
    public String getString() {
        return this.p;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.f1991i;
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        if (!y().y().A()) {
            throw new k.x.j1.w(k.x.j1.w.e);
        }
        k.x.j1.x xVar = new k.x.j1.x(D(), this, A(), C(), y().x().A());
        xVar.c();
        byte[] bArrA = xVar.a();
        int length = bArrA.length + 22;
        byte[] bArr = new byte[length];
        k.x.s0.f(getRow(), bArr, 0);
        k.x.s0.f(b(), bArr, 2);
        k.x.s0.f(z(), bArr, 4);
        bArr[6] = 0;
        bArr[12] = -1;
        bArr[13] = -1;
        System.arraycopy(bArrA, 0, bArr, 22, bArrA.length);
        k.x.s0.f(bArrA.length, bArr, 20);
        int i2 = length - 6;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 6, bArr2, 0, i2);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        return this.p;
    }

    public x2(f2 f2Var, j0 j0Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var, w2 w2Var) {
        super(f2Var, n0Var, tVar, a1Var, y2Var, j0Var.c());
        this.p = "";
    }
}
