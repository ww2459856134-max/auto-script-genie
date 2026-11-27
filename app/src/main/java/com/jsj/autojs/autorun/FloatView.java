package com.jsj.autojs.autorun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import com.frame.l1;
import com.frame.p1;
import com.frame.v0;

/* loaded from: classes.dex */
public class FloatView extends FloatAble {
    private static FloatView t;
    private int e;
    private TextView f;
    private ScrollView g;

    /* renamed from: h, reason: collision with root package name */
    private int f784h;

    /* renamed from: i, reason: collision with root package name */
    private int f785i;

    /* renamed from: j, reason: collision with root package name */
    private int f786j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f787k;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatView.this.f786j == 0 || FloatView.this.f786j <= 0 ? FloatView.this.f784h <= FloatView.this.f785i : FloatView.this.f784h >= FloatView.this.f785i) {
                FloatView floatView = FloatView.this;
                floatView.setProgress(floatView.f785i);
                return;
            }
            FloatView floatView2 = FloatView.this;
            FloatView.c(floatView2, floatView2.f786j > 0 ? 1 : -1);
            FloatView floatView3 = FloatView.this;
            floatView3.setProgress(floatView3.f784h);
            FloatView floatView4 = FloatView.this;
            floatView4.postDelayed(floatView4.f787k, 18L);
        }
    }

    interface b {
    }

    public FloatView(Context context) {
        super(context);
        this.e = -16777216;
        p1.c(4.0f);
        this.f787k = new a();
    }

    static /* synthetic */ int c(FloatView floatView, int i2) {
        int i3 = floatView.f784h + i2;
        floatView.f784h = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str) {
        TextView textView;
        this.f.append(str);
        if (this.g == null || (textView = this.f) == null) {
            return;
        }
        int measuredHeight = textView.getMeasuredHeight() - this.g.getMeasuredHeight();
        if (measuredHeight < 0) {
            measuredHeight = 0;
        }
        this.g.scrollTo(0, measuredHeight);
    }

    public static FloatView getInstance() {
        FloatView floatView = t;
        if (floatView != null) {
            return floatView;
        }
        FloatView floatView2 = new FloatView(v0.g());
        t = floatView2;
        return floatView2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawColor(this.e);
    }

    public int getProgress() {
        WindowManager.LayoutParams layoutParams = this.d;
        if (layoutParams == null) {
            return 65;
        }
        return (int) (layoutParams.alpha * 100.0f);
    }

    public void setClickListen(b bVar) {
    }

    public void setColor(String str) {
        this.e = Color.parseColor(str);
        postInvalidate();
    }

    public void setContent(final String str) {
        l1.e(new Runnable() { // from class: com.jsj.autojs.autorun.a
            @Override // java.lang.Runnable
            public final void run() {
                this.c.g(str);
            }
        });
    }

    public void setProgress(int i2) {
        WindowManager.LayoutParams layoutParams = this.d;
        if (layoutParams == null) {
            return;
        }
        try {
            layoutParams.alpha = i2 / 110.0f;
            this.c.updateViewLayout(this, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setScreenBrightness(float f) {
        WindowManager.LayoutParams layoutParams = this.d;
        if (layoutParams == null) {
            return;
        }
        try {
            layoutParams.buttonBrightness = f;
            layoutParams.screenBrightness = f;
            this.c.updateViewLayout(this, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
