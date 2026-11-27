package com.bumptech.glide.load.y;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
class v implements y<ParcelFileDescriptor> {
    v() {
    }

    @Override // com.bumptech.glide.load.y.y
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.y.y
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.y.y
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor c(File file) throws FileNotFoundException {
        return ParcelFileDescriptor.open(file, 268435456);
    }
}
