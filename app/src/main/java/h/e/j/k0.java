package h.e.j;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class k0 implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
    private WeakHashMap<View, Boolean> c = new WeakHashMap<>();

    k0() {
    }

    private void a(View view, boolean z) {
        boolean z2 = view.getVisibility() == 0;
        if (z != z2) {
            s0.N(view, z2 ? 16 : 32);
            this.c.put(view, Boolean.valueOf(z2));
        }
    }

    private void b(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 28) {
            for (Map.Entry<View, Boolean> entry : this.c.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        b(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
