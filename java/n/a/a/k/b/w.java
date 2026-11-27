package n.a.a.k.b;

import i.b.ha.a.b.d.c.o1;

/* loaded from: classes.dex */
class w implements Comparable<w> {
    final o1 c;
    final o d;
    final String e;
    final /* synthetic */ x f;

    w(x xVar, o1 o1Var, n.a.a.k.b.z.d dVar) {
        o oVarB;
        this.f = xVar;
        this.c = o1Var;
        String name = o1Var.getName();
        if (!x.n0(o1Var)) {
            try {
            } catch (Exception e) {
                x.J.atWarn().withThrowable(e).log("Entry {} is not valid, so this part won't be added to the package.", name);
            }
            oVarB = "[Content_Types].xml".equalsIgnoreCase(name) ? null : s.b(n.a.a.k.b.z.q.c(name));
        }
        this.d = oVarB;
        this.e = oVarB != null ? dVar.g(oVarB) : null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        int iCompare = Integer.compare("application/vnd.openxmlformats-package.relationships+xml".equals(this.e) ? -1 : 1, "application/vnd.openxmlformats-package.relationships+xml".equals(wVar.e) ? -1 : 1);
        return iCompare != 0 ? iCompare : this.d.compareTo(wVar.d);
    }

    void b(n nVar) throws n.a.a.k.a.a {
        if (this.e == null) {
            throw new n.a.a.k.a.a("The part " + this.d.g().getPath() + " does not have any content type ! Rule: Package require content types when retrieving a part from a package. [M.1.14]");
        }
        if (nVar.b(this.d)) {
            throw new n.a.a.k.a.a("A part with the name '" + this.d + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
        }
        try {
            o oVar = this.d;
            nVar.g(oVar, new y(this.f, this.c, oVar, this.e, false));
        } catch (n.a.a.k.a.b e) {
            throw new n.a.a.k.a.a(e.getMessage(), e);
        }
    }
}
