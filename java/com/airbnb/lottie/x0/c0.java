package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
abstract class c0 {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "c", "o", "tr", "hd");

    static com.airbnb.lottie.v0.l.n a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        boolean zN = false;
        String strS = null;
        com.airbnb.lottie.v0.k.b bVarF = null;
        com.airbnb.lottie.v0.k.b bVarF2 = null;
        com.airbnb.lottie.v0.k.l lVarG = null;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                bVarF = d.f(eVar, eVar2, false);
            } else if (iY == 2) {
                bVarF2 = d.f(eVar, eVar2, false);
            } else if (iY == 3) {
                lVarG = c.g(eVar, eVar2);
            } else if (iY != 4) {
                eVar.B();
            } else {
                zN = eVar.n();
            }
        }
        return new com.airbnb.lottie.v0.l.n(strS, bVarF, bVarF2, lVarG, zN);
    }
}
