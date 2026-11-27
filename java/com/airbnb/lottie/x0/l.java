package com.airbnb.lottie.x0;

import android.graphics.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l implements k0<com.airbnb.lottie.v0.l.c> {
    private int a;

    public l(int i2) {
        this.a = i2;
    }

    private void b(com.airbnb.lottie.v0.l.c cVar, List<Float> list) {
        int i2 = this.a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        while (i2 < list.size()) {
            if (i2 % 2 == 0) {
                dArr[i3] = list.get(i2).floatValue();
            } else {
                dArr2[i3] = list.get(i2).floatValue();
                i3++;
            }
            i2++;
        }
        for (int i4 = 0; i4 < cVar.c(); i4++) {
            int i5 = cVar.a()[i4];
            cVar.a()[i4] = Color.argb(c(cVar.b()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
    }

    private int c(double d, double[] dArr, double[] dArr2) {
        double dI;
        int i2 = 1;
        while (true) {
            if (i2 >= dArr.length) {
                dI = dArr2[dArr2.length - 1];
                break;
            }
            int i3 = i2 - 1;
            double d2 = dArr[i3];
            double d3 = dArr[i2];
            if (dArr[i2] >= d) {
                dI = com.airbnb.lottie.y0.g.i(dArr2[i3], dArr2[i2], (d - d2) / (d3 - d2));
                break;
            }
            i2++;
        }
        return (int) (dI * 255.0d);
    }

    @Override // com.airbnb.lottie.x0.k0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.v0.l.c a(com.airbnb.lottie.x0.l0.e eVar, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = eVar.w() == com.airbnb.lottie.x0.l0.d.BEGIN_ARRAY;
        if (z) {
            eVar.c();
        }
        while (eVar.m()) {
            arrayList.add(Float.valueOf((float) eVar.o()));
        }
        if (z) {
            eVar.f();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i2 = this.a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.a * 4; i5++) {
            int i6 = i5 / 4;
            double dFloatValue = arrayList.get(i5).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) dFloatValue;
            } else if (i7 == 1) {
                i3 = (int) (dFloatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (dFloatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(255, i3, i4, (int) (dFloatValue * 255.0d));
            }
        }
        com.airbnb.lottie.v0.l.c cVar = new com.airbnb.lottie.v0.l.c(fArr, iArr);
        b(cVar, arrayList);
        return cVar;
    }
}
