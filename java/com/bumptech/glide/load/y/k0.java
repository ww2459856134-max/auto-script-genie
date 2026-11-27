package com.bumptech.glide.load.y;

import android.content.Context;
import android.net.Uri;
import java.io.File;

/* loaded from: classes.dex */
public final class k0 implements p0<Uri, File> {
    private final Context a;

    public k0(Context context) {
        this.a = context;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<File> a(Uri uri, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(uri), new j0(this.a, uri));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return com.bumptech.glide.load.w.y.b.b(uri);
    }
}
