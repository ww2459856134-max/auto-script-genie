package n.a.a.o;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* loaded from: classes.dex */
public class u0 {
    private final Supplier<Number> a;
    private final Map<Integer, String> b = new LinkedHashMap();
    private final boolean c;

    u0(Supplier<Number> supplier, int[] iArr, String[] strArr, boolean z) {
        this.a = supplier;
        this.c = z;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.b.put(Integer.valueOf(iArr[i2]), strArr[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean d(int i2, Map.Entry entry) {
        return e(i2, ((Integer) entry.getKey()).intValue());
    }

    private boolean e(int i2, int i3) {
        if (this.c) {
            if (i2 == i3) {
                return true;
            }
        } else if ((i2 & i3) == i3) {
            return true;
        }
        return false;
    }

    public String a() {
        final int iIntValue = this.a.get().intValue();
        return (String) this.b.entrySet().stream().filter(new Predicate() { // from class: n.a.a.o.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.d(iIntValue, (Map.Entry) obj);
            }
        }).map(new Function() { // from class: n.a.a.o.f0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getValue();
            }
        }).collect(Collectors.joining(" | "));
    }

    public Supplier<Number> b() {
        return this.a;
    }
}
