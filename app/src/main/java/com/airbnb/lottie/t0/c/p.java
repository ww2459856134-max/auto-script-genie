package com.airbnb.lottie.t0.c;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public class p extends l<PointF> {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f499i;

    public p(List<com.airbnb.lottie.z0.a<PointF>> list) {
        super(list);
        this.f499i = new PointF();
    }

    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public PointF i(com.airbnb.lottie.z0.a<PointF> aVar, float f) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.b;
        if (pointF3 == null || (pointF = aVar.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.airbnb.lottie.z0.c<A> cVar = this.e;
        if (cVar != 0 && (pointF2 = (PointF) cVar.b(aVar.e, aVar.f.floatValue(), pointF4, pointF5, f, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f499i;
        float f2 = pointF4.x;
        float f3 = f2 + ((pointF5.x - f2) * f);
        float f4 = pointF4.y;
        pointF6.set(f3, f4 + (f * (pointF5.y - f4)));
        return this.f499i;
    }
}
