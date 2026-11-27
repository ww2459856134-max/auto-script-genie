package com.airbnb.lottie.x0;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class i0 {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
    private static final com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("n", "v");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.airbnb.lottie.v0.l.v a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        com.airbnb.lottie.v0.k.b bVarE;
        ArrayList arrayList = new ArrayList();
        boolean zN = false;
        float fO = 0.0f;
        String strS = null;
        com.airbnb.lottie.v0.k.b bVar = null;
        com.airbnb.lottie.v0.k.a aVarC = null;
        com.airbnb.lottie.v0.k.d dVarH = null;
        com.airbnb.lottie.v0.k.b bVarE2 = null;
        com.airbnb.lottie.v0.l.t tVar = null;
        com.airbnb.lottie.v0.l.u uVar = null;
        while (eVar.m()) {
            switch (eVar.y(a)) {
                case 0:
                    strS = eVar.s();
                    break;
                case 1:
                    aVarC = d.c(eVar, eVar2);
                    break;
                case 2:
                    bVarE2 = d.e(eVar, eVar2);
                    break;
                case 3:
                    dVarH = d.h(eVar, eVar2);
                    break;
                case 4:
                    tVar = com.airbnb.lottie.v0.l.t.values()[eVar.p() - 1];
                    break;
                case 5:
                    uVar = com.airbnb.lottie.v0.l.u.values()[eVar.p() - 1];
                    break;
                case 6:
                    fO = (float) eVar.o();
                    break;
                case 7:
                    zN = eVar.n();
                    break;
                case 8:
                    eVar.c();
                    while (eVar.m()) {
                        eVar.d();
                        String strS2 = null;
                        bVarE = null;
                        while (eVar.m()) {
                            int iY = eVar.y(b);
                            if (iY == 0) {
                                strS2 = eVar.s();
                            } else if (iY != 1) {
                                eVar.z();
                                eVar.B();
                            } else {
                                bVarE = d.e(eVar, eVar2);
                            }
                        }
                        eVar.i();
                        strS2.hashCode();
                        switch (strS2) {
                            case "d":
                            case "g":
                                eVar2.t(true);
                                arrayList.add(bVarE);
                                break;
                            case "o":
                                bVar = bVarE;
                                break;
                        }
                    }
                    eVar.f();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    eVar.B();
                    break;
            }
        }
        return new com.airbnb.lottie.v0.l.v(strS, bVar, arrayList, aVarC, dVarH, bVarE2, tVar, uVar, fO, zN);
    }
}
