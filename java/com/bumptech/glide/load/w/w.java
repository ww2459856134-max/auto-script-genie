package com.bumptech.glide.load.w;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class w extends b<InputStream> {
    public w(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.w.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.w.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public InputStream f(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
