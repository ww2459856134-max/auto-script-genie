package com.airbnb.lottie.t0.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import java.util.List;

/* loaded from: classes.dex */
public class h implements p, com.airbnb.lottie.t0.c.b, m {
    private final String b;
    private final e0 c;
    private final com.airbnb.lottie.t0.c.g<?, PointF> d;
    private final com.airbnb.lottie.t0.c.g<?, PointF> e;
    private final com.airbnb.lottie.v0.l.a f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f465h;
    private final Path a = new Path();
    private d g = new d();

    public h(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.a aVar) {
        this.b = aVar.b();
        this.c = e0Var;
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA = aVar.d().a();
        this.d = gVarA;
        com.airbnb.lottie.t0.c.g<PointF, PointF> gVarA2 = aVar.c().a();
        this.e = gVarA2;
        this.f = aVar;
        cVar.i(gVarA);
        cVar.i(gVarA2);
        gVarA.a(this);
        gVarA2.a(this);
    }

    private void b() {
        this.f465h = false;
        this.c.invalidateSelf();
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
                    this.g.a(wVar);
                    wVar.b(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        if (t == j0.g) {
            this.d.m(cVar);
        } else if (t == j0.f440j) {
            this.e.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        com.airbnb.lottie.y0.g.l(fVar, i2, list, fVar2, this);
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.t0.b.p
    public Path getPath() {
        if (this.f465h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.e()) {
            this.f465h = true;
            return this.a;
        }
        PointF pointFH = this.d.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        if (this.f.f()) {
            float f5 = -f2;
            this.a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFH2 = this.e.h();
        this.a.offset(pointFH2.x, pointFH2.y);
        this.a.close();
        this.g.b(this.a);
        this.f465h = true;
        return this.a;
    }
}
