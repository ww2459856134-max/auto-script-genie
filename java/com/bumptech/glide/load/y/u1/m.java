package com.bumptech.glide.load.y.u1;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.y.o0;
import com.bumptech.glide.load.y.p0;
import java.io.File;

/* loaded from: classes.dex */
public final class m<DataT> implements p0<Uri, DataT> {
    private final Context a;
    private final p0<File, DataT> b;
    private final p0<Uri, DataT> c;
    private final Class<DataT> d;

    m(Context context, p0<File, DataT> p0Var, p0<Uri, DataT> p0Var2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.b = p0Var;
        this.c = p0Var2;
        this.d = cls;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<DataT> a(Uri uri, int i2, int i3, r rVar) {
        return new o0<>(new com.bumptech.glide.a0.d(uri), new l(this.a, this.b, this.c, uri, i2, i3, rVar, this.d));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.w.y.b.b(uri);
    }
}
