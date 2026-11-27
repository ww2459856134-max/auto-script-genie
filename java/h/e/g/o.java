package h.e.g;

import android.net.Uri;

/* loaded from: classes.dex */
public class o {
    private final Uri a;
    private final int b;
    private final int c;
    private final boolean d;
    private final int e;

    @Deprecated
    public o(Uri uri, int i2, int i3, boolean z, int i4) {
        h.e.i.h.d(uri);
        this.a = uri;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = i4;
    }

    static o a(Uri uri, int i2, int i3, boolean z, int i4) {
        return new o(uri, i2, i3, z, i4);
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.b;
    }

    public Uri d() {
        return this.a;
    }

    public int e() {
        return this.c;
    }

    public boolean f() {
        return this.d;
    }
}
