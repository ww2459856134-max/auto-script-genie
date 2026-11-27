package com.bumptech.glide.z.l;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public abstract class e<Z> extends k<ImageView, Z> implements com.bumptech.glide.z.m.c {

    /* renamed from: i, reason: collision with root package name */
    private Animatable f718i;

    public e(ImageView imageView) {
        super(imageView);
    }

    private void p(Z z) {
        if (!(z instanceof Animatable)) {
            this.f718i = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.f718i = animatable;
        animatable.start();
    }

    private void s(Z z) {
        r(z);
        p(z);
    }

    @Override // com.bumptech.glide.w.k
    public void a() {
        Animatable animatable = this.f718i;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.w.k
    public void b() {
        Animatable animatable = this.f718i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.bumptech.glide.z.l.k, com.bumptech.glide.z.l.a, com.bumptech.glide.z.l.h
    public void f(Drawable drawable) {
        super.f(drawable);
        Animatable animatable = this.f718i;
        if (animatable != null) {
            animatable.stop();
        }
        s(null);
        q(drawable);
    }

    @Override // com.bumptech.glide.z.l.h
    public void g(Z z, com.bumptech.glide.z.m.d<? super Z> dVar) {
        if (dVar == null || !dVar.a(z, this)) {
            s(z);
        } else {
            p(z);
        }
    }

    @Override // com.bumptech.glide.z.l.k, com.bumptech.glide.z.l.a, com.bumptech.glide.z.l.h
    public void h(Drawable drawable) {
        super.h(drawable);
        s(null);
        q(drawable);
    }

    @Override // com.bumptech.glide.z.l.a, com.bumptech.glide.z.l.h
    public void j(Drawable drawable) {
        super.j(drawable);
        s(null);
        q(drawable);
    }

    public void q(Drawable drawable) {
        ((ImageView) this.c).setImageDrawable(drawable);
    }

    protected abstract void r(Z z);
}
