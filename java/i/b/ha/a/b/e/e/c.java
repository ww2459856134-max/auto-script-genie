package i.b.ha.a.b.e.e;

import i.b.ha.a.b.f.h;
import i.b.ha.a.c.j.d;
import i.b.ha.a.c.j.e;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZInputStream;

/* loaded from: classes.dex */
public class c extends i.b.ha.a.b.e.a implements h {
    private final e d;
    private final InputStream e;

    public static b j() {
        return new b();
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        return this.d.m();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.e.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int i2 = this.e.read();
            int i3 = -1;
            if (i2 != -1) {
                i3 = 1;
            }
            d(i3);
            return i2;
        } catch (MemoryLimitException e) {
            throw new i.b.ha.a.b.c(e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        try {
            return i.b.ha.a.c.e.p(this.e, j2);
        } catch (MemoryLimitException e) {
            throw new i.b.ha.a.b.c(e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private c(b bVar) throws IOException {
        e eVar = ((d) e.j().h(bVar.l())).get();
        this.d = eVar;
        if (bVar.f1472j) {
            this.e = new XZInputStream(eVar, bVar.f1471i);
        } else {
            this.e = new SingleXZInputStream(eVar, bVar.f1471i);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        try {
            int i4 = this.e.read(bArr, i2, i3);
            d(i4);
            return i4;
        } catch (MemoryLimitException e) {
            throw new i.b.ha.a.b.c(e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(InputStream inputStream) throws IOException {
        this((b) j().h(inputStream));
    }
}
