package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
abstract class k {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("fFamily", "fName", "fStyle", "ascent");

    static com.airbnb.lottie.v0.d a(com.airbnb.lottie.x0.l0.e eVar) throws IOException {
        eVar.d();
        String strS = null;
        String strS2 = null;
        float fO = 0.0f;
        String strS3 = null;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                strS3 = eVar.s();
            } else if (iY == 2) {
                strS2 = eVar.s();
            } else if (iY != 3) {
                eVar.z();
                eVar.B();
            } else {
                fO = (float) eVar.o();
            }
        }
        eVar.i();
        return new com.airbnb.lottie.v0.d(strS, strS3, strS2, fO);
    }
}
