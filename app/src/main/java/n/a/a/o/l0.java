package n.a.a.o;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: classes.dex */
public abstract class l0 {
    private static final ConcurrentHashMap<Integer, k0> a = new ConcurrentHashMap<>();

    public static k0 a(final int i2) {
        return a.computeIfAbsent(Integer.valueOf(i2), new Function() { // from class: n.a.a.o.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return l0.b(i2, (Integer) obj);
            }
        });
    }

    static /* synthetic */ k0 b(int i2, Integer num) {
        return new k0(i2);
    }
}
