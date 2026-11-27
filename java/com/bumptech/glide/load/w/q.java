package com.bumptech.glide.load.w;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class q implements f<InputStream> {
    private final com.bumptech.glide.load.x.g1.b a;

    public q(com.bumptech.glide.load.x.g1.b bVar) {
        this.a = bVar;
    }

    @Override // com.bumptech.glide.load.w.f
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.w.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g<InputStream> b(InputStream inputStream) {
        return new r(inputStream, this.a);
    }
}
