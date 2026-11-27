package i.b.ha.a.c.h.b;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class a {
    private static final MathContext a;
    private static final BigDecimal b;
    private static final long c;
    private static final BigDecimal d;
    static final long e;
    private static final BigDecimal f;

    static {
        BigDecimal.valueOf(Long.MIN_VALUE);
        BigDecimal.valueOf(Long.MAX_VALUE);
        a = new MathContext(0, RoundingMode.FLOOR);
        FileTime.from(Instant.EPOCH);
        b = BigDecimal.valueOf(-116444736000000000L);
        long nanos = TimeUnit.SECONDS.toNanos(1L) / 100;
        c = nanos;
        d = BigDecimal.valueOf(nanos);
        long nanos2 = TimeUnit.MILLISECONDS.toNanos(1L) / 100;
        e = nanos2;
        BigDecimal.valueOf(nanos2);
        f = BigDecimal.valueOf(100L);
    }

    public static FileTime a(long j2) {
        return FileTime.from(j2, TimeUnit.SECONDS);
    }

    public static boolean b(long j2) {
        return -2147483648L <= j2 && j2 <= 2147483647L;
    }

    public static boolean c(FileTime fileTime) {
        return b(i(fileTime));
    }

    public static FileTime d(long j2) {
        return FileTime.from(e(j2));
    }

    static Instant e(long j2) {
        return f(BigDecimal.valueOf(j2));
    }

    static Instant f(BigDecimal bigDecimal) {
        BigDecimal[] bigDecimalArrDivideAndRemainder = bigDecimal.add(b).divideAndRemainder(d, a);
        return Instant.ofEpochSecond(bigDecimalArrDivideAndRemainder[0].longValueExact(), bigDecimalArrDivideAndRemainder[1].multiply(f).longValueExact());
    }

    public static long g(FileTime fileTime) {
        return h(fileTime.toInstant());
    }

    static long h(Instant instant) {
        return BigDecimal.valueOf(instant.getEpochSecond()).multiply(d).add(BigDecimal.valueOf(instant.getNano() / 100)).subtract(b).longValueExact();
    }

    public static long i(FileTime fileTime) {
        if (fileTime != null) {
            return fileTime.to(TimeUnit.SECONDS);
        }
        return 0L;
    }
}
