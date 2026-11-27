package com.airbnb.lottie.x0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class e0 implements k0<com.airbnb.lottie.v0.l.o> {
    public static final e0 a = new e0();
    private static final com.airbnb.lottie.x0.l0.c b = com.airbnb.lottie.x0.l0.c.a("c", "v", "i", "o");

    private e0() {
    }

    @Override // com.airbnb.lottie.x0.k0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.v0.l.o a(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        if (eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY) {
            eVar.c();
        }
        eVar.d();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zN = false;
        while (eVar.m()) {
            int iY = eVar.y(b);
            if (iY == 0) {
                zN = eVar.n();
            } else if (iY == 1) {
                listF = q.f(eVar, f);
            } else if (iY == 2) {
                listF2 = q.f(eVar, f);
            } else if (iY != 3) {
                eVar.z();
                eVar.B();
            } else {
                listF3 = q.f(eVar, f);
            }
        }
        eVar.i();
        if (eVar.w() == com.airbnb.lottie.x0.l0.d.END_ARRAY) {
            eVar.f();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new com.airbnb.lottie.v0.l.o(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 1; i2 < size; i2++) {
            PointF pointF2 = listF.get(i2);
            int i3 = i2 - 1;
            arrayList.add(new com.airbnb.lottie.v0.a(com.airbnb.lottie.y0.g.a(listF.get(i3), listF3.get(i3)), com.airbnb.lottie.y0.g.a(pointF2, listF2.get(i2)), pointF2));
        }
        if (zN) {
            PointF pointF3 = listF.get(0);
            int i4 = size - 1;
            arrayList.add(new com.airbnb.lottie.v0.a(com.airbnb.lottie.y0.g.a(listF.get(i4), listF3.get(i4)), com.airbnb.lottie.y0.g.a(pointF3, listF2.get(0)), pointF3));
        }
        return new com.airbnb.lottie.v0.l.o(pointF, zN, arrayList);
    }
}
