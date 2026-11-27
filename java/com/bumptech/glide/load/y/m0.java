package com.bumptech.glide.load.y;

import java.util.Queue;

/* loaded from: classes.dex */
final class m0<A> {
    private static final Queue<m0<?>> d = com.bumptech.glide.b0.p.e(0);
    private int a;
    private int b;
    private A c;

    private m0() {
    }

    static <A> m0<A> a(A a, int i2, int i3) {
        m0<A> m0Var;
        Queue<m0<?>> queue = d;
        synchronized (queue) {
            m0Var = (m0) queue.poll();
        }
        if (m0Var == null) {
            m0Var = new m0<>();
        }
        m0Var.b(a, i2, i3);
        return m0Var;
    }

    private void b(A a, int i2, int i3) {
        this.c = a;
        this.b = i2;
        this.a = i3;
    }

    public void c() {
        Queue<m0<?>> queue = d;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.b == m0Var.b && this.a == m0Var.a && this.c.equals(m0Var.c);
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
    }
}
