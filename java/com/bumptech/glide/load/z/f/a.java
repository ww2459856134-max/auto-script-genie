package com.bumptech.glide.load.z.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.IOException;

/* loaded from: classes.dex */
public class a<DataType> implements com.bumptech.glide.load.t<DataType, BitmapDrawable> {
    private final com.bumptech.glide.load.t<DataType, Bitmap> a;
    private final Resources b;

    public a(Resources resources, com.bumptech.glide.load.t<DataType, Bitmap> tVar) {
        com.bumptech.glide.b0.n.d(resources);
        this.b = resources;
        com.bumptech.glide.b0.n.d(tVar);
        this.a = tVar;
    }

    @Override // com.bumptech.glide.load.t
    public boolean a(DataType datatype, com.bumptech.glide.load.r rVar) throws IOException {
        return this.a.a(datatype, rVar);
    }

    @Override // com.bumptech.glide.load.t
    public com.bumptech.glide.load.x.z0<BitmapDrawable> b(DataType datatype, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        return j0.e(this.b, this.a.b(datatype, i2, i3, rVar));
    }
}
