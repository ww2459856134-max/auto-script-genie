package com.bumptech.glide.load.x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class w0<Data, ResourceType, Transcode> {
    private final h.e.i.e<List<Throwable>> a;
    private final List<? extends w<Data, ResourceType, Transcode>> b;
    private final String c;

    public w0(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<w<Data, ResourceType, Transcode>> list, h.e.i.e<List<Throwable>> eVar) {
        this.a = eVar;
        com.bumptech.glide.b0.n.c(list);
        this.b = list;
        this.c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private z0<Transcode> b(com.bumptech.glide.load.w.g<Data> gVar, com.bumptech.glide.load.r rVar, int i2, int i3, v<ResourceType> vVar, List<Throwable> list) throws t0 {
        int size = this.b.size();
        z0<Transcode> z0VarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                z0VarA = this.b.get(i4).a(gVar, i2, i3, rVar, vVar);
            } catch (t0 e) {
                list.add(e);
            }
            if (z0VarA != null) {
                break;
            }
        }
        if (z0VarA != null) {
            return z0VarA;
        }
        throw new t0(this.c, new ArrayList(list));
    }

    public z0<Transcode> a(com.bumptech.glide.load.w.g<Data> gVar, com.bumptech.glide.load.r rVar, int i2, int i3, v<ResourceType> vVar) throws t0 {
        List<Throwable> listA = this.a.a();
        com.bumptech.glide.b0.n.d(listA);
        List<Throwable> list = listA;
        try {
            return b(gVar, rVar, i2, i3, vVar, list);
        } finally {
            this.a.b(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + '}';
    }
}
