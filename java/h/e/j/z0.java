package h.e.j;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class z0 {
    private WeakReference<View> a;
    Runnable b = null;
    Runnable c = null;
    int d = -1;

    z0(View view) {
        this.a = new WeakReference<>(view);
    }

    private void g(View view, a1 a1Var) {
        if (a1Var != null) {
            view.animate().setListener(new w0(this, a1Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public z0 a(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public z0 d(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public z0 e(Interpolator interpolator) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z0 f(a1 a1Var) {
        View view = this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                g(view, a1Var);
            } else {
                view.setTag(2113929216, a1Var);
                g(view, new y0(this));
            }
        }
        return this;
    }

    public z0 h(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public z0 i(c1 c1Var) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(c1Var != null ? new x0(this, c1Var, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z0 k(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
