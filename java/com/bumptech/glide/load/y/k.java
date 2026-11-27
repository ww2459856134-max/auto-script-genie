package com.bumptech.glide.load.y;

/* loaded from: classes.dex */
public class k<Data> implements p0<byte[], Data> {
    private final g<Data> a;

    public k(g<Data> gVar) {
        this.a = gVar;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<Data> a(byte[] bArr, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(bArr), new h(bArr, this.a));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(byte[] bArr) {
        return true;
    }
}
