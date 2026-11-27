package com.v;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ColorView extends View {
    private int c;
    private Paint d;
    private Paint e;
    private int f;

    public ColorView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.d != null) {
            int width = getWidth() - com.frame.p1.c(4.0f);
            getHeight();
            com.frame.p1.c(4.0f);
            float width2 = getWidth() / 2;
            float height = getHeight() / 2;
            float f = width / 2;
            canvas.drawCircle(width2, height, f, this.d);
            Paint paint = this.e;
            if (paint != null) {
                canvas.drawCircle(width2, height, f, paint);
            }
        }
    }

    public int getColor() {
        return this.c;
    }

    public void setBoundColor(int i2) {
        this.f = com.frame.p1.c(4.0f);
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(i2);
        this.e.setStrokeWidth(this.f / 2);
        this.e.setStyle(Paint.Style.STROKE);
    }

    public void setColor(int i2) {
        this.c = i2;
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(i2);
        postInvalidate();
    }

    public ColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
