package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class CanDragCloseButton extends TextView implements View.OnTouchListener {
    float c;
    float d;
    float e;
    float f;
    int g;

    public CanDragCloseButton(Context context) {
        super(context);
        this.g = com.frame.p1.c(5.0f);
        a();
    }

    public void a() {
        int iC = com.frame.p1.c(10.0f);
        int i2 = iC / 2;
        setPadding(iC, i2, iC, i2);
        setTextColor(-1);
        setCompoundDrawablePadding(i2);
        setTextSize(13.0f);
        setBackgroundResource(j.b.d.f1741h);
        setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
            this.d = motionEvent.getY();
            this.e = motionEvent.getRawX();
            this.f = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                setX(motionEvent.getRawX() - this.c);
                setY(motionEvent.getRawY() - this.d);
            }
        } else if (Math.abs(motionEvent.getRawX() - this.e) < this.g && Math.abs(motionEvent.getRawY() - this.f) < this.g) {
            callOnClick();
        }
        return true;
    }

    public CanDragCloseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = com.frame.p1.c(5.0f);
    }

    public CanDragCloseButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = com.frame.p1.c(5.0f);
    }
}
