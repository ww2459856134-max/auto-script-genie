package com.bumptech.glide.load;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class i implements k {
    final /* synthetic */ InputStream a;
    final /* synthetic */ com.bumptech.glide.load.x.g1.b b;

    i(InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar) {
        this.a = inputStream;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.load.k
    public int a(ImageHeaderParser imageHeaderParser) throws IOException {
        try {
            return imageHeaderParser.b(this.a, this.b);
        } finally {
            this.a.reset();
        }
    }
}
