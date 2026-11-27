package com.airbnb.lottie.t0.c;

import java.util.List;

/* loaded from: classes.dex */
public class j extends l<com.airbnb.lottie.v0.l.c> {

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.v0.l.c f493i;

    public j(List<com.airbnb.lottie.z0.a<com.airbnb.lottie.v0.l.c>> list) {
        super(list);
        com.airbnb.lottie.v0.l.c cVar = list.get(0).b;
        int iC = cVar != null ? cVar.c() : 0;
        this.f493i = new com.airbnb.lottie.v0.l.c(new float[iC], new int[iC]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.v0.l.c i(com.airbnb.lottie.z0.a<com.airbnb.lottie.v0.l.c> aVar, float f) {
        this.f493i.d(aVar.b, aVar.c, f);
        return this.f493i;
    }
}
