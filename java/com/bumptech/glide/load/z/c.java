package com.bumptech.glide.load.z;

import android.graphics.ImageDecoder;
import com.bumptech.glide.load.q;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.s;
import com.bumptech.glide.load.t;
import com.bumptech.glide.load.x.z0;
import com.bumptech.glide.load.z.f.e0;
import com.bumptech.glide.load.z.f.v;
import com.bumptech.glide.load.z.f.y;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class c<T> implements t<ImageDecoder.Source, T> {
    final e0 a = e0.a();

    protected abstract z0<T> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final z0<T> b(ImageDecoder.Source source, int i2, int i3, r rVar) throws IOException {
        com.bumptech.glide.load.b bVar = (com.bumptech.glide.load.b) rVar.c(y.f);
        v vVar = (v) rVar.c(v.f);
        q<Boolean> qVar = y.f650i;
        return c(source, i2, i3, new b(this, i2, i3, rVar.c(qVar) != null && ((Boolean) rVar.c(qVar)).booleanValue(), bVar, vVar, (s) rVar.c(y.g)));
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final boolean a(ImageDecoder.Source source, r rVar) {
        return true;
    }
}
