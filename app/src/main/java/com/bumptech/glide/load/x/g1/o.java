package com.bumptech.glide.load.x.g1;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class o implements b {
    private final k<m, Object> a = new k<>();
    private final n b = new n();
    private final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
    private final Map<Class<?>, a<?>> d = new HashMap();
    private final int e;
    private int f;

    public o(int i2) {
        this.e = i2;
    }

    private void f(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapM = m(cls);
        Integer num = (Integer) navigableMapM.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapM.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapM.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private void g() {
        h(this.e);
    }

    private void h(int i2) {
        while (this.f > i2) {
            Object objF = this.a.f();
            com.bumptech.glide.b0.n.d(objF);
            a aVarI = i(objF);
            this.f -= aVarI.a(objF) * aVarI.b();
            f(aVarI.a(objF), objF.getClass());
            if (Log.isLoggable(aVarI.getTag(), 2)) {
                Log.v(aVarI.getTag(), "evicted: " + aVarI.a(objF));
            }
        }
    }

    private <T> a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> a<T> j(Class<T> cls) {
        a<T> iVar = (a) this.d.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new l();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                iVar = new i();
            }
            this.d.put(cls, iVar);
        }
        return iVar;
    }

    private <T> T k(m mVar) {
        return (T) this.a.a(mVar);
    }

    private <T> T l(m mVar, Class<T> cls) {
        a<T> aVarJ = j(cls);
        T t = (T) k(mVar);
        if (t != null) {
            this.f -= aVarJ.a(t) * aVarJ.b();
            f(aVarJ.a(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(aVarJ.getTag(), 2)) {
            Log.v(aVarJ.getTag(), "Allocated " + mVar.b + " bytes");
        }
        return aVarJ.newArray(mVar.b);
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i2 = this.f;
        return i2 == 0 || this.e / i2 >= 2;
    }

    private boolean o(int i2) {
        return i2 <= this.e / 2;
    }

    private boolean p(int i2, Integer num) {
        return num != null && (n() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.x.g1.b
    public synchronized void a(int i2) {
        try {
            if (i2 >= 40) {
                b();
            } else if (i2 >= 20 || i2 == 15) {
                h(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.x.g1.b
    public synchronized void b() {
        h(0);
    }

    @Override // com.bumptech.glide.load.x.g1.b
    public synchronized <T> T c(int i2, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = m(cls).ceilingKey(Integer.valueOf(i2));
        return (T) l(p(i2, numCeilingKey) ? this.b.e(numCeilingKey.intValue(), cls) : this.b.e(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.x.g1.b
    public synchronized <T> T d(int i2, Class<T> cls) {
        return (T) l(this.b.e(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.x.g1.b
    public synchronized <T> void e(T t) {
        Class<?> cls = t.getClass();
        a<T> aVarJ = j(cls);
        int iA = aVarJ.a(t);
        int iB = aVarJ.b() * iA;
        if (o(iB)) {
            m mVarE = this.b.e(iA, cls);
            this.a.d(mVarE, t);
            NavigableMap<Integer, Integer> navigableMapM = m(cls);
            Integer num = (Integer) navigableMapM.get(Integer.valueOf(mVarE.b));
            Integer numValueOf = Integer.valueOf(mVarE.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iB;
            g();
        }
    }
}
