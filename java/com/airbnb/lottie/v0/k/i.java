package com.airbnb.lottie.v0.k;

import android.graphics.PointF;
import com.airbnb.lottie.t0.c.s;
import java.util.List;

/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {
    private final b a;
    private final b b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // com.airbnb.lottie.v0.k.m
    public com.airbnb.lottie.t0.c.g<PointF, PointF> a() {
        return new s(this.a.a(), this.b.a());
    }

    @Override // com.airbnb.lottie.v0.k.m
    public List<com.airbnb.lottie.z0.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.v0.k.m
    public boolean c() {
        return this.a.c() && this.b.c();
    }
}
