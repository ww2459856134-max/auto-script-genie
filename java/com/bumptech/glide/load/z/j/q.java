package com.bumptech.glide.load.z.j;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.t;
import com.bumptech.glide.load.x.z0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class q implements t<InputStream, f> {
    private final List<ImageHeaderParser> a;
    private final t<ByteBuffer, f> b;
    private final com.bumptech.glide.load.x.g1.b c;

    public q(List<ImageHeaderParser> list, t<ByteBuffer, f> tVar, com.bumptech.glide.load.x.g1.b bVar) {
        this.a = list;
        this.b = tVar;
        this.c = bVar;
    }

    private static byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public z0<f> b(InputStream inputStream, int i2, int i3, r rVar) throws IOException {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(bArrE), i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, r rVar) throws IOException {
        return !((Boolean) rVar.c(p.b)).booleanValue() && com.bumptech.glide.load.m.e(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
