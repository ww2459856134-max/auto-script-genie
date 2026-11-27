package com.bumptech.glide.load.y;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;

/* loaded from: classes.dex */
public final class g1 implements q0<String, AssetFileDescriptor> {
    @Override // com.bumptech.glide.load.y.q0
    public p0<String, AssetFileDescriptor> b(z0 z0Var) {
        return new j1(z0Var.d(Uri.class, AssetFileDescriptor.class));
    }
}
