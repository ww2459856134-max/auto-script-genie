package n.a.a.n.c;

import n.a.a.n.c.u1.f2;
import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.q2;
import n.a.a.n.c.u1.r2;

/* loaded from: classes.dex */
public class a1 {
    private final int a;
    private final int b;

    public a1(n.a.a.n.a aVar) {
        this.a = aVar.a();
        this.b = aVar.c();
    }

    private int b(int i2, int i3, boolean z) {
        if (!z) {
            return i3;
        }
        return this.a & (i3 + i2);
    }

    private int c(int i2, int i3, boolean z) {
        if (!z) {
            return i3;
        }
        return this.b & (i3 + i2);
    }

    public k2[] a(k2[] k2VarArr, int i2, int i3) {
        a1 a1Var = this;
        k2[] k2VarArr2 = new k2[k2VarArr.length];
        int i4 = 0;
        while (i4 < k2VarArr.length) {
            k2 k2VarP = k2VarArr[i4];
            byte bI = k2VarP.m() ? (byte) -1 : k2VarP.i();
            if (k2VarP instanceof r2) {
                r2 r2Var = (r2) k2VarP;
                q2 q2Var = new q2(a1Var.c(i2, r2Var.s(), r2Var.u()), a1Var.b(i3, r2Var.r(), r2Var.t()), r2Var.u(), r2Var.t());
                q2Var.n(bI);
                k2VarP = q2Var;
            } else if (k2VarP instanceof n.a.a.n.c.u1.f1) {
                n.a.a.n.c.u1.f1 f1Var = (n.a.a.n.c.u1.f1) k2VarP;
                n.a.a.n.c.u1.e1 e1Var = new n.a.a.n.c.u1.e1(a1Var.c(i2, f1Var.getFirstRow(), f1Var.s()), a1Var.c(i2, f1Var.getLastRow(), f1Var.u()), a1Var.b(i3, f1Var.getFirstColumn(), f1Var.r()), a1Var.b(i3, f1Var.getLastColumn(), f1Var.t()), f1Var.s(), f1Var.u(), f1Var.r(), f1Var.t());
                e1Var.n(bI);
                k2VarP = e1Var;
            } else if (k2VarP instanceof f2) {
                k2VarP = ((f2) k2VarP).p();
            }
            k2VarArr2[i4] = k2VarP;
            i4++;
            a1Var = this;
        }
        return k2VarArr2;
    }
}
