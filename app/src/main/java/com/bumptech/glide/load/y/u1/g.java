package com.bumptech.glide.load.y.u1;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.y.p0;
import com.bumptech.glide.load.y.q0;
import com.bumptech.glide.load.y.z0;
import java.io.InputStream;

/* loaded from: classes.dex */
public class g implements q0<Uri, InputStream> {
    private final Context a;

    public g(Context context) {
        this.a = context;
    }

    @Override // com.bumptech.glide.load.y.q0
    public p0<Uri, InputStream> b(z0 z0Var) {
        return new h(this.a);
    }
}
