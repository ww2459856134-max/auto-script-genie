package i.e.a.l;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d<T> implements Iterator<T> {
    static final d<Object> c = new d<>();

    private d() {
    }

    public static <T> d<T> a() {
        return (d<T>) c;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException();
    }
}
