package com.jsj.autojs.l;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;

/* loaded from: classes.dex */
class v extends LruCache<String, Drawable> {
    v(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap().getAllocationByteCount();
    }
}
