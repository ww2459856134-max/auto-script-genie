package com.bumptech.glide.load.x.h1;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
class k implements h {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    k(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // com.bumptech.glide.load.x.h1.h
    public File a() {
        File cacheDir = this.a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        return this.b != null ? new File(cacheDir, this.b) : cacheDir;
    }
}
