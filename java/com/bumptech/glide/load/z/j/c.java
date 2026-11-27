package com.bumptech.glide.load.z.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class c implements t<ByteBuffer, f> {
    private static final a f = new a();
    private static final b g = new b();
    private final Context a;
    private final List<ImageHeaderParser> b;
    private final b c;
    private final a d;
    private final d e;

    public c(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.x.g1.g gVar, com.bumptech.glide.load.x.g1.b bVar) {
        this(context, list, gVar, bVar, g, f);
    }

    private h c(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.v.e eVar, r rVar) {
        long jB = com.bumptech.glide.b0.j.b();
        try {
            com.bumptech.glide.v.d dVarC = eVar.c();
            if (dVarC.b() > 0 && dVarC.c() == 0) {
                Bitmap.Config config = rVar.c(p.a) == com.bumptech.glide.load.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                com.bumptech.glide.v.b bVarA = this.d.a(this.e, dVarC, byteBuffer, e(dVarC, i2, i3));
                bVarA.a(config);
                bVarA.f();
                Bitmap bitmapE = bVarA.e();
                if (bitmapE == null) {
                    return null;
                }
                h hVar = new h(new f(this.a, bVarA, com.bumptech.glide.load.z.e.c(), i2, i3, bitmapE));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.b0.j.a(jB));
                }
                return hVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.b0.j.a(jB));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.b0.j.a(jB));
            }
        }
    }

    private static int e(com.bumptech.glide.v.d dVar, int i2, int i3) {
        int iMin = Math.min(dVar.a() / i3, dVar.d() / i2);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + dVar.d() + "x" + dVar.a() + "]");
        }
        return iMax;
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public h b(ByteBuffer byteBuffer, int i2, int i3, r rVar) {
        com.bumptech.glide.v.e eVarA = this.c.a(byteBuffer);
        try {
            return c(byteBuffer, i2, i3, eVarA, rVar);
        } finally {
            this.c.b(eVarA);
        }
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, r rVar) throws IOException {
        return !((Boolean) rVar.c(p.b)).booleanValue() && com.bumptech.glide.load.m.f(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    c(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.x.g1.g gVar, com.bumptech.glide.load.x.g1.b bVar, b bVar2, a aVar) {
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new d(gVar, bVar);
        this.c = bVar2;
    }
}
