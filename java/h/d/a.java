package h.d;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
class a<K, V> extends h<K, V> {
    final /* synthetic */ b d;

    a(b bVar) {
        this.d = bVar;
    }

    @Override // h.d.h
    protected void a() {
        this.d.clear();
    }

    @Override // h.d.h
    protected Object b(int i2, int i3) {
        return this.d.d[(i2 << 1) + i3];
    }

    @Override // h.d.h
    protected Map<K, V> c() {
        return this.d;
    }

    @Override // h.d.h
    protected int d() {
        return this.d.e;
    }

    @Override // h.d.h
    protected int e(Object obj) {
        return this.d.f(obj);
    }

    @Override // h.d.h
    protected int f(Object obj) {
        return this.d.h(obj);
    }

    @Override // h.d.h
    protected void g(K k2, V v) {
        this.d.put(k2, v);
    }

    @Override // h.d.h
    protected void h(int i2) {
        this.d.k(i2);
    }

    @Override // h.d.h
    protected V i(int i2, V v) {
        return this.d.l(i2, v);
    }
}
