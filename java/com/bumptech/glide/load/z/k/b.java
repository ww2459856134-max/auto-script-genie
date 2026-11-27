package com.bumptech.glide.load.z.k;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.b0.n;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.x.z0;
import com.bumptech.glide.load.z.f.j0;

/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {
    private final Resources a;

    public b(Resources resources) {
        n.d(resources);
        this.a = resources;
    }

    @Override // com.bumptech.glide.load.z.k.e
    public z0<BitmapDrawable> a(z0<Bitmap> z0Var, r rVar) {
        return j0.e(this.a, z0Var);
    }
}
