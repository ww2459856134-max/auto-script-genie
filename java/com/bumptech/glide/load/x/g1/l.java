package com.bumptech.glide.load.x.g1;

/* loaded from: classes.dex */
public final class l implements a<int[]> {
    @Override // com.bumptech.glide.load.x.g1.a
    public int b() {
        return 4;
    }

    @Override // com.bumptech.glide.load.x.g1.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.x.g1.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i2) {
        return new int[i2];
    }

    @Override // com.bumptech.glide.load.x.g1.a
    public String getTag() {
        return "IntegerArrayPool";
    }
}
