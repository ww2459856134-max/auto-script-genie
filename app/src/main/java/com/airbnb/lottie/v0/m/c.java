package com.airbnb.lottie.v0.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.t0.c.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements com.airbnb.lottie.t0.b.g, com.airbnb.lottie.t0.c.b, com.airbnb.lottie.v0.g {
    private final Path a = new Path();
    private final Matrix b = new Matrix();
    private final Paint c = new com.airbnb.lottie.t0.a(1);
    private final Paint d = new com.airbnb.lottie.t0.a(1, PorterDuff.Mode.DST_IN);
    private final Paint e = new com.airbnb.lottie.t0.a(1, PorterDuff.Mode.DST_OUT);
    private final Paint f;
    private final Paint g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f534h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f535i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f536j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f537k;

    /* renamed from: l, reason: collision with root package name */
    private final String f538l;

    /* renamed from: m, reason: collision with root package name */
    final Matrix f539m;

    /* renamed from: n, reason: collision with root package name */
    final e0 f540n;

    /* renamed from: o, reason: collision with root package name */
    final i f541o;
    private com.airbnb.lottie.t0.c.m p;
    private com.airbnb.lottie.t0.c.i q;
    private c r;
    private c s;
    private List<c> t;
    private final List<com.airbnb.lottie.t0.c.g<?, ?>> u;
    final u v;
    private boolean w;

    c(e0 e0Var, i iVar) {
        com.airbnb.lottie.t0.a aVar = new com.airbnb.lottie.t0.a(1);
        this.f = aVar;
        this.g = new com.airbnb.lottie.t0.a(PorterDuff.Mode.CLEAR);
        this.f534h = new RectF();
        this.f535i = new RectF();
        this.f536j = new RectF();
        this.f537k = new RectF();
        this.f539m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.f540n = e0Var;
        this.f541o = iVar;
        this.f538l = iVar.g() + "#draw";
        if (iVar.f() == h.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        u uVarB = iVar.u().b();
        this.v = uVarB;
        uVarB.b(this);
        if (iVar.e() != null && !iVar.e().isEmpty()) {
            com.airbnb.lottie.t0.c.m mVar = new com.airbnb.lottie.t0.c.m(iVar.e());
            this.p = mVar;
            Iterator<com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path>> it = mVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (com.airbnb.lottie.t0.c.g<Integer, Integer> gVar : this.p.c()) {
                i(gVar);
                gVar.a(this);
            }
        }
        I();
    }

    private void A() {
        this.f540n.invalidateSelf();
    }

    private void B(float f) {
        this.f540n.m().m().a(this.f541o.g(), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z) {
        if (z != this.w) {
            this.w = z;
            A();
        }
    }

    private void I() {
        if (this.f541o.c().isEmpty()) {
            H(true);
            return;
        }
        com.airbnb.lottie.t0.c.i iVar = new com.airbnb.lottie.t0.c.i(this.f541o.c());
        this.q = iVar;
        iVar.k();
        this.q.a(new a(this));
        H(this.q.h().floatValue() == 1.0f);
        i(this.q);
    }

    private void j(Canvas canvas, Matrix matrix, com.airbnb.lottie.v0.l.h hVar, com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVar, com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2) {
        this.a.set(gVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (gVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
    }

    private void k(Canvas canvas, Matrix matrix, com.airbnb.lottie.v0.l.h hVar, com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVar, com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2) {
        com.airbnb.lottie.y0.h.m(canvas, this.f534h, this.d);
        this.a.set(gVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (gVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, com.airbnb.lottie.v0.l.h hVar, com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVar, com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2) {
        com.airbnb.lottie.y0.h.m(canvas, this.f534h, this.c);
        canvas.drawRect(this.f534h, this.c);
        this.a.set(gVar.h());
        this.a.transform(matrix);
        this.c.setAlpha((int) (gVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, com.airbnb.lottie.v0.l.h hVar, com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVar, com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2) {
        com.airbnb.lottie.y0.h.m(canvas, this.f534h, this.d);
        canvas.drawRect(this.f534h, this.c);
        this.e.setAlpha((int) (gVar2.h().intValue() * 2.55f));
        this.a.set(gVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, com.airbnb.lottie.v0.l.h hVar, com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVar, com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2) {
        com.airbnb.lottie.y0.h.m(canvas, this.f534h, this.e);
        canvas.drawRect(this.f534h, this.c);
        this.e.setAlpha((int) (gVar2.h().intValue() * 2.55f));
        this.a.set(gVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.c.a("Layer#saveLayer");
        com.airbnb.lottie.y0.h.n(canvas, this.f534h, this.d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        com.airbnb.lottie.c.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            com.airbnb.lottie.v0.l.h hVar = this.p.b().get(i2);
            com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVar = this.p.a().get(i2);
            com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2 = this.p.c().get(i2);
            int i3 = b.b[hVar.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.c.setColor(-16777216);
                        this.c.setAlpha(255);
                        canvas.drawRect(this.f534h, this.c);
                    }
                    if (hVar.d()) {
                        n(canvas, matrix, hVar, gVar, gVar2);
                    } else {
                        p(canvas, matrix, hVar, gVar, gVar2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (hVar.d()) {
                            l(canvas, matrix, hVar, gVar, gVar2);
                        } else {
                            j(canvas, matrix, hVar, gVar, gVar2);
                        }
                    }
                } else if (hVar.d()) {
                    m(canvas, matrix, hVar, gVar, gVar2);
                } else {
                    k(canvas, matrix, hVar, gVar, gVar2);
                }
            } else if (q()) {
                this.c.setAlpha(255);
                canvas.drawRect(this.f534h, this.c);
            }
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, com.airbnb.lottie.v0.l.h hVar, com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVar, com.airbnb.lottie.t0.c.g<Integer, Integer> gVar2) {
        this.a.set(gVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
    }

    private boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.p.b().size(); i2++) {
            if (this.p.b().get(i2).a() != com.airbnb.lottie.v0.l.g.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (c cVar = this.s; cVar != null; cVar = cVar.s) {
            this.t.add(cVar);
        }
    }

    private void s(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        RectF rectF = this.f534h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }

    static c u(i iVar, e0 e0Var, com.airbnb.lottie.e eVar) {
        switch (b.a[iVar.d().ordinal()]) {
            case 1:
                return new k(e0Var, iVar);
            case 2:
                return new e(e0Var, iVar, eVar.n(iVar.k()), eVar);
            case 3:
                return new l(e0Var, iVar);
            case 4:
                return new f(e0Var, iVar);
            case 5:
                return new j(e0Var, iVar);
            case 6:
                return new p(e0Var, iVar);
            default:
                com.airbnb.lottie.y0.d.c("Unknown layer type " + iVar.d());
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix) {
        this.f535i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                com.airbnb.lottie.v0.l.h hVar = this.p.b().get(i2);
                this.a.set(this.p.a().get(i2).h());
                this.a.transform(matrix);
                int i3 = b.b[hVar.a().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                if ((i3 == 3 || i3 == 4) && hVar.d()) {
                    return;
                }
                this.a.computeBounds(this.f537k, false);
                if (i2 == 0) {
                    this.f535i.set(this.f537k);
                } else {
                    RectF rectF2 = this.f535i;
                    rectF2.set(Math.min(rectF2.left, this.f537k.left), Math.min(this.f535i.top, this.f537k.top), Math.max(this.f535i.right, this.f537k.right), Math.max(this.f535i.bottom, this.f537k.bottom));
                }
            }
            if (rectF.intersect(this.f535i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        if (x() && this.f541o.f() != h.INVERT) {
            this.f536j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.a(this.f536j, matrix, true);
            if (rectF.intersect(this.f536j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void C(com.airbnb.lottie.t0.c.g<?, ?> gVar) {
        this.u.remove(gVar);
    }

    void D(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
    }

    void E(c cVar) {
        this.r = cVar;
    }

    void F(c cVar) {
        this.s = cVar;
    }

    void G(float f) {
        this.v.j(f);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).l(f);
            }
        }
        if (this.f541o.t() != 0.0f) {
            f /= this.f541o.t();
        }
        com.airbnb.lottie.t0.c.i iVar = this.q;
        if (iVar != null) {
            iVar.l(f / this.f541o.t());
        }
        c cVar = this.r;
        if (cVar != null) {
            this.r.G(cVar.f541o.t() * f);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).l(f);
        }
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f534h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f539m.set(matrix);
        if (z) {
            List<c> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f539m.preConcat(this.t.get(size).v.f());
                }
            } else {
                c cVar = this.s;
                if (cVar != null) {
                    this.f539m.preConcat(cVar.v.f());
                }
            }
        }
        this.f539m.preConcat(this.v.f());
    }

    @Override // com.airbnb.lottie.t0.b.g
    public void c(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a(this.f538l);
        if (!this.w || this.f541o.v()) {
            com.airbnb.lottie.c.b(this.f538l);
            return;
        }
        r();
        com.airbnb.lottie.c.a("Layer#parentMatrix");
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.b.preConcat(this.t.get(size).v.f());
        }
        com.airbnb.lottie.c.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i2 / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        if (!x() && !w()) {
            this.b.preConcat(this.v.f());
            com.airbnb.lottie.c.a("Layer#drawLayer");
            t(canvas, this.b, iIntValue);
            com.airbnb.lottie.c.b("Layer#drawLayer");
            B(com.airbnb.lottie.c.b(this.f538l));
            return;
        }
        com.airbnb.lottie.c.a("Layer#computeBounds");
        a(this.f534h, this.b, false);
        z(this.f534h, matrix);
        this.b.preConcat(this.v.f());
        y(this.f534h, this.b);
        if (!this.f534h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.f534h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.airbnb.lottie.c.b("Layer#computeBounds");
        if (!this.f534h.isEmpty()) {
            com.airbnb.lottie.c.a("Layer#saveLayer");
            this.c.setAlpha(255);
            com.airbnb.lottie.y0.h.m(canvas, this.f534h, this.c);
            com.airbnb.lottie.c.b("Layer#saveLayer");
            s(canvas);
            com.airbnb.lottie.c.a("Layer#drawLayer");
            t(canvas, this.b, iIntValue);
            com.airbnb.lottie.c.b("Layer#drawLayer");
            if (w()) {
                o(canvas, this.b);
            }
            if (x()) {
                com.airbnb.lottie.c.a("Layer#drawMatte");
                com.airbnb.lottie.c.a("Layer#saveLayer");
                com.airbnb.lottie.y0.h.n(canvas, this.f534h, this.f, 19);
                com.airbnb.lottie.c.b("Layer#saveLayer");
                s(canvas);
                this.r.c(canvas, matrix, iIntValue);
                com.airbnb.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c.b("Layer#restoreLayer");
                com.airbnb.lottie.c.b("Layer#drawMatte");
            }
            com.airbnb.lottie.c.a("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.b("Layer#restoreLayer");
        }
        B(com.airbnb.lottie.c.b(this.f538l));
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        A();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<com.airbnb.lottie.t0.b.e> list, List<com.airbnb.lottie.t0.b.e> list2) {
    }

    @Override // com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        this.v.c(t, cVar);
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
                D(fVar, i2 + fVar.e(getName(), i2), list, fVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.t0.b.e
    public String getName() {
        return this.f541o.g();
    }

    public void i(com.airbnb.lottie.t0.c.g<?, ?> gVar) {
        if (gVar == null) {
            return;
        }
        this.u.add(gVar);
    }

    abstract void t(Canvas canvas, Matrix matrix, int i2);

    i v() {
        return this.f541o;
    }

    boolean w() {
        com.airbnb.lottie.t0.c.m mVar = this.p;
        return (mVar == null || mVar.a().isEmpty()) ? false : true;
    }

    boolean x() {
        return this.r != null;
    }
}
