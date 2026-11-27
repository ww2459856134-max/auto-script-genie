package com.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class ProgressBar extends View {
    private int c;
    private int d;
    private AnimatorListenerAdapter e;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            ProgressBar.this.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ProgressBar.this.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ProgressBar.this.setVisibility(0);
        }
    }

    public ProgressBar() {
        super(com.frame.v0.g());
        this.d = 0;
        this.e = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(ValueAnimator valueAnimator) {
        this.d = ((Integer) valueAnimator.getAnimatedValue("progress")).intValue();
        postInvalidate();
    }

    static /* synthetic */ void d(int i2) {
        int iC = com.frame.p1.c(100.0f);
        int iC2 = com.frame.p1.c(200.0f);
        int iC3 = com.frame.p1.c(25.0f);
        ProgressBar progressBar = (ProgressBar) com.frame.s0.g().F(ProgressBar.class, (com.frame.k0.c().e() - iC2) / 2, iC, iC2, iC3);
        progressBar.setAlpha(0.4f);
        progressBar.g(i2);
    }

    static /* synthetic */ void e(Runnable runnable) {
        com.frame.s0.g().d(ProgressBar.class);
        runnable.run();
    }

    static /* synthetic */ void f(ProgressBar progressBar, int i2) {
        progressBar.setVisibility(0);
        progressBar.g(i2);
    }

    public static void h(final int i2) {
        if (i2 <= 0) {
            return;
        }
        final Runnable runnable = new Runnable() { // from class: com.v.mj
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.d(i2);
            }
        };
        final ProgressBar progressBar = (ProgressBar) com.frame.s0.g().f(ProgressBar.class);
        if (progressBar == null) {
            com.frame.l1.e(runnable);
        } else if (progressBar.getLayoutParams() == null) {
            com.frame.l1.e(new Runnable() { // from class: com.v.oj
                @Override // java.lang.Runnable
                public final void run() {
                    ProgressBar.e(runnable);
                }
            });
        } else {
            com.frame.l1.e(new Runnable() { // from class: com.v.nj
                @Override // java.lang.Runnable
                public final void run() {
                    ProgressBar.f(this.c, i2);
                }
            });
        }
    }

    public String a(long j2) {
        int i2 = (int) ((j2 % 3600000) / 60000);
        int i3 = (int) ((j2 % 60000) / 1000);
        int i4 = (int) (j2 % 1000);
        return i2 > 0 ? String.format("%02d:%02d.%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format("%02d.%02d", Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void g(int i2) {
        this.c = i2;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "progress", 0, i2);
        objectAnimatorOfInt.setDuration(i2);
        objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.v.lj
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.c(valueAnimator);
            }
        });
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.addListener(this.e);
        objectAnimatorOfInt.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c == 0) {
            return;
        }
        int iC = com.frame.p1.c(5.0f);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Paint paint = new Paint();
        paint.setAlpha(10);
        paint.setColor(-16777216);
        float f = iC;
        canvas.drawRoundRect(rectF, f, f, paint);
        RectF rectF2 = new RectF(0.0f, 0.0f, (getWidth() * this.d) / this.c, getHeight());
        paint.setColor(-65536);
        canvas.drawRoundRect(rectF2, f, f, paint);
        Paint paint2 = new Paint();
        paint2.setTextSize(com.frame.p1.k(12.0f));
        paint2.setColor(-1);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float fCenterY = rectF2.centerY();
        float f2 = fontMetrics.bottom;
        float f3 = fontMetrics.top;
        canvas.drawText(a(this.d), getWidth() / 2, (fCenterY - ((f2 - f3) / 2.0f)) - f3, paint2);
    }

    public ProgressBar(Context context) {
        super(context);
        this.d = 0;
        this.e = new a();
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = new a();
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = 0;
        this.e = new a();
    }
}
