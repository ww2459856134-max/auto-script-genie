package com.bumptech.glide.load.x;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class w<DataType, ResourceType, Transcode> {
    private final Class<DataType> a;
    private final List<? extends com.bumptech.glide.load.t<DataType, ResourceType>> b;
    private final com.bumptech.glide.load.z.k.e<ResourceType, Transcode> c;
    private final h.e.i.e<List<Throwable>> d;
    private final String e;

    public w(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.t<DataType, ResourceType>> list, com.bumptech.glide.load.z.k.e<ResourceType, Transcode> eVar, h.e.i.e<List<Throwable>> eVar2) {
        this.a = cls;
        this.b = list;
        this.c = eVar;
        this.d = eVar2;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private z0<ResourceType> b(com.bumptech.glide.load.w.g<DataType> gVar, int i2, int i3, com.bumptech.glide.load.r rVar) throws t0 {
        List<Throwable> listA = this.d.a();
        com.bumptech.glide.b0.n.d(listA);
        List<Throwable> list = listA;
        try {
            return c(gVar, i2, i3, rVar, list);
        } finally {
            this.d.b(list);
        }
    }

    private z0<ResourceType> c(com.bumptech.glide.load.w.g<DataType> gVar, int i2, int i3, com.bumptech.glide.load.r rVar, List<Throwable> list) throws t0 {
        int size = this.b.size();
        z0<ResourceType> z0VarB = null;
        for (int i4 = 0; i4 < size; i4++) {
            com.bumptech.glide.load.t<DataType, ResourceType> tVar = this.b.get(i4);
            try {
                if (tVar.a(gVar.a(), rVar)) {
                    z0VarB = tVar.b(gVar.a(), i2, i3, rVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + tVar, e);
                }
                list.add(e);
            }
            if (z0VarB != null) {
                break;
            }
        }
        if (z0VarB != null) {
            return z0VarB;
        }
        throw new t0(this.e, new ArrayList(list));
    }

    public z0<Transcode> a(com.bumptech.glide.load.w.g<DataType> gVar, int i2, int i3, com.bumptech.glide.load.r rVar, v<ResourceType> vVar) throws t0 {
        return this.c.a(vVar.a(b(gVar, i2, i3, rVar)), rVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
