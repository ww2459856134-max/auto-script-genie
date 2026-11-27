package h.a.l.a;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class k implements Drawable.Callback {
    private Drawable.Callback c;

    k() {
    }

    public Drawable.Callback a() {
        Drawable.Callback callback = this.c;
        this.c = null;
        return callback;
    }

    public k b(Drawable.Callback callback) {
        this.c = callback;
        return this;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = this.c;
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = this.c;
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }
}
