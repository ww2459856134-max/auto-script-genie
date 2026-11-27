package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public final class f0 implements h0 {
    private final com.bumptech.glide.load.w.r a;
    private final com.bumptech.glide.load.x.g1.b b;
    private final List<ImageHeaderParser> c;

    f0(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.x.g1.b bVar) {
        com.bumptech.glide.b0.n.d(bVar);
        this.b = bVar;
        com.bumptech.glide.b0.n.d(list);
        this.c = list;
        this.a = new com.bumptech.glide.load.w.r(inputStream, bVar);
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public void a() {
        this.a.c();
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public int b() throws IOException {
        return com.bumptech.glide.load.m.b(this.c, this.a.a(), this.b);
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public Bitmap c(BitmapFactory.Options options) throws IOException {
        return BitmapFactory.decodeStream(this.a.a(), null, options);
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public ImageHeaderParser.ImageType d() throws IOException {
        return com.bumptech.glide.load.m.e(this.c, this.a.a(), this.b);
    }
}
