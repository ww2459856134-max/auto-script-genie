package com.yl.widget.wheel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.frame.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class WheelView extends ScrollView {
    public static final String M = WheelView.class.getSimpleName();
    int A;
    Runnable C;
    int D;
    int G;
    int[] H;
    Paint I;
    int J;
    private c K;
    private int c;
    private int d;
    private Context e;
    private LinearLayout f;
    List<String> g;

    /* renamed from: h, reason: collision with root package name */
    private Integer f1172h;

    /* renamed from: i, reason: collision with root package name */
    int f1173i;

    /* renamed from: j, reason: collision with root package name */
    int f1174j;

    /* renamed from: k, reason: collision with root package name */
    int f1175k;
    int t;

    class a implements Runnable {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(int i2, int i3) {
            WheelView wheelView = WheelView.this;
            wheelView.smoothScrollTo(0, (wheelView.A - i2) + wheelView.G);
            WheelView wheelView2 = WheelView.this;
            wheelView2.f1175k = i3 + wheelView2.f1173i + 1;
            wheelView2.k();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(int i2, int i3) {
            WheelView wheelView = WheelView.this;
            wheelView.smoothScrollTo(0, wheelView.A - i2);
            WheelView wheelView2 = WheelView.this;
            wheelView2.f1175k = i3 + wheelView2.f1173i;
            wheelView2.k();
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> list;
            WheelView wheelView = WheelView.this;
            if (wheelView.G <= 0 || (list = wheelView.g) == null || list.isEmpty()) {
                return;
            }
            int scrollY = WheelView.this.getScrollY();
            WheelView wheelView2 = WheelView.this;
            int i2 = wheelView2.A;
            if (i2 - scrollY != 0) {
                wheelView2.A = wheelView2.getScrollY();
                WheelView wheelView3 = WheelView.this;
                wheelView3.postDelayed(wheelView3.C, wheelView3.D);
                return;
            }
            int i3 = wheelView2.G;
            final int i4 = i2 % i3;
            final int i5 = i2 / i3;
            if (i4 == 0) {
                wheelView2.f1175k = i5 + wheelView2.f1173i;
                wheelView2.k();
            } else if (i4 > i3 / 2) {
                wheelView2.post(new Runnable() { // from class: com.yl.widget.wheel.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.b(i4, i5);
                    }
                });
            } else {
                wheelView2.post(new Runnable() { // from class: com.yl.widget.wheel.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.d(i4, i5);
                    }
                });
            }
        }
    }

    class b extends Drawable {
        b() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            WheelView wheelView = WheelView.this;
            float f = (wheelView.J * 1) / 6;
            float f2 = wheelView.j()[0];
            WheelView wheelView2 = WheelView.this;
            canvas.drawLine(f, f2, (wheelView2.J * 5) / 6, wheelView2.j()[0], WheelView.this.I);
            WheelView wheelView3 = WheelView.this;
            float f3 = (wheelView3.J * 1) / 6;
            float f4 = wheelView3.j()[1];
            WheelView wheelView4 = WheelView.this;
            canvas.drawLine(f3, f4, (wheelView4.J * 5) / 6, wheelView4.j()[1], WheelView.this.I);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public interface c {
        void a(int i2, String str);
    }

    public WheelView(Context context) {
        super(context);
        this.c = Color.parseColor("#B5B5B5");
        this.d = Color.parseColor("#55CA9B");
        this.f1173i = 1;
        this.f1175k = 1;
        this.t = 25;
        this.D = 50;
        this.G = 0;
        f(context);
    }

    private TextView c(String str) {
        TextView textView = new TextView(this.e);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, this.t);
        textView.setText(str);
        textView.setGravity(17);
        int iD = d(15.0f);
        textView.setPadding(iD, iD, iD, iD);
        if (this.G == 0) {
            this.G = e(textView);
            Log.d(M, "itemHeight: " + this.G);
            this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, this.G * this.f1174j));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.G * this.f1174j));
        }
        return textView;
    }

    private int d(float f) {
        return (int) ((f * (v0.g() == null ? getResources().getDisplayMetrics().density : v0.g().getResources().getDisplayMetrics().density)) + 0.5f);
    }

    private int e(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }

    private void f(Context context) {
        this.e = context;
        Log.d(M, "parent: " + getParent());
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f);
        this.C = new a();
    }

    private void g() {
        this.f1174j = (this.f1173i * 2) + 1;
        this.G = 0;
        List<String> list = this.g;
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f.addView(c(it.next()));
        }
        this.f1175k = Math.max(0, Math.min(this.f1175k, Math.max(0, this.g.size() - 1)));
        l(0);
        if (this.K == null || this.g.isEmpty()) {
            return;
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i2) {
        smoothScrollTo(0, i2 * this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] j() {
        if (this.H == null) {
            this.H = new int[]{i * i, i * (i + 1)};
            int i2 = this.G;
            int i3 = this.f1173i;
        }
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        List<String> list;
        if (this.K == null || (list = this.g) == null || list.isEmpty()) {
            return;
        }
        int iMax = this.f1175k;
        if (iMax < 0 || iMax >= this.g.size()) {
            iMax = Math.max(0, Math.min(iMax, this.g.size() - 1));
        }
        this.f1175k = iMax;
        this.K.a(iMax, this.g.get(iMax));
    }

    private void l(int i2) {
        LinearLayout linearLayout;
        int i3 = this.G;
        if (i3 <= 0 || (linearLayout = this.f) == null) {
            return;
        }
        int i4 = this.f1173i;
        int i5 = (i2 / i3) + i4;
        int i6 = i2 % i3;
        int i7 = i2 / i3;
        if (i6 == 0) {
            i5 = i7 + i4;
        } else if (i6 > i3 / 2) {
            i5 = i7 + i4 + 1;
        }
        int childCount = linearLayout.getChildCount();
        if (childCount <= 0) {
            return;
        }
        if (i5 < 0) {
            i5 = 0;
        } else if (i5 >= childCount) {
            i5 = childCount - 1;
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            TextView textView = (TextView) this.f.getChildAt(i8);
            if (textView == null) {
                return;
            }
            if (i5 == i8) {
                textView.setTextColor(this.d);
            } else {
                textView.setTextColor(this.c);
            }
        }
    }

    @Override // android.widget.ScrollView
    public void fling(int i2) {
        super.fling(i2 / 3);
    }

    public List<String> getItems() {
        return this.g;
    }

    public int getOffset() {
        return this.f1173i;
    }

    public c getOnWheelViewListener() {
        return this.K;
    }

    public int getSeletedIndex() {
        return this.f1175k - this.f1173i;
    }

    public String getSeletedItem() {
        List<String> list = this.g;
        if (list == null || list.isEmpty()) {
            return "";
        }
        return this.g.get(Math.max(0, Math.min(this.f1175k, this.g.size() - 1)));
    }

    public int getTextSize() {
        return this.t;
    }

    public void m() {
        List<String> list;
        if (this.G <= 0 || (list = this.g) == null || list.isEmpty()) {
            return;
        }
        this.A = getScrollY();
        postDelayed(this.C, this.D);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        l(i3);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Log.d(M, "w: " + i2 + ", h: " + i3 + ", oldw: " + i4 + ", oldh: " + i5);
        this.J = i2;
        setBackgroundDrawable(null);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.J == 0) {
            this.J = ((Activity) this.e).getWindowManager().getDefaultDisplay().getWidth();
            Log.d(M, "viewWidth: " + this.J);
        }
        if (this.I == null) {
            Paint paint = new Paint();
            this.I = paint;
            paint.setColor(Color.parseColor("#979797"));
            this.I.setStrokeWidth(1.0f);
        }
        super.setBackgroundDrawable(new b());
    }

    public void setDefaultColor(int i2) {
        this.c = i2;
    }

    public void setItems(List<String> list) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.clear();
        if (list != null) {
            this.g.addAll(list);
        }
        for (int i2 = 0; i2 < this.f1173i; i2++) {
            this.g.add(0, "");
            this.g.add("");
        }
        this.f.removeAllViews();
        g();
        Integer num = this.f1172h;
        if (num != null) {
            setSeletion(num.intValue());
            this.f1172h = null;
        }
    }

    public void setOffset(int i2) {
        this.f1173i = i2;
    }

    public void setOnWheelViewListener(c cVar) {
        this.K = cVar;
    }

    public void setSelectedColor(int i2) {
        this.d = i2;
    }

    public void setSeletion(int i2) {
        List<String> list = this.g;
        if (list == null || list.isEmpty() || this.G <= 0) {
            this.f1172h = Integer.valueOf(i2);
            return;
        }
        final int iMax = Math.max(0, Math.min(i2, Math.max(0, this.g.size() - (this.f1173i * 2)) - 1));
        this.f1175k = this.f1173i + iMax;
        post(new Runnable() { // from class: com.yl.widget.wheel.c
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i(iMax);
            }
        });
    }

    public void setTextSize(int i2) {
        this.t = i2;
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = Color.parseColor("#B5B5B5");
        this.d = Color.parseColor("#55CA9B");
        this.f1173i = 1;
        this.f1175k = 1;
        this.t = 25;
        this.D = 50;
        this.G = 0;
        f(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = Color.parseColor("#B5B5B5");
        this.d = Color.parseColor("#55CA9B");
        this.f1173i = 1;
        this.f1175k = 1;
        this.t = 25;
        this.D = 50;
        this.G = 0;
        f(context);
    }
}
