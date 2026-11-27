package com.frame;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class s0 {
    private static s0 d;
    private static final Object e = new Object();
    private static final Object f = new Object();
    private WindowManager.LayoutParams b;
    private ConcurrentHashMap<String, View> c = new ConcurrentHashMap<>();
    private WindowManager a = (WindowManager) t0.a().getSystemService("window");

    s0() {
    }

    public static s0 g() {
        s0 s0Var = d;
        if (s0Var != null) {
            return s0Var;
        }
        s0 s0Var2 = new s0();
        d = s0Var2;
        return s0Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        ArrayList arrayList = new ArrayList(this.c.values());
        int size = arrayList.size();
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return;
            }
            View view = (View) arrayList.get(i2);
            view.setVisibility(0);
            u(view.getClass());
            size = i2;
        }
    }

    public <T> T A(View view, int i2, int i3, int i4, int i5) {
        WindowManager.LayoutParams layoutParamsB = t0.b(true);
        this.b = layoutParamsB;
        layoutParamsB.x = Math.abs(i2);
        this.b.y = Math.abs(i3);
        WindowManager.LayoutParams layoutParams = this.b;
        layoutParams.width = i4;
        layoutParams.height = i5;
        if (Build.VERSION.SDK_INT >= 19) {
            layoutParams.flags = 201328160;
        } else {
            layoutParams.flags = 544;
        }
        return (T) w(view, layoutParams);
    }

    public <T> T B(Class<T> cls) {
        return (T) C(cls, 0, 0, -1, -1);
    }

    public <T> T C(Class<T> cls, int i2, int i3, int i4, int i5) {
        WindowManager.LayoutParams layoutParamsB = t0.b(true);
        this.b = layoutParamsB;
        layoutParamsB.x = Math.abs(i2);
        this.b.y = Math.abs(i3);
        WindowManager.LayoutParams layoutParams = this.b;
        layoutParams.width = i4;
        layoutParams.height = i5;
        if (Build.VERSION.SDK_INT >= 19) {
            layoutParams.flags = 201328160;
        } else {
            layoutParams.flags = 544;
        }
        return (T) z(cls, layoutParams);
    }

    public <T> T D(View view) {
        WindowManager.LayoutParams layoutParamsB = t0.b(false);
        this.b = layoutParamsB;
        layoutParamsB.x = 0;
        layoutParamsB.y = 0;
        layoutParamsB.width = -1;
        layoutParamsB.height = -1;
        return (T) w(view, layoutParamsB);
    }

    public <T> T E(Class<T> cls) {
        WindowManager.LayoutParams layoutParamsB = t0.b(false);
        this.b = layoutParamsB;
        layoutParamsB.x = 0;
        layoutParamsB.y = 0;
        layoutParamsB.width = -1;
        layoutParamsB.height = -1;
        return (T) z(cls, layoutParamsB);
    }

    public <T> T F(Class<T> cls, int i2, int i3, int i4, int i5) {
        WindowManager.LayoutParams layoutParamsB = t0.b(false);
        this.b = layoutParamsB;
        layoutParamsB.x = i2;
        layoutParamsB.y = i3;
        layoutParamsB.width = i4;
        layoutParamsB.height = i5;
        return (T) z(cls, layoutParamsB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T G(View view, int i2, int i3) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
        layoutParams.x = i2;
        layoutParams.y = i3;
        I(view, layoutParams);
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T H(View view, int i2, int i3, int i4, int i5) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
        layoutParams.x = i2;
        layoutParams.y = i3;
        layoutParams.width = i4;
        layoutParams.height = i5;
        I(view, layoutParams);
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T I(View view, WindowManager.LayoutParams layoutParams) {
        try {
            if (view.getTag() instanceof WindowManager) {
                ((WindowManager) view.getTag()).updateViewLayout(view, layoutParams);
            } else {
                this.a.updateViewLayout(view, layoutParams);
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
        return view;
    }

    public void a(Class cls) {
        final View view = this.c.get(cls.getName());
        if (view != null) {
            l1.e(new Runnable() { // from class: com.frame.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.o(view);
                }
            });
        }
    }

    public boolean b(Class cls) {
        return this.c.get(cls.getName()) != null;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void o(View view) {
        synchronized (e) {
            try {
                r(view);
                this.c.remove(view.getClass().getName());
                view.setTag(null);
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
    }

    public void d(Class cls) {
        View view = this.c.get(cls.getName());
        if (view != null) {
            n(view);
        }
    }

    public void e() {
        Iterator<View> it = this.c.values().iterator();
        while (it.hasNext()) {
            try {
                n(it.next());
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
    }

    public <T> T f(Class<T> cls) {
        T t = (T) ((View) this.c.get(cls.getName()));
        if (t != null) {
            return t;
        }
        return null;
    }

    public <T> T h(Class<T> cls) {
        T t;
        synchronized (f) {
            T t2 = (T) ((View) this.c.get(cls.getName()));
            if (t2 != null) {
                return t2;
            }
            try {
                t = (T) ((View) cls.newInstance());
            } catch (Exception e2) {
                e = e2;
            }
            try {
                this.c.put(cls.getName(), t);
            } catch (Exception e3) {
                e = e3;
                t2 = t;
                k0.r(e);
                t = t2;
                return t;
            }
            return t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, android.view.View] */
    public <T> T i(Class<T> cls) {
        ?? r2 = (T) ((View) this.c.get(cls.getName()));
        if (r2 == 0) {
            return null;
        }
        j(r2);
        return r2;
    }

    public void j(View view) {
        view.setVisibility(8);
    }

    public void k() {
        Iterator<View> it = this.c.values().iterator();
        while (it.hasNext()) {
            r(it.next());
        }
    }

    public boolean l(Class... clsArr) {
        for (Class cls : clsArr) {
            View view = this.c.get(cls.getName());
            if (view != null && view.getParent() != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m(Class cls) {
        View view = this.c.get(cls.getName());
        return (view == null || view.getParent() == null || view.getLayoutParams() == null) ? false : true;
    }

    public void r(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            WindowManager windowManager = (WindowManager) view.getTag();
            if (windowManager != null) {
                windowManager.removeView(view);
            } else {
                this.a.removeView(view);
            }
        } catch (Exception unused) {
        }
    }

    public void s(Class cls) {
        View view = this.c.get(cls.getName());
        if (view != null) {
            r(view);
            t(view);
        }
    }

    public View t(View view) {
        if (view == null || view.getLayoutParams() == null) {
            return null;
        }
        return (View) w(view, (WindowManager.LayoutParams) view.getLayoutParams());
    }

    public <T> T u(Class<T> cls) {
        View view = this.c.get(cls.getName());
        if (view == null || view.getLayoutParams() == null) {
            return null;
        }
        return (T) z(cls, (WindowManager.LayoutParams) view.getLayoutParams());
    }

    public void v() {
        l1.e(new Runnable() { // from class: com.frame.t
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T w(View view, WindowManager.LayoutParams layoutParams) {
        if (view == 0 || layoutParams == null) {
            return null;
        }
        view.setVisibility(0);
        if (view.getParent() == null) {
            synchronized (e) {
                if (view.getParent() == null) {
                    WindowManager windowManager = (WindowManager) t0.a().getSystemService("window");
                    if (windowManager != null) {
                        this.a = windowManager;
                    }
                    view.setTag(this.a);
                    try {
                        this.a.addView(view, layoutParams);
                    } catch (Exception e2) {
                        k0.r(e2);
                    }
                }
            }
        } else {
            Log.e(view.getClass().getName(), "：已在页面上显示");
        }
        return view;
    }

    public <T> T x(Class<T> cls) {
        return (T) y(cls, 0, 0, -1, -1);
    }

    public <T> T y(Class<T> cls, int i2, int i3, int i4, int i5) {
        WindowManager.LayoutParams layoutParamsB = t0.b(true);
        this.b = layoutParamsB;
        layoutParamsB.x = Math.abs(i2);
        this.b.y = Math.abs(i3);
        WindowManager.LayoutParams layoutParams = this.b;
        layoutParams.width = i4;
        layoutParams.height = i5;
        return (T) z(cls, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T z(Class<T> cls, WindowManager.LayoutParams layoutParams) {
        T t;
        synchronized (e) {
            t = (T) h(cls);
            View view = (View) t;
            try {
                view.setVisibility(0);
                if (view.getParent() == null) {
                    try {
                        WindowManager windowManager = (WindowManager) t0.a().getSystemService("window");
                        if (windowManager != null) {
                            this.a = windowManager;
                        }
                        view.setTag(this.a);
                        this.a.addView(view, layoutParams);
                    } catch (WindowManager.BadTokenException unused) {
                        this.a = (WindowManager) t0.a().getSystemService("window");
                        try {
                            r(view);
                            WindowManager windowManager2 = this.a;
                            if (windowManager2 != null) {
                                view.setTag(windowManager2);
                                this.a.addView(view, layoutParams);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            r(view);
                        }
                    } catch (IllegalStateException unused2) {
                        this.a = (WindowManager) t0.a().getSystemService("window");
                        try {
                            r(view);
                            WindowManager windowManager3 = this.a;
                            if (windowManager3 != null) {
                                view.setTag(windowManager3);
                                this.a.addView(view, layoutParams);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            r(view);
                        }
                    } catch (Exception e4) {
                        k0.r(e4);
                        r(view);
                    }
                } else if (Build.VERSION.SDK_INT < 19 || view.isAttachedToWindow()) {
                    Log.e(cls.getName(), "：已在页面上显示");
                } else {
                    r(view);
                    try {
                        view.setTag(this.a);
                        this.a.addView(view, layoutParams);
                    } catch (Exception e5) {
                        k0.r(e5);
                    }
                }
            } catch (Exception e6) {
                if (v0.g().l()) {
                    k0.r(e6);
                }
            }
        }
        return t;
    }
}
