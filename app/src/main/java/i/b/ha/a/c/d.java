package i.b.ha.a.c;

import java.util.Arrays;
import java.util.function.Supplier;

/* loaded from: classes.dex */
final class d implements AutoCloseable {
    private static final ThreadLocal<Object[]> d = ThreadLocal.withInitial(new Supplier() { // from class: i.b.ha.a.c.b
        @Override // java.util.function.Supplier
        public final Object get() {
            return d.d();
        }
    });
    private static final d e = new d(null);
    private final byte[] c;

    private d(byte[] bArr) {
        this.c = bArr;
    }

    static d c() {
        Object[] objArr = d.get();
        if (((Boolean) objArr[0]).booleanValue()) {
            return new d(e.a());
        }
        objArr[0] = Boolean.TRUE;
        return e;
    }

    static /* synthetic */ Object[] d() {
        return new Object[]{Boolean.FALSE, e.a()};
    }

    byte[] a() {
        byte[] bArr = this.c;
        return bArr != null ? bArr : (byte[]) d.get()[1];
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.c == null) {
            Object[] objArr = d.get();
            Arrays.fill((byte[]) objArr[1], (byte) 0);
            objArr[0] = Boolean.FALSE;
        }
    }
}
