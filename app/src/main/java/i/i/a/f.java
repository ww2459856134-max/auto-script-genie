package i.i.a;

/* loaded from: classes.dex */
public class f extends a {
    protected f() {
    }

    @Override // i.i.a.a
    protected boolean a(int i2, int i3, int i4, long[] jArr, long[] jArr2) {
        while (i3 != i4) {
            jArr[i3] = -1;
            i3++;
        }
        return false;
    }

    @Override // i.i.a.a
    protected int d() {
        return 0;
    }

    @Override // i.i.a.a
    protected boolean e(h hVar) {
        return true;
    }

    @Override // i.i.a.a
    protected boolean f(int i2, int i3, long[] jArr, long[] jArr2, long j2) {
        jArr[i3] = jArr[i3] | j2;
        return false;
    }
}
