package com.bumptech.glide.load.x.g1;

import com.bumptech.glide.load.x.g1.t;
import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class k<K extends t, V> {
    private final j<K, V> a = new j<>();
    private final Map<K, j<K, V>> b = new HashMap();

    k() {
    }

    private void b(j<K, V> jVar) {
        e(jVar);
        j<K, V> jVar2 = this.a;
        jVar.d = jVar2;
        jVar.c = jVar2.c;
        g(jVar);
    }

    private void c(j<K, V> jVar) {
        e(jVar);
        j<K, V> jVar2 = this.a;
        jVar.d = jVar2.d;
        jVar.c = jVar2;
        g(jVar);
    }

    private static <K, V> void e(j<K, V> jVar) {
        j<K, V> jVar2 = jVar.d;
        jVar2.c = jVar.c;
        jVar.c.d = jVar2;
    }

    private static <K, V> void g(j<K, V> jVar) {
        jVar.c.d = jVar;
        jVar.d.c = jVar;
    }

    public V a(K k2) {
        j<K, V> jVar = this.b.get(k2);
        if (jVar == null) {
            jVar = new j<>(k2);
            this.b.put(k2, jVar);
        } else {
            k2.a();
        }
        b(jVar);
        return jVar.b();
    }

    public void d(K k2, V v) {
        j<K, V> jVar = this.b.get(k2);
        if (jVar == null) {
            jVar = new j<>(k2);
            c(jVar);
            this.b.put(k2, jVar);
        } else {
            k2.a();
        }
        jVar.a(v);
    }

    public V f() {
        for (j jVar = this.a.d; !jVar.equals(this.a); jVar = jVar.d) {
            V v = (V) jVar.b();
            if (v != null) {
                return v;
            }
            e(jVar);
            this.b.remove(jVar.a);
            ((t) jVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (j jVar = this.a.c; !jVar.equals(this.a); jVar = jVar.c) {
            z = true;
            sb.append('{');
            sb.append(jVar.a);
            sb.append(NameUtil.COLON);
            sb.append(jVar.c());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
