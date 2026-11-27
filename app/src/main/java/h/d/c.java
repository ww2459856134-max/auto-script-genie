package h.d;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes.dex */
class c<E> extends h<E, E> {
    final /* synthetic */ d d;

    c(d dVar) {
        this.d = dVar;
    }

    @Override // h.d.h
    protected void a() {
        this.d.clear();
    }

    @Override // h.d.h
    protected Object b(int i2, int i3) {
        return this.d.d[i2];
    }

    @Override // h.d.h
    protected Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // h.d.h
    protected int d() {
        return this.d.e;
    }

    @Override // h.d.h
    protected int e(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // h.d.h
    protected int f(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // h.d.h
    protected void g(E e, E e2) {
        this.d.add(e);
    }

    @Override // h.d.h
    protected void h(int i2) {
        this.d.k(i2);
    }

    @Override // h.d.h
    protected E i(int i2, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
