package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
abstract class h0 {
    static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "ind", "ks", "hd");

    static com.airbnb.lottie.v0.l.r a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        int iP = 0;
        String strS = null;
        com.airbnb.lottie.v0.k.h hVarK = null;
        boolean zN = false;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                iP = eVar.p();
            } else if (iY == 2) {
                hVarK = d.k(eVar, eVar2);
            } else if (iY != 3) {
                eVar.B();
            } else {
                zN = eVar.n();
            }
        }
        return new com.airbnb.lottie.v0.l.r(strS, iP, hVarK, zN);
    }
}
