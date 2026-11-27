package i.b.ha.a.a.k;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class a<E> implements i.b.ha.a.a.i<E> {
    protected a() {
    }

    @Deprecated
    public void add(E e) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.Iterator
    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int nextIndex() {
        return 0;
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int previousIndex() {
        return -1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void set(E e) {
        throw new IllegalStateException("Iterator contains no elements");
    }
}
