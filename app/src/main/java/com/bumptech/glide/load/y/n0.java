package com.bumptech.glide.load.y;

/* loaded from: classes.dex */
public class n0<A, B> {
    private final com.bumptech.glide.b0.k<m0<A>, B> a;

    public n0(long j2) {
        this.a = new l0(this, j2);
    }

    public B a(A a, int i2, int i3) {
        m0<A> m0VarA = m0.a(a, i2, i3);
        B bG = this.a.g(m0VarA);
        m0VarA.c();
        return bG;
    }

    public void b(A a, int i2, int i3, B b) {
        this.a.k(m0.a(a, i2, i3), b);
    }
}
