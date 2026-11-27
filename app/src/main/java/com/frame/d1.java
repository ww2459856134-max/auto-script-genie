package com.frame;

import android.util.LruCache;

/* loaded from: classes.dex */
class d1 extends LruCache<String, String> {
    d1(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, String str2) {
        return str2.length();
    }
}
