package com.bumptech.glide.load.y;

import android.content.Context;
import android.net.Uri;
import java.io.File;

/* loaded from: classes.dex */
public final class i0 implements q0<Uri, File> {
    private final Context a;

    public i0(Context context) {
        this.a = context;
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Uri, File> b(z0 z0Var) {
        return new k0(this.a);
    }
}
