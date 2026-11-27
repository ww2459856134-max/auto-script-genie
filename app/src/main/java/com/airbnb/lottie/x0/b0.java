package com.airbnb.lottie.x0;

import android.graphics.PointF;
import java.io.IOException;

/* loaded from: classes.dex */
abstract class b0 {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "p", "s", "r", "hd");

    static com.airbnb.lottie.v0.l.m a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        String strS = null;
        com.airbnb.lottie.v0.k.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.v0.k.f fVarI = null;
        com.airbnb.lottie.v0.k.b bVarE = null;
        boolean zN = false;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                mVarB = a.b(eVar, eVar2);
            } else if (iY == 2) {
                fVarI = d.i(eVar, eVar2);
            } else if (iY == 3) {
                bVarE = d.e(eVar, eVar2);
            } else if (iY != 4) {
                eVar.B();
            } else {
                zN = eVar.n();
            }
        }
        return new com.airbnb.lottie.v0.l.m(strS, mVarB, fVarI, bVarE, zN);
    }
}
