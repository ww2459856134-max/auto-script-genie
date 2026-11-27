package h.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class e<K, V> implements Iterable<Map.Entry<K, V>> {
    d<K, V> c;
    private d<K, V> d;
    private WeakHashMap<g<K, V>, Boolean> e = new WeakHashMap<>();
    private int f = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public class a implements Iterator<Map.Entry<K, V>>, g<K, V> {
        private d<K, V> c;
        private boolean d = true;

        a() {
        }

        @Override // h.b.a.b.g
        public void a(d<K, V> dVar) {
            d<K, V> dVar2 = this.c;
            if (dVar == dVar2) {
                d<K, V> dVar3 = dVar2.f;
                this.c = dVar3;
                this.d = dVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.d) {
                this.d = false;
                this.c = e.this.c;
            } else {
                d<K, V> dVar = this.c;
                this.c = dVar != null ? dVar.e : null;
            }
            return this.c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.d) {
                return e.this.c != null;
            }
            d<K, V> dVar = this.c;
            return (dVar == null || dVar.e == null) ? false : true;
        }
    }

    public Iterator<Map.Entry<K, V>> a() {
        c cVar = new c(this.d, this.c);
        this.e.put(cVar, Boolean.FALSE);
        return cVar;
    }

    public Map.Entry<K, V> b() {
        return this.c;
    }

    protected d<K, V> e(K k2) {
        d<K, V> dVar = this.c;
        while (dVar != null && !dVar.c.equals(k2)) {
            dVar = dVar.e;
        }
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (size() != eVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = eVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public e<K, V>.a g() {
        e<K, V>.a aVar = new a();
        this.e.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Map.Entry<K, V> h() {
        return this.d;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        b bVar = new b(this.c, this.d);
        this.e.put(bVar, Boolean.FALSE);
        return bVar;
    }

    protected d<K, V> j(K k2, V v) {
        d<K, V> dVar = new d<>(k2, v);
        this.f++;
        d<K, V> dVar2 = this.d;
        if (dVar2 == null) {
            this.c = dVar;
            this.d = dVar;
            return dVar;
        }
        dVar2.e = dVar;
        dVar.f = dVar2;
        this.d = dVar;
        return dVar;
    }

    public V k(K k2, V v) {
        d<K, V> dVarE = e(k2);
        if (dVarE != null) {
            return dVarE.d;
        }
        j(k2, v);
        return null;
    }

    public V l(K k2) {
        d<K, V> dVarE = e(k2);
        if (dVarE == null) {
            return null;
        }
        this.f--;
        if (!this.e.isEmpty()) {
            Iterator<g<K, V>> it = this.e.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(dVarE);
            }
        }
        d<K, V> dVar = dVarE.f;
        if (dVar != null) {
            dVar.e = dVarE.e;
        } else {
            this.c = dVarE.e;
        }
        d<K, V> dVar2 = dVarE.e;
        if (dVar2 != null) {
            dVar2.f = dVar;
        } else {
            this.d = dVar;
        }
        dVarE.e = null;
        dVarE.f = null;
        return dVarE.d;
    }

    public int size() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
