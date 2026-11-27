package com.bumptech.glide.b0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k<T, Y> {
    private final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);
    private long b;
    private long c;

    public k(long j2) {
        this.b = j2;
    }

    private void f() {
        m(this.b);
    }

    public void b() {
        m(0L);
    }

    public synchronized Y g(T t) {
        return this.a.get(t);
    }

    public synchronized long h() {
        return this.b;
    }

    protected int i(Y y) {
        return 1;
    }

    protected void j(T t, Y y) {
    }

    public synchronized Y k(T t, Y y) {
        long jI = i(y);
        if (jI >= this.b) {
            j(t, y);
            return null;
        }
        if (y != null) {
            this.c += jI;
        }
        Y yPut = this.a.put(t, y);
        if (yPut != null) {
            this.c -= i(yPut);
            if (!yPut.equals(y)) {
                j(t, yPut);
            }
        }
        f();
        return yPut;
    }

    public synchronized Y l(T t) {
        Y yRemove;
        yRemove = this.a.remove(t);
        if (yRemove != null) {
            this.c -= i(yRemove);
        }
        return yRemove;
    }

    protected synchronized void m(long j2) {
        while (this.c > j2) {
            Iterator<Map.Entry<T, Y>> it = this.a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.c -= i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
