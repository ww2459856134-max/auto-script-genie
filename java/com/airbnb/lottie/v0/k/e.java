package com.airbnb.lottie.v0.k;

import android.graphics.PointF;
import com.airbnb.lottie.t0.c.o;
import com.airbnb.lottie.t0.c.p;
import java.util.List;

/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.z0.a<PointF>> a;

    public e(List<com.airbnb.lottie.z0.a<PointF>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.v0.k.m
    public com.airbnb.lottie.t0.c.g<PointF, PointF> a() {
        return this.a.get(0).h() ? new p(this.a) : new o(this.a);
    }

    @Override // com.airbnb.lottie.v0.k.m
    public List<com.airbnb.lottie.z0.a<PointF>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v0.k.m
    public boolean c() {
        return this.a.size() == 1 && this.a.get(0).h();
    }
}
