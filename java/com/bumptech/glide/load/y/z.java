package com.bumptech.glide.load.y;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class z implements y<InputStream> {
    z() {
    }

    @Override // com.bumptech.glide.load.y.y
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.y.y
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.y.y
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public InputStream c(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}
