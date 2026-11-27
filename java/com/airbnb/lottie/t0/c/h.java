package com.airbnb.lottie.t0.c;

import java.util.List;

/* loaded from: classes.dex */
public class h extends l<Integer> {
    public h(List<com.airbnb.lottie.z0.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(com.airbnb.lottie.z0.a<Integer> aVar, float f) {
        Integer num;
        Integer num2 = aVar.b;
        if (num2 == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = aVar.c.intValue();
        com.airbnb.lottie.z0.c<A> cVar = this.e;
        return (cVar == 0 || (num = (Integer) cVar.b(aVar.e, aVar.f.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, e(), f())) == null) ? com.airbnb.lottie.y0.b.c(com.airbnb.lottie.y0.g.b(f, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer i(com.airbnb.lottie.z0.a<Integer> aVar, float f) {
        return Integer.valueOf(p(aVar, f));
    }
}
