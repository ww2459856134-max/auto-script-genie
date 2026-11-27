package h.e.j.s1;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;

/* loaded from: classes.dex */
public final class i {
    private final h a;

    public i(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.a = new f(uri, clipDescription, uri2);
        } else {
            this.a = new g(uri, clipDescription, uri2);
        }
    }

    public static i f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new i(new f(obj));
        }
        return null;
    }

    public Uri a() {
        return this.a.b();
    }

    public ClipDescription b() {
        return this.a.getDescription();
    }

    public Uri c() {
        return this.a.d();
    }

    public void d() {
        this.a.c();
    }

    public Object e() {
        return this.a.a();
    }

    private i(h hVar) {
        this.a = hVar;
    }
}
