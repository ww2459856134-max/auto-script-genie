package com.airbnb.lottie.t0.c;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: classes.dex */
public class n extends com.airbnb.lottie.z0.a<PointF> {

    /* renamed from: o, reason: collision with root package name */
    private Path f494o;
    private final com.airbnb.lottie.z0.a<PointF> p;

    public n(com.airbnb.lottie.e eVar, com.airbnb.lottie.z0.a<PointF> aVar) {
        super(eVar, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f);
        this.p = aVar;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        T t;
        T t2 = this.c;
        boolean z = (t2 == 0 || (t = this.b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.c;
        if (t3 == 0 || z) {
            return;
        }
        com.airbnb.lottie.z0.a<PointF> aVar = this.p;
        this.f494o = com.airbnb.lottie.y0.h.d((PointF) this.b, (PointF) t3, aVar.f570m, aVar.f571n);
    }

    Path j() {
        return this.f494o;
    }
}
