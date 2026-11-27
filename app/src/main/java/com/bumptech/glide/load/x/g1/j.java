package com.bumptech.glide.load.x.g1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class j<K, V> {
    final K a;
    private List<V> b;
    j<K, V> c;
    j<K, V> d;

    j() {
        this(null);
    }

    public void a(V v) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(v);
    }

    public V b() {
        int iC = c();
        if (iC > 0) {
            return this.b.remove(iC - 1);
        }
        return null;
    }

    public int c() {
        List<V> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    j(K k2) {
        this.d = this;
        this.c = this;
        this.a = k2;
    }
}
