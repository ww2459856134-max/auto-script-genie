package h.b.a.b;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
abstract class f<K, V> implements Iterator<Map.Entry<K, V>>, g<K, V> {
    d<K, V> c;
    d<K, V> d;

    f(d<K, V> dVar, d<K, V> dVar2) {
        this.c = dVar2;
        this.d = dVar;
    }

    private d<K, V> e() {
        d<K, V> dVar = this.d;
        d<K, V> dVar2 = this.c;
        if (dVar == dVar2 || dVar2 == null) {
            return null;
        }
        return c(dVar);
    }

    @Override // h.b.a.b.g
    public void a(d<K, V> dVar) {
        if (this.c == dVar && dVar == this.d) {
            this.d = null;
            this.c = null;
        }
        d<K, V> dVar2 = this.c;
        if (dVar2 == dVar) {
            this.c = b(dVar2);
        }
        if (this.d == dVar) {
            this.d = e();
        }
    }

    abstract d<K, V> b(d<K, V> dVar);

    abstract d<K, V> c(d<K, V> dVar);

    @Override // java.util.Iterator
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        d<K, V> dVar = this.d;
        this.d = e();
        return dVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.d != null;
    }
}
