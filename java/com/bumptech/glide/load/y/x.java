package com.bumptech.glide.load.y;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
final class x<Data> implements com.bumptech.glide.load.w.e<Data> {
    private final File c;
    private final y<Data> d;
    private Data e;

    x(File file, y<Data> yVar) {
        this.c = file;
        this.d = yVar;
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<Data> a() {
        return this.d.a();
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
        Data data = this.e;
        if (data != null) {
            try {
                this.d.b(data);
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

    /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super Data> dVar) {
        try {
            Data dataC = this.d.c(this.c);
            this.e = dataC;
            dVar.e(dataC);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("FileLoader", 3)) {
                Log.d("FileLoader", "Failed to open file", e);
            }
            dVar.f(e);
        }
    }
}
