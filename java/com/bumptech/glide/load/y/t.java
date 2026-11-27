package com.bumptech.glide.load.y;

/* loaded from: classes.dex */
public final class t<Model, Data> implements p0<Model, Data> {
    private final p<Data> a;

    public t(p<Data> pVar) {
        this.a = pVar;
    }

    @Override // com.bumptech.glide.load.y.p0
    public o0<Data> a(Model model, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(model), new q(model.toString(), this.a));
    }

    @Override // com.bumptech.glide.load.y.p0
    public boolean b(Model model) {
        return model.toString().startsWith("data:image");
    }
}
