package com.bumptech.glide.load.z.j;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public final class d implements com.bumptech.glide.v.a {
    private final com.bumptech.glide.load.x.g1.g a;
    private final com.bumptech.glide.load.x.g1.b b;

    public d(com.bumptech.glide.load.x.g1.g gVar, com.bumptech.glide.load.x.g1.b bVar) {
        this.a = gVar;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.v.a
    public byte[] a(int i2) {
        com.bumptech.glide.load.x.g1.b bVar = this.b;
        return bVar == null ? new byte[i2] : (byte[]) bVar.c(i2, byte[].class);
    }

    @Override // com.bumptech.glide.v.a
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        return this.a.e(i2, i3, config);
    }

    @Override // com.bumptech.glide.v.a
    public void c(Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // com.bumptech.glide.v.a
    public int[] d(int i2) {
        com.bumptech.glide.load.x.g1.b bVar = this.b;
        return bVar == null ? new int[i2] : (int[]) bVar.c(i2, int[].class);
    }

    @Override // com.bumptech.glide.v.a
    public void e(byte[] bArr) {
        com.bumptech.glide.load.x.g1.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.e(bArr);
    }

    @Override // com.bumptech.glide.v.a
    public void f(int[] iArr) {
        com.bumptech.glide.load.x.g1.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.e(iArr);
    }
}
