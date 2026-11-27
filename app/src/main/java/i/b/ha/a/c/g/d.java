package i.b.ha.a.c.g;

import i.b.ha.a.c.g.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.OpenOption;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class d<T, B extends d<T, B>> extends g<T, B> {
    final T a;

    protected d(T t) {
        Objects.requireNonNull(t, "origin");
        this.a = t;
    }

    private String f() {
        return getClass().getSimpleName();
    }

    public abstract byte[] d() throws IOException;

    public abstract InputStream e(OpenOption... openOptionArr) throws IOException;

    @Override // i.b.ha.a.c.i.p
    public T get() {
        return this.a;
    }

    public String toString() {
        return f() + "[" + this.a.toString() + "]";
    }
}
