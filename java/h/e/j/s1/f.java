package h.e.j.s1;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
final class f implements h {
    final InputContentInfo a;

    f(Object obj) {
        this.a = (InputContentInfo) obj;
    }

    @Override // h.e.j.s1.h
    public Object a() {
        return this.a;
    }

    @Override // h.e.j.s1.h
    public Uri b() {
        return this.a.getContentUri();
    }

    @Override // h.e.j.s1.h
    public void c() {
        this.a.requestPermission();
    }

    @Override // h.e.j.s1.h
    public Uri d() {
        return this.a.getLinkUri();
    }

    @Override // h.e.j.s1.h
    public ClipDescription getDescription() {
        return this.a.getDescription();
    }

    f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.a = new InputContentInfo(uri, clipDescription, uri2);
    }
}
