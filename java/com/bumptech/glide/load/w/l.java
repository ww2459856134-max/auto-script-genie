package com.bumptech.glide.load.w;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes.dex */
public class l extends b<ParcelFileDescriptor> {
    public l(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.w.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.w.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor f(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
