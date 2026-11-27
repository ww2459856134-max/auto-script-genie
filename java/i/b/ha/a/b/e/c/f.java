package i.b.ha.a.b.e.c;

import java.io.IOException;

/* loaded from: classes.dex */
final class f extends d {
    private boolean a;
    private final j b;
    private final c c;
    private final c d;
    private int e;
    private byte[] f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ i f1462h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(i iVar, j jVar, int[] iArr, int[] iArr2) {
        super();
        this.f1462h = iVar;
        this.f = i.b.ha.a.b.f.e.a;
        this.b = jVar;
        this.c = i.o(iArr);
        this.d = i.o(iArr2);
    }

    private int e(byte[] bArr, int i2, int i3) {
        int i4 = this.g - this.e;
        if (i4 <= 0) {
            return 0;
        }
        int iMin = Math.min(i3, i4);
        System.arraycopy(this.f, this.e, bArr, i2, iMin);
        this.e += iMin;
        return iMin;
    }

    private int f(byte[] bArr, int i2, int i3) throws IOException {
        if (this.a) {
            return -1;
        }
        int iE = e(bArr, i2, i3);
        while (true) {
            if (iE < i3) {
                int iU = i.u(this.f1462h.e, this.c);
                if (iU >= 256) {
                    if (iU <= 256) {
                        this.a = true;
                        break;
                    }
                    short s = i.f1463h[iU - 257];
                    int iA = i.b.ha.a.b.f.f.a(s >>> 5, this.f1462h.x(s & 31));
                    int i4 = i.f1464i[i.u(this.f1462h.e, this.d)];
                    int iA2 = i.b.ha.a.b.f.f.a(i4 >>> 4, this.f1462h.x(i4 & 15));
                    if (this.f.length < iA) {
                        this.f = new byte[iA];
                    }
                    this.g = iA;
                    this.e = 0;
                    this.f1462h.g.d(iA2, iA, this.f);
                    iE += e(bArr, i2 + iE, i3 - iE);
                } else {
                    byte b = (byte) iU;
                    this.f1462h.g.a(b);
                    bArr[iE + i2] = b;
                    iE++;
                }
            } else {
                break;
            }
        }
        return iE;
    }

    @Override // i.b.ha.a.b.e.c.d
    int a() {
        return this.g - this.e;
    }

    @Override // i.b.ha.a.b.e.c.d
    boolean b() {
        return !this.a;
    }

    @Override // i.b.ha.a.b.e.c.d
    int c(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        return f(bArr, i2, i3);
    }

    @Override // i.b.ha.a.b.e.c.d
    j d() {
        return this.a ? j.INITIAL : this.b;
    }
}
