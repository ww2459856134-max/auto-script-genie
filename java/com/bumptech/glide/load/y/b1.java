package com.bumptech.glide.load.y;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public class b1 implements q0<Integer, ParcelFileDescriptor> {
    private final Resources a;

    public b1(Resources resources) {
        this.a = resources;
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Integer, ParcelFileDescriptor> b(z0 z0Var) {
        return new e1(this.a, z0Var.d(Uri.class, ParcelFileDescriptor.class));
    }
}
