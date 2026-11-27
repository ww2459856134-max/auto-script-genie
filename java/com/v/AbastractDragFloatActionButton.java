package com.v;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.s.BoxService;

/* loaded from: classes.dex */
public abstract class AbastractDragFloatActionButton extends RelativeLayout {
    private int A;
    private int C;
    private int c;
    private int d;
    protected WindowManager e;
    protected WindowManager.LayoutParams f;
    protected boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f896h;

    /* renamed from: i, reason: collision with root package name */
    private int f897i;

    /* renamed from: j, reason: collision with root package name */
    private int f898j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f899k;
    private int t;

    public AbastractDragFloatActionButton(Context context) {
        this(context, null, 0);
    }

    protected void a() {
        if (this.f896h) {
            WindowManager.LayoutParams layoutParams = this.f;
            int i2 = layoutParams.x;
            int i3 = this.d;
            if (i2 > i3 / 2) {
                layoutParams.x = i3 - getWidth();
            } else {
                layoutParams.x = 0;
            }
        }
        this.e.updateViewLayout(this, this.f);
        WindowManager.LayoutParams layoutParams2 = this.f;
        f(new Point(layoutParams2.x, layoutParams2.y));
    }

    public abstract Point b();

    void c(float f, float f2) {
        WindowManager.LayoutParams layoutParams = this.f;
        layoutParams.x = (int) f;
        layoutParams.y = (int) f2;
        this.e.updateViewLayout(this, layoutParams);
    }

    protected void d() {
    }

    public abstract void e(View view);

    public abstract void f(Point point);

    public abstract int getLayoutId();

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        try {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChildren(i2, i3);
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g) {
            return super.onTouchEvent(motionEvent);
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.t = com.frame.q1.f();
            this.f899k = false;
            this.f897i = (int) motionEvent.getX();
            this.f898j = (int) motionEvent.getY();
            this.A = rawX;
            this.C = rawY;
        } else if (action == 1) {
            a();
            if (Math.abs(this.A - rawX) < 20 && Math.abs(this.C - rawY) < 20) {
                d();
            }
        } else if (action == 2) {
            boolean z = this.c > 0 && this.d > 0;
            this.f899k = z;
            if (z) {
                c(rawX - this.f897i, (rawY - this.f898j) - this.t);
            }
        }
        return this.f899k || super.onTouchEvent(motionEvent);
    }

    public void setMagnet(boolean z) {
        this.f896h = z;
        if (z) {
            a();
        }
    }

    public AbastractDragFloatActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbastractDragFloatActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = true;
        this.f896h = true;
        try {
            this.c = com.frame.q1.d();
            this.d = com.frame.q1.e();
            e(LayoutInflater.from(context).inflate(getLayoutId(), this));
            Context context2 = getContext();
            this.f = new WindowManager.LayoutParams();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 > 21 && com.frame.w0.d()) {
                this.f.type = 2032;
                context2 = BoxService.m();
            } else if (i3 >= 26) {
                this.f.type = 2038;
            } else {
                this.f.type = 2006;
            }
            Point pointB = b();
            WindowManager.LayoutParams layoutParams = this.f;
            layoutParams.x = pointB.x;
            layoutParams.y = pointB.y;
            layoutParams.flags = 8;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = 1;
            layoutParams.gravity = 51;
            WindowManager windowManager = (WindowManager) context2.getSystemService("window");
            this.e = windowManager;
            windowManager.addView(this, this.f);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }
}
