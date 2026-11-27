package com.bumptech.glide.load.y;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.InputStream;

/* loaded from: classes.dex */
public class q1 implements q0<Uri, InputStream>, p1<InputStream> {
    private final ContentResolver a;

    public q1(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    @Override // com.bumptech.glide.load.y.p1
    public com.bumptech.glide.load.w.e<InputStream> a(Uri uri) {
        return new com.bumptech.glide.load.w.x(this.a, uri);
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Uri, InputStream> b(z0 z0Var) {
        return new r1(this);
    }
}
