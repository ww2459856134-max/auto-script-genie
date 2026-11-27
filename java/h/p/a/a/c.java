package h.p.a.a;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class c implements Drawable.Callback {
    final /* synthetic */ f c;

    c(f fVar) {
        this.c = fVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        this.c.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        this.c.scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.c.unscheduleSelf(runnable);
    }
}
