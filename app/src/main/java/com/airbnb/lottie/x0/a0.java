package com.airbnb.lottie.x0;

import android.graphics.PointF;
import java.io.IOException;

/* loaded from: classes.dex */
abstract class a0 {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    static com.airbnb.lottie.v0.l.l a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        boolean zN = false;
        String strS = null;
        com.airbnb.lottie.v0.l.k kVarA = null;
        com.airbnb.lottie.v0.k.b bVarF = null;
        com.airbnb.lottie.v0.k.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.v0.k.b bVarF2 = null;
        com.airbnb.lottie.v0.k.b bVarE = null;
        com.airbnb.lottie.v0.k.b bVarE2 = null;
        com.airbnb.lottie.v0.k.b bVarF3 = null;
        com.airbnb.lottie.v0.k.b bVarF4 = null;
        while (eVar.m()) {
            switch (eVar.y(a)) {
                case 0:
                    strS = eVar.s();
                    break;
                case 1:
                    kVarA = com.airbnb.lottie.v0.l.k.a(eVar.p());
                    break;
                case 2:
                    bVarF = d.f(eVar, eVar2, false);
                    break;
                case 3:
                    mVarB = a.b(eVar, eVar2);
                    break;
                case 4:
                    bVarF2 = d.f(eVar, eVar2, false);
                    break;
                case 5:
                    bVarE2 = d.e(eVar, eVar2);
                    break;
                case 6:
                    bVarF4 = d.f(eVar, eVar2, false);
                    break;
                case 7:
                    bVarE = d.e(eVar, eVar2);
                    break;
                case 8:
                    bVarF3 = d.f(eVar, eVar2, false);
                    break;
                case 9:
                    zN = eVar.n();
                    break;
                default:
                    eVar.z();
                    eVar.B();
                    break;
            }
        }
        return new com.airbnb.lottie.v0.l.l(strS, kVarA, bVarF, mVarB, bVarF2, bVarE, bVarE2, bVarF3, bVarF4, zN);
    }
}
