package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
class e extends q0 {
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private k.w f2120h;

    /* renamed from: i, reason: collision with root package name */
    private n1 f2121i;

    static {
        k.y.c.b(e.class);
    }

    public e(k.w wVar) {
        this.f2120h = wVar;
    }

    private byte[] o() {
        t0[] t0VarArrL = this.f2121i.l();
        int length = t0VarArrL.length;
        byte[] bArrA = t0VarArrL[0].a();
        int length2 = bArrA.length;
        int length3 = bArrA.length + 4;
        byte[] bArr = new byte[length3];
        System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
        i1 i1Var = i1.L;
        bArr[length2] = i1Var.a();
        bArr[length2 + 1] = 2;
        int i2 = length2 + 2;
        byte[] bArrA2 = t0VarArrL[1].a();
        int length4 = bArrA2.length + length3;
        byte[] bArr2 = new byte[length4];
        System.arraycopy(bArr, 0, bArr2, 0, length3);
        System.arraycopy(bArrA2, 0, bArr2, length3, bArrA2.length);
        int i3 = length4 + 4;
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr2, 0, bArr3, 0, length4);
        bArr3[length4] = i1Var.a();
        bArr3[length4 + 1] = 8;
        int i4 = length4 + 2;
        if (length > 2) {
            k.x.s0.f((i3 - i2) - 2, bArr3, i2);
            byte[] bArrA3 = t0VarArrL[length - 1].a();
            int length5 = bArrA3.length + i3;
            byte[] bArr4 = new byte[length5];
            System.arraycopy(bArr3, 0, bArr4, 0, i3);
            System.arraycopy(bArrA3, 0, bArr4, i3, bArrA3.length);
            bArr3 = new byte[length5 + 4];
            System.arraycopy(bArr4, 0, bArr3, 0, length5);
            bArr3[length5] = i1Var.a();
            bArr3[length5 + 1] = 8;
            bArr3[length5 + 2] = 3;
        }
        int length6 = bArr3.length;
        int length7 = bArr3.length + 4;
        byte[] bArr5 = new byte[length7];
        System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        bArr5[length6] = i1.K.a();
        bArr5[length6 + 1] = (byte) length;
        bArr5[length6 + 2] = 1;
        bArr5[length6 + 3] = 0;
        int i5 = length7 - 1;
        if (length < 3) {
            k.x.s0.f((i5 - i2) - 5, bArr5, i2);
        }
        k.x.s0.f((i5 - i4) - 2, bArr5, i4);
        return bArr5;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[0];
        if (!r()) {
            return q() ? o() : bArr;
        }
        t0[] t0VarArrL = l();
        int length = t0VarArrL.length - 1;
        while (length >= 0) {
            byte[] bArrA = t0VarArrL[length].a();
            byte[] bArr2 = new byte[bArr.length + bArrA.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bArrA, 0, bArr2, bArr.length, bArrA.length);
            length--;
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + 4];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = i1.L.a();
        bArr3[bArr.length + 1] = 16;
        return bArr3;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        int i2 = this.f;
        if ((i2 & 16) != 0) {
            t0[] t0VarArrL = l();
            stringBuffer.append(y.f.e(this.f2120h));
            stringBuffer.append('(');
            t0VarArrL[0].c(stringBuffer);
            stringBuffer.append(')');
            return;
        }
        if ((i2 & 2) != 0) {
            stringBuffer.append(y.f2149h.e(this.f2120h));
            stringBuffer.append('(');
            t0[] t0VarArrL2 = this.f2121i.l();
            for (int i3 = 0; i3 < t0VarArrL2.length - 1; i3++) {
                t0VarArrL2[i3].c(stringBuffer);
                stringBuffer.append(',');
            }
            t0VarArrL2[t0VarArrL2.length - 1].c(stringBuffer);
            stringBuffer.append(')');
        }
    }

    @Override // k.x.j1.q0
    public void k(Stack stack) {
        int i2 = this.f;
        if ((i2 & 16) != 0) {
            j((t0) stack.pop());
        } else if ((i2 & 2) != 0) {
            j((t0) stack.pop());
        }
    }

    @Override // k.x.j1.q0
    int m() {
        return 3;
    }

    public boolean p() {
        return (this.f & 4) != 0;
    }

    public boolean q() {
        return (this.f & 2) != 0;
    }

    public boolean r() {
        return (this.f & 16) != 0;
    }

    public int s(byte[] bArr, int i2) {
        this.f = bArr[i2];
        this.g = k.x.s0.c(bArr[i2 + 1], bArr[i2 + 2]);
        if (p()) {
            return ((this.g + 1) * 2) + 3;
        }
        return 3;
    }

    void t(n1 n1Var) {
        this.f2121i = n1Var;
        this.f |= 2;
    }

    public e(c1 c1Var, k.w wVar) {
        this.f2120h = wVar;
        if (c1Var.j(wVar) == y.f) {
            this.f |= 16;
        } else if (c1Var.j(this.f2120h) == y.f2149h) {
            this.f |= 2;
        }
    }
}
