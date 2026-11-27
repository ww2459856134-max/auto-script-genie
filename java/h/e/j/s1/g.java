package h.e.j.s1;

import android.content.ClipDescription;
import android.net.Uri;

/* loaded from: classes.dex */
final class g implements h {
    private final Uri a;
    private final ClipDescription b;
    private final Uri c;

    g(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.a = uri;
        this.b = clipDescription;
        this.c = uri2;
    }

    @Override // h.e.j.s1.h
    public Object a() {
        return null;
    }

    @Override // h.e.j.s1.h
    public Uri b() {
        return this.a;
    }

    @Override // h.e.j.s1.h
    public void c() {
    }

    @Override // h.e.j.s1.h
    public Uri d() {
        return this.c;
    }

    @Override // h.e.j.s1.h
    public ClipDescription getDescription() {
        return this.b;
    }
}
