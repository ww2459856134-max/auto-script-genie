package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
class g implements l {
    final /* synthetic */ ByteBuffer a;

    g(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.l
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
        return imageHeaderParser.c(this.a);
    }
}
