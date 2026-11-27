package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
class b2 extends f0 {
    final /* synthetic */ Inflater e;
    final /* synthetic */ i2 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b2(i2 i2Var, InputStream inputStream, Inflater inflater, Inflater inflater2) {
        super(inputStream, inflater);
        this.f = i2Var;
        this.e = inflater2;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            this.e.end();
        }
    }
}
