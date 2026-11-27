package com.bumptech.glide.z.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.b0.n;

@Deprecated
/* loaded from: classes.dex */
public abstract class k<T extends View, Z> extends a<Z> {

    /* renamed from: h, reason: collision with root package name */
    private static int f719h = com.bumptech.glide.i.a;
    protected final T c;
    private final j d;
    private View.OnAttachStateChangeListener e;
    private boolean f;
    private boolean g;

    public k(T t) {
        n.d(t);
        this.c = t;
        this.d = new j(t);
    }

    private Object l() {
        return this.c.getTag(f719h);
    }

    private void m() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
        if (onAttachStateChangeListener == null || this.g) {
            return;
        }
        this.c.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = true;
    }

    private void n() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
        if (onAttachStateChangeListener == null || !this.g) {
            return;
        }
        this.c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = false;
    }

    private void o(Object obj) {
        this.c.setTag(f719h, obj);
    }

    @Override // com.bumptech.glide.z.l.h
    public void c(g gVar) {
        this.d.k(gVar);
    }

    @Override // com.bumptech.glide.z.l.h
    public com.bumptech.glide.z.c e() {
        Object objL = l();
        if (objL == null) {
            return null;
        }
        if (objL instanceof com.bumptech.glide.z.c) {
            return (com.bumptech.glide.z.c) objL;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.z.l.a, com.bumptech.glide.z.l.h
    public void f(Drawable drawable) {
        super.f(drawable);
        this.d.b();
        if (this.f) {
            return;
        }
        n();
    }

    @Override // com.bumptech.glide.z.l.a, com.bumptech.glide.z.l.h
    public void h(Drawable drawable) {
        super.h(drawable);
        m();
    }

    @Override // com.bumptech.glide.z.l.h
    public void i(com.bumptech.glide.z.c cVar) {
        o(cVar);
    }

    @Override // com.bumptech.glide.z.l.h
    public void k(g gVar) {
        this.d.d(gVar);
    }

    public String toString() {
        return "Target for: " + this.c;
    }
}
