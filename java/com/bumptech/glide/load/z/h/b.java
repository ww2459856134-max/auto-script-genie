package com.bumptech.glide.load.z.h;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.b0.n;
import com.bumptech.glide.load.x.u0;
import com.bumptech.glide.load.x.z0;
import com.bumptech.glide.load.z.j.f;

/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements z0<T>, u0 {
    protected final T c;

    public b(T t) {
        n.d(t);
        this.c = t;
    }

    @Override // com.bumptech.glide.load.x.u0
    public void c() {
        T t = this.c;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof f) {
            ((f) t).e().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.x.z0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.c.getConstantState();
        return constantState == null ? this.c : (T) constantState.newDrawable();
    }
}
