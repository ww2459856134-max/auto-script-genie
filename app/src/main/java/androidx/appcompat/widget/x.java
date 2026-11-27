package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class x extends t {
    private final SeekBar d;
    private Drawable e;
    private ColorStateList f;
    private PorterDuff.Mode g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f178h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f179i;

    x(SeekBar seekBar) {
        super(seekBar);
        this.f = null;
        this.g = null;
        this.f178h = false;
        this.f179i = false;
        this.d = seekBar;
    }

    private void f() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.f178h || this.f179i) {
                Drawable drawableQ = androidx.core.graphics.drawable.a.q(drawable.mutate());
                this.e = drawableQ;
                if (this.f178h) {
                    androidx.core.graphics.drawable.a.n(drawableQ, this.f);
                }
                if (this.f179i) {
                    androidx.core.graphics.drawable.a.o(this.e, this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.t
    void c(AttributeSet attributeSet, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.c(attributeSet, i2);
        Context context = this.d.getContext();
        int[] iArr = h.a.j.T;
        t1 t1VarU = t1.u(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.d;
        h.e.j.s0.X(seekBar, seekBar.getContext(), iArr, attributeSet, t1VarU.q(), i2, 0);
        Drawable drawableG = t1VarU.g(h.a.j.U);
        if (drawableG != null) {
            this.d.setThumb(drawableG);
        }
        j(t1VarU.f(h.a.j.V));
        int i3 = h.a.j.X;
        if (t1VarU.r(i3)) {
            this.g = m0.e(t1VarU.j(i3, -1), this.g);
            this.f179i = true;
        }
        int i4 = h.a.j.W;
        if (t1VarU.r(i4)) {
            this.f = t1VarU.c(i4);
            this.f178h = true;
        }
        t1VarU.v();
        f();
    }

    void g(Canvas canvas) {
        if (this.e != null) {
            int max = this.d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.d);
            androidx.core.graphics.drawable.a.l(drawable, h.e.j.s0.w(this.d));
            if (drawable.isStateful()) {
                drawable.setState(this.d.getDrawableState());
            }
            f();
        }
        this.d.invalidate();
    }
}
