package com.bumptech.glide.load.w;

import com.bumptech.glide.load.z.f.m0;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class r implements g<InputStream> {
    private final m0 a;

    public r(InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar) {
        m0 m0Var = new m0(inputStream, bVar);
        this.a = m0Var;
        m0Var.mark(5242880);
    }

    @Override // com.bumptech.glide.load.w.g
    public void b() {
        this.a.d();
    }

    public void c() {
        this.a.c();
    }

    @Override // com.bumptech.glide.load.w.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() throws IOException {
        this.a.reset();
        return this.a;
    }
}
