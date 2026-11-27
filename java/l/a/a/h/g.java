package l.a.a.h;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l.a.a.f.q;
import l.a.a.f.r;

/* loaded from: classes.dex */
public class g extends a<f> {
    public g(q qVar, char[] cArr, l.a.a.d.e eVar, k kVar) {
        super(qVar, cArr, eVar, kVar);
    }

    private List<File> z(f fVar) throws l.a.a.c.b {
        ArrayList arrayList = new ArrayList();
        for (File file : fVar.b) {
            arrayList.add(file);
            boolean zU = l.a.a.i.d.u(file);
            r rVarN = fVar.c.n();
            if (zU && !r.INCLUDE_LINK_ONLY.equals(rVarN)) {
                arrayList.addAll(l.a.a.i.d.m(file, fVar.c));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void f(f fVar, l.a.a.g.d dVar) throws IOException {
        x(fVar.c);
        l(z(fVar), dVar, fVar.c, fVar.a);
    }

    @Override // l.a.a.h.a, l.a.a.h.l
    protected l.a.a.g.c g() {
        return super.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public long d(f fVar) throws l.a.a.c.b {
        return o(fVar.b, fVar.c);
    }
}
