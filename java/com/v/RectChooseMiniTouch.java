package com.v;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class RectChooseMiniTouch extends LinearLayout {
    RectChooseView c;
    float d;
    float e;
    int f;
    int g;

    /* renamed from: h, reason: collision with root package name */
    int f1035h;

    /* renamed from: i, reason: collision with root package name */
    int f1036i;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                RectChooseMiniTouch.this.d = motionEvent.getX();
                RectChooseMiniTouch.this.e = motionEvent.getY();
                Rect rect = RectChooseMiniTouch.this.getRect();
                RectChooseMiniTouch rectChooseMiniTouch = RectChooseMiniTouch.this;
                rectChooseMiniTouch.f = rect.left;
                rectChooseMiniTouch.g = rect.right;
                rectChooseMiniTouch.f1035h = rect.top;
                rectChooseMiniTouch.f1036i = rect.bottom;
                rectChooseMiniTouch.c.s();
            } else if (action == 1) {
                RectChooseMiniTouch.this.c.t();
            } else if (action == 2) {
                int x = ((int) (motionEvent.getX() - RectChooseMiniTouch.this.d)) / 3;
                float y = motionEvent.getY();
                RectChooseMiniTouch rectChooseMiniTouch2 = RectChooseMiniTouch.this;
                int i2 = ((int) (y - rectChooseMiniTouch2.e)) / 3;
                Rect rect2 = rectChooseMiniTouch2.getRect();
                RectChooseMiniTouch rectChooseMiniTouch3 = RectChooseMiniTouch.this;
                int i3 = rectChooseMiniTouch3.f + x;
                rect2.left = i3;
                int i4 = rectChooseMiniTouch3.g + x;
                rect2.right = i4;
                int i5 = rectChooseMiniTouch3.f1035h + i2;
                rect2.top = i5;
                int i6 = rectChooseMiniTouch3.f1036i + i2;
                rect2.bottom = i6;
                rectChooseMiniTouch3.c.setRectXY(i3, i5, i4, i6);
                RectChooseMiniTouch.this.c.postInvalidate();
            }
            return true;
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                RectChooseMiniTouch.this.d = motionEvent.getX();
                RectChooseMiniTouch.this.e = motionEvent.getY();
                Rect rect = RectChooseMiniTouch.this.getRect();
                RectChooseMiniTouch rectChooseMiniTouch = RectChooseMiniTouch.this;
                rectChooseMiniTouch.f = rect.left;
                rectChooseMiniTouch.g = rect.right;
                rectChooseMiniTouch.f1035h = rect.top;
                rectChooseMiniTouch.f1036i = rect.bottom;
                rectChooseMiniTouch.c.s();
            } else if (action == 1) {
                RectChooseMiniTouch.this.c.t();
            } else if (action == 2) {
                int x = ((int) (motionEvent.getX() - RectChooseMiniTouch.this.d)) / 3;
                float y = motionEvent.getY();
                RectChooseMiniTouch rectChooseMiniTouch2 = RectChooseMiniTouch.this;
                int i2 = ((int) (y - rectChooseMiniTouch2.e)) / 3;
                Rect rect2 = rectChooseMiniTouch2.getRect();
                RectChooseMiniTouch rectChooseMiniTouch3 = RectChooseMiniTouch.this;
                int i3 = rectChooseMiniTouch3.g + x;
                rect2.right = i3;
                int i4 = rectChooseMiniTouch3.f1036i + i2;
                rect2.bottom = i4;
                rectChooseMiniTouch3.c.setRectXY(rect2.left, rect2.top, i3, i4);
                RectChooseMiniTouch.this.c.postInvalidate();
            }
            return true;
        }
    }

    public RectChooseMiniTouch(Context context) {
        super(context);
        this.d = 0.0f;
        this.e = 0.0f;
    }

    public Rect getRect() {
        if (this.c.getRect() == null) {
            int iC = com.frame.p1.c(20.0f);
            int i2 = -iC;
            Rect rect = new Rect(i2, i2, iC, iC);
            rect.offset(com.frame.k0.c().e() / 2, com.frame.k0.c().d() / 2);
            this.c.setRect(rect);
        }
        return this.c.getRect();
    }

    public void setRectChooseView(RectChooseView rectChooseView) {
        this.c = rectChooseView;
    }

    public RectChooseMiniTouch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        this.e = 0.0f;
    }

    public RectChooseMiniTouch(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = 0.0f;
        this.e = 0.0f;
    }

    public RectChooseMiniTouch() {
        this(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.m1, this);
        findViewById(j.b.e.R).setOnTouchListener(new a());
        findViewById(j.b.e.S).setOnTouchListener(new b());
    }
}
