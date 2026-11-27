package k.x.j1;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class f0 extends g1 {
    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        t0[] t0VarArrK = k();
        if (t0VarArrK.length == 1) {
            t0VarArrK[0].c(stringBuffer);
        } else if (t0VarArrK.length == 2) {
            t0VarArrK[1].c(stringBuffer);
            stringBuffer.append(NameUtil.COLON);
            t0VarArrK[0].c(stringBuffer);
        }
    }

    @Override // k.x.j1.g1
    public int l(byte[] bArr, int i2) {
        m(k.x.s0.c(bArr[i2 + 4], bArr[i2 + 5]));
        return 6;
    }
}
