package com.bumptech.glide.load.w;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b<T> implements e<T> {
    private final String c;
    private final AssetManager d;
    private T e;

    public b(AssetManager assetManager, String str) {
        this.d = assetManager;
        this.c = str;
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
        T t = this.e;
        if (t == null) {
            return;
        }
        try {
            e(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, d<? super T> dVar) {
        try {
            T tF = f(this.d, this.c);
            this.e = tF;
            dVar.e(tF);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dVar.f(e);
        }
    }

    protected abstract void e(T t) throws IOException;

    protected abstract T f(AssetManager assetManager, String str) throws IOException;
}
