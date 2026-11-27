package n.a.a.l.c;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class s implements Iterable<ByteBuffer> {
    private final e c;
    private int d;
    private OutputStream e;

    private class b implements Iterator<ByteBuffer> {
        private final d c;
        private int d;

        b(int i2) {
            this.d = i2;
            try {
                this.c = s.this.c.f();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ByteBuffer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Can't read past the end of the stream");
            }
            try {
                this.c.a(this.d);
                ByteBuffer byteBufferC = s.this.c.c(this.d);
                this.d = s.this.c.j(this.d);
                return byteBufferC;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d != -2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class c implements Iterator<Integer> {
        private final d c;
        private int d;

        c(int i2) {
            this.d = i2;
            try {
                this.c = s.this.c.f();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Can't read past the end of the stream");
            }
            this.c.a(this.d);
            int i2 = this.d;
            this.d = s.this.c.j(this.d);
            return Integer.valueOf(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d != -2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public s(e eVar, int i2) {
        this.c = eVar;
        this.d = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(d dVar) {
        int i2 = this.d;
        while (i2 != -2) {
            dVar.a(i2);
            int iJ = this.c.j(i2);
            this.c.n(i2, -1);
            i2 = iJ;
        }
        this.d = -2;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return j();
    }

    Iterator<ByteBuffer> j() {
        int i2 = this.d;
        if (i2 != -2) {
            return new b(i2);
        }
        throw new IllegalStateException("Can't read from a new stream before it has been written to");
    }

    Iterator<Integer> k() {
        int i2 = this.d;
        if (i2 != -2) {
            return new c(i2);
        }
        throw new IllegalStateException("Can't read from a new stream before it has been written to");
    }

    public OutputStream l() throws IOException {
        if (this.e == null) {
            this.e = new a();
        }
        return this.e;
    }

    public int p() {
        return this.d;
    }

    protected class a extends OutputStream {
        ByteBuffer d;
        d e;
        int g;
        byte[] c = new byte[1];
        int f = -2;

        a() throws IOException {
            this.e = s.this.c.f();
            this.g = s.this.d;
        }

        void a() throws IOException {
            ByteBuffer byteBuffer = this.d;
            if (byteBuffer == null || !byteBuffer.hasRemaining()) {
                int i2 = this.g;
                if (i2 == -2) {
                    i2 = s.this.c.i();
                    this.e.a(i2);
                    this.g = -2;
                    if (this.f != -2) {
                        s.this.c.n(this.f, i2);
                    }
                    s.this.c.n(i2, -2);
                    if (s.this.d == -2) {
                        s.this.d = i2;
                    }
                } else {
                    this.e.a(i2);
                    this.g = s.this.c.j(i2);
                }
                if (this.d != null) {
                    s.this.c.m(this.d);
                }
                this.d = s.this.c.a(i2);
                this.f = i2;
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            new s(s.this.c, this.g).h(this.e);
            if (this.f != -2) {
                s.this.c.n(this.f, -2);
            }
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            byte[] bArr = this.c;
            bArr[0] = (byte) (i2 & 255);
            write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            int i4;
            if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return;
            }
            do {
                a();
                int iMin = Math.min(this.d.remaining(), i3);
                this.d.put(bArr, i2, iMin);
                i2 += iMin;
                i3 -= iMin;
            } while (i3 > 0);
        }
    }

    public s(e eVar) {
        this.c = eVar;
        this.d = -2;
    }
}
