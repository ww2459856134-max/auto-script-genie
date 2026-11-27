package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private int J;
    private int K;
    private int M;
    private int O;
    private int P;
    private int Q;
    private final Paint U;
    private final Rect V;
    private int W;
    private boolean a0;
    private boolean b0;
    private int c0;
    private boolean d0;
    private float e0;
    private float f0;
    private int g0;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            PagerTabStrip.this.c.setCurrentItem(r2.getCurrentItem() - 1);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            ViewPager viewPager = PagerTabStrip.this.c;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void c(int i2, float f, boolean z) {
        Rect rect = this.V;
        int height = getHeight();
        int left = this.e.getLeft() - this.Q;
        int right = this.e.getRight() + this.Q;
        int i3 = height - this.K;
        rect.set(left, i3, right, height);
        super.c(i2, f, z);
        this.W = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.e.getLeft() - this.Q, i3, this.e.getRight() + this.Q, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.a0;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.P);
    }

    public int getTabIndicatorColor() {
        return this.J;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.e.getLeft() - this.Q;
        int right = this.e.getRight() + this.Q;
        int i2 = height - this.K;
        this.U.setColor((this.W << 24) | (this.J & 16777215));
        float f = height;
        canvas.drawRect(left, i2, right, f, this.U);
        if (this.a0) {
            this.U.setColor((-16777216) | (this.J & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.c0, getWidth() - getPaddingRight(), f, this.U);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction();
        if (action != 0 && this.d0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.e0 = x;
            this.f0 = y;
            this.d0 = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.e0) > this.g0 || Math.abs(y - this.f0) > this.g0)) {
                this.d0 = true;
            }
        } else if (x < this.e.getLeft() - this.Q) {
            ViewPager viewPager = this.c;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x > this.e.getRight() + this.Q) {
            ViewPager viewPager2 = this.c;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        if (this.b0) {
            return;
        }
        this.a0 = (i2 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b0) {
            return;
        }
        this.a0 = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        if (this.b0) {
            return;
        }
        this.a0 = i2 == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.a0 = z;
        this.b0 = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.M;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(int i2) {
        this.J = i2;
        this.U.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i2) {
        setTabIndicatorColor(androidx.core.content.a.c(getContext(), i2));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i2) {
        int i3 = this.O;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.U = paint;
        this.V = new Rect();
        this.W = 255;
        this.a0 = false;
        this.b0 = false;
        int i2 = this.G;
        this.J = i2;
        paint.setColor(i2);
        float f = context.getResources().getDisplayMetrics().density;
        this.K = (int) ((3.0f * f) + 0.5f);
        this.M = (int) ((6.0f * f) + 0.5f);
        this.O = (int) (64.0f * f);
        this.Q = (int) ((16.0f * f) + 0.5f);
        this.c0 = (int) ((1.0f * f) + 0.5f);
        this.P = (int) ((f * 32.0f) + 0.5f);
        this.g0 = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.d.setFocusable(true);
        this.d.setOnClickListener(new a());
        this.f.setFocusable(true);
        this.f.setOnClickListener(new b());
        if (getBackground() == null) {
            this.a0 = true;
        }
    }
}
