package com.airbnb.lottie.t0.c;

import java.util.List;

/* loaded from: classes.dex */
public class q extends l<com.airbnb.lottie.z0.d> {

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.z0.d f500i;

    public q(List<com.airbnb.lottie.z0.a<com.airbnb.lottie.z0.d>> list) {
        super(list);
        this.f500i = new com.airbnb.lottie.z0.d();
    }

    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.z0.d i(com.airbnb.lottie.z0.a<com.airbnb.lottie.z0.d> aVar, float f) {
        com.airbnb.lottie.z0.d dVar;
        com.airbnb.lottie.z0.d dVar2;
        com.airbnb.lottie.z0.d dVar3 = aVar.b;
        if (dVar3 == null || (dVar = aVar.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.z0.d dVar4 = dVar3;
        com.airbnb.lottie.z0.d dVar5 = dVar;
        com.airbnb.lottie.z0.c<A> cVar = this.e;
        if (cVar != 0 && (dVar2 = (com.airbnb.lottie.z0.d) cVar.b(aVar.e, aVar.f.floatValue(), dVar4, dVar5, f, e(), f())) != null) {
            return dVar2;
        }
        this.f500i.d(com.airbnb.lottie.y0.g.j(dVar4.b(), dVar5.b(), f), com.airbnb.lottie.y0.g.j(dVar4.c(), dVar5.c(), f));
        return this.f500i;
    }
}
