package i.b.ha.a.a.k;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class c<E> extends d<E, E> {
    protected c(Iterator<E> it) {
        super(it);
    }

    @Override // java.util.Iterator
    public E next() {
        return a().next();
    }
}
