package i.e.a.l;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class g implements Iterator<String> {
    private final String c;
    private boolean d = false;

    public g(String str) {
        this.c = str;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (this.d) {
            throw new NoSuchElementException();
        }
        this.d = true;
        return this.c;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.d;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
