package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
class i1 implements b0 {
    final /* synthetic */ b0 c;
    final /* synthetic */ o1 d;

    i1(o1 o1Var, b0 b0Var) {
        this.d = o1Var;
        this.c = b0Var;
    }

    @Override // i.b.ha.a.b.d.c.r0
    public a2 a(byte[] bArr, int i2, int i3, boolean z, int i4) throws ZipException {
        return this.c.a(bArr, i2, i3, z, i4);
    }

    @Override // i.b.ha.a.b.d.c.b0
    public a2 b(a2 a2Var, byte[] bArr, int i2, int i3, boolean z) throws ZipException {
        return this.c.b(a2Var, bArr, i2, i3, z);
    }

    @Override // i.b.ha.a.b.d.c.b0
    public a2 c(l2 l2Var) throws IllegalAccessException, ZipException, InstantiationException {
        a2 a2Var = (a2) this.d.D.apply(l2Var);
        return a2Var == null ? this.c.c(l2Var) : a2Var;
    }
}
