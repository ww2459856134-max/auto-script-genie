package n.a.a.n.c.t1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
class l8 implements Iterator<Integer> {
    private int c;
    final /* synthetic */ m8 d;

    l8(m8 m8Var) {
        this.d = m8Var;
        this.c = m8Var.getSize() - 1;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer next() {
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 >= 0) {
            return Integer.valueOf(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c > 0;
    }
}
