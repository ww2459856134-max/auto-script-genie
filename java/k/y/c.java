package k.y;

import java.security.AccessControlException;

/* loaded from: classes.dex */
public abstract class c {
    private static c a;

    protected c() {
    }

    public static final c b(Class cls) {
        if (a == null) {
            d();
        }
        c cVar = a;
        cVar.c(cls);
        return cVar;
    }

    private static synchronized void d() {
        if (a != null) {
            return;
        }
        String str = k.y.d.a.a;
        try {
            try {
                try {
                    String property = System.getProperty("logger");
                    if (property != null) {
                        str = property;
                    }
                    a = (c) Class.forName(str).newInstance();
                } catch (InstantiationException unused) {
                    k.y.d.b bVar = new k.y.d.b();
                    a = bVar;
                    bVar.f("Could not instantiate logger " + str + " using default");
                }
            } catch (AccessControlException unused2) {
                k.y.d.b bVar2 = new k.y.d.b();
                a = bVar2;
                bVar2.f("Could not instantiate logger " + str + " using default");
            }
        } catch (ClassNotFoundException unused3) {
            k.y.d.b bVar3 = new k.y.d.b();
            a = bVar3;
            bVar3.f("Could not instantiate logger " + str + " using default");
        } catch (IllegalAccessException unused4) {
            k.y.d.b bVar4 = new k.y.d.b();
            a = bVar4;
            bVar4.f("Could not instantiate logger " + str + " using default");
        }
    }

    public abstract void a(Object obj);

    protected abstract c c(Class cls);

    public abstract void e(boolean z);

    public abstract void f(Object obj);

    public abstract void g(Object obj, Throwable th);
}
