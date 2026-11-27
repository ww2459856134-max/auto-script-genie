package i.i.a;

/* loaded from: classes.dex */
public class g extends a {
    protected transient int a;
    protected transient long b;
    protected transient int c;
    protected transient long d;
    protected transient long e;
    protected transient int f;
    protected transient int g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ h f1732h;

    protected g(h hVar) {
        this.f1732h = hVar;
    }

    private void g(int i2, long j2) {
        this.f++;
        this.e ^= (i2 + 1) * j2;
        if (this.a < 0) {
            this.a = i2;
            this.b = j2;
        }
        this.c = i2;
        this.d = j2;
        this.g += Long.bitCount(j2);
    }

    @Override // i.i.a.a
    protected boolean a(int i2, int i3, int i4, long[] jArr, long[] jArr2) {
        boolean z = true;
        for (int i5 = 0; i5 != i4; i5++) {
            long j2 = jArr[i5];
            if (j2 != 0) {
                g(i2 + i5, j2);
                z = false;
            }
        }
        return z;
    }

    @Override // i.i.a.a
    protected void b(int i2, int i3) {
        b bVar = this.f1732h.f;
        bVar.f = i2;
        bVar.g = i3;
        bVar.e = this.f;
        bVar.c = this.g;
        bVar.d = ((this.c + 1) * 64) - Long.numberOfLeadingZeros(this.d);
        b bVar2 = this.f1732h.f;
        bVar2.b = (bVar2.d - (this.a * 64)) - Long.numberOfTrailingZeros(this.b);
        b bVar3 = this.f1732h.f;
        long j2 = this.e;
        bVar3.a = (int) (j2 ^ (j2 >> 32));
    }

    @Override // i.i.a.a
    protected int d() {
        return 3;
    }

    @Override // i.i.a.a
    protected boolean e(h hVar) {
        this.e = 1234L;
        this.a = -1;
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.f = 0;
        this.g = 0;
        return false;
    }

    @Override // i.i.a.a
    protected boolean f(int i2, int i3, long[] jArr, long[] jArr2, long j2) {
        long j3 = jArr[i3];
        long j4 = j3 & j2;
        if (j4 != 0) {
            g(i2 + i3, j4);
        }
        return j3 == 0;
    }
}
