package com.bumptech.glide.u;

import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class c {
    private final d a;
    private final boolean[] b;
    private boolean c;
    final /* synthetic */ f d;

    /* synthetic */ c(f fVar, d dVar, a aVar) {
        this(fVar, dVar);
    }

    public void a() throws IOException {
        this.d.q(this, false);
    }

    public void b() {
        if (this.c) {
            return;
        }
        try {
            a();
        } catch (IOException unused) {
        }
    }

    public void e() throws IOException {
        this.d.q(this, true);
        this.c = true;
    }

    public File f(int i2) throws IOException {
        File fileK;
        synchronized (this.d) {
            if (this.a.f != this) {
                throw new IllegalStateException();
            }
            if (!this.a.e) {
                this.b[i2] = true;
            }
            fileK = this.a.k(i2);
            if (!this.d.c.exists()) {
                this.d.c.mkdirs();
            }
        }
        return fileK;
    }

    private c(f fVar, d dVar) {
        this.d = fVar;
        this.a = dVar;
        this.b = dVar.e ? null : new boolean[fVar.f678i];
    }
}
