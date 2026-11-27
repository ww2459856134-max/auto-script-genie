package com.airbnb.lottie.t0.c;

import android.graphics.Path;
import java.util.List;

/* loaded from: classes.dex */
public class r extends g<com.airbnb.lottie.v0.l.o, Path> {

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.v0.l.o f501i;

    /* renamed from: j, reason: collision with root package name */
    private final Path f502j;

    public r(List<com.airbnb.lottie.z0.a<com.airbnb.lottie.v0.l.o>> list) {
        super(list);
        this.f501i = new com.airbnb.lottie.v0.l.o();
        this.f502j = new Path();
    }

    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Path i(com.airbnb.lottie.z0.a<com.airbnb.lottie.v0.l.o> aVar, float f) {
        this.f501i.c(aVar.b, aVar.c, f);
        com.airbnb.lottie.y0.g.h(this.f501i, this.f502j);
        return this.f502j;
    }
}
