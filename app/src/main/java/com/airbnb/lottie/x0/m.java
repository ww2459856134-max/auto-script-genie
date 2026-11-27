package com.airbnb.lottie.x0;

import android.graphics.Path;
import java.io.IOException;

/* loaded from: classes.dex */
abstract class m {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "g", "o", "t", "s", "e", "r", "hd");
    private static final com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("p", "k");

    static com.airbnb.lottie.v0.l.d a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        Path.FillType fillType = Path.FillType.WINDING;
        String strS = null;
        com.airbnb.lottie.v0.l.f fVar = null;
        com.airbnb.lottie.v0.k.c cVarG = null;
        com.airbnb.lottie.v0.k.d dVarH = null;
        com.airbnb.lottie.v0.k.f fVarI = null;
        com.airbnb.lottie.v0.k.f fVarI2 = null;
        boolean zN = false;
        while (eVar.m()) {
            switch (eVar.y(a)) {
                case 0:
                    strS = eVar.s();
                    break;
                case 1:
                    int iP = -1;
                    eVar.d();
                    while (eVar.m()) {
                        int iY = eVar.y(b);
                        if (iY == 0) {
                            iP = eVar.p();
                        } else if (iY != 1) {
                            eVar.z();
                            eVar.B();
                        } else {
                            cVarG = d.g(eVar, eVar2, iP);
                        }
                    }
                    eVar.i();
                    break;
                case 2:
                    dVarH = d.h(eVar, eVar2);
                    break;
                case 3:
                    fVar = eVar.p() == 1 ? com.airbnb.lottie.v0.l.f.LINEAR : com.airbnb.lottie.v0.l.f.RADIAL;
                    break;
                case 4:
                    fVarI = d.i(eVar, eVar2);
                    break;
                case 5:
                    fVarI2 = d.i(eVar, eVar2);
                    break;
                case 6:
                    fillType = eVar.p() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zN = eVar.n();
                    break;
                default:
                    eVar.z();
                    eVar.B();
                    break;
            }
        }
        return new com.airbnb.lottie.v0.l.d(strS, fVar, fillType, cVarG, dVarH, fVarI, fVarI2, null, null, zN);
    }
}
