package i.b.ha.a.b.d.c;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes.dex */
public abstract class z1 {
    static final y1 a = b(StandardCharsets.UTF_8);

    public static y1 a(String str) {
        return new h0(f(str));
    }

    public static y1 b(Charset charset) {
        return new h0(i.b.ha.a.c.c.c(charset));
    }

    static ByteBuffer c(ByteBuffer byteBuffer, int i2) {
        byteBuffer.limit(byteBuffer.position());
        byteBuffer.rewind();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity() + i2);
        byteBufferAllocate.put(byteBuffer);
        return byteBufferAllocate;
    }

    static boolean d(Charset charset) {
        return e(i.b.ha.a.c.c.c(charset).name());
    }

    private static boolean e(final String str) {
        if (!StandardCharsets.UTF_8.name().equalsIgnoreCase(str)) {
            Stream<String> stream = StandardCharsets.UTF_8.aliases().stream();
            Objects.requireNonNull(str);
            if (!stream.anyMatch(new Predicate() { // from class: i.b.ha.a.b.d.c.q
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return str.equalsIgnoreCase((String) obj);
                }
            })) {
                return false;
            }
        }
        return true;
    }

    private static Charset f(String str) {
        try {
            return i.b.ha.a.c.c.a(str);
        } catch (IllegalArgumentException | NullPointerException unused) {
            return Charset.defaultCharset();
        }
    }
}
