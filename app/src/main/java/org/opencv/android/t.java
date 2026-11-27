package org.opencv.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import java.text.DecimalFormat;
import org.opencv.core.Core;

/* loaded from: classes2.dex */
public class t {

    /* renamed from: i, reason: collision with root package name */
    private static final DecimalFormat f2585i = new DecimalFormat("0.00");
    private int a;
    private double b;
    private long c;
    private String d;
    Paint e;
    boolean f = false;
    int g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f2586h = 0;

    public void a(Canvas canvas, float f, float f2) {
        Log.d("FpsMeter", this.d);
        canvas.drawText(this.d, f, f2, this.e);
    }

    public void b() {
        this.a = 0;
        this.b = Core.d();
        this.c = Core.c();
        this.d = "";
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(-16776961);
        this.e.setTextSize(20.0f);
    }

    public void c() {
        if (!this.f) {
            b();
            this.f = true;
            return;
        }
        int i2 = this.a + 1;
        this.a = i2;
        if (i2 % 20 == 0) {
            long jC = Core.c();
            double d = (this.b * 20.0d) / (jC - this.c);
            this.c = jC;
            if (this.g == 0 || this.f2586h == 0) {
                this.d = f2585i.format(d) + " FPS";
            } else {
                this.d = f2585i.format(d) + " FPS@" + Integer.valueOf(this.g) + "x" + Integer.valueOf(this.f2586h);
            }
            Log.i("FpsMeter", this.d);
        }
    }

    public void d(int i2, int i3) {
        this.g = i2;
        this.f2586h = i3;
    }
}
