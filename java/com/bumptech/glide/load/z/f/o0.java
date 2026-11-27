package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import java.io.IOException;

/* loaded from: classes.dex */
class o0 implements x {
    private final m0 a;
    private final com.bumptech.glide.b0.f b;

    o0(m0 m0Var, com.bumptech.glide.b0.f fVar) {
        this.a = m0Var;
        this.b = fVar;
    }

    @Override // com.bumptech.glide.load.z.f.x
    public void a() {
        this.a.c();
    }

    @Override // com.bumptech.glide.load.z.f.x
    public void b(com.bumptech.glide.load.x.g1.g gVar, Bitmap bitmap) throws IOException {
        IOException iOExceptionA = this.b.a();
        if (iOExceptionA != null) {
            if (bitmap == null) {
                throw iOExceptionA;
            }
            gVar.c(bitmap);
            throw iOExceptionA;
        }
    }
}
