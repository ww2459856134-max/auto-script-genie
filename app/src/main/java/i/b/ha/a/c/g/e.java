package i.b.ha.a.c.g;

import i.b.ha.a.c.g.e;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class e<T, B extends e<T, B>> extends g<T, B> {
    private d<?, ?> a;

    protected static b e(byte[] bArr) {
        return new b(bArr);
    }

    protected static c f(InputStream inputStream) {
        return new c(inputStream);
    }

    protected d<?, ?> d() {
        d<?, ?> dVar = this.a;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException("origin == null");
    }

    public B g(byte[] bArr) {
        return (B) i(e(bArr));
    }

    public B h(InputStream inputStream) {
        return (B) i(f(inputStream));
    }

    protected B i(d<?, ?> dVar) {
        this.a = dVar;
        c();
        return this;
    }
}
