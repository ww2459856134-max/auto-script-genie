package i.f.a.a0.d;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
final class f implements Serializable, Comparator<d> {
    private f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(d dVar, d dVar2) {
        return Float.compare(dVar.i(), dVar2.i());
    }
}
