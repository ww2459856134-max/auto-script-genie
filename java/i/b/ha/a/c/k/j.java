package i.b.ha.a.c.k;

import i.b.ha.a.c.i.p;
import i.b.ha.a.c.i.q;
import i.b.ha.a.c.j.k;
import i.b.ha.a.c.j.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class j extends e<j> {

    public static class a extends i.b.ha.a.c.g.f<j, a> {
        @Override // i.b.ha.a.c.i.p
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public j get() {
            return new j(this);
        }
    }

    public static a p() {
        return new a();
    }

    static /* synthetic */ l q(byte[] bArr, int i2, int i3) throws IOException {
        k kVarW = l.a().w(bArr);
        kVarW.y(i2);
        kVarW.x(i3);
        return kVarW.get();
    }

    static /* synthetic */ l s(final byte[] bArr, final int i2, final int i3) {
        return (l) q.a(new p() { // from class: i.b.ha.a.c.k.a
            @Override // i.b.ha.a.c.i.p
            public final Object get() {
                return j.q(bArr, i2, i3);
            }
        });
    }

    @Override // i.b.ha.a.c.k.e
    public byte[] d() {
        return f();
    }

    public void u() {
        c();
    }

    public int w() {
        return this.d;
    }

    @Override // i.b.ha.a.c.k.e, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        i.b.ha.a.c.e.d(bArr, i2, i3);
        if (i3 == 0) {
            return;
        }
        n(bArr, i2, i3);
    }

    public InputStream x() {
        return i(new d() { // from class: i.b.ha.a.c.k.b
            @Override // i.b.ha.a.c.k.d
            public final InputStream a(byte[] bArr, int i2, int i3) {
                return j.s(bArr, i2, i3);
            }
        });
    }

    public int y(InputStream inputStream) throws IOException {
        return j(inputStream);
    }

    public void z(OutputStream outputStream) throws IOException {
        o(outputStream);
    }

    private j(a aVar) {
        this(aVar.k());
    }

    @Deprecated
    public j(int i2) {
        if (i2 >= 0) {
            a(i2);
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i2);
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        m(i2);
    }
}
