package l.a.a.h;

import java.util.Comparator;

/* loaded from: classes.dex */
class c implements Comparator<l.a.a.f.i> {
    c(d dVar) {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(l.a.a.f.i iVar, l.a.a.f.i iVar2) {
        if (iVar.j().equals(iVar2.j())) {
            return 0;
        }
        return iVar.Q() < iVar2.Q() ? -1 : 1;
    }
}
