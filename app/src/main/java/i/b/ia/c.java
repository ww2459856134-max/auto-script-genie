package i.b.ia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.frame.p1;

/* loaded from: classes.dex */
public class c extends RectF {
    private static Paint A;
    private static Paint C;
    private static PathEffect D;

    /* renamed from: k, reason: collision with root package name */
    public static int f1509k;
    private static Paint t;
    public int c;
    public b d;
    public b e;
    private int f = Color.parseColor("#99AAB7C4");
    private int g = p1.c(10.0f);

    /* renamed from: h, reason: collision with root package name */
    public int f1510h;

    /* renamed from: i, reason: collision with root package name */
    public String f1511i;

    /* renamed from: j, reason: collision with root package name */
    private int f1512j;

    public c(b bVar, b bVar2) {
        if (A == null) {
            Paint paint = new Paint();
            A = paint;
            paint.setColor(Color.parseColor("#99AAB7C4"));
            A.setTextAlign(Paint.Align.CENTER);
            A.setAntiAlias(true);
            A.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            t = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            t.setColor(Color.parseColor("#99AAB7C4"));
            t.setStrokeWidth(p1.c(2.0f));
            Paint paint3 = new Paint();
            C = paint3;
            paint3.setStyle(Paint.Style.FILL);
            C.setColor(Color.parseColor("#99AAB7C4"));
            C.setStrokeWidth(p1.c(2.0f));
            D = new CornerPathEffect(p1.c(10.0f));
        }
        this.d = bVar;
        this.e = bVar2;
        if (bVar2 == null) {
            return;
        }
        float f = ((RectF) bVar).left;
        float f2 = ((RectF) bVar2).left;
        if (f == f2 && ((RectF) bVar2).top < ((RectF) bVar).top) {
            int i2 = f1509k + 1;
            f1509k = i2;
            if (i2 % 2 == 0) {
                if (bVar.g) {
                    this.f1512j = 10;
                    bVar.f1506h = true;
                    bVar2.f1506h = true;
                    return;
                } else {
                    this.f1512j = 9;
                    bVar.g = true;
                    bVar2.g = true;
                    return;
                }
            }
            if (bVar.f1506h) {
                this.f1512j = 9;
                bVar.g = true;
                bVar2.g = true;
                return;
            } else {
                this.f1512j = 10;
                bVar.f1506h = true;
                bVar2.f1506h = true;
                return;
            }
        }
        if (f == f2 && ((RectF) bVar2).top > ((RectF) bVar).top) {
            if (!bVar.f1508j) {
                this.f1512j = 11;
                bVar.f1508j = true;
                bVar2.f1507i = true;
                return;
            } else if (bVar.g) {
                this.f1512j = 7;
                bVar.f1506h = true;
                bVar2.f1506h = true;
                return;
            } else {
                this.f1512j = 8;
                bVar.g = true;
                bVar2.g = true;
                return;
            }
        }
        if (f > f2 && ((RectF) bVar2).top == ((RectF) bVar).top) {
            this.f1512j = 6;
            bVar.g = true;
            bVar2.f1506h = true;
            return;
        }
        if (f < f2 && ((RectF) bVar2).top == ((RectF) bVar).top) {
            this.f1512j = 5;
            bVar.f1506h = true;
            bVar2.g = true;
            return;
        }
        if (f > f2 && ((RectF) bVar2).top < ((RectF) bVar).top) {
            this.f1512j = 3;
            bVar.g = true;
            bVar2.f1506h = true;
            return;
        }
        if (f > f2 && ((RectF) bVar2).top > ((RectF) bVar).top) {
            this.f1512j = 4;
            bVar.g = true;
            bVar2.f1506h = true;
        } else if (f < f2 && ((RectF) bVar2).top > ((RectF) bVar).top) {
            this.f1512j = 2;
            bVar.f1506h = true;
            bVar2.g = true;
        } else {
            if (f >= f2 || ((RectF) bVar2).top >= ((RectF) bVar).top) {
                return;
            }
            this.f1512j = 1;
            bVar.f1506h = true;
            bVar2.g = true;
        }
    }

    public void a(Canvas canvas) {
        m(canvas, false);
    }

    public void b(Canvas canvas) {
        m(canvas, true);
    }

    public void c(Canvas canvas) {
        float f = ((RectF) this.e).right;
        float f2 = f + ((((RectF) this.d).left - f) / 2.0f);
        Path path = new Path();
        b bVar = this.d;
        path.moveTo(((RectF) bVar).left, bVar.centerY());
        path.lineTo(f2, this.d.centerY());
        path.lineTo(f2, this.e.centerY());
        b bVar2 = this.e;
        path.lineTo(((RectF) bVar2).right + this.g, bVar2.centerY());
        canvas.drawPath(path, t);
        b bVar3 = this.e;
        i(canvas, ((RectF) bVar3).right + this.g, bVar3.centerY(), 1);
        if (this.e.e == null || TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        canvas.drawText(this.f1511i, centerX(), centerY(), A);
    }

    public void d(Canvas canvas) {
        float f = ((RectF) this.d).right;
        float fCenterY = this.e.centerY();
        float f2 = ((RectF) this.e).left - this.g;
        float fCenterY2 = this.d.centerY();
        int iC = p1.c(30.0f);
        ((RectF) this).left = f;
        float f3 = iC;
        ((RectF) this).top = fCenterY - f3;
        ((RectF) this).right = f2;
        ((RectF) this).bottom = f3 + fCenterY2;
        i(canvas, f2, fCenterY2, 2);
        float fMax = Math.max(f, f2) + (this.d.width() / 3.0f);
        canvas.drawLine(f, fCenterY, f2, fCenterY2, t);
        if (TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        A.setColor(this.f);
        A.setTextSize(20.0f);
        Paint.FontMetrics fontMetrics = A.getFontMetrics();
        float f4 = fCenterY - ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
        float f5 = ((RectF) this.d).right;
        canvas.drawText(this.f1511i, f5 + ((fMax - f5) / 2.0f), f4, A);
    }

    public void e(Canvas canvas) {
        float f = ((RectF) this.e).right;
        float f2 = f + ((((RectF) this.d).left - f) / 2.0f);
        Path path = new Path();
        b bVar = this.d;
        path.moveTo(((RectF) bVar).left, bVar.centerY());
        path.lineTo(f2, this.d.centerY());
        path.lineTo(f2, this.e.centerY());
        b bVar2 = this.e;
        path.lineTo(((RectF) bVar2).right + this.g, bVar2.centerY());
        canvas.drawPath(path, t);
        b bVar3 = this.e;
        i(canvas, ((RectF) bVar3).right + this.g, bVar3.centerY(), 1);
        if (this.e.e == null || TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        canvas.drawText(this.f1511i, centerX(), centerY(), A);
    }

    public void f(Canvas canvas) {
        float f = ((RectF) this.e).left;
        float f2 = f + ((((RectF) this.d).right - f) / 2.0f);
        Path path = new Path();
        b bVar = this.d;
        path.moveTo(((RectF) bVar).right, bVar.centerY());
        path.lineTo(f2, this.d.centerY());
        path.lineTo(f2, this.e.centerY());
        b bVar2 = this.e;
        path.lineTo(((RectF) bVar2).left + this.g, bVar2.centerY());
        canvas.drawPath(path, t);
        b bVar3 = this.e;
        i(canvas, ((RectF) bVar3).left + this.g, bVar3.centerY(), 2);
        if (this.e.e == null || TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        canvas.drawText(this.f1511i, centerX(), centerY(), A);
    }

    public void g(Canvas canvas) {
        float f = ((RectF) this.d).left;
        float fCenterY = this.e.centerY();
        float f2 = ((RectF) this.e).right + this.g;
        float fCenterY2 = this.d.centerY();
        int iC = p1.c(30.0f);
        ((RectF) this).left = f;
        float f3 = iC;
        ((RectF) this).top = fCenterY - f3;
        ((RectF) this).right = f2;
        ((RectF) this).bottom = f3 + fCenterY2;
        i(canvas, f2, fCenterY2, 1);
        float fMin = Math.min(f, f2) - (this.d.width() / 3.0f);
        canvas.drawLine(f, fCenterY, f2, fCenterY2, t);
        if (TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        A.setColor(this.f);
        A.setTextSize(20.0f);
        Paint.FontMetrics fontMetrics = A.getFontMetrics();
        float f4 = fCenterY - ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
        float f5 = ((RectF) this.d).left;
        canvas.drawText(this.f1511i, f5 - ((f5 - fMin) / 2.0f), f4, A);
    }

    public void h(Canvas canvas) {
        float f = ((RectF) this.e).left;
        float f2 = f + ((((RectF) this.d).right - f) / 2.0f);
        Path path = new Path();
        b bVar = this.d;
        path.moveTo(((RectF) bVar).right, bVar.centerY());
        path.lineTo(f2, this.d.centerY());
        path.lineTo(f2, this.e.centerY());
        b bVar2 = this.e;
        path.lineTo(((RectF) bVar2).left + this.g, bVar2.centerY());
        canvas.drawPath(path, t);
        b bVar3 = this.e;
        i(canvas, ((RectF) bVar3).left + this.g, bVar3.centerY(), 2);
        if (this.e.e == null || TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        canvas.drawText(this.f1511i, centerX(), centerY(), A);
    }

    public void i(Canvas canvas, float f, float f2, int i2) {
        canvas.save();
        Path path = new Path();
        int i3 = this.g / 2;
        if (i2 == 0) {
            f2 += r1 / 2;
        } else if (i2 == 1) {
            f -= r1 / 2;
        } else if (i2 == 2) {
            f += r1 / 2;
        }
        canvas.translate(f, f2);
        if (i2 == 1) {
            canvas.rotate(90.0f, 0.0f, 0.0f);
        } else if (i2 == 2) {
            canvas.rotate(-90.0f, 0.0f, 0.0f);
        }
        float f3 = -i3;
        path.moveTo(f3, f3);
        float f4 = i3;
        path.lineTo(f4, f3);
        path.lineTo(0.0f, f4);
        path.lineTo(f3, f3);
        canvas.drawPath(path, C);
        canvas.restore();
    }

    public void j(Canvas canvas) {
        float fCenterX = this.d.centerX();
        b bVar = this.d;
        canvas.drawLine(fCenterX, ((RectF) bVar).bottom, bVar.centerX(), ((RectF) this.e).top - this.g, t);
        float fC = p1.c(30.0f);
        ((RectF) this).left = this.d.centerX() - fC;
        b bVar2 = this.d;
        ((RectF) this).top = ((RectF) bVar2).bottom;
        ((RectF) this).right = bVar2.centerX() + fC;
        b bVar3 = this.e;
        ((RectF) this).bottom = ((RectF) bVar3).top;
        i(canvas, bVar3.centerX(), (int) (((RectF) this.e).top - this.g), 0);
        if (this.e.e == null || TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        canvas.drawText(this.f1511i, centerX(), centerY(), A);
    }

    public void k(Canvas canvas) {
        m(canvas, false);
    }

    public void l(Canvas canvas) {
        m(canvas, true);
    }

    public void m(Canvas canvas, boolean z) {
        float f;
        b bVar = this.d;
        float f2 = z ? ((RectF) bVar).right : ((RectF) bVar).left;
        float fCenterY = this.d.centerY();
        b bVar2 = this.e;
        float f3 = z ? ((RectF) bVar2).right + this.g : ((RectF) bVar2).left - this.g;
        float fCenterY2 = this.e.centerY();
        float fWidth = this.d.width() / 3.0f;
        float fMax = z ? Math.max(f2, f3) + fWidth : Math.min(f2, f3) - fWidth;
        Path path = new Path();
        path.moveTo(f2, fCenterY);
        path.lineTo(fMax, fCenterY);
        path.lineTo(fMax, fCenterY2);
        path.lineTo(f3, fCenterY2);
        int iC = p1.c(25.0f);
        if (!z) {
            iC = -iC;
        }
        float f4 = iC + fMax;
        ((RectF) this).left = Math.min(f2, f4);
        ((RectF) this).top = Math.min(fCenterY, fCenterY2);
        ((RectF) this).right = Math.max(f2, f4);
        ((RectF) this).bottom = Math.max(fCenterY, fCenterY2);
        canvas.drawPath(path, t);
        i(canvas, f3, fCenterY2, z ? 1 : 2);
        if (TextUtils.isEmpty(this.f1511i)) {
            return;
        }
        A.setColor(this.f);
        A.setTextSize(20.0f);
        Paint.FontMetrics fontMetrics = A.getFontMetrics();
        float f5 = fCenterY - ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
        if (z) {
            float f6 = ((RectF) this.d).right;
            f = f6 + ((fMax - f6) / 2.0f);
        } else {
            float f7 = ((RectF) this.d).left;
            f = f7 - ((f7 - fMax) / 2.0f);
        }
        canvas.drawText(this.f1511i, f, f5, A);
    }

    public long n() {
        return this.d.c;
    }

    public void o(Canvas canvas) {
        PathEffect composePathEffect;
        int i2 = this.f1510h;
        if (i2 == 1) {
            this.f = Color.parseColor("#99FBA847");
            composePathEffect = D;
        } else if (i2 == 2) {
            this.f = Color.parseColor("#2fAAB7C4");
            composePathEffect = D;
        } else if (i2 != 3) {
            composePathEffect = D;
            this.f = Color.parseColor("#99AAB7C4");
        } else {
            this.f = Color.parseColor("#99FBA847");
            composePathEffect = new ComposePathEffect(new DashPathEffect(new float[]{10.0f, 4.0f}, 0.0f), D);
        }
        t.setPathEffect(composePathEffect);
        C.setColor(this.f);
        t.setColor(this.f);
        A.setColor(this.f);
        A.setTextSize(15.0f);
        switch (this.f1512j) {
            case 1:
                h(canvas);
                break;
            case 2:
                f(canvas);
                break;
            case 3:
                e(canvas);
                break;
            case 4:
                c(canvas);
                break;
            case 5:
                d(canvas);
                break;
            case 6:
                g(canvas);
                break;
            case 7:
                l(canvas);
                break;
            case 8:
                k(canvas);
                break;
            case 9:
                a(canvas);
                break;
            case 10:
                b(canvas);
                break;
            case 11:
                j(canvas);
                break;
        }
    }

    public void p(String str) {
        this.f1511i = str;
    }

    public void q(int i2) {
        this.f1510h = i2;
    }
}
