package com.bumptech.glide.load.z;

import android.content.Context;
import com.bumptech.glide.load.v;
import com.bumptech.glide.load.x.z0;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class e<T> implements v<T> {
    private static final v<?> b = new e();

    private e() {
    }

    public static <T> e<T> c() {
        return (e) b;
    }

    @Override // com.bumptech.glide.load.v
    public z0<T> a(Context context, z0<T> z0Var, int i2, int i3) {
        return z0Var;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
    }
}
