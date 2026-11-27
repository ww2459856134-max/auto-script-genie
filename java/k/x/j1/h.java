package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
class h extends q0 {
    private y f;
    private k.w g;

    static {
        k.y.c.b(h.class);
    }

    public h(k.w wVar) {
        this.g = wVar;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        t0[] t0VarArrL = l();
        byte[] bArr = new byte[0];
        int i2 = 0;
        while (i2 < t0VarArrL.length) {
            byte[] bArrA = t0VarArrL[i2].a();
            byte[] bArr2 = new byte[bArr.length + bArrA.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bArrA, 0, bArr2, bArr.length, bArrA.length);
            i2++;
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + 3];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = !i() ? i1.J.a() : i1.J.b();
        k.x.s0.f(this.f.a(), bArr3, bArr.length + 1);
        return bArr3;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.f.e(this.g));
        stringBuffer.append('(');
        int iF = this.f.f();
        if (iF > 0) {
            t0[] t0VarArrL = l();
            t0VarArrL[0].c(stringBuffer);
            for (int i2 = 1; i2 < iF; i2++) {
                stringBuffer.append(',');
                t0VarArrL[i2].c(stringBuffer);
            }
        }
        stringBuffer.append(')');
    }

    @Override // k.x.j1.q0
    public void k(Stack stack) {
        t0[] t0VarArr = new t0[this.f.f()];
        for (int iF = this.f.f() - 1; iF >= 0; iF--) {
            t0VarArr[iF] = (t0) stack.pop();
        }
        for (int i2 = 0; i2 < this.f.f(); i2++) {
            j(t0VarArr[i2]);
        }
    }

    @Override // k.x.j1.q0
    int m() {
        return 3;
    }

    public int o(byte[] bArr, int i2) {
        int iC = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        y yVarB = y.b(iC);
        this.f = yVarB;
        k.y.a.b(yVarB != y.f2150i, "function code " + iC);
        return 2;
    }

    public h(y yVar, k.w wVar) {
        this.f = yVar;
        this.g = wVar;
    }
}
