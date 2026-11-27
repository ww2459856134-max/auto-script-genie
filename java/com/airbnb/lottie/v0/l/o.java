package com.airbnb.lottie.v0.l;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class o {
    private final List<com.airbnb.lottie.v0.a> a;
    private PointF b;
    private boolean c;

    public o(PointF pointF, boolean z, List<com.airbnb.lottie.v0.a> list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    private void e(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public List<com.airbnb.lottie.v0.a> a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(o oVar, o oVar2, float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = oVar.d() || oVar2.d();
        if (oVar.a().size() != oVar2.a().size()) {
            com.airbnb.lottie.y0.d.c("Curves must have the same number of control points. Shape 1: " + oVar.a().size() + "\tShape 2: " + oVar2.a().size());
        }
        int iMin = Math.min(oVar.a().size(), oVar2.a().size());
        if (this.a.size() < iMin) {
            for (int size = this.a.size(); size < iMin; size++) {
                this.a.add(new com.airbnb.lottie.v0.a());
            }
        } else if (this.a.size() > iMin) {
            for (int size2 = this.a.size() - 1; size2 >= iMin; size2--) {
                List<com.airbnb.lottie.v0.a> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = oVar.b();
        PointF pointFB2 = oVar2.b();
        e(com.airbnb.lottie.y0.g.j(pointFB.x, pointFB2.x, f), com.airbnb.lottie.y0.g.j(pointFB.y, pointFB2.y, f));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.v0.a aVar = oVar.a().get(size3);
            com.airbnb.lottie.v0.a aVar2 = oVar2.a().get(size3);
            PointF pointFA = aVar.a();
            PointF pointFB3 = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA2 = aVar2.a();
            PointF pointFB4 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            this.a.get(size3).d(com.airbnb.lottie.y0.g.j(pointFA.x, pointFA2.x, f), com.airbnb.lottie.y0.g.j(pointFA.y, pointFA2.y, f));
            this.a.get(size3).e(com.airbnb.lottie.y0.g.j(pointFB3.x, pointFB4.x, f), com.airbnb.lottie.y0.g.j(pointFB3.y, pointFB4.y, f));
            this.a.get(size3).f(com.airbnb.lottie.y0.g.j(pointFC.x, pointFC2.x, f), com.airbnb.lottie.y0.g.j(pointFC.y, pointFC2.y, f));
        }
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }

    public o() {
        this.a = new ArrayList();
    }
}
