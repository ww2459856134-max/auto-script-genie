package i.b.ha.a.b.d.c;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* loaded from: classes.dex */
public enum k2 {
    STORED(0),
    UNSHRINKING(1),
    EXPANDING_LEVEL_1(2),
    EXPANDING_LEVEL_2(3),
    EXPANDING_LEVEL_3(4),
    EXPANDING_LEVEL_4(5),
    IMPLODING(6),
    TOKENIZATION(7),
    DEFLATED(8),
    ENHANCED_DEFLATED(9),
    PKWARE_IMPLODING(10),
    BZIP2(12),
    LZMA(14),
    ZSTD_DEPRECATED(20),
    ZSTD(93),
    XZ(95),
    JPEG(96),
    WAVPACK(97),
    PPMD(98),
    AES_ENCRYPTED(99),
    UNKNOWN;

    private static final Map<Integer, k2> U = Collections.unmodifiableMap((Map) Stream.of((Object[]) values()).collect(Collectors.toMap(new Function() { // from class: i.b.ha.a.b.d.c.e
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return Integer.valueOf(((k2) obj).b());
        }
    }, Function.identity())));
    private final int c;

    k2() {
        this(-1);
    }

    public static k2 c(int i2) {
        return U.get(Integer.valueOf(i2));
    }

    static boolean d(int i2) {
        return i2 == ZSTD.b() || i2 == ZSTD_DEPRECATED.b();
    }

    public int b() {
        return this.c;
    }

    k2(int i2) {
        this.c = i2;
    }
}
