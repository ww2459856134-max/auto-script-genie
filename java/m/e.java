package m;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class e implements l {
    final /* synthetic */ m c;
    final /* synthetic */ InputStream d;

    e(m mVar, InputStream inputStream) {
        this.c = mVar;
        this.d = inputStream;
    }

    @Override // m.l
    public long C(a aVar, long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        if (j2 == 0) {
            return 0L;
        }
        try {
            this.c.a();
            i iVarG = aVar.G(1);
            int i2 = this.d.read(iVarG.a, iVarG.c, (int) Math.min(j2, 8192 - iVarG.c));
            if (i2 == -1) {
                return -1L;
            }
            iVarG.c += i2;
            long j3 = i2;
            aVar.d += j3;
            return j3;
        } catch (AssertionError e) {
            if (f.b(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // m.l, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.d.close();
    }

    public String toString() {
        return "source(" + this.d + ")";
    }
}
