package com.airbnb.lottie.t0.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;

/* loaded from: classes.dex */
public class v extends c {

    /* renamed from: o, reason: collision with root package name */
    private final com.airbnb.lottie.v0.m.c f491o;
    private final String p;
    private final boolean q;
    private final com.airbnb.lottie.t0.c.g<Integer, Integer> r;
    private com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> s;

    public v(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.v vVar) {
        super(e0Var, cVar, vVar.b().a(), vVar.e().a(), vVar.g(), vVar.i(), vVar.j(), vVar.f(), vVar.d());
        this.f491o = cVar;
        this.p = vVar.h();
        this.q = vVar.k();
        com.airbnb.lottie.t0.c.g<Integer, Integer> gVarA = vVar.c().a();
        this.r = gVarA;
        gVarA.a(this);
        cVar.i(gVarA);
    }

    @Override // com.airbnb.lottie.t0.b.c, com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        if (this.q) {
            return;
        }
        this.f455i.setColor(((com.airbnb.lottie.t0.c.h) this.r).o());
        com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.s;
        if (gVar != null) {
            this.f455i.setColorFilter(gVar.h());
        }
        super.c(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.t0.b.c, com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        super.f(t, cVar);
        if (t == j0.b) {
            this.r.m(cVar);
            return;
        }
        if (t == j0.C) {
            com.airbnb.lottie.t0.c.g<ColorFilter, ColorFilter> gVar = this.s;
            if (gVar != null) {
                this.f491o.C(gVar);
            }
            if (cVar == null) {
                this.s = null;
                return;
            }
            com.airbnb.lottie.t0.c.v vVar = new com.airbnb.lottie.t0.c.v(cVar);
            this.s = vVar;
            vVar.a(this);
            this.f491o.i(this.r);
        }
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.p;
    }
}
