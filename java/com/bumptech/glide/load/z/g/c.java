package com.bumptech.glide.load.z.g;

import com.bumptech.glide.b0.n;
import com.bumptech.glide.load.x.z0;

/* loaded from: classes.dex */
public class c implements z0<byte[]> {
    private final byte[] c;

    public c(byte[] bArr) {
        n.d(bArr);
        this.c = bArr;
    }

    @Override // com.bumptech.glide.load.x.z0
    public void a() {
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<byte[]> b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.x.z0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.c;
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return this.c.length;
    }
}
