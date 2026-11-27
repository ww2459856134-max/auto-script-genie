package com.airbnb.lottie.t0.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import java.util.List;

/* loaded from: classes.dex */
public class s implements com.airbnb.lottie.t0.c.b, m, p {
    private final String c;
    private final boolean d;
    private final e0 e;
    private final com.airbnb.lottie.t0.c.g<?, PointF> f;
    private final com.airbnb.lottie.t0.c.g<?, PointF> g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<?, Float> f485h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f487j;
    private final Path a = new Path();
    private final RectF b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private d f486i = new d();

    public s(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.m mVar) {
        this.c = mVar.c();
        this.d = mVar.f();
        this.e = e0Var;
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA = mVar.d().a();
        this.f = gVarA;
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA2 = mVar.e().a();
        this.g = gVarA2;
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA3 = mVar.b().a();
        this.f485h = gVarA3;
        cVar.i(gVarA);
        cVar.i(gVarA2);
        cVar.i(gVarA3);
        gVarA.a(this);
        gVarA2.a(this);
        gVarA3.a(this);
    }

    private void b() {
        this.f487j = false;
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        b();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            e eVar = list.get(i2);
            if (eVar instanceof w) {
                w wVar = (w) eVar;
                if (wVar.i() == com.airbnb.lottie.v0.l.w.SIMULTANEOUSLY) {
                    this.f486i.a(wVar);
                    wVar.b(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        if (t == j0.f438h) {
            this.g.m(cVar);
        } else if (t == j0.f440j) {
            this.f.m(cVar);
        } else if (t == j0.f439i) {
            this.f485h.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        com.airbnb.lottie.y0.g.l(fVar, i2, list, fVar2, this);
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.c;
    }

    @Override // com.airbnb.lottie.t0.b.p
    public Path getPath() {
        if (this.f487j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.f487j = true;
            return this.a;
        }
        PointF pointFH = this.g.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        com.airbnb.lottie.t0.c.g<?, Float> gVar = this.f485h;
        float fO = gVar == null ? 0.0f : ((com.airbnb.lottie.t0.c.i) gVar).o();
        float fMin = Math.min(f, f2);
        if (fO > fMin) {
            fO = fMin;
        }
        PointF pointFH2 = this.f.h();
        this.a.moveTo(pointFH2.x + f, (pointFH2.y - f2) + fO);
        this.a.lineTo(pointFH2.x + f, (pointFH2.y + f2) - fO);
        if (fO > 0.0f) {
            RectF rectF = this.b;
            float f3 = pointFH2.x;
            float f4 = fO * 2.0f;
            float f5 = pointFH2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointFH2.x - f) + fO, pointFH2.y + f2);
        if (fO > 0.0f) {
            RectF rectF2 = this.b;
            float f6 = pointFH2.x;
            float f7 = pointFH2.y;
            float f8 = fO * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointFH2.x - f, (pointFH2.y - f2) + fO);
        if (fO > 0.0f) {
            RectF rectF3 = this.b;
            float f9 = pointFH2.x;
            float f10 = pointFH2.y;
            float f11 = fO * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointFH2.x + f) - fO, pointFH2.y - f2);
        if (fO > 0.0f) {
            RectF rectF4 = this.b;
            float f12 = pointFH2.x;
            float f13 = fO * 2.0f;
            float f14 = pointFH2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.f486i.b(this.a);
        this.f487j = true;
        return this.a;
    }
}
