package com.bumptech.glide.load.y;

import java.io.File;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class o implements p0<File, ByteBuffer> {
    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<ByteBuffer> a(File file, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(file), new m(file));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(File file) {
        return true;
    }
}
