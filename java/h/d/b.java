package h.d;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class b<K, V> extends i<K, V> implements Map<K, V> {

    /* renamed from: j, reason: collision with root package name */
    h<K, V> f1271j;

    public b() {
    }

    private h<K, V> n() {
        if (this.f1271j == null) {
            this.f1271j = new a(this);
        }
        return this.f1271j;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return h.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.e + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }

    public b(int i2) {
        super(i2);
    }
}
