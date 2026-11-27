package com.airbnb.lottie.x0;

import android.graphics.PointF;
import java.io.IOException;

/* loaded from: classes.dex */
abstract class e {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "p", "s", "hd", "d");

    static com.airbnb.lottie.v0.l.a a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2, int i2) throws IOException {
        boolean z = i2 == 3;
        boolean zN = false;
        String strS = null;
        com.airbnb.lottie.v0.k.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.v0.k.f fVarI = null;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                mVarB = a.b(eVar, eVar2);
            } else if (iY == 2) {
                fVarI = d.i(eVar, eVar2);
            } else if (iY == 3) {
                zN = eVar.n();
            } else if (iY != 4) {
                eVar.z();
                eVar.B();
            } else {
                z = eVar.p() == 3;
            }
        }
        return new com.airbnb.lottie.v0.l.a(strS, mVarB, fVarI, z, zN);
    }
}
