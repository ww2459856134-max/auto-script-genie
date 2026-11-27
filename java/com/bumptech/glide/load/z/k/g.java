package com.bumptech.glide.load.z.k;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class g {
    private final List<f<?, ?>> a = new ArrayList();

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return h.b();
        }
        for (f<?, ?> fVar : this.a) {
            if (fVar.a(cls, cls2)) {
                return (e<Z, R>) fVar.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<f<?, ?>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.a.add(new f<>(cls, cls2, eVar));
    }
}
