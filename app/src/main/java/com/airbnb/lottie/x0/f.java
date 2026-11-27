package com.airbnb.lottie.x0;

import android.graphics.Color;
import java.io.IOException;

/* loaded from: classes.dex */
public class f implements k0<Integer> {
    public static final f a = new f();

    private f() {
    }

    @Override // com.airbnb.lottie.x0.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        boolean z = eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY;
        if (z) {
            eVar.c();
        }
        double dO = eVar.o();
        double dO2 = eVar.o();
        double dO3 = eVar.o();
        double dO4 = eVar.o();
        if (z) {
            eVar.f();
        }
        if (dO <= 1.0d && dO2 <= 1.0d && dO3 <= 1.0d) {
            dO *= 255.0d;
            dO2 *= 255.0d;
            dO3 *= 255.0d;
            if (dO4 <= 1.0d) {
                dO4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dO4, (int) dO, (int) dO2, (int) dO3));
    }
}
