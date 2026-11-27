package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.z.f.m0;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
class h implements l {
    final /* synthetic */ com.bumptech.glide.load.w.v a;
    final /* synthetic */ com.bumptech.glide.load.x.g1.b b;

    h(com.bumptech.glide.load.w.v vVar, com.bumptech.glide.load.x.g1.b bVar) {
        this.a = vVar;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.load.l
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
        m0 m0Var = null;
        try {
            m0 m0Var2 = new m0(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
            try {
                ImageHeaderParser.ImageType imageTypeA = imageHeaderParser.a(m0Var2);
                try {
                    m0Var2.close();
                } catch (IOException unused) {
                }
                this.a.a();
                return imageTypeA;
            } catch (Throwable th) {
                th = th;
                m0Var = m0Var2;
                if (m0Var != null) {
                    try {
                        m0Var.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
