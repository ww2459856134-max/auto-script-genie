package com.airbnb.lottie.t0.c;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: classes.dex */
public class s extends g<PointF, PointF> {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f503i;

    /* renamed from: j, reason: collision with root package name */
    private final g<Float, Float> f504j;

    /* renamed from: k, reason: collision with root package name */
    private final g<Float, Float> f505k;

    public s(g<Float, Float> gVar, g<Float, Float> gVar2) {
        super(Collections.emptyList());
        this.f503i = new PointF();
        this.f504j = gVar;
        this.f505k = gVar2;
        l(f());
    }

    @Override // com.airbnb.lottie.t0.c.g
    public void l(float f) {
        this.f504j.l(f);
        this.f505k.l(f);
        this.f503i.set(this.f504j.h().floatValue(), this.f505k.h().floatValue());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).d();
        }
    }

    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t0.c.g
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(com.airbnb.lottie.z0.a<PointF> aVar, float f) {
        return this.f503i;
    }
}
