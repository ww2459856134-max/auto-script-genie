package com.bumptech.glide.load.w;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class s<T> implements e<T> {
    private final Uri c;
    private final ContentResolver d;
    private T e;

    public s(ContentResolver contentResolver, Uri uri) {
        this.d = contentResolver;
        this.c = uri;
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
        T t = this.e;
        if (t != null) {
            try {
                e(t);
            } catch (IOException unused) {
            }
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
    public final void d(com.bumptech.glide.h hVar, d<? super T> dVar) {
        try {
            T tF = f(this.c, this.d);
            this.e = tF;
            dVar.e(tF);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            dVar.f(e);
        }
    }

    protected abstract void e(T t) throws IOException;

    protected abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
