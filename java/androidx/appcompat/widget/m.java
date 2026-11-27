package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
class m {
    private final View a;
    private r1 d;
    private r1 e;
    private r1 f;
    private int c = -1;
    private final p b = p.b();

    m(View view) {
        this.a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new r1();
        }
        r1 r1Var = this.f;
        r1Var.a();
        ColorStateList colorStateListN = h.e.j.s0.n(this.a);
        if (colorStateListN != null) {
            r1Var.d = true;
            r1Var.a = colorStateListN;
        }
        PorterDuff.Mode modeO = h.e.j.s0.o(this.a);
        if (modeO != null) {
            r1Var.c = true;
            r1Var.b = modeO;
        }
        if (!r1Var.d && !r1Var.c) {
            return false;
        }
        p.i(drawable, r1Var, this.a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.d != null : i2 == 21;
    }

    void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            r1 r1Var = this.e;
            if (r1Var != null) {
                p.i(background, r1Var, this.a.getDrawableState());
                return;
            }
            r1 r1Var2 = this.d;
            if (r1Var2 != null) {
                p.i(background, r1Var2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        r1 r1Var = this.e;
        if (r1Var != null) {
            return r1Var.a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        r1 r1Var = this.e;
        if (r1Var != null) {
            return r1Var.b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i2) {
        Context context = this.a.getContext();
        int[] iArr = h.a.j.D3;
        t1 t1VarU = t1.u(context, attributeSet, iArr, i2, 0);
        View view = this.a;
        h.e.j.s0.X(view, view.getContext(), iArr, attributeSet, t1VarU.q(), i2, 0);
        try {
            int i3 = h.a.j.E3;
            if (t1VarU.r(i3)) {
                this.c = t1VarU.m(i3, -1);
                ColorStateList colorStateListF = this.b.f(this.a.getContext(), this.c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i4 = h.a.j.F3;
            if (t1VarU.r(i4)) {
                h.e.j.s0.b0(this.a, t1VarU.c(i4));
            }
            int i5 = h.a.j.G3;
            if (t1VarU.r(i5)) {
                h.e.j.s0.c0(this.a, m0.e(t1VarU.j(i5, -1), null));
            }
        } finally {
            t1VarU.v();
        }
    }

    void f(Drawable drawable) {
        this.c = -1;
        h(null);
        b();
    }

    void g(int i2) {
        this.c = i2;
        p pVar = this.b;
        h(pVar != null ? pVar.f(this.a.getContext(), i2) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new r1();
            }
            r1 r1Var = this.d;
            r1Var.a = colorStateList;
            r1Var.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new r1();
        }
        r1 r1Var = this.e;
        r1Var.a = colorStateList;
        r1Var.d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new r1();
        }
        r1 r1Var = this.e;
        r1Var.b = mode;
        r1Var.c = true;
        b();
    }
}
