package com.airbnb.lottie.x0;

import android.graphics.PointF;
import java.io.IOException;

/* loaded from: classes.dex */
public class z implements k0<PointF> {
    public static final z a = new z();

    private z() {
    }

    @Override // com.airbnb.lottie.x0.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        com.airbnb.lottie.x0.l0.d dVarW = eVar.w();
        if (dVarW == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY) {
            return q.e(eVar, f);
        }
        if (dVarW == com.airbnb.lottie.x0.l0.d.BEGIN_OBJECT) {
            return q.e(eVar, f);
        }
        if (dVarW == com.airbnb.lottie.x0.l0.d.NUMBER) {
            PointF pointF = new PointF(((float) eVar.o()) * f, ((float) eVar.o()) * f);
            while (eVar.m()) {
                eVar.B();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + dVarW);
    }
}
