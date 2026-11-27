package com.airbnb.lottie.x0;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("a");
    private static com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("fc", "sc", "sw", "t");

    public static com.airbnb.lottie.v0.k.k a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        eVar.d();
        com.airbnb.lottie.v0.k.k kVarB = null;
        while (eVar.m()) {
            if (eVar.y(a) != 0) {
                eVar.z();
                eVar.B();
            } else {
                kVarB = b(eVar, eVar2);
            }
        }
        eVar.i();
        return kVarB == null ? new com.airbnb.lottie.v0.k.k(null, null, null, null) : kVarB;
    }

    private static com.airbnb.lottie.v0.k.k b(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        eVar.d();
        com.airbnb.lottie.v0.k.a aVarC = null;
        com.airbnb.lottie.v0.k.a aVarC2 = null;
        com.airbnb.lottie.v0.k.b bVarE = null;
        com.airbnb.lottie.v0.k.b bVarE2 = null;
        while (eVar.m()) {
            int iY = eVar.y(b);
            if (iY == 0) {
                aVarC = d.c(eVar, eVar2);
            } else if (iY == 1) {
                aVarC2 = d.c(eVar, eVar2);
            } else if (iY == 2) {
                bVarE = d.e(eVar, eVar2);
            } else if (iY != 3) {
                eVar.z();
                eVar.B();
            } else {
                bVarE2 = d.e(eVar, eVar2);
            }
        }
        eVar.i();
        return new com.airbnb.lottie.v0.k.k(aVarC, aVarC2, bVarE, bVarE2);
    }
}
