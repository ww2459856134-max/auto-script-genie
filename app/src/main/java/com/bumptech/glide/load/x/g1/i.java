package com.bumptech.glide.load.x.g1;

/* loaded from: classes.dex */
public final class i implements a<byte[]> {
    @Override // com.bumptech.glide.load.x.g1.a
    public int b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.x.g1.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.x.g1.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i2) {
        return new byte[i2];
    }

    @Override // com.bumptech.glide.load.x.g1.a
    public String getTag() {
        return "ByteArrayPool";
    }
}
