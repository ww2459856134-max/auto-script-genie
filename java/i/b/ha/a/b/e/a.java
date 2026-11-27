package i.b.ha.a.b.e;

import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class a extends InputStream {
    private long c;

    public long c() {
        return i();
    }

    protected void d(int i2) {
        f(i2);
    }

    protected void f(long j2) {
        if (j2 != -1) {
            this.c += j2;
        }
    }

    public long i() {
        return this.c;
    }
}
