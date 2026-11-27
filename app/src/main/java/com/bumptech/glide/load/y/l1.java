package com.bumptech.glide.load.y;

/* loaded from: classes.dex */
class l1<Model> implements com.bumptech.glide.load.w.e<Model> {
    private final Model c;

    l1(Model model) {
        this.c = model;
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<Model> a() {
        return (Class<Model>) this.c.getClass();
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
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super Model> dVar) {
        dVar.e(this.c);
    }
}
