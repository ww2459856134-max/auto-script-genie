package n.a.a.o;

import java.util.Iterator;
import java.util.PrimitiveIterator;

/* loaded from: classes.dex */
final class n0 implements Iterator<String> {
    final /* synthetic */ PrimitiveIterator.OfInt c;

    n0(PrimitiveIterator.OfInt ofInt) {
        this.c = ofInt;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        return new String(Character.toChars(this.c.nextInt()));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c.hasNext();
    }
}
