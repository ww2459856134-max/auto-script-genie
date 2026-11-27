package com.bumptech.glide.load.y;

import java.io.File;

/* loaded from: classes.dex */
public abstract class u<Data> implements q0<File, Data> {
    private final y<Data> a;

    public u(y<Data> yVar) {
        this.a = yVar;
    }

    @Override // com.bumptech.glide.load.y.q0
    public final p0<File, Data> b(z0 z0Var) {
        return new b0(this.a);
    }
}
