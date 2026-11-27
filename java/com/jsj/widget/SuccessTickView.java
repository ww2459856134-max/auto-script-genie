package com.jsj.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public class SuccessTickView extends View {
    private float A;
    private boolean C;
    private float c;
    private Paint d;
    private final float e;
    private final float f;
    private final float g;

    /* renamed from: h, reason: collision with root package name */
    private final float f797h;

    /* renamed from: i, reason: collision with root package name */
    private final float f798i;

    /* renamed from: j, reason: collision with root package name */
    private final float f799j;

    /* renamed from: k, reason: collision with root package name */
    private float f800k;
    private float t;

    class a extends Animation {
        a() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            double d = f;
            if (0.54d < d && 0.7d >= d) {
                SuccessTickView.this.C = true;
                SuccessTickView successTickView = SuccessTickView.this;
                successTickView.t = successTickView.f800k * ((f - 0.54f) / 0.16f);
                if (0.65d < d) {
                    SuccessTickView successTickView2 = SuccessTickView.this;
                    successTickView2.A = successTickView2.f799j * ((f - 0.65f) / 0.19f);
                }
                SuccessTickView.this.invalidate();
                return;
            }
            if (0.7d < d && 0.84d >= d) {
                SuccessTickView.this.C = false;
                SuccessTickView successTickView3 = SuccessTickView.this;
                successTickView3.t = successTickView3.f800k * (1.0f - ((f - 0.7f) / 0.14f));
                SuccessTickView successTickView4 = SuccessTickView.this;
                successTickView4.t = successTickView4.t < SuccessTickView.this.f798i ? SuccessTickView.this.f798i : SuccessTickView.this.t;
                SuccessTickView successTickView5 = SuccessTickView.this;
                successTickView5.A = successTickView5.f799j * ((f - 0.65f) / 0.19f);
                SuccessTickView.this.invalidate();
                return;
            }
            if (0.84d >= d || 1.0f < f) {
                return;
            }
            SuccessTickView.this.C = false;
            SuccessTickView successTickView6 = SuccessTickView.this;
            float f2 = (f - 0.84f) / 0.16f;
            successTickView6.t = successTickView6.f798i + ((SuccessTickView.this.g - SuccessTickView.this.f798i) * f2);
            SuccessTickView successTickView7 = SuccessTickView.this;
            successTickView7.A = successTickView7.f797h + ((SuccessTickView.this.f799j - SuccessTickView.this.f797h) * (1.0f - f2));
            SuccessTickView.this.invalidate();
        }
    }

    public SuccessTickView(Context context) {
        super(context);
        this.c = -1.0f;
        this.e = j(1.2f);
        this.f = j(3.0f);
        this.g = j(15.0f);
        float fJ = j(25.0f);
        this.f797h = fJ;
        this.f798i = j(3.3f);
        this.f799j = fJ + j(6.7f);
        k();
    }

    private void k() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(getResources().getColor(2131099761));
        this.t = this.g;
        this.A = this.f797h;
        this.C = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i2 = (int) (height / 1.4d);
        float f = (int) (width / 1.2d);
        this.f800k = (((this.g + f) / 2.0f) + this.f) - 1.0f;
        RectF rectF = new RectF();
        if (this.C) {
            rectF.left = 0.0f;
            rectF.right = 0.0f + this.t;
            float f2 = (i2 + this.f797h) / 2.0f;
            rectF.top = f2;
            rectF.bottom = f2 + this.f;
        } else {
            float f3 = (this.g + f) / 2.0f;
            float f4 = this.f;
            float f5 = (f3 + f4) - 1.0f;
            rectF.right = f5;
            rectF.left = f5 - this.t;
            float f6 = (i2 + this.f797h) / 2.0f;
            rectF.top = f6;
            rectF.bottom = f6 + f4;
        }
        float f7 = this.e;
        canvas.drawRoundRect(rectF, f7, f7, this.d);
        RectF rectF2 = new RectF();
        float f8 = (i2 + this.f797h) / 2.0f;
        float f9 = this.f;
        float f10 = (f8 + f9) - 1.0f;
        rectF2.bottom = f10;
        float f11 = (f + this.g) / 2.0f;
        rectF2.left = f11;
        rectF2.right = f11 + f9;
        rectF2.top = f10 - this.A;
        float f12 = this.e;
        canvas.drawRoundRect(rectF2, f12, f12, this.d);
    }

    public float j(float f) {
        if (this.c == -1.0f) {
            this.c = getResources().getDisplayMetrics().density;
        }
        return (f * this.c) + 0.5f;
    }

    public void l() {
        this.t = 0.0f;
        this.A = 0.0f;
        invalidate();
        a aVar = new a();
        aVar.setDuration(750L);
        aVar.setStartOffset(0L);
        startAnimation(aVar);
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1.0f;
        this.e = j(1.2f);
        this.f = j(3.0f);
        this.g = j(15.0f);
        float fJ = j(25.0f);
        this.f797h = fJ;
        this.f798i = j(3.3f);
        this.f799j = fJ + j(6.7f);
        k();
    }
}
