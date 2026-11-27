package com.airbnb.lottie.t0.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements com.airbnb.lottie.t0.c.b, m, g {
    private final e0 e;
    protected final com.airbnb.lottie.v0.m.c f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f454h;

    /* renamed from: i, reason: collision with root package name */
    final Paint f455i;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f456j;

    /* renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Integer> f457k;

    /* renamed from: l, reason: collision with root package name */
    private final List<com.airbnb.lottie.t0.c.g<?, Float>> f458l;

    /* renamed from: m, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f459m;

    /* renamed from: n, reason: collision with root package name */
    private com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> f460n;
    private final PathMeasure a = new PathMeasure();
    private final Path b = new Path();
    private final Path c = new Path();
    private final RectF d = new RectF();
    private final List<b> g = new ArrayList();

    c(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.v0.k.d dVar, com.airbnb.lottie.v0.k.b bVar, List<com.airbnb.lottie.v0.k.b> list, com.airbnb.lottie.v0.k.b bVar2) {
        com.airbnb.lottie.t0.a aVar = new com.airbnb.lottie.t0.a(1);
        this.f455i = aVar;
        this.e = e0Var;
        this.f = cVar;
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setStrokeCap(cap);
        aVar.setStrokeJoin(join);
        aVar.setStrokeMiter(f);
        this.f457k = dVar.a();
        this.f456j = bVar.a();
        if (bVar2 == null) {
            this.f459m = null;
        } else {
            this.f459m = bVar2.a();
        }
        this.f458l = new ArrayList(list.size());
        this.f454h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f458l.add(list.get(i2).a());
        }
        cVar.i(this.f457k);
        cVar.i(this.f456j);
        for (int i3 = 0; i3 < this.f458l.size(); i3++) {
            cVar.i(this.f458l.get(i3));
        }
        com.airbnb.lottie.t0.c.g<?, Float> gVar = this.f459m;
        if (gVar != null) {
            cVar.i(gVar);
        }
        this.f457k.a(this);
        this.f456j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f458l.get(i4).a(this);
        }
        com.airbnb.lottie.t0.c.g<?, Float> gVar2 = this.f459m;
        if (gVar2 != null) {
            gVar2.a(this);
        }
    }

    private void b(Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#applyDashPattern");
        if (this.f458l.isEmpty()) {
            com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
            return;
        }
        float fG = com.airbnb.lottie.y0.h.g(matrix);
        for (int i2 = 0; i2 < this.f458l.size(); i2++) {
            this.f454h[i2] = this.f458l.get(i2).h().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f454h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f454h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f454h;
            fArr3[i2] = fArr3[i2] * fG;
        }
        com.airbnb.lottie.t0.c.g<?, Float> gVar = this.f459m;
        this.f455i.setPathEffect(new DashPathEffect(this.f454h, gVar == null ? 0.0f : fG * gVar.h().floatValue()));
        com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(Canvas canvas, b bVar, Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#applyTrimPath");
        if (bVar.b == null) {
            com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.b.addPath(((p) bVar.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float fFloatValue = (bVar.b.g().h().floatValue() * length) / 360.0f;
        float fFloatValue2 = ((bVar.b.h().h().floatValue() * length) / 100.0f) + fFloatValue;
        float fFloatValue3 = ((bVar.b.f().h().floatValue() * length) / 100.0f) + fFloatValue;
        float f = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((p) bVar.a.get(size2)).getPath());
            this.c.transform(matrix);
            this.a.setPath(this.c, false);
            float length2 = this.a.getLength();
            if (fFloatValue3 > length) {
                float f2 = fFloatValue3 - length;
                if (f2 >= f + length2 || f >= f2) {
                    float f3 = f + length2;
                    if (f3 >= fFloatValue2 && f <= fFloatValue3) {
                        if (f3 > fFloatValue3 || fFloatValue2 >= f) {
                            com.airbnb.lottie.y0.h.a(this.c, fFloatValue2 < f ? 0.0f : (fFloatValue2 - f) / length2, fFloatValue3 <= f3 ? (fFloatValue3 - f) / length2 : 1.0f, 0.0f);
                            canvas.drawPath(this.c, this.f455i);
                        } else {
                            canvas.drawPath(this.c, this.f455i);
                        }
                    }
                } else {
                    com.airbnb.lottie.y0.h.a(this.c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f2 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.f455i);
                }
            }
            f += length2;
        }
        com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        com.airbnb.lottie.c.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            for (int i3 = 0; i3 < bVar.a.size(); i3++) {
                this.b.addPath(((p) bVar.a.get(i3)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float fO = ((com.airbnb.lottie.t0.c.i) this.f456j).o();
        RectF rectF2 = this.d;
        float f = fO / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a("StrokeContent#draw");
        if (com.airbnb.lottie.y0.h.h(matrix)) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        this.f455i.setAlpha(com.airbnb.lottie.y0.g.c((int) ((((i2 / 255.0f) * ((com.airbnb.lottie.t0.c.k) this.f457k).o()) / 100.0f) * 255.0f), 0, 255));
        this.f455i.setStrokeWidth(((com.airbnb.lottie.t0.c.i) this.f456j).o() * com.airbnb.lottie.y0.h.g(matrix));
        if (this.f455i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        b(matrix);
        com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.f460n;
        if (gVar != null) {
            this.f455i.setColorFilter(gVar.h());
        }
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            b bVar = this.g.get(i3);
            if (bVar.b != null) {
                h(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.c.a("StrokeContent#buildPath");
                this.b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((p) bVar.a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.c.b("StrokeContent#buildPath");
                com.airbnb.lottie.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.f455i);
                com.airbnb.lottie.c.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.c.b("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.airbnb.lottie.t0.b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(List<e> list, List<e> list2) {
        w wVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            e eVar = list.get(size);
            if (eVar instanceof w) {
                w wVar2 = (w) eVar;
                if (wVar2.i() == com.airbnb.lottie.v0.l.w.INDIVIDUALLY) {
                    wVar = wVar2;
                }
            }
        }
        if (wVar != null) {
            wVar.b(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            e eVar2 = list2.get(size2);
            if (eVar2 instanceof w) {
                w wVar3 = (w) eVar2;
                if (wVar3.i() == com.airbnb.lottie.v0.l.w.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(wVar3);
                    wVar3.b(this);
                } else if (eVar2 instanceof p) {
                    if (bVar == null) {
                        bVar = new b(wVar);
                    }
                    bVar.a.add((p) eVar2);
                }
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        if (t == j0.d) {
            this.f457k.m(cVar);
            return;
        }
        if (t == j0.f445o) {
            this.f456j.m(cVar);
            return;
        }
        if (t == j0.C) {
            com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.f460n;
            if (gVar != null) {
                this.f.C(gVar);
            }
            if (cVar == null) {
                this.f460n = null;
                return;
            }
            com.airbnb.lottie.t0.c.v vVar = new com.airbnb.lottie.t0.c.v(cVar);
            this.f460n = vVar;
            vVar.a(this);
            this.f.i(this.f460n);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        com.airbnb.lottie.y0.g.l(fVar, i2, list, fVar2, this);
    }
}
