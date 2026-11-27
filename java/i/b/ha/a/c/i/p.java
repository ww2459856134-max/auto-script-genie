package i.b.ha.a.c.i;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Supplier;

@FunctionalInterface
/* loaded from: classes.dex */
public interface p<T> {
    default Supplier<T> a() {
        return new Supplier() { // from class: i.b.ha.a.c.i.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.b();
            }
        };
    }

    default T b() throws UncheckedIOException {
        return (T) q.a(this);
    }

    T get() throws IOException;
}
