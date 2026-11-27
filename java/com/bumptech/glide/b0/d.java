package com.bumptech.glide.b0;

/* loaded from: classes.dex */
public final class d<K, V> extends h.d.b<K, V> {

    /* renamed from: k, reason: collision with root package name */
    private int f576k;

    @Override // h.d.i, java.util.Map
    public void clear() {
        this.f576k = 0;
        super.clear();
    }

    @Override // h.d.i, java.util.Map
    public int hashCode() {
        if (this.f576k == 0) {
            this.f576k = super.hashCode();
        }
        return this.f576k;
    }

    @Override // h.d.i
    public void j(h.d.i<? extends K, ? extends V> iVar) {
        this.f576k = 0;
        super.j(iVar);
    }

    @Override // h.d.i
    public V k(int i2) {
        this.f576k = 0;
        return (V) super.k(i2);
    }

    @Override // h.d.i
    public V l(int i2, V v) {
        this.f576k = 0;
        return (V) super.l(i2, v);
    }

    @Override // h.d.i, java.util.Map
    public V put(K k2, V v) {
        this.f576k = 0;
        return (V) super.put(k2, v);
    }
}
