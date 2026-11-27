package n.a.a.n.c.t1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
class k8 implements Iterator<Integer> {
    private int c = 0;
    final /* synthetic */ m8 d;

    k8(m8 m8Var) {
        this.d = m8Var;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.c;
        this.c = i2 + 1;
        return Integer.valueOf(i2);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c < this.d.getSize();
    }
}
