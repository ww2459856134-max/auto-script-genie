package com.bumptech.glide.load.z.j;

import android.util.Log;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.u;
import com.bumptech.glide.load.x.z0;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class g implements u<f> {
    @Override // com.bumptech.glide.load.u
    public com.bumptech.glide.load.c b(r rVar) {
        return com.bumptech.glide.load.c.SOURCE;
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(z0<f> z0Var, File file, r rVar) throws Throwable {
        try {
            com.bumptech.glide.b0.c.e(z0Var.get().c(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
