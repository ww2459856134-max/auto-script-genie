package l.a.a.h;

import java.io.File;
import java.io.IOException;
import java.util.List;
import l.a.a.f.q;

/* loaded from: classes.dex */
public class i extends a<h> {
    public i(q qVar, char[] cArr, l.a.a.d.e eVar, k kVar) {
        super(qVar, cArr, eVar, kVar);
    }

    private List<File> A(h hVar) throws l.a.a.c.b {
        List<File> listM = l.a.a.i.d.m(hVar.b, hVar.c);
        if (hVar.c.p()) {
            listM.add(hVar.b);
        }
        return listM;
    }

    private void B(h hVar) throws IOException {
        File file = hVar.b;
        String canonicalPath = (!hVar.c.p() || file.getCanonicalFile().getParentFile() == null) ? file.getCanonicalPath() : file.getCanonicalFile().getParentFile().getCanonicalPath();
        hVar.c.x(canonicalPath);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public long d(h hVar) throws l.a.a.c.b {
        List<File> listA = A(hVar);
        if (hVar.c.p()) {
            listA.add(hVar.b);
        }
        return o(listA, hVar.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.h.l
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void f(h hVar, l.a.a.g.d dVar) throws IOException {
        List<File> listA = A(hVar);
        B(hVar);
        l(listA, dVar, hVar.c, hVar.a);
    }
}
