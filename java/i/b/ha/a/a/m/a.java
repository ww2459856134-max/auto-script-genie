package i.b.ha.a.a.m;

import i.b.ha.a.a.d;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a<K, V> extends i.b.ha.a.a.m.b<K, V> implements d<K, V> {

    private final class b extends i.b.ha.a.a.m.b<K, V>.c implements List<V> {
        b(K k2) {
            super(k2);
        }

        @Override // java.util.List
        public void add(int i2, V v) {
            List<V> listA = a();
            if (listA == null) {
                listA = a.this.i();
                a.this.e().put(this.c, listA);
            }
            listA.add(i2, v);
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends V> collection) {
            List<V> listA = a();
            if (listA != null) {
                return listA.addAll(i2, collection);
            }
            List<V> listI = a.this.i();
            boolean zAddAll = listI.addAll(i2, collection);
            if (zAddAll) {
                a.this.e().put(this.c, listI);
            }
            return zAddAll;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // i.b.ha.a.a.m.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<V> a() {
            return a.this.e().get(this.c);
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            List<V> listA = a();
            if (listA == null) {
                return Collections.emptyList().equals(obj);
            }
            if (obj instanceof List) {
                return i.b.ha.a.a.c.c(listA, (List) obj);
            }
            return false;
        }

        @Override // java.util.List
        public V get(int i2) {
            return (V) i.b.ha.a.a.c.a(a()).get(i2);
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            return i.b.ha.a.a.c.b(a());
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return i.b.ha.a.a.c.a(a()).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return i.b.ha.a.a.c.a(a()).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            return new C0014a(this.c);
        }

        @Override // java.util.List
        public V remove(int i2) {
            List listA = i.b.ha.a.a.c.a(a());
            V v = (V) listA.remove(i2);
            if (listA.isEmpty()) {
                a.this.g(this.c);
            }
            return v;
        }

        @Override // java.util.List
        public V set(int i2, V v) {
            return (V) i.b.ha.a.a.c.a(a()).set(i2, v);
        }

        @Override // java.util.List
        public List<V> subList(int i2, int i3) {
            return i.b.ha.a.a.c.a(a()).subList(i2, i3);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i2) {
            return new C0014a(this.c, i2);
        }
    }

    protected a() {
    }

    @Override // i.b.ha.a.a.m.b
    protected Map<K, List<V>> e() {
        return super.e();
    }

    @Override // i.b.ha.a.a.d
    public List<V> get(K k2) {
        return h(k2);
    }

    protected abstract List<V> i();

    @Override // i.b.ha.a.a.m.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public List<V> g(Object obj) {
        return i.b.ha.a.a.c.a(e().remove(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // i.b.ha.a.a.m.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public List<V> h(K k2) {
        return new b(k2);
    }

    protected a(Map<K, ? extends List<V>> map) {
        super(map);
    }

    /* renamed from: i.b.ha.a.a.m.a$a, reason: collision with other inner class name */
    private final class C0014a implements ListIterator<V> {
        private final K c;
        private List<V> d;
        private ListIterator<V> e;

        C0014a(K k2) {
            this.c = k2;
            List<V> listA = i.b.ha.a.a.c.a(a.this.e().get(k2));
            this.d = listA;
            this.e = listA.listIterator();
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            if (a.this.e().get(this.c) == null) {
                List<V> listI = a.this.i();
                a.this.e().put(this.c, listI);
                this.d = listI;
                this.e = listI.listIterator();
            }
            this.e.add(v);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.e.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.e.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            return this.e.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.e.nextIndex();
        }

        @Override // java.util.ListIterator
        public V previous() {
            return this.e.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.e.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.e.remove();
            if (this.d.isEmpty()) {
                a.this.e().remove(this.c);
            }
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            this.e.set(v);
        }

        C0014a(K k2, int i2) {
            this.c = k2;
            List<V> listA = i.b.ha.a.a.c.a(a.this.e().get(k2));
            this.d = listA;
            this.e = listA.listIterator(i2);
        }
    }
}
