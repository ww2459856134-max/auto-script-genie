package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
abstract class j0 {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("s", "e", "o", "nm", "m", "hd");

    static com.airbnb.lottie.v0.l.x a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        boolean zN = false;
        String strS = null;
        com.airbnb.lottie.v0.l.w wVarA = null;
        com.airbnb.lottie.v0.k.b bVarF = null;
        com.airbnb.lottie.v0.k.b bVarF2 = null;
        com.airbnb.lottie.v0.k.b bVarF3 = null;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                bVarF = d.f(eVar, eVar2, false);
            } else if (iY == 1) {
                bVarF2 = d.f(eVar, eVar2, false);
            } else if (iY == 2) {
                bVarF3 = d.f(eVar, eVar2, false);
            } else if (iY == 3) {
                strS = eVar.s();
            } else if (iY == 4) {
                wVarA = com.airbnb.lottie.v0.l.w.a(eVar.p());
            } else if (iY != 5) {
                eVar.B();
            } else {
                zN = eVar.n();
            }
        }
        return new com.airbnb.lottie.v0.l.x(strS, wVarA, bVarF, bVarF2, bVarF3, zN);
    }
}
