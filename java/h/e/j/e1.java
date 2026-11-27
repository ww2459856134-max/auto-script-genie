package h.e.j;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class e1 {
    public static final e1 b;
    private final o1 a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            b = n1.f1315n;
        } else {
            b = o1.b;
        }
    }

    private e1(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.a = new n1(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.a = new m1(this, windowInsets);
            return;
        }
        if (i2 >= 28) {
            this.a = new l1(this, windowInsets);
            return;
        }
        if (i2 >= 21) {
            this.a = new k1(this, windowInsets);
        } else if (i2 >= 20) {
            this.a = new j1(this, windowInsets);
        } else {
            this.a = new o1(this);
        }
    }

    static h.e.d.b j(h.e.d.b bVar, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, bVar.a - i2);
        int iMax2 = Math.max(0, bVar.b - i3);
        int iMax3 = Math.max(0, bVar.c - i4);
        int iMax4 = Math.max(0, bVar.d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? bVar : h.e.d.b.b(iMax, iMax2, iMax3, iMax4);
    }

    public static e1 r(WindowInsets windowInsets) {
        return s(windowInsets, null);
    }

    public static e1 s(WindowInsets windowInsets, View view) {
        h.e.i.h.d(windowInsets);
        e1 e1Var = new e1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            e1Var.o(s0.C(view));
            e1Var.d(view.getRootView());
        }
        return e1Var;
    }

    @Deprecated
    public e1 a() {
        return this.a.a();
    }

    @Deprecated
    public e1 b() {
        return this.a.b();
    }

    @Deprecated
    public e1 c() {
        return this.a.c();
    }

    void d(View view) {
        this.a.d(view);
    }

    @Deprecated
    public int e() {
        return this.a.h().d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e1) {
            return h.e.i.c.a(this.a, ((e1) obj).a);
        }
        return false;
    }

    @Deprecated
    public int f() {
        return this.a.h().a;
    }

    @Deprecated
    public int g() {
        return this.a.h().c;
    }

    @Deprecated
    public int h() {
        return this.a.h().b;
    }

    public int hashCode() {
        o1 o1Var = this.a;
        if (o1Var == null) {
            return 0;
        }
        return o1Var.hashCode();
    }

    public e1 i(int i2, int i3, int i4, int i5) {
        return this.a.i(i2, i3, i4, i5);
    }

    public boolean k() {
        return this.a.j();
    }

    @Deprecated
    public e1 l(int i2, int i3, int i4, int i5) {
        a aVar = new a(this);
        aVar.c(h.e.d.b.b(i2, i3, i4, i5));
        return aVar.a();
    }

    void m(h.e.d.b[] bVarArr) {
        this.a.l(bVarArr);
    }

    void n(h.e.d.b bVar) {
        this.a.m(bVar);
    }

    void o(e1 e1Var) {
        this.a.n(e1Var);
    }

    void p(h.e.d.b bVar) {
        this.a.o(bVar);
    }

    public WindowInsets q() {
        o1 o1Var = this.a;
        if (o1Var instanceof j1) {
            return ((j1) o1Var).c;
        }
        return null;
    }

    public static final class a {
        private final i1 a;

        public a() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.a = new h1();
                return;
            }
            if (i2 >= 29) {
                this.a = new g1();
            } else if (i2 >= 20) {
                this.a = new f1();
            } else {
                this.a = new i1();
            }
        }

        public e1 a() {
            return this.a.b();
        }

        @Deprecated
        public a b(h.e.d.b bVar) {
            this.a.d(bVar);
            return this;
        }

        @Deprecated
        public a c(h.e.d.b bVar) {
            this.a.f(bVar);
            return this;
        }

        public a(e1 e1Var) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.a = new h1(e1Var);
                return;
            }
            if (i2 >= 29) {
                this.a = new g1(e1Var);
            } else if (i2 >= 20) {
                this.a = new f1(e1Var);
            } else {
                this.a = new i1(e1Var);
            }
        }
    }

    public e1(e1 e1Var) {
        if (e1Var != null) {
            o1 o1Var = e1Var.a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (o1Var instanceof n1)) {
                this.a = new n1(this, (n1) o1Var);
            } else if (i2 >= 29 && (o1Var instanceof m1)) {
                this.a = new m1(this, (m1) o1Var);
            } else if (i2 >= 28 && (o1Var instanceof l1)) {
                this.a = new l1(this, (l1) o1Var);
            } else if (i2 >= 21 && (o1Var instanceof k1)) {
                this.a = new k1(this, (k1) o1Var);
            } else if (i2 >= 20 && (o1Var instanceof j1)) {
                this.a = new j1(this, (j1) o1Var);
            } else {
                this.a = new o1(this);
            }
            o1Var.e(this);
            return;
        }
        this.a = new o1(this);
    }
}
