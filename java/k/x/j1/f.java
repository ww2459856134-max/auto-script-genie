package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
abstract class f extends q0 {
    static {
        k.y.c.b(f.class);
    }

    @Override // k.x.j1.t0
    byte[] a() {
        t0[] t0VarArrL = l();
        byte[] bArr = new byte[0];
        int length = t0VarArrL.length - 1;
        while (length >= 0) {
            byte[] bArrA = t0VarArrL[length].a();
            byte[] bArr2 = new byte[bArr.length + bArrA.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bArrA, 0, bArr2, bArr.length, bArrA.length);
            length--;
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + 1];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = p().a();
        return bArr3;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        t0[] t0VarArrL = l();
        t0VarArrL[1].c(stringBuffer);
        stringBuffer.append(o());
        t0VarArrL[0].c(stringBuffer);
    }

    @Override // k.x.j1.q0
    public void k(Stack stack) {
        t0 t0Var = (t0) stack.pop();
        t0 t0Var2 = (t0) stack.pop();
        j(t0Var);
        j(t0Var2);
    }

    abstract String o();

    abstract i1 p();

    public int q(byte[] bArr, int i2) {
        return 0;
    }
}
