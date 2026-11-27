package com.bumptech.glide.load.z.g;

import com.bumptech.glide.load.w.g;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b implements g<ByteBuffer> {
    private final ByteBuffer a;

    public b(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.w.g
    public void b() {
    }

    @Override // com.bumptech.glide.load.w.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.a.position(0);
        return this.a;
    }
}
