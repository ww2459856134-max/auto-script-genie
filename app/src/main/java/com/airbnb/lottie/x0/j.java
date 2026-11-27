package com.airbnb.lottie.x0;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class j {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("ch", "size", "w", "style", "fFamily", "data");
    private static final com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("shapes");

    static com.airbnb.lottie.v0.e a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        ArrayList arrayList = new ArrayList();
        eVar.d();
        String strS = null;
        String strS2 = null;
        double dO = 0.0d;
        double dO2 = 0.0d;
        char cCharAt = 0;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                cCharAt = eVar.s().charAt(0);
            } else if (iY == 1) {
                dO = eVar.o();
            } else if (iY == 2) {
                dO2 = eVar.o();
            } else if (iY == 3) {
                strS = eVar.s();
            } else if (iY == 4) {
                strS2 = eVar.s();
            } else if (iY != 5) {
                eVar.z();
                eVar.B();
            } else {
                eVar.d();
                while (eVar.m()) {
                    if (eVar.y(b) != 0) {
                        eVar.z();
                        eVar.B();
                    } else {
                        eVar.c();
                        while (eVar.m()) {
                            arrayList.add((com.airbnb.lottie.v0.l.q) g.a(eVar, eVar2));
                        }
                        eVar.f();
                    }
                }
                eVar.i();
            }
        }
        eVar.i();
        return new com.airbnb.lottie.v0.e(arrayList, cCharAt, dO, dO2, strS, strS2);
    }
}
