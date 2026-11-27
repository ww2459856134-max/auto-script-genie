package com.airbnb.lottie.x0;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class g0 {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "hd", "it");

    static com.airbnb.lottie.v0.l.q a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strS = null;
        boolean zN = false;
        while (eVar.m()) {
            int iY = eVar.y(a);
            if (iY == 0) {
                strS = eVar.s();
            } else if (iY == 1) {
                zN = eVar.n();
            } else if (iY != 2) {
                eVar.B();
            } else {
                eVar.c();
                while (eVar.m()) {
                    com.airbnb.lottie.v0.l.b bVarA = g.a(eVar, eVar2);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                eVar.f();
            }
        }
        return new com.airbnb.lottie.v0.l.q(strS, arrayList, zN);
    }
}
