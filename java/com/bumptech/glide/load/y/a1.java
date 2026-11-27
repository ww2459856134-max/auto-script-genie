package com.bumptech.glide.load.y;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;

/* loaded from: classes.dex */
public final class a1 implements q0<Integer, AssetFileDescriptor> {
    private final Resources a;

    public a1(Resources resources) {
        this.a = resources;
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Integer, AssetFileDescriptor> b(z0 z0Var) {
        return new e1(this.a, z0Var.d(Uri.class, AssetFileDescriptor.class));
    }
}
