package com.airbnb.lottie.v0.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.e0;
import com.airbnb.lottie.v0.l.q;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class k extends c {
    private final com.airbnb.lottie.t0.b.f x;

    k(e0 e0Var, i iVar) {
        super(e0Var, iVar);
        com.airbnb.lottie.t0.b.f fVar = new com.airbnb.lottie.t0.b.f(e0Var, this, new q("__container", iVar.l(), false));
        this.x = fVar;
        fVar.e(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.v0.m.c
    protected void D(com.airbnb.lottie.v0.f fVar, int i2, List<com.airbnb.lottie.v0.f> list, com.airbnb.lottie.v0.f fVar2) {
        this.x.g(fVar, i2, list, fVar2);
    }

    @Override // com.airbnb.lottie.v0.m.c, com.airbnb.lottie.t0.b.g
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.x.a(rectF, this.f539m, z);
    }

    @Override // com.airbnb.lottie.v0.m.c
    void t(Canvas canvas, Matrix matrix, int i2) {
        this.x.c(canvas, matrix, i2);
    }
}
