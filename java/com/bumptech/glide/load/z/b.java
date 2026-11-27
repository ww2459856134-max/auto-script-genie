package com.bumptech.glide.load.z;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.s;
import com.bumptech.glide.load.z.f.v;

/* loaded from: classes.dex */
class b implements ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ com.bumptech.glide.load.b d;
    final /* synthetic */ v e;
    final /* synthetic */ s f;
    final /* synthetic */ c g;

    b(c cVar, int i2, int i3, boolean z, com.bumptech.glide.load.b bVar, v vVar, s sVar) {
        this.g = cVar;
        this.a = i2;
        this.b = i3;
        this.c = z;
        this.d = bVar;
        this.e = vVar;
        this.f = sVar;
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    @SuppressLint({"Override"})
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        boolean z = false;
        if (this.g.a.c(this.a, this.b, this.c, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == com.bumptech.glide.load.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a(this));
        Size size = imageInfo.getSize();
        int width = this.a;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.b;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            if (i2 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        } else {
            if (this.f == s.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                z = true;
            }
            imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }
}
