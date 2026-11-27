package com.bumptech.glide.load.y.u1;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.y.p0;
import com.bumptech.glide.load.y.q0;
import com.bumptech.glide.load.y.z0;
import java.io.File;

/* loaded from: classes.dex */
abstract class i<DataT> implements q0<Uri, DataT> {
    private final Context a;
    private final Class<DataT> b;

    i(Context context, Class<DataT> cls) {
        this.a = context;
        this.b = cls;
    }

    @Override // com.bumptech.glide.load.y.q0
    public final p0<Uri, DataT> b(z0 z0Var) {
        return new m(this.a, z0Var.d(File.class, this.b), z0Var.d(Uri.class, this.b), this.b);
    }
}
