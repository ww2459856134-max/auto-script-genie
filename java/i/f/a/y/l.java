package i.f.a.y;

import java.util.Map;

/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: h, reason: collision with root package name */
    private final p f1702h = new e();

    private static i.f.a.p s(i.f.a.p pVar) throws i.f.a.g {
        String strF = pVar.f();
        if (strF.charAt(0) != '0') {
            throw i.f.a.g.a();
        }
        i.f.a.p pVar2 = new i.f.a.p(strF.substring(1), null, pVar.e(), i.f.a.a.UPC_A);
        if (pVar.d() != null) {
            pVar2.g(pVar.d());
        }
        return pVar2;
    }

    @Override // i.f.a.y.k, i.f.a.n
    public i.f.a.p a(i.f.a.c cVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.g {
        return s(this.f1702h.a(cVar, map));
    }

    @Override // i.f.a.y.p, i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g {
        return s(this.f1702h.c(i2, aVar, map));
    }

    @Override // i.f.a.y.p
    protected int l(i.f.a.v.a aVar, int[] iArr, StringBuilder sb) throws i.f.a.k {
        return this.f1702h.l(aVar, iArr, sb);
    }

    @Override // i.f.a.y.p
    public i.f.a.p m(int i2, i.f.a.v.a aVar, int[] iArr, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g {
        return s(this.f1702h.m(i2, aVar, iArr, map));
    }

    @Override // i.f.a.y.p
    i.f.a.a q() {
        return i.f.a.a.UPC_A;
    }
}
