package com.google.gson.internal;

import java.util.Map;

/* loaded from: classes.dex */
final class h0<K, V> implements Map.Entry<K, V> {
    h0<K, V> c;
    h0<K, V> d;
    h0<K, V> e;
    h0<K, V> f;
    h0<K, V> g;

    /* renamed from: h, reason: collision with root package name */
    final K f752h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f753i;

    /* renamed from: j, reason: collision with root package name */
    V f754j;

    /* renamed from: k, reason: collision with root package name */
    int f755k;

    h0(boolean z) {
        this.f752h = null;
        this.f753i = z;
        this.g = this;
        this.f = this;
    }

    public h0<K, V> a() {
        h0<K, V> h0Var = this;
        for (h0<K, V> h0Var2 = this.d; h0Var2 != null; h0Var2 = h0Var2.d) {
            h0Var = h0Var2;
        }
        return h0Var;
    }

    public h0<K, V> b() {
        h0<K, V> h0Var = this;
        for (h0<K, V> h0Var2 = this.e; h0Var2 != null; h0Var2 = h0Var2.e) {
            h0Var = h0Var2;
        }
        return h0Var;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        K k2 = this.f752h;
        if (k2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!k2.equals(entry.getKey())) {
            return false;
        }
        V v = this.f754j;
        if (v == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!v.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.f752h;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.f754j;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K k2 = this.f752h;
        int iHashCode = k2 == null ? 0 : k2.hashCode();
        V v = this.f754j;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        if (v == null && !this.f753i) {
            throw new NullPointerException("value == null");
        }
        V v2 = this.f754j;
        this.f754j = v;
        return v2;
    }

    public String toString() {
        return this.f752h + "=" + this.f754j;
    }

    h0(boolean z, h0<K, V> h0Var, K k2, h0<K, V> h0Var2, h0<K, V> h0Var3) {
        this.c = h0Var;
        this.f752h = k2;
        this.f753i = z;
        this.f755k = 1;
        this.f = h0Var2;
        this.g = h0Var3;
        h0Var3.f = this;
        h0Var2.g = this;
    }
}
