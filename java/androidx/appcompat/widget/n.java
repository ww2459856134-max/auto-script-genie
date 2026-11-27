package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
class n {
    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    n(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    void a() throws NoSuchFieldException {
        Drawable drawableA = androidx.core.widget.e.a(this.a);
        if (drawableA != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.q(drawableA).mutate();
                if (this.d) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.b);
                }
                if (this.e) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i2) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = androidx.core.widget.e.a(this.a)) == null) ? i2 : i2 + drawableA.getIntrinsicWidth();
    }

    ColorStateList c() {
        return this.b;
    }

    PorterDuff.Mode d() {
        return this.c;
    }

    void e(AttributeSet attributeSet, int i2) {
        boolean z;
        int iM;
        int iM2;
        Context context = this.a.getContext();
        int[] iArr = h.a.j.O0;
        t1 t1VarU = t1.u(context, attributeSet, iArr, i2, 0);
        CompoundButton compoundButton = this.a;
        h.e.j.s0.X(compoundButton, compoundButton.getContext(), iArr, attributeSet, t1VarU.q(), i2, 0);
        try {
            int i3 = h.a.j.Q0;
            if (!t1VarU.r(i3) || (iM2 = t1VarU.m(i3, 0)) == 0) {
                z = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(h.a.k.a.b.d(compoundButton2.getContext(), iM2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (!z) {
                int i4 = h.a.j.P0;
                if (t1VarU.r(i4) && (iM = t1VarU.m(i4, 0)) != 0) {
                    CompoundButton compoundButton3 = this.a;
                    compoundButton3.setButtonDrawable(h.a.k.a.b.d(compoundButton3.getContext(), iM));
                }
            }
            int i5 = h.a.j.R0;
            if (t1VarU.r(i5)) {
                androidx.core.widget.e.b(this.a, t1VarU.c(i5));
            }
            int i6 = h.a.j.S0;
            if (t1VarU.r(i6)) {
                androidx.core.widget.e.c(this.a, m0.e(t1VarU.j(i6, -1), null));
            }
        } finally {
            t1VarU.v();
        }
    }

    void f() throws NoSuchFieldException {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) throws NoSuchFieldException {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    void h(PorterDuff.Mode mode) throws NoSuchFieldException {
        this.c = mode;
        this.e = true;
        a();
    }
}
