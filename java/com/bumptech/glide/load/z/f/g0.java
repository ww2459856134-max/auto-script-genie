package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class g0 implements h0 {
    private final com.bumptech.glide.load.x.g1.b a;
    private final List<ImageHeaderParser> b;
    private final com.bumptech.glide.load.w.v c;

    g0(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.x.g1.b bVar) {
        com.bumptech.glide.b0.n.d(bVar);
        this.a = bVar;
        com.bumptech.glide.b0.n.d(list);
        this.b = list;
        this.c = new com.bumptech.glide.load.w.v(parcelFileDescriptor);
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public void a() {
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public int b() throws IOException {
        return com.bumptech.glide.load.m.a(this.b, this.c, this.a);
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public Bitmap c(BitmapFactory.Options options) throws IOException {
        return BitmapFactory.decodeFileDescriptor(this.c.a().getFileDescriptor(), null, options);
    }

    @Override // com.bumptech.glide.load.z.f.h0
    public ImageHeaderParser.ImageType d() throws IOException {
        return com.bumptech.glide.load.m.d(this.b, this.c, this.a);
    }
}
