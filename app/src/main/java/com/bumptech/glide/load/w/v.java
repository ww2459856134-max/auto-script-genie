package com.bumptech.glide.load.w;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes.dex */
public final class v implements g<ParcelFileDescriptor> {
    private final u a;

    public v(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new u(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // com.bumptech.glide.load.w.g
    public void b() {
    }

    @Override // com.bumptech.glide.load.w.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor a() throws IOException {
        return this.a.a();
    }
}
