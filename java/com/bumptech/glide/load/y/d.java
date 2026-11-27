package com.bumptech.glide.load.y;

import android.content.res.AssetManager;
import android.net.Uri;

/* loaded from: classes.dex */
public class d<Data> implements p0<Uri, Data> {
    private static final int c = 22;
    private final AssetManager a;
    private final a<Data> b;

    public d(AssetManager assetManager, a<Data> aVar) {
        this.a = assetManager;
        this.b = aVar;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<Data> a(Uri uri, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(uri), this.b.a(this.a, uri.toString().substring(c)));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
