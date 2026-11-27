package com.bumptech.glide.load.z.j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* loaded from: classes.dex */
class j extends com.bumptech.glide.z.l.c<Bitmap> {
    private final Handler f;
    final int g;

    /* renamed from: h, reason: collision with root package name */
    private final long f659h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f660i;

    j(Handler handler, int i2, long j2) {
        this.f = handler;
        this.g = i2;
        this.f659h = j2;
    }

    @Override // com.bumptech.glide.z.l.h
    public void f(Drawable drawable) {
        this.f660i = null;
    }

    Bitmap l() {
        return this.f660i;
    }

    @Override // com.bumptech.glide.z.l.h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void g(Bitmap bitmap, com.bumptech.glide.z.m.d<? super Bitmap> dVar) {
        this.f660i = bitmap;
        this.f.sendMessageAtTime(this.f.obtainMessage(1, this), this.f659h);
    }
}
