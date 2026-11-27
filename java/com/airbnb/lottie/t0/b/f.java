package com.airbnb.lottie.t0.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f implements g, p, com.airbnb.lottie.t0.c.b, com.airbnb.lottie.v0.g {
    private Paint a;
    private RectF b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private final List<e> f461h;

    /* renamed from: i, reason: collision with root package name */
    private final e0 f462i;

    /* renamed from: j, reason: collision with root package name */
    private List<p> f463j;

    /* renamed from: k, reason: collision with root package name */
    private com.airbnb.lottie.t0.c.u f464k;

    public f(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.q qVar) {
        this(e0Var, cVar, qVar.c(), qVar.d(), b(e0Var, cVar, qVar.b()), h(qVar.b()));
    }

    private static List<e> b(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, List<com.airbnb.lottie.v0.l.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            e eVarA = list.get(i2).a(e0Var, cVar);
            if (eVarA != null) {
                arrayList.add(eVarA);
            }
        }
        return arrayList;
    }

    static com.airbnb.lottie.v0.k.l h(List<com.airbnb.lottie.v0.l.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.airbnb.lottie.v0.l.b bVar = list.get(i2);
            if (bVar instanceof com.airbnb.lottie.v0.k.l) {
                return (com.airbnb.lottie.v0.k.l) bVar;
            }
        }
        return null;
    }

    private boolean k() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f461h.size(); i3++) {
            if ((this.f461h.get(i3) instanceof g) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        com.airbnb.lottie.t0.c.u uVar = this.f464k;
        if (uVar != null) {
            this.c.preConcat(uVar.f());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f461h.size() - 1; size >= 0; size--) {
            e eVar = this.f461h.get(size);
            if (eVar instanceof g) {
                ((g) eVar).a(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        com.airbnb.lottie.t0.c.u uVar = this.f464k;
        if (uVar != null) {
            this.c.preConcat(uVar.f());
            i2 = (int) (((((this.f464k.h() == null ? 100 : this.f464k.h().h().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.f462i.F() && k() && i2 != 255;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.b, this.c, true);
            this.a.setAlpha(i2);
            com.airbnb.lottie.y0.h.m(canvas, this.b, this.a);
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f461h.size() - 1; size >= 0; size--) {
            e eVar = this.f461h.get(size);
            if (eVar instanceof g) {
                ((g) eVar).c(canvas, this.c, i2);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        this.f462i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f461h.size());
        arrayList.addAll(list);
        for (int size = this.f461h.size() - 1; size >= 0; size--) {
            e eVar = this.f461h.get(size);
            eVar.e(arrayList, this.f461h.subList(0, size));
            arrayList.add(eVar);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        com.airbnb.lottie.t0.c.u uVar = this.f464k;
        if (uVar != null) {
            uVar.c(t, cVar);
        }
    }

    @Override // com.airbnb.lottie.v0.g
    public void g(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        if (fVar.g(getName(), i2)) {
            if (!"__container".equals(getName())) {
                fVar2 = fVar2.a(getName());
                if (fVar.c(getName(), i2)) {
                    list.add(fVar2.i(this));
                }
            }
            if (fVar.h(getName(), i2)) {
                int iE = i2 + fVar.e(getName(), i2);
                for (int i3 = 0; i3 < this.f461h.size(); i3++) {
                    e eVar = this.f461h.get(i3);
                    if (eVar instanceof com.airbnb.lottie.v0.g) {
                        ((com.airbnb.lottie.v0.g) eVar).g(fVar, iE, list, fVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.f;
    }

    @Override // com.airbnb.lottie.t0.b.p
    public Path getPath() {
        this.c.reset();
        com.airbnb.lottie.t0.c.u uVar = this.f464k;
        if (uVar != null) {
            this.c.set(uVar.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.f461h.size() - 1; size >= 0; size--) {
            e eVar = this.f461h.get(size);
            if (eVar instanceof p) {
                this.d.addPath(((p) eVar).getPath(), this.c);
            }
        }
        return this.d;
    }

    List<p> i() {
        if (this.f463j == null) {
            this.f463j = new ArrayList();
            for (int i2 = 0; i2 < this.f461h.size(); i2++) {
                e eVar = this.f461h.get(i2);
                if (eVar instanceof p) {
                    this.f463j.add((p) eVar);
                }
            }
        }
        return this.f463j;
    }

    Matrix j() {
        com.airbnb.lottie.t0.c.u uVar = this.f464k;
        if (uVar != null) {
            return uVar.f();
        }
        this.c.reset();
        return this.c;
    }

    f(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, String str, boolean z, List<e> list, com.airbnb.lottie.v0.k.l lVar) {
        this.a = new com.airbnb.lottie.t0.a();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.f462i = e0Var;
        this.g = z;
        this.f461h = list;
        if (lVar != null) {
            com.airbnb.lottie.t0.c.u uVarB = lVar.b();
            this.f464k = uVarB;
            uVarB.a(cVar);
            this.f464k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            e eVar = list.get(size);
            if (eVar instanceof l) {
                arrayList.add((l) eVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((l) arrayList.get(size2)).b(list.listIterator(list.size()));
        }
    }
}
