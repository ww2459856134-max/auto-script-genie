package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes.dex */
class e {
    final RectF a = new RectF();
    final Paint b;
    final Paint c;
    final Paint d;
    float e;
    float f;
    float g;

    /* renamed from: h, reason: collision with root package name */
    float f390h;

    /* renamed from: i, reason: collision with root package name */
    int[] f391i;

    /* renamed from: j, reason: collision with root package name */
    int f392j;

    /* renamed from: k, reason: collision with root package name */
    float f393k;

    /* renamed from: l, reason: collision with root package name */
    float f394l;

    /* renamed from: m, reason: collision with root package name */
    float f395m;

    /* renamed from: n, reason: collision with root package name */
    boolean f396n;

    /* renamed from: o, reason: collision with root package name */
    Path f397o;
    float p;
    float q;
    int r;
    int s;
    int t;
    int u;

    e() {
        Paint paint = new Paint();
        this.b = paint;
        Paint paint2 = new Paint();
        this.c = paint2;
        Paint paint3 = new Paint();
        this.d = paint3;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f390h = 5.0f;
        this.p = 1.0f;
        this.t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    void A() {
        this.f393k = this.e;
        this.f394l = this.f;
        this.f395m = this.g;
    }

    void a(Canvas canvas, Rect rect) {
        RectF rectF = this.a;
        float f = this.q;
        float fMin = (this.f390h / 2.0f) + f;
        if (f <= 0.0f) {
            fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.f390h / 2.0f);
        }
        rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
        float f2 = this.e;
        float f3 = this.g;
        float f4 = (f2 + f3) * 360.0f;
        float f5 = ((this.f + f3) * 360.0f) - f4;
        this.b.setColor(this.u);
        this.b.setAlpha(this.t);
        float f6 = this.f390h / 2.0f;
        rectF.inset(f6, f6);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
        float f7 = -f6;
        rectF.inset(f7, f7);
        canvas.drawArc(rectF, f4, f5, false, this.b);
        b(canvas, f4, f5, rectF);
    }

    void b(Canvas canvas, float f, float f2, RectF rectF) {
        if (this.f396n) {
            Path path = this.f397o;
            if (path == null) {
                Path path2 = new Path();
                this.f397o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f3 = (this.r * this.p) / 2.0f;
            this.f397o.moveTo(0.0f, 0.0f);
            this.f397o.lineTo(this.r * this.p, 0.0f);
            Path path3 = this.f397o;
            float f4 = this.r;
            float f5 = this.p;
            path3.lineTo((f4 * f5) / 2.0f, this.s * f5);
            this.f397o.offset((fMin + rectF.centerX()) - f3, rectF.centerY() + (this.f390h / 2.0f));
            this.f397o.close();
            this.c.setColor(this.u);
            this.c.setAlpha(this.t);
            canvas.save();
            canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
            canvas.drawPath(this.f397o, this.c);
            canvas.restore();
        }
    }

    int c() {
        return this.t;
    }

    float d() {
        return this.f;
    }

    int e() {
        return this.f391i[f()];
    }

    int f() {
        return (this.f392j + 1) % this.f391i.length;
    }

    float g() {
        return this.e;
    }

    int h() {
        return this.f391i[this.f392j];
    }

    float i() {
        return this.f394l;
    }

    float j() {
        return this.f395m;
    }

    float k() {
        return this.f393k;
    }

    void l() {
        t(f());
    }

    void m() {
        this.f393k = 0.0f;
        this.f394l = 0.0f;
        this.f395m = 0.0f;
        y(0.0f);
        v(0.0f);
        w(0.0f);
    }

    void n(int i2) {
        this.t = i2;
    }

    void o(float f, float f2) {
        this.r = (int) f;
        this.s = (int) f2;
    }

    void p(float f) {
        if (f != this.p) {
            this.p = f;
        }
    }

    void q(float f) {
        this.q = f;
    }

    void r(int i2) {
        this.u = i2;
    }

    void s(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    void t(int i2) {
        this.f392j = i2;
        this.u = this.f391i[i2];
    }

    void u(int[] iArr) {
        this.f391i = iArr;
        t(0);
    }

    void v(float f) {
        this.f = f;
    }

    void w(float f) {
        this.g = f;
    }

    void x(boolean z) {
        if (this.f396n != z) {
            this.f396n = z;
        }
    }

    void y(float f) {
        this.e = f;
    }

    void z(float f) {
        this.f390h = f;
        this.b.setStrokeWidth(f);
    }
}
