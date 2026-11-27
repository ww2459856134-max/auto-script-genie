package m;

import java.io.InputStream;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class f {
    static {
        Logger.getLogger(f.class.getName());
    }

    public static c a(l lVar) {
        return new h(lVar);
    }

    static boolean b(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static l c(InputStream inputStream) {
        return d(inputStream, new m());
    }

    private static l d(InputStream inputStream, m mVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (mVar != null) {
            return new e(mVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }
}
