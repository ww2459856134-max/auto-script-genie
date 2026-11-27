package com.v;

import android.graphics.drawable.Drawable;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public class FloatToast extends AppCompatTextView implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    public static int f961h = com.frame.n0.c("ftGra", 48);

    public FloatToast() {
        super(com.frame.v0.g());
        setTextColor(-1);
        setText("点击偏移点");
        setTextSize(13.0f);
        setGravity(17);
        setBackgroundResource(j.b.d.g);
        int iC = com.frame.p1.c(6.0f);
        int i2 = iC * 3;
        setPadding(i2, iC, i2, iC);
        setCompoundDrawablePadding(iC);
        setAlpha(0.9f);
    }

    static /* synthetic */ void f(WindowManager.LayoutParams layoutParams, int i2, CharSequence charSequence, boolean z) {
        FloatToast floatToast = (FloatToast) com.frame.s0.g().z(FloatToast.class, layoutParams);
        if (i2 == 0) {
            floatToast.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            floatToast.setCompoundDrawablesRelativeWithIntrinsicBounds(com.frame.v0.g().getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        floatToast.setText(charSequence);
        if (z) {
            floatToast.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        }
        com.frame.l1.c(floatToast.hashCode(), floatToast, 2000L);
    }

    public static final void g(int i2, CharSequence charSequence) {
        int i3 = f961h;
        if (i3 == -1) {
            return;
        }
        h(i2, charSequence, false, i3);
    }

    public static final void h(final int i2, final CharSequence charSequence, final boolean z, int i3) {
        final WindowManager.LayoutParams layoutParamsB = com.frame.t0.b(false);
        if (i3 == 17) {
            layoutParamsB.y = 0;
            layoutParamsB.gravity = 17;
        } else {
            layoutParamsB.y = i3 == 48 ? com.frame.p1.c(100.0f) : com.frame.q1.d() - com.frame.p1.c(100.0f);
            layoutParamsB.gravity = 49;
        }
        layoutParamsB.width = -2;
        layoutParamsB.height = -2;
        com.frame.l1.c(8887777, new Runnable() { // from class: com.v.w7
            @Override // java.lang.Runnable
            public final void run() {
                FloatToast.f(layoutParamsB, i2, charSequence, z);
            }
        }, 300L);
    }

    public static final void i(CharSequence charSequence) {
        int i2 = f961h;
        if (i2 == -1) {
            return;
        }
        h(0, charSequence, false, i2);
    }

    public static final void setPosition(int i2) {
        f961h = i2;
        com.frame.n0.i("ftGra", i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.frame.s0.g().d(FloatToast.class);
    }
}
