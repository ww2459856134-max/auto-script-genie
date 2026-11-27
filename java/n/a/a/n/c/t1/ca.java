package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class ca implements p6 {
    private static n.a.a.n.c.r1.j a(aa aaVar, ba baVar, ba baVar2) throws n.a.a.n.c.r1.p {
        ba baVarD = baVar.d(aaVar.b());
        ba baVarD2 = baVar2.d(aaVar.a());
        n.a.a.n.a aVar = n.a.a.n.a.EXCEL2007;
        if (baVarD.c(0, aVar.c())) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f);
        }
        if (baVarD2.c(0, aVar.a())) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f);
        }
        return aaVar.e(baVar.a(), baVar.b(), baVar2.a(), baVar2.b());
    }

    private static aa b(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            return new aa((n.a.a.n.c.r1.c0) w0Var);
        }
        if (w0Var instanceof n.a.a.n.c.r1.j) {
            return new aa((n.a.a.n.c.r1.j) w0Var);
        }
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0Var);
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    static int c(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050 A[Catch: p -> 0x006d, TryCatch #0 {p -> 0x006d, blocks: (B:8:0x000b, B:12:0x001f, B:16:0x002d, B:29:0x005b, B:31:0x006a, B:20:0x003c, B:22:0x0042, B:23:0x0049, B:25:0x0050, B:15:0x0027, B:11:0x0019), top: B:38:0x000b }] */
    @Override // n.a.a.n.c.t1.p6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 1 || w0VarArr.length > 5) {
            return n.a.a.n.c.r1.o.e;
        }
        int iC = 0;
        try {
            aa aaVarB = b(w0VarArr[0]);
            int iC2 = w0VarArr[1] instanceof n.a.a.n.c.r1.u ? 0 : c(w0VarArr[1], i2, i3);
            if (!(w0VarArr[2] instanceof n.a.a.n.c.r1.u)) {
                iC = c(w0VarArr[2], i2, i3);
            }
            int iC3 = aaVarB.c();
            int iD = aaVarB.d();
            int length = w0VarArr.length;
            if (length == 4) {
                if (!(w0VarArr[3] instanceof n.a.a.n.c.r1.u)) {
                    iC3 = c(w0VarArr[3], i2, i3);
                }
            } else if (length == 5) {
                if (!(w0VarArr[4] instanceof n.a.a.n.c.r1.u)) {
                    iD = c(w0VarArr[4], i2, i3);
                }
                if (!(w0VarArr[3] instanceof n.a.a.n.c.r1.u)) {
                }
            }
            if (iC3 != 0 && iD != 0) {
                return a(aaVarB, new ba(iC2, iC3), new ba(iC, iD));
            }
            return n.a.a.n.c.r1.o.f;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
