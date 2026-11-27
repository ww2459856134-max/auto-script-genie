package i.b.ha.a.c.k;

import java.io.OutputStream;

/* loaded from: classes.dex */
public class f extends g {
    private long c;

    public f(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // i.b.ha.a.c.k.g
    protected synchronized void c(int i2) {
        this.c += i2;
    }

    public synchronized long f() {
        return this.c;
    }
}
