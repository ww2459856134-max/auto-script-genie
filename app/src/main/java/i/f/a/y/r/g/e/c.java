package i.f.a.y.r.g.e;

/* loaded from: classes.dex */
final class c extends h {
    c(i.f.a.v.a aVar) {
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
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}
