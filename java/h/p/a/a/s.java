package h.p.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Shader;

/* loaded from: classes.dex */
class s {
    private static final Matrix q = new Matrix();
    private final Path a;
    private final Path b;
    private final Matrix c;
    Paint d;
    Paint e;
    private PathMeasure f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    final p f1367h;

    /* renamed from: i, reason: collision with root package name */
    float f1368i;

    /* renamed from: j, reason: collision with root package name */
    float f1369j;

    /* renamed from: k, reason: collision with root package name */
    float f1370k;

    /* renamed from: l, reason: collision with root package name */
    float f1371l;

    /* renamed from: m, reason: collision with root package name */
    int f1372m;

    /* renamed from: n, reason: collision with root package name */
    String f1373n;

    /* renamed from: o, reason: collision with root package name */
    Boolean f1374o;
    final h.d.b<String, Object> p;

    public s() {
        this.c = new Matrix();
        this.f1368i = 0.0f;
        this.f1369j = 0.0f;
        this.f1370k = 0.0f;
        this.f1371l = 0.0f;
        this.f1372m = 255;
        this.f1373n = null;
        this.f1374o = null;
        this.p = new h.d.b<>();
        this.f1367h = new p();
        this.a = new Path();
        this.b = new Path();
    }

    private static float a(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    private void c(p pVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
        pVar.a.set(matrix);
        pVar.a.preConcat(pVar.f1363j);
        canvas.save();
        for (int i4 = 0; i4 < pVar.b.size(); i4++) {
            q qVar = pVar.b.get(i4);
            if (qVar instanceof p) {
                c((p) qVar, pVar.a, canvas, i2, i3, colorFilter);
            } else if (qVar instanceof r) {
                d(pVar, (r) qVar, canvas, i2, i3, colorFilter);
            }
        }
        canvas.restore();
    }

    private void d(p pVar, r rVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
        float f = i2 / this.f1370k;
        float f2 = i3 / this.f1371l;
        float fMin = Math.min(f, f2);
        Matrix matrix = pVar.a;
        this.c.set(matrix);
        this.c.postScale(f, f2);
        float fE = e(matrix);
        if (fE == 0.0f) {
            return;
        }
        rVar.d(this.a);
        Path path = this.a;
        this.b.reset();
        if (rVar.c()) {
            this.b.setFillType(rVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
            this.b.addPath(path, this.c);
            canvas.clipPath(this.b);
            return;
        }
        o oVar = (o) rVar;
        float f3 = oVar.f1356k;
        if (f3 != 0.0f || oVar.f1357l != 1.0f) {
            float f4 = oVar.f1358m;
            float f5 = (f3 + f4) % 1.0f;
            float f6 = (oVar.f1357l + f4) % 1.0f;
            if (this.f == null) {
                this.f = new PathMeasure();
            }
            this.f.setPath(this.a, false);
            float length = this.f.getLength();
            float f7 = f5 * length;
            float f8 = f6 * length;
            path.reset();
            if (f7 > f8) {
                this.f.getSegment(f7, length, path, true);
                this.f.getSegment(0.0f, f8, path, true);
            } else {
                this.f.getSegment(f7, f8, path, true);
            }
            path.rLineTo(0.0f, 0.0f);
        }
        this.b.addPath(path, this.c);
        if (oVar.f1353h.l()) {
            androidx.core.content.c.b bVar = oVar.f1353h;
            if (this.e == null) {
                Paint paint = new Paint(1);
                this.e = paint;
                paint.setStyle(Paint.Style.FILL);
            }
            Paint paint2 = this.e;
            if (bVar.h()) {
                Shader shaderF = bVar.f();
                shaderF.setLocalMatrix(this.c);
                paint2.setShader(shaderF);
                paint2.setAlpha(Math.round(oVar.f1355j * 255.0f));
            } else {
                paint2.setShader(null);
                paint2.setAlpha(255);
                paint2.setColor(v.a(bVar.e(), oVar.f1355j));
            }
            paint2.setColorFilter(colorFilter);
            this.b.setFillType(oVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
            canvas.drawPath(this.b, paint2);
        }
        if (oVar.f.l()) {
            androidx.core.content.c.b bVar2 = oVar.f;
            if (this.d == null) {
                Paint paint3 = new Paint(1);
                this.d = paint3;
                paint3.setStyle(Paint.Style.STROKE);
            }
            Paint paint4 = this.d;
            Paint.Join join = oVar.f1360o;
            if (join != null) {
                paint4.setStrokeJoin(join);
            }
            Paint.Cap cap = oVar.f1359n;
            if (cap != null) {
                paint4.setStrokeCap(cap);
            }
            paint4.setStrokeMiter(oVar.p);
            if (bVar2.h()) {
                Shader shaderF2 = bVar2.f();
                shaderF2.setLocalMatrix(this.c);
                paint4.setShader(shaderF2);
                paint4.setAlpha(Math.round(oVar.f1354i * 255.0f));
            } else {
                paint4.setShader(null);
                paint4.setAlpha(255);
                paint4.setColor(v.a(bVar2.e(), oVar.f1354i));
            }
            paint4.setColorFilter(colorFilter);
            paint4.setStrokeWidth(oVar.g * fMin * fE);
            canvas.drawPath(this.b, paint4);
        }
    }

    private float e(Matrix matrix) {
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
        float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
        float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
        float fMax = Math.max(fHypot, fHypot2);
        if (fMax > 0.0f) {
            return Math.abs(fA) / fMax;
        }
        return 0.0f;
    }

    public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
        c(this.f1367h, q, canvas, i2, i3, colorFilter);
    }

    public boolean f() {
        if (this.f1374o == null) {
            this.f1374o = Boolean.valueOf(this.f1367h.a());
        }
        return this.f1374o.booleanValue();
    }

    public boolean g(int[] iArr) {
        return this.f1367h.b(iArr);
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f1372m;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i2) {
        this.f1372m = i2;
    }

    public s(s sVar) {
        this.c = new Matrix();
        this.f1368i = 0.0f;
        this.f1369j = 0.0f;
        this.f1370k = 0.0f;
        this.f1371l = 0.0f;
        this.f1372m = 255;
        this.f1373n = null;
        this.f1374o = null;
        h.d.b<String, Object> bVar = new h.d.b<>();
        this.p = bVar;
        this.f1367h = new p(sVar.f1367h, bVar);
        this.a = new Path(sVar.a);
        this.b = new Path(sVar.b);
        this.f1368i = sVar.f1368i;
        this.f1369j = sVar.f1369j;
        this.f1370k = sVar.f1370k;
        this.f1371l = sVar.f1371l;
        this.g = sVar.g;
        this.f1372m = sVar.f1372m;
        this.f1373n = sVar.f1373n;
        String str = sVar.f1373n;
        if (str != null) {
            bVar.put(str, this);
        }
        this.f1374o = sVar.f1374o;
    }
}
