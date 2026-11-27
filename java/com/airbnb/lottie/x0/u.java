package com.airbnb.lottie.x0;

import android.graphics.Rect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes.dex */
public abstract class u {
    private static final com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    static com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("id", "layers", "w", "h", "p", "u");
    private static final com.airbnb.lottie.x0.l0.c c = com.airbnb.lottie.x0.l0.c.a(XmlErrorCodes.LIST);
    private static final com.airbnb.lottie.x0.l0.c d = com.airbnb.lottie.x0.l0.c.a("cm", "tm", "dr");

    public static com.airbnb.lottie.e a(com.airbnb.lottie.x0.l0.e eVar) throws IOException {
        HashMap map;
        ArrayList arrayList;
        com.airbnb.lottie.x0.l0.e eVar2 = eVar;
        float fE = com.airbnb.lottie.y0.h.e();
        h.d.f<com.airbnb.lottie.v0.m.i> fVar = new h.d.f<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        h.d.j<com.airbnb.lottie.v0.e> jVar = new h.d.j<>();
        com.airbnb.lottie.e eVar3 = new com.airbnb.lottie.e();
        eVar.d();
        float fO = 0.0f;
        float fO2 = 0.0f;
        float fO3 = 0.0f;
        int iP = 0;
        int iP2 = 0;
        while (eVar.m()) {
            switch (eVar2.y(a)) {
                case 0:
                    iP = eVar.p();
                    break;
                case 1:
                    iP2 = eVar.p();
                    break;
                case 2:
                    fO = (float) eVar.o();
                    break;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fO2 = ((float) eVar.o()) - 0.01f;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fO3 = (float) eVar.o();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] strArrSplit = eVar.s().split("\\.");
                    if (!com.airbnb.lottie.y0.h.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        eVar3.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    e(eVar2, eVar3, arrayList2, fVar);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    b(eVar2, eVar3, map2, map3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    d(eVar2, map4);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    c(eVar2, eVar3, jVar);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    f(eVar2, eVar3, arrayList3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                default:
                    map = map4;
                    arrayList = arrayList3;
                    eVar.z();
                    eVar.B();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
            }
            eVar2 = eVar;
        }
        eVar3.r(new Rect(0, 0, (int) (iP * fE), (int) (iP2 * fE)), fO, fO2, fO3, arrayList2, fVar, map2, map3, jVar, map4, arrayList3);
        return eVar3;
    }

    private static void b(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2, Map<String, List<com.airbnb.lottie.v0.m.i>> map, Map<String, com.airbnb.lottie.f0> map2) throws IOException {
        eVar.c();
        while (eVar.m()) {
            ArrayList arrayList = new ArrayList();
            h.d.f fVar = new h.d.f();
            eVar.d();
            int iP = 0;
            int iP2 = 0;
            String strS = null;
            String strS2 = null;
            String strS3 = null;
            while (eVar.m()) {
                int iY = eVar.y(b);
                if (iY == 0) {
                    strS = eVar.s();
                } else if (iY == 1) {
                    eVar.c();
                    while (eVar.m()) {
                        com.airbnb.lottie.v0.m.i iVarB = t.b(eVar, eVar2);
                        fVar.j(iVarB.b(), iVarB);
                        arrayList.add(iVarB);
                    }
                    eVar.f();
                } else if (iY == 2) {
                    iP = eVar.p();
                } else if (iY == 3) {
                    iP2 = eVar.p();
                } else if (iY == 4) {
                    strS2 = eVar.s();
                } else if (iY != 5) {
                    eVar.z();
                    eVar.B();
                } else {
                    strS3 = eVar.s();
                }
            }
            eVar.i();
            if (strS2 != null) {
                com.airbnb.lottie.f0 f0Var = new com.airbnb.lottie.f0(iP, iP2, strS, strS2, strS3);
                map2.put(f0Var.d(), f0Var);
            } else {
                map.put(strS, arrayList);
            }
        }
        eVar.f();
    }

    private static void c(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2, h.d.j<com.airbnb.lottie.v0.e> jVar) throws IOException {
        eVar.c();
        while (eVar.m()) {
            com.airbnb.lottie.v0.e eVarA = j.a(eVar, eVar2);
            jVar.h(eVarA.hashCode(), eVarA);
        }
        eVar.f();
    }

    private static void d(com.airbnb.lottie.x0.l0.e eVar, Map<String, com.airbnb.lottie.v0.d> map) throws IOException {
        eVar.d();
        while (eVar.m()) {
            if (eVar.y(c) != 0) {
                eVar.z();
                eVar.B();
            } else {
                eVar.c();
                while (eVar.m()) {
                    com.airbnb.lottie.v0.d dVarA = k.a(eVar);
                    map.put(dVarA.b(), dVarA);
                }
                eVar.f();
            }
        }
        eVar.i();
    }

    private static void e(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2, List<com.airbnb.lottie.v0.m.i> list, h.d.f<com.airbnb.lottie.v0.m.i> fVar) throws IOException {
        eVar.c();
        int i2 = 0;
        while (eVar.m()) {
            com.airbnb.lottie.v0.m.i iVarB = t.b(eVar, eVar2);
            if (iVarB.d() == com.airbnb.lottie.v0.m.g.IMAGE) {
                i2++;
            }
            list.add(iVarB);
            fVar.j(iVarB.b(), iVarB);
            if (i2 > 4) {
                com.airbnb.lottie.y0.d.c("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        eVar.f();
    }

    private static void f(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2, List<com.airbnb.lottie.v0.i> list) throws IOException {
        eVar.c();
        while (eVar.m()) {
            String strS = null;
            eVar.d();
            float fO = 0.0f;
            float fO2 = 0.0f;
            while (eVar.m()) {
                int iY = eVar.y(d);
                if (iY == 0) {
                    strS = eVar.s();
                } else if (iY == 1) {
                    fO = (float) eVar.o();
                } else if (iY != 2) {
                    eVar.z();
                    eVar.B();
                } else {
                    fO2 = (float) eVar.o();
                }
            }
            eVar.i();
            list.add(new com.airbnb.lottie.v0.i(strS, fO, fO2));
        }
        eVar.f();
    }
}
