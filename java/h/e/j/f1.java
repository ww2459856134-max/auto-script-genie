package h.e.j;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class f1 extends i1 {
    private static Field e;
    private static boolean f;
    private static Constructor<WindowInsets> g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f1300h;
    private WindowInsets c;
    private h.e.d.b d;

    f1() {
        this.c = h();
    }

    private static WindowInsets h() {
        if (!f) {
            try {
                e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
            }
            f = true;
        }
        Field field = e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
            }
        }
        if (!f1300h) {
            try {
                g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
            }
            f1300h = true;
        }
        Constructor<WindowInsets> constructor = g;
        if (constructor != null) {
            try {
                return constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
            }
        }
        return null;
    }

    @Override // h.e.j.i1
    e1 b() {
        a();
        e1 e1VarR = e1.r(this.c);
        e1VarR.m(this.b);
        e1VarR.p(this.d);
        return e1VarR;
    }

    @Override // h.e.j.i1
    void d(h.e.d.b bVar) {
        this.d = bVar;
    }

    @Override // h.e.j.i1
    void f(h.e.d.b bVar) {
        WindowInsets windowInsets = this.c;
        if (windowInsets != null) {
            this.c = windowInsets.replaceSystemWindowInsets(bVar.a, bVar.b, bVar.c, bVar.d);
        }
    }

    f1(e1 e1Var) {
        this.c = e1Var.q();
    }
}
