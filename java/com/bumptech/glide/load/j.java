package com.bumptech.glide.load;

import com.bumptech.glide.load.z.f.m0;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
class j implements k {
    final /* synthetic */ com.bumptech.glide.load.w.v a;
    final /* synthetic */ com.bumptech.glide.load.x.g1.b b;

    j(com.bumptech.glide.load.w.v vVar, com.bumptech.glide.load.x.g1.b bVar) {
        this.a = vVar;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.load.k
    public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
        m0 m0Var = null;
        try {
            m0 m0Var2 = new m0(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
            try {
                int iB = imageHeaderParser.b(m0Var2, this.b);
                try {
                    m0Var2.close();
                } catch (IOException unused) {
                }
                this.a.a();
                return iB;
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
