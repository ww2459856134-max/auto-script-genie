package com.bumptech.glide.load.z.f;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class v {
    public static final v a = new s();
    public static final v b = new q();
    public static final v c;
    public static final v d;
    public static final v e;
    public static final com.bumptech.glide.load.q<v> f;
    static final boolean g;

    static {
        r rVar = new r();
        c = rVar;
        d = new t();
        e = rVar;
        f = com.bumptech.glide.load.q.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", rVar);
        g = Build.VERSION.SDK_INT >= 19;
    }

    public abstract u a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
