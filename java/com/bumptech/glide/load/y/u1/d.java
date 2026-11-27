package com.bumptech.glide.load.y.u1;

import android.net.Uri;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.y.c0;
import com.bumptech.glide.load.y.o0;
import com.bumptech.glide.load.y.p0;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d implements p0<Uri, InputStream> {
    private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final p0<c0, InputStream> a;

    public d(p0<c0, InputStream> p0Var) {
        this.a = p0Var;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<InputStream> a(Uri uri, int i2, int i3, r rVar) {
        return this.a.a(new c0(uri.toString()), i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
