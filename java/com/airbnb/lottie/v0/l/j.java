package com.airbnb.lottie.v0.l;

import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class j implements b {
    private final String a;
    private final i b;
    private final boolean c;

    public j(String str, i iVar, boolean z) {
        this.a = str;
        this.b = iVar;
        this.c = z;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        if (e0Var.k()) {
            return new com.airbnb.lottie.t0.b.o(this);
        }
        com.airbnb.lottie.y0.d.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public i b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
