package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class f0<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    private static final Comparator<Comparable> f748k = new d0();
    private final Comparator<? super K> c;
    private final boolean d;
    h0<K, V> e;
    int f;
    int g;

    /* renamed from: h, reason: collision with root package name */
    final h0<K, V> f749h;

    /* renamed from: i, reason: collision with root package name */
    private f0<K, V>.a f750i;

    /* renamed from: j, reason: collision with root package name */
    private f0<K, V>.b f751j;

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && f0.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e0(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            h0<K, V> h0VarC;
            if (!(obj instanceof Map.Entry) || (h0VarC = f0.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            f0.this.f(h0VarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f0.this.f;
        }
    }

    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f0.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new g0(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return f0.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f0.this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class c<T> implements Iterator<T> {
        h0<K, V> c;
        h0<K, V> d = null;
        int e;

        c() {
            this.c = f0.this.f749h.f;
            this.e = f0.this.g;
        }

        final h0<K, V> a() {
            h0<K, V> h0Var = this.c;
            f0 f0Var = f0.this;
            if (h0Var == f0Var.f749h) {
                throw new NoSuchElementException();
            }
            if (f0Var.g != this.e) {
                throw new ConcurrentModificationException();
            }
            this.c = h0Var.f;
            this.d = h0Var;
            return h0Var;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.c != f0.this.f749h;
        }

        @Override // java.util.Iterator
        public final void remove() {
            h0<K, V> h0Var = this.d;
            if (h0Var == null) {
                throw new IllegalStateException();
            }
            f0.this.f(h0Var, true);
            this.d = null;
            this.e = f0.this.g;
        }
    }

    public f0() {
        this(f748k, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void e(h0<K, V> h0Var, boolean z) {
        while (h0Var != null) {
            h0<K, V> h0Var2 = h0Var.d;
            h0<K, V> h0Var3 = h0Var.e;
            int i2 = h0Var2 != null ? h0Var2.f755k : 0;
            int i3 = h0Var3 != null ? h0Var3.f755k : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                h0<K, V> h0Var4 = h0Var3.d;
                h0<K, V> h0Var5 = h0Var3.e;
                int i5 = (h0Var4 != null ? h0Var4.f755k : 0) - (h0Var5 != null ? h0Var5.f755k : 0);
                if (i5 == -1 || (i5 == 0 && !z)) {
                    i(h0Var);
                } else {
                    k(h0Var3);
                    i(h0Var);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                h0<K, V> h0Var6 = h0Var2.d;
                h0<K, V> h0Var7 = h0Var2.e;
                int i6 = (h0Var6 != null ? h0Var6.f755k : 0) - (h0Var7 != null ? h0Var7.f755k : 0);
                if (i6 == 1 || (i6 == 0 && !z)) {
                    k(h0Var);
                } else {
                    i(h0Var2);
                    k(h0Var);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                h0Var.f755k = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                h0Var.f755k = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            h0Var = h0Var.c;
        }
    }

    private void h(h0<K, V> h0Var, h0<K, V> h0Var2) {
        h0<K, V> h0Var3 = h0Var.c;
        h0Var.c = null;
        if (h0Var2 != null) {
            h0Var2.c = h0Var3;
        }
        if (h0Var3 == null) {
            this.e = h0Var2;
        } else if (h0Var3.d == h0Var) {
            h0Var3.d = h0Var2;
        } else {
            h0Var3.e = h0Var2;
        }
    }

    private void i(h0<K, V> h0Var) {
        h0<K, V> h0Var2 = h0Var.d;
        h0<K, V> h0Var3 = h0Var.e;
        h0<K, V> h0Var4 = h0Var3.d;
        h0<K, V> h0Var5 = h0Var3.e;
        h0Var.e = h0Var4;
        if (h0Var4 != null) {
            h0Var4.c = h0Var;
        }
        h(h0Var, h0Var3);
        h0Var3.d = h0Var;
        h0Var.c = h0Var3;
        int iMax = Math.max(h0Var2 != null ? h0Var2.f755k : 0, h0Var4 != null ? h0Var4.f755k : 0) + 1;
        h0Var.f755k = iMax;
        h0Var3.f755k = Math.max(iMax, h0Var5 != null ? h0Var5.f755k : 0) + 1;
    }

    private void k(h0<K, V> h0Var) {
        h0<K, V> h0Var2 = h0Var.d;
        h0<K, V> h0Var3 = h0Var.e;
        h0<K, V> h0Var4 = h0Var2.d;
        h0<K, V> h0Var5 = h0Var2.e;
        h0Var.d = h0Var5;
        if (h0Var5 != null) {
            h0Var5.c = h0Var;
        }
        h(h0Var, h0Var2);
        h0Var2.e = h0Var;
        h0Var.c = h0Var2;
        int iMax = Math.max(h0Var3 != null ? h0Var3.f755k : 0, h0Var5 != null ? h0Var5.f755k : 0) + 1;
        h0Var.f755k = iMax;
        h0Var2.f755k = Math.max(iMax, h0Var4 != null ? h0Var4.f755k : 0) + 1;
    }

    h0<K, V> b(K k2, boolean z) {
        int iCompareTo;
        h0<K, V> h0Var;
        Comparator<? super K> comparator = this.c;
        h0<K, V> h0Var2 = this.e;
        if (h0Var2 != null) {
            Comparable comparable = comparator == f748k ? (Comparable) k2 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(h0Var2.f752h) : comparator.compare(k2, h0Var2.f752h);
                if (iCompareTo == 0) {
                    return h0Var2;
                }
                h0<K, V> h0Var3 = iCompareTo < 0 ? h0Var2.d : h0Var2.e;
                if (h0Var3 == null) {
                    break;
                }
                h0Var2 = h0Var3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        h0<K, V> h0Var4 = this.f749h;
        if (h0Var2 != null) {
            h0Var = new h0<>(this.d, h0Var2, k2, h0Var4, h0Var4.g);
            if (iCompareTo < 0) {
                h0Var2.d = h0Var;
            } else {
                h0Var2.e = h0Var;
            }
            e(h0Var2, true);
        } else {
            if (comparator == f748k && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            h0Var = new h0<>(this.d, h0Var2, k2, h0Var4, h0Var4.g);
            this.e = h0Var;
        }
        this.f++;
        this.g++;
        return h0Var;
    }

    h0<K, V> c(Map.Entry<?, ?> entry) {
        h0<K, V> h0VarD = d(entry.getKey());
        if (h0VarD != null && a(h0VarD.f754j, entry.getValue())) {
            return h0VarD;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.e = null;
        this.f = 0;
        this.g++;
        h0<K, V> h0Var = this.f749h;
        h0Var.g = h0Var;
        h0Var.f = h0Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    h0<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        f0<K, V>.a aVar = this.f750i;
        if (aVar != null) {
            return aVar;
        }
        f0<K, V>.a aVar2 = new a();
        this.f750i = aVar2;
        return aVar2;
    }

    void f(h0<K, V> h0Var, boolean z) {
        int i2;
        if (z) {
            h0<K, V> h0Var2 = h0Var.g;
            h0Var2.f = h0Var.f;
            h0Var.f.g = h0Var2;
        }
        h0<K, V> h0Var3 = h0Var.d;
        h0<K, V> h0Var4 = h0Var.e;
        h0<K, V> h0Var5 = h0Var.c;
        int i3 = 0;
        if (h0Var3 == null || h0Var4 == null) {
            if (h0Var3 != null) {
                h(h0Var, h0Var3);
                h0Var.d = null;
            } else if (h0Var4 != null) {
                h(h0Var, h0Var4);
                h0Var.e = null;
            } else {
                h(h0Var, null);
            }
            e(h0Var5, false);
            this.f--;
            this.g++;
            return;
        }
        h0<K, V> h0VarB = h0Var3.f755k > h0Var4.f755k ? h0Var3.b() : h0Var4.a();
        f(h0VarB, false);
        h0<K, V> h0Var6 = h0Var.d;
        if (h0Var6 != null) {
            i2 = h0Var6.f755k;
            h0VarB.d = h0Var6;
            h0Var6.c = h0VarB;
            h0Var.d = null;
        } else {
            i2 = 0;
        }
        h0<K, V> h0Var7 = h0Var.e;
        if (h0Var7 != null) {
            i3 = h0Var7.f755k;
            h0VarB.e = h0Var7;
            h0Var7.c = h0VarB;
            h0Var.e = null;
        }
        h0VarB.f755k = Math.max(i2, i3) + 1;
        h(h0Var, h0VarB);
    }

    h0<K, V> g(Object obj) {
        h0<K, V> h0VarD = d(obj);
        if (h0VarD != null) {
            f(h0VarD, true);
        }
        return h0VarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        h0<K, V> h0VarD = d(obj);
        if (h0VarD != null) {
            return h0VarD.f754j;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        f0<K, V>.b bVar = this.f751j;
        if (bVar != null) {
            return bVar;
        }
        f0<K, V>.b bVar2 = new b();
        this.f751j = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        Objects.requireNonNull(k2, "key == null");
        if (v == null && !this.d) {
            throw new NullPointerException("value == null");
        }
        h0<K, V> h0VarB = b(k2, true);
        V v2 = h0VarB.f754j;
        h0VarB.f754j = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h0<K, V> h0VarG = g(obj);
        if (h0VarG != null) {
            return h0VarG.f754j;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f;
    }

    public f0(boolean z) {
        this(f748k, z);
    }

    public f0(Comparator<? super K> comparator, boolean z) {
        this.f = 0;
        this.g = 0;
        this.c = comparator == null ? f748k : comparator;
        this.d = z;
        this.f749h = new h0<>(z);
    }
}
