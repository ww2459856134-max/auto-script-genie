package com.v;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class RectOfferSetChooseView extends FrameLayout {
    protected Rect c;
    private TextView d;
    private View.OnClickListener e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f1041h;

    /* renamed from: i, reason: collision with root package name */
    private int f1042i;

    /* renamed from: j, reason: collision with root package name */
    private int f1043j;

    /* renamed from: k, reason: collision with root package name */
    private int f1044k;
    private DialogInterface.OnCancelListener t;

    public RectOfferSetChooseView() {
        super(com.frame.v0.g());
        this.f1042i = com.frame.p1.c(7.0f);
        TextView textView = new TextView(com.frame.v0.g());
        this.d = textView;
        textView.setTextColor(-1);
        this.d.setText("点击偏移点");
        this.d.setTextSize(20.0f);
        this.d.setGravity(17);
        addView(this.d, -1, -1);
        TextView textView2 = new TextView(com.frame.v0.g());
        this.f1041h = textView2;
        textView2.setTextColor(-1);
        textView2.setText("确定");
        textView2.setTextSize(13.0f);
        textView2.setBackgroundResource(j.b.d.f1742i);
        textView2.setPadding(com.frame.p1.c(12.0f), com.frame.p1.c(5.0f), com.frame.p1.c(12.0f), com.frame.p1.c(5.0f));
        addView(textView2, -2, -2);
        this.f1041h.setOnClickListener(new View.OnClickListener() { // from class: com.v.gk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.b(view);
            }
        });
        this.f1041h.setVisibility(8);
        CanDragCloseButton canDragCloseButton = new CanDragCloseButton(com.frame.v0.g());
        canDragCloseButton.setText("关闭选择");
        int iC = com.frame.p1.c(10.0f);
        int i2 = iC / 2;
        canDragCloseButton.setPadding(iC, i2, iC, i2);
        canDragCloseButton.setTextColor(-1);
        canDragCloseButton.setCompoundDrawablePadding(i2);
        canDragCloseButton.setTextSize(13.0f);
        canDragCloseButton.setBackgroundResource(j.b.d.f1741h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        canDragCloseButton.setCompoundDrawablesWithIntrinsicBounds(j.b.d.A0, 0, 0, 0);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.frame.p1.c(2.0f);
        layoutParams.rightMargin = com.frame.p1.c(8.0f);
        canDragCloseButton.setLayoutParams(layoutParams);
        addView(canDragCloseButton);
        canDragCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.v.hk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.d(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(View view) {
        View.OnClickListener onClickListener = this.e;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        com.frame.s0.g().d(RectOfferSetChooseView.class);
        DialogInterface.OnCancelListener onCancelListener = this.t;
        if (onCancelListener != null) {
            onCancelListener.onCancel(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i2;
        canvas.drawColor(Color.parseColor("#bb000000"));
        if (this.c != null) {
            Paint paint = new Paint();
            paint.setTextSize(com.frame.p1.k(8.0f));
            paint.setColor(-256);
            Paint paint2 = new Paint();
            paint2.setColor(-65536);
            paint2.setAlpha(180);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setStrokeWidth(com.frame.p1.c(2.0f));
            Paint paint3 = new Paint();
            paint3.setColor(-16711936);
            paint3.setAlpha(100);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(com.frame.p1.c(2.0f));
            Paint paint4 = new Paint();
            paint4.setAlpha(0);
            paint4.setDither(true);
            paint4.setAlpha(100);
            paint4.setStyle(Paint.Style.FILL);
            paint4.setStrokeJoin(Paint.Join.ROUND);
            paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            Rect rect = this.c;
            canvas.drawRoundRect(rect.left, rect.top, rect.right, rect.bottom, com.frame.p1.c(2.0f), com.frame.p1.c(2.0f), paint4);
            Rect rect2 = this.c;
            int iWidth = rect2.left + (rect2.width() / 2);
            Rect rect3 = this.c;
            int iHeight = rect3.top + (rect3.height() / 2);
            float f = iWidth;
            float f2 = iHeight;
            canvas.drawCircle(f, f2, this.f1042i, paint2);
            canvas.drawRect(this.c, paint3);
            int i3 = this.f;
            if (i3 != 0 && (i2 = this.g) != 0) {
                canvas.drawLine(f, f2, i3, i2, paint2);
                canvas.drawCircle(this.f, this.g, this.f1042i, paint2);
                this.f1043j = this.f - iWidth;
                this.f1044k = this.g - iHeight;
                String str = this.f1043j + "," + (this.g - iHeight);
                int i4 = this.f;
                int i5 = this.f1042i;
                canvas.drawText(str, i4 - i5, this.g + (i5 * 2), paint);
            }
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void f() {
        this.f1041h.setX((this.f1042i - (r0.getWidth() / 2)) + this.f);
        int i2 = this.g + (this.f1042i * 3);
        if (this.f1041h.getHeight() + i2 > com.frame.k0.c().d() / 1.5d) {
            this.f1041h.setY(this.g - (this.f1042i * 5));
        } else {
            this.f1041h.setY(i2);
        }
    }

    public Point getOfferSet() {
        Point point = new Point();
        point.x = this.f1043j;
        point.y = this.f1044k;
        return point;
    }

    public Rect getRect() {
        return this.c;
    }

    public RectOfferSetChooseView h(String str, View.OnClickListener onClickListener) {
        TextView textView = this.f1041h;
        if (str == null) {
            textView.setVisibility(8);
            textView.setOnClickListener(null);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
            textView.setOnClickListener(onClickListener);
        }
        return this;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (getChildCount() > 1) {
                removeView(this.d);
            }
            this.f1041h.setVisibility(8);
            this.f = x;
            this.g = y;
            postInvalidate();
        } else if (action == 1) {
            this.f1041h.setVisibility(0);
            e();
        } else if (action == 2) {
            this.f = x;
            this.g = y;
            postInvalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.t = onCancelListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void setRect(Rect rect, Point point) {
        this.c = rect;
        if (rect == null) {
            int iE = com.frame.k0.c().e() / 2;
            int iD = com.frame.k0.c().d() / 2;
            int iC = com.frame.p1.c(10.0f);
            Rect rect2 = new Rect(iE - iC, iD - iC, iE + iC, iD + iC);
            this.c = rect2;
            rect = rect2;
        }
        if (point != null) {
            this.f1043j = point.x;
            this.f1044k = point.y;
            int iWidth = rect.left + (rect.width() / 2);
            int iHeight = rect.top + (rect.height() / 2);
            this.f = this.f1043j + iWidth;
            this.g = this.f1044k + iHeight;
            this.f1041h.setVisibility(0);
            this.f1041h.post(new Runnable() { // from class: com.v.fk
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.f();
                }
            });
        }
    }
}
