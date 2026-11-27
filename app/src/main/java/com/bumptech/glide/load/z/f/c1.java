package com.bumptech.glide.load.z.f;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c1<T> implements com.bumptech.glide.load.t<T, Bitmap> {
    public static final com.bumptech.glide.load.q<Long> d = com.bumptech.glide.load.q.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new u0());
    public static final com.bumptech.glide.load.q<Integer> e = com.bumptech.glide.load.q.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new v0());
    private static final z0 f = new z0();
    private final a1<T> a;
    private final com.bumptech.glide.load.x.g1.g b;
    private final z0 c;

    c1(com.bumptech.glide.load.x.g1.g gVar, a1<T> a1Var) {
        this(gVar, a1Var, f);
    }

    public static com.bumptech.glide.load.t<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.x.g1.g gVar) {
        return new c1(gVar, new w0(null));
    }

    public static com.bumptech.glide.load.t<ByteBuffer, Bitmap> d(com.bumptech.glide.load.x.g1.g gVar) {
        return new c1(gVar, new y0());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, v vVar) {
        Bitmap bitmapG = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || vVar == v.d) ? null : g(mediaMetadataRetriever, j2, i2, i3, i4, vVar);
        return bitmapG == null ? f(mediaMetadataRetriever, j2, i2) : bitmapG;
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, v vVar) {
        try {
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i7 == 90 || i7 == 270) {
                i6 = i5;
                i5 = i6;
            }
            float fB = vVar.b(i5, i6, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static com.bumptech.glide.load.t<ParcelFileDescriptor, Bitmap> h(com.bumptech.glide.load.x.g1.g gVar) {
        return new c1(gVar, new b1());
    }

    @Override // com.bumptech.glide.load.t
    public boolean a(T t, com.bumptech.glide.load.r rVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.t
    public com.bumptech.glide.load.x.z0<Bitmap> b(T t, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        long jLongValue = ((Long) rVar.c(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) rVar.c(e);
        if (num == null) {
            num = 2;
        }
        v vVar = (v) rVar.c(v.f);
        if (vVar == null) {
            vVar = v.e;
        }
        v vVar2 = vVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.c.a();
        try {
            try {
                this.a.a(mediaMetadataRetrieverA, t);
                Bitmap bitmapE = e(mediaMetadataRetrieverA, jLongValue, num.intValue(), i2, i3, vVar2);
                mediaMetadataRetrieverA.release();
                return e.e(bitmapE, this.b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    c1(com.bumptech.glide.load.x.g1.g gVar, a1<T> a1Var, z0 z0Var) {
        this.b = gVar;
        this.a = a1Var;
        this.c = z0Var;
    }
}
