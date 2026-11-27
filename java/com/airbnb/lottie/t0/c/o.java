package com.airbnb.lottie.t0.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class o extends l<PointF> {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f495i;

    /* renamed from: j, reason: collision with root package name */
    private final float[] f496j;

    /* renamed from: k, reason: collision with root package name */
    private n f497k;

    /* renamed from: l, reason: collision with root package name */
    private PathMeasure f498l;

    public o(List<? extends com.airbnb.lottie.z0.a<PointF>> list) {
        super(list);
        this.f495i = new PointF();
        this.f496j = new float[2];
        this.f498l = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public PointF i(com.airbnb.lottie.z0.a<PointF> aVar, float f) {
        PointF pointF;
        n nVar = (n) aVar;
        Path pathJ = nVar.j();
        if (pathJ == null) {
            return aVar.b;
        }
        com.airbnb.lottie.z0.c<A> cVar = this.e;
        if (cVar != 0 && (pointF = (PointF) cVar.b(nVar.e, nVar.f.floatValue(), nVar.b, nVar.c, e(), f, f())) != null) {
            return pointF;
        }
        if (this.f497k != nVar) {
            this.f498l.setPath(pathJ, false);
            this.f497k = nVar;
        }
        PathMeasure pathMeasure = this.f498l;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.f496j, null);
        PointF pointF2 = this.f495i;
        float[] fArr = this.f496j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f495i;
    }
}
