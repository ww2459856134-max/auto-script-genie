package com.bumptech.glide.load.x.h1;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class j implements c {
    private final File b;
    private final long c;
    private com.bumptech.glide.u.f e;
    private final g d = new g();
    private final v a = new v();

    @Deprecated
    protected j(File file, long j2) {
        this.b = file;
        this.c = j2;
    }

    public static c c(File file, long j2) {
        return new j(file, j2);
    }

    private synchronized com.bumptech.glide.u.f d() throws IOException {
        if (this.e == null) {
            this.e = com.bumptech.glide.u.f.D(this.b, 1, 1, this.c);
        }
        return this.e;
    }

    @Override // com.bumptech.glide.load.x.h1.c
    public void a(com.bumptech.glide.load.n nVar, b bVar) {
        com.bumptech.glide.u.f fVarD;
        String strB = this.a.b(nVar);
        this.d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + nVar);
            }
            try {
                fVarD = d();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (fVarD.z(strB) != null) {
                return;
            }
            com.bumptech.glide.u.c cVarW = fVarD.w(strB);
            if (cVarW == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strB);
            }
            try {
                if (bVar.a(cVarW.f(0))) {
                    cVarW.e();
                }
                cVarW.b();
            } catch (Throwable th) {
                cVarW.b();
                throw th;
            }
        } finally {
            this.d.b(strB);
        }
    }

    @Override // com.bumptech.glide.load.x.h1.c
    public File b(com.bumptech.glide.load.n nVar) {
        String strB = this.a.b(nVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + nVar);
        }
        try {
            com.bumptech.glide.u.e eVarZ = d().z(strB);
            if (eVarZ != null) {
                return eVarZ.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }
}
