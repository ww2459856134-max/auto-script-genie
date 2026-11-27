package com.airbnb.lottie.x0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("k", "x", "y");

    public static com.airbnb.lottie.v0.k.e a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY) {
            eVar.c();
            while (eVar.m()) {
                arrayList.add(x.a(eVar, eVar2));
            }
            eVar.f();
            s.b(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.z0.a(q.e(eVar, com.airbnb.lottie.y0.h.e())));
        }
        return new com.airbnb.lottie.v0.k.e(arrayList);
    }

    static com.airbnb.lottie.v0.k.m<PointF, PointF> b(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        eVar.d();
        com.airbnb.lottie.v0.k.e eVarA = null;
        com.airbnb.lottie.v0.k.b bVarE = null;
        boolean z = false;
        com.airbnb.lottie.v0.k.b bVarE2 = null;
        while (eVar.w() != com.airbnb.lottie.x0.l0.d.END_OBJECT) {
            int iY = eVar.y(a);
            if (iY == 0) {
                eVarA = a(eVar, eVar2);
            } else if (iY != 1) {
                if (iY != 2) {
                    eVar.z();
                    eVar.B();
                } else if (eVar.w() == com.airbnb.lottie.x0.l0.d.STRING) {
                    eVar.B();
                    z = true;
                } else {
                    bVarE = d.e(eVar, eVar2);
                }
            } else if (eVar.w() == com.airbnb.lottie.x0.l0.d.STRING) {
                eVar.B();
                z = true;
            } else {
                bVarE2 = d.e(eVar, eVar2);
            }
        }
        eVar.i();
        if (z) {
            eVar2.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new com.airbnb.lottie.v0.k.i(bVarE2, bVarE);
    }
}
