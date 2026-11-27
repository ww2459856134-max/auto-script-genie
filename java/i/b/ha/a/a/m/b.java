package i.b.ha.a.a.m;

import i.b.ha.a.a.f;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class b<K, V> implements f<K, V> {
    private transient b<K, V>.a c;
    private transient Map<K, Collection<V>> d;

    private final class a extends AbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> c;

        /* renamed from: i.b.ha.a.a.m.b$a$a, reason: collision with other inner class name */
        final class C0015a extends AbstractSet<Map.Entry<K, Collection<V>>> {
            C0015a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                a.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return a.this.c.entrySet().contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                a aVar = a.this;
                return aVar.new C0016b(aVar.c.entrySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                b.this.g(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a.this.size();
            }
        }

        /* renamed from: i.b.ha.a.a.m.b$a$b, reason: collision with other inner class name */
        final class C0016b extends i.b.ha.a.a.k.c<Map.Entry<K, Collection<V>>> {
            C0016b(Iterator<Map.Entry<K, Collection<V>>> it) {
                super(it);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // i.b.ha.a.a.k.c, java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Object key = ((Map.Entry) super.next()).getKey();
                return new i.b.ha.a.a.l.c(key, b.this.h(key));
            }
        }

        a(Map<K, Collection<V>> map) {
            this.c = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            if (this.c.get(obj) == null) {
                return null;
            }
            return b.this.h(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.c.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionD = b.this.i();
            collectionD.addAll(collectionRemove);
            collectionRemove.clear();
            return collectionD;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            b.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.c.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            return new C0015a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.c.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return b.this.f();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.c.toString();
        }
    }

    /* renamed from: i.b.ha.a.a.m.b$b, reason: collision with other inner class name */
    private final class C0017b implements Iterator<V> {
        private final Object c;
        private final Collection<V> d;
        private final Iterator<V> e;

        C0017b(Object obj) {
            this.c = obj;
            Collection<V> collection = b.this.e().get(obj);
            this.d = collection;
            this.e = collection.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.e.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.e.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.e.remove();
            if (this.d.isEmpty()) {
                b.this.g(this.c);
            }
        }
    }

    protected b() {
    }

    @Override // i.b.ha.a.a.f
    public boolean a(Object obj, Object obj2) {
        Collection<V> collection = e().get(obj);
        if (collection == null) {
            return false;
        }
        boolean zRemove = collection.remove(obj2);
        if (collection.isEmpty()) {
            e().remove(obj);
        }
        return zRemove;
    }

    @Override // i.b.ha.a.a.f
    public Map<K, Collection<V>> b() {
        b<K, V>.a aVar = this.c;
        if (aVar != null) {
            return aVar;
        }
        b<K, V>.a aVar2 = new a(this.d);
        this.c = aVar2;
        return aVar2;
    }

    public void clear() {
        e().clear();
    }

    /* renamed from: d */
    protected abstract Collection<V> i();

    protected Map<K, ? extends Collection<V>> e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return b().equals(((f) obj).b());
        }
        return false;
    }

    public Set<K> f() {
        return e().keySet();
    }

    public abstract Collection<V> g(Object obj);

    abstract Collection<V> h(K k2);

    public int hashCode() {
        return e().hashCode();
    }

    @Override // i.b.ha.a.a.f
    public boolean put(K k2, V v) {
        Collection<V> collection = e().get(k2);
        if (collection != null) {
            return collection.add(v);
        }
        Collection<V> collectionD = i();
        if (!collectionD.add(v)) {
            return false;
        }
        this.d.put(k2, collectionD);
        return true;
    }

    public String toString() {
        return e().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected b(Map<K, ? extends Collection<V>> map) {
        Objects.requireNonNull(map, "map");
        this.d = map;
    }

    class c implements Collection<V> {
        protected final K c;

        c(K k2) {
            this.c = k2;
        }

        protected abstract Collection<V> a();

        @Override // java.util.Collection
        public boolean add(V v) {
            Collection<V> collectionA = a();
            if (collectionA == null) {
                collectionA = b.this.i();
                b.this.d.put(this.c, collectionA);
            }
            return collectionA.add(v);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            Collection<V> collectionA = a();
            if (collectionA == null) {
                collectionA = b.this.i();
                b.this.d.put(this.c, collectionA);
            }
            return collectionA.addAll(collection);
        }

        @Override // java.util.Collection
        public void clear() {
            Collection<V> collectionA = a();
            if (collectionA != null) {
                collectionA.clear();
                b.this.g(this.c);
            }
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            Collection<V> collectionA = a();
            return collectionA != null && collectionA.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Collection<V> collectionA = a();
            return collectionA != null && collectionA.containsAll(collection);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Collection<V> collectionA = a();
            return collectionA == null || collectionA.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return a() == null ? i.b.ha.a.a.b.a : new C0017b(this.c);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            Collection<V> collectionA = a();
            if (collectionA == null) {
                return false;
            }
            boolean zRemove = collectionA.remove(obj);
            if (collectionA.isEmpty()) {
                b.this.g(this.c);
            }
            return zRemove;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Collection<V> collectionA = a();
            if (collectionA == null) {
                return false;
            }
            boolean zRemoveAll = collectionA.removeAll(collection);
            if (collectionA.isEmpty()) {
                b.this.g(this.c);
            }
            return zRemoveAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Collection<V> collectionA = a();
            if (collectionA == null) {
                return false;
            }
            boolean zRetainAll = collectionA.retainAll(collection);
            if (collectionA.isEmpty()) {
                b.this.g(this.c);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            Collection<V> collectionA = a();
            if (collectionA == null) {
                return 0;
            }
            return collectionA.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Collection<V> collectionA = a();
            return collectionA == null ? i.b.ha.a.a.a.a.toArray() : collectionA.toArray();
        }

        public String toString() {
            Collection<V> collectionA = a();
            return collectionA == null ? i.b.ha.a.a.a.a.toString() : collectionA.toString();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            Collection<V> collectionA = a();
            if (collectionA == null) {
                return (T[]) i.b.ha.a.a.a.a.toArray(tArr);
            }
            return (T[]) collectionA.toArray(tArr);
        }
    }
}
