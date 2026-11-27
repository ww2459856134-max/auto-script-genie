package com.v;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class MultiClickChooseView extends RelativeLayout {
    private TextView c;
    private View.OnClickListener d;
    private int e;
    private int f;
    private int g;

    public MultiClickChooseView() {
        super(com.frame.v0.g());
        this.g = com.frame.p1.c(20.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#99000000"));
        Paint paint = new Paint();
        paint.setColor(-65536);
        paint.setAlpha(180);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(com.frame.p1.c(2.0f));
        canvas.drawCircle(this.e, this.f, this.g, paint);
        super.dispatchDraw(canvas);
    }

    public Point getPoint() {
        return new Point(this.e, this.f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.e = x;
        this.f = y;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            removeAllViews();
            postInvalidate();
        } else if (action == 1) {
            postInvalidate();
            View.OnClickListener onClickListener = this.d;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        } else if (action == 2) {
            postInvalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDefaultPoint(int i2, int i3) {
        this.e = i2;
        this.f = i3;
    }

    public void setHit(String str) {
        TextView textView = new TextView(com.frame.v0.g());
        this.c = textView;
        textView.setTextColor(-1);
        this.c.setText(str);
        this.c.setTextSize(20.0f);
        this.c.setGravity(17);
        addView(this.c, -1, -1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }
}
