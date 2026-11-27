package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;

/* loaded from: classes.dex */
interface h0 {
    void a();

    int b() throws IOException;

    Bitmap c(BitmapFactory.Options options) throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
