package com.bumptech.glide.load.z.f;

/* loaded from: classes.dex */
class q extends v {
    q() {
    }

    @Override // com.bumptech.glide.load.z.f.v
    public u a(int i2, int i3, int i4, int i5) {
        return b(i2, i3, i4, i5) == 1.0f ? u.QUALITY : v.a.a(i2, i3, i4, i5);
    }

    @Override // com.bumptech.glide.load.z.f.v
    public float b(int i2, int i3, int i4, int i5) {
        return Math.min(1.0f, v.a.b(i2, i3, i4, i5));
    }
}
