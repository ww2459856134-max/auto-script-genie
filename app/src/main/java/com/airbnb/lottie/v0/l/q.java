package com.airbnb.lottie.v0.l;

import com.airbnb.lottie.e0;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class q implements b {
    private final String a;
    private final List<b> b;
    private final boolean c;

    public q(String str, List<b> list, boolean z) {
        this.a = str;
        this.b = list;
        this.c = z;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.f(e0Var, cVar, this);
    }

    public List<b> b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
