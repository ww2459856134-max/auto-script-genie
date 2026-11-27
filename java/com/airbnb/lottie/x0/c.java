package com.airbnb.lottie.x0;

import android.graphics.PointF;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class c {
    private static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
    private static com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("k");

    private static boolean a(com.airbnb.lottie.v0.k.e eVar) {
        return eVar == null || (eVar.c() && eVar.b().get(0).b.equals(0.0f, 0.0f));
    }

    private static boolean b(com.airbnb.lottie.v0.k.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof com.airbnb.lottie.v0.k.i) && mVar.c() && mVar.b().get(0).b.equals(0.0f, 0.0f));
    }

    private static boolean c(com.airbnb.lottie.v0.k.b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).b.floatValue() == 0.0f);
    }

    private static boolean d(com.airbnb.lottie.v0.k.g gVar) {
        return gVar == null || (gVar.c() && gVar.b().get(0).b.a(1.0f, 1.0f));
    }

    private static boolean e(com.airbnb.lottie.v0.k.b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).b.floatValue() == 0.0f);
    }

    private static boolean f(com.airbnb.lottie.v0.k.b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).b.floatValue() == 0.0f);
    }

    public static com.airbnb.lottie.v0.k.l g(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        boolean z;
        boolean z2 = false;
        boolean z3 = eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_OBJECT;
        if (z3) {
            eVar.d();
        }
        com.airbnb.lottie.v0.k.b bVar = null;
        com.airbnb.lottie.v0.k.e eVarA = null;
        com.airbnb.lottie.v0.k.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.v0.k.g gVarJ = null;
        com.airbnb.lottie.v0.k.b bVarF = null;
        com.airbnb.lottie.v0.k.b bVarF2 = null;
        com.airbnb.lottie.v0.k.d dVarH = null;
        com.airbnb.lottie.v0.k.b bVarF3 = null;
        com.airbnb.lottie.v0.k.b bVarF4 = null;
        while (eVar.m()) {
            switch (eVar.y(a)) {
                case 0:
                    boolean z4 = z2;
                    eVar.d();
                    while (eVar.m()) {
                        if (eVar.y(b) != 0) {
                            eVar.z();
                            eVar.B();
                        } else {
                            eVarA = a.a(eVar, eVar2);
                        }
                    }
                    eVar.i();
                    z2 = z4;
                    continue;
                case 1:
                    mVarB = a.b(eVar, eVar2);
                    continue;
                case 2:
                    gVarJ = d.j(eVar, eVar2);
                    continue;
                case 3:
                    eVar2.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVarH = d.h(eVar, eVar2);
                    continue;
                case 6:
                    bVarF3 = d.f(eVar, eVar2, z2);
                    continue;
                case 7:
                    bVarF4 = d.f(eVar, eVar2, z2);
                    continue;
                case 8:
                    bVarF = d.f(eVar, eVar2, z2);
                    continue;
                case 9:
                    bVarF2 = d.f(eVar, eVar2, z2);
                    continue;
                default:
                    eVar.z();
                    eVar.B();
                    continue;
            }
            com.airbnb.lottie.v0.k.b bVarF5 = d.f(eVar, eVar2, z2);
            if (bVarF5.b().isEmpty()) {
                bVarF5.b().add(new com.airbnb.lottie.z0.a<>(eVar2, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(eVar2.f())));
            } else {
                if (bVarF5.b().get(0).b == null) {
                    z = false;
                    bVarF5.b().set(0, new com.airbnb.lottie.z0.a<>(eVar2, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(eVar2.f())));
                }
                z2 = z;
                bVar = bVarF5;
            }
            z = false;
            z2 = z;
            bVar = bVarF5;
        }
        if (z3) {
            eVar.i();
        }
        com.airbnb.lottie.v0.k.e eVar3 = a(eVarA) ? null : eVarA;
        com.airbnb.lottie.v0.k.m<PointF, PointF> mVar = b(mVarB) ? null : mVarB;
        com.airbnb.lottie.v0.k.b bVar2 = c(bVar) ? null : bVar;
        if (d(gVarJ)) {
            gVarJ = null;
        }
        return new com.airbnb.lottie.v0.k.l(eVar3, mVar, gVarJ, bVar2, dVarH, bVarF3, bVarF4, f(bVarF) ? null : bVarF, e(bVarF2) ? null : bVarF2);
    }
}
