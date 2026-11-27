package h.e.j;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
abstract class l0<T> {
    private final int a;
    private final Class<T> b;
    private final int c;
    private final int d;

    l0(int i2, Class<T> cls, int i3) {
        this(i2, cls, 0, i3);
    }

    private boolean b() {
        return Build.VERSION.SDK_INT >= 19;
    }

    private boolean c() {
        return Build.VERSION.SDK_INT >= this.c;
    }

    boolean a(Boolean bool, Boolean bool2) {
        return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
    }

    abstract T d(View view);

    abstract void e(View view, T t);

    T f(View view) {
        if (c()) {
            return d(view);
        }
        if (!b()) {
            return null;
        }
        T t = (T) view.getTag(this.a);
        if (this.b.isInstance(t)) {
            return t;
        }
        return null;
    }

    void g(View view, T t) {
        if (c()) {
            e(view, t);
        } else if (b() && h(f(view), t)) {
            s0.A(view);
            view.setTag(this.a, t);
            s0.N(view, this.d);
        }
    }

    abstract boolean h(T t, T t2);

    l0(int i2, Class<T> cls, int i3, int i4) {
        this.a = i2;
        this.b = cls;
        this.d = i3;
        this.c = i4;
    }
}
