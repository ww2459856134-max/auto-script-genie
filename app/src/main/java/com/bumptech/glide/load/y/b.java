package com.bumptech.glide.load.y;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public class b implements q0<Uri, ParcelFileDescriptor>, a<ParcelFileDescriptor> {
    private final AssetManager a;

    public b(AssetManager assetManager) {
        this.a = assetManager;
    }

    @Override // com.bumptech.glide.load.y.a
    public com.bumptech.glide.load.w.e<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
        return new com.bumptech.glide.load.w.l(assetManager, str);
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Uri, ParcelFileDescriptor> b(z0 z0Var) {
        return new d(this.a, this);
    }
}
