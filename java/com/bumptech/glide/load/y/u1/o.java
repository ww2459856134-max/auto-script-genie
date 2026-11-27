package com.bumptech.glide.load.y.u1;

import com.bumptech.glide.load.r;
import com.bumptech.glide.load.y.c0;
import com.bumptech.glide.load.y.o0;
import com.bumptech.glide.load.y.p0;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class o implements p0<URL, InputStream> {
    private final p0<c0, InputStream> a;

    public o(p0<c0, InputStream> p0Var) {
        this.a = p0Var;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<InputStream> a(URL url, int i2, int i3, r rVar) {
        return this.a.a(new c0(url), i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(URL url) {
        return true;
    }
}
