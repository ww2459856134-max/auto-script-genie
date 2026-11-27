package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
class n1 extends q0 {
    private y f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2137h = true;

    /* renamed from: i, reason: collision with root package name */
    private k.w f2138i;

    static {
        k.y.c.b(n1.class);
    }

    public n1(k.w wVar) {
        this.f2138i = wVar;
    }

    private void p() {
        if (this.f == y.g) {
            t0[] t0VarArrL = l();
            for (int length = t0VarArrL.length - 1; length >= 0; length--) {
                if (t0VarArrL[length] instanceof c) {
                    t0VarArrL[length].e();
                }
            }
        }
    }

    @Override // k.x.j1.t0
    byte[] a() {
        p();
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
        byte[] bArr3 = new byte[bArr.length + 4];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = !i() ? i1.K.a() : i1.K.b();
        bArr3[bArr.length + 1] = (byte) this.g;
        k.x.s0.f(this.f.a(), bArr3, bArr.length + 2);
        return bArr3;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.f.e(this.f2138i));
        stringBuffer.append('(');
        if (this.g > 0) {
            t0[] t0VarArrL = l();
            if (this.f2137h) {
                t0VarArrL[0].c(stringBuffer);
                for (int i2 = 1; i2 < this.g; i2++) {
                    stringBuffer.append(',');
                    t0VarArrL[i2].c(stringBuffer);
                }
            } else {
                t0VarArrL[this.g - 1].c(stringBuffer);
                for (int i3 = this.g - 2; i3 >= 0; i3--) {
                    stringBuffer.append(',');
                    t0VarArrL[i3].c(stringBuffer);
                }
            }
        }
        stringBuffer.append(')');
    }

    @Override // k.x.j1.q0
    public void k(Stack stack) {
        int i2 = this.g;
        t0[] t0VarArr = new t0[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            t0VarArr[i3] = (t0) stack.pop();
        }
        for (int i4 = 0; i4 < this.g; i4++) {
            j(t0VarArr[i4]);
        }
    }

    @Override // k.x.j1.q0
    int m() {
        return 3;
    }

    y o() {
        return this.f;
    }

    public int q(byte[] bArr, int i2) throws w {
        this.g = bArr[i2];
        int iC = k.x.s0.c(bArr[i2 + 1], bArr[i2 + 2]);
        y yVarB = y.b(iC);
        this.f = yVarB;
        if (yVarB != y.f2150i) {
            return 3;
        }
        throw new w(w.d, iC);
    }

    public n1(y yVar, int i2, k.w wVar) {
        this.f = yVar;
        this.g = i2;
        this.f2138i = wVar;
    }
}
