package i.b.ha.a.c.g;

import i.b.ha.a.c.g.f;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.util.function.IntUnaryOperator;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class f<T, B extends f<T, B>> extends e<T, B> {

    /* renamed from: h, reason: collision with root package name */
    private static final OpenOption[] f1473h = i.b.ha.a.c.h.a.a;
    private int b = XMLEvent.ENTITY_REFERENCE;
    private int c = XMLEvent.ENTITY_REFERENCE;
    private int d = Integer.MAX_VALUE;
    private OpenOption[] e;
    private final IntUnaryOperator f;
    private IntUnaryOperator g;

    public f() {
        Charset.defaultCharset();
        Charset.defaultCharset();
        this.e = f1473h;
        IntUnaryOperator intUnaryOperator = new IntUnaryOperator() { // from class: i.b.ha.a.c.g.a
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i2) {
                this.a.o(i2);
                return i2;
            }
        };
        this.f = intUnaryOperator;
        this.g = intUnaryOperator;
    }

    private int j(int i2) {
        return this.g.applyAsInt(i2);
    }

    private /* synthetic */ int n(int i2) {
        int i3 = this.d;
        if (i2 <= i3) {
            return i2;
        }
        q(i2, i3);
        throw null;
    }

    private int q(int i2, int i3) {
        throw new IllegalArgumentException(String.format("Request %,d exceeds maximum %,d", Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    public int k() {
        return this.b;
    }

    public InputStream l() throws IOException {
        return d().e(m());
    }

    public OpenOption[] m() {
        return this.e;
    }

    public /* synthetic */ int o(int i2) {
        n(i2);
        return i2;
    }

    public B p(int i2) {
        if (i2 <= 0) {
            i2 = this.c;
        }
        this.b = j(i2);
        c();
        return this;
    }
}
