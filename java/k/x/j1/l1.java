package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
abstract class l1 extends q0 {
    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArrA = l()[0].a();
        byte[] bArr = new byte[bArrA.length + 1];
        System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
        bArr[bArrA.length] = p().a();
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        t0[] t0VarArrL = l();
        stringBuffer.append(o());
        t0VarArrL[0].c(stringBuffer);
    }

    @Override // k.x.j1.q0
    public void k(Stack stack) {
        j((t0) stack.pop());
    }

    abstract String o();

    abstract i1 p();

    public int q(byte[] bArr, int i2) {
        return 0;
    }
}
