package n.a.a.i;

import com.auto.exceldeps.log4j.LogManager;
import com.auto.exceldeps.log4j.Logger;
import n.a.a.o.q0;

/* loaded from: classes.dex */
public abstract class b {
    private static long a;

    public static Logger a(Class<?> cls) {
        try {
            Logger logger = LogManager.getLogger(cls);
            if (logger != null) {
                return logger;
            }
            if (c()) {
                System.err.println("[PoiLogManager] Log4J returned null logger. Falling back to No-Op logger.");
            }
            return a.c;
        } catch (Throwable th) {
            if (!q0.a(th) && c()) {
                System.err.println("[PoiLogManager] Issue loading Log4J. Falling back to No-Op logger.");
                th.printStackTrace();
            }
            return a.c;
        }
    }

    public static Logger b(String str) {
        try {
            Logger logger = LogManager.getLogger(str);
            if (logger != null) {
                return logger;
            }
            if (c()) {
                System.err.println("[PoiLogManager] Log4J returned null logger. Falling back to No-Op logger.");
            }
            return a.c;
        } catch (Throwable th) {
            if (!q0.a(th) && c()) {
                System.err.println("[PoiLogManager] Issue loading Log4J. Falling back to No-Op logger.");
                th.printStackTrace();
            }
            return a.c;
        }
    }

    private static synchronized boolean c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis <= a + 600000) {
            return false;
        }
        a = jCurrentTimeMillis;
        return true;
    }
}
