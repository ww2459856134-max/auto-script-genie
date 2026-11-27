package k.x.j1;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;

/* loaded from: classes.dex */
class y0 extends f {
    @Override // k.x.j1.f, k.x.j1.t0
    byte[] a() {
        h();
        n();
        byte[] bArrA = super.a();
        byte[] bArr = new byte[bArrA.length + 3];
        System.arraycopy(bArrA, 0, bArr, 3, bArrA.length);
        bArr[0] = i1.M.a();
        k.x.s0.f(bArrA.length, bArr, 1);
        return bArr;
    }

    @Override // k.x.j1.q0
    int m() {
        return 1;
    }

    @Override // k.x.j1.f
    public String o() {
        return ParameterizedMessage.ERROR_MSG_SEPARATOR;
    }

    @Override // k.x.j1.f
    i1 p() {
        return i1.I;
    }
}
