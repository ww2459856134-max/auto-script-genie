package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
abstract class q0 extends t0 {
    private t0[] e = new t0[0];

    protected void j(t0 t0Var) {
        t0Var.f(this);
        t0[] t0VarArr = this.e;
        t0[] t0VarArr2 = new t0[t0VarArr.length + 1];
        System.arraycopy(t0VarArr, 0, t0VarArr2, 0, t0VarArr.length);
        t0VarArr2[this.e.length] = t0Var;
        this.e = t0VarArr2;
    }

    public abstract void k(Stack stack);

    protected t0[] l() {
        return this.e;
    }

    abstract int m();

    protected void n() {
        int i2 = 0;
        while (true) {
            t0[] t0VarArr = this.e;
            if (i2 >= t0VarArr.length) {
                return;
            }
            t0VarArr[i2].e();
            i2++;
        }
    }
}
