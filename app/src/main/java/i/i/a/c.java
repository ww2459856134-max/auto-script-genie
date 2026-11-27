package i.i.a;

/* loaded from: classes.dex */
public class c extends a {
    protected c() {
    }

    @Override // i.i.a.a
    protected boolean a(int i2, int i3, int i4, long[] jArr, long[] jArr2) {
        boolean z = true;
        while (i3 != i4) {
            long j2 = jArr2[i3];
            jArr[i3] = j2;
            z &= j2 == 0;
            i3++;
        }
        return z;
    }

    @Override // i.i.a.a
    protected int d() {
        return 5;
    }

    @Override // i.i.a.a
    protected boolean e(h hVar) {
        return true;
    }

    @Override // i.i.a.a
    protected boolean f(int i2, int i3, long[] jArr, long[] jArr2, long j2) {
        long j3 = jArr2[i3] & j2;
        jArr[i3] = j3;
        return j3 == 0;
    }
}
