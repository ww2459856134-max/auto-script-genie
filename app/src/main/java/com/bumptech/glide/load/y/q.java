package com.bumptech.glide.load.y;

import java.io.IOException;

/* loaded from: classes.dex */
final class q<Data> implements com.bumptech.glide.load.w.e<Data> {
    private final String c;
    private final p<Data> d;
    private Data e;

    q(String str, p<Data> pVar) {
        this.c = str;
        this.d = pVar;
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<Data> a() {
        return this.d.a();
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
        try {
            this.d.b(this.e);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super Data> dVar) {
        try {
            Data dataC = this.d.c(this.c);
            this.e = dataC;
            dVar.e(dataC);
        } catch (IllegalArgumentException e) {
            dVar.f(e);
        }
    }
}
