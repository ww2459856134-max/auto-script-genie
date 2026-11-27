package com.airbnb.lottie.t0.c;

import java.util.List;

/* loaded from: classes.dex */
public class k extends l<Integer> {
    public k(List<com.airbnb.lottie.z0.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    int p(com.airbnb.lottie.z0.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.b == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.z0.c<A> cVar = this.e;
        return (cVar == 0 || (num = (Integer) cVar.b(aVar.e, aVar.f.floatValue(), aVar.b, aVar.c, f, e(), f())) == null) ? com.airbnb.lottie.y0.g.k(aVar.g(), aVar.d(), f) : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer i(com.airbnb.lottie.z0.a<Integer> aVar, float f) {
        return Integer.valueOf(p(aVar, f));
    }
}
