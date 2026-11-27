package org.apache.xmlbeans.impl.logging;

import com.auto.exceldeps.log4j.LogManager;
import com.auto.exceldeps.log4j.Logger;
import org.apache.xmlbeans.impl.util.ExceptionUtil;

/* loaded from: classes.dex */
public final class XmlBeansLogManager {
    private static long LAST_TIME = 0;
    private static final long SLEEP_TIME = 600000;

    private XmlBeansLogManager() {
    }

    public static Logger getLogger(Class<?> cls) {
        try {
            Logger logger = LogManager.getLogger(cls);
            if (logger != null) {
                return logger;
            }
            if (shouldLog()) {
                System.err.println("[XmlBeansLogManager] Log4J returned null logger. Falling back to No-Op logger.");
            }
            return NoOpLogger.INSTANCE;
        } catch (Throwable th) {
            if (!ExceptionUtil.isFatal(th) && shouldLog()) {
                System.err.println("[XmlBeansLogManager] Issue loading Log4J. Falling back to No-Op logger.");
                th.printStackTrace();
            }
            return NoOpLogger.INSTANCE;
        }
    }

    private static synchronized boolean shouldLog() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis <= LAST_TIME + SLEEP_TIME) {
            return false;
        }
        LAST_TIME = jCurrentTimeMillis;
        return true;
    }
}
