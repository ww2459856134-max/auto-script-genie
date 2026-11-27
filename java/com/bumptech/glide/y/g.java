package com.bumptech.glide.y;

import com.bumptech.glide.load.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class g {
    private final List<String> a = new ArrayList();
    private final Map<String, List<f<?, ?>>> b = new HashMap();

    private synchronized List<f<?, ?>> c(String str) {
        List<f<?, ?>> arrayList;
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        arrayList = this.b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.b.put(str, arrayList);
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, t<T, R> tVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new f<>(cls, cls2, tVar));
    }

    public synchronized <T, R> List<t<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            List<f<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (f<?, ?> fVar : list) {
                    if (fVar.a(cls, cls2)) {
                        arrayList.add(fVar.c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            List<f<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (f<?, ?> fVar : list) {
                    if (fVar.a(cls, cls2) && !arrayList.contains(fVar.b)) {
                        arrayList.add(fVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.a);
        this.a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.a.add(it.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.a.add(str);
            }
        }
    }
}
