package i.f.a.y.r.g.e;

/* loaded from: classes.dex */
final class d extends h {
    d(i.f.a.v.a aVar) {
        super(aVar);
    }

    @Override // i.f.a.y.r.g.e.j
    public String d() throws i.f.a.k, i.f.a.g {
        if (c().k() < 48) {
            throw i.f.a.k.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int iF = b().f(48, 2);
        sb.append("(393");
        sb.append(iF);
        sb.append(')');
        int iF2 = b().f(50, 10);
        if (iF2 / 100 == 0) {
            sb.append('0');
        }
        if (iF2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iF2);
        sb.append(b().c(60, null).b());
        return sb.toString();
    }
}
