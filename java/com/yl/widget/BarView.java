package com.yl.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.frame.k0;
import com.frame.p1;
import com.frame.v0;
import com.yl.ui.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BarView extends View {
    private int A;
    private boolean C;
    private int D;
    private int c;
    private int d;
    private Paint e;
    private Paint f;
    private Paint g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f1162h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f1163i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<a> f1164j;

    /* renamed from: k, reason: collision with root package name */
    private int f1165k;
    private boolean t;

    public static class a {
        public long a;
        public long b;

        abstract boolean a(int i2, BarView barView, Rect rect);

        public abstract int b(Rect rect);

        public abstract float c(BarView barView);

        abstract void d(Canvas canvas, BarView barView, Rect rect, boolean z);

        abstract void e(Canvas canvas, BarView barView, Rect rect);

        abstract void f(Canvas canvas, BarView barView, Rect rect);
    }

    public BarView(Context context) {
        this(context, null);
    }

    void a() {
        ArrayList<a> arrayList = this.f1164j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (this.t) {
            this.f1165k = (int) ((((this.c - getPaddingLeft()) - getPaddingRight()) / this.f1164j.size()) / 1.7f);
        }
        int paddingLeft = (((this.c - getPaddingLeft()) - getPaddingRight()) - (this.f1165k * (this.f1164j.size() - 1))) / this.f1164j.size();
        getPaddingTop();
        getPaddingBottom();
        long jMax = 0;
        long jMax2 = 0;
        for (int i2 = 0; i2 < this.f1164j.size(); i2++) {
            jMax = Math.max(jMax, this.f1164j.get(i2).a);
            jMax2 = Math.max(jMax2, this.f1164j.get(i2).b);
        }
        int i3 = (jMax > 0L ? 1 : (jMax == 0L ? 0 : -1));
        int i4 = (jMax2 > 0L ? 1 : (jMax2 == 0L ? 0 : -1));
    }

    public List<a> getData() {
        return this.f1164j;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<a> arrayList = this.f1164j;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a();
        Rect rect = new Rect();
        canvas.translate(getPaddingLeft(), (-getPaddingBottom()) - (this.A * 1.5f));
        Path path = new Path();
        a aVar = null;
        Rect rect2 = null;
        for (int i2 = 0; i2 < this.f1164j.size(); i2++) {
            a aVar2 = this.f1164j.get(i2);
            aVar2.d(canvas, this, rect, false);
            aVar2.e(canvas, this, rect);
            float fB = aVar2.b(rect);
            float fC = aVar2.c(this);
            if (i2 == 0) {
                path.moveTo(fB, fC);
            } else {
                path.lineTo(fB, fC);
            }
            this.f1163i.setColor(-1);
            canvas.drawCircle(fB, fC, p1.c(3.0f), this.f1163i);
            this.f1163i.setColor(v0.g().getResources().getColor(y.a));
            canvas.drawCircle(fB, fC, p1.c(2.0f), this.f1163i);
            if (this.C && aVar2.a(this.D - getPaddingLeft(), this, rect)) {
                rect2 = new Rect(rect.left, rect.top, rect.right, rect.bottom);
                aVar = aVar2;
            }
        }
        if (aVar != null && rect2 != null) {
            aVar.d(canvas, this, rect2, true);
            aVar.f(canvas, this, rect2);
        }
        canvas.drawPath(path, this.g);
        canvas.drawLine(0.0f, this.d, (this.c - getPaddingRight()) - getPaddingLeft(), this.d, this.f);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.c = View.MeasureSpec.getSize(i2);
        this.d = View.MeasureSpec.getSize(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.C = false;
                postInvalidate();
            } else if (action != 2) {
                if (action == 3 || action == 4) {
                }
            }
            return true;
        }
        k0.i("data_bar_touch_down");
        if (motionEvent.getY() <= getPaddingTop()) {
            return false;
        }
        this.C = true;
        this.D = (int) motionEvent.getX();
        postInvalidate();
        return true;
    }

    public void setAutoSpace() {
        this.t = true;
    }

    public void setBarBackgroundColor(int i2) {
        this.e.setColor(i2);
    }

    public void setData(ArrayList<a> arrayList) {
        this.f1164j = arrayList;
    }

    public void setLabelColor(int i2) {
        Paint paint = this.f1162h;
        if (paint != null) {
            paint.setColor(i2);
        }
    }

    public void setSpace(int i2) {
        this.f1165k = i2;
    }

    public BarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = p1.c(8.0f);
        p1.c(13.0f);
    }
}
