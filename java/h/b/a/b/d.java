package h.b.a.b;

import java.util.Map;

/* loaded from: classes.dex */
class d<K, V> implements Map.Entry<K, V> {
    final K c;
    final V d;
    d<K, V> e;
    d<K, V> f;

    d(K k2, V v) {
        this.c = k2;
        this.d = v;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.c.equals(dVar.c) && this.d.equals(dVar.d);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.c;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.d;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return this.c.hashCode() ^ this.d.hashCode();
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public String toString() {
        return this.c + "=" + this.d;
    }
}
