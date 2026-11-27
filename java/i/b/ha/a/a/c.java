package i.b.ha.a.a;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class c {
    public static <T> List<T> a(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static int b(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        int iHashCode = 1;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next == null ? 0 : next.hashCode());
        }
        return iHashCode;
    }

    public static boolean c(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection.iterator();
        Iterator<?> it2 = collection2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!Objects.equals(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }
}
