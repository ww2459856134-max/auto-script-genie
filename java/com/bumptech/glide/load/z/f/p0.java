package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class p0 implements com.bumptech.glide.load.t<InputStream, Bitmap> {
    private final y a;
    private final com.bumptech.glide.load.x.g1.b b;

    public p0(y yVar, com.bumptech.glide.load.x.g1.b bVar) {
        this.a = yVar;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.x.z0<Bitmap> b(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        boolean z;
        m0 m0Var;
        if (inputStream instanceof m0) {
            m0Var = (m0) inputStream;
            z = false;
        } else {
            z = true;
            m0Var = new m0(inputStream, this.b);
        }
        com.bumptech.glide.b0.f fVarC = com.bumptech.glide.b0.f.c(m0Var);
        try {
            return this.a.g(new com.bumptech.glide.b0.l(fVarC), i2, i3, rVar, new o0(m0Var, fVarC));
        } finally {
            fVarC.d();
            if (z) {
                m0Var.d();
            }
        }
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, com.bumptech.glide.load.r rVar) {
        return this.a.p(inputStream);
    }
}
