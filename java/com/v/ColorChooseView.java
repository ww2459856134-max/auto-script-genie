package com.v;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yl.model.Node;

/* loaded from: classes.dex */
public class ColorChooseView extends RelativeLayout implements View.OnClickListener {
    private boolean A;
    View C;
    private DialogInterface.OnCancelListener D;
    private int G;
    private boolean H;
    Bitmap I;
    private View c;
    private lt d;
    private TextView e;
    private View.OnClickListener f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f921h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f922i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f923j;

    /* renamed from: k, reason: collision with root package name */
    private int f924k;
    private boolean t;

    public ColorChooseView() {
        super(com.frame.v0.g());
        this.H = true;
        this.I = null;
        setHit("触控屏幕拾取颜色");
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
        this.c = canDragCloseButton;
        canDragCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.v.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.n(view);
            }
        });
    }

    private void a() {
        final int i2 = this.f924k + 1;
        this.f924k = i2;
        this.t = true;
        this.A = false;
        com.frame.l0.c(this.f923j);
        this.f923j = null;
        setAlpha(0.0f);
        postDelayed(new Runnable() { // from class: com.v.c3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.l(i2);
            }
        }, 50L);
    }

    private void d() {
        Bitmap bitmap;
        int i2;
        if (!this.A || this.t || (bitmap = this.f923j) == null || (i2 = this.g) < 0 || this.f921h < 0 || i2 >= bitmap.getWidth() || this.f921h >= this.f923j.getHeight()) {
            return;
        }
        this.G = f(this.f923j, this.g, this.f921h);
        this.A = false;
        View.OnClickListener onClickListener = this.f;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
        setSubViewPosition();
    }

    private Bitmap e(int i2, int i3) {
        int iC = com.frame.p1.c(14.0f);
        Rect rect = new Rect(i2 - iC, i3 - iC, i2 + iC, iC + i3);
        boolean zF = i.b.i9.v().F();
        Bitmap bitmapX = zF ? this.f923j : i.b.i9.v().x();
        Bitmap bitmapCreateBitmap = null;
        if (bitmapX != null) {
            if (rect.intersect(0, 0, bitmapX.getWidth(), bitmapX.getHeight()) && i2 >= 0 && i3 >= 0 && i2 < bitmapX.getWidth() && i3 < bitmapX.getHeight()) {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapX, rect.left, rect.top, rect.width(), rect.height(), (Matrix) null, true);
                this.G = f(bitmapX, i2, i3);
                if (!zF) {
                    com.frame.l0.c(bitmapX);
                }
            } else if (!zF) {
                com.frame.l0.c(bitmapX);
            }
        }
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(int i2, Bitmap bitmap) {
        if (i2 != this.f924k || !isAttachedToWindow()) {
            com.frame.l0.c(bitmap);
            return;
        }
        this.t = false;
        this.f923j = bitmap;
        setAlpha(1.0f);
        if (bitmap == null) {
            FloatToast.i("未取得截图，请重新触控取色");
        }
        invalidate();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(final int i2) {
        final Bitmap bitmapX = i.b.i9.v().x();
        post(new Runnable() { // from class: com.v.e3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.h(i2, bitmapX);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(final int i2) {
        if (i2 == this.f924k && isAttachedToWindow()) {
            com.frame.l1.g(new Runnable() { // from class: com.v.b3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.j(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(View view) {
        com.frame.s0.g().d(ColorChooseView.class);
        DialogInterface.OnCancelListener onCancelListener = this.D;
        if (onCancelListener != null) {
            onCancelListener.onCancel(null);
        }
    }

    public void b(Canvas canvas, Bitmap bitmap, int i2) {
        int iC = com.frame.p1.c(20.0f);
        int width = bitmap.getWidth() * 4;
        int iC2 = com.frame.p1.c(30.0f);
        Rect rect = new Rect(0, 0, width, width);
        int i3 = rect.bottom;
        Rect rect2 = new Rect(0, i3, rect.right, iC2 + i3);
        canvas.save();
        if (this.f921h < rect.height() + rect2.height()) {
            this.H = false;
            canvas.translate(this.g - rect.centerX(), this.f921h + iC + com.frame.p1.c(30.0f));
        } else {
            this.H = true;
            canvas.translate(this.g - rect.centerX(), ((this.f921h - rect2.bottom) - iC) - com.frame.p1.c(30.0f));
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(com.frame.p1.c(1.5f));
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(rect2, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(com.frame.p1.k(10.0f));
        paint.setColor(i2);
        canvas.drawCircle(rect2.left + com.frame.p1.c(12.0f), rect2.centerY(), com.frame.p1.c(6.0f), paint);
        paint.setColor(-1);
        canvas.drawText("色值：" + com.frame.q1.b(i2), rect2.left + com.frame.p1.c(25.0f), rect2.centerY() - com.frame.p1.c(3.0f), paint);
        paint.setColor(-1);
        canvas.drawText("坐标：" + this.g + "," + this.f921h, rect2.left + com.frame.p1.c(25.0f), rect2.centerY() + com.frame.p1.c(10.0f), paint);
        canvas.save();
        float f = (float) 4;
        canvas.scale(f, f);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.restore();
        canvas.restore();
    }

    public void c(Canvas canvas, int i2, int i3) {
        Paint paint = new Paint();
        int iC = com.frame.p1.c(6.0f);
        int iC2 = com.frame.p1.c(1.0f);
        Rect rect = new Rect(i2 - iC, i3 - iC, i2 + iC, i3 + iC);
        paint.setColor(-65536);
        paint.setAlpha(180);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(com.frame.p1.c(1.0f));
        Path path = new Path();
        path.moveTo(rect.left, rect.centerY());
        path.lineTo(rect.centerX() - iC2, rect.centerY());
        path.moveTo(rect.centerX() + iC2, rect.centerY());
        path.lineTo(rect.right - iC2, rect.centerY());
        path.moveTo(rect.centerX(), rect.top);
        path.lineTo(rect.centerX(), rect.centerY() - iC2);
        path.moveTo(rect.centerX(), rect.centerY() + iC2);
        path.lineTo(rect.centerX(), rect.bottom);
        canvas.drawPath(path, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(i2, i3, iC, paint);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i2;
        if (this.G == 0) {
            canvas.drawColor(Color.parseColor("#99000000"));
        }
        int i3 = this.g;
        if (i3 != 0 && (i2 = this.f921h) != 0) {
            try {
                Bitmap bitmapE = e(i3, i2);
                if (bitmapE != null) {
                    b(canvas, bitmapE, this.G);
                    com.frame.l0.c(this.I);
                    this.I = bitmapE;
                } else {
                    Bitmap bitmap = this.I;
                    if (bitmap != null) {
                        b(canvas, bitmap, this.G);
                    }
                }
                c(canvas, this.g, this.f921h);
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        super.dispatchDraw(canvas);
    }

    public int f(Bitmap bitmap, int i2, int i3) {
        int pixel = bitmap.getPixel(i2, i3);
        return Color.argb(Color.alpha(pixel), Color.red(pixel), Color.green(pixel), Color.blue(pixel));
    }

    public Point getPoint() {
        return new Point(this.g, this.f921h);
    }

    public ColorChooseView o(lt ltVar) {
        this.d = ltVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != j.b.e.I0) {
            if (id == j.b.e.A0) {
                com.frame.s0.g().o(this);
                ColorScanDialogView colorScanDialogView = (ColorScanDialogView) com.frame.s0.g().B(ColorScanDialogView.class);
                if (this.f922i) {
                    colorScanDialogView.setMiniModel();
                }
                colorScanDialogView.setTaskNode(i.b.v8.m().p(), i.b.v8.m().e(this.g, this.f921h, this.G));
                colorScanDialogView.setColor1(new Point(this.g, this.f921h), this.G);
                colorScanDialogView.setNodeCallback(this.d);
                colorScanDialogView.setOnCancelListener(this.D);
                return;
            }
            return;
        }
        com.frame.s0.g().o(this);
        if (!com.frame.s0.g().b(ColorScanDialogView.class)) {
            Node nodeE = i.b.v8.m().e(this.g, this.f921h, this.G);
            lt ltVar = this.d;
            if (ltVar != null) {
                ltVar.a(nodeE);
                return;
            }
            return;
        }
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        ColorScanDialogView colorScanDialogView2 = (ColorScanDialogView) com.frame.s0.g().u(ColorScanDialogView.class);
        colorScanDialogView2.setCurEditColor(new Point(this.g, this.f921h), this.G);
        if (this.f922i) {
            colorScanDialogView2.setMiniModel();
        }
        colorScanDialogView2.setNodeCallback(this.d);
        colorScanDialogView2.setOnCancelListener(this.D);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f924k++;
        this.t = false;
        com.frame.l0.c(this.f923j);
        this.f923j = null;
        com.frame.l0.c(this.I);
        this.I = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        this.g = rawX;
        this.f921h = rawY;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            i.b.i9.v().g0();
            this.c.setVisibility(8);
            View view = this.C;
            if (view != null) {
                view.setVisibility(8);
            }
            removeAllViews();
            if (i.b.i9.v().F()) {
                a();
            }
            postInvalidate();
        } else if (action == 1) {
            i.b.i9.v().h0();
            postInvalidate();
            if (i.b.i9.v().F()) {
                this.A = true;
                d();
            } else {
                View.OnClickListener onClickListener = this.f;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                setSubViewPosition();
            }
        } else if (action == 2) {
            postInvalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setHit(String str) {
        TextView textView = new TextView(com.frame.v0.g());
        this.e = textView;
        textView.setTextColor(-1);
        this.e.setText(str);
        this.e.setTextSize(20.0f);
        this.e.setGravity(17);
        addView(this.e, -1, -1);
    }

    public void setMiniModel(boolean z) {
        this.f922i = z;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.D = onCancelListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void setSubViewPosition() {
        removeAllViews();
        this.C = View.inflate(com.frame.v0.g(), j.b.f.u0, null);
        addView(this.C, new RelativeLayout.LayoutParams(-2, -2));
        this.C.setX(this.g - com.frame.p1.c(60.0f));
        if (this.H) {
            this.C.setY(this.f921h - com.frame.p1.c(48.0f));
        } else {
            this.C.setY(this.f921h + com.frame.p1.c(10.0f));
        }
        this.C.findViewById(j.b.e.I0).setOnClickListener(this);
        if (com.frame.s0.g().b(ColorScanDialogView.class)) {
            this.C.findViewById(j.b.e.A0).setVisibility(8);
        } else {
            this.C.findViewById(j.b.e.A0).setOnClickListener(this);
        }
    }
}
