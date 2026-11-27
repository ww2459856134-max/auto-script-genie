package n.a.a.o;

import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class k1 {
    private static l1 a = new p0();
    private static final ThreadLocal<l1> b;

    static {
        final ThreadLocal<l1> threadLocal = new ThreadLocal<>();
        b = threadLocal;
        m1.a(new Runnable() { // from class: n.a.a.o.v
            @Override // java.lang.Runnable
            public final void run() {
                threadLocal.remove();
            }
        });
    }

    public static File a(String str, String str2) throws IOException {
        return b().a(str, str2);
    }

    private static l1 b() {
        ThreadLocal<l1> threadLocal = b;
        l1 l1Var = threadLocal.get();
        if (l1Var != null) {
            return l1Var;
        }
        threadLocal.remove();
        return a;
    }
}
