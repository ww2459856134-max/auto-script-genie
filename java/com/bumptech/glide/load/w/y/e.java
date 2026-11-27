package com.bumptech.glide.load.w.y;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.w.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.w.e<InputStream> {
    private final Uri c;
    private final g d;
    private InputStream e;

    e(Uri uri, g gVar) {
        this.c = uri;
        this.d = gVar;
    }

    private static e e(Context context, Uri uri, f fVar) {
        return new e(uri, new g(com.bumptech.glide.c.c(context).j().g(), fVar, com.bumptech.glide.c.c(context).e(), context.getContentResolver()));
    }

    public static e f(Context context, Uri uri) {
        return e(context, uri, new c(context.getContentResolver()));
    }

    public static e g(Context context, Uri uri) {
        return e(context, uri, new d(context.getContentResolver()));
    }

    private InputStream h() throws Throwable {
        InputStream inputStreamD = this.d.d(this.c);
        int iA = inputStreamD != null ? this.d.a(this.c) : -1;
        return iA != -1 ? new k(inputStreamD, iA) : inputStreamD;
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() throws IOException {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(h hVar, com.bumptech.glide.load.w.d<? super InputStream> dVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.e = inputStreamH;
            dVar.e(inputStreamH);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            dVar.f(e);
        }
    }
}
