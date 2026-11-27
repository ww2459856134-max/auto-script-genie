package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class w1 implements p6 {
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a A[Catch: p -> 0x0083, TryCatch #0 {p -> 0x0083, blocks: (B:8:0x000b, B:10:0x001d, B:12:0x0023, B:27:0x0046, B:29:0x004a, B:32:0x0055, B:33:0x005a, B:35:0x006a, B:36:0x0072, B:21:0x0037, B:22:0x003e), top: B:43:0x000b }] */
    @Override // n.a.a.n.c.t1.p6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) throws n.a.a.n.c.r1.p {
        boolean z;
        String strG;
        n.a.a.n.c.r1.w0 w0VarI;
        if (w0VarArr.length < 2 || w0VarArr.length > 5) {
            return n.a.a.n.c.r1.o.e;
        }
        boolean z2 = false;
        try {
            int iD = (int) y9.D(w0VarArr[0], i2, i3);
            int iD2 = (int) y9.D(w0VarArr[1], i2, i3);
            int iD3 = (w0VarArr.length <= 2 || w0VarArr[2] == n.a.a.n.c.r1.u.a) ? 1 : (int) y9.D(w0VarArr[2], i2, i3);
            if (iD3 != 1) {
                if (iD3 == 2) {
                    z = false;
                    z2 = true;
                } else if (iD3 == 3) {
                    z = true;
                } else if (iD3 != 4) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
                }
                strG = null;
                if (w0VarArr.length == 5 && (w0VarI = n.a.a.n.c.r1.z.i(w0VarArr[4], i2, i3)) != n.a.a.n.c.r1.u.a) {
                    strG = n.a.a.n.c.r1.z.g(w0VarI);
                }
                n.a.a.n.e.s sVar = new n.a.a.n.e.s(iD - 1, iD2 - 1, z2, z);
                StringBuilder sb = new StringBuilder(32);
                if (strG != null) {
                    n.a.a.n.c.c1.b(sb, strG);
                    sb.append('!');
                }
                sb.append(sVar.g());
                return new n.a.a.n.c.r1.m0(sb.toString());
            }
            z2 = true;
            z = z2;
            strG = null;
            if (w0VarArr.length == 5) {
                strG = n.a.a.n.c.r1.z.g(w0VarI);
            }
            n.a.a.n.e.s sVar2 = new n.a.a.n.e.s(iD - 1, iD2 - 1, z2, z);
            StringBuilder sb2 = new StringBuilder(32);
            if (strG != null) {
            }
            sb2.append(sVar2.g());
            return new n.a.a.n.c.r1.m0(sb2.toString());
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
