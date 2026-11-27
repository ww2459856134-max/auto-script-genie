package n.a.a.n.e;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import n.a.a.n.d.e;

/* loaded from: classes.dex */
public final class d0<K extends n.a.a.n.d.e> implements n.a.a.n.d.g<K> {
    private final K[] c;

    private d0(int i2, int i3, int i4, int i5, K[] kArr) {
        this.c = (K[]) ((n.a.a.n.d.e[]) kArr.clone());
    }

    public static <B extends n.a.a.n.d.e> d0<B> a(int i2, int i3, int i4, int i5, List<B> list, Class<B> cls) {
        int size = list.size();
        if (i4 * i5 != size) {
            throw new IllegalArgumentException("Array size mismatch.");
        }
        n.a.a.n.d.e[] eVarArr = (n.a.a.n.d.e[]) Array.newInstance((Class<?>) cls, size);
        list.toArray(eVarArr);
        return new d0<>(i2, i3, i4, i5, eVarArr);
    }

    @Override // n.a.a.n.d.g, java.lang.Iterable
    public Iterator<K> iterator() {
        return Stream.of((Object[]) this.c).iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<K> spliterator() {
        return Stream.of((Object[]) this.c).spliterator();
    }
}
