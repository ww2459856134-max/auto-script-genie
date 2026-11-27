package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.z.f.m0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m {
    public static int a(List<ImageHeaderParser> list, com.bumptech.glide.load.w.v vVar, com.bumptech.glide.load.x.g1.b bVar) throws IOException {
        return c(list, new j(vVar, bVar));
    }

    public static int b(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new m0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return c(list, new i(inputStream, bVar));
    }

    private static int c(List<ImageHeaderParser> list, k kVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = kVar.a(list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType d(List<ImageHeaderParser> list, com.bumptech.glide.load.w.v vVar, com.bumptech.glide.load.x.g1.b bVar) throws IOException {
        return g(list, new h(vVar, bVar));
    }

    public static ImageHeaderParser.ImageType e(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new m0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return g(list, new f(inputStream));
    }

    public static ImageHeaderParser.ImageType f(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : g(list, new g(byteBuffer));
    }

    private static ImageHeaderParser.ImageType g(List<ImageHeaderParser> list, l lVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = lVar.a(list.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
