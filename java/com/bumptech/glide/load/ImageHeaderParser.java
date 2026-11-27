package com.bumptech.glide.load;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean c;

        ImageType(boolean z) {
            this.c = z;
        }

        public boolean hasAlpha() {
            return this.c;
        }
    }

    ImageType a(InputStream inputStream) throws IOException;

    int b(InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar) throws IOException;

    ImageType c(ByteBuffer byteBuffer) throws IOException;
}
