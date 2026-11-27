package com.bumptech.glide.load.y;

import android.content.res.Resources;
import android.net.Uri;

/* loaded from: classes.dex */
public class d1 implements q0<Integer, Uri> {
    private final Resources a;

    public d1(Resources resources) {
        this.a = resources;
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Integer, Uri> b(z0 z0Var) {
        return new e1(this.a, m1.c());
    }
}
