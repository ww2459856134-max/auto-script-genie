package com.airbnb.lottie.t0.c;

import java.util.List;

/* loaded from: classes.dex */
public class i extends l<Float> {
    public i(List<com.airbnb.lottie.z0.a<Float>> list) {
        super(list);
    }

    public float o() {
        return p(b(), d());
    }

    float p(com.airbnb.lottie.z0.a<Float> aVar, float f) {
        Float f2;
        if (aVar.b == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.z0.c<A> cVar = this.e;
        return (cVar == 0 || (f2 = (Float) cVar.b(aVar.e, aVar.f.floatValue(), aVar.b, aVar.c, f, e(), f())) == null) ? com.airbnb.lottie.y0.g.j(aVar.f(), aVar.c(), f) : f2.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Float i(com.airbnb.lottie.z0.a<Float> aVar, float f) {
        return Float.valueOf(p(aVar, f));
    }
}
