package com.bumptech.glide.load.y;

import android.net.Uri;
import java.io.InputStream;

/* loaded from: classes.dex */
public class i1 implements q0<String, InputStream> {
    @Override // com.bumptech.glide.load.y.q0
    public p0<String, InputStream> b(z0 z0Var) {
        return new j1(z0Var.d(Uri.class, InputStream.class));
    }
}
