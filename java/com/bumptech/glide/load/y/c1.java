package com.bumptech.glide.load.y;

import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c1 implements q0<Integer, InputStream> {
    private final Resources a;

    public c1(Resources resources) {
        this.a = resources;
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Integer, InputStream> b(z0 z0Var) {
        return new e1(this.a, z0Var.d(Uri.class, InputStream.class));
    }
}
