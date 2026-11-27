package com.airbnb.lottie.x0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class s {
    static com.airbnb.lottie.x0.l0.c a = com.airbnb.lottie.x0.l0.c.a("k");

    static <T> List<com.airbnb.lottie.z0.a<T>> a(com.airbnb.lottie.x0.l0.e eVar, com.airbnb.lottie.e eVar2, float f, k0<T> k0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (eVar.w() == com.airbnb.lottie.x0.l0.d.STRING) {
            eVar2.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        eVar.d();
        while (eVar.m()) {
            if (eVar.y(a) != 0) {
                eVar.B();
            } else if (eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY) {
                eVar.c();
                if (eVar.w() == com.airbnb.lottie.x0.l0.d.NUMBER) {
                    arrayList.add(r.b(eVar, eVar2, f, k0Var, false));
                } else {
                    while (eVar.m()) {
                        arrayList.add(r.b(eVar, eVar2, f, k0Var, true));
                    }
                }
                eVar.f();
            } else {
                arrayList.add(r.b(eVar, eVar2, f, k0Var, false));
            }
        }
        eVar.i();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends com.airbnb.lottie.z0.a<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            com.airbnb.lottie.z0.a<T> aVar = list.get(i3);
            i3++;
            com.airbnb.lottie.z0.a<T> aVar2 = list.get(i3);
            aVar.f = Float.valueOf(aVar2.e);
            if (aVar.c == null && (t = aVar2.b) != null) {
                aVar.c = t;
                if (aVar instanceof com.airbnb.lottie.t0.c.n) {
                    ((com.airbnb.lottie.t0.c.n) aVar).i();
                }
            }
        }
        com.airbnb.lottie.z0.a<T> aVar3 = list.get(i2);
        if ((aVar3.b == null || aVar3.c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
