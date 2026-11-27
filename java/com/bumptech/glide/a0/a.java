package com.bumptech.glide.a0;

import android.content.Context;
import com.bumptech.glide.b0.p;
import com.bumptech.glide.load.n;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class a implements n {
    private final int b;
    private final n c;

    private a(int i2, n nVar) {
        this.b = i2;
        this.c = nVar;
    }

    public static n c(Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && this.c.equals(aVar.c);
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return p.m(this.c, this.b);
    }
}
