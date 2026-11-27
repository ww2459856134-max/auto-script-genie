package com.bumptech.glide.load.z.j;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.v;
import com.bumptech.glide.load.x.z0;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class i implements v<f> {
    private final v<Bitmap> b;

    public i(v<Bitmap> vVar) {
        com.bumptech.glide.b0.n.d(vVar);
        this.b = vVar;
    }

    @Override // com.bumptech.glide.load.v
    public z0<f> a(Context context, z0<f> z0Var, int i2, int i3) {
        f fVar = z0Var.get();
        z0<Bitmap> eVar = new com.bumptech.glide.load.z.f.e(fVar.e(), com.bumptech.glide.c.c(context).f());
        z0<Bitmap> z0VarA = this.b.a(context, eVar, i2, i3);
        if (!eVar.equals(z0VarA)) {
            eVar.a();
        }
        fVar.m(this.b, z0VarA.get());
        return z0Var;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.b.equals(((i) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return this.b.hashCode();
    }
}
