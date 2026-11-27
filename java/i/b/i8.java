package i.b;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToLongFunction;

/* loaded from: classes.dex */
public abstract class i8 {
    public static void a(List<File> list, int i2) {
        Comparator comparatorComparingLong;
        if (i2 == 1) {
            comparatorComparingLong = Comparator.comparingLong(new ToLongFunction() { // from class: i.b.v6
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((File) obj).length();
                }
            });
        } else if (i2 == 2) {
            comparatorComparingLong = Comparator.comparing(new Function() { // from class: i.b.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((File) obj).getName();
                }
            });
        } else if (i2 != 3) {
            return;
        } else {
            comparatorComparingLong = Comparator.comparingLong(new ToLongFunction() { // from class: i.b.t2
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((File) obj).lastModified();
                }
            });
        }
        list.sort(comparatorComparingLong.thenComparing(new Function() { // from class: i.b.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((File) obj).getName();
            }
        }));
    }
}
