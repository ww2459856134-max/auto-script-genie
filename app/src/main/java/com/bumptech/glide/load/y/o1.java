package com.bumptech.glide.load.y;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public class o1 implements q0<Uri, ParcelFileDescriptor>, p1<ParcelFileDescriptor> {
    private final ContentResolver a;

    public o1(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    @Override // com.bumptech.glide.load.y.p1
    public com.bumptech.glide.load.w.e<ParcelFileDescriptor> a(Uri uri) {
        return new com.bumptech.glide.load.w.m(this.a, uri);
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Uri, ParcelFileDescriptor> b(z0 z0Var) {
        return new r1(this);
    }
}
