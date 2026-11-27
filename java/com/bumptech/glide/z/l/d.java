package com.bumptech.glide.z.l;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.z.l.e
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void r(Drawable drawable) {
        ((ImageView) this.c).setImageDrawable(drawable);
    }
}
