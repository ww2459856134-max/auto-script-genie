package com.bumptech.glide.load.y;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
class i implements g<InputStream> {
    i(j jVar) {
    }

    @Override // com.bumptech.glide.load.y.g
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.y.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InputStream b(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }
}
