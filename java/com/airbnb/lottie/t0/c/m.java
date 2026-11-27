package com.airbnb.lottie.t0.c;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class m {
    private final List<g<com.airbnb.lottie.v0.l.o, Path>> a;
    private final List<g<Integer, Integer>> b;
    private final List<com.airbnb.lottie.v0.l.h> c;

    public m(List<com.airbnb.lottie.v0.l.h> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.add(list.get(i2).b().a());
            this.b.add(list.get(i2).c().a());
        }
    }

    public List<g<com.airbnb.lottie.v0.l.o, Path>> a() {
        return this.a;
    }

    public List<com.airbnb.lottie.v0.l.h> b() {
        return this.c;
    }

    public List<g<Integer, Integer>> c() {
        return this.b;
    }
}
