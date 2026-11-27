package l.a.a.h;

import java.io.IOException;
import l.a.a.f.q;

/* loaded from: classes.dex */
public class n extends b<m> {
    private final char[] f;
    private l.a.a.e.a.i g;

    public n(q qVar, char[] cArr, l.a.a.f.k kVar, k kVar2) {
        super(qVar, kVar, kVar2);
        this.f = cArr;
    }

    private l.a.a.f.i x(q qVar) {
        if (qVar.a() == null || qVar.a().a() == null || qVar.a().a().size() == 0) {
            return null;
        }
        return qVar.a().a().get(0);
    }

    private l.a.a.e.a.l y(l.a.a.f.l lVar) throws IOException {
        this.g = l.a.a.i.h.b(q());
        l.a.a.f.i iVarX = x(q());
        if (iVarX != null) {
            this.g.a(iVarX);
        }
        return new l.a.a.e.a.l(this.g, this.f, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public long d(m mVar) {
        return l.a.a.d.d.f(q().a().a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void f(m mVar, l.a.a.g.d dVar) throws IOException {
        try {
            l.a.a.e.a.l lVarY = y(mVar.a);
            try {
                for (l.a.a.f.i iVar : q().a().a()) {
                    if (iVar.j().startsWith("__MACOSX")) {
                        dVar.l(iVar.n());
                    } else {
                        this.g.a(iVar);
                        o(lVarY, iVar, mVar.b, null, dVar, new byte[mVar.a.a()]);
                        j();
                    }
                }
                if (lVarY != null) {
                    lVarY.close();
                }
            } finally {
            }
        } finally {
            l.a.a.e.a.i iVar2 = this.g;
            if (iVar2 != null) {
                iVar2.close();
            }
        }
    }
}
