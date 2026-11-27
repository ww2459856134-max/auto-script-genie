package h.b.a.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends e<K, V> {
    private HashMap<K, d<K, V>> g = new HashMap<>();

    public boolean contains(K k2) {
        return this.g.containsKey(k2);
    }

    @Override // h.b.a.b.e
    protected d<K, V> e(K k2) {
        return this.g.get(k2);
    }

    @Override // h.b.a.b.e
    public V k(K k2, V v) {
        d<K, V> dVarE = e(k2);
        if (dVarE != null) {
            return dVarE.d;
        }
        this.g.put(k2, j(k2, v));
        return null;
    }

    @Override // h.b.a.b.e
    public V l(K k2) {
        V v = (V) super.l(k2);
        this.g.remove(k2);
        return v;
    }

    public Map.Entry<K, V> p(K k2) {
        if (contains(k2)) {
            return this.g.get(k2).f;
        }
        return null;
    }
}
