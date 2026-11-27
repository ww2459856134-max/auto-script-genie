package androidx.lifecycle;

import androidx.lifecycle.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class b {
    final int a;
    final Method b;

    b(int i2, Method method) {
        this.a = i2;
        this.b = method;
        method.setAccessible(true);
    }

    void a(i iVar, f.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            int i2 = this.a;
            if (i2 == 0) {
                this.b.invoke(obj, new Object[0]);
            } else if (i2 == 1) {
                this.b.invoke(obj, iVar);
            } else {
                if (i2 != 2) {
                    return;
                }
                this.b.invoke(obj, iVar, aVar);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to call observer method", e2.getCause());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
    }

    public int hashCode() {
        return (this.a * 31) + this.b.getName().hashCode();
    }
}
