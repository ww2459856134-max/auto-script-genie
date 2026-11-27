package com.bumptech.glide.load.x;

import java.util.Map;

/* loaded from: classes.dex */
class d0 {
    final r a;
    final h.e.i.e<p<?>> b = com.bumptech.glide.b0.q.h.d(150, new c0(this));
    private int c;

    d0(r rVar) {
        this.a = rVar;
    }

    <R> p<R> a(com.bumptech.glide.f fVar, Object obj, o0 o0Var, com.bumptech.glide.load.n nVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, b0 b0Var, Map<Class<?>, com.bumptech.glide.load.v<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.r rVar, o<R> oVar) {
        p pVarA = this.b.a();
        com.bumptech.glide.b0.n.d(pVarA);
        p pVar = pVarA;
        int i4 = this.c;
        this.c = i4 + 1;
        pVar.n(fVar, obj, o0Var, nVar, i2, i3, cls, cls2, hVar, b0Var, map, z, z2, z3, rVar, oVar, i4);
        return pVar;
    }
}
