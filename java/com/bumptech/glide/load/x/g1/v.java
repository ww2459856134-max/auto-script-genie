package com.bumptech.glide.load.x.g1;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
final class v implements t {
    private final w a;
    int b;
    private Bitmap.Config c;

    public v(w wVar) {
        this.a = wVar;
    }

    @Override // com.bumptech.glide.load.x.g1.t
    public void a() {
        this.a.c(this);
    }

    public void b(int i2, Bitmap.Config config) {
        this.b = i2;
        this.c = config;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.b == vVar.b && com.bumptech.glide.b0.p.c(this.c, vVar.c);
    }

    public int hashCode() {
        int i2 = this.b * 31;
        Bitmap.Config config = this.c;
        return i2 + (config != null ? config.hashCode() : 0);
    }

    public String toString() {
        return x.i(this.b, this.c);
    }
}
