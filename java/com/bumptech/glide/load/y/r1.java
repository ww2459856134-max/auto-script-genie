package com.bumptech.glide.load.y;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class r1<Data> implements p0<Uri, Data> {
    private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));
    private final p1<Data> a;

    public r1(p1<Data> p1Var) {
        this.a = p1Var;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<Data> a(Uri uri, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(uri), this.a.a(uri));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
