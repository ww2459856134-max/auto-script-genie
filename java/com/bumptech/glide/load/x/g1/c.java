package com.bumptech.glide.load.x.g1;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
class c implements t {
    private final d a;
    private int b;
    private int c;
    private Bitmap.Config d;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // com.bumptech.glide.load.x.g1.t
    public void a() {
        this.a.c(this);
    }

    public void b(int i2, int i3, Bitmap.Config config) {
        this.b = i2;
        this.c = i3;
        this.d = config;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.b == cVar.b && this.c == cVar.c && this.d == cVar.d;
    }

    public int hashCode() {
        int i2 = ((this.b * 31) + this.c) * 31;
        Bitmap.Config config = this.d;
        return i2 + (config != null ? config.hashCode() : 0);
    }

    public String toString() {
        return e.g(this.b, this.c, this.d);
    }
}
