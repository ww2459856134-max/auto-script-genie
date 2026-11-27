package com.bumptech.glide.load.y.u1;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.y.o0;
import com.bumptech.glide.load.y.p0;
import java.io.InputStream;

/* loaded from: classes.dex */
public class f implements p0<Uri, InputStream> {
    private final Context a;

    public f(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<InputStream> a(Uri uri, int i2, int i3, r rVar) {
        if (com.bumptech.glide.load.w.y.b.d(i2, i3)) {
            return new o0<>(new com.bumptech.glide.a0.d(uri), com.bumptech.glide.load.w.y.e.f(this.a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return com.bumptech.glide.load.w.y.b.a(uri);
    }
}
