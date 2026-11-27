package com.bumptech.glide.load.z.f;

/* loaded from: classes.dex */
class s extends v {
    s() {
    }

    @Override // com.bumptech.glide.load.z.f.v
    public u a(int i2, int i3, int i4, int i5) {
        return v.g ? u.QUALITY : u.MEMORY;
    }

    @Override // com.bumptech.glide.load.z.f.v
    public float b(int i2, int i3, int i4, int i5) {
        if (v.g) {
            return Math.min(i4 / i2, i5 / i3);
        }
        if (Math.max(i3 / i5, i2 / i4) == 0) {
            return 1.0f;
        }
        return 1.0f / Integer.highestOneBit(r2);
    }
}
