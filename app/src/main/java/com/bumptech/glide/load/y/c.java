package com.bumptech.glide.load.y;

import android.content.res.AssetManager;
import android.net.Uri;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c implements q0<Uri, InputStream>, a<InputStream> {
    private final AssetManager a;

    public c(AssetManager assetManager) {
        this.a = assetManager;
    }

    @Override // com.bumptech.glide.load.y.a
    public com.bumptech.glide.load.w.e<InputStream> a(AssetManager assetManager, String str) {
        return new com.bumptech.glide.load.w.w(assetManager, str);
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Uri, InputStream> b(z0 z0Var) {
        return new d(this.a, this);
    }
}
