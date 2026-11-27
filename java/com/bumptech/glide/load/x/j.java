package com.bumptech.glide.load.x;

import java.io.File;

/* loaded from: classes.dex */
class j<DataType> implements com.bumptech.glide.load.x.h1.b {
    private final com.bumptech.glide.load.d<DataType> a;
    private final DataType b;
    private final com.bumptech.glide.load.r c;

    j(com.bumptech.glide.load.d<DataType> dVar, DataType datatype, com.bumptech.glide.load.r rVar) {
        this.a = dVar;
        this.b = datatype;
        this.c = rVar;
    }

    @Override // com.bumptech.glide.load.x.h1.b
    public boolean a(File file) {
        return this.a.a(this.b, file, this.c);
    }
}
