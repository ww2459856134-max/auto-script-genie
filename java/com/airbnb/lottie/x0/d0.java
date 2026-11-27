package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
public class d0 implements k0<com.airbnb.lottie.z0.d> {
    public static final d0 a = new d0();

    private d0() {
    }

    @Override // com.airbnb.lottie.x0.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.z0.d a(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        boolean z = eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY;
        if (z) {
            eVar.c();
        }
        float fO = (float) eVar.o();
        float fO2 = (float) eVar.o();
        while (eVar.m()) {
            eVar.B();
        }
        if (z) {
            eVar.f();
        }
        return new com.airbnb.lottie.z0.d((fO / 100.0f) * f, (fO2 / 100.0f) * f);
    }
}
