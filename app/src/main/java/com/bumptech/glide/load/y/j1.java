package com.bumptech.glide.load.y;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public class j1<Data> implements p0<String, Data> {
    private final p0<Uri, Data> a;

    public j1(p0<Uri, Data> p0Var) {
        this.a = p0Var;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<Data> a(String str, int i2, int i3, com.bumptech.glide.load.r rVar) {
        Uri uriE = e(str);
        if (uriE == null || !this.a.b(uriE)) {
            return null;
        }
        return this.a.a(uriE, i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(String str) {
        return true;
    }
}
