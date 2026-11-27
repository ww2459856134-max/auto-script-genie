package i.b.ha.a.b.e.c;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
final class h extends d {
    private final long a;
    private long b;
    final /* synthetic */ i c;

    @Override // i.b.ha.a.b.e.c.d
    int a() throws IOException {
        return (int) Math.min(this.a - this.b, this.c.e.c() / 8);
    }

    @Override // i.b.ha.a.b.e.c.d
    boolean b() {
        return this.b < this.a;
    }

    @Override // i.b.ha.a.b.e.c.d
    int c(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = 0;
        if (i3 == 0) {
            return 0;
        }
        int iMin = (int) Math.min(this.a - this.b, i3);
        while (i5 < iMin) {
            if (this.c.e.d() > 0) {
                byte bX = (byte) this.c.x(8);
                this.c.g.a(bX);
                bArr[i2 + i5] = bX;
                i4 = 1;
            } else {
                int i6 = i2 + i5;
                i4 = this.c.f.read(bArr, i6, iMin - i5);
                if (i4 == -1) {
                    throw new EOFException("Truncated Deflate64 Stream");
                }
                this.c.g.b(bArr, i6, i4);
            }
            this.b += i4;
            i5 += i4;
        }
        return iMin;
    }

    @Override // i.b.ha.a.b.e.c.d
    j d() {
        return this.b < this.a ? j.STORED : j.INITIAL;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private h(i iVar, long j2) {
        super();
        this.c = iVar;
        this.a = j2;
    }
}
