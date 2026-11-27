package i.b.ha.a.b.e.c;

import java.io.IOException;

/* loaded from: classes.dex */
final class g extends d {
    private g() {
        super();
    }

    @Override // i.b.ha.a.b.e.c.d
    int a() {
        return 0;
    }

    @Override // i.b.ha.a.b.e.c.d
    boolean b() {
        return false;
    }

    @Override // i.b.ha.a.b.e.c.d
    int c(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        throw new IllegalStateException("Cannot read in this state");
    }

    @Override // i.b.ha.a.b.e.c.d
    j d() {
        return j.INITIAL;
    }
}
