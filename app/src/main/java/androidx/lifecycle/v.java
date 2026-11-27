package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class v {
    private final HashMap<String, t> a = new HashMap<>();

    public final void a() {
        Iterator<t> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }

    final t b(String str) {
        return this.a.get(str);
    }

    Set<String> c() {
        return new HashSet(this.a.keySet());
    }

    final void d(String str, t tVar) {
        t tVarPut = this.a.put(str, tVar);
        if (tVarPut != null) {
            tVarPut.d();
        }
    }
}
