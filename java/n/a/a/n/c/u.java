package n.a.a.n.c;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class u {
    private final Map<Object, v> a = new HashMap();

    public v a(l lVar) {
        return this.a.get(lVar.j());
    }

    public void b(l lVar, v vVar) {
        this.a.put(lVar.j(), vVar);
    }
}
