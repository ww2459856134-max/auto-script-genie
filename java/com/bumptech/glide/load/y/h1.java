package com.bumptech.glide.load.y;

import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public class h1 implements q0<String, ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.y.q0
    public p0<String, ParcelFileDescriptor> b(z0 z0Var) {
        return new j1(z0Var.d(Uri.class, ParcelFileDescriptor.class));
    }
}
