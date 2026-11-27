package com.bumptech.glide.load.y;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;

/* loaded from: classes.dex */
public final class n1 implements q0<Uri, AssetFileDescriptor>, p1<AssetFileDescriptor> {
    private final ContentResolver a;

    public n1(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    @Override // com.bumptech.glide.load.y.p1
    public com.bumptech.glide.load.w.e<AssetFileDescriptor> a(Uri uri) {
        return new com.bumptech.glide.load.w.a(this.a, uri);
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Uri, AssetFileDescriptor> b(z0 z0Var) {
        return new r1(this);
    }
}
