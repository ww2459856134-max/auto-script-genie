package com.bumptech.glide.load.y;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class m implements com.bumptech.glide.load.w.e<ByteBuffer> {
    private final File c;

    m(File file) {
        this.c = file;
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<ByteBuffer> a() {
        return ByteBuffer.class;
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super ByteBuffer> dVar) {
        try {
            dVar.e(com.bumptech.glide.b0.c.a(this.c));
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
            }
            dVar.f(e);
        }
    }
}
