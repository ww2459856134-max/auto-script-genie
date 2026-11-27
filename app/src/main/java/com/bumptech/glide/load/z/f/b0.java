package com.bumptech.glide.load.z.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class b0 implements com.bumptech.glide.load.v<Drawable> {
    private final com.bumptech.glide.load.v<Bitmap> b;
    private final boolean c;

    public b0(com.bumptech.glide.load.v<Bitmap> vVar, boolean z) {
        this.b = vVar;
        this.c = z;
    }

    private com.bumptech.glide.load.x.z0<Drawable> d(Context context, com.bumptech.glide.load.x.z0<Bitmap> z0Var) {
        return j0.e(context.getResources(), z0Var);
    }

    @Override // com.bumptech.glide.load.v
    public com.bumptech.glide.load.x.z0<Drawable> a(Context context, com.bumptech.glide.load.x.z0<Drawable> z0Var, int i2, int i3) {
        com.bumptech.glide.load.x.g1.g gVarF = com.bumptech.glide.c.c(context).f();
        Drawable drawable = z0Var.get();
        com.bumptech.glide.load.x.z0<Bitmap> z0VarA = a0.a(gVarF, drawable, i2, i3);
        if (z0VarA != null) {
            com.bumptech.glide.load.x.z0<Bitmap> z0VarA2 = this.b.a(context, z0VarA, i2, i3);
            if (!z0VarA2.equals(z0VarA)) {
                return d(context, z0VarA2);
            }
            z0VarA2.a();
            return z0Var;
        }
        if (!this.c) {
            return z0Var;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    public com.bumptech.glide.load.v<BitmapDrawable> c() {
        return this;
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (obj instanceof b0) {
            return this.b.equals(((b0) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return this.b.hashCode();
    }
}
