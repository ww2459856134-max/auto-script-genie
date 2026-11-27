package com.airbnb.lottie.v0.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.t0.c.v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e extends c {
    private final RectF A;
    private Paint B;
    private com.airbnb.lottie.t0.c.g<Float, Float> x;
    private final List<c> y;
    private final RectF z;

    public e(e0 e0Var, i iVar, List<i> list, com.airbnb.lottie.e eVar) {
        int i2;
        c cVar;
        super(e0Var, iVar);
        this.y = new ArrayList();
        this.z = new RectF();
        this.A = new RectF();
        this.B = new Paint();
        com.airbnb.lottie.v0.k.b bVarS = iVar.s();
        if (bVarS != null) {
            com.airbnb.lottie.t0.c.g<Float, Float> gVarA = bVarS.a();
            this.x = gVarA;
            i(gVarA);
            this.x.a(this);
        } else {
            this.x = null;
        }
        h.d.f fVar = new h.d.f(eVar.j().size());
        int size = list.size() - 1;
        c cVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            i iVar2 = list.get(size);
            c cVarU = c.u(iVar2, e0Var, eVar);
            if (cVarU != null) {
                fVar.j(cVarU.v().b(), cVarU);
                if (cVar2 != null) {
                    cVar2.E(cVarU);
                    cVar2 = null;
                } else {
                    this.y.add(0, cVarU);
                    int i3 = d.a[iVar2.f().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        cVar2 = cVarU;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < fVar.m(); i2++) {
            c cVar3 = (c) fVar.f(fVar.i(i2));
            if (cVar3 != null && (cVar = (c) fVar.f(cVar3.v().h())) != null) {
                cVar3.F(cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.v0.m.c
    protected void D(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        for (int i3 = 0; i3 < this.y.size(); i3++) {
            this.y.get(i3).g(fVar, i2, list, fVar2);
        }
    }

    @Override // com.airbnb.lottie.v0.m.c
    public void G(float f) {
        super.G(f);
        if (this.x != null) {
            f = ((this.x.h().floatValue() * this.f541o.a().h()) - this.f541o.a().o()) / (this.f540n.m().e() + 0.01f);
        }
        if (this.x == null) {
            f -= this.f541o.p();
        }
        if (this.f541o.t() != 0.0f) {
            f /= this.f541o.t();
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.y.get(size).G(f);
        }
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.y.get(size).a(this.z, this.f539m, true);
            rectF.union(this.z);
        }
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.v0.g
    public <T> void f(T t, com.airbnb.lottie.z0.c<T> cVar) {
        super.f(t, cVar);
        if (t == j0.A) {
            if (cVar == null) {
                com.airbnb.lottie.t0.c.g<Float, Float> gVar = this.x;
                if (gVar != null) {
                    gVar.m(null);
                    return;
                }
                return;
            }
            v vVar = new v(cVar);
            this.x = vVar;
            vVar.a(this);
            i(this.x);
        }
    }

    @Override // com.airbnb.lottie.v0.m.c
    void t(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a("CompositionLayer#draw");
        this.A.set(0.0f, 0.0f, this.f541o.j(), this.f541o.i());
        matrix.mapRect(this.A);
        boolean z = this.f540n.F() && this.y.size() > 1 && i2 != 255;
        if (z) {
            this.B.setAlpha(i2);
            com.airbnb.lottie.y0.h.m(canvas, this.A, this.B);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            if (!this.A.isEmpty() ? canvas.clipRect(this.A) : true) {
                this.y.get(size).c(canvas, matrix, i2);
            }
        }
        canvas.restore();
        com.airbnb.lottie.c.b("CompositionLayer#draw");
    }
}
