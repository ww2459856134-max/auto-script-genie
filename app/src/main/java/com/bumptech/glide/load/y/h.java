package com.bumptech.glide.load.y;

/* loaded from: classes.dex */
class h<Data> implements com.bumptech.glide.load.w.e<Data> {
    private final byte[] c;
    private final g<Data> d;

    h(byte[] bArr, g<Data> gVar) {
        this.c = bArr;
        this.d = gVar;
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<Data> a() {
        return this.d.a();
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super Data> dVar) {
        dVar.e(this.d.b(this.c));
    }
}
