package n.b.a.m;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class c<T> implements Iterator<T> {
    private final T c;
    private boolean d = false;

    @Deprecated
    public c(T t) {
        this.c = t;
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.d;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.d) {
            throw new NoSuchElementException();
        }
        this.d = true;
        return this.c;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Can not remove item from SingletonIterator.");
    }
}
