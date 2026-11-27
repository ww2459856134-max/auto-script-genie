package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class l1 {
    final k1 a;
    j1 b = new j1();

    l1(k1 k1Var) {
        this.a = k1Var;
    }

    View a(int i2, int i3, int i4, int i5) {
        int iB = this.a.b();
        int iC = this.a.c();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View viewA = this.a.a(i2);
            this.b.e(iB, iC, this.a.d(viewA), this.a.e(viewA));
            if (i4 != 0) {
                this.b.d();
                this.b.a(i4);
                if (this.b.b()) {
                    return viewA;
                }
            }
            if (i5 != 0) {
                this.b.d();
                this.b.a(i5);
                if (this.b.b()) {
                    view = viewA;
                }
            }
            i2 += i6;
        }
        return view;
    }

    boolean b(View view, int i2) {
        this.b.e(this.a.b(), this.a.c(), this.a.d(view), this.a.e(view));
        if (i2 == 0) {
            return false;
        }
        this.b.d();
        this.b.a(i2);
        return this.b.b();
    }
}
