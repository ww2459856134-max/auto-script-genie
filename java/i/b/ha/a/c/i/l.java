package i.b.ha.a.c.i;

import java.io.IOException;

@FunctionalInterface
/* loaded from: classes.dex */
public interface l<T, U> {
    static <T, U> l<T, U> a() {
        return k.a;
    }

    void accept(T t, U u) throws IOException;
}
