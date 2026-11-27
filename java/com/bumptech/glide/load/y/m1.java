package com.bumptech.glide.load.y;

/* loaded from: classes.dex */
public class m1<Model> implements p0<Model, Model> {
    private static final m1<?> a = new m1<>();

    @Deprecated
    public m1() {
    }

    public static <T> m1<T> c() {
        return (m1<T>) a;
    }

    @Override // com.bumptech.glide.load.y.p0
    public o0<Model> a(Model model, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(model), new l1(model));
    }

    @Override // com.bumptech.glide.load.y.p0
    public boolean b(Model model) {
        return true;
    }
}
