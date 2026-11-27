package h.e.j;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final View c;
    private ViewTreeObserver d;
    private final Runnable e;

    private d0(View view, Runnable runnable) {
        this.c = view;
        this.d = view.getViewTreeObserver();
        this.e = runnable;
    }

    public static d0 a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        d0 d0Var = new d0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(d0Var);
        view.addOnAttachStateChangeListener(d0Var);
        return d0Var;
    }

    public void b() {
        if (this.d.isAlive()) {
            this.d.removeOnPreDrawListener(this);
        } else {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.c.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.e.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.d = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
