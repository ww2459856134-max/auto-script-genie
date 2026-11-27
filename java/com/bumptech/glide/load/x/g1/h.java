package com.bumptech.glide.load.x.g1;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class h implements g {
    @Override // com.bumptech.glide.load.x.g1.g
    public void a(int i2) {
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public void b() {
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        return d(i2, i3, config);
    }
}
