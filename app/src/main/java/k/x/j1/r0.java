package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
class r0 extends q0 {
    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArrA = l()[0].a();
        byte[] bArr = new byte[bArrA.length + 1];
        System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
        bArr[bArrA.length] = o().a();
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        t0[] t0VarArrL = l();
        stringBuffer.append('(');
        t0VarArrL[0].c(stringBuffer);
        stringBuffer.append(')');
    }

    @Override // k.x.j1.q0
    public void k(Stack stack) {
        j((t0) stack.pop());
    }

    @Override // k.x.j1.q0
    int m() {
        return 4;
    }

    i1 o() {
        return i1.v;
    }

    public int p(byte[] bArr, int i2) {
        return 0;
    }
}
