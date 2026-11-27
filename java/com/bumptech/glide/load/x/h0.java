package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
public class h0 {
    private final j0<?> a;
    private final com.bumptech.glide.z.h b;
    final /* synthetic */ i0 c;

    h0(i0 i0Var, com.bumptech.glide.z.h hVar, j0<?> j0Var) {
        this.c = i0Var;
        this.b = hVar;
        this.a = j0Var;
    }

    public void a() {
        synchronized (this.c) {
            this.a.r(this.b);
        }
    }
}
