package k.b0.v;

/* loaded from: classes.dex */
public class p extends k.x.h1 {
    protected p(k.x.i0 i0Var, k.x.b0 b0Var) {
        super(i0Var, b0Var);
        U(k.x.h1.U, 0);
    }

    public void W(k.z.b bVar, k.z.c cVar, k.z.e eVar) throws k.b0.u {
        if (isInitialized()) {
            throw new d1(d1.c);
        }
        if (bVar == k.z.b.b) {
            super.T(k.z.b.e, cVar, eVar);
            super.T(k.z.b.f, cVar, eVar);
            super.T(k.z.b.c, cVar, eVar);
            super.T(k.z.b.d, cVar, eVar);
            return;
        }
        if (bVar != k.z.b.a) {
            super.T(bVar, cVar, eVar);
            return;
        }
        k.z.b bVar2 = k.z.b.e;
        k.z.c cVar2 = k.z.c.d;
        k.z.e eVar2 = k.z.e.d;
        super.T(bVar2, cVar2, eVar2);
        super.T(k.z.b.f, cVar2, eVar2);
        super.T(k.z.b.c, cVar2, eVar2);
        super.T(k.z.b.d, cVar2, eVar2);
    }

    p(k.x.h1 h1Var) {
        super(h1Var);
        U(k.x.h1.U, 0);
    }
}
