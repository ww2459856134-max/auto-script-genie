package com.airbnb.lottie.x0;

import android.graphics.Color;
import android.graphics.Rect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public abstract class t {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");
    private static final com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("d", "a");
    private static final com.airbnb.lottie.x0.l0.c c = com.airbnb.lottie.x0.l0.c.a("nm");

    public static com.airbnb.lottie.v0.m.i a(com.airbnb.lottie.e eVar) {
        Rect rectB = eVar.b();
        return new com.airbnb.lottie.v0.m.i(Collections.emptyList(), eVar, "__container", -1L, com.airbnb.lottie.v0.m.g.PRE_COMP, -1L, null, Collections.emptyList(), new com.airbnb.lottie.v0.k.l(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), com.airbnb.lottie.v0.m.h.NONE, null, false);
    }

    public static com.airbnb.lottie.v0.m.i b(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f;
        com.airbnb.lottie.v0.m.h hVar = com.airbnb.lottie.v0.m.h.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        eVar.d();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        com.airbnb.lottie.v0.m.h hVar2 = hVar;
        float fO = 1.0f;
        int iP = 0;
        int iP2 = 0;
        int color = 0;
        int iP3 = 0;
        int iP4 = 0;
        boolean zN = false;
        com.airbnb.lottie.v0.m.g gVar = null;
        String strS = null;
        com.airbnb.lottie.v0.k.l lVarG = null;
        com.airbnb.lottie.v0.k.j jVarD = null;
        com.airbnb.lottie.v0.k.k kVarA = null;
        com.airbnb.lottie.v0.k.b bVarF = null;
        float fO2 = 0.0f;
        float fO3 = 0.0f;
        float fO4 = 0.0f;
        long jP = -1;
        long jP2 = 0;
        String strS2 = null;
        String strS3 = "UNSET";
        while (eVar.m()) {
            switch (eVar.y(a)) {
                case 0:
                    strS3 = eVar.s();
                    break;
                case 1:
                    jP2 = eVar.p();
                    break;
                case 2:
                    strS = eVar.s();
                    break;
                case 3:
                    int iP5 = eVar.p();
                    gVar = com.airbnb.lottie.v0.m.g.UNKNOWN;
                    if (iP5 >= gVar.ordinal()) {
                        break;
                    } else {
                        gVar = com.airbnb.lottie.v0.m.g.values()[iP5];
                        break;
                    }
                case 4:
                    jP = eVar.p();
                    break;
                case 5:
                    iP = (int) (eVar.p() * com.airbnb.lottie.y0.h.e());
                    break;
                case 6:
                    iP2 = (int) (eVar.p() * com.airbnb.lottie.y0.h.e());
                    break;
                case 7:
                    color = Color.parseColor(eVar.s());
                    break;
                case 8:
                    lVarG = c.g(eVar, eVar2);
                    break;
                case 9:
                    hVar2 = com.airbnb.lottie.v0.m.h.values()[eVar.p()];
                    eVar2.q(1);
                    break;
                case 10:
                    eVar.c();
                    while (eVar.m()) {
                        arrayList3.add(v.a(eVar, eVar2));
                    }
                    eVar2.q(arrayList3.size());
                    eVar.f();
                    break;
                case 11:
                    eVar.c();
                    while (eVar.m()) {
                        com.airbnb.lottie.v0.l.b bVarA = g.a(eVar, eVar2);
                        if (bVarA != null) {
                            arrayList4.add(bVarA);
                        }
                    }
                    eVar.f();
                    break;
                case 12:
                    eVar.d();
                    while (eVar.m()) {
                        int iY = eVar.y(b);
                        if (iY == 0) {
                            jVarD = d.d(eVar, eVar2);
                        } else if (iY != 1) {
                            eVar.z();
                            eVar.B();
                        } else {
                            eVar.c();
                            if (eVar.m()) {
                                kVarA = b.a(eVar, eVar2);
                            }
                            while (eVar.m()) {
                                eVar.B();
                            }
                            eVar.f();
                        }
                    }
                    eVar.i();
                    break;
                case 13:
                    eVar.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (eVar.m()) {
                        eVar.d();
                        while (eVar.m()) {
                            if (eVar.y(c) != 0) {
                                eVar.z();
                                eVar.B();
                            } else {
                                arrayList5.add(eVar.s());
                            }
                        }
                        eVar.i();
                    }
                    eVar.f();
                    eVar2.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    fO = (float) eVar.o();
                    break;
                case 15:
                    fO4 = (float) eVar.o();
                    break;
                case 16:
                    iP3 = (int) (eVar.p() * com.airbnb.lottie.y0.h.e());
                    break;
                case 17:
                    iP4 = (int) (eVar.p() * com.airbnb.lottie.y0.h.e());
                    break;
                case 18:
                    fO2 = (float) eVar.o();
                    break;
                case 19:
                    fO3 = (float) eVar.o();
                    break;
                case 20:
                    bVarF = d.f(eVar, eVar2, false);
                    break;
                case 21:
                    strS2 = eVar.s();
                    break;
                case 22:
                    zN = eVar.n();
                    break;
                default:
                    eVar.z();
                    eVar.B();
                    break;
            }
        }
        eVar.i();
        float f2 = fO2 / fO;
        float f3 = fO3 / fO;
        ArrayList arrayList6 = new ArrayList();
        if (f2 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new com.airbnb.lottie.z0.a(eVar2, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f2)));
            f = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f = 0.0f;
        }
        if (f3 <= f) {
            f3 = eVar2.f();
        }
        arrayList2.add(new com.airbnb.lottie.z0.a(eVar2, fValueOf, fValueOf, null, f2, Float.valueOf(f3)));
        arrayList2.add(new com.airbnb.lottie.z0.a(eVar2, fValueOf2, fValueOf2, null, f3, Float.valueOf(Float.MAX_VALUE)));
        if (strS3.endsWith(".ai") || "ai".equals(strS2)) {
            eVar2.a("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.v0.m.i(arrayList4, eVar2, strS3, jP2, gVar, jP, strS, arrayList, lVarG, iP, iP2, color, fO, fO4, iP3, iP4, jVarD, kVarA, arrayList2, hVar2, bVarF, zN);
    }
}
