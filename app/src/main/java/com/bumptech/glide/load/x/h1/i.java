package com.bumptech.glide.load.x.h1;

import java.io.File;

/* loaded from: classes.dex */
public abstract class i implements a {
    private final long a;
    private final h b;

    public i(h hVar, long j2) {
        this.a = j2;
        this.b = hVar;
    }

    @Override // com.bumptech.glide.load.x.h1.a
    public c a() {
        File fileA = this.b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return j.c(fileA, this.a);
        }
        return null;
    }
}
