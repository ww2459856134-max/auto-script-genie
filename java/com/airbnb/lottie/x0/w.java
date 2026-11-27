package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
abstract class w {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "mm", "hd");

    static com.airbnb.lottie.v0.l.j a(com.airbnb.lottie.x0.l0.e eVar) throws IOException {
        String strS = null;
        boolean zN = false;
        com.airbnb.lottie.v0.l.i iVarA = null;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                iVarA = com.airbnb.lottie.v0.l.i.a(eVar.p());
            } else if (iY != 2) {
                eVar.z();
                eVar.B();
            } else {
                zN = eVar.n();
            }
        }
        return new com.airbnb.lottie.v0.l.j(strS, iVarA, zN);
    }
}
