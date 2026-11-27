package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class r {
    private final ImageView a;
    private r1 b;
    private r1 c;
    private r1 d;

    public r(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new r1();
        }
        r1 r1Var = this.d;
        r1Var.a();
        ColorStateList colorStateListA = androidx.core.widget.g.a(this.a);
        if (colorStateListA != null) {
            r1Var.d = true;
            r1Var.a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.g.b(this.a);
        if (modeB != null) {
            r1Var.c = true;
            r1Var.b = modeB;
        }
        if (!r1Var.d && !r1Var.c) {
            return false;
        }
        p.i(drawable, r1Var, this.a.getDrawableState());
        return true;
    }

    private boolean j() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.b != null : i2 == 21;
    }

    void b() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            m0.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            r1 r1Var = this.c;
            if (r1Var != null) {
                p.i(drawable, r1Var, this.a.getDrawableState());
                return;
            }
            r1 r1Var2 = this.b;
            if (r1Var2 != null) {
                p.i(drawable, r1Var2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        r1 r1Var = this.c;
        if (r1Var != null) {
            return r1Var.a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        r1 r1Var = this.c;
        if (r1Var != null) {
            return r1Var.b;
        }
        return null;
    }

    boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i2) {
        int iM;
        Context context = this.a.getContext();
        int[] iArr = h.a.j.P;
        t1 t1VarU = t1.u(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.a;
        h.e.j.s0.X(imageView, imageView.getContext(), iArr, attributeSet, t1VarU.q(), i2, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (iM = t1VarU.m(h.a.j.Q, -1)) != -1 && (drawable = h.a.k.a.b.d(this.a.getContext(), iM)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                m0.b(drawable);
            }
            int i3 = h.a.j.R;
            if (t1VarU.r(i3)) {
                androidx.core.widget.g.c(this.a, t1VarU.c(i3));
            }
            int i4 = h.a.j.S;
            if (t1VarU.r(i4)) {
                androidx.core.widget.g.d(this.a, m0.e(t1VarU.j(i4, -1), null));
            }
        } finally {
            t1VarU.v();
        }
    }

    public void g(int i2) {
        if (i2 != 0) {
            Drawable drawableD = h.a.k.a.b.d(this.a.getContext(), i2);
            if (drawableD != null) {
                m0.b(drawableD);
            }
            this.a.setImageDrawable(drawableD);
        } else {
            this.a.setImageDrawable(null);
        }
        b();
    }

    void h(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new r1();
        }
        r1 r1Var = this.c;
        r1Var.a = colorStateList;
        r1Var.d = true;
        b();
    }

    void i(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new r1();
        }
        r1 r1Var = this.c;
        r1Var.b = mode;
        r1Var.c = true;
        b();
    }
}
