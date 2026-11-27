package com.bumptech.glide.z.l;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.z.l.e
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void r(Bitmap bitmap) {
        ((ImageView) this.c).setImageBitmap(bitmap);
    }
}
