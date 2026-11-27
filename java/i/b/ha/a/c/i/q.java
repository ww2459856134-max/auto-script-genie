package i.b.ha.a.c.i;

import java.io.IOException;
import java.io.UncheckedIOException;

/* loaded from: classes.dex */
public abstract class q {
    public static <T> T a(p<T> pVar) {
        try {
            return pVar.get();
        } catch (IOException e) {
            throw b(e);
        }
    }

    private static UncheckedIOException b(IOException iOException) {
        return new UncheckedIOException(iOException);
    }
}
