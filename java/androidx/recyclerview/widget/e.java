package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class e {
    final a a;
    final d b = new d();
    final List<View> c = new ArrayList();

    interface a {
        View a(int i2);

        void b(View view);

        int c();

        RecyclerView.d0 d(View view);

        void e(View view, int i2);

        void f();

        void g(View view, int i2, ViewGroup.LayoutParams layoutParams);

        void h(int i2);

        int i(View view);

        void j(View view);

        void k(int i2);
    }

    e(a aVar) {
        this.a = aVar;
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int iC = this.a.c();
        int i3 = i2;
        while (i3 < iC) {
            int iB = i2 - (i3 - this.b.b(i3));
            if (iB == 0) {
                while (this.b.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.c.add(view);
        this.a.b(view);
    }

    private boolean t(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.j(view);
        return true;
    }

    void a(View view, int i2, boolean z) {
        int iC = i2 < 0 ? this.a.c() : h(i2);
        this.b.e(iC, z);
        if (z) {
            l(view);
        }
        this.a.e(view, iC);
    }

    void b(View view, boolean z) {
        a(view, -1, z);
    }

    void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iC = i2 < 0 ? this.a.c() : h(i2);
        this.b.e(iC, z);
        if (z) {
            l(view);
        }
        this.a.g(view, iC, layoutParams);
    }

    void d(int i2) {
        int iH = h(i2);
        this.b.f(iH);
        this.a.h(iH);
    }

    View e(int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.c.get(i3);
            RecyclerView.d0 d0VarD = this.a.d(view);
            if (d0VarD.getLayoutPosition() == i2 && !d0VarD.isInvalid() && !d0VarD.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View f(int i2) {
        return this.a.a(h(i2));
    }

    int g() {
        return this.a.c() - this.c.size();
    }

    View i(int i2) {
        return this.a.a(i2);
    }

    int j() {
        return this.a.c();
    }

    void k(View view) {
        int i2 = this.a.i(view);
        if (i2 >= 0) {
            this.b.h(i2);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int i2 = this.a.i(view);
        if (i2 == -1 || this.b.d(i2)) {
            return -1;
        }
        return i2 - this.b.b(i2);
    }

    boolean n(View view) {
        return this.c.contains(view);
    }

    void o() {
        this.b.g();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.a.j(this.c.get(size));
            this.c.remove(size);
        }
        this.a.f();
    }

    void p(View view) {
        int i2 = this.a.i(view);
        if (i2 < 0) {
            return;
        }
        if (this.b.f(i2)) {
            t(view);
        }
        this.a.k(i2);
    }

    void q(int i2) {
        int iH = h(i2);
        View viewA = this.a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.b.f(iH)) {
            t(viewA);
        }
        this.a.k(iH);
    }

    boolean r(View view) {
        int i2 = this.a.i(view);
        if (i2 == -1) {
            t(view);
            return true;
        }
        if (!this.b.d(i2)) {
            return false;
        }
        this.b.f(i2);
        t(view);
        this.a.k(i2);
        return true;
    }

    void s(View view) {
        int i2 = this.a.i(view);
        if (i2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.b.d(i2)) {
            this.b.a(i2);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
