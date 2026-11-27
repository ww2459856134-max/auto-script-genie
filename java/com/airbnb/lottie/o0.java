package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class o0 {
    private boolean a = false;
    private final Set<n0> b = new h.d.d();
    private final Map<String, com.airbnb.lottie.y0.f> c = new HashMap();

    public void a(String str, float f) {
        if (this.a) {
            com.airbnb.lottie.y0.f fVar = this.c.get(str);
            if (fVar == null) {
                fVar = new com.airbnb.lottie.y0.f();
                this.c.put(str, fVar);
            }
            fVar.a(f);
            if (str.equals("__container")) {
                Iterator<n0> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().a(f);
                }
            }
        }
    }

    void b(boolean z) {
        this.a = z;
    }
}
