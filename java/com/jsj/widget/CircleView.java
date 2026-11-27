package com.jsj.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.frame.p1;

/* loaded from: classes.dex */
public class CircleView extends View {
    Paint c;
    Paint d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f788h;

    /* renamed from: i, reason: collision with root package name */
    private a f789i;

    public interface a {
        void a();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Paint();
        this.d = new Paint();
        this.e = p1.c(2.0f);
        this.g = 180;
    }

    public void a() {
        this.f788h = false;
        this.g = 180;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.e;
        RectF rectF = new RectF(getLeft() + i2, getTop() + i2, getRight() - i2, getBottom() - i2);
        canvas.drawArc(rectF, 0.0f, 360.0f, true, this.d);
        canvas.drawArc(rectF, 180.0f, this.g, false, this.c);
        if (this.f788h) {
            int i3 = this.g - 8;
            this.g = i3;
            if (i3 >= -360) {
                invalidate();
                return;
            } else {
                this.g = 180;
                invalidate();
                return;
            }
        }
        int i4 = this.g - 17;
        this.g = i4;
        if (i4 > -300) {
            invalidate();
            return;
        }
        this.g = -360;
        invalidate();
        a aVar = this.f789i;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() throws Resources.NotFoundException {
        super.onFinishInflate();
        Paint paint = this.c;
        int color = this.f;
        if (color == 0) {
            color = getResources().getColor(2131099761);
        }
        paint.setColor(color);
        this.c.setStrokeWidth(this.e);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        Paint paint2 = this.d;
        int color2 = this.f;
        if (color2 == 0) {
            color2 = getResources().getColor(2131099761);
        }
        paint2.setColor(color2);
        this.d.setStrokeWidth(this.e);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAlpha(100);
        this.d.setAntiAlias(true);
    }

    public void setColor(int i2) {
        this.f = i2;
        this.c.setColor(i2);
        this.d.setColor(i2);
    }

    public void setOnFinishListener(a aVar) {
        this.f789i = aVar;
    }

    public void setStrokeWidth(int i2) {
        this.e = i2;
        this.c.setStrokeWidth(i2);
        this.d.setStrokeWidth(this.e);
    }

    public CircleView(Context context) {
        super(context);
        this.c = new Paint();
        this.d = new Paint();
        this.e = p1.c(2.0f);
        this.g = 180;
    }

    public CircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new Paint();
        this.d = new Paint();
        this.e = p1.c(2.0f);
        this.g = 180;
    }
}
