package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class f implements l {
    final /* synthetic */ InputStream a;

    f(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // com.bumptech.glide.load.l
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
        try {
            return imageHeaderParser.a(this.a);
        } finally {
            this.a.reset();
        }
    }
}
