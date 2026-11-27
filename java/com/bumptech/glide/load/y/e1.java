package com.bumptech.glide.load.y;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* loaded from: classes.dex */
public class e1<Data> implements p0<Integer, Data> {
    private final p0<Uri, Data> a;
    private final Resources b;

    public e1(Resources resources, p0<Uri, Data> p0Var) {
        this.b = resources;
        this.a = p0Var;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<Data> a(Integer num, int i2, int i3, com.bumptech.glide.load.r rVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.a.a(uriD, i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(Integer num) {
        return true;
    }
}
