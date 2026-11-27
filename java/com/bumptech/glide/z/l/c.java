package com.bumptech.glide.z.l;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.b0.p;

/* loaded from: classes.dex */
public abstract class c<T> implements h<T> {
    private final int c;
    private final int d;
    private com.bumptech.glide.z.c e;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.w.k
    public void a() {
    }

    @Override // com.bumptech.glide.w.k
    public void b() {
    }

    @Override // com.bumptech.glide.z.l.h
    public final void c(g gVar) {
    }

    @Override // com.bumptech.glide.w.k
    public void d() {
    }

    @Override // com.bumptech.glide.z.l.h
    public final com.bumptech.glide.z.c e() {
        return this.e;
    }

    @Override // com.bumptech.glide.z.l.h
    public void h(Drawable drawable) {
    }

    @Override // com.bumptech.glide.z.l.h
    public final void i(com.bumptech.glide.z.c cVar) {
        this.e = cVar;
    }

    @Override // com.bumptech.glide.z.l.h
    public void j(Drawable drawable) {
    }

    @Override // com.bumptech.glide.z.l.h
    public final void k(g gVar) {
        gVar.e(this.c, this.d);
    }

    public c(int i2, int i3) {
        if (p.r(i2, i3)) {
            this.c = i2;
            this.d = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }
}
