package com.airbnb.lottie.t0.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class i implements g, com.airbnb.lottie.t0.c.b, m {
    private final Path a;
    private final Paint b;
    private final com.airbnb.lottie.v0.m.c c;
    private final String d;
    private final boolean e;
    private final List<p> f;
    private final com.airbnb.lottie.t0.c.g<Integer, Integer> g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<Integer, Integer> f466h;

    /* renamed from: i, reason: collision with root package name */
    private com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> f467i;

    /* renamed from: j, reason: collision with root package name */
    private final e0 f468j;

    public i(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.p pVar) {
        Path path = new Path();
        this.a = path;
        this.b = new com.airbnb.lottie.t0.a(1);
        this.f = new ArrayList();
        this.c = cVar;
        this.d = pVar.d();
        this.e = pVar.f();
        this.f468j = e0Var;
        if (pVar.b() == null || pVar.e() == null) {
            this.g = null;
            this.f466h = null;
            return;
        }
        path.setFillType(pVar.c());
        com.airbnb.lottie.t0.c.g<Integer, Integer> gVarA = pVar.b().a();
        this.g = gVarA;
        gVarA.a(this);
        cVar.i(gVarA);
        com.airbnb.lottie.t0.c.g<Integer, Integer> gVarA2 = pVar.e().a();
        this.f466h = gVarA2;
        gVarA2.a(this);
        cVar.i(gVarA2);
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        if (this.e) {
            return;
        }
        com.airbnb.lottie.c.a("FillContent#draw");
        this.b.setColor(((com.airbnb.lottie.t0.c.h) this.g).o());
        this.b.setAlpha(com.airbnb.lottie.y0.g.c((int) ((((i2 / 255.0f) * this.f466h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.f467i;
        if (gVar != null) {
            this.b.setColorFilter(gVar.h());
        }
        this.a.reset();
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            this.a.addPath(this.f.get(i3).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        com.airbnb.lottie.c.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        this.f468j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            e eVar = list2.get(i2);
            if (eVar instanceof p) {
                this.f.add((p) eVar);
            }
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        if (t == j0.a) {
            this.g.m(cVar);
            return;
        }
        if (t == j0.d) {
            this.f466h.m(cVar);
            return;
        }
        if (t == j0.C) {
            com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.f467i;
            if (gVar != null) {
                this.c.C(gVar);
            }
            if (cVar == null) {
                this.f467i = null;
                return;
            }
            com.airbnb.lottie.t0.c.v vVar = new com.airbnb.lottie.t0.c.v(cVar);
            this.f467i = vVar;
            vVar.a(this);
            this.c.i(this.f467i);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        com.airbnb.lottie.y0.g.l(fVar, i2, list, fVar2, this);
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.d;
    }
}
