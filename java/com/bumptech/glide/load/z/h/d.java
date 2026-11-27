package com.bumptech.glide.load.z.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.t;
import com.bumptech.glide.load.x.z0;
import java.util.List;

/* loaded from: classes.dex */
public class d implements t<Uri, Drawable> {
    private final Context a;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
            return this.a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.a.getPackageName())) {
                return this.a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public z0<Drawable> b(Uri uri, int i2, int i3, r rVar) {
        Context contextD = d(uri, uri.getAuthority());
        return c.e(a.b(this.a, contextD, g(contextD, uri)));
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, r rVar) {
        return uri.getScheme().equals("android.resource");
    }
}
