package com.v;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class RectChooseView extends RelativeLayout implements View.OnClickListener {
    private LinearLayout A;
    private View C;
    private CanDragCloseButton D;
    private CanDragCloseButton G;
    private RectChooseMiniTouch H;
    private int I;
    private int J;
    private long K;
    private int M;
    private int O;
    private Paint P;
    private Paint Q;
    private DialogInterface.OnCancelListener U;
    private a V;
    protected Rect c;
    private TextView d;
    private View.OnClickListener e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1037h;

    /* renamed from: i, reason: collision with root package name */
    private int f1038i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f1039j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f1040k;
    private boolean t;

    public interface a {
        void a(Rect rect);
    }

    public RectChooseView() {
        super(com.frame.v0.g());
        this.O = -1;
        com.frame.p1.c(2.0f);
        this.M = com.frame.p1.c(15.0f);
        Paint paint = new Paint();
        this.Q = paint;
        paint.setColor(-65536);
        this.Q.setAlpha(180);
        this.Q.setStyle(Paint.Style.STROKE);
        this.Q.setStrokeWidth(com.frame.p1.c(2.0f));
        Paint paint2 = new Paint();
        this.P = paint2;
        paint2.setAlpha(0);
        this.P.setDither(true);
        this.P.setStyle(Paint.Style.FILL);
        this.P.setStrokeJoin(Paint.Join.ROUND);
        this.P.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        LinearLayout linearLayout = (LinearLayout) View.inflate(com.frame.v0.g(), j.b.f.u0, null);
        this.A = linearLayout;
        linearLayout.setVisibility(8);
        addView(this.A);
        CanDragCloseButton canDragCloseButton = new CanDragCloseButton(com.frame.v0.g());
        canDragCloseButton.setText("关闭识别");
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
        this.C = canDragCloseButton;
        canDragCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.v.ek
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m(view);
            }
        });
        b();
    }

    private int e(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    private void f() {
        int width = getWidth() > 0 ? getWidth() : com.frame.k0.c().e();
        int height = getHeight() > 0 ? getHeight() : com.frame.k0.c().d();
        this.f = e(this.f, 0, width);
        this.f1037h = e(this.f1037h, 0, width);
        this.g = e(this.g, 0, height);
        this.f1038i = e(this.f1038i, 0, height);
    }

    private void g() {
        this.c = new Rect();
    }

    private void h(Canvas canvas, Rect rect) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#22999999"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, paint);
        float fC = com.frame.p1.c(10.0f);
        int iMax = (int) (Math.max(rect.width(), rect.height()) / fC);
        for (int i2 = 0; i2 < iMax; i2++) {
            if (i2 % 2 == 0) {
                Rect rect2 = new Rect();
                float f = i2 * fC;
                int i3 = (int) (rect.top + f);
                rect2.top = i3;
                int i4 = (int) (i3 + fC);
                rect2.bottom = i4;
                float f2 = i4;
                int i5 = rect.bottom;
                if (f2 < i5 + fC) {
                    if (i4 > i5) {
                        rect2.bottom = i5;
                    }
                    rect2.left = rect.left;
                    rect2.right = rect.right;
                    canvas.drawRect(rect2, this.P);
                }
                Rect rect3 = new Rect();
                int i6 = (int) (rect.left + f);
                rect3.left = i6;
                int i7 = (int) (i6 + fC);
                rect3.right = i7;
                float f3 = i7;
                int i8 = rect.right;
                if (f3 < i8 + fC) {
                    if (i7 > i8) {
                        rect3.right = i8;
                    }
                    rect3.top = rect.top;
                    rect3.bottom = rect.bottom;
                    canvas.drawRect(rect3, this.P);
                }
            }
        }
    }

    private int i(int i2, int i3) {
        Rect rect = this.c;
        if (rect == null) {
            return -1;
        }
        int i4 = rect.left;
        int i5 = this.M;
        if (i2 >= i4 + i5 || i2 <= i4 - i5) {
            int i6 = rect.right;
            if (i2 < i6 + i5 && i2 > i6 - i5) {
                int i7 = rect.top;
                if (i3 < i7 + i5 && i3 > i7 - i5) {
                    return 2;
                }
                int i8 = rect.bottom;
                if (i3 < i8 + i5 && i3 > i8 - i5) {
                    return 3;
                }
            }
        } else {
            int i9 = rect.top;
            if (i3 < i9 + i5 && i3 > i9 - i5) {
                return 1;
            }
            int i10 = rect.bottom;
            if (i3 < i10 + i5 && i3 > i10 - i5) {
                return 4;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        if (!this.D.getText().toString().equals("微调")) {
            this.D.setText("微调");
            this.H.setVisibility(8);
            return;
        }
        this.D.setText("关闭微调");
        RectChooseMiniTouch rectChooseMiniTouch = this.H;
        if (rectChooseMiniTouch == null) {
            setTouchMiniModel();
        } else {
            rectChooseMiniTouch.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view) {
        com.frame.s0.g().d(RectChooseView.class);
        DialogInterface.OnCancelListener onCancelListener = this.U;
        if (onCancelListener != null) {
            onCancelListener.onCancel(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o() {
        this.A.setX(((this.c.width() - this.A.getWidth()) / 2) + this.c.left);
        if (this.c.bottom + this.A.getHeight() <= getHeight()) {
            this.A.setY(this.c.bottom);
        } else if (this.c.top - this.A.getHeight() < 0) {
            this.A.setY(this.c.centerY());
        } else {
            this.A.setY(this.c.top - r0.getHeight());
        }
    }

    public void a(View.OnClickListener onClickListener) {
        int iC = com.frame.p1.c(10.0f);
        CanDragCloseButton canDragCloseButton = new CanDragCloseButton(com.frame.v0.g());
        canDragCloseButton.setText("从文件选取");
        int i2 = iC / 2;
        canDragCloseButton.setPadding(iC, i2, iC, i2);
        canDragCloseButton.setTextColor(-1);
        canDragCloseButton.setCompoundDrawablePadding(i2);
        canDragCloseButton.setTextSize(13.0f);
        canDragCloseButton.setBackgroundResource(j.b.d.f1741h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        canDragCloseButton.setCompoundDrawablesWithIntrinsicBounds(j.b.d.B0, 0, 0, 0);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.frame.p1.c(2.0f);
        layoutParams.rightMargin = com.frame.p1.c(175.0f);
        canDragCloseButton.setLayoutParams(layoutParams);
        addView(canDragCloseButton);
        this.G = canDragCloseButton;
        canDragCloseButton.setOnClickListener(onClickListener);
    }

    public void b() {
        int iC = com.frame.p1.c(10.0f);
        CanDragCloseButton canDragCloseButton = new CanDragCloseButton(com.frame.v0.g());
        canDragCloseButton.setText("微调");
        int i2 = iC / 2;
        canDragCloseButton.setPadding(iC, i2, iC, i2);
        canDragCloseButton.setTextColor(-1);
        canDragCloseButton.setCompoundDrawablePadding(i2);
        canDragCloseButton.setTextSize(13.0f);
        canDragCloseButton.setBackgroundResource(j.b.d.f1741h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        canDragCloseButton.setCompoundDrawablesWithIntrinsicBounds(j.b.d.C0, 0, 0, 0);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.frame.p1.c(2.0f);
        layoutParams.rightMargin = com.frame.p1.c(108.0f);
        canDragCloseButton.setLayoutParams(layoutParams);
        addView(canDragCloseButton);
        this.D = canDragCloseButton;
        canDragCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.v.dk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.k(view);
            }
        });
    }

    public void c() {
        int i2 = this.f1037h;
        int i3 = this.f;
        if (i2 < i3) {
            this.f1037h = i3;
            this.f = i2;
        }
        int i4 = this.f1038i;
        int i5 = this.g;
        if (i4 < i5) {
            this.f1038i = i5;
            this.g = i4;
        }
    }

    public void d() {
        com.frame.p1.m(this.C);
        com.frame.p1.m(this.D);
        com.frame.p1.m(this.G);
        this.C.getDrawingRect(new Rect());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        if (this.c.top > com.frame.p1.c(20.0f)) {
            layoutParams.removeRule(12);
            layoutParams.addRule(10);
            this.C.setLayoutParams(layoutParams);
            CanDragCloseButton canDragCloseButton = this.D;
            if (canDragCloseButton != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) canDragCloseButton.getLayoutParams();
                layoutParams2.removeRule(12);
                layoutParams2.addRule(10);
                layoutParams2.rightMargin = com.frame.p1.c(100.0f);
                this.D.setLayoutParams(layoutParams2);
            }
            CanDragCloseButton canDragCloseButton2 = this.G;
            if (canDragCloseButton2 != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) canDragCloseButton2.getLayoutParams();
                layoutParams3.removeRule(12);
                layoutParams3.addRule(10);
                layoutParams3.rightMargin = com.frame.p1.c(175.0f);
                this.G.setLayoutParams(layoutParams3);
            }
        } else {
            layoutParams.removeRule(10);
            layoutParams.addRule(12);
            this.C.setLayoutParams(layoutParams);
            CanDragCloseButton canDragCloseButton3 = this.D;
            if (canDragCloseButton3 != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) canDragCloseButton3.getLayoutParams();
                layoutParams4.removeRule(10);
                layoutParams4.addRule(12);
                layoutParams4.rightMargin = com.frame.p1.c(100.0f);
                this.D.setLayoutParams(layoutParams4);
            }
            CanDragCloseButton canDragCloseButton4 = this.G;
            if (canDragCloseButton4 != null) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) canDragCloseButton4.getLayoutParams();
                layoutParams5.removeRule(10);
                layoutParams5.addRule(12);
                layoutParams5.rightMargin = com.frame.p1.c(175.0f);
                this.G.setLayoutParams(layoutParams5);
            }
        }
        if (this.H != null) {
            if (this.c.bottom >= com.frame.k0.c().d() - com.frame.p1.c(165.0f)) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
                layoutParams6.removeRule(12);
                layoutParams6.addRule(10);
                this.H.setLayoutParams(layoutParams6);
                return;
            }
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
            layoutParams7.removeRule(10);
            layoutParams7.addRule(12);
            this.H.setLayoutParams(layoutParams7);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#bb000000"));
        Rect rect = this.c;
        if (rect != null) {
            rect.top = this.g;
            rect.left = this.f;
            rect.bottom = this.f1038i;
            rect.right = this.f1037h;
            canvas.drawRect(rect, this.P);
            if (this.Q != null) {
                int iMin = Math.min(this.f, this.f1037h);
                int iMax = Math.max(this.f, this.f1037h);
                int iMin2 = Math.min(this.g, this.f1038i);
                int iMax2 = Math.max(this.g, this.f1038i);
                Path path = new Path();
                int iC = com.frame.p1.c(8.0f);
                int iC2 = com.frame.p1.c(2.0f);
                int i2 = iMin - iC2;
                float f = i2 + iC;
                int i3 = iMin2 - iC2;
                float f2 = i3;
                path.moveTo(f, f2);
                float f3 = i2;
                path.lineTo(f3, f2);
                float f4 = i3 + iC;
                path.lineTo(f3, f4);
                int i4 = iMax2 + iC2;
                float f5 = i4;
                path.moveTo(f, f5);
                path.lineTo(f3, f5);
                float f6 = i4 - iC;
                path.lineTo(f3, f6);
                int i5 = iMax + iC2;
                float f7 = i5 - iC;
                path.moveTo(f7, f5);
                float f8 = i5;
                path.lineTo(f8, f5);
                path.lineTo(f8, f6);
                path.moveTo(f7, f2);
                path.lineTo(f8, f2);
                path.lineTo(f8, f4);
                canvas.drawPath(path, this.Q);
            }
        }
        if (this.f1039j != null) {
            Rect rect2 = this.c;
            if (rect2 != null) {
                h(canvas, rect2);
            }
            canvas.drawRect(this.f1039j, this.f1040k);
        }
        super.dispatchDraw(canvas);
    }

    public Rect getRect() {
        return this.c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
        int i2 = j.b.e.I0;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0158  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            s();
            this.K = System.currentTimeMillis();
            int iC = com.frame.p1.c(80.0f);
            int i2 = i(x, y);
            if (i2 != -1) {
                this.O = i2;
                if (i2 == 1) {
                    Rect rect = this.c;
                    this.I = x - rect.left;
                    this.J = y - rect.top;
                } else if (i2 == 2) {
                    Rect rect2 = this.c;
                    this.I = x - rect2.right;
                    this.J = y - rect2.top;
                } else if (i2 == 3) {
                    Rect rect3 = this.c;
                    this.I = x - rect3.right;
                    this.J = y - rect3.bottom;
                } else if (i2 == 4) {
                    Rect rect4 = this.c;
                    this.I = x - rect4.left;
                    this.J = y - rect4.bottom;
                }
            } else {
                Rect rect5 = this.c;
                if (rect5 == null || x >= rect5.right + iC) {
                    this.t = false;
                    this.f = x;
                    this.g = y;
                    this.f1037h = x;
                    this.f1038i = y;
                    g();
                } else {
                    int i3 = rect5.left;
                    if (x > i3 - iC && y < rect5.bottom + iC) {
                        int i4 = rect5.top;
                        if (y > i4 - iC) {
                            this.t = true;
                            this.I = x - i3;
                            this.J = y - i4;
                        }
                    }
                }
            }
        } else if (action == 1) {
            this.O = -1;
            c();
            f();
            Rect rect6 = this.c;
            rect6.top = this.g;
            rect6.left = this.f;
            rect6.bottom = this.f1038i;
            rect6.right = this.f1037h;
            if (rect6.width() == 0 || this.c.height() == 0) {
                d();
                FloatToast.i("请滑动选取需要匹配的图片");
            } else {
                a aVar = this.V;
                if (aVar != null) {
                    aVar.a(this.c);
                }
                if (this.t && System.currentTimeMillis() - this.K < 200 && (onClickListener = this.e) != null) {
                    onClickListener.onClick(this);
                }
                t();
            }
        } else if (action == 2) {
            int i5 = this.O;
            if (i5 != -1) {
                if (i5 == 1) {
                    this.f = x - this.I;
                    this.g = y - this.J;
                } else if (i5 == 2) {
                    this.f1037h = x - this.I;
                    this.g = y - this.J;
                } else if (i5 == 3) {
                    this.f1037h = x - this.I;
                    this.f1038i = y - this.J;
                } else if (i5 == 4) {
                    this.f = x - this.I;
                    this.f1038i = y - this.J;
                }
                postInvalidate();
            } else if (this.t) {
                this.f = x - this.I;
                int i6 = y - this.J;
                this.g = i6;
                this.f1038i = i6 + this.c.height();
                this.f1037h = this.f + this.c.width();
                postInvalidate();
            } else {
                this.f1037h = x;
                this.f1038i = y;
                postInvalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public RectChooseView p(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.A.findViewById(j.b.e.W);
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

    public RectChooseView q(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.A.findViewById(j.b.e.A0);
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

    public RectChooseView r(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.A.findViewById(j.b.e.I0);
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

    public void s() {
        removeView(this.d);
        com.frame.p1.l(this.A);
        com.frame.p1.l(this.C);
        com.frame.p1.l(this.D);
        com.frame.p1.l(this.G);
    }

    public void setCallBack(a aVar) {
        this.V = aVar;
    }

    public void setFrontRect(Rect rect, int i2) {
        this.f1039j = rect;
        Paint paint = new Paint();
        this.f1040k = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1040k.setColor(i2);
        postInvalidate();
    }

    public void setHit(String str) {
        TextView textView = new TextView(com.frame.v0.g());
        this.d = textView;
        if (this.c == null) {
            textView.setTextColor(-1);
            this.d.setText(str);
            this.d.setTextSize(20.0f);
            this.d.setGravity(17);
            addView(this.d, -1, -1);
        }
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.U = onCancelListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void setRect(Rect rect) {
        this.c = rect;
        if (rect != null) {
            this.f = rect.left;
            this.g = rect.top;
            this.f1037h = rect.right;
            this.f1038i = rect.bottom;
            postInvalidate();
        }
    }

    public void setRectXY(int i2, int i3, int i4, int i5) {
        this.g = i3;
        this.f = i2;
        this.f1037h = i4;
        this.f1038i = i5;
    }

    public void setSubViewPosition() {
        int iC;
        int iC2;
        if (this.c == null) {
            return;
        }
        int iWidth = ((this.c.width() - com.frame.p1.c(130.0f)) / 2) + this.c.left;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.c.width() > com.frame.p1.c(100.0f)) {
            this.A.setOrientation(0);
            iC = com.frame.p1.c(40.0f);
        } else {
            iWidth = this.c.left + ((this.c.width() - com.frame.p1.c(70.0f)) / 2);
            this.A.setOrientation(1);
            iC = com.frame.p1.c(80.0f);
        }
        if (this.c.bottom + iC > getHeight()) {
            iC2 = this.c.top - iC;
        } else {
            iC2 = com.frame.p1.c(10.0f) + this.c.bottom;
        }
        this.A.setX(iWidth);
        this.A.setY(iC2);
        this.A.setLayoutParams(layoutParams);
        this.A.setVisibility(0);
        d();
        this.A.post(new Runnable() { // from class: com.v.ck
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o();
            }
        });
    }

    public void setTouchMiniModel() {
        RectChooseMiniTouch rectChooseMiniTouch = new RectChooseMiniTouch();
        this.H = rectChooseMiniTouch;
        rectChooseMiniTouch.setRectChooseView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.H, layoutParams);
    }

    public void t() {
        setSubViewPosition();
    }
}
