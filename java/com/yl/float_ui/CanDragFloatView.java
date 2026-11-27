package com.yl.float_ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.frame.q1;
import com.frame.s0;
import com.frame.v0;

/* loaded from: classes.dex */
public abstract class CanDragFloatView extends RelativeLayout {
    private GestureDetector gestureDetector;
    protected boolean isCanDrag;
    protected boolean isDragging;
    private int lastX;
    private int lastY;
    protected View.OnTouchListener mSubTouchListener;
    protected boolean magnet;
    protected View subClickView;
    private int x;
    protected int xx;
    int[] xy;
    private int y;
    protected int yy;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View view = CanDragFloatView.this.subClickView;
            if (view != null) {
                view.performLongClick();
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            CanDragFloatView.this.onScroll((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY());
            CanDragFloatView.this.move(((int) motionEvent2.getRawX()) - CanDragFloatView.this.xy[0], ((int) motionEvent2.getRawY()) - CanDragFloatView.this.xy[1]);
            CanDragFloatView.this.isDragging = true;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View view = CanDragFloatView.this.subClickView;
            if (view != null && Build.VERSION.SDK_INT >= 15) {
                view.callOnClick();
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public CanDragFloatView(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        setMagnet(this.magnet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        this.gestureDetector = new GestureDetector(v0.g(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean f(View view, MotionEvent motionEvent) {
        this.subClickView = view;
        if (motionEvent.getAction() == 0) {
            view.getLocationInWindow(this.xy);
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int[] iArr = this.xy;
            iArr[0] = iArr[0] + x;
            iArr[1] = iArr[1] + y;
        } else if (motionEvent.getAction() == 1) {
            int[] iArr2 = this.xy;
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        return onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h() {
        endMove(false);
    }

    protected void endMove(boolean z) {
        boolean z2;
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            this.xx = layoutParams.x;
            this.yy = layoutParams.y;
        }
        if (this.magnet) {
            post(new Runnable() { // from class: com.yl.float_ui.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.b();
                }
            });
        } else {
            int iK = q1.k();
            int i2 = q1.i();
            boolean z3 = true;
            if (this.xx < 0) {
                this.xx = 0;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.yy < 0) {
                this.yy = 0;
                z2 = true;
            }
            if (this.xx + getWidth() > iK) {
                this.xx = iK - getWidth();
                z2 = true;
            }
            if (this.yy + getHeight() > i2) {
                this.yy = i2 - getHeight();
            } else {
                z3 = z2;
            }
            if (z3) {
                move(this.xx, this.yy);
                saveXY(new Point(this.xx, this.yy));
                if (z) {
                    onOutScreen();
                    return;
                }
                return;
            }
        }
        if (z) {
            saveXY(new Point(this.xx, this.yy));
        }
    }

    public abstract Point loadXY();

    protected void move(float f, float f2) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        s0.g().H(this, (int) f, (int) f2, layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Point pointLoadXY = loadXY();
        this.xx = pointLoadXY.x;
        this.yy = pointLoadXY.y;
        post(new Runnable() { // from class: com.yl.float_ui.c
            @Override // java.lang.Runnable
            public final void run() {
                this.c.h();
            }
        });
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        post(new Runnable() { // from class: com.yl.float_ui.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.onRotationMove();
            }
        });
    }

    public boolean onOutScreen() {
        return false;
    }

    protected void onPress() {
    }

    public void onRotationMove() {
        endMove(false);
    }

    protected void onScroll(int i2, int i3) {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isCanDrag) {
            return super.onTouchEvent(motionEvent);
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.x = (int) motionEvent.getX();
            this.y = (int) motionEvent.getY();
            this.lastX = rawX;
            this.lastY = rawY;
            if (this.subClickView == null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int[] iArr = this.xy;
                iArr[0] = x;
                iArr[1] = y;
            }
        } else if (action == 1) {
            this.isDragging = false;
            endMove(true);
            if (Math.abs(this.lastX - rawX) < 20 && Math.abs(this.lastY - rawY) < 20) {
                onPress();
            }
        } else if (action == 2) {
            this.yy = rawY - this.y;
            this.xx = rawX - this.x;
        } else if (action == 3) {
        }
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector == null) {
            return true;
        }
        boolean zOnTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        int action2 = motionEvent.getAction() & 255;
        if (action2 == 1 || action2 == 3) {
            this.subClickView = null;
        }
        return zOnTouchEvent;
    }

    public abstract void saveXY(Point point);

    public void setMagnet(boolean z) {
        this.magnet = z;
        if (z) {
            int iK = q1.k();
            if (this.xx > (iK - getWidth()) / 2) {
                this.xx = iK - getWidth();
            } else {
                this.xx = 0;
            }
            if (this.yy == 0) {
                this.yy = loadXY().y;
            }
            move(this.xx, this.yy);
        }
    }

    public CanDragFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanDragFloatView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.isCanDrag = true;
        this.magnet = false;
        this.xy = new int[2];
        this.mSubTouchListener = new View.OnTouchListener() { // from class: com.yl.float_ui.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.c.f(view, motionEvent);
            }
        };
        post(new Runnable() { // from class: com.yl.float_ui.e
            @Override // java.lang.Runnable
            public final void run() {
                this.c.d();
            }
        });
    }
}
