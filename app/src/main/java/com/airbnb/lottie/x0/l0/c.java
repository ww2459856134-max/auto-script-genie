package com.airbnb.lottie.x0.l0;

import java.io.IOException;

/* loaded from: classes.dex */
public final class c {
    final String[] a;
    final m.g b;

    private c(String[] strArr, m.g gVar) {
        this.a = strArr;
        this.b = gVar;
    }

    public static c a(String... strArr) {
        try {
            m.d[] dVarArr = new m.d[strArr.length];
            m.a aVar = new m.a();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                e.D(aVar, strArr[i2]);
                aVar.n();
                dVarArr[i2] = aVar.q();
            }
            return new c((String[]) strArr.clone(), m.g.g(dVarArr));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
