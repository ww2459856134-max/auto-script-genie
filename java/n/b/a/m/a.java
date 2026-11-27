package n.b.a.m;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class a implements Iterator<Object> {
    static final Iterator<?> c = new a();

    private a() {
    }

    public static <T> Iterator<T> a() {
        return (Iterator<T>) c;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException();
    }
}
