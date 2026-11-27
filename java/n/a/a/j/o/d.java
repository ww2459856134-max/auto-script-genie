package n.a.a.j.o;

import java.io.IOException;
import java.io.InputStream;
import n.a.a.k.b.k;
import n.a.a.k.b.z.g;

/* loaded from: classes.dex */
public abstract class d {
    public static k a(InputStream inputStream, boolean z) throws IOException {
        try {
            try {
                return k.T(inputStream, z);
            } catch (n.a.a.k.a.a e) {
                Throwable cause = e.getCause();
                if (cause instanceof g) {
                    throw ((g) cause);
                }
                throw new n.a.a.j.d(e);
            }
        } finally {
            if (z) {
                inputStream.close();
            }
        }
    }
}
