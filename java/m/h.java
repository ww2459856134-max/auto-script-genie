package m;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes.dex */
final class h implements c {
    public final a c = new a();
    public final l d;
    boolean e;

    h(l lVar) {
        Objects.requireNonNull(lVar, "source == null");
        this.d = lVar;
    }

    @Override // m.l
    public long C(a aVar, long j2) throws IOException {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        a aVar2 = this.c;
        if (aVar2.d == 0 && this.d.C(aVar2, 8192L) == -1) {
            return -1L;
        }
        return this.c.C(aVar, Math.min(j2, this.c.d));
    }

    @Override // m.c
    public int E(g gVar) throws IOException {
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        do {
            int iZ = this.c.z(gVar, true);
            if (iZ == -1) {
                return -1;
            }
            if (iZ != -2) {
                this.c.B(gVar.c[iZ].size());
                return iZ;
            }
        } while (this.d.C(this.c, 8192L) != -1);
        return -1;
    }

    public long a(d dVar, long j2) throws IOException {
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jI = this.c.i(dVar, j2);
            if (jI != -1) {
                return jI;
            }
            a aVar = this.c;
            long j3 = aVar.d;
            if (this.d.C(aVar, 8192L) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (j3 - dVar.size()) + 1);
        }
    }

    @Override // m.c
    public long b(d dVar) throws IOException {
        return a(dVar, 0L);
    }

    public long c(d dVar, long j2) throws IOException {
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long j3 = this.c.j(dVar, j2);
            if (j3 != -1) {
                return j3;
            }
            a aVar = this.c;
            long j4 = aVar.d;
            if (this.d.C(aVar, 8192L) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, j4);
        }
    }

    @Override // m.l, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.e) {
            return;
        }
        this.e = true;
        this.d.close();
        this.c.a();
    }

    @Override // m.c
    public long e(d dVar) throws IOException {
        return c(dVar, 0L);
    }

    @Override // m.c
    public boolean h(long j2) throws IOException {
        a aVar;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        do {
            aVar = this.c;
            if (aVar.d >= j2) {
                return true;
            }
        } while (this.d.C(aVar, 8192L) != -1);
        return false;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.e;
    }

    @Override // m.c
    public a r() {
        return this.c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        a aVar = this.c;
        if (aVar.d == 0 && this.d.C(aVar, 8192L) == -1) {
            return -1;
        }
        return this.c.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.d + ")";
    }
}
