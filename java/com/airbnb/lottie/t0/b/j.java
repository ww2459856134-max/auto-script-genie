package com.airbnb.lottie.t0.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class j implements g, com.airbnb.lottie.t0.c.b, m {
    private final String a;
    private final boolean b;
    private final com.airbnb.lottie.v0.m.c c;
    private final h.d.f<LinearGradient> d = new h.d.f<>();
    private final h.d.f<RadialGradient> e = new h.d.f<>();
    private final Path f;
    private final Paint g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f469h;

    /* renamed from: i, reason: collision with root package name */
    private final List<p> f470i;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.v0.l.f f471j;

    /* renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.c, com.airbnb.lottie.v0.l.c> f472k;

    /* renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<Integer, Integer> f473l;

    /* renamed from: m, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<PointF, PointF> f474m;

    /* renamed from: n, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<PointF, PointF> f475n;

    /* renamed from: o, reason: collision with root package name */
    private com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> f476o;
    private com.airbnb.lottie.t0.c.v p;
    private final e0 q;
    private final int r;

    public j(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.d dVar) {
        Path path = new Path();
        this.f = path;
        this.g = new com.airbnb.lottie.t0.a(1);
        this.f469h = new RectF();
        this.f470i = new ArrayList();
        this.c = cVar;
        this.a = dVar.f();
        this.b = dVar.i();
        this.q = e0Var;
        this.f471j = dVar.e();
        path.setFillType(dVar.c());
        this.r = (int) (e0Var.m().d() / 32.0f);
        com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.c, com.airbnb.lottie.v0.l.c> gVarA = dVar.d().a();
        this.f472k = gVarA;
        gVarA.a(this);
        cVar.i(gVarA);
        com.airbnb.lottie.t0.c.g<Integer, Integer> gVarA2 = dVar.g().a();
        this.f473l = gVarA2;
        gVarA2.a(this);
        cVar.i(gVarA2);
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA3 = dVar.h().a();
        this.f474m = gVarA3;
        gVarA3.a(this);
        cVar.i(gVarA3);
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA4 = dVar.b().a();
        this.f475n = gVarA4;
        gVarA4.a(this);
        cVar.i(gVarA4);
    }

    private int[] b(int[] iArr) {
        com.airbnb.lottie.t0.c.v vVar = this.p;
        if (vVar != null) {
            Integer[] numArr = (Integer[]) vVar.h();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private int h() {
        int iRound = Math.round(this.f474m.f() * this.r);
        int iRound2 = Math.round(this.f475n.f() * this.r);
        int iRound3 = Math.round(this.f472k.f() * this.r);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient i() {
        long jH = h();
        LinearGradient linearGradientF = this.d.f(jH);
        if (linearGradientF != null) {
            return linearGradientF;
        }
        PointF pointFH = this.f474m.h();
        PointF pointFH2 = this.f475n.h();
        com.airbnb.lottie.v0.l.c cVarH = this.f472k.h();
        LinearGradient linearGradient = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, b(cVarH.a()), cVarH.b(), Shader.TileMode.CLAMP);
        this.d.j(jH, linearGradient);
        return linearGradient;
    }

    private RadialGradient j() {
        long jH = h();
        RadialGradient radialGradientF = this.e.f(jH);
        if (radialGradientF != null) {
            return radialGradientF;
        }
        PointF pointFH = this.f474m.h();
        PointF pointFH2 = this.f475n.h();
        com.airbnb.lottie.v0.l.c cVarH = this.f472k.h();
        int[] iArrB = b(cVarH.a());
        float[] fArrB = cVarH.b();
        float f = pointFH.x;
        float f2 = pointFH.y;
        float fHypot = (float) Math.hypot(pointFH2.x - f, pointFH2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient = new RadialGradient(f, f2, fHypot, iArrB, fArrB, Shader.TileMode.CLAMP);
        this.e.j(jH, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        for (int i2 = 0; i2 < this.f470i.size(); i2++) {
            this.f.addPath(this.f470i.get(i2).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        if (this.b) {
            return;
        }
        com.airbnb.lottie.c.a("GradientFillContent#draw");
        this.f.reset();
        for (int i3 = 0; i3 < this.f470i.size(); i3++) {
            this.f.addPath(this.f470i.get(i3).getPath(), matrix);
        }
        this.f.computeBounds(this.f469h, false);
        Shader shaderI = this.f471j == com.airbnb.lottie.v0.l.f.LINEAR ? i() : j();
        shaderI.setLocalMatrix(matrix);
        this.g.setShader(shaderI);
        com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.f476o;
        if (gVar != null) {
            this.g.setColorFilter(gVar.h());
        }
        this.g.setAlpha(com.airbnb.lottie.y0.g.c((int) ((((i2 / 255.0f) * this.f473l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        com.airbnb.lottie.c.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        this.q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            e eVar = list2.get(i2);
            if (eVar instanceof p) {
                this.f470i.add((p) eVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        if (t == j0.d) {
            this.f473l.m(cVar);
            return;
        }
        if (t == j0.C) {
            com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.f476o;
            if (gVar != null) {
                this.c.C(gVar);
            }
            if (cVar == null) {
                this.f476o = null;
                return;
            }
            com.airbnb.lottie.t0.c.v vVar = new com.airbnb.lottie.t0.c.v(cVar);
            this.f476o = vVar;
            vVar.a(this);
            this.c.i(this.f476o);
            return;
        }
        if (t == j0.D) {
            com.airbnb.lottie.t0.c.v vVar2 = this.p;
            if (vVar2 != null) {
                this.c.C(vVar2);
            }
            if (cVar == null) {
                this.p = null;
                return;
            }
            com.airbnb.lottie.t0.c.v vVar3 = new com.airbnb.lottie.t0.c.v(cVar);
            this.p = vVar3;
            vVar3.a(this);
            this.c.i(this.p);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        com.airbnb.lottie.y0.g.l(fVar, i2, list, fVar2, this);
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.a;
    }
}
