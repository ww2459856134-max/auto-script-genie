package com.airbnb.lottie.x0;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class n {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
    private static final com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("p", "k");
    private static final com.airbnb.lottie.x0.l0.c c = com.airbnb.lottie.x0.l0.c.a("n", "v");

    static com.airbnb.lottie.v0.l.e a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        com.airbnb.lottie.v0.k.c cVar;
        ArrayList arrayList = new ArrayList();
        float fO = 0.0f;
        String strS = null;
        com.airbnb.lottie.v0.l.f fVar = null;
        com.airbnb.lottie.v0.k.c cVarG = null;
        com.airbnb.lottie.v0.k.d dVarH = null;
        com.airbnb.lottie.v0.k.f fVarI = null;
        com.airbnb.lottie.v0.k.f fVarI2 = null;
        com.airbnb.lottie.v0.k.b bVarE = null;
        com.airbnb.lottie.v0.l.t tVar = null;
        com.airbnb.lottie.v0.l.u uVar = null;
        com.airbnb.lottie.v0.k.b bVar = null;
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
                        if (iY != 0) {
                            cVar = cVarG;
                            if (iY != 1) {
                                eVar.z();
                                eVar.B();
                            } else {
                                cVarG = d.g(eVar, eVar2, iP);
                            }
                        } else {
                            cVar = cVarG;
                            iP = eVar.p();
                        }
                        cVarG = cVar;
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
                    bVarE = d.e(eVar, eVar2);
                    break;
                case 7:
                    tVar = com.airbnb.lottie.v0.l.t.values()[eVar.p() - 1];
                    break;
                case 8:
                    uVar = com.airbnb.lottie.v0.l.u.values()[eVar.p() - 1];
                    break;
                case 9:
                    fO = (float) eVar.o();
                    break;
                case 10:
                    zN = eVar.n();
                    break;
                case 11:
                    eVar.c();
                    while (eVar.m()) {
                        eVar.d();
                        String strS2 = null;
                        com.airbnb.lottie.v0.k.b bVarE2 = null;
                        while (eVar.m()) {
                            int iY2 = eVar.y(c);
                            if (iY2 != 0) {
                                com.airbnb.lottie.v0.k.b bVar2 = bVar;
                                if (iY2 != 1) {
                                    eVar.z();
                                    eVar.B();
                                } else {
                                    bVarE2 = d.e(eVar, eVar2);
                                }
                                bVar = bVar2;
                            } else {
                                strS2 = eVar.s();
                            }
                        }
                        com.airbnb.lottie.v0.k.b bVar3 = bVar;
                        eVar.i();
                        if (strS2.equals("o")) {
                            bVar = bVarE2;
                        } else {
                            if (strS2.equals("d") || strS2.equals("g")) {
                                eVar2.t(true);
                                arrayList.add(bVarE2);
                            }
                            bVar = bVar3;
                        }
                    }
                    com.airbnb.lottie.v0.k.b bVar4 = bVar;
                    eVar.f();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar = bVar4;
                    break;
                default:
                    eVar.z();
                    eVar.B();
                    break;
            }
        }
        return new com.airbnb.lottie.v0.l.e(strS, fVar, cVarG, dVarH, fVarI, fVarI2, bVarE, tVar, uVar, fO, arrayList, bVar, zN);
    }
}
