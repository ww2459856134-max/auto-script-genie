package h.e.j;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import h.e.j.e1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
class j1 extends o1 {
    private static boolean g;

    /* renamed from: h, reason: collision with root package name */
    private static Method f1301h;

    /* renamed from: i, reason: collision with root package name */
    private static Class<?> f1302i;

    /* renamed from: j, reason: collision with root package name */
    private static Class<?> f1303j;

    /* renamed from: k, reason: collision with root package name */
    private static Field f1304k;

    /* renamed from: l, reason: collision with root package name */
    private static Field f1305l;
    final WindowInsets c;
    private h.e.d.b d;
    private e1 e;
    h.e.d.b f;

    j1(e1 e1Var, WindowInsets windowInsets) {
        super(e1Var);
        this.d = null;
        this.c = windowInsets;
    }

    private h.e.d.b p(View view) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!g) {
            q();
        }
        Method method = f1301h;
        if (method != null && f1303j != null && f1304k != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f1304k.get(f1305l.get(objInvoke));
                if (rect != null) {
                    return h.e.d.b.c(rect);
                }
                return null;
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void q() throws ClassNotFoundException {
        try {
            f1301h = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            f1302i = Class.forName("android.view.ViewRootImpl");
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f1303j = cls;
            f1304k = cls.getDeclaredField("mVisibleInsets");
            f1305l = f1302i.getDeclaredField("mAttachInfo");
            f1304k.setAccessible(true);
            f1305l.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        g = true;
    }

    @Override // h.e.j.o1
    void d(View view) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        h.e.d.b bVarP = p(view);
        if (bVarP == null) {
            bVarP = h.e.d.b.e;
        }
        m(bVarP);
    }

    @Override // h.e.j.o1
    void e(e1 e1Var) {
        e1Var.o(this.e);
        e1Var.n(this.f);
    }

    @Override // h.e.j.o1
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f, ((j1) obj).f);
        }
        return false;
    }

    @Override // h.e.j.o1
    final h.e.d.b h() {
        if (this.d == null) {
            this.d = h.e.d.b.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
        }
        return this.d;
    }

    @Override // h.e.j.o1
    e1 i(int i2, int i3, int i4, int i5) {
        e1.a aVar = new e1.a(e1.r(this.c));
        aVar.c(e1.j(h(), i2, i3, i4, i5));
        aVar.b(e1.j(g(), i2, i3, i4, i5));
        return aVar.a();
    }

    @Override // h.e.j.o1
    boolean k() {
        return this.c.isRound();
    }

    @Override // h.e.j.o1
    public void l(h.e.d.b[] bVarArr) {
    }

    @Override // h.e.j.o1
    void m(h.e.d.b bVar) {
        this.f = bVar;
    }

    @Override // h.e.j.o1
    void n(e1 e1Var) {
        this.e = e1Var;
    }

    j1(e1 e1Var, j1 j1Var) {
        this(e1Var, new WindowInsets(j1Var.c));
    }
}
