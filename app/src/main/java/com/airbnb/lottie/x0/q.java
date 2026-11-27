package com.airbnb.lottie.x0;

import android.graphics.Color;
import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class q {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("x", "y");

    private static PointF a(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        eVar.c();
        float fO = (float) eVar.o();
        float fO2 = (float) eVar.o();
        while (eVar.w() != com.airbnb.lottie.x0.l0.d.END_ARRAY) {
            eVar.B();
        }
        eVar.f();
        return new PointF(fO * f, fO2 * f);
    }

    private static PointF b(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        float fO = (float) eVar.o();
        float fO2 = (float) eVar.o();
        while (eVar.m()) {
            eVar.B();
        }
        return new PointF(fO * f, fO2 * f);
    }

    private static PointF c(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        eVar.d();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                fG = g(eVar);
            } else if (iY != 1) {
                eVar.z();
                eVar.B();
            } else {
                fG2 = g(eVar);
            }
        }
        eVar.i();
        return new PointF(fG * f, fG2 * f);
    }

    static int d(com.airbnb.lottie.x0.l0.e eVar) throws IOException {
        eVar.c();
        int iO = (int) (eVar.o() * 255.0d);
        int iO2 = (int) (eVar.o() * 255.0d);
        int iO3 = (int) (eVar.o() * 255.0d);
        while (eVar.m()) {
            eVar.B();
        }
        eVar.f();
        return Color.argb(255, iO, iO2, iO3);
    }

    static PointF e(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        int i2 = p.a[eVar.w().ordinal()];
        if (i2 == 1) {
            return b(eVar, f);
        }
        if (i2 == 2) {
            return a(eVar, f);
        }
        if (i2 == 3) {
            return c(eVar, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + eVar.w());
    }

    static List<PointF> f(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        eVar.c();
        while (eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY) {
            eVar.c();
            arrayList.add(e(eVar, f));
            eVar.f();
        }
        eVar.f();
        return arrayList;
    }

    static float g(com.airbnb.lottie.x0.l0.e eVar) throws IOException {
        com.airbnb.lottie.x0.l0.d dVarW = eVar.w();
        int i2 = p.a[dVarW.ordinal()];
        if (i2 == 1) {
            return (float) eVar.o();
        }
        if (i2 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + dVarW);
        }
        eVar.c();
        float fO = (float) eVar.o();
        while (eVar.m()) {
            eVar.B();
        }
        eVar.f();
        return fO;
    }
}
