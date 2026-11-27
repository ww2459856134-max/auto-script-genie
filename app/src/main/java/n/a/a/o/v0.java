package n.a.a.o;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/* loaded from: classes.dex */
public abstract class v0 {
    public static Supplier<u0> a(final Supplier<Number> supplier, k0[] k0VarArr, final String[] strArr) {
        final int[] array = Arrays.stream(k0VarArr).mapToInt(new ToIntFunction() { // from class: n.a.a.o.a
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((k0) obj).b();
            }
        }).toArray();
        return new Supplier() { // from class: n.a.a.o.n
            @Override // java.util.function.Supplier
            public final Object get() {
                return v0.j(supplier, array, strArr);
            }
        };
    }

    public static Supplier<u0> b(final Supplier<Number> supplier, final int[] iArr, final String[] strArr) {
        return new Supplier() { // from class: n.a.a.o.l
            @Override // java.util.function.Supplier
            public final Object get() {
                return v0.k(supplier, iArr, strArr);
            }
        };
    }

    public static Map<String, Supplier<?>> c(String str, Supplier<?> supplier) {
        return Collections.singletonMap(str, supplier);
    }

    public static Map<String, Supplier<?>> d(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2) {
        return i(str, supplier, str2, supplier2, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> e(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3) {
        return i(str, supplier, str2, supplier2, str3, supplier3, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> f(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4) {
        return i(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> g(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5) {
        return i(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, str5, supplier5, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> h(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5, String str6, Supplier<?> supplier6) {
        return i(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, str5, supplier5, str6, supplier6, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> i(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5, String str6, Supplier<?> supplier6, String str7, Supplier<?> supplier7, String str8, Supplier<?> supplier8, String str9, Supplier<?> supplier9) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] strArr = {str, str2, str3, str4, str5, str6, str7, str8, str9};
        Supplier[] supplierArr = {supplier, supplier2, supplier3, supplier4, supplier5, supplier6, supplier7, supplier8, supplier9};
        for (int i2 = 0; i2 < 9 && strArr[i2] != null; i2++) {
            if ("base".equals(strArr[i2])) {
                linkedHashMap.putAll((Map) supplierArr[i2].get());
            } else {
                linkedHashMap.put(strArr[i2], supplierArr[i2]);
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static /* synthetic */ u0 j(Supplier supplier, int[] iArr, String[] strArr) {
        return new u0(supplier, iArr, strArr, false);
    }

    static /* synthetic */ u0 k(Supplier supplier, int[] iArr, String[] strArr) {
        return new u0(supplier, iArr, strArr, true);
    }
}
