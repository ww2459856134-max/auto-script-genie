package com.bumptech.glide.load.y;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class v0<Model, Data> implements p0<Model, Data> {
    private final List<p0<Model, Data>> a;
    private final h.e.i.e<List<Throwable>> b;

    v0(List<p0<Model, Data>> list, h.e.i.e<List<Throwable>> eVar) {
        this.a = list;
        this.b = eVar;
    }

    @Override // com.bumptech.glide.load.y.p0
    public o0<Data> a(Model model, int i2, int i3, com.bumptech.glide.load.r rVar) {
        o0<Data> o0VarA;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.n nVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            p0<Model, Data> p0Var = this.a.get(i4);
            if (p0Var.b(model) && (o0VarA = p0Var.a(model, i2, i3, rVar)) != null) {
                nVar = o0VarA.a;
                arrayList.add(o0VarA.c);
            }
        }
        if (arrayList.isEmpty() || nVar == null) {
            return null;
        }
        return new o0<>(nVar, new u0(arrayList, this.b));
    }

    @Override // com.bumptech.glide.load.y.p0
    public boolean b(Model model) {
        Iterator<p0<Model, Data>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().b(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }
}
