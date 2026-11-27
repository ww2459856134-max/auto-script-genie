package com.airbnb.lottie.t0.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class t implements g, p, l, com.airbnb.lottie.t0.c.b, m {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final e0 c;
    private final com.airbnb.lottie.v0.m.c d;
    private final String e;
    private final boolean f;
    private final com.airbnb.lottie.t0.c.g<Float, Float> g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.g<Float, Float> f488h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.t0.c.u f489i;

    /* renamed from: j, reason: collision with root package name */
    private f f490j;

    public t(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.n nVar) {
        this.c = e0Var;
        this.d = cVar;
        this.e = nVar.c();
        this.f = nVar.f();
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA = nVar.b().a();
        this.g = gVarA;
        cVar.i(gVarA);
        gVarA.a(this);
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA2 = nVar.d().a();
        this.f488h = gVarA2;
        cVar.i(gVarA2);
        gVarA2.a(this);
        com.airbnb.lottie.t0.c.u uVarB = nVar.e().b();
        this.f489i = uVarB;
        uVarB.a(cVar);
        uVarB.b(this);
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f490j.a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.t0.b.l
    public void b(ListIterator<e> listIterator) {
        if (this.f490j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f490j = new f(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        float fFloatValue = this.g.h().floatValue();
        float fFloatValue2 = this.f488h.h().floatValue();
        float fFloatValue3 = this.f489i.i().h().floatValue() / 100.0f;
        float fFloatValue4 = this.f489i.e().h().floatValue() / 100.0f;
        for (int i3 = ((int) fFloatValue) - 1; i3 >= 0; i3--) {
            this.a.set(matrix);
            float f = i3;
            this.a.preConcat(this.f489i.g(f + fFloatValue2));
            this.f490j.c(canvas, this.a, (int) (i2 * com.airbnb.lottie.y0.g.j(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        this.f490j.e(list, list2);
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        if (this.f489i.c(t, cVar)) {
            return;
        }
        if (t == j0.q) {
            this.g.m(cVar);
        } else if (t == j0.r) {
            this.f488h.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        com.airbnb.lottie.y0.g.l(fVar, i2, list, fVar2, this);
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.e;
    }

    @Override // com.airbnb.lottie.t0.b.p
    public Path getPath() {
        Path path = this.f490j.getPath();
        this.b.reset();
        float fFloatValue = this.g.h().floatValue();
        float fFloatValue2 = this.f488h.h().floatValue();
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(this.f489i.g(i2 + fFloatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }
}
