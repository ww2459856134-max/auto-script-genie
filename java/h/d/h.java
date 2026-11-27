package h.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
abstract class h<K, V> {
    h<K, V>.b a;
    h<K, V>.c b;
    h<K, V>.e c;

    final class a<T> implements Iterator<T> {
        final int c;
        int d;
        int e;
        boolean f = false;

        a(int i2) {
            this.c = i2;
            this.d = h.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.e < this.d;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) h.this.b(this.e, this.c);
            this.e++;
            this.f = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f) {
                throw new IllegalStateException();
            }
            int i2 = this.e - 1;
            this.e = i2;
            this.d--;
            this.f = false;
            h.this.h(i2);
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iD = h.this.d();
            for (Map.Entry<K, V> entry : collection) {
                h.this.g(entry.getKey(), entry.getValue());
            }
            return iD != h.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iE = h.this.e(entry.getKey());
            if (iE < 0) {
                return false;
            }
            return h.d.e.c(h.this.b(iE, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = h.this.d() - 1; iD >= 0; iD--) {
                Object objB = h.this.b(iD, 0);
                Object objB2 = h.this.b(iD, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return h.j(h.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = h.this.d() - 1; iD >= 0; iD--) {
                Object objB = h.this.b(iD, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = h.this.e(obj);
            if (iE < 0) {
                return false;
            }
            h.this.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return h.o(h.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return h.p(h.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return h.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int c;
        boolean e = false;
        int d = -1;

        d() {
            this.c = h.this.d() - 1;
        }

        public Map.Entry<K, V> a() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.d++;
            this.e = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.e) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return h.d.e.c(entry.getKey(), h.this.b(this.d, 0)) && h.d.e.c(entry.getValue(), h.this.b(this.d, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.e) {
                return (K) h.this.b(this.d, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.e) {
                return (V) h.this.b(this.d, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d < this.c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.e) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = h.this.b(this.d, 0);
            Object objB2 = h.this.b(this.d, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.e) {
                throw new IllegalStateException();
            }
            h.this.h(this.d);
            this.d--;
            this.c--;
            this.e = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.e) {
                return (V) h.this.i(this.d, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return h.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iF = h.this.f(obj);
            if (iF < 0) {
                return false;
            }
            h.this.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iD = h.this.d();
            int i2 = 0;
            boolean z = false;
            while (i2 < iD) {
                if (collection.contains(h.this.b(i2, 1))) {
                    h.this.h(i2);
                    i2--;
                    iD--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iD = h.this.d();
            int i2 = 0;
            boolean z = false;
            while (i2 < iD) {
                if (!collection.contains(h.this.b(i2, 1))) {
                    h.this.h(i2);
                    i2--;
                    iD--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return h.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return h.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.r(tArr, 1);
        }
    }

    h() {
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i2, int i3);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k2, V v);

    protected abstract void h(int i2);

    protected abstract V i(int i2, V v);

    public Set<Map.Entry<K, V>> l() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    public Set<K> m() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }

    public Object[] q(int i2) {
        int iD = d();
        Object[] objArr = new Object[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            objArr[i3] = b(i3, i2);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i2) {
        int iD = d();
        if (tArr.length < iD) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iD));
        }
        for (int i3 = 0; i3 < iD; i3++) {
            tArr[i3] = b(i3, i2);
        }
        if (tArr.length > iD) {
            tArr[iD] = null;
        }
        return tArr;
    }
}
