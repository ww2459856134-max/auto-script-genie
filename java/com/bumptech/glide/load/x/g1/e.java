package com.bumptech.glide.load.x.g1;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
class e implements s {
    private final d a = new d();
    private final k<c, Bitmap> b = new k<>();

    e() {
    }

    static String g(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    private static String h(Bitmap bitmap) {
        return g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public String a(int i2, int i3, Bitmap.Config config) {
        return g(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.b0.p.g(bitmap);
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public void c(Bitmap bitmap) {
        this.b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        return this.b.a(this.a.e(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public String e(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // com.bumptech.glide.load.x.g1.s
    public Bitmap f() {
        return this.b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }
}
