package com.bumptech.glide.load.y;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class t1<Data> implements p0<Uri, Data> {
    private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final p0<c0, Data> a;

    public t1(p0<c0, Data> p0Var) {
        this.a = p0Var;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<Data> a(Uri uri, int i2, int i3, com.bumptech.glide.load.r rVar) {
        return this.a.a(new c0(uri.toString()), i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
