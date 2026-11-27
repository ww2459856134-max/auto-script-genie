package com.airbnb.lottie.x0;

import android.graphics.Path;
import java.io.IOException;

/* loaded from: classes.dex */
abstract class f0 {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "c", "o", "fillEnabled", "r", "hd");

    static com.airbnb.lottie.v0.l.p a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        boolean zN = false;
        boolean zN2 = false;
        int iP = 1;
        String strS = null;
        com.airbnb.lottie.v0.k.a aVarC = null;
        com.airbnb.lottie.v0.k.d dVarH = null;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                aVarC = d.c(eVar, eVar2);
            } else if (iY == 2) {
                dVarH = d.h(eVar, eVar2);
            } else if (iY == 3) {
                zN = eVar.n();
            } else if (iY == 4) {
                iP = eVar.p();
            } else if (iY != 5) {
                eVar.z();
                eVar.B();
            } else {
                zN2 = eVar.n();
            }
        }
        return new com.airbnb.lottie.v0.l.p(strS, zN, iP == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarC, dVarH, zN2);
    }
}
