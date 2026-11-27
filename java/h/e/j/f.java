package h.e.j;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class f {
    ClipData a;
    int b;
    int c;
    Uri d;
    Bundle e;

    public f(ClipData clipData, int i2) {
        this.a = clipData;
        this.b = i2;
    }

    public g a() {
        return new g(this);
    }

    public f b(Bundle bundle) {
        this.e = bundle;
        return this;
    }

    public f c(int i2) {
        this.c = i2;
        return this;
    }

    public f d(Uri uri) {
        this.d = uri;
        return this;
    }
}
