package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.f;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements g {
    private final Object a;
    private final a.C0001a b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = a.c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.g
    public void a(i iVar, f.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.b.a(iVar, aVar, this.a);
    }
}
