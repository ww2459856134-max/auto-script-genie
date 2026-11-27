package i.b.ha.a.a.k;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class d<I, O> implements Iterator<O> {
    private final Iterator<I> c;

    protected d(Iterator<I> it) {
        Objects.requireNonNull(it, "iterator");
        this.c = it;
    }

    protected Iterator<I> a() {
        return this.c;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.c.remove();
    }
}
