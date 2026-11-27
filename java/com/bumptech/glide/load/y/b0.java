package com.bumptech.glide.load.y;

import java.io.File;

/* loaded from: classes.dex */
public class b0<Data> implements p0<File, Data> {
    private final y<Data> a;

    public b0(y<Data> yVar) {
        this.a = yVar;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<Data> a(File file, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(file), new x(file, this.a));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(File file) {
        return true;
    }
}
