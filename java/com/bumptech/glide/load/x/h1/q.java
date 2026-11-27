package com.bumptech.glide.load.x.h1;

import android.util.DisplayMetrics;

/* loaded from: classes.dex */
final class q implements r {
    private final DisplayMetrics a;

    q(DisplayMetrics displayMetrics) {
        this.a = displayMetrics;
    }

    @Override // com.bumptech.glide.load.x.h1.r
    public int a() {
        return this.a.heightPixels;
    }

    @Override // com.bumptech.glide.load.x.h1.r
    public int b() {
        return this.a.widthPixels;
    }
}
